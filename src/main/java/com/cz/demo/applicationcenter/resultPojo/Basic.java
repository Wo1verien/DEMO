package com.cz.demo.applicationcenter.resultPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created 2019-09-05.
 *
 * @author changzheng
 */
@Data
public class Basic {
    @JsonProperty("appCode")
    private String appCode;
    @JsonProperty("description")
    private String description;
    @JsonProperty("members")
    private Members[] members;
    @JsonProperty("owners")
    private Owners[] owners;
    @JsonProperty("token")
    private String token;
    @JsonProperty("creatTime")
    private String creatTime;
    @JsonProperty("updateTime")
    private String updateTime;
    @JsonProperty("projectCode")
    private String projectCode;
    @JsonProperty("projectTitle")
    private String projecctTitle;

}
