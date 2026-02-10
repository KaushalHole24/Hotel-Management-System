package Hotel_Management_System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateRoomStatus extends JFrame implements ActionListener{

    JButton check, update, cancel;
    Choice roomNumber, avlStatus, cleanStatus;
    JLabel avlStatusResult, cleanStatusResult;
    JComboBox<String> cbavl, cbclean;
    
    UpdateRoomStatus(){
        setLayout(null);

        JLabel heading = new JLabel("Room Status");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.PLAIN ,20));
        heading.setBounds(30,30,150,30);
        add(heading);                                                                               

        JLabel room = new JLabel("Room Number");
        room.setBounds(30,80,100,30);
        add(room); 

        roomNumber = new Choice();
        roomNumber.setBounds(150, 80, 100,30);
        add(roomNumber);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from rooms");

            while(rs.next()){
                roomNumber.add(rs.getString("roomNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(30,120,100,30);
        add(availability); 

        avlStatusResult = new JLabel();
        avlStatusResult.setBounds(150,120,100,30);
        add(avlStatusResult); 
        
        JLabel cleaning = new JLabel("Cleaning Status");
        cleaning.setBounds(30,160,100,30);
        add(cleaning); 

        cleanStatusResult = new JLabel();
        cleanStatusResult.setBounds(150,160,100,30);
        add(cleanStatusResult); 

        check = new JButton("Check");
        check.addActionListener(this);
        check.setBounds(30, 220, 100, 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setFocusPainted(false);
        check.setBorderPainted(false);
        check.setOpaque(true);
        add(check);

        JLabel updateavailability = new JLabel("Update Availability Status");
        updateavailability.setBounds(30,270,170,30);
        add(updateavailability);

        String avlOption[] = {" ", "Available", "Occupied"};
        cbavl = new JComboBox<>(avlOption);
        cbavl.setBounds(220,270,100,30);
        add(cbavl);
        
        JLabel updatecleaning = new JLabel("Update Cleaning Status");
        updatecleaning.setBounds(30,320,150,30);
        add(updatecleaning); 

        String cleanOption[] = {" ", "Dirty", "Cleaned"};
        cbclean = new JComboBox<>(cleanOption);
        cbclean.setBounds(220,320,100,30);
        add(cbclean);

        update = new JButton("Update");
        update.addActionListener(this);
        update.setBounds(30, 370, 100, 30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setFocusPainted(false);
        update.setBorderPainted(false);
        update.setOpaque(true);
        add(update);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(150, 370, 100, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(true);
        add(cancel);

        setBounds(200,200, 600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        Conn c = new Conn();
        ResultSet rs;
        String roomNo = roomNumber.getSelectedItem(); 

        if(ae.getSource() == check){
            try{
                rs = c.s.executeQuery("select * from rooms where roomNo = '"+roomNo+"' ");
                while(rs.next()){
                    avlStatusResult.setText(rs.getString("availablity"));
                    cleanStatusResult.setText(rs.getString("cleaning"));
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        } else if(ae.getSource() == update){
            String avlupdate = (String)cbavl.getSelectedItem();
            String cleanupdate = (String)cbclean.getSelectedItem();
            try{
                c.s.executeUpdate("update rooms set availablity = '"+avlupdate+"', cleaning = '"+cleanupdate+"' where roomNo = '"+roomNo+"' ");
                JOptionPane.showMessageDialog(null,"Status Updated Successfully");
            } catch(Exception e){
                e.printStackTrace();
            }

        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new UpdateRoomStatus();
    }
}
