package Hotel_Management_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel lblheading, lblid, lblnumber, lblname, lblgender, lblcountry, lblroomno, lblcheckin, lbldeposit, checkintime;
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

        String idoption[] = { "Passport", "Voter ID", "Adhaar Card", "Pan Card", "Driving Licence" };
        cbid = new JComboBox<String>(idoption);
        cbid.setBounds(160, 80, 150, 30);
        add(cbid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 120, 120, 30);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(160, 120, 150, 30);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(160, 160, 150, 30);
        add(tfname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 200, 120, 30);
        add(lblgender);

        rdmale = new JRadioButton("Male");
        rdmale.setBounds(160, 200, 80, 30);
        add(rdmale);

        rdfemale = new JRadioButton("Female");
        rdfemale.setBounds(240, 200, 80, 30);
        add(rdfemale);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 240, 120, 30);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(160, 240, 150, 30);
        add(tfcountry);

        lblroomno = new JLabel("Allocated Room");
        lblroomno.setBounds(30, 280, 120, 30);
        add(lblroomno);

        croom = new Choice();
        croom.setBounds(160, 280, 150, 30);
        add(croom);

        try {
            Conn c = new Conn();
            String query = "select * from rooms where availablity='Available'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblcheckin = new JLabel("Check-in-time");
        lblcheckin.setBounds(30, 320, 120, 30);
        add(lblcheckin);

        Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("E, MMM dd yyyy hh:mm:ss a");
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String newDate = sdf.format(date);
        checkintime = new JLabel("" + newDate);
        checkintime.setBounds(160, 320, 200, 30);
        add(checkintime);

        lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(30, 360, 120, 30);
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(160, 360, 150, 30);
        add(tfdeposit);

        addcustomer = new JButton("Add");
        addcustomer.setBounds(30, 420, 120, 40);
        addcustomer.setForeground(Color.WHITE);
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setOpaque(true);
        addcustomer.setBorderPainted(false);
        addcustomer.setFocusPainted(false);
        addcustomer.addActionListener(this);
        add(addcustomer);

        back = new JButton("Back");
        back.setBounds(180, 420, 120, 40);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setOpaque(true);
        back.addActionListener(this);
        add(back);

        String path = "Icons/CustomerForm.jpg";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(path));
        Image i2 = i1.getImage().getScaledInstance(500, 520, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330,0,500,520);
        add(image);

        setBounds(350, 200, 700, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String id = (String)cbid.getSelectedItem();
        String number = tfnumber.getText();
        String name = tfname.getText();
        String gender = null;
        if(rdmale.isSelected()){
            gender = "Male";
        } else if(rdfemale.isSelected()){
            gender = "Female";
        }

        String country = tfcountry.getText();
        String allocatedRoom = croom.getSelectedItem();
        String checkin = checkintime.getText();
        String deposit = tfdeposit.getText();

        if (ae.getSource() == addcustomer) {
            try {
                Conn c = new Conn();
                String query = "insert into addCustomer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+allocatedRoom+"','"+checkin+"','"+deposit+"')";
                String query2 = "update rooms set availablity='Occupied' where roomNo='"+allocatedRoom+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
