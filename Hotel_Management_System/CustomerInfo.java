package Hotel_Management_System;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerInfo extends JFrame implements ActionListener {

    JButton cancel;
    JTable table;
    JScrollPane jsptable;

    CustomerInfo(){
        setLayout(null);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Number");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Country");
        model.addColumn("Allocated Room");
        model.addColumn("Check-in-Time");
        model.addColumn("Deposit");

        table = new JTable(model);
        table.setBounds(20, 20, 500, 200);
        add(table);

        jsptable = new JScrollPane(table);
        jsptable.setBounds(20, 20, 500, 200);
        add(jsptable);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from addCustomer");

            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("number"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("country"),
                    rs.getString("allocatedRoom"),
                    rs.getString("checkinTime"),
                    rs.getString("deposit")
                });
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(20, 240, 100, 30);
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        add(cancel);

        setBounds(200, 200, 700, 700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}