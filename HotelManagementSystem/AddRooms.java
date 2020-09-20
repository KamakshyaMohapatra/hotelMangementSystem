
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener {
    
    
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
     AddRooms()
     {
         JLabel l1=new JLabel("AddRooms");
         l1.setBounds(120,10,120,30);
         l1.setFont(new Font("Tahoma",Font.BOLD,18));
         add(l1);
         
         JLabel room=new JLabel("ROOM NUMBER");
         room.setBounds(62,50,120,30);
         room.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(room);
         t1=new JTextField();
         t1.setBounds(185,55,120,20);
         add(t1);
     
         
         JLabel available=new JLabel("AVAILABILITY");
         available.setBounds(60,80,120,30);
         available.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(available);
         c1=new JComboBox(new String [] {"Availble","Occupied"});
         c1.setBounds(183,85,120,20);
         c1.setBackground(Color.white);
         add(c1);
         
          JLabel status=new JLabel("CLEANING STATUS");
          status.setBounds(60,110,120,30);
          status.setFont(new Font("Tahoma",Font.PLAIN,14));
          add(status);
          c2=new JComboBox(new String[]{"Yes","No"});
          c2.setBounds(183,115,120,20);
          c2.setBackground(Color.white);
          add(c2);
     
           
          JLabel price=new JLabel("PRICE");
          price.setBounds(60,140,120,30);
          price.setFont(new Font("Tahoma",Font.PLAIN,14));
          add(price);
          t2=new JTextField();
          t2.setBounds(183,145,120,20);
          add(t2);

         
          JLabel bed=new JLabel("BED TYPE");
          bed.setBounds(60,170,120,30);
          bed.setFont(new Font("Tahoma",Font.PLAIN,14));
          add(bed);
          c3=new JComboBox(new String[] {"Single Bed","Double Bed","Triple Bed"});
          c3.setBounds(183,175,120,20);
          c3.setBackground(Color.white);
          add(c3);
     
          
          
          b1=new JButton("Add Room");
          b1.setBounds(57,250,120,20);
          b1.setBackground(Color.BLACK);    
          b1.setForeground(Color.white);
          b1.addActionListener(this);
          add(b1);
          
          b2=new JButton("Cancel");
          b2.setBounds(187,250,120,20);
          add(b2);
          b2.setBackground(Color.black);
          b2.addActionListener(this);
          b2.setForeground(Color.white);
          
          
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotelroom2.jpg"));
          Image i2=i1.getImage().getScaledInstance(560,370,Image.SCALE_DEFAULT);
          ImageIcon i3=new ImageIcon(i2);
          JLabel l=new JLabel(i3);
          l.setBounds(310,0,560,370);
          add(l);
          
          
          
          
          
          
          getContentPane().setBackground(Color.white); //container
         
         setBounds(600,300,750,400);
         setLayout(null);
         setVisible(true);
     }
     public void actionPerformed(ActionEvent ae)
     {
         
         if(ae.getSource()==b1){
             String room =t1.getText();
             String available = (String)c1.getSelectedItem();
             String status= (String)c2.getSelectedItem();
             String price=t2.getText();
             String type=(String)c3.getSelectedItem();
             
             conn c=new conn();
             try{
                 String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                 c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null, "New Room Added");
//                 this.setVisible(false); 
             }catch(Exception e){
                 System.out.println(e);
             }
             
         }
         else if(ae.getSource()==b2){
             this.setVisible(false);
         }
         
     }
         
     public static void main(String args[])
     {
         new AddRooms().setVisible(true);
     }
         
         
    
}
