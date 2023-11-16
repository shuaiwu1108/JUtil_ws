package net.shuaiwu.utils;


import com.github.kevinsawicki.http.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.entity.StringEntity;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

/**
 * web请求工具类封装
 */
public class HttpUtil {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String COOKIE = "connect.sid=s%3AH6iC4rLx9IUJcR9T1QsmHtB8OuYflr5P.rg6cMkVPT%2Fp9FuVc%2BX5lucM5cwGmUAn%2BW0CkeHtVTjg; SERVERID=b5ef5234a2f203d5d2d5c0238cb08690|1640316118|1640311709";

    public static String sendGet(String url){
        String res = "";
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            request.addHeader("User-Agent", USER_AGENT);
            request.addHeader("cookie", COOKIE);
            HttpResponse response = client.execute(request);
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            return result.toString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<String> sendGetForList(String url){
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            request.addHeader("User-Agent", USER_AGENT);
            request.addHeader("cookie", COOKIE);
            HttpResponse response = client.execute(request);
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            List<String> result = new ArrayList<>();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.add(line + "\n");
            }
            return result;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void downLoadByNio(String url, String saveDir, String fileName){
        try (InputStream ins = new URL(url).openStream()) {
            Path target = Paths.get(saveDir, fileName);
            Files.createDirectories(target.getParent());
            Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(url + "," + fileName + ", 成功!, 目录: " + saveDir);
        }catch (IOException e){
            System.err.println(url + "," + fileName + ", 失败！");
        }
    }

    public static String sendPostByHttps(String url, Map<String, String> body, Map<String, String> header) {

        CloseableHttpResponse response = null;
        // 处理请求路径
        //创建httpclient对象
        CloseableHttpClient client = null;
        String respBody;
        try {
            client = HttpClients.custom()
                    .setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContexts.custom()
                            //忽略掉对服务器端证书的校验
                            .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                            .build(), NoopHostnameVerifier.INSTANCE))
                    .build();
            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            // 请求头设置
            httpPost.setHeader("Content-Type", "application/json");
            if (header != null) {
                for(String s:header.keySet()){
                    httpPost.setHeader(s,header.get(s));
                }
            }
            // 情求体设置
            if (body != null) {
                httpPost.setEntity(new StringEntity(JsonUtil.parseObject(body), "utf-8"));
            }
            //执行请求操作，并拿到结果
            response = client.execute(httpPost);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                respBody = EntityUtils.toString(entity);
                return respBody;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static String postTest(){
        String result = HttpRequest.post("https://223.75.53.63:44380/iot/ganwei/v2/devices")
                .header("Content-Type", "application/json")
                .header("X-ClientId", "d0ba3f5f1b6106e9")
                .form("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoi5YyX5ZCR5bqU55So5Li76LSm5Y-3IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiQURNSU4iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6ImQwYmEzZjVmMWI2MTA2ZTkiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zeXN0ZW0iOiLmuZbljJfogZTmipXljYPmlrnpobnnm64iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiIxIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9leHBpcmVkIjoiMDMvMjkvMjAyMiAxMTo0ODoyNCIsImV4cCI6MTY0ODUyNTcwNCwiaXNzIjoiZ2Fud2Vpc29mdC5uZXQiLCJhdWQiOiJnYW53ZWlzb2Z0Lm5ldCJ9.aL0B30DtRyGcynhzZwfntAd2tlwfFZ1wef3B92opRYY")
                .body();
        return result;
    }
}
