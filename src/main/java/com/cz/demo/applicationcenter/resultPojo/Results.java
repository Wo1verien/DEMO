package com.cz.demo.applicationcenter.resultPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Controller;

/**
 * Created 2019-09-06.
 *
 * @author changzheng
 */
@Data
public class Results {
    @JsonProperty("basic")
    private Basic basic;
    @JsonProperty("code")
    private Code code;
    @JsonProperty("configurations")
    private Configurations configurations;
    @JsonProperty("service")
    private Service service;
}
