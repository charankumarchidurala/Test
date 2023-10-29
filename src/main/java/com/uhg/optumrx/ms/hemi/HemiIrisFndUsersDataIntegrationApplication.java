package com.uhg.optumrx.ms.hemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.uhg.optumrx.ms.hemi.repo.UserRepository;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserRepository.class))
public class HemiIrisFndUsersDataIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HemiIrisFndUsersDataIntegrationApplication.class, args);
	}

}
