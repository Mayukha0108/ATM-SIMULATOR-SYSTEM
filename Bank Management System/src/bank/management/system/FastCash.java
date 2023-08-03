
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton deposit,withdrawal,ministmt,pinchange,fastcash,balenq,exit;
    String pin;
    
    FastCash(String pin) {
        
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(335,315,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(275,510,90,20);
        deposit.addActionListener(this);
        image.add(deposit);
                
        withdrawal = new JButton("Rs 500");
        withdrawal.setBounds(375,510,130,20);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(275,540,90,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministmt = new JButton("Rs 2000");
        ministmt.setBounds(375,540,130,20);
        ministmt.addActionListener(this);
        image.add(ministmt);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(273,570,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balenq = new JButton("Rs 10000");
        balenq.setBounds(377,570,128,20);
        balenq.addActionListener(this);
        image.add(balenq);
        
        exit = new JButton("BACK");
        exit.setBounds(430,595,80,20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit) {
            System.exit(0);
            new Transactions(pin).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin= '"+pin+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));           
                    }
                }
                
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pin).setVisible(true);
                
            } catch(Exception e){
                System.out.println(e);
            }
            
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
