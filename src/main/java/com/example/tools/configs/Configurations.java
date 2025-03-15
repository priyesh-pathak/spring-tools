package com.example.tools.configs;
import com.example.tools.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAud")
public class Configurations {
    @Bean
    public ModelMapper getModelMap() {
        return new ModelMapper();
    }
    @Bean
    AuditorAware<String> getAud(){
        return new AuditorAwareImpl();
    }
}
