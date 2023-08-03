package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nametf,fnametf, emailtf,addtf,statetf,citytf,pintf;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    
    SignupOne() {
        
        setLayout(null);
        
        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont((new Font("Raleway", Font.BOLD,38)));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails= new JLabel("Page 1: Personal Details ");
        personalDetails.setFont((new Font("Raleway", Font.BOLD,22)));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name= new JLabel("Name : ");
        name.setFont((new Font("Raleway", Font.BOLD,20)));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 14));
        nametf.setBounds(300,140,400,30);
        add(nametf);
        
        JLabel fname= new JLabel("Father's Name : ");
        fname.setFont((new Font("Raleway", Font.BOLD,20)));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametf.setBounds(300,190,400,30);
        add(fnametf);
        
        JLabel dob= new JLabel("Date of Birth : ");
        dob.setFont((new Font("Raleway", Font.BOLD,20)));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender= new JLabel("Gender : ");
        gender.setFont((new Font("Raleway", Font.BOLD,20)));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");  
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female"); 
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email= new JLabel("Email Address : ");
        email.setFont((new Font("Raleway", Font.BOLD,20)));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtf.setBounds(300,340,400,30);
        add(emailtf);
        
        JLabel marit= new JLabel("Marital Status : ");
        marit.setFont((new Font("Raleway", Font.BOLD,20)));
        marit.setBounds(100,390,200,30);
        add(marit);
        
        married = new JRadioButton("Married");  
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried"); 
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other"); 
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);        
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        JLabel address= new JLabel("Address : ");
        address.setFont((new Font("Raleway", Font.BOLD,20)));
        address.setBounds(100,440,200,30);
        add(address);
        
        addtf = new JTextField();
        addtf.setFont(new Font("Raleway", Font.BOLD, 14));
        addtf.setBounds(300,440,400,30);
        add(addtf);
        
        JLabel city= new JLabel("City : ");
        city.setFont((new Font("Raleway", Font.BOLD,20)));
        city.setBounds(100,490,200,30);
        add(city);
        
        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 14));
        citytf.setBounds(300,490,400,30);
        add(citytf);
        
        JLabel state= new JLabel("State : ");
        state.setFont((new Font("Raleway", Font.BOLD,20)));
        state.setBounds(100,540,200,30);
        add(state);
        
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 14));
        statetf.setBounds(300,540,400,30);
        add(statetf);
        
        JLabel pincode= new JLabel("Pin Code : ");
        pincode.setFont((new Font("Raleway", Font.BOLD,20)));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pintf = new JTextField();
        pintf.setFont(new Font("Raleway", Font.BOLD, 14));
        pintf.setBounds(300,590,400,30);
        add(pintf);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);       
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nametf.getText();
        String fname = fnametf.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        }
        else if (female.isSelected()) {
            gender = "Female";
        }
        
        String email = emailtf.getText();
        
        String marit = null;
        if(married.isSelected()) {
            marit = "Married";
        }
        else if(unmarried.isSelected())
        {
            marit = "Unmarried";
        }
        else if(other.isSelected()) {
            marit = "Other";
        }
            
        String address = addtf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pin = pintf.getText();
        
        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Conn c = new Conn();
                String query = "Insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marit+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
       new SignupOne();
    }
}
