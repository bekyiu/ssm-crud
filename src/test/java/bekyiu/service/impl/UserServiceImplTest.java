package bekyiu.service.impl;

import bekyiu.domain.User;
import bekyiu.query.PageResult;
import bekyiu.query.UserQueryObject;
import bekyiu.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest
{

    @Autowired
    private IUserService userService;

    @Test
    public void save()
    {
        User u = new User();
        u.setName("neww");
        userService.save(u);
    }

    @Test
    public void update()
    {
        User user = userService.get(25L);
        user.setName("xx");
        userService.update(user);
    }

    @Test
    public void get()
    {
        System.out.println(userService.get(1L));
    }

    @Test
    public void delete()
    {
        userService.delete(25L);
    }

    @Test
    public void listAll()
    {
        userService.listAll().forEach(System.out :: println);
    }

    @Test
    public void query()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 1, 10);
        Date time = calendar.getTime();
        UserQueryObject qo = new UserQueryObject();
//        qo.setName("i");
        qo.setBeginDate(time);
//        qo.setEndDate(new Date());
        qo.setCurrentPage(1);
        qo.setPageSize(3);
        PageResult query = userService.query(qo);
        System.out.println(query);
    }
}