package com.netflix.price.application;

import com.netflix.price.resources.RolloutController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;


@Configuration
@ApplicationPath("/swagger")
public class SwaggerApplication extends ResourceConfig {

public SwaggerApplication() {
    register(RolloutController.class);
    packages("com.netflix.price.resources");
    registerSwagger();
}

private void registerSwagger() {
    register(ApiListingResource.class);
    register(SwaggerSerializers.class);
    BeanConfig config = new BeanConfig();
    config.setConfigId("Sample configuration");
    config.setTitle("Sample API document");
    config.setVersion("v1");
    config.setContact("klakshmanan");
    config.setSchemes(new String[] { "http" });
    config.setBasePath("/swagger");
    config.setResourcePackage("com.netflix.price.resources");
    config.setPrettyPrint(true);
    config.setScan(true);
}
}