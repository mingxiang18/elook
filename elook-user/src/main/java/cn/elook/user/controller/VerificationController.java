package cn.elook.user.controller;

import cn.elook.common.utils.CommonResult;
import cn.elook.user.util.CommonUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@CrossOrigin(allowCredentials="true",maxAge = 3600)
public class VerificationController {
    @Resource
    private DefaultKaptcha captchaProducer;

    @RequestMapping(value = {"/"})
    public String index() {
        return "/index";
    }

    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";
    /**
     * 登录验证码图片
     */
    @RequestMapping(value = {"/loginValidateCode"})
    public void loginValidateCode(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws Exception{
        CommonUtil.validateCode(request,response,captchaProducer,LOGIN_VALIDATE_CODE);
    }

    /**
     * 实时检查验证码是否正确
     */
    @RequestMapping("/checkLoginValidateCode")
    @ResponseBody
    public HashMap checkLoginValidateCode(HttpServletRequest request,HttpServletResponse response  , @RequestParam("validateCode")String validateCode) {
        HttpSession session = request.getSession();
        System.out.println("controler工具里的session：" + session);
        System.out.println("controler里的前台输入的验证码：" + validateCode);
        long validTime = Long.parseLong(String.valueOf(session.getAttribute("validTime")));
        String loginValidateCode = session.getAttribute(LOGIN_VALIDATE_CODE).toString();
        HashMap<String,Object> map = new HashMap<String,Object>();
        if(validateCode == null){//验证码为空时
            map.put("status",false);
        }else {
            if(System.currentTimeMillis() > validTime){//验证码超时
                map.put("status",null);
            }else if(loginValidateCode.equals(validateCode)){//验证码正确
                map.put("status",true);
            }else if(!loginValidateCode.equals(validateCode)){//验证码不正确
                map.put("status",false);
            }
        }

        return map;
    }
    /**
     * 一次性检查验证码是否正确
     */
    @RequestMapping("/checkLoginValidateCode2")
    @ResponseBody
    public CommonResult checkLoginValidateCode2(HttpServletRequest request,@RequestParam("validateCode")String validateCode) {
        HttpSession session = request.getSession();
        CommonResult<Object> result = new CommonResult<>();
        //有效时间
        long validTime = Long.parseLong(String.valueOf(session.getAttribute("validTime")));
        String loginValidateCode = session.getAttribute(LOGIN_VALIDATE_CODE).toString();
        if(loginValidateCode == null){//验证码为空时
            result.setCode(200);
            result.setMessage("验证码为空");
        }else {
            if(System.currentTimeMillis() > validTime){//验证码超时
                result.setCode(201);
                result.setMessage("验证码超时");
            }else if(loginValidateCode.equals(validateCode)){//验证码正确
                result.setCode(202);
                result.setMessage("验证码正确");
            }else if(!loginValidateCode.equals(validateCode)){//验证码不正确
                result.setCode(203);
                result.setMessage("验证码不正确");
            }
        }
        return result;
    }
}
