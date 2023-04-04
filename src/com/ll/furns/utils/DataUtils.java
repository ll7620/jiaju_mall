package com.ll.furns.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.print.DocFlavor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class DataUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String val, int defaultVal){
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
           // e.printStackTrace();
        }

        return defaultVal;
    }
}
