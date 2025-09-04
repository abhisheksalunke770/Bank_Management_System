package bank.mangenet.system;

import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

	JPasswordField pin,repin;
	JButton change,back;
	String pinnumber;
	
	public PinChange(String pinnumber) {
		this.pinnumber=pinnumber;
		
		
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/logo2.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JLabel text=new JLabel("Change your pin");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,290,500,35);
		image.add(text);
		
		JLabel pintext=new JLabel("New PIN:");
		pintext.setFont(new Font("System",Font.BOLD,15));
		pintext.setForeground(Color.WHITE);
		pintext.setBounds(170,340,100,35);
		image.add(pintext);
		
		 pin=new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(300,340,180,25);
		image.add(pin);
		
		JLabel repintext=new JLabel("Re-Enter New PIN:");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System",Font.BOLD,15));
		repintext.setBounds(165,380,200,35);
		image.add(repintext);
		
		 repin=new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,20));
		repin.setBounds(300,380,180,25);
		image.add(repin);
		
		 change=new JButton("Change");
		change.setBounds(410,485,100,30);
		change.addActionListener(this);
		image.add(change);
		
		 back=new JButton("Back");
		back.setBounds(410,520,100,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
			
		
		try {
			String npin=pin.getText();
			String rpin=repin.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
		
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter New PIN");
				return;
			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
				return;
			}
			Conn conn =new Conn();
			String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
			String query2="update login set pin='"+rpin+"'where pin='"+pinnumber+"'";
			String query3="update signupthree set pin='"+rpin+"'where pin='"+pinnumber+"'";
			
			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			conn.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN Change Successfully");
			
			setVisible(false);
			new Transactions(rpin).setVisible(true);
			
			
		}catch(Exception e) {
			System.out.println(e);
	
		}
		
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		new PinChange(" ").setVisible(true);

	}

}
