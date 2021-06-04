import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class adminDao {
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
	public String setStatus(String s){
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "update example.admin set status = ? where time=?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			String v = "p";
			ps.setString(1, s);
			ps.setString(2,v);
			boolean  r =ps.execute();
		    //rs.next();
		    //result = rs.getString(1);
		    result = "hi";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		return result;
	}
	public String getStatus(){
		loadDriver("com.mysql.jdbc.Driver");
		Connection con =  getConnection();
		String result = "";
		String sql = "select status from example.admin where time = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			String v = "p";
			ps.setString(1, v);
			ResultSet  rs =ps.executeQuery();
		    rs.next();
		    result = rs.getString(1);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "not execured";
		}
		return result;
	}
}
