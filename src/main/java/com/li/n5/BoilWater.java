package com.li.n5;

import com.li.sleep.Sleep;
import lombok.extern.slf4j.Slf4j;
/**
 * @author li
 */

@Slf4j(topic = "c.boil")
public class BoilWater {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            log.debug("老王洗水壶");
            Sleep.sleep(1);
            log.debug("老王洗完了水壶");
            Sleep.sleep(1);
            log.debug("老王烧水");
            Sleep.sleep(5);
            log.debug("老王烧开了水");
        },"老王");

        Thread t2 = new Thread(()->{
            log.debug("小李洗茶壶");
            Sleep.sleep(1);
            log.debug("小李洗完了茶壶");
            log.debug("小李洗茶杯");
            Sleep.sleep(2);
            log.debug("小李洗完了茶杯");
            log.debug("小李拿茶叶");
            Sleep.sleep(1);
            log.debug("小李拿到了茶叶");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("小李泡茶");
        },"小李");

        t1.start();
        t2.start();
    }
}
