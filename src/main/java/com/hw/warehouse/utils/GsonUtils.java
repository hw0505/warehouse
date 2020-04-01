package com.hw.warehouse.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * @author LYL-PC
 * @所属项目 total
 * @类名称 GsonUtils
 * @类作用 gson工具类
 * @类作者 LYL-PC
 * @创建日期 2020/3/24
 * @审核人
 * @审核日期
 * @更新记录
 * @其它备注
 */
public class GsonUtils {
    private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    /**
     * 将object对象转成json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }


    /**
     * 将gsonString转成泛型bean
     *
     * @param gsonString
     * @param clazz
     * @return
     */
    public static <T> T toBean(String gsonString, Class<T> clazz) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, clazz);
        }
        return t;
    }


    /**
     * 转成list
     * 泛型在编译期类型被擦除导致报错
     * @param gsonString
     * @param clazz
     * @return
     */
    public static <T> List<T> toList(String gsonString, Class<T> clazz) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }


    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> toMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
