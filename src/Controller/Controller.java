package Controller;

import Database.DAO;
import GUI.Menu.MenuBar;
import GUI.Windows.AllergensFrame;
import GUI.Windows.AllergensListFrame;
import GUI.Windows.LoginFrame;
import GUI.Windows.ProfileFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            if (dao.login(loginInternalFrame.getUsernameInput().getText(), String.valueOf((loginInternalFrame.getPasswordInput()).getPassword()))) {
                //TODO show menu
                MenuBar menuBar = new MenuBar();
                frame.setJMenuBar(menuBar);
                loginInternalFrame.dispose();
                addMenuListeners(menuBar);
            } else {
                //TODO popup invalid data
            }
        });
        desktopPane.add(loginInternalFrame);
        loginInternalFrame.toFront();
        Dimension dim = frame.getToolkit().getDefaultToolkit().getScreenSize();
        loginInternalFrame.setLocation(dim.width/2-loginInternalFrame.getSize().width/2, dim.height/2-loginInternalFrame.getSize().height/2);
        frame.add(desktopPane);
        frame.setSize(dim.width, dim.height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addMenuListeners(MenuBar menuBar) {

        menuBar.addListener("profile", e -> {
            ProfileFrame profileFrame = new ProfileFrame("Profil", true, true, true, true);
            profileFrame.setValues(dao.getProfile());
            profileFrame.setSave(e1 -> {
                if (dao.saveProfile(profileFrame.getValues())) {
                    profileFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(profileFrame);
            profileFrame.toFront();
        });

        //kijelentkezés
        menuBar.addListener("logout", event -> {
            frame.setJMenuBar(null);
            dao.setUserId(0);
            LoginFrame loginInternalFrame = new LoginFrame("Bejelentkezés", true, true, true, true);
            loginInternalFrame.addLoginButtonActionListener(e -> {
                if (dao.login(loginInternalFrame.getUsernameInput().getText(), String.valueOf((loginInternalFrame.getPasswordInput()).getPassword()))) {
                    MenuBar menuBar1 = new MenuBar();
                    frame.setJMenuBar(menuBar1);
                    loginInternalFrame.dispose();
                    addMenuListeners(menuBar1);
                }
            });
            desktopPane.add(loginInternalFrame);
            loginInternalFrame.toFront();
        });

        //új allergén
        menuBar.addListener("newAllergens", event -> {
            AllergensFrame allergensFrame = new AllergensFrame("Allergén", true, true, true, true);
            allergensFrame.setSave(e1 -> {
                if (dao.saveAllergens(allergensFrame.getValues())) {
                    allergensFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(allergensFrame);
            allergensFrame.toFront();
        });

        //allergén lista
        menuBar.addListener("listAllergens", event -> {
            AllergensListFrame allergensListFrame = new AllergensListFrame("Allergén lista", true, true, true, true);
//            allergensFrame.setValues(dao.getAllergens());
            allergensListFrame.setEdit(e1 -> {
                AllergensFrame allergensFrame = new AllergensFrame("Allergén", true, true, true, true);
                allergensFrame.setId(allergensListFrame.getId());
                allergensFrame.setSave(e2 -> {
                    if (dao.saveAllergens(allergensFrame.getValues())) {
                        allergensFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    allergensListFrame.setValues(dao.getAllergensList());
                });
                allergensFrame.setValues(dao.getAllergen(allergensListFrame.getId()));
                desktopPane.add(allergensFrame);
                allergensFrame.toFront();
            });
            allergensListFrame.setDelete(el -> {
                dao.deleteAllergen(allergensListFrame.getId());
                allergensListFrame.setValues(dao.getAllergensList());
            });
            allergensListFrame.setValues(dao.getAllergensList());
            desktopPane.add(allergensListFrame);
            allergensListFrame.toFront();
        });

        //kilépés
        menuBar.addListener("close", event -> frame.dispose());
    }
}
