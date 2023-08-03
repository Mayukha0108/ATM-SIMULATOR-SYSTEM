
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw,back;
    String pin;
    
    Withdrawal(String pin) {
        
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text1 = new JLabel("Enter the amount you");
        text1.setForeground(Color.BLACK);
        text1.setFont(new Font("System",Font.BOLD,16));
        text1.setBounds(280,430,700,35);
        image.add(text1);
        
        JLabel text2 = new JLabel("want to Withdraw : ");
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("System",Font.BOLD,16));
        text2.setBounds(280,450,700,35);
        image.add(text2);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(277,482,230,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(408,540,90,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(408, 570, 90,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                
            }else {
                try {
                    Conn conn = new Conn();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawn Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                
                } catch(Exception e) {
                    System.out.println(e);
                }
                
            }
            
            
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } 
    }
    
    public static void main(String args[]) {
        new Withdrawal("");
    }
}

