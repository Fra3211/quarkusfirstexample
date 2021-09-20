package com.example;

import com.example.service.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    ExampleService exampleService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return exampleService.sayHello();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWithName(@QueryParam("name") String name){
        return exampleService.sayHelloWithName(name);
    }
}