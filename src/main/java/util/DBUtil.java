package util;

import java.sql.*;

public class DBUtil {

    static String DBurl = "jdbc:mysql://localhost:3306/demo_login?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static String user = "root";
    static String password = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.创建连接
        Connection connection = DriverManager.getConnection(DBurl,user,password);
        System.out.println("创建连接成功");
        return connection;
    }

    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet!=null){
            resultSet.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (connection!=null){
            connection.close();
        }

    }
}
