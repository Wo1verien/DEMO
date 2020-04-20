package com.cz.demo.applicationcenter.resultPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created 2019-09-05.
 *
 * @author changzheng
 */
@Data
public class Service {
    @JsonProperty("ports")
    private Ports[] ports;

}
