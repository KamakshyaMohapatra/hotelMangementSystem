/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class CheckOut extends JFrame implements ActionListener {
    
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    
    CheckOut()
    {
        
        
        JLabel l1=new JLabel("Check Out");
        l1.setBounds(30,20,200,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(l1);
        
        JLabel l2=new JLabel("Customer-Id");
        l2.setBounds(30,80,100,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l2);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
                
        }
        catch(Exception e){
            
        }
        c1.setBounds(150,80,150,30);
        add(c1);
        
        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(150,130,150,25);
        add(t1);
        
        b1=new JButton("CheckOut");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(30,200,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(180,200,120,30);
        add(b2);
        b2.addActionListener(this);
        
         ImageIcon i6=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick7.jpg"));
        Image i4=i6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i5=new ImageIcon(i4);
        b3=new JButton(i5);
        add(b3);
        b3.addActionListener(this);
        b3.setBounds(310,80, 25,25);
        
        
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/checkout.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l8=new JLabel(i3);
        add(l8);
        l8.setBounds(340,0, 500, 300);
        
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(600,300,800,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String id=c1.getSelectedItem();
            String room=t1.getText();
            String str="delete from customer where number='"+id+"'";
            String str2="update room set available= 'Available' where room_number='"+room+"'";
            conn c=new conn();
            try{
                
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"CheckOut Sucessfull");
                 
      

                
            }
            catch(Exception e){
                
            }
        }
        else if(ae.getSource()==b2){
                 new Reception().setVisible(true);
                 this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            conn c=new conn();
            String id=c1.getSelectedItem();
            try{
            ResultSet rs=c.s.executeQuery("select * from customer where number='"+id+"'");
             while(rs.next()){
                t1.setText(rs.getString("room"));
            }
            }
            catch(Exception e){
                
            }
           
            
        }
        
        
        
        
    }
    
    public static void main(String args[])
    {
        new CheckOut().setVisible(true);
    }
}
