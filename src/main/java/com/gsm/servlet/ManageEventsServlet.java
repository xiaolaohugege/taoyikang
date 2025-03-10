package com.gsm.servlet;

import com.gsm.bean.Event;
import com.gsm.service.inter.EventService;
import com.gsm.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/manageEvents")
public class ManageEventsServlet extends HttpServlet {
    private EventService eventService = new EventServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("search".equals(action)) {
                searchEvents(request, response);
            } else if ("delete".equals(action)) {
                deleteEvent(request, response);
            } else {
                listEvents(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "操作失败");
            request.getRequestDispatcher("/jsp/manageEvents.jsp").forward(request, response);
        }
    }

    private void listEvents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 假设用户ID存储在Session中
        HttpSession session = request.getSession();
        com.gsm.bean.User user = (com.gsm.bean.User) session.getAttribute("user");
        List<Event> events = eventService.getAllEventsByUser(user.getUserID());
        request.setAttribute("events", events);
        request.getRequestDispatcher("/jsp/manageEvents.jsp").forward(request, response);
    }

    private void searchEvents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<Event> events = eventService.searchEvents(keyword);
        request.setAttribute("events", events);
        request.getRequestDispatcher("/jsp/manageEvents.jsp").forward(request, response);
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String eventIDStr = request.getParameter("eventID");
        if (eventIDStr != null) {
            int eventID = Integer.parseInt(eventIDStr);
            eventService.deleteEvent(eventID);
        }
        response.sendRedirect("manageEvents");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
