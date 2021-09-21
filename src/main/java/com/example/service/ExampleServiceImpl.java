package com.example.service;

import com.example.config.ExampleConfig;
import com.example.config.ExampleConverterConfig;
import com.example.dto.TestDto;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class ExampleServiceImpl implements ExampleService{

    @Inject
    ExampleConfig exampleConfig;

    @Inject
    ExampleConverterConfig exampleConverterConfig;


    @Override
    public String sayHello() {
        TestDto dto = TestDto.builder()
                .name("HelloName")
                .build();
        log.info("Hello was called");
        return dto.getName();
    }

    @Override
    public String sayHelloWithName(String name) {
        if(StringUtil.isNullOrEmpty(name))
            return String.format("Hello %s", exampleConfig.name());
        return String.format("Hello %s", name);
    }

    @Override
    public Integer toInt() {
        return exampleConverterConfig.encode();
    }
}
