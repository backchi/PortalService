import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JejuConnectionMaker implements ConnectionMaker {
    @Value("${db.classname}")
    private String classname;
    @Value("${db.url}")
    private String url; //"jdbc:mysql://localhost/spring?characterEncoding=utf-8"
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(classname);
            return DriverManager.getConnection(url, username, password);
    }

//    public void setClassname(String classname) {
//        this.classname = classname;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
