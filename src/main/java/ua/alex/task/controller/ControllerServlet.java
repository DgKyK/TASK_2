package ua.alex.task.controller;

import ua.alex.task.model.Model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class ControllerServlet extends HttpServlet {
    private Model model;
    {
        model = new Model();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model.formDaySchedule();
        request.setAttribute("activities", model.getDayActivitiesLists());
        request.getRequestDispatcher("view/View.jsp").forward(request, response);
    }
}
