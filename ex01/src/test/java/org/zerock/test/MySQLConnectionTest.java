package org.zerock.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	
private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test_ex?userSSL=false&serverTimezone=Asia/Seoul";
	
	private static final String USER =
			"kopoctc";
	
	private static final String PW = 
			"rbxo4158";
	
	@Test
	public void testConnection() throws Exception{
		
		Class.forName(DRIVER);
		
		try(Connection con =DriverManager.getConnection(URL,USER,PW)){
			System.out.println("\n >>>>>>>> Connectino Ãâ·Â : "+con+" \n");
		}catch(Exception e) {
			e.printStackTrace();
		}
				
			
	}

}
