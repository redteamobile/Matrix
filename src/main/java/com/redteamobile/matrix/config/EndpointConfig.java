package com.redteamobile.matrix.config;

import com.redteamobile.matrix.interceptor.ValidationInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Jamc on 10/26/16.
 */
@Configuration
public class EndpointConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ValidationInterceptor validationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO config the right uri pattern to do validation
        registry.addInterceptor(validationInterceptor).addPathPatterns("/**");
    }

}
