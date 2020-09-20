/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    UpdateCheck(){
        
        
        JLabel l1=new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,26));
        l1.setBounds(70,30,200,30);
        add(l1);
        
        
        JLabel l2=new JLabel("Customer-ID");
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        l2.setBounds(40,80,120,30);
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
        c1.setBounds(180,80,150,40);
        add(c1);
        
        JLabel l3=new JLabel("Room Number");
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        l3.setBounds(40,130,120,30);
        add(l3);
        t1=new JTextField();
        t1.setBounds(180,130,150,25);
        add(t1);
        
        JLabel l4=new JLabel("Name");
        l4.setFont(new Font("Tahoma",Font.PLAIN,14));
        l4.setBounds(40,180,120,30);
        add(l4);
        t2=new JTextField();
        t2.setBounds(180,180,150,25);
        add(t2);
        
        
        JLabel l5=new JLabel("Checked-In");
        l5.setFont(new Font("Tahoma",Font.PLAIN,14));
        l5.setBounds(40,230,120,30);
        add(l5);
        t3=new JTextField();
        t3.setBounds(180,230,150,25);
        add(t3);
        
        
        JLabel l6=new JLabel("Ammount Paid");
        l6.setFont(new Font("Tahoma",Font.PLAIN,14));
        l6.setBounds(40,280,120,30);
        add(l6);
        t4=new JTextField();
        t4.setBounds(180,280,150,25);
        add(t4);
        
        
        JLabel l7=new JLabel("Pending Ammount");
        l7.setFont(new Font("Tahoma",Font.PLAIN,14));
        l7.setBounds(40,330,200,30);
        add(l7);
        t5=new JTextField();
        t5.setBounds(180,330,150,25);
        add(t5);
        
        
        
        
        b1=new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,380,70,25);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(135,380,80,25);
        add(b2);
        b2.addActionListener(this);
        
        b3=new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(240,380,70,25);
        add(b3);
        b3.addActionListener(this);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room14.jpg"));
        JLabel icon=new JLabel(i1);
        icon.setBounds(350,0,650,545);
        add(icon);
        
        
        
        
        
        
         getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,1000,500);
        setVisible(true);
        
    }
    
        public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource()==b1){
                try{
                String room=null;
                int ammountPaid=0;
                String deposite=null;
                String price=null;
                conn c=new conn();
                String id=c1.getSelectedItem();
                String  str="select * from customer where number = '"+id+"'";
                ResultSet rs=c.s.executeQuery(str);
                while(rs.next()){
                     t1.setText(rs.getString("room"));
                     t2.setText(rs.getString("name"));
                     t3.setText(rs.getString("status"));
                     t4.setText(rs.getString("deposite"));
                     room=rs.getString("room");
                     deposite=rs.getString("deposite");
                    
                }
                ResultSet rs2=c.s.executeQuery("select * from room where room_number ='"+room+"'");
                while(rs2.next()){
                    price=rs2.getString("price");
                    ammountPaid=Integer.parseInt(price)-Integer.parseInt(deposite);
                    t5.setText(Integer.toString(ammountPaid));
                }
            }
                catch(Exception e){
                    
                }
            }
            else if(ae.getSource()==b2){
                
            }
            else if(ae.getSource()==b3){
                new Reception().setVisible(true);
                this.setVisible(false);
            }
        
        }
    
        public static void main(String args[]){
            new UpdateCheck().setVisible(true);
        }
    
    
    
    
}
