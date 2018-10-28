package GUI.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginFrame extends JInternalFrame {
    private JButton loginButton;
    private JLabel usernameText;
    private JTextField usernameInput;
    private JLabel passwordText;
    private JTextField passwordInput;

    public LoginFrame(String title, boolean resizable, boolean closable,
                      boolean maximizable, boolean iconifiable) {
        super(title,resizable,closable,maximizable,iconifiable);
        this.setBounds(10,10,200,200);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        loginButton = new JButton("Bejelentkezés");
        usernameText = new JLabel("Felhasználónév");
        usernameInput = new JTextField();
        passwordText = new JLabel("Jelszó");
        passwordInput = new JTextField();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(5,2));
        loginPanel.add(usernameText);
        loginPanel.add(usernameInput);
        loginPanel.add(passwordText);
        loginPanel.add(passwordInput);
        loginPanel.add(loginButton);
        this.setVisible(true);
        this.add(loginPanel);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public void addLoginButtonActionListener(ActionListener actionListener){
        this.loginButton.addActionListener(actionListener);
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
