package com.example.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "example")
public interface ExampleConfig {

    String name();
}
