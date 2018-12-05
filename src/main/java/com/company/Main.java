package com.company;

import Controller.Controller;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Controller controller = new Controller();
    }
}
