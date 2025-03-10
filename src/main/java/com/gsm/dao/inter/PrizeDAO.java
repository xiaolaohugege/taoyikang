package com.gsm.dao.inter;

import com.gsm.bean.Prize;
import java.util.List;

public interface PrizeDAO {
    void addPrize(Prize prize) throws Exception;
    void updatePrize(Prize prize) throws Exception;
    void deletePrize(int prizeID) throws Exception;
    Prize getPrizeById(int prizeID) throws Exception;
    List<Prize> getPrizesByEventId(int eventID) throws Exception;
    // 其他必要的方法
}
