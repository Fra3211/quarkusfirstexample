package com.example.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithConverter;
import org.eclipse.microprofile.config.spi.Converter;

@ConfigMapping(prefix = "exampleconverter")
public interface ExampleConverterConfig {

    @WithConverter(ToStringConverter.class)
    Integer encode();

    class ToStringConverter implements Converter<Integer> {

        @Override
        public Integer convert(String value) throws IllegalArgumentException, NullPointerException {
            return Integer.parseInt(value);
        }
    }

}
