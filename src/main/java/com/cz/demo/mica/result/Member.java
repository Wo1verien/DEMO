package com.cz.demo.mica.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created 2019-08-16.
 *
 * @author changzheng
 */
@Data
public class Member {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("IP")
    private String ip;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Role")
    private String role;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Tags")
    private Tags tags;


}
