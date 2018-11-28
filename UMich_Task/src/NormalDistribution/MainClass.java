package NormalDistribution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class MainClass {

	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:h2:"+"./Database/MyDataBase", "root", "password");
		System.out.println("DataBaseCreated");
		Statement stmt=con.createStatement();
		String createTable="CREATE TABLE IF NOT EXISTS TABLE2"
							+"(NDNumber NUMBER)";
		stmt.executeUpdate(createTable);
		System.out.println("Table Created");
		//Form an array list which contains all the ND numbers and store that number in the table
		ArrayList<Double> list1=new ArrayList<Double>();
		Random r=new Random();
		for(int i=0;i<100000;i++)
		{
			list1.add(r.nextGaussian()*100+500);
			String sql="INSERT INTO TABLE1 (NDNumber)"+"VALUES("+r.nextGaussian()*100+500+")";
			stmt.execute(sql);
			
		}
		System.out.println("Data Entered");
		
		
		
		
		
		
		

	}

}
