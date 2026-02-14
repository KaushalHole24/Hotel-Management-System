package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class AddEmployee extends JFrame implements ActionListener{

    JLabel lblname, lblage, lblgender, lblsalary, lbljob, lblphone, lblemail;
    JButton submit;
    JTextField tfname, tfage, tfsalary, tfphone, tfemail;
    JRadioButton rbmale, rbfemale;
    JComboBox<String> cbjob;

    AddEmployee() {
        setLayout(null);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 20, 80, 30);
        lblname.setFont(new Font("", Font.PLAIN, 20));;
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(120, 20, 140, 30);
        add(tfname);

        lblage = new JLabel("Age");
        lblage.setBounds(30, 60, 80, 30);
        lblage.setFont(new Font("", Font.PLAIN, 20));;
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(120, 60, 140, 30);
        add(tfage);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 100, 80, 30);
        lblgender.setFont(new Font("", Font.PLAIN, 20));;
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(120, 100, 80,40);
        rbmale.setFont(new Font("", Font.PLAIN, 15));
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(200, 100, 100,40);
        rbfemale.setFont(new Font("", Font.PLAIN, 15));
        add(rbfemale);

        ButtonGroup radio = new ButtonGroup();
        radio.add(rbfemale);
        radio.add(rbmale);

        lbljob = new JLabel("Job");
        lbljob.setBounds(30, 140, 80, 30);
        lbljob.setFont(new Font("", Font.PLAIN, 20));;
        add(lbljob);

        String role[] = {"Front Desk Clerk", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager"}; 
        cbjob = new JComboBox<String>(role);
        cbjob.setBounds(120, 140, 160, 30);
        add(cbjob);

        lblsalary = new JLabel("Salary");
        lblsalary.setBounds(30, 180, 80, 30);
        lblsalary.setFont(new Font("", Font.PLAIN, 20));;
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(120, 180, 140, 30);
        add(tfsalary);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 220, 80, 30);
        lblphone.setFont(new Font("", Font.PLAIN, 20));;
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(120, 220, 140, 30);
        add(tfphone);

        lblemail = new JLabel("Email");
        lblemail.setBounds(30, 260, 80, 30);
        lblemail.setFont(new Font("", Font.PLAIN, 20));;
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(120, 260, 140, 30);
        add(tfemail);

        submit = new JButton("Submit");
        submit.setBounds(120,300,140,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true);
        submit.setContentAreaFilled(true);
        submit.setBorderPainted(false);
        submit.setFocusPainted(false);
        submit.addActionListener(this);
        add(submit);

        String imgpath = "Icons/staff.png";
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(imgpath));
        Image i2 = i1.getImage().getScaledInstance(250, 220, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280, 80, 300, 250);
        add(image);

        setBounds(800, 400, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String email = tfemail.getText();
        String phone = tfphone.getText();

        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        } else {
            gender = "Not Disclosed";
        }

        String job = (String)cbjob.getSelectedItem();

        try{
            // Validation for form
            
           


            // Database Connection and query 
            Conn conn = new Conn();
            String query = "insert into employee values('"+name+"','"+gender+"','"+age+"','"+job+"','"+salary+"','"+phone+"','"+email+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added Successfully");
        } catch (Exception e){
            e.printStackTrace();
        }

        
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}