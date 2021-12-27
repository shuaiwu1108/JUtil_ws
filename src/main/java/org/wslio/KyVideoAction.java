package org.wslio;

import org.wslio.utils.FilesUtil;
import org.wslio.utils.HttpUtil;
import org.wslio.utils.JedisUtil;
import org.wslio.utils.PatternMatchesUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static void main(String[] args) {
//        setUrlToRedis();
//        setUrlRealToRedis();
//        setKyTsVideoUrlToRedis();
        getTsToDir();
    }
}
