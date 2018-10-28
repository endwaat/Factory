package GUI.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFrame extends JInternalFrame {
    private JButton save;
    private JLabel usernameText;
    private JTextField usernameInput;
    private JLabel passwordText;
    private JTextField passwordInput;
    private JLabel emailText;
    private JTextField emailInput;

    public ProfileFrame(String title, boolean resizable, boolean closable,
                        boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 200, 200);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        save = new JButton("Mentés");
        usernameText = new JLabel("Felhasználónév");
        usernameInput = new JTextField();
        passwordText = new JLabel("Jelszó");
        passwordInput = new JTextField();
        emailText = new JLabel("Felhasználónév");
        emailInput = new JTextField();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        loginPanel.add(usernameText);
        loginPanel.add(usernameInput);
        loginPanel.add(passwordText);
        loginPanel.add(passwordInput);
        loginPanel.add(emailText);
        loginPanel.add(emailInput);
        loginPanel.add(save);
        this.setVisible(true);
        this.add(loginPanel);
    }

    public JButton getSave() {
        return save;
    }

    public void setSave(JButton save) {
        this.save = save;
    }

    public void addSaveAL(ActionListener actionListener) {
        this.save.addActionListener(actionListener);
    }

    public JLabel getUsernameText() {
        return usernameText;
    }

    public void setUsernameText(JLabel usernameText) {
        this.usernameText = usernameText;
    }

    public JTextField getUsernameInput() {
        return usernameInput;
    }

    public void setUsernameInput(JTextField usernameInput) {
        this.usernameInput = usernameInput;
    }

    public JLabel getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(JLabel passwordText) {
        this.passwordText = passwordText;
    }

    public JTextField getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(JTextField passwordInput) {
        this.passwordInput = passwordInput;
    }
}
