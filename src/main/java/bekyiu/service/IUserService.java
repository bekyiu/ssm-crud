package bekyiu.service;

import bekyiu.domain.User;
import bekyiu.query.PageResult;
import bekyiu.query.UserQueryObject;

import java.util.List;

public interface IUserService
{
    void save(User user);

    void update(User user);

    User get(Long id);

    void delete(Long id);

    List<User> listAll();

    PageResult query(UserQueryObject qo);

    Integer count(UserQueryObject qo);
}
