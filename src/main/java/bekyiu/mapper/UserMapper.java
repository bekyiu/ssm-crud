package bekyiu.mapper;

import bekyiu.domain.User;
import bekyiu.query.UserQueryObject;

import java.util.List;

public interface UserMapper
{
    void save(User user);

    void update(User user);

    User get(Long id);

    void delete(Long id);

    List<User> listAll();

    List<User> query(UserQueryObject qo);

    Integer count(UserQueryObject qo);
}
