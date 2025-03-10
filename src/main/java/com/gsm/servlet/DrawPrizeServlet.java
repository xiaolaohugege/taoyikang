package com.gsm.servlet;

import com.gsm.bean.Prize;
import com.gsm.bean.User;
import com.gsm.service.inter.LotteryService;
import com.gsm.service.impl.LotteryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/drawResult")
public class DrawPrizeServlet extends HttpServlet {
    private LotteryService lotteryService = new LotteryServiceImpl();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventIDStr = request.getParameter("eventID");
        eventIDStr = "1";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (eventIDStr != null && user != null) {
            int eventID = Integer.parseInt(eventIDStr);
            try {

                Prize prize = lotteryService.drawPrize(eventID);
                // 记录用户参与记录
                // 如果中奖，记录中奖信息

                // 省略具体实现
                request.setAttribute("prize", prize);
                request.getRequestDispatcher("/jsp/drawResult.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "抽奖失败");
                request.getRequestDispatcher("/jsp/drawResult.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
