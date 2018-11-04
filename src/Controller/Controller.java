package Controller;

import Database.DAO;
import GUI.Menu.MenuBar;
import GUI.Windows.LoginFrame;
import GUI.Windows.ProfileFrame;

import javax.swing.*;
import java.awt.*;

public class Controller {
    static JFrame frame;
    static JDesktopPane desktopPane;
    static DAO dao;

    public Controller() {

        dao = new DAO();
        frame = new JFrame("Factory");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        desktopPane = new JDesktopPane();

        LoginFrame loginInternalFrame = new LoginFrame("Bejelentkezés", true, true, true, true);
        loginInternalFrame.addLoginButtonActionListener(e -> {
            if(dao.login(loginInternalFrame.getUsernameInput().getText(), String.valueOf(( loginInternalFrame.getPasswordInput()).getPassword()))){
                //TODO show menu
                MenuBar menuBar = new MenuBar();
                frame.setJMenuBar(menuBar);
                loginInternalFrame.dispose();
                addMenuListeners(menuBar);
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

    public void addMenuListeners(MenuBar menuBar){
        menuBar.addListener("profile", e -> {
            ProfileFrame profileFrame = new ProfileFrame("Profil", true, true, true, true);
            profileFrame.setValues(dao.getProfile());
            profileFrame.setSave(e1 -> {
                dao.saveProfile(profileFrame.getValues());
                profileFrame.dispose();
            });
            desktopPane.add(profileFrame);
            frame.add(desktopPane);
        });
        menuBar.addListener("logout", event -> {
            frame.setJMenuBar(null);
            dao.setUserId(0);
            LoginFrame loginInternalFrame = new LoginFrame("Bejelentkezés", true, true, true, true);
            loginInternalFrame.addLoginButtonActionListener(e -> {
                if(dao.login(loginInternalFrame.getUsernameInput().getText(), String.valueOf(( loginInternalFrame.getPasswordInput()).getPassword()))){
                    MenuBar menuBar1 = new MenuBar();
                    frame.setJMenuBar(menuBar1);
                    loginInternalFrame.dispose();
                    addMenuListeners(menuBar1);
                }
            });
            desktopPane.add(loginInternalFrame);
        });
        menuBar.addListener("close", event -> frame.dispose());
    }
}
