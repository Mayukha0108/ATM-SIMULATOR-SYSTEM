package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton male,female,married,unmarried,other,syes,sno,eyes,eno;
    JComboBox religion,income,education,occupation;
    String formno;
    
    SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails= new JLabel("Page 1: Additional Details ");
        additionalDetails.setFont((new Font("Raleway", Font.BOLD,22)));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name= new JLabel("Religion : ");
        name.setFont((new Font("Raleway", Font.BOLD,20)));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
       
//        nametf = new JTextField();
//        nametf.setFont(new Font("Raleway", Font.BOLD, 14));
       
        
//        JLabel fname= new JLabel("Category : ");
//        fname.setFont((new Font("Raleway", Font.BOLD,20)));
//        fname.setBounds(100,190,200,30);
//        add(fname);
//        
//        fnametf = new JTextField();
//        fnametf.setFont(new Font("Raleway", Font.BOLD, 14));
//        fnametf.setBounds(300,190,400,30);
//        add(fnametf);
        
        JLabel dob= new JLabel("Income : ");
        dob.setFont((new Font("Raleway", Font.BOLD,20)));
        dob.setBounds(100,190,200,30);
        add(dob);
        
        String incomeCat[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCat);
        income.setBounds(300,190,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender= new JLabel("Educational ");
        gender.setFont((new Font("Raleway", Font.BOLD,20)));
        gender.setBounds(100,240,200,30);
        add(gender);
    
        JLabel email= new JLabel("Qualification : ");
        email.setFont((new Font("Raleway", Font.BOLD,20)));
        email.setBounds(100,265,200,30);
        add(email);
        
        String eduVal[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        education = new JComboBox(eduVal);
        education.setBounds(300,265,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marit= new JLabel("Occupation : ");
        marit.setFont((new Font("Raleway", Font.BOLD,20)));
        marit.setBounds(100,340,200,30);
        add(marit);
        
        String occVal[] = {"Salaried","Self-Employed","Business","Student","Others"};
        occupation = new JComboBox(occVal);
        occupation.setBounds(300,340,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
       
        JLabel address= new JLabel("PAN Number : ");
        address.setFont((new Font("Raleway", Font.BOLD,20)));
        address.setBounds(100,390,200,30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,390,400,30);
        add(pan);
        
        JLabel city= new JLabel("Aadhar Number : ");
        city.setFont((new Font("Raleway", Font.BOLD,20)));
        city.setBounds(100,440,200,30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,440,400,30);
        add(aadhar);
        
        JLabel state= new JLabel("Senior Citizen : ");
        state.setFont((new Font("Raleway", Font.BOLD,20)));
        state.setBounds(100,490,200,30);
        add(state);
        
        syes = new JRadioButton("Yes");  
        syes.setBounds(300,490,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No"); 
        sno.setBounds(450,490,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);
        
        JLabel pincode= new JLabel("Existing Account : ");
        pincode.setFont((new Font("Raleway", Font.BOLD,20)));
        pincode.setBounds(100,540,200,30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");  
        eyes.setBounds(300,540,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No"); 
        eno.setBounds(450,540,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,620,80,30);
        next.addActionListener(this);
        add(next);       
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String sreligion =(String)religion.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
                
        String seniorcitizen = null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        }
        else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()) {
            existingaccount = "Yes";
        }
        else if(eno.isSelected())
        {
            existingaccount = "No";
        }
            
        String saadhar = aadhar.getText();
        String span = pan.getText();
        
        try {
            Conn c = new Conn();
            String query = "Insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            //Signup3 Object
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
       new SignupTwo("");
    }
}
