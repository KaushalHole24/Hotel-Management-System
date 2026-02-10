package Hotel_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox<String> jbtype;
    JCheckBox cbcheck;
    JButton cancel, search;
    DefaultTableModel model;

    SearchRoom() {
        setLayout(null);

        JLabel lblroom = new JLabel("Search Room");
        lblroom.setBounds(320, 25, 200, 32);
        lblroom.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblroom.setForeground(Color.BLUE);
        add(lblroom);

        JLabel lblroomtype = new JLabel("Room bed type");
        lblroomtype.setBounds(40, 80, 100, 30);
        add(lblroomtype);

        String typeOption[] = { "Single Bed", "Double Bed" };
        jbtype = new JComboBox<String>(typeOption);
        jbtype.setBounds(150, 82, 120, 30);
        add(jbtype);

        cbcheck = new JCheckBox();
        cbcheck.setBounds(570, 80, 30, 30);
        add(cbcheck);

        JLabel lblcheck = new JLabel("Only display Available");
        lblcheck.setBounds(600, 80, 200, 30);
        add(lblcheck);

        model = new DefaultTableModel();
        model.addColumn("Room Number");
        model.addColumn("Availability");
        model.addColumn("Cleaning Status");
        model.addColumn("Price");
        model.addColumn("Bed Type");

        JTable table = new JTable(model);
        table.setBounds(50, 140, 700, 300);
        add(table);

        JScrollPane jsptable = new JScrollPane(table);
        jsptable.setBounds(50, 140, 700, 300);
        add(jsptable);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from rooms");

            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("roomNo"),
                        rs.getString("availablity"),
                        rs.getString("cleaning"),
                        rs.getString("rprice"),
                        rs.getString("bedtype")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.addActionListener(this);
        search.setBounds(50, 460, 100, 30);
        add(search);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(170, 460, 100, 30);
        add(cancel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String bedtype = (String)jbtype.getSelectedItem();
        Boolean avlcheck = cbcheck.isSelected();
        ResultSet rs;
        
        if(ae.getSource() == search){

                try{
                    String query1 = ("select * from rooms where bedtype = '"+bedtype+"'");
                    String query2 = ("select * from rooms where availablity = 'Available' and bedtype = '"+bedtype+"' ");
                    
                    Conn c = new Conn();

                    if(avlcheck){
                        rs = c.s.executeQuery(query2);
                    } else {
                        rs = c.s.executeQuery(query1);
                    }
                
                    model.setRowCount(0);
                    while(rs.next()){
                        model.addRow(new Object[]{
                            rs.getString("roomNo"),
                            rs.getString("availablity"),
                            rs.getString("cleaning"),
                            rs.getString("rprice"),
                            rs.getString("bedtype")
                        });
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
