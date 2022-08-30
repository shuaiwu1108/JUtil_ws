package org.wslio;

import com.alibaba.druid.pool.DruidPooledConnection;
import org.wslio.models.ListNode;
import org.wslio.utils.*;

import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class KyVideoAction {
    private static final String baseUrl = "https://www.tangxinli.com";
    private static final String outhUrl = "/passport/wechat/oauth?state=";
    private static final String testUrl = "/podcasts/606d535cdeb2bc229e6af45a";
    private static final String state = "/ky/home/courses";

    public static void setUrlToRedis(){
        List<String> urls = FilesUtil.readFileToList("KY视频列表地址.txt");
        JedisUtil.setKeyAndList("KyVideo", urls);
    }

    public static void setUrlRealToRedis(){
        List<String> kyVideoListReal = new ArrayList<>();
        List<String> videoList = JedisUtil.getKeyByList("KyVideo");
        for (String video : videoList){
            System.out.println(video);
            String req = video.split(",")[1].trim();
            String res  = HttpUtil.sendGet(baseUrl + req);
            String tmp = PatternMatchesUtil.muliLineMatches("<title>(.*)</title>.*src: \'(.*)\\.m3u8\'", res);
            System.out.println(tmp.split("-")[0]);
            kyVideoListReal.add(tmp.split("-")[0]);
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JedisUtil.setKeyAndList("KyVideoReal", kyVideoListReal);
    }

    public static void setKyTsVideoUrlToRedis(){
        List<String> urlReals = JedisUtil.getKeyByList("KyVideoReal");
        for(String urlReal : urlReals){
            System.out.println(urlReal);
            List<String> resLines = HttpUtil.sendGetForList(urlReal.split(",")[1].trim());
            List<String> newLines = new ArrayList<>();
            newLines.add(urlReal.split(",")[1].trim() + "\n");
            newLines.addAll(resLines);
//            FilesUtil.writeFileForList(newLines, "UrlReal/" + urlReal.split(",")[0].trim());
            JedisUtil.setKeyAndList(urlReal.split(",")[0].trim(), newLines);

            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getTsToDir(){
        Set<String> keys = JedisUtil.getInstance().keys("萌芽8期*");
        keys.forEach(key -> {
            List<String> tsArray = JedisUtil.getKeyByList(key);
            String m3u8Url = PatternMatchesUtil.mathcesToStr("(.*)v.f100220.m3u8", tsArray.get(0));
            for (String ts : tsArray){
                if(ts.startsWith("https") || ts.startsWith("#") || ts.equals("\n")){
                    continue;
                }else{
                    System.out.println(m3u8Url + ts);
                    HttpUtil.downLoadByNio(m3u8Url + ts, FilesUtil.baseResources + "KyTsVideo/" + key + "/", ts.trim());
                    try {
                        Thread.sleep(1000 * 3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    //合并ts文件为mp4，并删除ts
    public static void handlerTsToMp4(){
        Set<String> keys = JedisUtil.getInstance().keys("萌芽8期*");
        keys.forEach(key -> {
            List<String> vals = JedisUtil.getKeyByList(key);
            System.out.println(key);
            try (FileOutputStream outputStream = new FileOutputStream("D:\\KyVideoMerge\\" + key + ".ts");) {
                vals.stream().filter(val -> !val.startsWith("#") && !val.startsWith("https"))
                    .forEach(val -> {
                        File temp = new File("F:\\DOC\\KY\\KyTsVideo\\" + key + "\\" + val.trim());
                        try (FileInputStream inputStream = new FileInputStream(temp)){
                            int len = 0;
                            byte[] buf = new byte[1024];
                            while ((len = inputStream.read(buf)) != -1){
                                outputStream.write(buf, 0, len);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                System.out.println("-------------------------------------------------");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
//        MessageUtil.main(new String[]{"10.8.1.17:9092"});
//        setUrlToRedis();
//        setUrlRealToRedis();
//        setKyTsVideoUrlToRedis();
//        getTsToDir();
//        handlerTsToMp4();

//        DruidPooledConnection conn = MySqlPoolUtil.getInstance();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = conn.prepareStatement("select id,username,password,account from t_user");
//            rs = stmt.executeQuery();
//            while (rs.next()){
//                System.out.println(rs.getString(1)+", " + rs.getString("username")+", "+ rs.getString("password") + ", " + rs.getString("account"));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            MySqlPoolUtil.close(rs, stmt, conn);
//        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> l1List = new ArrayList<>();
        int val1 =  l1.val;
        l1List.add(val1);
        while(l1.next!=null){
            l1 = l1.next;
            l1List.add(l1.val);
        }
        Collections.reverse(l1List);
        System.out.println("l1: " + l1List.toString());


        List<Integer> l2List = new ArrayList<>();
        int val2 = l2.val;
        l2List.add(val2);
        while(l2.next!=null){
            l2 = l2.next;
            l2List.add(l2.val);
        }
        Collections.reverse(l2List);
        System.out.println("l2: " + l2List.toString());

        int l1Tmp = 0;
        for(int i=0; i<l1List.size(); i++){
            int tmp = l1List.size() - i - 1;
            l1Tmp += l1List.get(i) * Math.pow(10, tmp);
        }
        System.out.println("l1Count: " + l1Tmp);

        int l2Tmp = 0;
        for(int i=0; i<l2List.size(); i++){
            int tmp = l2List.size() - i - 1;
            l2Tmp += l2List.get(i) * Math.pow(10, tmp);
        }
        System.out.println("l2Count: " + l2Tmp);

        int tot = l1Tmp + l2Tmp;
        System.out.println("totCount: " + tot);

        String t = reverseTestSix(tot+"");
        System.out.println("t: " + t);

        ListNode resNode = new ListNode();
        for (int i=0; i<t.length(); i++){
            resNode.next = new ListNode(Integer.parseInt(t.substring(i, i+1)));
            resNode = resNode.next;
        }
        return resNode.next;
    }

    public static String reverseTestSix(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseTestSix(s.substring(1)) + s.substring(0, 1);
    }
}
