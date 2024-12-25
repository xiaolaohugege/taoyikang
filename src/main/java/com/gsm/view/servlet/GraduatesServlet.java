package com.gsm.view.servlet;

import com.gsm.bean.Colleges;
import com.gsm.bean.Graduate;
import com.gsm.service.impl.CollegesServiceImpl;
import com.gsm.service.impl.GraduatesServiceImpl;
import com.gsm.service.inter.ICollegesService;
import com.gsm.service.inter.IGraduatesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  一个普通的java类 不可能被浏览器 url 能够访的到！！！ 必须是特殊的java类
 *
 */
public class GraduatesServlet extends HttpServlet {

    IGraduatesService graduatesService = new GraduatesServiceImpl();
    ICollegesService collegesService = new CollegesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req ,  resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 在第一次执行req.getParameter("requestMethod")方法之前设置编码
        // 可以有效避免post方式提交时后加收到乱码
        req.setCharacterEncoding("UTF-8");

        String requestMethod = req.getParameter("requestMethod");

        if("list".equals(requestMethod)){
            list(req ,resp);
        }

        if("addInput".equals(requestMethod)){
            addInput(req ,resp);
        }

        if("add".equals(requestMethod)){
            add(req ,resp);
        }


        if("delete".equals(requestMethod)){
            delete(req ,resp);
        }

        if("updateInput".equals(requestMethod)){
            updateInput(req ,resp);
        }

        if("update".equals(requestMethod)){
            update(req ,resp);
        }

        if("search".equals(requestMethod)){
            search(req ,resp);
        }
        
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // mvc
        // c controller 调用m model得到一些数据
        List<Graduate> graduateses = graduatesService.list();

        // c 把这个数据给到v view jsp
        req.setAttribute("graduateses" , graduateses);

        // 最左侧的/代表的是webapp文件夹
        // c controller 把v view 给到客户端
        req.getRequestDispatcher("/graduates/graduatesList.jsp").forward(req ,resp);

    }

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameKey = req.getParameter("nameKey");

        // mvc
        // c controller 调用m model得到一些数据
        List<Graduate> graduateses = graduatesService.find(nameKey);


        // c 把这个数据给到v view jsp
        req.setAttribute("nameKey" , nameKey);
        req.setAttribute("graduateses" , graduateses);

        // 最左侧的/代表的是webapp文件夹
        // c controller 把v view 给到客户端
        req.getRequestDispatcher("/graduates/graduatesList.jsp").forward(req ,resp);

    }

    protected void addInput(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Colleges> collegeses = collegesService.list();

        // c 把这个数据给到v view jsp
        req.setAttribute("collegeses" , collegeses);

        // 最左侧的/代表的是webapp文件夹
        // c controller 把v view 给到客户端
        req.getRequestDispatcher("/graduates/graduatesAddInput.jsp").forward(req ,resp);

    }
    
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String collegeId = req.getParameter("collegeId");
        String name = req.getParameter("name");
        String studentNumber = req.getParameter("studentNumber");
        String gender = req.getParameter("gender");
        String major = req.getParameter("major");
        String graduationYear = req.getParameter("graduationYear");
        String degree = req.getParameter("degree");

        Graduate graduates = new Graduate();

        graduates.setCollegeId(Integer.parseInt(collegeId));
        graduates.setName(name);
        graduates.setStudentNumber(studentNumber);
        graduates.setGender(gender);
        graduates.setMajor(major);
        graduates.setGraduationYear(Integer.parseInt(graduationYear));
        graduates.setDegree(degree);

        graduatesService.add(graduates);

        // 最左侧的/代表的是webapp文件夹
        // c controller 把v view 给到客户端
        list(req ,resp);

    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        graduatesService.delete(Integer.parseInt(id));

        list(req ,resp);

    }

    protected void updateInput(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");

        Graduate graduates = graduatesService.load(Integer.parseInt(id));

        req.setAttribute("graduates" , graduates);

        // 最左侧的/代表的是webapp文件夹
        // c controller 把v view 给到客户端
        req.getRequestDispatcher("/graduates/graduatesUpdateInput.jsp").forward(req ,resp);

    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String graduateId = req.getParameter("graduateId");
        String collegeId = req.getParameter("collegeId");
        String name = req.getParameter("name");
        String studentNumber = req.getParameter("studentNumber");
        String gender = req.getParameter("gender");
        String major = req.getParameter("major");
        String graduationYear = req.getParameter("graduationYear");
        String degree = req.getParameter("degree");

        Graduate graduates = new Graduate();

        graduates.setGraduateId(Integer.parseInt(graduateId));
        graduates.setCollegeId(Integer.parseInt(collegeId));
        graduates.setName(name);
        graduates.setStudentNumber(studentNumber);
        graduates.setGender(gender);
        graduates.setMajor(major);
        graduates.setGraduationYear(Integer.parseInt(graduationYear));
        graduates.setDegree(degree);

        graduatesService.update(graduates);

        list(req, resp);

    }


}
