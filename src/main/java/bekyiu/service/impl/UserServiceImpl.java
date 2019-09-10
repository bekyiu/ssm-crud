package bekyiu.service.impl;

import bekyiu.domain.User;
import bekyiu.mapper.UserMapper;
import bekyiu.query.PageResult;
import bekyiu.query.UserQueryObject;
import bekyiu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user)
    {
        userMapper.save(user);
    }

    @Override
    public void update(User user)
    {
        userMapper.update(user);
    }

    @Override
    public User get(Long id)
    {
        return userMapper.get(id);
    }

    @Override
    public void delete(Long id)
    {
        userMapper.delete(id);
    }

    @Override
    public List<User> listAll()
    {
        return userMapper.listAll();
    }

    @Override
    public PageResult query(UserQueryObject qo)
    {
        Integer count = userMapper.count(qo);
        if(count <= 0)
        {
            return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
        }
        List<User> list = userMapper.query(qo);
        return new PageResult(list, count, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public Integer count(UserQueryObject qo)
    {
        return userMapper.count(qo);
    }
}
