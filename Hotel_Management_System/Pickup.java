package Hotel_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Pickup extends JFrame implements ActionListener {

    Choice cartype;
    JButton search, cancel;
    DefaultTableModel model;

    Pickup() {
        setLayout(null);

        JLabel heading = new JLabel("Pickup Service");
        heading.setBounds(230, 30, 140, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lbltype = new JLabel("Type of Car");
        lbltype.setBounds(30, 100, 80, 30);
        add(lbltype);

        cartype = new Choice();
        cartype.setBounds(120, 100, 120, 30);
        add(cartype);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from drivers");
            while (rs.next()) {
                cartype.add(rs.getString("model"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("Brand");
        model.addColumn("Model");
        model.addColumn("Availability");
        model.addColumn("Location");

        JTable table = new JTable(model);
        table.setBounds(50, 150, 500, 300);
        add(table);

        JScrollPane jsptable = new JScrollPane(table);
        jsptable.setBounds(50, 150, 500, 300);
        add(jsptable);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from drivers");

            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("company"),
                        rs.getString("model"),
                        rs.getString("availablity"),
                        rs.getString("location")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(70, 480, 100, 30);
        search.addActionListener(this);
        add(search);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 480, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        String path = "Icons/Pickup.jpg";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(path));
        Image i2 = i1.getImage().getScaledInstance(530, 550, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570,0,530,550);
        add(image);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 1100, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String carModel = cartype.getSelectedItem();

        if (ae.getSource() == search) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from drivers where model ='" + carModel + "' ");

                model.setRowCount(0);
                while (rs.next()) {
                    model.addRow(new Object[] {
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("company"),
                        rs.getString("model"),
                        rs.getString("availablity"),
                        rs.getString("location")
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Pickup();
    }
}
