import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException ;
//    {
//            Class.forName("com.mysql.jdbc.Driver");
//            return DriverManager.getConnection("jdbc:mysql://localhost/spring?characterEncoding=utf-8"
//                    , "root", "dahee");
}