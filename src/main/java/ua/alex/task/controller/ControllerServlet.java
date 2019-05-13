package ua.alex.task.controller;

import ua.alex.task.model.Activity;
import ua.alex.task.model.Model;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "ControllerServlet")
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    private Model model;
    {
        model = new Model();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        model.formDaySchedule();
        request.setAttribute("activities", model.getDaySchedule());
        request.getRequestDispatcher("view/View.jsp").forward(request, response);
    }
}
