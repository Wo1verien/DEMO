package com.cz.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created 2020/2/5. 11:29 上午
 *
 * @author changzheng
 */
@RestController
public class TestController {

    @GetMapping(value = "/testEnum",produces = {"application/json;charset=utf-8"})
    public void testEnum(@RequestBody TestPO testPO){
        System.out.println(testPO.getAccessMode().getCode());

    }
}
