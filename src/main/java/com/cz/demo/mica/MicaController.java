package com.cz.demo.mica;

import com.cz.demo.mica.result.Member;
import com.cz.demo.mica.result.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created 2019-08-16.
 * 远程调用mica接口
 * @author changzheng
 */
@RestController
@PropertySource(value = "classpath:config.properties")
public class MicaController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    HttpHeaders httpHeaders;

    @Value("${mica.url}")
    private String url;

    /**
     * 获取全部成员
     *.
     * @return List<Member>
     */
    @RequestMapping("/members")
    public List<Member> getAllMember() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<List<Member>> responseEntity = restTemplate.exchange(url+"/api/v1/members", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Member>>() {
        });
        return responseEntity.getBody();
    }

    /**
     * 删除域名信息
     * @param qname qname
     * @return String
     */
    @RequestMapping("/delete")
    public String deleteInfo(@RequestParam("qname") String qname) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url+"/api/v1/service?qname="+qname, HttpMethod.DELETE, entity, String.class, qname);
        return responseEntity.getBody();

    }

    /**
     * 根据qname查询service
     * @param qname qname
     * @return Service
     */
    @RequestMapping("/query")
    public Service queryByQname(@RequestParam("qname") String qname) throws IOException {
        String json = restTemplate.getForObject(url+"/api/v1/service?qname={qname}", String.class, qname);
        Map<String, Service> map = mapper.readValue(json, new TypeReference<Map<String, Service>>() {
        });
        return map.get(qname);

    }

    /**
     * 新建service
     * @param qname qname
     * @param host 主机
     * @param port 端口号
     *
     * @return Object
     */    @RequestMapping("/new")
    public Object newService(@RequestParam("qname")String qname,@RequestParam("host") String host,@RequestParam("port") Integer port,@RequestParam("priority")Integer priority,@RequestParam("ttl")Integer ttl,@RequestParam("weight")Integer weight) throws JsonProcessingException {
        Service service = new Service();
        service.setHost(host);
        service.setPort(port);
        service.setPriority(priority);
        service.setTtl(ttl);
        service.setWeight(weight);
        Map<String, Object> jsonMap = new HashMap<>(10);
        jsonMap.put("qname", qname);
        jsonMap.put("service", service);
        String json = mapper.writeValueAsString(jsonMap);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url+"/api/v1/service", entity, Object.class);
        return responseEntity.getBody();

    }

    /**
     * 获取全量service
     *
     * @return Map
     */    @RequestMapping("/allService")
    public Map<String,Service> getAllService() throws IOException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url+"/api/v1/services", String.class);
        return mapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, Service>>() {});

    }

}