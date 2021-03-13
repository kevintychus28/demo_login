package dao;

import entity.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> login(String username, String password){
        Connection connection = null;
        List<User> userList = new ArrayList<>();
        PreparedStatement prepareStatement  = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            //3.写sql语句
            String sql = "select * from user where username=? and password=?";
            //4.获得statement对象
            prepareStatement  = connection.prepareStatement(sql);
            prepareStatement .setString(1,username);
            prepareStatement .setString(2,password);
            //5.执行sql 得到结果集
            resultSet = prepareStatement .executeQuery();
            //6.处理结果集
            while (resultSet.next()){
                User user = new User();
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                userList.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.关闭资源
            try {
                DBUtil.closeAll(resultSet,prepareStatement,connection);
            } catch (SQLException e){
                e.printStackTrace();
            }

        }

        return userList;
    }

}

