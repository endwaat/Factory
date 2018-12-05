package Controller;

import Database.DAO;
import GUI.Menu.MenuBar;
import GUI.Panes.admin.UserPanel;
import GUI.Panes.machines.MachineListPanel;
import GUI.Windows.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

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
        loginInternalFrame.setLocation(dim.width / 2 - loginInternalFrame.getSize().width / 2, dim.height / 2 - loginInternalFrame.getSize().height / 2);
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

        //új alapanyag
        menuBar.addListener("newIngredient", event -> {
            IngredientFrame ingredientFrame = new IngredientFrame("Alapanyag", true, true, true, true);
            ingredientFrame.setSave(e1 -> {
                if (dao.saveIngredient(ingredientFrame.getValues())) {
                    ingredientFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(ingredientFrame);
            ingredientFrame.toFront();
        });

        //alapanyag lista
        menuBar.addListener("listIngredient", event -> {
            IngredientListFrame ingredientListFrame = new IngredientListFrame("Alapanyag lista", true, true, true, true);
            ingredientListFrame.setEdit(e1 -> {
                IngredientFrame ingredientFrame = new IngredientFrame("Alapanyag", true, true, true, true);
                ingredientFrame.setId(ingredientListFrame.getId());
                ingredientFrame.setSave(e2 -> {
                    if (dao.saveIngredient(ingredientFrame.getValues())) {
                        ingredientFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    ingredientListFrame.setValues(dao.getIngredientList()); //reload
                });
                ingredientFrame.setValues(dao.getIngredient(ingredientListFrame.getId()));
                desktopPane.add(ingredientFrame);
                ingredientFrame.toFront();
            });
            ingredientListFrame.setDelete(el -> {
                dao.deteleIngredient(ingredientListFrame.getId());
                ingredientListFrame.setValues(dao.getIngredientList());
            });
            ingredientListFrame.setValues(dao.getIngredientList());
            desktopPane.add(ingredientListFrame);
            ingredientListFrame.toFront();
        });

        //új szállító
        menuBar.addListener("newSupplier", event -> {
            SupplierFrame supplierFrame = new SupplierFrame("Szállító", true, true, true, true);
            supplierFrame.setSave(e1 -> {
                if (dao.saveSupplier(supplierFrame.getValues())) {
                    supplierFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(supplierFrame);
            supplierFrame.toFront();
        });

        //szállító lista
        menuBar.addListener("listSupplier", event -> {
            SupplierListFrame supplierListFrame = new SupplierListFrame("Szállító lista", true, true, true, true);
            supplierListFrame.setEdit(e1 -> {
                SupplierFrame supplierFrame = new SupplierFrame("Szállító", true, true, true, true);
                supplierFrame.setId(supplierListFrame.getId());
                supplierFrame.setSave(e2 -> {
                    if (dao.saveSupplier(supplierFrame.getValues())) {
                        supplierFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    supplierListFrame.setValues(dao.getSupplierList()); //reload
                });
                supplierFrame.setValues(dao.getSupplier(supplierListFrame.getId()));
                desktopPane.add(supplierFrame);
                supplierFrame.toFront();
            });
            supplierListFrame.setDelete(el -> {
                dao.deteleSupplier(supplierListFrame.getId());
                supplierListFrame.setValues(dao.getSupplierList());
            });
            supplierListFrame.setValues(dao.getSupplierList());
            desktopPane.add(supplierListFrame);
            supplierListFrame.toFront();
        });

        //új dolgozó
        menuBar.addListener("newWorker", event -> {
            WorkerFrame workerFrame = new WorkerFrame("Dolgozó", true, true, true, true);
            workerFrame.setSave(e1 -> {
                if (dao.saveWorker(workerFrame.getValues())) {
                    workerFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(workerFrame);
            workerFrame.toFront();
        });

        //dolgozó lista
        menuBar.addListener("listWorker", event -> {
            WorkerListFrame workerListFrame = new WorkerListFrame("Dolgozó lista", true, true, true, true);
            workerListFrame.setEdit(e1 -> {
                WorkerFrame workerFrame = new WorkerFrame("Dolgozó", true, true, true, true);
                workerFrame.setId(workerListFrame.getId());
                workerFrame.setSave(e2 -> {
                    if (dao.saveWorker(workerFrame.getValues())) {
                        workerFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                    workerListFrame.setValues(dao.getWorkerList()); //reload
                });
                workerFrame.setValues(dao.getWorker(workerListFrame.getId()));
                workerFrame.setAttendance(dao.getWorkersLog(workerListFrame.getId()));
                desktopPane.add(workerFrame);
                workerFrame.toFront();
            });
            workerListFrame.setDelete(el -> {
                dao.deleteWorker(workerListFrame.getId());
                workerListFrame.setValues(dao.getWorkerList());
            });
            workerListFrame.setValues(dao.getWorkerList());
            desktopPane.add(workerListFrame);
            workerListFrame.toFront();
        });

        //új jelenlét
        menuBar.addListener("newAttendance", event -> {
            PresenceFrame presenceFrame = new PresenceFrame("Jelenlét", true, true, true, true);
            presenceFrame.setSave(e1 -> {
                if ("SUCCES".equals(dao.savePresence(presenceFrame.getValues()).toString())) {
                    presenceFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            desktopPane.add(presenceFrame);
            presenceFrame.toFront();
        });

        //jelenlétilista
        menuBar.addListener("listAttendance", event -> {
            PresenceListFrame presenceListFrame = new PresenceListFrame("Jelenléti lista", true, true, true, true);
            presenceListFrame.setDelete(el -> {
                dao.deletePresence(presenceListFrame.getId());
                presenceListFrame.setValues(dao.getPresenceList(presenceListFrame.getDateInterval()));
            });
            presenceListFrame.setShow(el -> {
                presenceListFrame.setValues(dao.getPresenceList(presenceListFrame.getDateInterval()));
            });
            presenceListFrame.setValues(dao.getPresenceList(presenceListFrame.getDateInterval()));
            desktopPane.add(presenceListFrame);
            presenceListFrame.toFront();
        });

        //új terméktípus
        menuBar.addListener("newProductType", event -> {
            ProductTypeFrame productTypeFrame = new ProductTypeFrame("Terméktípus", true, true, true, true);
            productTypeFrame.setSave(e1 -> {
                if ("SUCCES".equals(dao.saveProductType(productTypeFrame.getValues()).toString())) {
                    productTypeFrame.dispose();
                } else {
                    //TODO ERROR
                }
            });
            productTypeFrame.setBrowseIngredientButton(e1 -> {
                BrowseIngredientTypeFrame browseIngredientTypeFrame = new BrowseIngredientTypeFrame("Alapanyag típus böngészés", true, true, true, true);
                browseIngredientTypeFrame.setTableValues(dao.getIngredientTypeList());
                browseIngredientTypeFrame.setSelect(e -> {
                    Map selectedItem = browseIngredientTypeFrame.getSelectedItem();
                    productTypeFrame.setSelectedIngredientTypeItem(selectedItem);
                    browseIngredientTypeFrame.dispose();
                });
                desktopPane.add(browseIngredientTypeFrame);
                browseIngredientTypeFrame.toFront();
            });
            productTypeFrame.setBrowseMachineButton(e1 -> {
                BrowseMachineFrame browseMachineFrame = new BrowseMachineFrame("Gép böngészés", true, true, true, true);
                browseMachineFrame.setTableValues(dao.getMachineList());
                browseMachineFrame.setSelect(e -> {
                    Map selectedItem = browseMachineFrame.getSelectedItem();
                    productTypeFrame.setSelectedMachineItem(selectedItem);
                    browseMachineFrame.dispose();
                });
                desktopPane.add(browseMachineFrame);
                browseMachineFrame.toFront();
            });
            desktopPane.add(productTypeFrame);
            productTypeFrame.toFront();
        });

        //terméktípus lista
        menuBar.addListener("listProductType", event -> {
            ProductTypeListFrame productTypeListFrame = new ProductTypeListFrame("Terméktípus lista", true, true, true, true);
            productTypeListFrame.setEdit(e1 -> {
                ProductTypeFrame productTypeFrame = new ProductTypeFrame("Terméktípus", true, true, true, true);
                productTypeFrame.setId(productTypeListFrame.getId());
                productTypeFrame.setValues(dao.getProductType(productTypeListFrame.getId()));
                productTypeFrame.setSave(e2 -> {
                    if ("SUCCES".equals(dao.saveProductType(productTypeFrame.getValues()).toString())) {
                        productTypeFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                });
                productTypeFrame.setBrowseIngredientButton(e2 -> {
                    BrowseIngredientTypeFrame browseIngredientTypeFrame = new BrowseIngredientTypeFrame("Alapanyag típus böngészés", true, true, true, true);
                    browseIngredientTypeFrame.setTableValues(dao.getIngredientTypeList());
                    browseIngredientTypeFrame.setSelect(e -> {
                        Map selectedItem = browseIngredientTypeFrame.getSelectedItem();
                        productTypeFrame.setSelectedIngredientTypeItem(selectedItem);
                        browseIngredientTypeFrame.dispose();
                    });
                    desktopPane.add(browseIngredientTypeFrame);
                    browseIngredientTypeFrame.toFront();
                });
                productTypeFrame.setBrowseMachineButton(e2 -> {
                    BrowseMachineFrame browseMachineFrame = new BrowseMachineFrame("Gép böngészés", true, true, true, true);
                    browseMachineFrame.setTableValues(dao.getMachineList());
                    browseMachineFrame.setSelect(e -> {
                        Map selectedItem = browseMachineFrame.getSelectedItem();
                        productTypeFrame.setSelectedMachineItem(selectedItem);
                        browseMachineFrame.dispose();
                    });
                    desktopPane.add(browseMachineFrame);
                    browseMachineFrame.toFront();
                });
                desktopPane.add(productTypeFrame);
                productTypeFrame.toFront();
            });
            productTypeListFrame.setDelete(el -> {
                dao.deleteProductType(productTypeListFrame.getId());
                productTypeListFrame.setValues(dao.getProductTypeList());
            });
            productTypeListFrame.setValues(dao.getProductTypeList());
            desktopPane.add(productTypeListFrame);
            productTypeListFrame.toFront();
        });

        //új terméktípus
        menuBar.addListener("newProduct", event -> {
            ProductFrame productFrame = new ProductFrame("Terméktípus", true, true, true, true);
            productFrame.setSave(e1 -> {
                if(productFrame.beforeSave()) {
                    if ("SUCCES".equals(dao.saveProduct(productFrame.getValues()).toString())) {
                        productFrame.dispose();
                    } else {
                        //TODO ERROR
                    }
                }else{
                    //TODO NOT SAVEABLE maxweight
                }
            });
            productFrame.setBrowseIngredientButton(e1 -> {
                BrowseIngredientFrame browseIngredientFrame = new BrowseIngredientFrame("Alapanyag böngészés", true, true, true, true);
                browseIngredientFrame.setTableValues(dao.getIngredientList());
                browseIngredientFrame.setSelect(e -> {
                    Map selectedItem = browseIngredientFrame.getSelectedItem();
                    productFrame.setSelectedIngredientItem(selectedItem);
                    browseIngredientFrame.dispose();
                });
                desktopPane.add(browseIngredientFrame);
                browseIngredientFrame.toFront();
            });
            desktopPane.add(productFrame);
            productFrame.toFront();
        });

        //termék lista
        menuBar.addListener("listProduct", event -> {
            ProductListFrame productListFrame = new ProductListFrame("Terméktípus lista", true, true, true, true);
            productListFrame.setShow(e2 -> {
                ProductFrame productFrame = new ProductFrame("Terméktípus", true, true, true, true);
                productFrame.setId(productListFrame.getId());
                desktopPane.add(productFrame);
                productFrame.toFront();
            });
            productListFrame.setValues(dao.getProductList());
            desktopPane.add(productListFrame);
            productListFrame.toFront();
        });
    }
}
