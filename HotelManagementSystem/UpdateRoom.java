/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    
    UpdateRoom()
    {
        JLabel l1=new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma",Font.PLAIN,26));
        l1.setBounds(30,20,250,30);
        add(l1);
        
        JLabel l2=new JLabel("Guest ID");
        l2.setBounds(30,80,120,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l2);
        
        c1=new Choice(); // dynamic
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){     // hopping from coloumn to column
                c1.add(rs.getString("number"));
            } 
        }
        catch(Exception e){}
            c1.setBounds(200,80,150,25);
            add(c1);
        
        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,120,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l3);
        t1=new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);
        
        
        JLabel l4=new JLabel("Availability");
        l4.setBounds(30,180,120,30);
        l4.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l4);
        t2=new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);
        
        JLabel l5=new JLabel("Clean Status");
        l5.setBounds(30,230,120,30);
        l5.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l5);
        t3=new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);
        
        b1=new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,350,120,25);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(140,350,120,25);
        add(b2);
        b2.addActionListener(this);
        
        b3=new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(270,350,120,25);
        add(b3);
        b3.addActionListener(this);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/roomStatus.jpg"));
        JLabel icon=new JLabel(i1);
        icon.setBounds(400,0,650,545);
        add(icon);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,1000,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room=null;
            String s1=c1.getSelectedItem();
            conn c=new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from customer where number = '"+s1+"'");
                
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                     
                      room=rs.getString("room");
                }
                ResultSet rs2=c.s.executeQuery("select * from room where room_number ='"+room+"'");
                while(rs2.next()){
                    t2.setText(rs2.getString("available"));
                   t3.setText(rs2.getString("clean_status"));
                }
            }
            catch(Exception e){
                
            }
            
        }
        else if(ae.getSource()==b2){
            try{
                conn c=new conn();
                String room=t1.getText();
                String available=t2.getText();
                String status=t3.getText();
                
                String str="update room set available='"+available+"',clean_status='"+status+"' where room_number='"+room+"' ";
                 c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Updated Sucessfully");
//                new Reception().setVisible(true);
//                this.setVisible(false);
            }
            catch(Exception e){
                
            }
                
        }
        else if(ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
            
    }
    public static void main(String args[])
    {
        new UpdateRoom().setVisible(true);
    }
        
    
    
}
