
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener  {
       
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
        Dashboard()
        {
            mb =new JMenuBar();
            add(mb);
            mb.setBounds(0,0,1930,30);
            
            m1=new JMenu("HOTEL MANAGEMENT");
            mb.add(m1);
            
            m2 = new JMenu("ADMIN");
            mb.add(m2);
            
            
            i1=new JMenuItem("RECEPTION");
            i1.addActionListener(this);
            m1.add(i1);
            
            i2=new JMenuItem("ADD EMPLOYEE");
            i2.addActionListener(this);
            m2.add(i2);
            
            
            i3=new JMenuItem("ADD ROOMS");
            i3.addActionListener(this);
            m2.add(i3);
            
            i4=new JMenuItem("ADD DRIVERS");
            i4.addActionListener(this);
            m2.add(i4);
            
            ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/dashboard.jpg"));
            Image i2=i5.getImage().getScaledInstance(1930, 1080,Image.SCALE_DEFAULT);
            ImageIcon i6=new ImageIcon(i2);
            JLabel l1=new JLabel(i6);
            l1.setBounds(0,0,1930,1080);
            add(l1);
            
            setLayout(null);
            setBounds(0,0,1930,1080);
            setVisible(true);
            setExtendedState(JFrame.MAXIMIZED_BOTH); 
            
           
            
            
        }
        
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("RECEPTION")){
                new Reception().setVisible(true);
            }
            else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
                new AddEmployee().setVisible(true);
            }
            else if(ae.getActionCommand().equals("ADD ROOMS")){
                new AddRooms().setVisible(true);
            }
            else if(ae.getActionCommand().equals("ADD DRIVERS")){
                new AddDriver().setVisible(true);
            }
            
        }
           
        public static void main(String args[])
        {
            new Dashboard().setVisible(true);
        }
                
            
}
