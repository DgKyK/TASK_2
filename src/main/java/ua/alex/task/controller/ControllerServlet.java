package ua.alex.task.controller;

import ua.alex.task.model.Model;

import java.io.IOException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    private Model model;
    {
        model = new Model();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        model.formDaySchedule();
        request.setAttribute("activities", model.getDayActivities());
        request.getRequestDispatcher("view/View.jsp").forward(request, response);
    }
}
