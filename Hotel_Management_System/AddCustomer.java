package Hotel_Management_System;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel lblheading, lblid, lblnumber, lblname, lblgender, lblcountry, lblroomno, lblcheckin, lbldeposit;
    JButton addcustomer, back;
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JComboBox<String> cbid;
    Choice croom;
    JRadioButton rdmale, rdfemale;

    AddCustomer() {
        setLayout(null);

        lblheading = new JLabel("NEW CUSTOMER FORM");
        lblheading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblheading.setForeground(Color.BLUE);
        lblheading.setBounds(80, 30, 250, 30);
        add(lblheading);

        lblid = new JLabel("ID");
        lblid.setBounds(30, 80, 120, 30);
        add(lblid);

        String idoption[] = {"Passport", "Voter ID", "Adhaar Card", "Pan Card", "Driving Licence"};
        cbid = new JComboBox<String>(idoption);
        cbid.setBounds(160, 80, 150, 30);
        add(cbid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 120, 120, 30);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(160,120,150,30);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(160,160,150,30);
        add(tfname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 200, 120, 30);
        add(lblgender);

        rdmale = new JRadioButton("Male");
        rdmale.setBounds(160, 200, 80,30);
        add(rdmale);

        rdfemale = new JRadioButton("Female");
        rdfemale.setBounds(240, 200, 80, 30);
        add(rdfemale);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 240, 120, 30);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(160,240,150,30);
        add(tfcountry);

        lblroomno = new JLabel("Allocated Room");
        lblroomno.setBounds(30, 280, 120, 30);
        add(lblroomno);

        // String idoption[] = {"Passport", "Voter ID", "Adhaar Card", "Pan Card", "Driving Licence"};
        croom = new Choice();
        croom.setBounds(160, 280, 150, 30);
        add(croom);

        lblcheckin = new JLabel("Check-in-time");
        lblcheckin.setBounds(30, 320, 120, 30);
        add(lblcheckin);

        lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(30, 360, 120, 30);
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(160,360,150,30);
        add(tfdeposit);

        setBounds(350, 200, 700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
