package Hotel_Management_System;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AddDriver extends JFrame implements ActionListener {

    JLabel lblpage, lbldriver, lblage, lblgender, lblcompany, lblcarmodel, lblavailable, lbllocation;
    JTextField tfdriver, tfage, tfcompany, tfmodel, tflocation;
    JComboBox<String> cbgender, cbavailable;   
    JButton addriver, cancel;

    AddDriver(){
        setLayout(null);

        lblpage = new JLabel("Add Driver");
        lblpage.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblpage.setBounds(40, 20, 130,30);
        add(lblpage);

        lbldriver = new JLabel("Name");
        lbldriver.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldriver.setBounds(60, 60, 100, 30);
        add(lbldriver);

        tfdriver = new JTextField();
        tfdriver.setBounds(180, 60, 120, 30);
        add(tfdriver);

        lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 100, 100, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(180, 100, 120, 30);
        add(tfage);

        lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 140, 100, 30);
        add(lblgender);

        String genderoption[] = {"Male", "Female"};
        cbgender = new JComboBox<String>(genderoption);
        cbgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cbgender.setBounds(180, 140, 120, 30);
        add(cbgender);

        lblcompany = new JLabel("Car Company");
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcompany.setBounds(60, 180, 100, 30);
        add(lblcompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(180, 180, 120, 30);
        add(tfcompany);

        lblcarmodel = new JLabel("Car Model");
        lblcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcarmodel.setBounds(60, 220, 100, 30);
        add(lblcarmodel);

        tfmodel = new JTextField();
        tfmodel.setBounds(180, 220, 120, 30);
        add(tfmodel);

        lblavailable = new JLabel("Availablity");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 260, 100, 30);
        add(lblavailable);

        String availableoption[] = {"Available", "Busy"};
        cbavailable = new JComboBox<String>(availableoption);
        cbavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cbavailable.setBounds(180, 260, 120, 30);
        add(cbavailable);

        lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60, 300, 100, 30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(180, 300, 120, 30);
        add(tflocation);

        addriver = new JButton("Add Driver");
        addriver.setBounds(60, 360, 120, 30);
        addriver.addActionListener(this);
        addriver.setBackground(Color.BLACK);
        addriver.setForeground(Color.WHITE);
        addriver.setOpaque(true);
        addriver.setBorderPainted(false);
        addriver.setFocusPainted(false);
        add(addriver);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 360, 120, 30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        add(cancel);

        setBounds(200,200,350,520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String name = tfdriver.getText();
        String age = tfage.getText();
        String gender = (String)cbgender.getSelectedItem();
        String company = tfcompany.getText();
        String model = tfmodel.getText();
        String availablity = (String)cbavailable.getSelectedItem();
        String location = tflocation.getText();

        if(ae.getSource() == addriver){
            try{
                Conn c = new Conn();
                String query = "insert into drivers values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+availablity+"','"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver added successfully.");
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
