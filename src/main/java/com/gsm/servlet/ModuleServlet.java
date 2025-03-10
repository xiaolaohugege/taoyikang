package com.gsm.servlet;

import com.gsm.bean.Module;
import com.gsm.service.inter.ModuleService;
import com.gsm.service.impl.ModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
//
//@WebServlet("/modules")
public class ModuleServlet extends HttpServlet {
    private ModuleService moduleService = new ModuleServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("search".equals(action)) {
                searchModules(request, response);
            } else {
                listModules(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "操作失败");
            request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
        }
    }

    private void listModules(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Module> modules = moduleService.getAllModules();
        request.setAttribute("modules", modules);
        request.getRequestDispatcher("/jsp/moduleList.jsp").forward(request, response);
    }

    private void searchModules(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<Module> modules = moduleService.searchModules(keyword);
        request.setAttribute("modules", modules);
        request.getRequestDispatcher("/jsp/moduleList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
