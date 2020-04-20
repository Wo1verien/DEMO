package com.cz.demo.test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created 2019/11/4. 9:02 下午
 *
 * @author changzheng
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
//        String regex = "(\\w)+!?=?~?\"([-\\w\\\\.:$?*%()]*)\"";
//        String regex = "(\\w)*#=#\"(@[-\\w]*@)\"";
        String regex = "(\\w)+!?=?\"\\$\\{[\\w||\\u4E00-\\u9FA5||()]+}\"";
//        String regex = "(\\w)*[=~!]*\"([-\\w\\\\.:$?*%()]*)\"";
//        String regex = "(\\w)+[=~!]+\"([-\\w\\\\.:$?*%()]*)\"";
//        String regex = "(\\w)+!?=\"\\$\\{appCode}\"";

        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher("sum(idelta(http_server_requests_seconds_count{exception=\"${异常}\",method=\"${请求方法}\",status=\"${返回状态码}\",status=\"${返回状态码}\",outcome!=\"${状态}\",application=\"${appCode}\",container_label_io_kubernetes_pod_name=~\"123056-vinfo-mweng-(.*?)\"}[1m]))");
//        Matcher matcher = pattern.matcher("sum(jvm_memory_used_bytes{area=\"heap\"})by(application,instance,area,job,pod,service)*100/sum(jvm_memory_max_bytes{area=\"heap\"})by(application,instance,area,job,pod,service)");
//        Matcher matcher = pattern.matcher("sum(delta(http_server_requests_seconds_count{action!=\"${区域}\",cause=\"${回收原因}\",instance=\"172.18.18.103:8004\",application=\"${appCode}\"[1m]))");
//        Matcher matcher = pattern.matcher("sum(idelta(http_server_requests_seconds_count{exception=\"${异常}\",method=\"${请求方法}\",status=\"${返回状态码}\",status=\"${返回状态码}\",outcome!=\"${状态}\",application=\"${appCode}\",container_label_io_kubernetes_pod_name=~\"123056-vinfo-mweng-(.*?)\"}[1m]))");
        Matcher matcher = pattern.matcher("ceil(rate(container_cpu_usage_seconds_total{biz_application =\"${应用}\"}[3m]) * 100)".replaceAll(" +",""));

        System.out.println(matcher.matches());
        System.out.println("###");

        while (matcher.find()){
//            System.out.println(matcher.group().replace("=\"@ @\"",""));
            System.out.println(matcher.group());

            if(matcher.group().contains("=~")){
                System.out.println(1);
            }else if(matcher.group().contains("!=")){
                System.out.println(2);
            }else if(matcher.group().contains("!~")){
                System.out.println(3);
            }else {
                System.out.println(4);
            }

        }
//        System.out.println("action!=\"${区域}\",cause=\"${回收原因}\",instance=\"172.18.18.103:8004\",name!~\"0_(.*?)_step_$0%\"}[1m]))".contains("!="));
//
//        String[] label = "name!~\"0_(.*?)_step_$0%\"".split("=|!=|=~|!~");
//        System.out.println(label[1]);
//
//        System.out.println("\"sssss\"".substring(1,"\"sssss\"".length()-1));

        List<String> list = Lists.newArrayList("one","two","three","four","five");
        String result= Joiner.on(",").join(list);
        System.out.println(result);
        String text = "one,two,three,four,five";
        List<String> array = Splitter.on(",").omitEmptyStrings().splitToList(text);
        array.forEach(System.out::println);
        //loadingcache
        //LoadingCache<String,String> loadingCache;
        //EventBus 订阅者
        //Futures.addCallback()
        //MoreExecutors.new
        //CompletableFuture
        //Lists
        //Sets
        //Maps
        //ImmutableMap
        //Multimap


        Map<String,String> msgMap = Maps.newHashMap();
        msgMap.put("appCode","malert");
        msgMap.put("content","错误");
        System.out.println( Joiner.on(" ").withKeyValueSeparator(":").join(msgMap.entrySet().stream().collect(Collectors.toMap(it->"\\n>"+it.getKey(), Map.Entry::getValue))));

        StringBuffer info = new StringBuffer();
        String colorTitle = "异常告警";
        info.append("{");
        info.append("    \"title\":\"<font color='red'>" + colorTitle + " </font> \",");
        info.append("    \"content\":\"");
        if (!msgMap.isEmpty()) {
            msgMap.forEach((k, v) -> {
                info.append("\\n>" + k + ":" + v.replace("\"", "'"));
            });
        }
        info.append("\"}");
        System.out.println(info);



        List <Instance> instances = Lists.newArrayList();
        Instance instance = new Instance();
        instance.setPort("80");
        instance.setId(1);
        Instance instance1 = new Instance();
        instance1.setId(1);
        instances.add(instance);
        instances.add(instance1);
        System.out.println("stream之前");
        System.out.println(instances);
        instances.stream().filter(it-> it.getId()==1
        && it.getPort()!=null).forEach(it->{
            System.out.println(it.toString());
        });





        List<String>list1 = new ArrayList<>();
        list1.add(null);
        list1.forEach(it->{
            System.out.println(1);
        });
        System.out.println(list1);

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()/1000);
    }

    @Data
    private static class Instance{
        private String port;
        private int id;
    }




}
