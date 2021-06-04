

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class logingDao {
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public String check(String name, String pwd){
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select name from example.student where password = ? and rollno = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, pwd);
			ps.setString(2,name);
			ResultSet rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		String[] s = result.split(",");
		if(s[0]!="not execured")
			return "yes";
		else{
			return "No";
		}
	}
	public String candidateCheck(String roll) {
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select electype from example.candidate where rollno = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, roll);
			ResultSet rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		String[] s = result.split(",");
		if(s[0]=="not execured")
			return "yes";
		else{
			return s[0];
		}
}
	public String VoteCollege(String roll) {
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select rollno from example.college where rollno = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, roll);
			ResultSet rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		return result;
}
	public String VoteDept(String roll) {
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select rollno from example.dept where rollno = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, roll);
			ResultSet rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		return result;
}
	public String VoteYear(String roll) {
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select rollno from example.year where rollno = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, roll);
			ResultSet rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		return result;
}
	public String deptCheck(String roll){
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select rollno from example.student where rollno = ? && dept = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, roll);
			ps.setString(2,"IT");
			ResultSet rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		return result;
	}
	public String yearCheck(String roll){
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select rollno from example.student where rollno = ? && year = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, roll);
			ps.setInt(2,4);
			ResultSet rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		return result;
	}
	public String insert(String roll,String v){
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String rowCount = "select count(*) from example.candidate;";
		int count = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(rowCount);
		      //Retrieving the result
		      rs.next();
		      count = rs.getInt(1);
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "insert into example.candidate values(?,?,?,?);";
		String result="";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			String h = "";
			ps.setString(1,roll);
			ps.setString(2,v);
			ps.setInt(3,0);
			ps.setInt(4,count+1);
			int i = ps.executeUpdate();
			result = "yes";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			result = "election not created";
		}
		return result;
	}
	public String addcandidate(String roll, String v) {
		String x = "";
		if(v.equals("department-IT")){
			String s = deptCheck(roll);
			if(!s.equals(roll)){
				return "only IT dept students are allowed to register";
			}
			else{
				
			 x = insert(roll,v);
			}
		}
		else if(v.equals("IT-4-year")){
			String s = deptCheck(roll);
			String ss = yearCheck(roll);
			if(!s.equals(roll)|| !ss.equals(roll)){
				return "only IT dept 4th year students are only allowed to get register";
			}
			else{
				
			 x = insert(roll,v);
			}
		}
		else{
			x = insert(roll,v);
		}
		return x;
}
	public String  collegeInsert(String roll, String s) {
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String sql = "insert into example.college values(?,?);";
		String result="";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			String h = "";
			ps.setString(1,roll);
			ps.setInt(2,Integer.parseInt(s));
			int i = ps.executeUpdate();
			result = "yes";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			result = "election not created";
		}
		return result;	
		
	}
	public String yearInsert(String roll, String s) {
		// TODO Auto-generated method stub
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String sql = "insert into example.year values(?,?);";
		String result="";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			String h = "";
			ps.setString(1,roll);
			ps.setInt(2,Integer.parseInt(s));
			int i = ps.executeUpdate();
			result = "yes";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			result = "election not created";
		}
		return result;	
		
	}
	public String deptInsert(String roll, String s) {
		// TODO Auto-generated method stub
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String sql = "insert into example.dept values(?,?);";
		String result="";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			String h = "";
			ps.setString(1,roll);
			ps.setInt(2,Integer.parseInt(s));
			int i = ps.executeUpdate();
			result = "yes";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			result = "election not created";
		}
		return result;	
		
	}
}
