package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTester {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		try
        {   String filepath="C:\\Users\\886758\\Documents\\M&S\\BP Align Workspace\\StudentManagement\\src\\main\\resources\\DataBase\\StudentDB\\database\\StudentDB.odb";     	
        	Connection conn = createConnection(filepath);//create Connection
        	Statement st = conn.createStatement();//Create Statement
        	//createTable(st);//Create Table
            //insertRow(st);//Insert row into the Table
            //readTable(st);//Read Rows From Table
            //deleteTableDataAll(st);
            //dropTable(st);//Drop Table   
            //listTable(st);
            System.out.println("DONE");            
            st.close();//Close Statement
            conn.close();//Close Connection
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
	}
		
	public static void deleteTableDataAll(Statement st) throws SQLException 
	{
		String deleteTableDataAll = "DELETE FROM STUDENTREGISTRATION";
		//String deleteTableDataSpecific = "DELETE FROM STUDENTREGISTRATION WHERE firstName='kirthi'";
        st.execute(deleteTableDataAll);
	}

	public static void listTable(Statement st) throws SQLException 
	{		  
		ResultSet rs=st.executeQuery("SELECT * FROM INFORMATION_SCHEMA.COLUMNS");  
		while(rs.next())  
		{
			System.out.println(rs.getString(1));
		}
		
	}
	public static void dropTable(Statement s) throws SQLException , IOException
	{
		String dropTable = "DROP TABLE STUDENTREGISTRATION";		
        s.execute(dropTable);
	}
	public static void readTable(Statement s) throws SQLException 
	{
		String readTable = "SELECT * FROM STUDENTREGISTRATION";
        s.execute(readTable);
        ResultSet rs = s.getResultSet();
        System.out.println("***************");
        while((rs!=null) && (rs.next()))
        {        	
        	System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
            System.out.println(rs.getString(6));
            System.out.println(rs.getString(7));
            System.out.println(rs.getString(8));
            System.out.println("===============");
        }
	}
	public static void insertRow(Statement s) throws SQLException, IOException 
	{
		String addRow = "INSERT INTO STUDENTREGISTRATION VALUES ('kirthi','M',24,'ECE','2','kirthi@gmail.com','kirthi','kirthi')";
        try {
			s.execute(addRow);
		} catch (SQLException e) {			
			createTable(s);
			insertRow(s);
		}
	}
	public static void createTable(Statement s) throws SQLException , IOException 
	{
        String createTable = "CREATE TABLE STUDENTREGISTRATION (firstName VARCHAR(32),lastName VARCHAR(32),age INT,department VARCHAR(32),year VARCHAR(32),email VARCHAR(32),password VARCHAR(32),confirmPassword VARCHAR(32))";
        s.execute(createTable);
	}
	public static Connection createConnection(String db_file_name_prefix) throws ClassNotFoundException, SQLException 
	{		             
        Class.forName("org.hsqldb.jdbcDriver");            
        Connection con = DriverManager.getConnection("jdbc:hsqldb:file:" + db_file_name_prefix, "sa", "");        
		return con;
	}
}

