package net.shuaiwu.utils;

import redis.clients.jedis.Jedis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JedisUtil {
    private JedisUtil() {}

    private static class JedisUtilInstance{
        private static final Jedis jedis = new Jedis("localhost", 6379);
    }

    public static Jedis getInstance(){
        return JedisUtilInstance.jedis;
    }

    public static String getKey(String key){
        return getInstance().get(key);
    }

    public static void setKeyAndValue(String key, String value){
        getInstance().set(key, value);
    }

    public static void setKeyAndList(String key, List<String> valueList){
        valueList.forEach(value -> getInstance().lpush(key, value));
    }

    public static List<String> getKeyByList(String key){
        Long size = getInstance().llen(key);
        List<String> tmpList = new ArrayList<>();
        for (long i = size-1; i >= 0; i--) {
            tmpList.add(getInstance().lindex(key, i));
        }
        return tmpList;
    }

    public static void main(String[] args) {

    }
}
