package Controller;

import Database.DAO;
import GUI.Menu.MenuBar;
import GUI.Windows.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Controller {
    static JFrame frame;

    public Controller() {

        DAO dao = new DAO();
        frame = new JFrame("Factory");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JDesktopPane desktopPane = new JDesktopPane();

        LoginFrame loginInternalFrame = new LoginFrame("Bejelentkezés", true, true, true, true);
        loginInternalFrame.addLoginButtonActionListener(e -> {
            if(dao.login(loginInternalFrame.getUsernameInput().getText(),loginInternalFrame.getPasswordInput().getText())){
                System.out.println("FUCK IT MAN");
                //TODO show menu
                MenuBar menuBar = new MenuBar();
                frame.setJMenuBar(menuBar);
                loginInternalFrame.dispose();
            }else{
                //TODO popup invalid data
            }
        });

        desktopPane.add(loginInternalFrame);
        frame.add(desktopPane);
        frame.setSize(1500, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
