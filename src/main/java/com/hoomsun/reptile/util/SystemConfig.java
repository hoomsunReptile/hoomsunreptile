package com.hoomsun.reptile.util;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 *
 * 常量配置加载
 */
@Component
public class SystemConfig {

    private static Properties props=new Properties();

    public SystemConfig() {

        try {
            URL url = ResourceUtils.getURL("classpath:constantconfig.properties");
            String path = url.getPath();
            InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            props.load(bufferedInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取属性
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {

        return props == null ? null : props.getProperty(key);

    }

    /**
     * 获取属性
     *
     * @param key          属性key
     * @param defaultValue 属性value
     * @return
     */
    public static String getProperty(String key, String defaultValue) {

        return props == null ? null : props.getProperty(key, defaultValue);

    }

    /**
     * 获取properyies属性
     *
     * @return
     */
    public static String getProperties() {
        return props.toString();
    }

}
