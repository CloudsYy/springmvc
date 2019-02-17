package cn.itcast.ssm.service.Imp;

import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.mapper.UserMapperCustom;
import cn.itcast.ssm.po.User;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class userImp implements UserService {

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserByNameandpwd(User user) throws Exception {

        return userMapperCustom.findUserByNameandpwd(user);
    }

    @Override
    public List<User> findUserByName(User user) throws Exception {
        return userMapperCustom.findUserByName(user);
    }

    @Override
    public void insertUser(User user) throws Exception {
        userMapperCustom.insertUser(user);
    }

    @Override
    public List<User> checkUserByName(String username) throws Exception {
        return userMapperCustom.checkUserByName(username);
    }

}
