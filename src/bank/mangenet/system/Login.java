package bank.mangenet.system;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login,Clear,Signup;
	JTextField cardTextField;
	JPasswordField PINTextField;
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		JLabel label =new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text=new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		JLabel Card=new JLabel("Card no:");
		Card.setFont(new Font("Raleway",Font.BOLD,28));
		Card.setBounds(120,150,150,30);
		add(Card);
		
		 cardTextField=new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		
		JLabel PINno=new JLabel("PINno:");
		PINno.setFont(new Font("Raleway",Font.BOLD,28));
		PINno.setBounds(120,220,250,30);
		add(PINno);
		
		PINTextField=new JPasswordField(); 
		PINTextField.setBounds(300,220,230,30);
		PINTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(PINTextField);   
		
		login=new JButton("SIGN IN"); 
		login.setBounds(300,300,100,30);
		login.setBackground(Color.BLACK); 
		login.setForeground(Color.WHITE); 
		login.addActionListener(this); 
		add(login);  
		
		Clear=new JButton("CLEAR");
		Clear.setBounds(430,300,100,30); 
		Clear.setBackground(Color.BLACK); 
		Clear.setForeground(Color.WHITE); 
		Clear.addActionListener(this); 
		add(Clear);  
		
		Signup=new JButton("SIGNUP"); 
		Signup.setBounds(300,350,230,30);
		Signup.setBackground(Color.BLACK);
		Signup.setForeground(Color.WHITE);
		Signup.addActionListener(this); 
		add(Signup);  
		
		getContentPane().setBackground(Color.WHITE);  
		setSize(800,500);
		setVisible(true); 
		setLocation(350,200);
		} 
	public void actionPerformed(ActionEvent ae) 
	{  
		if(ae.getSource()==Clear) 
	{ 
			cardTextField.setText("");
			PINTextField.setText(""); 
			} else if(ae.getSource()==login) {
				Conn conn=new Conn();
				String cardnumber=cardTextField.getText();
				String pinnumber=PINTextField.getText();
				String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
				try {
					ResultSet rs=conn.s.executeQuery(query);
					if(rs.next()) {
						setVisible(false);
						new Transactions(pinnumber).setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Crad Number or Pin");
					}
				}catch(Exception e) {
					System.out.println(e);
				}
				}
				else if(ae.getSource()==Signup) { 
				setVisible(false); 
				new SingupOne().setVisible(true);      
	}
	}	
	
	public static void main(String[] args) {
		new Login();
		

	}

}
