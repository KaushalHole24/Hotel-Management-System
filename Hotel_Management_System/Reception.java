package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    JButton customerForm, rooms, departments, allEmployees, customerInfo, managerInfo, checkout, updateStatus, roomStatus, pickupService, searchRoom, logout;
    
    Reception(){
        setLayout(null);

        customerForm = new JButton("New Customer Form");
        customerForm.setBounds(10, 30, 200, 30);
        customerForm.setBackground(Color.BLACK);
        customerForm.setForeground(Color.WHITE);
        customerForm.setOpaque(true);
        customerForm.setBorderPainted(false);
        customerForm.setFocusPainted(false);
        customerForm.addActionListener(this);
        add(customerForm);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setOpaque(true);
        rooms.setBorderPainted(false);
        rooms.setFocusPainted(false);
        rooms.addActionListener(this);
        add(rooms);

        departments = new JButton("Department");
        departments.setBounds(10, 110, 200, 30);
        departments.setBackground(Color.BLACK);
        departments.setForeground(Color.WHITE);
        departments.setOpaque(true);
        departments.setBorderPainted(false);
        departments.setFocusPainted(false);
        departments.addActionListener(this);
        add(departments);

        allEmployees = new JButton("All Employees");
        allEmployees.setBounds(10, 150, 200, 30);
        allEmployees.setBackground(Color.BLACK);
        allEmployees.setForeground(Color.WHITE);
        allEmployees.setOpaque(true);
        allEmployees.setBorderPainted(false);
        allEmployees.setFocusPainted(false);
        allEmployees.addActionListener(this);
        add(allEmployees);

        customerInfo = new JButton("Customer Info");
        customerInfo.setBounds(10, 190, 200, 30);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.setOpaque(true);
        customerInfo.setBorderPainted(false);
        customerInfo.setFocusPainted(false);
        customerInfo.addActionListener(this);
        add(customerInfo);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setOpaque(true);
        managerInfo.setBorderPainted(false);
        managerInfo.setFocusPainted(false);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setOpaque(true);
        checkout.setBorderPainted(false);
        checkout.setFocusPainted(false);
        checkout.addActionListener(this);
        add(checkout);

        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(10, 310, 200, 30);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.setOpaque(true);
        updateStatus.setBorderPainted(false);
        updateStatus.setFocusPainted(false);
        updateStatus.addActionListener(this);
        add(updateStatus);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.setOpaque(true);
        roomStatus.setBorderPainted(false);
        roomStatus.setFocusPainted(false);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickupService = new JButton("Pickup Service");
        pickupService.setBounds(10, 390, 200, 30);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.setOpaque(true);
        pickupService.setBorderPainted(false);
        pickupService.setFocusPainted(false);
        pickupService.addActionListener(this);
        add(pickupService);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setOpaque(true);
        searchRoom.setBorderPainted(false);
        searchRoom.setFocusPainted(false);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setOpaque(true);
        logout.setBorderPainted(false);
        logout.setFocusPainted(false);
        logout.addActionListener(this);
        add(logout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 200, 500, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == customerForm){

        }else if(ae.getSource() == rooms){

        }else if(ae.getSource() == departments){

        }else if(ae.getSource() == allEmployees){

        }else if(ae.getSource() == customerInfo){

        }else if(ae.getSource() == managerInfo){

        }else if(ae.getSource() == checkout){

        }else if(ae.getSource() == updateStatus){

        }else if(ae.getSource() == roomStatus){

        }else if(ae.getSource() == pickupService){

        }else if(ae.getSource() == searchRoom){

        }else if(ae.getSource() == logout){

        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
