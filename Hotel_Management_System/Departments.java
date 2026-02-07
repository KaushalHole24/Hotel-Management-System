package Hotel_Management_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Departments extends JFrame implements ActionListener {

    JTable table;
    DefaultTableModel model;
    JScrollPane jsptable;
    JButton cancel;

    Departments(){
        setLayout(null);

        model = new DefaultTableModel();
        model.addColumn("Department");
        model.addColumn("Budget");

        table = new JTable(model);
        table.setBounds(20,40,500,300);
        add(table);

        jsptable = new JScrollPane(table);
        jsptable.setBounds(20, 40, 500, 300);
        add(jsptable);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");

            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("department"),
                    rs.getString("budget")
                });
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(30, 370, 100, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(200, 200, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Departments();
    }

}
