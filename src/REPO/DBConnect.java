package REPO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBConnect {
  public static String USER = "sa";
    public static String PASSWORD = "123";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=DA2;encrypt=true;trustServerCertificate=true; ";
     static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static Connection getConnection(){
        Connection cn = null;
        try {
            cn= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
      }
        public static void main(String[] args) {
        Connection cn = getConnection();
        if (cn!=null) {
            System.out.println("Connect Success");
        }else{
           System.out.println("Connect Error"); 
        }
    }
}
