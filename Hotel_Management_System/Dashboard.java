package Hotel_Management_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

    JMenu admin, hotel;
    JMenuItem addEmployee, addDrivers, addRooms, reception;
    JLabel text, image;
    
    Dashboard(){
        setBounds(0, 0, 1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        String imagePath = "Icons/Dashboard.jpg";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 1400, 800);
        add(image);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1400, 40);
        image.add(mb);

        // Hotel Menu

        hotel = new JMenu("Hotel Management");
        mb.add(hotel);

        reception = new JMenuItem("Reception");
        reception.addActionListener(this);
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
            new AddEmployee();
        } else if(ae.getSource() == addRooms){
            new AddRoom();
        } else if(ae.getSource() == addDrivers){
            new AddDriver();
        } else if(ae.getSource() == reception){
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
}
