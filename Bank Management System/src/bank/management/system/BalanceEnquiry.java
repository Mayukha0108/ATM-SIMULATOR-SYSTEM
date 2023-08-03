
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pin;

    BalanceEnquiry(String pin) {
        
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image); 
                
        back = new JButton("Back");
        back.setBounds(420,580,85,25);
        back.addActionListener(this);
        image.add(back);
        
        
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin= '"+pin+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));           
                }
            }
        }
        catch(Exception e) {
                System.out.println(e);
          }
       
        JLabel text = new JLabel("Your Current Account Balance is : ");
        JLabel text1 = new JLabel("Rs " +balance);    
        text.setFont(new Font("System",Font.BOLD,13));
        text1.setFont(new Font("System", Font.BOLD,20));
        text.setForeground(Color.WHITE);
        text1.setForeground(Color.WHITE);
        text.setBounds(275,460,500,25); 
        text1.setBounds(300,490,500,25); 
        image.add(text);
        image.add(text1);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
        
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
