package com.gsm.service.impl;

import com.gsm.bean.Prize;
import com.gsm.dao.impl.PrizeDAOImpl;
import com.gsm.dao.inter.PrizeDAO;
import com.gsm.service.inter.PrizeService;
import java.util.List;

public class PrizeServiceImpl implements PrizeService {
    private PrizeDAO prizeDAO = new PrizeDAOImpl();

    @Override
    public void addPrize(Prize prize) throws Exception {
        prizeDAO.addPrize(prize);
    }

    @Override
    public void updatePrize(Prize prize) throws Exception {
        prizeDAO.updatePrize(prize);
    }

    @Override
    public void deletePrize(int prizeID) throws Exception {
        prizeDAO.deletePrize(prizeID);
    }

    @Override
    public Prize getPrizeById(int prizeID) throws Exception {
        return prizeDAO.getPrizeById(prizeID);
    }

    @Override
    public List<Prize> getPrizesByEventId(int eventID) throws Exception {
        return prizeDAO.getPrizesByEventId(eventID);
    }
}
