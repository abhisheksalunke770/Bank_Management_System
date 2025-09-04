package bank.mangenet.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener{
	
	
	JTextField pan,aadhar;
	//JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religion,category,Education,Occupation,income;
	String formno;
	JButton next;
	
	SignupTwo(String formno){
		
		this.formno=formno;
		
		
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICTION FORM-PAGE 2");
		
		
		JLabel additionalDetails=new JLabel("Page 2:Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(280,40,400,30);
		add(additionalDetails);
		
		
		JLabel Religion=new JLabel("Religion:");
		Religion.setFont(new Font("Raleway",Font.BOLD,22));
		Religion.setBounds(100,140,200,30);
		add(Religion);
		
		String valReligion[]= {"Hindu","Muslim","Sikh","Christion","Other"};
		 religion=new JComboBox(valReligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		
		JLabel Category=new JLabel("Category:");
		Category.setFont(new Font("Raleway",Font.BOLD,22));
		Category.setBounds(100,190,200,30);
		add(Category);
		
		String valcategory[]= {"General","OBC","SC","ST","Other"};
		category=new JComboBox(valcategory);
		category.setBounds(300,190,400,30);
		category.setBackground(Color.WHITE);
		add(category);
		
		
		
		
		JLabel Income=new JLabel("Income:");
		Income.setFont(new Font("Raleway",Font.BOLD,22));
		Income.setBounds(100,240,200,30);
		add(Income);
		
		String incomecategory[]= {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		 income=new JComboBox(incomecategory);
		income.setBounds(300,240,400,30);
		income.setBackground(Color.WHITE);
		add(income);
		
		
		
		JLabel education=new JLabel("Education:");
		education.setFont(new Font("Raleway",Font.BOLD,22));
		education.setBounds(100,290,200,30);
		add(education);
		
		JLabel qualification=new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD,22));
		qualification.setBounds(100,315,200,30);
		add(qualification);
		
		String educationvalue[]= {"Non Graduation","Graduate","Post-Graduation","Doctrate","Other"};
		 Education=new JComboBox(educationvalue);
		Education.setBounds(300,300,400,40);
		Education.setBackground(Color.WHITE);
		add(Education);
		
		JLabel occupation=new JLabel("Occpation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,22));
		occupation.setBounds(100,390,200,30);
		add(occupation);
		
		String occuptionValues[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
		 Occupation=new JComboBox(occuptionValues);
		Occupation.setBounds(300,390,400,30);
		Occupation.setBackground(Color.WHITE);
		add(Occupation);
		
		
		JLabel panno=new JLabel("PAN Number:");
		panno.setFont(new Font("Raleway",Font.BOLD,22));
		panno.setBounds(100,440,200,30);
		add(panno);
		
		 pan=new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBackground(Color.WHITE);
		pan.setBounds(300,440,400,30);
		add(pan);
		
		JLabel aadharno=new JLabel("Aadhar Number:");
		aadharno.setFont(new Font("Raleway",Font.BOLD,22));
		aadharno.setBounds(100,490,200,30);
		add(aadharno);
		
		 aadhar=new JTextField();
		aadhar.setBounds(300,490,400,30);
		aadhar.setFont(new Font("Raleway",Font.BOLD,22));
		add(aadhar);
		
		JLabel seniorcitizen=new JLabel("Senior Citizen:");
		seniorcitizen.setFont(new Font("Raleway",Font.BOLD,22));
		seniorcitizen.setBounds(100,540,200,30);
		add(seniorcitizen);
		
		 syes=new JRadioButton("YES");
		syes.setBackground(Color.WHITE);
		syes.setBounds(300,540,100,30);
		add(syes);
	
		 sno=new JRadioButton("NO");
		sno.setBounds(400,540,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup citizen=new ButtonGroup();
		citizen.add(syes);
		citizen.add(sno);	
		
		
		JLabel exaccount=new JLabel("Exisiting Account");
		exaccount.setFont(new Font("Raleway",Font.BOLD,22));
		exaccount.setBounds(100,590,200,30);
		add(exaccount);
		
		 eyes=new JRadioButton("YES");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		 eno=new JRadioButton("NO");
		eno.setBounds(400,590,100,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup accountgroup=new ButtonGroup();
		accountgroup.add(eyes);
		accountgroup.add(eno);
		
		next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		setSize(850,800);
		setLocation(350,10);
	    setVisible(true);
	    
	    
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		String sreligion=(String)religion.getSelectedItem();
		String scategory=(String)category.getSelectedItem();
		String sEducation=(String)Education.getSelectedItem();
		String sOccupation=(String)Occupation.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seniorcitizen=null;
		if (syes.isSelected()) {
			seniorcitizen="YES";
		}else if(sno.isSelected()) {
			seniorcitizen="NO";
		}
		
		String exaccount=null;
		if(eyes.isSelected()) {
		exaccount="YES";
		}else if(eno.isSelected()) {
			exaccount="NO";
		}
		String span=pan.getText();
		String saadhar=aadhar.getText();
		
		try {
			Conn c=new Conn();
			String query="insert into singnuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+sEducation+"','"+sOccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exaccount+"')";
			c.s.executeUpdate(query);
			
			
			//Signup3 Object
			setVisible(false);
			new SignupThree(formno).setVisible(true);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void main(String[] args) {
		
 
		new SignupTwo(" ");
	}
	

}
