package Hotel_Management_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerInfo extends JFrame implements ActionListener {

    JButton cancel;
    JTable table;
    JScrollPane jsptable;
    
    ManagerInfo(){
        setLayout(null);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Age");
        model.addColumn("Salary");
        model.addColumn("Phone");
        model.addColumn("Email");

        table = new JTable(model);
        table.setBounds(20,20,500,300);
        add(table);


        jsptable = new JScrollPane(table);
        jsptable.setBounds(20,20,500,300);
        add(jsptable);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job='Manager'");

            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("age"),
                    rs.getString("salary"),
                    rs.getString("phone"),
                    rs.getString("email")
                });
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(30, 340, 90, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(200, 200, 600,700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}