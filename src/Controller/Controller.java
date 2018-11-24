package Controller;

import Database.DAO;
import GUI.Menu.MenuBar;
import GUI.Panes.admin.UserPanel;
import GUI.Panes.machines.MachineListPanel;
import GUI.Windows.*;

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
            allergensListFrame.setEdit(e1 -> {
                AllergensFrame allergensFrame = new AllergensFrame("Allergén", true, true, true, true);
                allergensFrame.setId(allergensListFrame.getId());
                allergensFrame.setSave(e2 -> {
                    if (dao.saveAllergens(allergensFrame.getValues())) {
                        allergensFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    allergensListFrame.setValues(dao.getAllergensList()); //reload
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

        //Új felhasználó
        menuBar.addListener("newUser", event -> {
            UserFrame userFrame = new UserFrame("Felhasználó", true, true, true, true);
            userFrame.setSave(e1 -> {
                if (dao.saveUser(userFrame.getValues())) {
                    userFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(userFrame);
            userFrame.toFront();
        });

        //Felhasználó lista
        menuBar.addListener("listUsers", event -> {
            UserListFrame userListFrame = new UserListFrame("Felhasználó lista", true, true, true, true);
            userListFrame.setEdit(e1 -> {
                UserFrame userFrame = new UserFrame("Felhasználó", true, true, true, true);
                userFrame.setId(userListFrame.getId());
                userFrame.setSave(e2 -> {
                    if (dao.saveUser(userFrame.getValues())) {
                        userFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    userListFrame.setValues(dao.getUsersList()); //reload
                });
                userFrame.setValues(dao.getUser(userListFrame.getId()));
                desktopPane.add(userFrame);
                userFrame.toFront();
            });
            userListFrame.setDelete(el -> {
                dao.deleteUser(userListFrame.getId());
                userListFrame.setValues(dao.getUsersList());
            });
            userListFrame.setValues(dao.getUsersList());
            desktopPane.add(userListFrame);
            userListFrame.toFront();
        });

        //kilépés
        menuBar.addListener("close", event -> frame.dispose());

        //új gép
        menuBar.addListener("newMachine", event -> {
            MachineFrame machineFrame = new MachineFrame("Gép", true, true, true, true);
            machineFrame.setSave(e1 -> {
                if (dao.saveMachine(machineFrame.getValues())) {
                    machineFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(machineFrame);
            machineFrame.toFront();
        });

        //gép lista
        menuBar.addListener("listMachine", event -> {
            MachineListFrame machineListFrame = new MachineListFrame("Gép lista", true, true, true, true);
            machineListFrame.setEdit(e1 -> {
                MachineFrame machineFrame = new MachineFrame("Gép", true, true, true, true);
                machineFrame.setId(machineListFrame.getId());
                machineFrame.setSave(e2 -> {
                    if (dao.saveMachine(machineFrame.getValues())) {
                        machineFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    machineListFrame.setValues(dao.getMachineList()); //reload
                });
                machineFrame.setValues(dao.getMachine(machineListFrame.getId()));
                desktopPane.add(machineFrame);
                machineFrame.toFront();
            });
            machineListFrame.setDelete(el -> {
                dao.deleteMachine(machineListFrame.getId());
                machineListFrame.setValues(dao.getMachineList());
            });
            machineListFrame.setValues(dao.getMachineList());
            desktopPane.add(machineListFrame);
            machineListFrame.toFront();
        });

        //új alapanyagtípus
        menuBar.addListener("newIngredientType", event -> {
            IngredientTypeFrame ingredientTypeFrame = new IngredientTypeFrame("Alapanyag típus", true, true, true, true);
            ingredientTypeFrame.setSave(e1 -> {
                if (dao.saveIngredientType(ingredientTypeFrame.getValues())) {
                    ingredientTypeFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(ingredientTypeFrame);
            ingredientTypeFrame.toFront();
        });

        //alapanyagtípus lista
        menuBar.addListener("listIngredientType", event -> {
            IngredientTypeListFrame ingredientTypeListFrame = new IngredientTypeListFrame("Alapanyag típus lista", true, true, true, true);
            ingredientTypeListFrame.setEdit(e1 -> {
                IngredientTypeFrame ingredientTypeFrame = new IngredientTypeFrame("Alapanyag típus", true, true, true, true);
                ingredientTypeFrame.setId(ingredientTypeListFrame.getId());
                ingredientTypeFrame.setSave(e2 -> {
                    if (dao.saveIngredientType(ingredientTypeFrame.getValues())) {
                        ingredientTypeFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    ingredientTypeListFrame.setValues(dao.getIngredientTypeList()); //reload
                });
                ingredientTypeFrame.setValues(dao.getIngredientType(ingredientTypeListFrame.getId()));
                desktopPane.add(ingredientTypeFrame);
                ingredientTypeFrame.toFront();
            });
            ingredientTypeListFrame.setDelete(el -> {
                dao.deteleIngredientType(ingredientTypeListFrame.getId());
                ingredientTypeListFrame.setValues(dao.getIngredientTypeList());
            });
            ingredientTypeListFrame.setValues(dao.getIngredientTypeList());
            desktopPane.add(ingredientTypeListFrame);
            ingredientTypeListFrame.toFront();
        });
    }
}
