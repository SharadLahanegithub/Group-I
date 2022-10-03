package com.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class MyClass {
	
//	ArrayList<String> al = new ArrayList<String>();
	
	
	public static Connection letConnect() {
		
		Connection con = null;
		
		try {
	        //step 1
            Class.forName("com.mysql.jdbc.Driver");
            //step 2
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Banereal@1997");
           // System.out.println("All Student Score list");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public Connection FetchData() {
		
		Connection con= letConnect();
		Quiz qz = new Quiz();
		qz.displayQuestionsAndCalculateMarks();
		  System.out.println("All Student Score list>>>");
		String sql = "select * from test.studentdetails ";
		    	try {
		    		java.sql.Statement st = con.createStatement();
		    		ResultSet rs = st.executeQuery(sql);
		    	
		    	//	ArrayList<String> studentname = new ArrayList<String>();
		    	//	Collection.sort(al);
		    		while(rs.next()) {
		    	//		Collections.sort(studentname);
		   			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		   			
		    		}
		    		
		    	}catch (Exception e) {
		    		e.printStackTrace();
		   	}
		    	return con;
		   } 
	public static Connection getUserByID()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id to get the specific record : ");
		
		int qid=sc.nextInt();
		
		Connection con= letConnect();
		try {
			
			String sql = "select qid,studentname,score from test.studentdetails where qid= " + qid;
			java.sql.Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
				
			
			
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));	
			
			}	
			
		
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	}


