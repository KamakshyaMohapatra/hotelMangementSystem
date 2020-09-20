
package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 

import net.proteanit.sql.*; //for showing the table

public class CustomerInfo extends JFrame implements ActionListener {
    
    
    JTable t1;
    JButton b1,b2;
    
    CustomerInfo()
    {
        t1=new JTable();
        t1.setBounds(0,50,1000,500);
        add(t1);
        JLabel l1=new JLabel("ID");
        l1.setBounds(30,10,70,20);
        add(l1);
        
        JLabel l2=new JLabel("Number");
        l2.setBounds(150,10,70,20);
        add(l2);
        
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(270,10,70,20);
        add(l3);
        
        JLabel l4=new JLabel("Gender");
        l4.setBounds(380,10,70,20);
        add(l4);
        
        JLabel l5=new JLabel("Country");
        l5.setBounds(520,10,70,20);
        add(l5);
        
        JLabel l6=new JLabel("RoomNumber");
        l6.setBounds(640,10,90,20);
        add(l6);
        
        JLabel l7=new JLabel("CheckStatus");
        l7.setBounds(750,10,90,20);
        add(l7);
        
        JLabel l8=new JLabel("Deposite");
        l8.setBounds(890,10,70,20);
        add(l8);
        
        b1=new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.addActionListener(this);
        add(b1);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        
        b2=new JButton("Back");
        b2.setBounds(550,560,120,30);
        add(b2);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        
        
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450, 200, 1000,650);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                conn c=new conn();
                String str="select * from customer";
                ResultSet rs=c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                
            }
                
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
            
    }
        
    public static void main(String args[])
    {
        new CustomerInfo().setVisible(true);
    }
        
        
    
}
