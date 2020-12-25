package myproject;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        //URL of Oracle database server
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "sys as sysdba");
        props.setProperty("password", "admin");

        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url, props);

        String sql = "select * from employee";

        // Demo 1 connect to Oracle PreparedStatement and get data--------------------------
        //creating PreparedStatement object to execute query
//        PreparedStatement preStatement = conn.prepareStatement(sql);
//
//        ResultSet result = preStatement.executeQuery();
//
//        while(result.next()){
//            System.out.println("Current Date from Oracle : " +         result.getString("display_name"));
//        }
//        System.out.println("done");
        // End Demo 1-------------------------------------------------------

        // Demo 2 ----------------------------------------------------------
//        Statement statement = conn.createStatement();
//
//        ResultSet rs = statement.executeQuery(sql);
//        while(rs.next()){
//            System.out.println("Current Date from Oracle : " +         rs.getString("display_name"));
//        }
//        System.out.println("done");
        // End Demo 2-------------------------------------------------------

        // Demo 3 execute---------------------------------------------------
//        Statement statement = conn.createStatement();
//        statement.execute(sql);
//        ResultSet rs = statement.getResultSet();
//        while (rs.next()) {
//            System.out.println("Current Date from Oracle : " + rs.getString("display_name"));
//        }
//        System.out.println("done");
        // End Demo3--------------------------------------------------------

        // Demo 4---------------------------------
//        String insertSql = "insert into employee (id, display_name, user_name) values(135, 'Alex Liu', 'alexliu')";
//        Statement statement = conn.createStatement();
//        int count = statement.executeUpdate(insertSql);
//        System.out.println(count + " record has been insert into table");
        // End Demo 4-----------------------------------------------------

        // Demo 5---------------------------------------------------------
        CallableStatement stmt = conn.prepareCall("{call INSERTER(?,?,?)}");
        stmt.setInt(1,1011);
        stmt.setString(2,"Amit Wang");
        stmt.setString(3,"Amitw");
        stmt.execute();
        System.out.println("execute procedure success");
        // End Demo 5-----------------------------------------------------

        conn.close();
    }
}
