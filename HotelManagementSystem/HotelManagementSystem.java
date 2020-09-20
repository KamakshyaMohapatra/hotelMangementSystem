package hotel.management.system;
import java.awt.*;
import java.awt.color.*;
import javax.swing.*;
import java.awt.event.*; //classes get imported but packages dont get impoted
public class HotelManagementSystem extends JFrame implements ActionListener
{      //jframe is present in swing package
	
	   HotelManagementSystem()
	   {
//		   setSize(400,400);// length and breath by default at left at origin
//		   setLocation(300,400); // location of the frame x-axis and y-axis
		   setBounds(640,300,640,365);// combination of setlocation and setSizr (first location and then size)
		   
		  
		   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/frontImage.jpg"));
		   JLabel l1=new JLabel(i1);
		   l1.setBounds(0,0,640,360);
                   
		   add(l1);
		   JLabel l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
		   l2.setForeground(Color.white);
		   l2.setBounds(65,230,1000,100 );
		   l2.setFont(new Font("serif",Font.PLAIN,36));
		   l1.add(l2);
		   JButton b1=new JButton("Next");
		   b1.setBackground(Color.black);
                   setUndecorated(true);
                   
		   b1.setForeground(Color.white);
		   b1.setBounds(290,310,70,30);
		   b1.addActionListener(this);
		   l1.add(b1);
		   setLayout(null);
		   setVisible(true);// to show the frame by default false
	   }
	   public void actionPerformed(ActionEvent ae)      // overiding the method of actionListener
	   {
		   new Login().setVisible(true);
		   this.setVisible(false);
	   }

	public static void main(String[] args) {
		new HotelManagementSystem();
	}

}
