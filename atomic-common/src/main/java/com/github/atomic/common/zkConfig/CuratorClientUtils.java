package com.github.atomic.common.zkConfig;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorClientUtils {

    public static final String CONNECTSTRING="127.0.0.1:2181";

    private static CuratorFramework curatorFramework;

    public static CuratorFramework getInstance(){
        curatorFramework= CuratorFrameworkFactory.newClient(CONNECTSTRING,5000,5000,
                new ExponentialBackoffRetry(1000,3));
        curatorFramework.start();
        return curatorFramework;
    }

    public static CuratorFramework getInstance(String zkAddress){
        curatorFramework= CuratorFrameworkFactory.newClient(zkAddress,5000,5000,
                new ExponentialBackoffRetry(1000,3));
        curatorFramework.start();
        return curatorFramework;
    }

}
