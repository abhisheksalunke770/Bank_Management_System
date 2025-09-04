package bank.mangenet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount; // Instance variable
    JButton withdraw, back; // Instance variables
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/logo2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter your amount you want to deposit ");
        text.setBounds(170, 300, 400, 20);
        text.setFont(new Font("System", Font.BOLD, 12));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField(); // Use instance variable
        amount.setBounds(170, 330, 300, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(amount);

        withdraw = new JButton("Withdraw"); // Use instance variable
        withdraw.setBounds(410, 455, 100, 25);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back"); // Use instance variable
        back.setBounds(410, 490, 100, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl(" ");
    }
}
