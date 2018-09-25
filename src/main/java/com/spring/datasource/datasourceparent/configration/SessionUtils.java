package com.spring.datasource.datasourceparent.configration;



/**
 * @ClassName SessionUtils
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/19 11:46
 * @Version 1.0
 **/
public class SessionUtils {

    private static final String DB_PREFIX="user_";
    private static final String TENANT_ID="TENANT_ID";


    public static void setTenantId(String key){
        ThreadLocalUtil.set(TENANT_ID,DB_PREFIX+key);
    }

    public static String getTenantId(){
        return ThreadLocalUtil.get(TENANT_ID);
    }

    public static void removeTenantId(){
        ThreadLocalUtil.remove(TENANT_ID);
    }

}
