package ua.alex.task.controller;

import ua.alex.task.view.View;
import ua.alex.task.model.Model;

import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startAction() {
        view.printMessage(Constants.INVITATION_MESSAGE);
        view.printMessage(Constants.PRESS_ONE_MESSAGE);
        Scanner sc = new Scanner(System.in);
        if (inputProcess(sc)) {
            model.formDaySchedule();
            view.showSchedule(model.getDaySchedule());
        }
        view.printMessage(Constants.GOODBYE_MESSAGE);

    }

    private boolean inputProcess(Scanner sc) {
        int temp;
        return sc.hasNextInt() && (temp = sc.nextInt()) == 1;
    }

}
