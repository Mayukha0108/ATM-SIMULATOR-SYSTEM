package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField  pinTextField;;
    
    Login() {
        
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,20,100,100);
        add(label);
      
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,50,400,40);
        text.setFont(new Font("Osward", Font.BOLD,38));
        add(text);
        
        JLabel cardno = new JLabel("Card No : ");
        cardno.setBounds(120,145,200,30);
        cardno.setFont(new Font("Raleway", Font.BOLD,38));
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(350,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(cardTextField);
                
        JLabel pin = new JLabel("PIN : ");
        pin.setBounds(120, 220,230,30);
        pin.setFont(new Font("Raleway", Font.BOLD,38));
        add(pin);    
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 225,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(350,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(480,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(350,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == clear) {
           cardTextField.setText("");
           pinTextField.setText("");
       } else if(ae.getSource() == login) {
           Conn conn = new Conn();
           String cardnumber = cardTextField.getText();
           String pin = pinTextField.getText();
           String query = "select * from login where cardnumber='"+cardnumber+"' and pin = '"+pin+"'";
           try {
              ResultSet rs = conn.s.executeQuery(query);
              if(rs.next()) {
                  setVisible(false);
                  new Transactions(pin).setVisible(true);
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
              }
           } catch(Exception e) {
               System.out.println(e);
           }
       } else if(ae.getSource() == signup) {
           setVisible(false);
           new SignupOne().setVisible(true);
       }
    }
    
    public static void main(String args[]) {
          new Login();
    }
}
