package com.gsm.servlet;

import com.gsm.bean.Event;
import com.gsm.service.inter.EventService;
import com.gsm.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet("/editEvent")
public class EditEventServlet extends HttpServlet {
    private EventService eventService = new EventServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String moduleIDStr = request.getParameter("moduleID");
        if (moduleIDStr != null) {
            // 选择模板后，跳转到活动编辑页面
            request.setAttribute("moduleID", moduleIDStr);
            request.getRequestDispatcher("/jsp/editEvent.jsp").forward(request, response);
        } else {
            String eventIDStr = request.getParameter("eventID");
            if (eventIDStr != null) {
                try {
                    int eventID = Integer.parseInt(eventIDStr);
                    Event event = eventService.getEventById(eventID);
                    request.setAttribute("event", event);
                    request.getRequestDispatcher("/jsp/editEvent.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("manageEvents");
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理活动创建或更新
        String eventIDStr = request.getParameter("eventID");
        String moduleIDStr = request.getParameter("moduleID");
        String title = request.getParameter("title");
        String eventTimeStr = request.getParameter("eventTime");
        String announcement = request.getParameter("announcement");
        String description = request.getParameter("description");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date eventTime = sdf.parse(eventTimeStr);

            Event event = new Event();
            if (eventIDStr != null && !eventIDStr.isEmpty()) {
                event.setEventID(Integer.parseInt(eventIDStr));
            }
            event.setModuleID(Integer.parseInt(moduleIDStr));
            event.setTitle(title);
            event.setEventTime(eventTime);
            event.setAnnouncement(announcement);
            event.setDescription(description);

            if (eventIDStr == null || eventIDStr.isEmpty()) {
                eventService.createEvent(event);
            } else {
                eventService.updateEvent(event);
            }

            response.sendRedirect("manageEvents");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "保存活动失败");
            request.getRequestDispatcher("jsp/editEvent.jsp").forward(request, response);
        }
    }
}
