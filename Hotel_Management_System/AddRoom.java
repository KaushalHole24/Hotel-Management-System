package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    JLabel heading, lblroomno, lblavailable, lblclean, lblprice, lbltype;
    JTextField tfroomno, tfprice;
    JComboBox<String> cbavailable, cbclean, cbtype;
    JButton addroom, cancel;

    AddRoom() {
        setLayout(null);

        heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(80, 20, 220, 30);
        add(heading);

        lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(120, 60, 120, 20);
        add(lblroomno);

        tfroomno = new JTextField();
        tfroomno.setBounds(260, 60, 120, 20);
        add(tfroomno);

        lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(120, 100, 120, 20);
        add(lblavailable);

        String availableOption[] = { "Available", "Occupied" };
        cbavailable = new JComboBox<String>(availableOption);
        cbavailable.setBounds(260, 100, 120, 20);
        add(cbavailable);

        lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(120, 140, 120, 20);
        add(lblclean);

        String cleanOption[] = { "Cleaned", "Dirty" };
        cbclean = new JComboBox<String>(cleanOption);
        cbclean.setBounds(260, 140, 120, 20);
        add(cbclean);

        lblprice = new JLabel("Room Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(120, 180, 120, 20);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(260, 180, 120, 20);
        add(tfprice);

        lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(120, 220, 120, 20);
        add(lbltype);

        String typeOption[] = { "Single Bed", "Double Bed" };
        cbtype = new JComboBox<String>(typeOption);
        cbtype.setBounds(260, 220, 120, 20);
        add(cbtype);

        addroom = new JButton("Add Room");
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.setOpaque(true);
        addroom.setBorderPainted(false);
        addroom.setFocusPainted(false);
        addroom.setBounds(120, 260, 120, 30);
        addroom.addActionListener(this);
        add(addroom);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.setBounds(260, 260, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(300, 200, 400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String roomno = tfroomno.getText();
        String price = tfprice.getText();
        String available = (String) cbavailable.getSelectedItem();
        String cleaning = (String) cbclean.getSelectedItem();
        String bedtype = (String) cbtype.getSelectedItem();

        if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == addroom) {
            try {
                Conn c = new Conn();
                String query = "insert into rooms values('" + roomno + "','" + available + "','" + cleaning + "','"
                        + price + "','" + bedtype + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
