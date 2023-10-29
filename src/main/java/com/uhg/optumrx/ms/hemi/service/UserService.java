package com.uhg.optumrx.ms.hemi.service;

import java.beans.Beans;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhg.optumrx.ms.hemi.bo.UsersDTO;
import com.uhg.optumrx.ms.hemi.entity.UsersBo;
import com.uhg.optumrx.ms.hemi.repo.UserRepository;
import com.uhg.optumrx.ms.hemi.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private JsonUtil jsonUtil;
	
	private UserRepository repoService;
	
	
	
	public void filterListenerData(String msg){
		
		if(msg==null || msg.length() <=0) return;
		try {
			System.out.println("Got data is : "+msg);
			UsersDTO userDTO = (UsersDTO) jsonUtil.fromJson(msg,UsersDTO.class);
			if(userDTO.getUserId() ==null || userDTO.getUserId().length()<=0) {
				log.info("In user data userId is not avaliable so discarding the packet");
				return;
			}
			UsersBo entityBo = new UsersBo();
			
			BeanUtils.copyProperties(userDTO, entityBo);
			
			repoService.save(entityBo);
			
			
		}catch(Exception e) {
			log.error("json Conversion error"+e.getMessage());
		}
	
	}
	
}
