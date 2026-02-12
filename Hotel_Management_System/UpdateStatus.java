package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateStatus extends JFrame implements ActionListener {

    Choice cbroom;
    JButton check, update, cancel;
    JLabel lblheading, lblroom, lblid, lblname, lblcheckin, lblamt, lblpamt, lbladdamt;
    JLabel idResult, nameResult, checkinResult, amtResult, pamtResult;
    JTextField addpayment;

    UpdateStatus() {
        setLayout(null);

        lblheading = new JLabel("Update Status");
        lblheading.setBounds(230, 20, 150, 30);
        lblheading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblheading.setForeground(Color.BLUE);
        add(lblheading);

        lblroom = new JLabel("Allocated room number");
        lblroom.setBounds(30, 70, 150, 30);
        add(lblroom);

        cbroom = new Choice();
        cbroom.setBounds(200, 70, 80, 30);
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

        lblid = new JLabel("ID");
        lblid.setBounds(30, 120, 120, 30);
        add(lblid);

        // Output
        idResult = new JLabel();
        idResult.setBounds(200, 120, 150, 30);
        add(idResult);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 120, 30);
        add(lblname);

        // Output
        nameResult = new JLabel();
        nameResult.setBounds(200, 170, 150, 30);
        add(nameResult);

        lblcheckin = new JLabel("Check-in-time");
        lblcheckin.setBounds(30, 220, 120, 30);
        add(lblcheckin);

        // Output
        checkinResult = new JLabel();
        checkinResult.setBounds(200, 220, 250, 30);
        add(checkinResult);

        lblamt = new JLabel("Amount Paid");
        lblamt.setBounds(30, 270, 120, 30);
        add(lblamt);

        // Output
        amtResult = new JLabel();
        amtResult.setBounds(200, 270, 150, 30);
        add(amtResult);

        lblpamt = new JLabel("Pending Amount");
        lblpamt.setBounds(30, 320, 120, 30);
        add(lblpamt);

        // Output
        pamtResult = new JLabel();
        pamtResult.setBounds(200, 320, 150, 30);
        add(pamtResult);

        lbladdamt = new JLabel("Add Payment");
        lbladdamt.setBounds(30, 370, 120, 30);
        add(lbladdamt);

        // Input
        addpayment = new JTextField();
        addpayment.setBounds(200, 370, 120, 30);
        add(addpayment);

        check = new JButton("Check");
        check.setBounds(30, 420, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(160, 420, 100, 30);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(290, 420, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 520);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String checkRoom = cbroom.getSelectedItem();

        // String deposit = null;

        if (ae.getSource() == check) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from addCustomer where allocatedRoom = '" + checkRoom + "' ");

                while (rs.next()) {
                    idResult.setText(rs.getString("number"));
                    nameResult.setText(rs.getString("name"));
                    checkinResult.setText(rs.getString("checkinTime"));
                    amtResult.setText(rs.getString("deposit"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from rooms where roomNo = '" + checkRoom + "' ");
                while (rs2.next()) {
                    String price = rs2.getString("rprice");

                    int roomPrice = Integer.parseInt(price);
                    int deposit = Integer.parseInt(amtResult.getText());
                    int amtpending = roomPrice - deposit;

                    pamtResult.setText("" + amtpending);

                    if (deposit >= roomPrice) {
                        JOptionPane.showMessageDialog(null, "Full Payment Done");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {

            Conn c = new Conn();
            int deposit = 0;

            try {
                ResultSet rs2 = c.s
                        .executeQuery("select * from addCustomer where allocatedRoom = '" + checkRoom + "' ");

                while (rs2.next()) {
                    deposit = Integer.parseInt(rs2.getString("deposit"));
                }

                // User Input
                String adamt = addpayment.getText().trim();

                // Check if User Input is empty
                if (adamt.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter valid amount");
                    return;
                }
                int addamt = Integer.parseInt(adamt);
                String pamt = pamtResult.getText();

                // check if User Input is greater then pending amount
                if (addamt > Integer.parseInt(pamt)) {
                    JOptionPane.showMessageDialog(null, "Pending amount is " + pamt);
                    return;
                }
                int updateAmount = deposit + addamt;
                c.s.executeUpdate("update addCustomer set deposit = '" + updateAmount + "' where allocatedRoom = '"
                        + checkRoom + "' ");

                JOptionPane.showMessageDialog(null, "Payment Updated Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateStatus();
    }
}
