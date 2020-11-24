package cn.elook.indent.test;


import cn.elook.common.entity.Indent;
import cn.elook.indent.ElookIndentApplication;
import cn.elook.indent.service.IndentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElookIndentApplication.class})
public class IndentTest {

    @Autowired
    private IndentService indentService;

    @Test
    public void findAllTest(){
        List<Indent> list = indentService.findAll();
        for (Indent indent : list){
            System.out.println(indent);
        }
    }

    @Test
    public void saveIndent(){
        Indent indent = new Indent();

    }

}
