

import java.sql.*;

public class UserDao {
    // connection 후 sql작성, sql 실행, 결과 User에 매핑, 자원 해지, 결과 리턴

    public User get(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/spring?charactorEncoding=utf-8"
                , "root", "dahee");

        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public Integer insert(User user) throws SQLException {
        // connection 후 sql작성, sql 실행, 자원 해지, 결과 리턴
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/spring?characterEncoding=utf-8",
                "root", "dahee");
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into userinfo(name, password) values (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();  // table 갱신

        preparedStatement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Integer id = resultSet.getInt(1);
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return id;
    }
}