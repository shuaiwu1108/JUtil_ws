package org.wslio.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 *  Pattern.DOTALL  (.)正常情况不会匹配回车
 *  Pattern.MULTILINE   多行匹配
 */
public class PatternMatchesUtil {
    public static boolean decideMatches(String regex, String text){
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        return false;
    }

    public static String mathcesToStr(String regex, String text){
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
            String tmp = matcher.group(1);
            return tmp;
        }
        return "";
    }

    public static String muliLineMatches(String regex, String text){
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL|Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            String tmp = matcher.group(1);
            String tmp2 = matcher.group(2);
            return tmp.trim().split("-")[0].trim() + ", " + tmp2.trim() + ".m3u8";
        }else{
            return "";
        }
    }

    public static List<String> muliLineMatchesToList(String regex, String text){
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        List<String> strs = new ArrayList<>();
        while(matcher.find()){
            String tmp = matcher.group(1);
            String tmp2 = matcher.group(2);
            strs.add(tmp2.trim() + ", " + tmp.trim() + "\n");
        }
        return strs;
    }

    public static void main(String[] args) {
        String tmp = mathcesToStr("(.*)v.f100220.m3u8", FilesUtil.readFile("UrlReal/萌芽8期：1.1 心理学入门"));
        System.out.println(tmp);
    }
}
