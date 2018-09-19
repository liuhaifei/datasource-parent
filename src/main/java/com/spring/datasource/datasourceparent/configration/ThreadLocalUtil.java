package com.spring.datasource.datasourceparent.configration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SessionUtils
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/19 11:46
 * @Version 1.0
 **/
public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String,Object>> LOCAL= new ThreadLocal<Map<String, Object>>(){
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    public static <T> T get(String key){
        return (T) LOCAL.get().get(key);
    }

    public static <T> void set(String key,T t){
        LOCAL.get().put(key,t);
    }

    public static void remove(String key){
        LOCAL.get().remove(key);
    }

}
