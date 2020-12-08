package cn.elook.user.controller;

import cn.elook.common.entity.PageRequest;
import cn.elook.common.entity.PageResult;
import cn.elook.common.entity.User;
import cn.elook.common.utils.CommonResult;
import cn.elook.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowCredentials="true",maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";

    //测试
    @RequestMapping("/nicetomeetyou")
    public void hello(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/").forward(request,response);

    }

    //根据用户名验证用户是否存在
    @PostMapping("/isUsernameExist")
    @ResponseBody
    public CommonResult isUsernameExist(String username,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.selectUserByUsername(username);
        CommonResult<Object> result = new CommonResult<>();
        if(user != null){//用户存在时
            result.setCode(201);
            result.setMessage("用户名已存在，可直接登录");
        }else{//用户不存在时
            //如果用户不存在，那么存入一个标识，告诉前台跳转到下一个页面
            result.setCode(200);
            result.setMessage("用户名不存在，可以注册");
        }
        return result;
    }

    /**
     * 一次性检验 验证码和密码是否正确
     *  @RequestParam("validateCode")
     */
    @PostMapping("/checkRegister")
    @ResponseBody
    public CommonResult checkRegister(HttpServletRequest request,HttpServletResponse response,String validateCode,String password,String username) throws IOException {
        System.out.println(username);
        System.out.println(password);
        System.out.println(validateCode);
        HttpSession session = request.getSession();
//        System.out.println("检查验证码和密码的session：" + session);
        CommonResult<Object> result = new CommonResult<>();
        //有效时间
        long validTime = Long.parseLong(String.valueOf(session.getAttribute("validTime")));
        String loginValidateCode = session.getAttribute(LOGIN_VALIDATE_CODE).toString();
        if(validateCode == null){//验证码为空时
            result.setCode(200);
            result.setMessage("验证码为空");
        }else {
            if(System.currentTimeMillis() > validTime){//验证码超时
                result.setCode(201);
                result.setMessage("验证码超时");
            }else if(loginValidateCode.equals(validateCode)){//验证码正确
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userService.insertUser(user);
//                session.setAttribute("loginUser",user);
                result.setCode(202);
                result.setMessage("注册成功");
            }else if(!loginValidateCode.equals(validateCode)){//验证码不正确
                result.setCode(203);
                result.setMessage("验证码不正确");
            }
        }
        return result;
    }

    //登陆验证
    @PostMapping("/checkLogin")
    @ResponseBody
    public CommonResult checkLogin(String username,String password,HttpServletRequest request){
        System.out.println(username);
        System.out.println(password);
        User user = userService.selectUserByUnameAndPword(username, password);
        CommonResult<Object> result = new CommonResult<>();
        if(user == null){
            result.setCode(200);
            result.setMessage("用户名或密码错误");
        }else {
            request.getSession().setAttribute("loginUser",user);
            result.setCode(201);
            result.setMessage("登录成功，整个用户信息已经存储在session中");
        }
        return result;
    }

    //登陆验证：当level为1的时候，即为管理员
    @PostMapping("/checkLogin2")
    @ResponseBody
    public CommonResult checkLogin2(String username,String password,HttpServletRequest request){
        System.out.println(username);
        System.out.println(password);
        User user = userService.selectUserByUnameAndPword(username, password);
        CommonResult<Object> result = new CommonResult<>();
        if(user == null){
            result.setCode(200);
            result.setMessage("用户名或密码错误");
        }else {
            Integer level = user.getLevel();
            if(level == 1){
                request.getSession().setAttribute("loginUser",user);
                result.setCode(201);
                result.setMessage("登录成功，整个用户信息已经存储在session中");
            }else if(level == 0){
                result.setCode(202);
                result.setMessage("登录失败，该用户不是管理员");
            }
        }
        return result;
    }

    //根据用户名查询个人信息
    @GetMapping("/personalInForm")
    @ResponseBody
    public CommonResult personalInForm(String username){
        User user = userService.selectUserByUsername(username);
        CommonResult<Object> result = new CommonResult<>();
        result.setCode(200);
        result.setMessage("个人信息");
        result.setData(user);
        return result;
    }

    //根据用户名查询个人信息
    @PostMapping("/personalInForm2")
    @ResponseBody
    public CommonResult personalInForm2(String username){
        System.out.println(username);
        User user = userService.selectUserByUsername(username);
        CommonResult<Object> result = new CommonResult<>();
        result.setCode(200);
        result.setMessage("个人信息");
        result.setData(user);
        return result;
    }

    //从session中将用户信息取出
    @GetMapping("/showPersonalInfo")
    @ResponseBody
    public CommonResult showPersonalInfo(HttpServletRequest request){
        CommonResult<Object> result = new CommonResult<>();
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        result.setCode(200);
        result.setMessage("Ajax获取个人信息成功！");
        result.setData(loginUser);
        return result;
    }

    /**
     * 普通用户自身修改用户信息；
     * 修改的信息中，只有电话可能是重复的；
     * 只更改了电话、性别、头像
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/updateUserInfo")
    @ResponseBody
    public CommonResult updateUserInfo(User user,HttpServletRequest request){
        System.out.println(user.getPhoto());
        CommonResult<Object> result = new CommonResult<>();
        String enterPhone = user.getPhone();    //用户重新输入的电话
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        //要把用户当前没改的信息放到新的user里
        user.setUsername(loginUser.getUsername());
        user.setUid(loginUser.getUid());
        user.setPassword(loginUser.getPassword());
        user.setLevel(loginUser.getLevel());
        String currentPhone = loginUser.getPhone();    //用户当前电话
        if(currentPhone == null){  //用户电话本身就是空的时候
            //输入的电话来查询用户
            User user2 = userService.selectUserByphone(enterPhone);
            if(user2 == null){
                //更新数据库用户数据
                userService.updateUser(user);
                //更新session中保存的登录的用户
                session.setAttribute("loginUser",user);
                result.setCode(200);
                result.setMessage("电话没改，所以直接更新用户信息成功！");
            }else {
                result.setCode(202);
                result.setMessage("电话号码已经存在，更新用户信息失败！");
            }
        }else if(currentPhone.equals(enterPhone)){   //电话号码没有修改时
            //更新数据库用户数据
            userService.updateUser(user);
            //更新session中保存的登录的用户
            session.setAttribute("loginUser",user);
            result.setCode(200);
            result.setMessage("电话没改，所以直接更新用户信息成功！");
        }else {
            User user1 = userService.selectUserByphone(enterPhone);
            if(user1 == null){  //电话号码没被注册时
                //更新数据库用户数据
                userService.updateUser(user);
                //更新session中保存的登录的用户
                session.setAttribute("loginUser",user);
                result.setCode(201);
                result.setMessage("电话已修改，更新用户信息成功！");
            }else if (user1 != null){   //电话号码已经被注册
                result.setCode(202);
                result.setMessage("电话号码已经存在，更新用户信息失败！");
            }
        }
        return result;
    }

    /**
     * 超级管理员修改用户信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/updateUserInfo2")
    @ResponseBody
    public CommonResult updateUserInfo2(User user,HttpServletRequest request){
        CommonResult<Object> result = new CommonResult<>();
        System.out.println(user);
        userService.updateUser(user);
        result.setCode(200);
        result.setMessage("更新成功！");
        return result;
    }

    //修改密码
    @PostMapping("/changePassword")
    @ResponseBody
    public CommonResult changePassword(String oldPassword,String newPassword,HttpServletRequest request){
        CommonResult<Object> result = new CommonResult<>();
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        String nowPassword = loginUser.getPassword();
        if(nowPassword.equals(oldPassword)){
            String username = loginUser.getUsername();
            userService.changePassword(newPassword,username);
            result.setCode(200);
            result.setMessage("修改密码成功！");
        }else {
            result.setCode(201);
            result.setMessage("修改密码失败！");
        }
        return result;
    }

    //显示所有用户的所有信息
    @GetMapping("/users")
    @ResponseBody
    public CommonResult selectAllUsers(){
        CommonResult<Object> result = new CommonResult<>();
        List<User> users = userService.selectAllUsers();
        result.setCode(200);
        result.setMessage("查询所有用户的所有信息成功！");
        result.setData(users);
        return result;
    }

    //显示除了超级管理员的所有用户的所有信息
    @GetMapping("/users2")
    @ResponseBody
    public CommonResult selectAllUsers2(){
        CommonResult<Object> result = new CommonResult<>();
        List<User> users = userService.selectAllUsers2();
        result.setCode(200);
        result.setMessage("查询所有用户的所有信息成功！");
        result.setData(users);
        return result;
    }

    //根据用户名删除用户
    @PostMapping("/deleteUser")
    @ResponseBody
    public CommonResult deleteUserByUsername(String username){
        CommonResult<Object> result = new CommonResult<>();
        userService.deleteUser(username);
        result.setCode(200);
        result.setMessage("删除用户成功！");
        return result;
    }

    //分页查询，查询参数分别是：currentPage当前页码，pageSize每页的记录条数
    @PostMapping("/pagingSelectUsers")
    @ResponseBody
    public CommonResult pagingSelectUsers(PageRequest pageRequest){
        CommonResult<Object> result = new CommonResult<>();
        //pageResult是分页查询的结果，包括：当前页面、每页记录条数、总记录数、总页码数、当前页码的记录数据
        PageResult pageResult = userService.pagingSelectUsers(pageRequest);
        result.setCode(200);
        result.setMessage("分页查询成功！");
        result.setData(pageResult);
        return result;
    }

    //循环插入数据
    @GetMapping("/insertUsers")
    @ResponseBody
    public CommonResult insertUsers(){
        CommonResult<Object> result = new CommonResult<>();
        for(int i = 1 ; i <= 40; i++){
            User user = new User();
            user.setUsername(i + "qwe");
            user.setPassword("123");
            userService.insertUser(user);
        }
        result.setCode(200);
        result.setMessage("循环插入数据成功！");
        return result;
    }
    
    //根据用户名和手机号的模糊查询来查询用户
    @PostMapping("/fuzzySelect")
    @ResponseBody
    public CommonResult fuzzySelectUsers(String keyword){
        CommonResult<Object> result = new CommonResult<>();
        List<User> users = userService.fuzzySelectUsers(keyword);
        result.setCode(200);
        result.setMessage("根据用户名和手机号的模糊查询——成功！");
        result.setData(users);
        return result;
    }

    //根据主键获取用户信息
    @GetMapping("/getUser")
    @ResponseBody
    public CommonResult getUser(Long uid){
        CommonResult<User> result = new CommonResult<>();
        User user = userService.selectUserByUid(uid);
        user.setPassword(null);
        result.setCode(200);
        result.setMessage("获取用户成功！");
        result.setData(user);
        return result;
    }
    //退出
    @GetMapping("/exit")
    @ResponseBody
    public CommonResult exit(HttpServletRequest request){
        CommonResult<Object> result = new CommonResult<>();
        request.getSession().setAttribute("loginUser",null);
        result.setCode(200);
        result.setMessage("退出成功！");
        return result;
    }

}
