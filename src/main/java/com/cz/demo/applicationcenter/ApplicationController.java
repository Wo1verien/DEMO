package com.cz.demo.applicationcenter;

import com.cz.demo.applicationcenter.resultPojo.Members;
import com.cz.demo.applicationcenter.resultPojo.Owners;
import com.cz.demo.applicationcenter.resultPojo.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created 2019-09-05.
 * 从应用中心根据appCode取对应的email
 * @author changzheng
 */
@RestController
@PropertySource(value = "classpath:config.properties")
public class ApplicationController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Value("${application.url}")
    private String url;

    @GetMapping("/getEmail")
    public void getEmail(@RequestParam("code") String code) {


        Results results = restTemplate.getForObject(url + "?appCode=" + code, Results.class);

//        try {
//            ResponseEntity entity = restTemplate.exchange(url+"?appCode="+code,HttpMethod.GET,null,String.class);
//            System.out.println(entity.getHeaders());
//            System.out.println(entity.getBody());
//        } catch (HttpStatusCodeException e){
//            e.getCause();
//            System.out.println(e.toString());
//        }
        Map<String, String> emailMap = new HashMap(10);
        Owners[] owners = results.getBasic().getOwners();
        Members[] members = results.getBasic().getMembers();
        System.out.println(owners[1]);
        System.out.println(members.length);
        for (Owners o : owners) {
            if (!emailMap.containsKey(o.getName())) {
                emailMap.put(o.getName(), o.getEmail());
            }
        }
        for (Members m : members) {
            if (!emailMap.containsKey(m.getName())) {
                emailMap.put(m.getName(), m.getEmail());
            }
        }
    }
//        return emailMap;


}


