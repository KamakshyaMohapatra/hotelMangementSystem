/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;  
import net.proteanit.sql.DbUtils;
public class PickupService extends JFrame implements ActionListener {
    
    Choice c1;
//    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    PickupService(){
        
        JLabel l1=new JLabel("Pickup Service");
        l1.setFont(new Font("Tahoma",Font.PLAIN,24));
        l1.setBounds(150,20,200,30);
        add(l1);
         
        JLabel l2=new JLabel("Type of Car");
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        l2.setBounds(50,100,100,20);
        add(l2);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("car"));
            }
                
        
        }
        catch(Exception e){
            
        }
            c1.setBounds(150,97,150,25);
            add(c1);
        
            
            
            
        t1=new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300,540,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(500,540,120,30);
        add(b2);
        b2.addActionListener(this);
        
        
        JLabel l3=new JLabel("Name");
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(30,160,200,20);
        add(l3);
        
        
        JLabel l4=new JLabel("Age");
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(180,160,200,20);
        add(l4);
        
        JLabel l5=new JLabel("Gender");
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setBounds(300,160,200,20);
        add(l5);
        
        JLabel l6=new JLabel("Company"); 
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setBounds(450,160,200,20);
        add(l6);
        
        JLabel l7=new JLabel("Brand");
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        l7.setBounds(600,160,200,20);
        add(l7);
         
         JLabel l8=new JLabel("Available");
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        l8.setBounds(730,160,200,20);
        add(l8);
        
        
         JLabel l9=new JLabel("Location");
        l9.setFont(new Font("Tahoma",Font.BOLD,14));
        l9.setBounds(860,160,200,20);
        add(l9);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str="select * from driver where car='"+c1.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception e){
                
            }
        }
        else if(ae.getSource()== b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    
    public static void main(String args[]){
        new PickupService().setVisible(true);
    }
    
    
    
    
    
}
