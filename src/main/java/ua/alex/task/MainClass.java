package ua.alex.task;

import ua.alex.task.view.View;
import ua.alex.task.controller.Controller;
import ua.alex.task.model.Model;

public class MainClass {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startAction();
    }
}
