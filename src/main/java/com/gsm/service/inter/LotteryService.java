package com.gsm.service.inter;

import com.gsm.bean.Prize;

public interface LotteryService {
    Prize drawPrize(int eventID) throws Exception;
}
