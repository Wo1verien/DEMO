package com.cz.demo.mica;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created 2019-08-19.
 *
 * @author changzheng
 */
@Configuration
public class ObjectMapperConfig {
    @Bean
    @Primary
    public ObjectMapper mapper(){

        return new ObjectMapper();

    }

}
