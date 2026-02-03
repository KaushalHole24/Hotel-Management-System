package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    Login(){
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 20);
        add(user);

        JTextField username = new JTextField();
        username.setBounds(150, 20, 100, 20);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 20);
        add(pass);

        JTextField password = new JTextField();
        password.setBounds(150, 70, 100, 20);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setFocusPainted(false);
        add(login);
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(170, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        add(cancel);

        String imagePath = "Icons/Login.png";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(200, 200, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();        
    }
}
