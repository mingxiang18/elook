package cn.elook.indent.controller;


import cn.elook.common.entity.Indent;
import cn.elook.common.utils.CommonResult;
import cn.elook.indent.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/indent")
public class IndentController {

    @Autowired
    private IndentService indentService;

    @GetMapping("/indent")
    public CommonResult findAll(){
        return indentService.findAll(0,3,"Asc");
    }
}
