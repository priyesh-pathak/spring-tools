package com.example.tools.configs;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Mapper {
    @Bean
    public ModelMapper getModelMap() {
        return new ModelMapper();
    }
}
