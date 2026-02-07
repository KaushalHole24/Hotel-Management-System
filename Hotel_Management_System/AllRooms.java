package Hotel_Management_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AllRooms extends JFrame implements ActionListener {

    JTable table;
    JScrollPane sptable;
    JButton cancel;
    
    AllRooms(){
        setLayout(null);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Room No");
        model.addColumn("Avl Status");
        model.addColumn("Cleaning Status");
        model.addColumn("Room Price");
        model.addColumn("Bed Type");

        table = new JTable(model);
        table.setBounds(20, 40, 500, 300); 
        add(table);

        sptable = new JScrollPane(table);
        sptable.setBounds(20, 40, 500, 300);
        add(sptable);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from rooms");

            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("roomNo"),
                    rs.getString("availablity"),
                    rs.getString("cleaning"),
                    rs.getString("rprice"),
                    rs.getString("bedtype"),
                });
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(20, 370, 100,30);
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        add(cancel);

        setBounds(300, 200, 1050, 600);
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
        new AllRooms();
    }
}
