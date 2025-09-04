package bank.mangenet.system;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{

	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	
	
	SignupThree(String formno){
		
		this.formno=formno;
		setLayout(null);
		JLabel l1=new JLabel("Page3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,30,400,40);
		add(l1);
		
		
		JLabel type=new JLabel("Account type:");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,100,200,30);
		add(type);
				
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBounds(100,140,150,20);
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setBackground(Color.WHITE);
		r2.setBounds(300,140,200,20);
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		add(r2);
		
		
		r3=new JRadioButton("Current Account");
		r3.setBackground(Color.WHITE);
		r3.setBounds(100,180,140,20);
		r3.setFont(new Font("Raleway",Font.BOLD,14));
		add(r3);
		
		r4=new JRadioButton("Recurring Deposit Account");
		r4.setBackground(Color.WHITE);
		r4.setBounds(300,180,230,20);
		r4.setFont(new Font("Ralewat",Font.BOLD,14));
		add(r4);
		
		ButtonGroup accountgroup=new ButtonGroup();
		accountgroup.add(r1);
		accountgroup.add(r2);
		accountgroup.add(r3);
		accountgroup.add(r4);
		
		JLabel card=new JLabel("Card Number:");
		card.setBounds(100,220,200,20);
		card.setFont(new Font("Raleway",Font.BOLD,22));
		add(card);
		
		JLabel carddetail=new JLabel("Your 16 Digit Card Number");
		carddetail.setBounds(100,235,300,30);
		carddetail.setFont(new Font("Raleway",Font.BOLD,12));
		add(carddetail);
		
		
		JLabel number=new JLabel("XXX-XXX-XXX-7640");
		number.setBounds(290,220,280,20);
		number.setFont(new Font("Raleway",Font.BOLD,18));
		add(number);
		
		
		JLabel pin =new JLabel("PIN number:");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,270,200,20);
		add(pin);
		 
		JLabel pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,18));
		pnumber.setBounds(290,270,100,20);
		add(pnumber);
		
		JLabel pindetail=new JLabel("Your 4 Digit PIN Password");
		pindetail.setBounds(100,285,300,30);
		pindetail.setFont(new Font("Raleway",Font.BOLD,12));
		add(pindetail);
		
		JLabel services=new JLabel("Services Required:");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,330,200,30);
		add(services);
		
		c1=new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway",Font.BOLD,14));
		c1.setBounds(100,370,200,30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setBounds(350,370,200,30);
		c2.setFont(new Font("Raleway",Font.BOLD,14));
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setBounds(100,410,200,30);
		c3.setFont(new Font("Raleway",Font.BOLD,14));
		add(c3);
		
		c4=new JCheckBox("Email & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setBounds(350,410,200,30);
		c4.setFont(new Font("Raleway",Font.BOLD,14));
		add(c4);
		
		c5=new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setBounds(100,450,200,30);
		c5.setFont(new Font("Raleway",Font.BOLD,14));
		add(c5);
		
		c6=new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setBounds(350,450,200,30);
		c6.setFont(new Font("Raleway",Font.BOLD,14));
		add(c6);
		
		c7=new JCheckBox("I Cereby Declared that above entered details are correctto the best of my Knowleged");
		c7.setBounds(150,510,630,30);
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBackground(Color.WHITE);
		add(c7);
		
		submit =new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(250,570,100,30);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.addActionListener(this);
		add(submit);
		
		cancel =new JButton("Cancel");
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(400,570,100,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		
		
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String accountType=null;
			if(r1.isSelected()) {
				accountType="Saving account";
			}else if(r2.isSelected()) {
				accountType="Fixed Deposit Account";
			}
			else if(r3.isSelected()) {
				accountType="Current Account";
			}
			else if(r4.isSelected()) {
				accountType="Recurring Deposit Account";
			}
			
			Random random=new Random();
			String cardnumber=" " + Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
			String facility="";
			if(c1.isSelected()) {
				facility=facility+"ATM Card";
				
			}else if(c2.isSelected()) {
				facility=facility+"Internet Banking";
			}else if(c3.isSelected()) {
				facility=facility+"Mobile Banking";
			}else if(c4.isSelected()) {
				facility=facility+"Email & SMS Alerts";
			}else if(c5.isSelected()) {
				facility=facility+"Cheque Book";
			}else if(c6.isSelected()) {
				facility=facility+"E-Statement";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null,"Account Type is required");
				}else {
					Conn conn=new Conn();
					String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
				
					conn.s.executeUpdate(query1);
			
					conn.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Card Number:"+cardnumber+"\nPin:"+pinnumber);
				
				setVisible(false);
				new Deposit1(pinnumber).setVisible(false);
				}
			}catch(Exception e) {
				System.out.println(e);
				
			}
			
			
			
		}else if(ae.getSource()== cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		new SignupThree(" ");

	}

}
