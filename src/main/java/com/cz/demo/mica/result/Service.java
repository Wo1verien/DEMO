package com.cz.demo.mica.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * Created 2019-08-16.
 *
 * @author changzheng
 */
@Data
public class Service implements Serializable {
    @JsonProperty("host")
    private String host;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("ttl")
    private Integer ttl;
    @JsonProperty("weight")
    private Integer weight;

}
