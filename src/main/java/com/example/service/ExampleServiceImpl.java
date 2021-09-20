package com.example.service;

import com.example.config.ExampleConfig;
import io.netty.util.internal.StringUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ExampleServiceImpl implements ExampleService{

    @Inject
    ExampleConfig exampleConfig;


    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String sayHelloWithName(String name) {
        if(StringUtil.isNullOrEmpty(name))
            return String.format("Hello %s", exampleConfig.name());
        return String.format("Hello %s", name);
    }
}
