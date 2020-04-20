package com.cz.demo.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created 2019/12/24. 4:18 下午
 *
 * @author changzheng
 */
public class OkHttpTest {

    OkHttpClient client = new OkHttpClient();
    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public static void main(String[] args) {
        OkHttpTest okHttpTest = new OkHttpTest();
        try {
            okHttpTest.run("http://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
