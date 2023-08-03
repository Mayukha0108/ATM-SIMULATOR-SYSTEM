
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdrawal,ministmt,pinchange,fastcash,balenq,exit;
    String pin;
    
    Transactions(String pin) {
        
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction : ");
        text.setBounds(335,315,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(275,510,90,20);
        deposit.addActionListener(this);
        image.add(deposit);
                
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(375,510,130,20);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(275,540,90,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministmt = new JButton("Mini Statement");
        ministmt.setBounds(375,540,130,20);
        ministmt.addActionListener(this);
        image.add(ministmt);
        
        pinchange = new JButton("Change Pin");
        pinchange.setBounds(273,570,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balenq = new JButton("Balance Enquiry");
        balenq.setBounds(377,570,128,20);
        balenq.addActionListener(this);
        image.add(balenq);
        
        exit = new JButton("Exit");
        exit.setBounds(430,595,80,20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit) {
            System.exit(0);
        }
        else if(ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);      
        } else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }
        else if(ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if(ae.getSource()== pinchange) {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        } else if(ae.getSource() == balenq){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if(ae.getSource() == ministmt) {
            new MiniStatement(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transactions("");
    }
}
