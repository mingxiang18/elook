package cn.elook.user.service;

import cn.elook.common.entity.PageRequest;
import cn.elook.common.entity.PageResult;
import cn.elook.common.entity.User;
import cn.elook.user.dao.UserDao;
import cn.elook.user.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //通过主键查询用户
    public User selectUserByUid(Long uid){
        User user = userDao.selectUserByUid(uid);
        return user;
    }

    //通过用户名查询用户
    public User selectUserByUsername(String username){
        User user = userDao.selectUserByUsername(username);
        return user;
    }
    //注册用户
    public void insertUser(User user){
        userDao.insertUser(user);
    }
    //根据用户名和密码查询用户
    public User selectUserByUnameAndPword(String username,String password){
        User user = userDao.selectUserByUnameAndPword(username, password);
        return user;
    }

    //更新用户信息
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    //根据电话号码查询用户
    public User selectUserByphone(String phone){
        return userDao.selectUserByphone(phone);
    }

    //根据用户名去修改密码
    public void changePassword(String newPassword,String username){
        userDao.changePassword(newPassword,username);
    }

    //查询所有用户的所有信息
    public List<User> selectAllUsers(){
        List<User> users = userDao.selectAllUsers();
        return users;
    }

    //查询除了超级管理员的所有用户的所有信息
    public List<User> selectAllUsers2(){
        return userDao.selectAllUsers2();
    }

    //根据用户名删除用户信息
    public void deleteUser(String username){
        userDao.deleteUser(username);
    }

    //分页查询用户
    public PageResult pagingSelectUsers(PageRequest pageRequest){
        //根据请求参数和PageInfo来制作分页查询的结果
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest));
    }

    //调用分页插件完成分页
    private PageInfo<User> getPageInfo(PageRequest pageRequest){
        //请求的页面是第几页
        int currentPage = pageRequest.getCurrentPage();
        //每一页的记录条数
        int pageSize = pageRequest.getPageSize();
        //根据这两个参数进行分页，而且分页的效果只对接下来的一次查询有效，也就是再下面的一条查询语句：List<User> users = userDao.pagingSelectUsers()
        PageHelper.startPage(currentPage,pageSize);
        List<User> users = userDao.pagingSelectUsers();
        return new PageInfo<User>(users);
    }

    //对用户名和手机号码进行模糊查询
    public List<User> fuzzySelectUsers(String keyword){
        return userDao.fuzzySelectUsers(keyword);
    }

}
