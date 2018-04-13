import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {

    private UserDao userDao;
    private DaoFactory daoFactory;


    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean(UserDao.class);
    }
    private User getUser() {
        User user = new User();
        user.setName("다희");
        user.setPassword("1111");
        return user;
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id = 1;
        User user = userDao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("강다희"));
        assertThat(user.getPassword(), is("1234"));
    }
    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = getUser();
        Integer id = userDao.insert(user);

        User insertedUser = userDao.get(id);
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
    @Test
    public void update() throws SQLException, ClassNotFoundException {
        User user = getUser();
        Integer id = userDao.insert(user);

        user.setId(id);
        user.setName("노을");
        user.setPassword("1234");
        userDao.update(user);

        User updatedUser = userDao.get(id);
        assertThat(updatedUser.getId(), is(id));
        assertThat(updatedUser.getName(), is(user.getName()));
        assertThat(updatedUser.getPassword(), is(user.getPassword()));
    }
    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        User user = getUser();
        Integer id = userDao.insert(user);

        userDao.delete(id);

        User deletedUser = userDao.get(id);
        assertThat(deletedUser, nullValue());
    }
}



