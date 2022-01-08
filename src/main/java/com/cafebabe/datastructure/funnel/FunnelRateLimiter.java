package com.cafebabe.datastructure.funnel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cafebabe on 2021/10/28 23:17
 */
public class FunnelRateLimiter {

    private Map<String,Funnel> funnels = new HashMap<>();

    static class Funnel {
        //初始容量
        int capacity;
        //流水速率
        float leakingRate;
        //剩余的配额
        int leftQuota;
        //当前时间
        long leakingTs;

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            //剩余配额等于初始容量
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long diffTs = nowTs - leakingTs;
            int deleteQuota = (int) (diffTs * leakingRate);
            if (deleteQuota < 0) {
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            if (deleteQuota < 1) {
                return;
            }
            this.leftQuota = leftQuota + deleteQuota;
            this.leakingTs = nowTs;
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quota){
            makeSpace();
            if(this.leftQuota >= quota){
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }
    }



}
