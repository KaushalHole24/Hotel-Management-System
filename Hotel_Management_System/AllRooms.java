package Hotel_Management_System;

import java.awt.Color;
import java.awt.Image;
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
        table.setBounds(20, 20, 500, 300); 
        add(table);

        sptable = new JScrollPane(table);
        sptable.setBounds(20, 20, 500, 300);
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
        cancel.setBounds(20, 340, 100,30);
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        add(cancel);

        String path = "Icons/AllRooms.jpg";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(path));
        Image i2 = i1.getImage().getScaledInstance(580, 450, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(530,0,580,450);
        add(image);

        setBounds(300, 200, 1000, 420);
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
