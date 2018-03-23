
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;


public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setup() {
        userDao = new UserDao();
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id= 1;
        User user = userDao.get(id);
        int userid = user.getId();
        String username = user.getName();
        String userpassword = user.getPassword();
        System.out.printf("%d %s %s", userid, username, userpassword);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("강다희"));
        assertThat(user.getPassword(), is("1234"));

    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("다희");
        user.setPassword("1111");
        Integer id = userDao.insert(user);
//        User insertedUser = userDao.insert(user);

        User insertedUser = userDao.get(id);
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
}
