package org.example;

import org.example.View.MainView;
import org.example.Controller.Controller;

public class Main {
    public static void main(String[] args) {
        MainView av = new MainView();
        Controller controller = new Controller(av);
    }
}