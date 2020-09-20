package hotel.management.system;
import java.awt.*;       // the classes get imported not the packages.
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{      // present in the java.awt.event package.   
 
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	 
	Login()
	{
		l1=new JLabel("Username");
		l1.setBounds(20,40,100,30);
		add(l1);
		l2=new JLabel("Password");
		l2.setBounds(20,70,100,30);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(84,46,150,20);
		add(t1);
		t2=new JPasswordField();
		t2.setBounds(84,76,150,20);
		add(t2);
		
		b1=new JButton("Login");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(20,120,100,20);
                b1.addActionListener(this);
		add(b1);
                
                
		b2=new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(140,120,100,20);
                b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l3=new JLabel(i3);
		l3.setBounds(190,0,200,200);
		add(l3);
		
		getContentPane().setBackground(Color.gray); //used for setting the background color.
		
	   setLayout(null);
	   setBounds(500,300,400,200);
	   setVisible(true);
	}
        public void actionPerformed(ActionEvent ae) // This class is called when the button is pressed.
        {
            if(ae.getSource()==b1)
            {
                
                String username=t1.getText();
                String password=t2.getText();
                conn c=new conn();
                
                String str="select * from login where username= '"+username+"' and password = '"+password+"'";
                try{
                ResultSet rs=c.s.executeQuery(str);
                if(rs.next())
                {
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"invalid username or password");
                    this.setVisible(false);
                }
                }   
                catch(Exception e){
                    
                }
            }
            
            else if(ae.getSource()==b2){
                System.exit(0);
            }
        }
	public static void main(String[] args) {
	
		new Login();
		
	}

}
