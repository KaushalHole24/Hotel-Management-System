package Hotel_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem(){
        setBounds(20, 0, 1400, 800); //This can be used instead of setsize, setLocation;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); //By defalut it's margin layout
        
        String imagePath = "Icons/LandingPage.jpg";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1400, 800); //loctionX, locationY, length, breadth
        add(image);

        JButton next = new JButton("Next");
        next.setBounds(650, 650, 100, 40);
        next.setFont(new Font("tahoma", Font.PLAIN, 18));
        next.addActionListener(this);
        next.setBorderPainted(false);
        next.setFocusPainted(false);
        // next.setBackground(Color.BLACK);
        next.setOpaque(true);
        next.setForeground(Color.WHITE);
        image.add(next);
        
        setVisible(true); //By default frame is hiden from the user.

        while(true){
            next.setBackground(Color.BLACK);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }

            next.setBackground(Color.RED);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}