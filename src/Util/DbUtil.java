package Util;


import java.sql.Connection;
import java.sql.DriverManager;


public class DbUtil
{
	
  private static  String dbUrl = "jdbc:mysql://localhost:3306/testpaper?useUnicode=true&characterEncoding=UTF8";
  private static  String dbUserName = "root";
  private static  String dbPassword = "123456";
  private static  String jdbcName = "com.mysql.jdbc.Driver";
//  后期做为一个DbUtil工具类  con
  public Connection getCon()
    throws Exception
  {
    Class.forName(this.jdbcName);
    Connection con = DriverManager.getConnection(this.dbUrl, this.dbUserName, this.dbPassword);
    return con;
  }

  public void closeCon(Connection con) throws Exception {
    if (con != null)
      con.close();
  }
  
}

  	
