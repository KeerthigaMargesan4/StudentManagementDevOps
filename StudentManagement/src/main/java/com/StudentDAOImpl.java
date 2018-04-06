package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class StudentDAOImpl implements StudentDAO
{
	public static final String SUCCESS="Success";
	public static final String FAILED="Failed";
	public static final String filepath="C:\\Users\\886758\\Documents\\M&S\\BP Align Workspace\\StudentManagement\\src\\main\\resources\\DataBase\\StudentDB\\database\\StudentDB.odb";
	
	public Connection createConnection(String db_file_name_prefix) throws ClassNotFoundException, SQLException 
	{		             
        Class.forName("org.hsqldb.jdbcDriver");            
        Connection con = DriverManager.getConnection("jdbc:hsqldb:file:" + db_file_name_prefix, "sa", "");        
		return con;
	}
	public void createTable(Statement s) throws SQLException , IOException 
	{
		String createTable = "CREATE TABLE STUDENTREGISTRATION (firstName VARCHAR(32),lastName VARCHAR(32),age INT,department VARCHAR(32),year VARCHAR(32),email VARCHAR(32),password VARCHAR(32),confirmPassword VARCHAR(32))";
        s.execute(createTable);
	}
	public void insertRow(Statement s,StudentRegister student) throws SQLException, IOException 
	{
		String addRow = "INSERT INTO STUDENTREGISTRATION VALUES ("+student+")";
        try {
			s.execute(addRow);
		} catch (SQLException e) {			
			createTable(s);
			insertRow(s,student);
		}
	}
	public ResultSet readTable(Statement s) throws SQLException 
	{
		String readTable = "SELECT * FROM STUDENTREGISTRATION";
        s.execute(readTable);
        ResultSet rs = s.getResultSet();
        return rs;
	}
	/*public static void deleteRow(Statement st,StudentRegister student) throws SQLException 
	{		
		String deleteTableDataSpecific = "DELETE FROM STUDENTREGISTRATION WHERE firstName='kirthi'";
        st.execute(deleteTableDataSpecific);
	}*/
	@Override
	public String addStudent(StudentRegister student) throws ClassNotFoundException, SQLException 
	{		
		String status= SUCCESS;
		Connection con=null;
		Statement st = null;
		try{	
			con=createConnection(filepath);
			st = con.createStatement();
			insertRow(st,student);			
			}
			catch(Exception e)
			{								
				status=FAILED;			 
			}
			finally
			{
				 st.close();//Close Statement
		         con.close();//Close Connection
			}		
			return status;
	}
	@Override
	public String signinStudent(StudentRegister student) throws ClassNotFoundException, SQLException
	{		
		String status= FAILED;
		Connection con=null;
		Statement st = null;
		try{	
			con=createConnection(filepath);
			st = con.createStatement();
	        ResultSet rs = readTable(st);
	        	while((rs!=null) && (rs.next()))
	        	{
	        		if(rs.getString(1).equals(student.getFirstName()))
	        		{
	        			if(rs.getString(7).equals(student.getPassword()))
	        			{
	        				status=SUCCESS;
	        			}
	        		}	        		            				
	        	}			
			}
			catch(Exception e)
			{
			 status=FAILED;			 
			}
			finally
			{
				 st.close();//Close Statement
		         con.close();//Close Connection
			}		
			return status;
	}
	
}
