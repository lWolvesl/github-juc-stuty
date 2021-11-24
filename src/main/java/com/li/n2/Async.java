package com.li.n2;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Sync")
public class Async {
    public static void main(String[] args) throws InterruptedException {
        log.debug("同步1");
        Thread.sleep(800);
        log.debug("同步2");
        log.debug("同步3");
    }
}
