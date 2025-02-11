/**

package com.csm.backend.scm_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.csm.backend.scm_backend.entity.Contact;
import com.csm.backend.scm_backend.entity.User;

@Configuration          //
public class RestConfig {

	
	@Bean
	public RepositoryRestConfigurer  repositoryRestConfigurer() {
		
		
		return new RepositoryRestConfigurer() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
				// TODO Auto-generated method stub
				
				config.setBasePath(AppConstants.REST_BASE_PATH);
				config.setDefaultPageSize(AppConstants.PAGE_SIZE);
				config.setDefaultMediaType(MediaType.APPLICATION_JSON);
				config.exposeIdsFor(User.class, Contact.class);  // its used to create id automatically
							
				}};
		       } 
				
			{
		
	} 
	
}
                  */
