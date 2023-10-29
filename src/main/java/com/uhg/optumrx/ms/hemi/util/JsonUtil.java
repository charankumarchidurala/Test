package com.uhg.optumrx.ms.hemi.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

@Component
public class JsonUtil {

	private Gson gson = null;


	@PostConstruct
	public void initGson() {
		gson = new GsonBuilder().create();
		
	}

	public String toJson(Object object) {
		//log.info("In toJson for object : "+ object);
		return gson.toJson(object);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object fromJson(String jsonString, Class class1) {
		return gson.fromJson(jsonString, class1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object fromJsonToList(String jsonString, Class object) {
		List<Object> objList = new ArrayList<Object>();
		try {
			JsonParser parser = new JsonParser();
			List<JsonElement> list = new ArrayList<JsonElement>();
			JsonArray jsonArray = (JsonArray) parser.parse(jsonString).getAsJsonArray();
			;
			if (jsonArray != null) {
				int len = jsonArray.size();
				for (int i = 0; i < len; i++) {
					list.add(jsonArray.get(i));
				}
			}

			if (list != null && list.size() > 0) {
				for (JsonElement jE : list) {
					JsonObject obj = jE.getAsJsonObject();
					Object object1 = gson.fromJson(obj, object);
					objList.add(object1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objList;
	}
	
	public Map<String, String> getValues(String data)
	{
		Map<String, String> valuesMap=new HashMap<>();
		
		try {
			JsonParser parser = new JsonParser();
			JsonObject jsonElement= parser.parse(data).getAsJsonObject();
			
			processJsonObject(jsonElement, valuesMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valuesMap;
	}
	
	public void processJsonObject(JsonObject jsonObject,Map<String, String> valueMap)
	{
		Set<Entry<String, JsonElement>> entry=jsonObject.entrySet();
		
		for (Entry<String, JsonElement> entry2 : entry) {
			String key=entry2.getKey();
			Object valueObject=entry2.getValue();
			String value=null;
			if(valueObject instanceof JsonPrimitive)
				value=((JsonPrimitive) valueObject).getAsString();
			else
				processJsonObject(jsonObject, valueMap);
			valueMap.put(key, value);
		}
	}
	
}
