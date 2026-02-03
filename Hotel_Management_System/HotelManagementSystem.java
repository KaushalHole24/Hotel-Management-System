package Hotel_Management_System;

import java.awt.*;
import javax.swing.*;

public class HotelManagementSystem extends JFrame{

    HotelManagementSystem(){
        // setSize(1366,565);
        // setLocation(100,100);
        setBounds(100, 100, 1366, 565); //This can be used instead of setsize, setLocation;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); //By defalut it's margin layout
        
        String imagePath = "Icons/Luxury.jpg";
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        JLabel image = new JLabel(il);
        image.setBounds(0,0,1366, 565); //loctionX, locationY, length, breadth
        add(image);

        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(next);
        
        setVisible(true); //By default frame is hiden from the user.

        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }

            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}