package hotel.management.system;



import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    JComboBox c1; // inside swing package
    Choice c2; // inside swings
    JRadioButton r1,r2;
    AddCustomer()
    {
        JLabel l1=new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(110,20,300,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        JLabel l2=new JLabel("ID");
        l2.setBounds(35,80,100,20);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l2);
        c1=new JComboBox(new String[]{"Passport","Voter-id Card","Driving License","Aadhar Card"});
        c1.setBounds(180,80,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);
       
        
        JLabel l3=new JLabel("Number");
        l3.setBounds(35,120,100,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l3);
        t1=new JTextField();
        t1.setBounds(180,120,150,25);
        add(t1);
       
        
        JLabel l4=new JLabel("Name");
        l4.setBounds(35,160,100,20);
        l4.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l4);
        t2=new JTextField();
        t2.setBounds(180,160,150,25);
        add(t2);
       
      
        JLabel l5=new JLabel("Gender");
        l5.setBounds(35,200,100,20);
        l5.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l5);
        r1=new JRadioButton("Male");
        r1.setBounds(180,200,60,20);
        add(r1);
        r1.setBackground(Color.WHITE);
        r2=new JRadioButton("Female");
        r2.setBounds(250,200,80,20);
        add(r2);
        r2.setBackground(Color.WHITE);
      
        
        JLabel l6=new JLabel("Country");
        l6.setBounds(35,240,100,20);
        l6.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l6);
        t3=new JTextField();
        t3.setBounds(180,240,150,25);
        add(t3);
        
        JLabel l7=new JLabel("Room Number");
        l7.setBounds(35,280,100,20);
        l7.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l7);
         c2=new Choice();
         try{
             conn c=new conn();
             String str="Select * from room";
             ResultSet rs=c.s.executeQuery(str);
             while(rs.next())
             {
                 c2.add(rs.getString("room_number")); //get specified string
             }
         }
         catch(Exception e){
             
         }
         c2.setBounds(180 ,280,150,30);
         add(c2);
        
        JLabel l8=new JLabel("Checked In");
        l8.setBounds(35,320,100,20);
        l8.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l8);
        t5=new JTextField();
        t5.setBounds(180,320,150,25);
        add(t5);
        
        JLabel l9=new JLabel("Deposite");
        l9.setBounds(35,360,100,20);
        l9.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l9);
        t6=new JTextField();
        t6.setBounds(180,360,150,25);
        add(t6);
        
        
        b1=new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(35,420,120,25);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(190,420,120,25);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/customer2.jpg"));
//        Image i2=i1.getImage().getScaledInstance(456,681,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
	JLabel l10=new JLabel(i1);
	l10.setBounds(428,0,456,681);
	add(l10);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,900,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
      if(ae.getSource()==b1){
        String id=(String) c1.getSelectedItem();
        String number=t1.getText();
        String name=t2.getText();
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }
        else{
            gender="Female";
        }
        String country=t3.getText();
        String room=c2.getSelectedItem();
        String status=t5.getText();
        String deposite=t6.getText();
        
        String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposite+"')";
        String str2="update room set available='Occupied' where room_number = '"+room+"'";
        try{
            conn c=new conn();
            c.s.executeUpdate(str);
          
            c.s.executeUpdate(str2);
            JOptionPane.showMessageDialog(null,"New Customer Added");
            
        }
        catch(Exception e){
            
        }     
      }
       else if(ae.getSource()==b2){
                new Reception().setVisible(true);
                this.setVisible(false);
                } 
    }
    
    public static void main(String args[])
    {
        new AddCustomer().setVisible(true);
    }
        
    
}
