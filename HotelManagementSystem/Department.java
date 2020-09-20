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
public class Department extends JFrame implements ActionListener {
    
    
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    Department(){
        
      
            
            
        t1=new JTable();
        t1.setBounds(0,50,500,300);
        add(t1);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,400,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,400,120,30);
        add(b2);
        b2.addActionListener(this);
        
        
        JLabel l3=new JLabel("Department");
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(20,25,200,20);
        add(l3);
        
        
        JLabel l4=new JLabel("Budget");
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(260,25,200,20);
        add(l4);
        
       
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(700,200,500,550);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str="select * from department";
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
        new Department().setVisible(true);
    }
    
    
    
    
    
}
