package com.gsm.servlet;

import com.gsm.bean.Prize;
import com.gsm.service.inter.PrizeService;
import com.gsm.service.impl.PrizeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/prizes")
public class PrizeServlet extends HttpServlet {
    private PrizeService prizeService = new PrizeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("list".equals(action)) {
                listPrizes(request, response);
            } else if ("edit".equals(action)) {
                editPrize(request, response);
            } else if ("delete".equals(action)) {
                deletePrize(request, response);
            } else {
                // 默认行为
                listPrizes(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "操作失败");
            request.getRequestDispatcher("/jsp/prizeList.jsp").forward(request, response);
        }
    }

    private void listPrizes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String eventIDStr = request.getParameter("eventID");
        if (eventIDStr == null) {
            response.sendRedirect("dashboard");
            return;
        }
        int eventID = Integer.parseInt(eventIDStr);
        List<Prize> prizes = prizeService.getPrizesByEventId(eventID);
        request.setAttribute("prizes", prizes);
        request.setAttribute("eventID", eventID);
        request.getRequestDispatcher("/jsp/prizeList.jsp").forward(request, response);
    }

    private void editPrize(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String prizeIDStr = request.getParameter("prizeID");
        String eventIDStr = request.getParameter("eventID");
        if (prizeIDStr != null) {
            int prizeID = Integer.parseInt(prizeIDStr);
            Prize prize = prizeService.getPrizeById(prizeID);
            request.setAttribute("prize", prize);
        }
        request.setAttribute("eventID", eventIDStr);
        request.getRequestDispatcher("/jsp/editPrize.jsp").forward(request, response);
    }

    private void deletePrize(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String prizeIDStr = request.getParameter("prizeID");
        String eventIDStr = request.getParameter("eventID");
        if (prizeIDStr != null) {
            int prizeID = Integer.parseInt(prizeIDStr);
            prizeService.deletePrize(prizeID);
        }
        response.sendRedirect("prizes?action=list&eventID=" + eventIDStr);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理奖品添加或更新
        String prizeIDStr = request.getParameter("prizeID");
        String eventIDStr = request.getParameter("eventID");
        String prizeLevel = request.getParameter("prizeLevel");
        String prizeName = request.getParameter("prizeName");
        String prizeImageURL = request.getParameter("prizeImageURL");
        String prizeType = request.getParameter("prizeType");
        String probabilityStr = request.getParameter("probability");
        String redemptionCode = request.getParameter("redemptionCode");
        String redemptionInstructions = request.getParameter("redemptionInstructions");

        try {
            double probability = Double.parseDouble(probabilityStr);
            Prize prize = new Prize();
            if (prizeIDStr != null && !prizeIDStr.isEmpty()) {
                prize.setPrizeID(Integer.parseInt(prizeIDStr));
            }
            prize.setEventID(Integer.parseInt(eventIDStr));
            prize.setPrizeLevel(prizeLevel);
            prize.setPrizeName(prizeName);
            prize.setPrizeImageURL(prizeImageURL);
            prize.setPrizeType(prizeType);
            prize.setProbability(probability);
            prize.setRedemptionCode(redemptionCode);
            prize.setRedemptionInstructions(redemptionInstructions);

            if (prizeIDStr == null || prizeIDStr.isEmpty()) {
                prizeService.addPrize(prize);
            } else {
                prizeService.updatePrize(prize);
            }

            response.sendRedirect("prizes?action=list&eventID=" + eventIDStr);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "保存奖品失败");
            request.getRequestDispatcher("/jsp/editPrize.jsp").forward(request, response);
        }
    }
}
