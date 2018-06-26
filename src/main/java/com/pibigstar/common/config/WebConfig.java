package com.pibigstar.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/**").addResourceLocations("classpath:/statics/");
		//配置server虚拟路径，handler为jsp中访问的目录，locations为files相对应的本地路径     
		registry.addResourceHandler("/files/**").addResourceLocations("file:///D:/upload/");  
	}

}
