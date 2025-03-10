package com.gsm.service.impl;

import com.gsm.bean.Prize;
import com.gsm.service.inter.LotteryService;
import com.gsm.service.inter.PrizeService;
import com.gsm.service.impl.PrizeServiceImpl;
import java.util.List;
import java.util.Random;

public class LotteryServiceImpl implements LotteryService {
    private PrizeService prizeService = new PrizeServiceImpl();
    private Random random = new Random();

    @Override
    public Prize drawPrize(int eventID) throws Exception {
        List<Prize> prizes = prizeService.getPrizesByEventId(eventID);
        double totalProbability = 0.0;
        for (Prize prize : prizes) {
            totalProbability += prize.getProbability();
        }
        double rand = random.nextDouble() * totalProbability;
        double cumulative = 0.0;
        for (Prize prize : prizes) {
            cumulative += prize.getProbability();
            if (rand <= cumulative) {
                return prize;
            }
        }
        return null; // 未中奖
    }
}
