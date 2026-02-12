package Hotel_Management_System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Checkout extends JFrame implements ActionListener {

    Choice cbroom;
    JButton checkoutbtn, cancel, getDetails;
    JLabel rname, rcheckin, rpending;

    Checkout() {
        setLayout(null);

        JLabel heading = new JLabel("Checkout");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setBounds(50, 30, 100, 30);
        add(heading);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(20, 100, 100, 30);
        add(lblroom);

        cbroom = new Choice();
        cbroom.setBounds(150, 100, 100, 30);
        add(cbroom);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from addCustomer");
            while (rs.next()) {
                cbroom.add(rs.getString("allocatedRoom"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20, 150, 100, 30);
        add(lblname);

        rname = new JLabel();
        rname.setBounds(150, 150, 100, 30);
        add(rname);

        JLabel lblcheckin = new JLabel("Check-in-time");
        lblcheckin.setBounds(20, 200, 100, 30);
        add(lblcheckin);

        rcheckin = new JLabel();
        rcheckin.setBounds(150, 200, 100, 30);
        add(rcheckin);

        JLabel lblcheckout = new JLabel("Check-out-time");
        lblcheckout.setBounds(20, 250, 110, 30);
        add(lblcheckout);

        Date checkout = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E, MMM dd yyyy hh:mm:ss a");
        String newDate = sdf.format(checkout);
        JLabel checkouttime = new JLabel("" + newDate);
        checkouttime.setBounds(150, 250, 170, 30);
        add(checkouttime);

        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(20, 300, 110, 30);
        add(lblpending);

        rpending = new JLabel();
        rpending.setBounds(150, 300, 100, 30);
        add(rpending);

        getDetails = new JButton("Get Details");
        getDetails.setBounds(30, 350, 120, 30);
        getDetails.addActionListener(this);
        add(getDetails);

        checkoutbtn = new JButton("Checkout");
        checkoutbtn.setBounds(170, 350, 100, 30);
        checkoutbtn.addActionListener(this);
        add(checkoutbtn);

        cancel = new JButton("Cancel");
        cancel.setBounds(290, 350, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String roomNo = cbroom.getSelectedItem();
        Conn c = new Conn();
        ResultSet rs, rs2;
        String deposit = null;

        if (ae.getSource() == getDetails) {
            try {
                rs = c.s.executeQuery("select * from addCustomer where allocatedRoom = '" + roomNo + "' ");
                while(rs.next()) {
                    rname.setText(rs.getString("name"));
                    rcheckin.setText(rs.getString("checkinTime"));
                    deposit = rs.getString("deposit");
                } 

                rs2 = c.s.executeQuery("select * from rooms where roomNo = '" + roomNo + "' ");
                while(rs2.next()){
                    int roomPrice = Integer.parseInt(rs2.getString("rprice"));
                    int depositAmt = Integer.parseInt(deposit);
                    int pendingAmt = roomPrice - depositAmt;
                    rpending.setText(""+pendingAmt);
                }       
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == checkoutbtn) {

            try {
                String pendingAmt = rpending.getText();
                

                String query1 = "delete from addCustomer where allocatedRoom = '" + roomNo + "' ";
                String query2 = "update rooms set availablity = 'Available', cleaning = 'Dirty' where roomNo = '"
                        + roomNo + "' ";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
