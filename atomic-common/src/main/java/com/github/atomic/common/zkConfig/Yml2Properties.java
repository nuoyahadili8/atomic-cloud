package com.github.atomic.common.zkConfig;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project:
 * @Description: yml转properties
 * @Version 1.0.0
 * @Throws SystemException:
 * @Author: <li>2018/12/15/015 Administrator Create 1.0
 * @Copyright ©2018-2019 al.github
 * @Modified By:
 */
public class Yml2Properties {

    public static Map<String,String> ymlConvertToProperties(String ymlFilePath, String ymlEncoding){
        final String DOT = ".";
        Map<String,String> map = new HashMap<>();
        try {
            YAMLFactory yamlFactory = new YAMLFactory();
            YAMLParser parser = yamlFactory.createParser(
                    new InputStreamReader(new FileInputStream(ymlFilePath), Charset.forName(ymlEncoding)));

            String key = "";
            String value = null;
            JsonToken token = parser.nextToken();
            while (token != null) {
                if (JsonToken.START_OBJECT.equals(token)) {
                    // do nothing
                } else if (JsonToken.FIELD_NAME.equals(token)) {
                    if (key.length() > 0) {
                        key = key + DOT;
                    }
                    key = key + parser.getCurrentName();

                    token = parser.nextToken();
                    if (JsonToken.START_OBJECT.equals(token)) {
                        continue;
                    }
                    value = parser.getText();
                    map.put(key,value);

                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    }
                    value = null;
                } else if (JsonToken.END_OBJECT.equals(token)) {
                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    } else {
                        key = "";
                    }
                }
                token = parser.nextToken();
            }
            parser.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String,String> map=Yml2Properties.ymlConvertToProperties("D:\\IdeaProjects\\chinabond-a\\atomic\\atomic-config\\target\\classes\\application-dev.yml","utf8");

        for (String key: map.keySet()){
            System.out.println("key="+key+" ,value="+map.get(key));
        }
    }

}
