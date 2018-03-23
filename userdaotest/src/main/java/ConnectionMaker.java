import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {

    public Connection getConnection() throws ClassNotFoundException, SQLException ;
//         Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost/spring?charactorEncoding=utf-8"
//                , "root", "dahee");
}