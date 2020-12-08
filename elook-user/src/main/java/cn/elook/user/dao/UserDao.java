package cn.elook.user.dao;

import cn.elook.common.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {
    //通过主键查询用户
    @Select("select * from user where uid = #{uid}")
    public User selectUserByUid(Long uid);

    //通过用户名查询用户
    @Select("select * from user where username = #{username}")
    public User selectUserByUsername(String username);

    //注册用户
    @Insert("insert into user(username,password) values(#{username},#{password})")
    public void insertUser(User user);

    //根据用户名和密码查询用户
    @Select("select * from user where username=#{username} and password=#{password}")
    public User selectUserByUnameAndPword(String username,String password);

    //更新用户个人信息（不含密码）
    @Update("update user set phone = #{phone},sex = #{sex},photo = #{photo} where username = #{username}")
    public void updateUser(User user);

    //根据电话号码查询用户
    @Select("select * from user where phone = #{phone}")
    public User selectUserByphone(String phone);

    //根据用户名去修改密码
    @Update("update user set password = #{newPassword} where username = #{username}")
    public void changePassword(String newPassword,String username);

    //查询所有用户的所有信息
    @Select("select * from user")
    public List<User> selectAllUsers();

    //查询除了超级管理员的所有用户的所有信息
    @Select("select * from user where level = 0")
    public List<User> selectAllUsers2();

    //根据用户名删除用户信息
    @Delete("delete from user where username = #{username}")
    public void deleteUser(String username);

    //分页查询用户
    @Select("select * from user where level = 0")
    public List<User> pagingSelectUsers();

    //对用户名和手机号码进行模糊查询
    @Select("select * from user where ((username like concat('%',#{keyword},'%')) or (phone like concat('%',#{keyword},'%'))) and level = 0 ")
    public List<User> fuzzySelectUsers(String keyword);

}
