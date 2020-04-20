package com.cz.demo.mica.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created 2019-08-16.
 *
 * @author changzheng
 */
@Data
public class Tags {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("ROLE")
    private String role;

}
