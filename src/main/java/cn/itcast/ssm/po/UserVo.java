package cn.itcast.ssm.po;

import java.util.List;

//用户包装类
public class UserVo {

    private User user;

    private List<UserCustom> userList;

    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<UserCustom> getUserList() {
        return userList;
    }

    public void setUserList(List<UserCustom> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
