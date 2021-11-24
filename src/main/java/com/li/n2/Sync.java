package com.li.n2;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Sync")
public class Sync {
    public static void main(String[] args) {
        new Thread(()->{
            log.debug("线程1开始运行");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("线程1结束运行");
        }).start();
        log.debug("异步");
    }
}
