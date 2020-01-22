import com.zhou.dao.IUserDao;
import com.zhou.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        BeanFactory factory = (BeanFactory) context;
        IUserDao userDao = factory.getBean(IUserDao.class);

        User user = userDao.selectUserById(1L);
        System.out.println("user:" + user.toString());

        User user1 = userDao.selectUserByName("jason", "jason-zhou");
        System.out.println("user1:" + user1.toString());

//        User user2 = new User();
//        user2.setName("test5");
//        user2.setMobile("16726789830");
//        user2.setRealName("test5");
//        user2.setCreateTime(new Date());
//        System.out.println("insert result: " + userDao.insertUser1(user2));

        User user3 = new User();
        user3.setName("test3");
        user3.setMobile("16726789848");
        user3.setRealName("test3");
        user3.setCreateTime(new Date());
        User user4 = new User();
        user4.setName("test4");
        user4.setMobile("16726789849");
        user4.setRealName("test4");
        user4.setCreateTime(new Date());
        List<User> userList = new ArrayList<>();
        userList.add(user3);
        userList.add(user4);
        System.out.println("insert batch result: " + userDao.insertUserBatch1(userList));
    }
}
