package com.gsm.service.inter;

import com.gsm.bean.Prize;
import java.util.List;

public interface PrizeService {
    void addPrize(Prize prize) throws Exception;
    void updatePrize(Prize prize) throws Exception;
    void deletePrize(int prizeID) throws Exception;
    Prize getPrizeById(int prizeID) throws Exception;
    List<Prize> getPrizesByEventId(int eventID) throws Exception;
}
