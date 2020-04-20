package com.cz.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

/**
 * Created 2019-09-09.
 *
 * @author changzheng
 */
public class ErrorHandlerConfig extends DefaultResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() != null && response.getStatusCode().value() != 200) {
            return true;
        }
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        String statusText = response.getStatusText();
        HttpHeaders headers = response.getHeaders();
        byte[] body = getResponseBody(response);
        Charset charset = getCharset(response);
        String str = new String(body);
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(str, Map.class);
        switch (response.getStatusCode().series()) {
            case CLIENT_ERROR:
                throw HttpClientErrorException.create(response.getStatusCode(), statusText, headers, body, charset);
            case SERVER_ERROR:
                if ("2".equals(map.get("code").toString())) {
                    System.out.println("appCode不存在");
                    break;
                } else {
                    throw HttpServerErrorException.create(response.getStatusCode(), statusText, headers, body, charset);
                }
            default:
                throw new UnknownHttpStatusCodeException(response.getStatusCode().value(), statusText, headers, body, charset);
        }
    }

}
//    @Override
//    protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
//        String statusText = response.getStatusText();
//        HttpHeaders headers = response.getHeaders();
//        response.getBody().
//        byte[] body = getResponseBody(response);
//        Charset charset = getCharset(response);
//        String str = new String(body);
//        ObjectMapper mapper =new ObjectMapper();
//        Map map =mapper.readValue(str,Map.class);
//        switch (statusCode.series()) {
//            case CLIENT_ERROR:
//                throw HttpClientErrorException.create(statusCode, statusText, headers, body, charset);
//            case SERVER_ERROR:
//                if("2".equals(map.get("code").toString())){
//                    System.out.println("appCode不存在");
//                    break;
//                }else {
//                    throw HttpServerErrorException.create(statusCode, statusText, headers, body, charset);
//                }
//            default:
//                throw new UnknownHttpStatusCodeException(statusCode.value(), statusText, headers, body, charset);
//        }
//    }


