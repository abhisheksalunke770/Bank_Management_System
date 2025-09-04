package bank.mangenet.system;
import java.sql.*;
public class Conn {

	Connection c;
	Statement s;
	public Conn() {
		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","siit");
			s=c.createStatement();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	public static void main(String[] args) {


	}

}
