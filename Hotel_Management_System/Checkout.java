package Hotel_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Checkout extends JFrame implements ActionListener {
    
    Checkout(){
        JLabel heading = new JLabel("Checkout");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setBounds(50, 30, 100, 30);
        add(heading);
    }
    
    public void actionPerformed(ActionEvent ae){
         
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
