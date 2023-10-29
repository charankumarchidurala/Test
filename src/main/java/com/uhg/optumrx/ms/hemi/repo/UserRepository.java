package com.uhg.optumrx.ms.hemi.repo;

import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
import com.uhg.optumrx.ms.hemi.entity.UsersBo;

public interface UserRepository extends CosmosRepository<UsersBo, String>{

}
