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
		String createTable="CREATE TABLE IF NOT EXISTS TABLE1"
							+"(NDNumber NUMBER)";
		stmt.executeUpdate(createTable);
		System.out.println("Table Created");
		//Form an array list which contains all the ND numbers and store that number in the table
		Random r=new Random();
		for(int i=0;i<100000;i++)
		{
			String sql="INSERT INTO TABLE1 (NDNumber)"+"VALUES("+r.nextGaussian()*100+500+")";
			stmt.execute(sql);
			
		}
		System.out.println("Data Entered");
		System.out.println("Extract data from the table and apply formula");
		String query1="Select avg(distinct(NDNumber)) as Average from TABLE1";
		ResultSet x=stmt.executeQuery(query1);
		if(x.next())
		{
			System.out.println(x.getString("Average"));
		}
		System.out.println("Task Completed");
		
		
		
		
		
		
		
		

	}

}
