package covid_vaccine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	static Connection conn;
	public Database(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		
	}
	public Statement connect() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_vaccination_1","root","");
		//conn = DriverManager.getConnection("jdbc:mysql://webphpmyadmin.com/db_structure.php?server=1&db","jHd0lWwbzH","7zkZvlj8Mh");
		Statement stmt = conn.createStatement();
		return stmt;
	}
	
	public void Close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static boolean checkVaccine(String btn, String date) throws SQLException {
		int counter = 0;
		
		int temp1=0;
		
		if(btn=="Covishield")
		{
			temp1=1;
		}
		
		else if(btn=="Covaxin")
		{
			temp1=2;
		}
		else if(btn =="Sputnik")
		{
			temp1=3;
		}
		Statement stmt1 = conn.createStatement();
		String q1 = ("select count(appointment_date) from appointment where vaccine_id="+temp1+" and appointment_date='"+date+"'");
		ResultSet ans=stmt1.executeQuery(q1);
		while (ans.next()) {
			counter = ans.getInt(1);
		}
		if (temp1==1 || temp1==2) {
			if (counter<=20) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(temp1==3 && counter<=10) {
			return true;
		}
		return false;
		
	}
	
	public static boolean pushData(String aadhar, String name, String phone, String email, String address,
			String btn , String appointment_date) {
		//String id =String.valueOf(btn);
		
    int temp2=0;
		
		if(btn=="Covishield")
		{
			temp2=1;
		}
		
		else if(btn=="Covaxin")
		{
			temp2=2;
		}
		else if(btn =="Sputnik")
		{
			temp2=3;
		}
		try {
			Statement stmt1 = conn.createStatement();
			String q1="INSERT INTO `users` (`aadhar`, `name`, `phone`, `email`, `address`) VALUES ('"+aadhar+"', '"+name+"', '"+phone+"', '"+email+"', '"+address+"')";
			int ret1 = stmt1.executeUpdate(q1);
			
			String q2="INSERT INTO `appointment` (`aadhar`,vaccine_id, `appointment_date`) VALUES ('"+aadhar+"','"+temp2+"', '"+appointment_date+"')";
			int ret2 = stmt1.executeUpdate(q2);
			
			
			if (ret1==1 || ret2==1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Message = " + e.getMessage());
		}
		return false;
		
		
	}
}