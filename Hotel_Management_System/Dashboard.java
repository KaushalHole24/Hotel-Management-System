package Hotel_Management_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

    JMenu admin;
    JMenuItem addEmployee, addDrivers, addRooms;
    
    Dashboard(){
        setBounds(0, 0, 1550, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        String imagePath = "Icons/Dashboard.jpg";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("Reception");
        hotel.add(reception);

        // Admin Menu
        
        admin = new JMenu("Admin");
        mb.add(admin);

        addEmployee = new JMenuItem("Add Employee");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        addRooms = new JMenuItem("Add Rooms");
        addRooms.addActionListener(this);
        admin.add(addRooms);

        addDrivers = new JMenuItem("Add Drivers");
        addDrivers.addActionListener(this);
        admin.add(addDrivers);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addEmployee){
            // setVisible(false);
            new AddEmployee();
        } else if(ae.getSource() == addRooms){
            // setVisible(false);
            new AddRoom();
        } else if(ae.getSource() == addDrivers){
            setVisible(false);
        } 
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
}
