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
public class SearchRoom extends JFrame implements ActionListener {
    
    
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    SearchRoom(){
        
        JLabel l1=new JLabel("Search for Room");
        l1.setFont(new Font("Tahoma",Font.PLAIN,24));
        l1.setBounds(150,20,200,30);
        add(l1);
        
        JLabel l2=new JLabel("Bed Type");
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        l2.setBounds(50,100,200,20);
        add(l2);
        
        c1=new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c1.setBounds(130,97,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2=new JCheckBox("Only display Available");
        c2.setBounds(650,97,150,25);
        add(c2);
        
        
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
        
        
        JLabel l3=new JLabel("Room Number");
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(50,160,200,20);
        add(l3);
        
        
        JLabel l4=new JLabel("Availability");
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(260,160,200,20);
        add(l4);
        
        JLabel l5=new JLabel("Cleaning Status");
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setBounds(420,160,200,20);
        add(l5);
        
        JLabel l6=new JLabel("Price");
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setBounds(650,160,200,20);
        add(l6);
        
        JLabel l7=new JLabel("Bed Type");
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        l7.setBounds(830,160,200,20);
        add(l7);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str="select * from room where bed_type='"+c1.getSelectedItem()+"'";
                String str2="select * from room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"' ";
                conn c=new conn();
                
                
                if(c2.isSelected()){
                    ResultSet rs2=c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                else{
                    ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
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
        new SearchRoom().setVisible(true);
    }
    
    
    
    
    
}
