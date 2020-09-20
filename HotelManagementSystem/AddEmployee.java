package hotel.management.system;
import javax.swing.*;
import java.awt.*;   // abstract window toolkit
import java.awt.image.*;  // 
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
    
     JTextField t1,t2,t3,t4,t5,t6;
     JRadioButton r1,r2;
     JComboBox c1;
     JButton b1;
      AddEmployee(){
          
           JLabel heading =new JLabel("Add Employee");
           heading.setBounds(50,0,200,30);
           heading.setFont(new Font("Tahona",Font.BOLD,24));
           add(heading);
          
          
          
           JLabel name =new JLabel("Name");
           name.setFont(new Font("Tahona",Font.PLAIN,14));
           name.setBounds(50,30,120,30);
           add(name);
           t1=new JTextField();
           t1.setBounds(120,36,180,20);
           t1.setBackground(Color.white);
           add(t1);

           
           JLabel age =new JLabel("Age");
           age.setFont(new Font("Tahona",Font.PLAIN,14));
           age.setBounds(50,60,120,30);
           add(age);
           t2=new JTextField();
           t2.setBounds(120,66,180,20);
           t2.setBackground(Color.white);
           add(t2);
           
           JLabel gender =new JLabel("Gender");
           gender.setFont(new Font("Tahona",Font.PLAIN,14));
           gender.setBounds(48,90,120,20);
           add(gender);
           r1=new JRadioButton("Male");
           r1.setBounds(120,90,70,20);
           r1.setFont(new Font("Tahona",Font.PLAIN,16));
           r1.setBackground(Color.WHITE);
           add(r1);
           r2=new JRadioButton("Female");
           r2.setBounds(190,90,90,20);
           r2.setFont(new Font("Tahona",Font.PLAIN,14));
           r2.setBackground(Color.WHITE);
           add(r2);
           
           
           JLabel job =new JLabel("Job");
           job.setFont(new Font("Tahona",Font.PLAIN,14));
           job.setBounds(48,120,120,30);
           add(job);
           String str[]={"Porters","HouseKeeping","KitchenStaff","RoomService","Waiter/Waitress","Manager","Accountant","chef"}; 
           c1=new JComboBox(str);
           c1.setBounds(121,123,120,20);
           c1.setBackground(Color.WHITE);
           add(c1);
           
           
           JLabel salary =new JLabel("Salary");
           salary.setFont(new Font("Tahona",Font.PLAIN,14));
           salary.setBounds(48,150,120,30);
           add(salary);
           t3=new JTextField();
           t3.setBounds(120,156,180,20);
           t3.setBackground(Color.white);
           add(t3);

           
           JLabel phone =new JLabel("Phone");
           phone.setFont(new Font("Tahona",Font.PLAIN,14));
           phone.setBounds(48,180,120,30);
           add(phone);
           t4=new JTextField();
           t4.setBounds(120,186,180,20);
           t4.setBackground(Color.white);
           add(t4);

           
           
           JLabel addhar =new JLabel("Aadhar");
           addhar.setFont(new Font("Tahona",Font.PLAIN,14));
           addhar.setBounds(48,210,120,30);
           add(addhar);
           t5=new JTextField();
           t5.setBounds(120,216,180,20);
           t5.setBackground(Color.white);
           add(t5);

           
           JLabel email =new JLabel("E-mail");
           email.setFont(new Font("Tahona",Font.PLAIN,14));
           email.setBounds(48,240,120,30);
           add(email);
           t6=new JTextField();
           t6.setBounds(120,246,180,20);
           t6.setBackground(Color.white);
           add(t6);
           
           b1=new JButton("SUBMIT");
           b1.setBackground(Color.BLACK);
           b1.setForeground(Color.white);
           b1.setBounds(120,276,120,30);
           add(b1);
           b1.addActionListener(this);

           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/he.jpg"));
           Image i2=i1.getImage().getScaledInstance(450,413,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           JLabel l1=new JLabel(i3);
           l1.setBounds(333,0,450,413);
           add(l1);           
           
           getContentPane().setBackground(Color.white);
           
           setLayout(null);
           setBounds(650,300,800,400);
           setVisible(true);
      }
      public void actionPerformed(ActionEvent ae)
      {
           String name=t1.getText();
           String age=t2.getText();
           String salary=t3.getText();
           String phone=t4.getText();
           String aadhar=t5.getText();
           String email=t6.getText();
           
           String gender=null;
           
           if(r1.isSelected())
           {
               gender="male";
           }
           else if(r2.isSelected())
           {
               gender="female";
           }
           
           String job=(String)c1.getSelectedItem(); //getting the combobutton
           
           conn c=new conn();
           
           String str="Insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
           try{
//               c.s.executeQuery(str);//use of taking out data from the database
                c.s.executeUpdate(str); 
               JOptionPane.showMessageDialog(null,"New Employee added");
               this.setVisible(false); 
           }catch(Exception e){
               
           }
      }
       
      public static void main(String args[])
      {
          new AddEmployee().setVisible(true);
          
      }
       
      
}
