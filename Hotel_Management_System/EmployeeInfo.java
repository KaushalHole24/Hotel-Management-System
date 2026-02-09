package Hotel_Management_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeInfo extends JFrame implements ActionListener {

    JButton cancel;
    
    EmployeeInfo(){
        setLayout(null);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Age");
        model.addColumn("Job");
        model.addColumn("Salary");
        model.addColumn("Phone");
        model.addColumn("Email");

        JTable table = new JTable(model);
        table.setBounds(20, 40, 600, 300);
        add(table);

        JScrollPane sptable = new JScrollPane(table);
        sptable.setBounds(20, 40, 600, 300);
        add(sptable);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("age"),
                    rs.getString("job"),
                    rs.getString("salary"),
                    rs.getString("phone"),
                    rs.getString("email")
                });
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(30, 370, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);
        add(cancel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
