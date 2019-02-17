package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.User;
import cn.itcast.ssm.po.UserCustom;
import java.util.List;

public interface UserMapperCustom {

    public List<User> findUserByNameandpwd(User user)throws Exception;

    public List<User> findUserByName(User user)throws Exception;

    public void insertUser(User user)throws Exception;

    public List<User> checkUserByName(String username)throws Exception;

}
