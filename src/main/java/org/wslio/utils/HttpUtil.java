package org.wslio.utils;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

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
}
