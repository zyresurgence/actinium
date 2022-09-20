package com.zy.actinium.rabbitmq.provider.util;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * TODO
 *  基础工具类。
 * @author Neo
 * @version 1.0.0
 * @date 2021/10/9 10:52
 */
public class CommonUtil {


    /**
     *  将byte数组为对象。
     * @param bytes     bytes数组。
     * @param clazz     转换类型。
     * @param <T>       泛型。
     * @return          转换对象。
     */
    public  <T> T byteToObject(byte[] bytes, Class<T> clazz) {
        T t;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            t = (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return t;
    }


    public static void main(String[] args) {
        String test = "{\"messageBody\":\"hello world!!!\",\"messageId\":\"7f21bbf85bc84c7e9692144929ed2b34\",\"sendTime\":\"2021-10-09 13:57:35\"}";
        byte[] bytes = test.getBytes();

    }
}
