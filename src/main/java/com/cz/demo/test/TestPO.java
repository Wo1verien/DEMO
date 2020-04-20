package com.cz.demo.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created 2020/2/5. 11:32 上午
 *
 * @author changzheng
 */
@Data
public class TestPO {
    private String name;
    @JsonProperty("access_mode")
    private AccessMode accessMode;
}
