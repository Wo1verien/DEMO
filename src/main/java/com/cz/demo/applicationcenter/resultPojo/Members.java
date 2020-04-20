package com.cz.demo.applicationcenter.resultPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created 2019-09-05.
 *
 * @author changzheng
 */
@Data
public class Members {
    @JsonProperty("name")
    private String name;
    @JsonProperty("mfwUid")
    private Integer mfwUid;
    @JsonProperty("wxUid")
    private String wxUid;
    @JsonProperty("email")
    private String email;
    @JsonProperty("department")
    private String department;
    @JsonProperty("isLeave")
    private boolean isLeave;
    @JsonProperty("id")
    private String id;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("qywx_avatar")
    private String qywxAvatar;
}
