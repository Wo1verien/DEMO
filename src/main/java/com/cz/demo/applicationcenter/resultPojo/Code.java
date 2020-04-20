package com.cz.demo.applicationcenter.resultPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created 2019-09-05.
 *
 * @author changzheng
 */
@Data
public class Code {
    @JsonProperty("git")
    private String git;
    @JsonProperty("strategy")
    private String strategy;
}
