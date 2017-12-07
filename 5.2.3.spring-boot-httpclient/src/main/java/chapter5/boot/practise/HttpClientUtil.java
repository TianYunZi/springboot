package chapter5.boot.practise;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Admin on 2017/10/31.
 */
public class HttpClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    private RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000)
            .setConnectTimeout(15000).setConnectionRequestTimeout(15000).build();

    private static HttpClientUtil instance = null;

    private HttpClientUtil() {
    }

    public static HttpClientUtil getInstance() {
        if (instance == null) {
            instance = new HttpClientUtil();
        }
        return instance;
    }

    /**
     * 发送post请求.
     *
     * @param httpUrl 地址
     * @return
     */
    public String sendHttpPost(String httpUrl) {
        HttpPost httpPost = new HttpPost(httpUrl);
        return sendHttpPost(httpPost);
    }

    /**
     * 发送post请求.
     *
     * @param httpUrl 地址
     * @param params  参数(格式:key1=value1&key2=value2)
     * @return
     */
    public String sendHttpPost(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl);
        //设置参数
        StringEntity stringEntity = new StringEntity(params, "UTF-8");
        stringEntity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(stringEntity);

        return sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl, Map<String, String> maps) {

    }

    /**
     * 发送Post请求.
     *
     * @param httpPost
     * @return
     */
    private String sendHttpPost(HttpPost httpPost) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            //创建默认的httpClient实例
            httpClient = HttpClients.createDefault();
            httpPost.setConfig(requestConfig);
            //执行请求
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (ClientProtocolException e) {
            LOGGER.error("错误信息: {}", e);
        } catch (IOException e) {
            LOGGER.error("错误信息: {}", e);
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    LOGGER.error("错误信息: {}", e);
                }
            }
        }

        return responseContent;
    }
}
