package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class AddDriver extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JRadioButton b1,b2;
    JComboBox c1;
    JButton j1,j2;
    AddDriver()
    {
        JLabel title=new JLabel("Add Drivers");
        title.setBounds(110,20,140,30);
        add(title);
        title.setFont(new Font("Tahoma",Font.BOLD,22));
        
        JLabel name=new JLabel("Name");
        name.setBounds(50,80,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(name);
        t1=new JTextField();
        t1.setBounds(120,85,130,20);
        add(t1);
        
        
        JLabel age=new JLabel("Age");
        age.setBounds(50,110,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(age);
        t2=new JTextField();
        t2.setBounds(120,115,130,20);
        add(t2);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(50,140,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(gender);
        b1=new JRadioButton("Male");
        b1.setBounds(115,140,70,30);
        b1.setBackground(Color.LIGHT_GRAY);
        add(b1);
        b1.setFont(new Font("Tahona",Font.PLAIN,14));
        
        b2=new JRadioButton("Female");
        b2.setBounds(190,140,120,30);
        b2.setBackground(Color.LIGHT_GRAY);
        add(b2);
        b2.setFont(new Font("Tahona",Font.PLAIN,14));
        
        JLabel car=new JLabel("Car");
        car.setBounds(50,170,120,30);
        car.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(car);
        t3=new JTextField();
        t3.setBounds(120,175,130,20);
        add(t3);
        
        
        
        JLabel model=new JLabel("Car Model");
        model.setBounds(50,200,120,30);
        model.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(model);
        t4=new JTextField();
        t4.setBounds(120,205,130,20);
        add(t4);

        
        
        JLabel available=new JLabel("Available");
        available.setBounds(50,230,120,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(available);
        c1=new JComboBox(new String [] {"Availble","Occupied"});
        c1.setBounds(120,235,130,20);
        c1.setBackground(Color.white);
        add(c1);
        
        
        JLabel location=new JLabel("Location");
        location.setBounds(50,260,120,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(location);
        t5=new JTextField();
        t5.setBounds(120,265,130,20);
        add(t5);
        
        
        j1=new JButton("Add Driver");
        j1.setBounds(120,295,100,20);
        j1.setBackground(Color.BLACK);
        j1.setForeground(Color.WHITE);
        add(j1);
        j1.addActionListener(this);
        
        j2=new JButton("Cancel");
        j2.setBounds(230,295,100,20);
        j2.setBackground(Color.BLACK);
        j2.setForeground(Color.WHITE);
        add(j2);
        j2.addActionListener(this);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/driver.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        add(l1);
        l1.setBounds(350,0, 500, 350);
        getContentPane().setBackground(Color.white);
        
        
        
        setBounds(600,300,800,400);
         setLayout(null);
         setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==j1){
            
            
                String name=t1.getText();
                String age=t2.getText();
                String car=t3.getText();
                String model=t4.getText();
                String available = (String)c1.getSelectedItem();
                String location=t5.getText();
               
                String gender=null;
           
                if(b1.isSelected())
                {
                  gender="male";
                }
                else if(b2.isSelected())
                {
                  gender="female";
                }
                conn c=new conn();
                try{
                    String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver info Added");
                    this.setVisible(false); 
                }
                catch(Exception e){
                    System.out.println(e);
                }
            
            
            
        }
        else if(ae.getSource()==j2){
            this.setVisible(false);
        }
        
    }
         
    public static void main(String args[])
    {
        new AddDriver().setVisible(true);
    }
        
}
