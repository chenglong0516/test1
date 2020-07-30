package com.chenglong.test1;

import com.alibaba.druid.support.json.JSONUtils;
import org.json.JSONObject;

import java.lang.ref.SoftReference;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class SoftReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        //100M的缓存数据
        byte[] cacheData = new byte[1000 * 1024 * 1024];
        //将缓存数据用软引用持有
        SoftReference<byte[]> cacheRef = new SoftReference<>(cacheData);
        //将缓存数据的强引用去除
        cacheData = null;
        System.out.println("第一次GC前" + cacheData);
        System.out.println("第一次GC前" + cacheRef.get());
        //进行一次GC后查看对象的回收情况
        System.gc();
        //等待GC
        Thread.sleep(500);
        System.out.println("第一次GC后" + cacheData);
        System.out.println("第一次GC后" + cacheRef.get());

        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData = new byte[1200 * 1024 * 1024];
        System.out.println("分配后1" + cacheData);
        System.out.println("分配后1" + cacheRef.get());
        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData1 = new byte[1200 * 1024 * 1024];
        System.out.println("分配后2" + cacheData);
        System.out.println("分配后2" + cacheRef.get());
        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData2 = new byte[100 * 1024 * 1024];
        System.out.println("分配后3" + cacheData);
        System.out.println("分配后3" + cacheRef.get());
        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData3 = new byte[100 * 1024 * 1024];
        System.out.println("分配后4" + cacheData);
        System.out.println("分配后4" + cacheRef.get());
        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData4 = new byte[100 * 1024 * 1024];
        System.out.println("分配后5" + cacheData);
        System.out.println("分配后5" + cacheRef.get());
    }

}
