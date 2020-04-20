package com.cz.demo.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created 2020/2/5. 11:32 上午
 *
 * @author changzheng
 */
public enum AccessMode {

    /**
     * 服务发现
     */
    DISCOVERY(0,"discovery"),

    /**
     * 域名
     */
    HOST(1, "host");


    private Integer code;


    private String desc;

    AccessMode(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }


    public Integer getCode() {
        return code;
    }


    @JsonValue
    public String getDesc() {
        return desc;
    }


    @JsonCreator
    public static AccessMode forValue(String desc){
        for(AccessMode a : values()){
            if(a.getDesc().equals(desc)){
                return a;
            }
        }
        return null;
    }

    public static AccessMode forCode(Integer code){
        for(AccessMode a : values()){
            if(a.getCode().equals(code)){
                return a;
            }
        }
        return null;
    }

}
