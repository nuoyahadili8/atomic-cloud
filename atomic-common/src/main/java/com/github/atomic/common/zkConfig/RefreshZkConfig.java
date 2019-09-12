package com.github.atomic.common.zkConfig;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project:
 * @Description: 刷新配置文件内容到zookeeper中
 * @Version 1.0.0
 * @Throws SystemException:
 * @Author: <li>2018/12/15/015 Administrator Create 1.0
 * @Copyright ©2018-2019 al.github
 * @Modified By:
 */
public class RefreshZkConfig {

    /**
     * zookeeper配置中心根目录
     */
    public static final String ZK_ROOT_PATH="/atomic-config/demo-dev";

    /**
     * 包含的配置文件
     */
    public static final String[] ymlFiles={"config/application-dev.yml", "config/atomic-demo-service-dev.yml"};

    /**
     * zookeeper连接串
     */
    public static final String CONNECTION_STRING="106.12.203.43:2181";

    public static void main(String[] args) throws Exception {
        Map<String,String> map=new HashMap<>();
        for (String ymlFile: ymlFiles){
            /**
             * 本地存放的配置文件
             */
            String file=RefreshZkConfig.class.getClassLoader().getResource(ymlFile).getFile();
            Map<String,String> properties=Yml2Properties.ymlConvertToProperties(file,"utf8");
            map.putAll(properties);
        }

        CuratorFramework zkClient = CuratorClientUtils.getInstance(CONNECTION_STRING);
        //确认目录
        confrimPath(zkClient,ZK_ROOT_PATH);

        for (String key : map.keySet()){
            System.out.println(key + "=" + map.get(key));
            zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                    .forPath(ZK_ROOT_PATH+"/"+key,map.get(key).getBytes());
        }
    }

    public static void confrimPath(CuratorFramework zkClient,String path) throws Exception {
        Stat stat = zkClient.checkExists().forPath(path);
        if (stat != null){
            zkClient.delete().deletingChildrenIfNeeded().forPath(path);
        }
        zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path);
    }
}
