package com.ayach.francestation.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.ayach.francesstation.utility.CORSFilter;
import com.ayach.francestation.controller.StationController;
import com.ayach.francestation.exception.GenericExceptionMapper;


@Component
public class JerseyConfiguration extends ResourceConfig{
    public JerseyConfiguration() {
    	register(StationController.class);
    	register(GenericExceptionMapper.class);
    	register(new CORSFilter());
    }
}
