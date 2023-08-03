
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pinnum, repin;
    JButton change,back;
    String pin;
    
    PinChange(String pin){
        this.pin=pin;
//        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =  new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,20));
        text.setBounds(350,300,500,25);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN : ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        pintext.setBounds(280,420,500,25);
        image.add(pintext);
        
        pinnum = new JPasswordField();
        pinnum.setFont(new Font("Raleway",Font.BOLD,25));
        pinnum.setBounds(365,420,130,25);
        image.add(pinnum);
        
        JLabel repintext = new JLabel("Re-enter New PIN : ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        repintext.setBounds(280,460,500,25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(360,490,130,25);
        image.add(repin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(410,530,85,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(410,560,85,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
        try {
            String npin = pinnum.getText();
            String rpin = repin.getText();
            if(!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
                return;
            } if(rpin.equals("")) {
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pin='"+rpin+"' where pin='"+pin+"'";
            String query2 = "update login set pin='"+rpin+"' where pin='"+pin+"'";
            String query3 = "update signupthree set pin='"+rpin+"' where pin='"+pin+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"PIN changed successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        } catch(Exception e) {
           System.out.println(e);
        }
        } else {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {
       new PinChange("").setVisible(true);
    }
}
