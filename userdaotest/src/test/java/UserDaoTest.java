

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {

    private UserDao UserDao;

    @Before
    public void setup() {
        UserDao = new UserDao();
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id = 1;
        User user = UserDao.get(id);
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
        Integer id = UserDao.insert(user);

        User insertedUser = UserDao.get(id);
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
}

