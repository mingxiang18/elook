package xie.note.controller;

import cn.elook.common.entity.User;
import cn.elook.common.entity.commentPo;
import cn.elook.common.entity.notePo;
import cn.elook.common.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xie.note.service.NoteService;

import javax.servlet.http.HttpServletRequest;

//解决跨域问题
//@CrossOrigin(allowCredentials="true",origins = "*" )
@CrossOrigin(allowCredentials="true" )
@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

//    测试前端跨域
@ResponseBody
@RequestMapping("/test")
public CommonResult test(){

    return  new CommonResult(200,"连接服务器成功");
}


//获取当前登录的uid
@ResponseBody
@RequestMapping("/getUid")
public CommonResult geiUid(HttpServletRequest request){
    User user = (User) request.getSession().getAttribute("loginUser");

    if (user!=null){
        return  new CommonResult(200,"获取到用户名",user);
    }
    return  new CommonResult(202,"当前尚未登录");
}



//    获取首页所有帖子集合
    @ResponseBody
    @RequestMapping("/getAllNotes")
    public CommonResult getAllNotes(){

        return  noteService.getAllNotes();
    }


    //    根据id获取指定的帖子信息
    @ResponseBody
    @GetMapping("/getNote/{nid}")
    public CommonResult getNoteBynid(@PathVariable("nid") int nid) {

        return noteService.getNoteByNid(nid);
    }

//    根据模糊查询获取帖子
    @ResponseBody
    @GetMapping("/getNotes/{condition}")
    public  CommonResult getNotesByCondition(@PathVariable("condition") String condition){
        return noteService.getNotesByCondition(condition);
    }


//    分页获取数据
    @ResponseBody
    @GetMapping("getNotes/{index}/{count}")
    public  CommonResult getNotesByPage(@PathVariable("index") int index,@PathVariable("count") int count){



        return noteService.getNotesByPage(index,count);
    }


    //    根据uid获取用户的所有帖子
    @ResponseBody
    @GetMapping("/getNotesByUid/{uid}")
    public  CommonResult getNotesByUid(@PathVariable("uid") int uid){
       return  noteService.getNoteByUid(uid);
    }


//    根据nid删除帖子
@ResponseBody
@DeleteMapping ("/deleteNote/{nid}")
public  CommonResult deleteNotesByNid(@PathVariable("nid") int nid){

        try{
            noteService.deleteNoteByNid(nid);
        }catch (Exception ex){
            return new CommonResult(444, "删除帖子失败");
        }
    return new CommonResult(200, "删除帖子成功");

}




//    获得分页数据pageBean
    @ResponseBody
    @GetMapping("/getPageBean/{currentCount}/{currentPage}")
    public CommonResult getPageBean(@PathVariable("currentCount") int currentCount,@PathVariable("currentPage") int currentPage){
       return noteService.getPageBean(currentCount,currentPage);
    }



    //    分页获取模糊查询的数据pageBean
    @ResponseBody
    @GetMapping("/getPageBeanByCondition/{currentCount}/{currentPage}/{condition}")
    public CommonResult getPageBeanByCondition(@PathVariable("currentCount") int currentCount,@PathVariable("currentPage") int currentPage,@PathVariable("condition") String condition){
        return noteService.getPageBeanByCondition(currentCount,currentPage,condition);
    }


    //    添加帖子

    @ResponseBody
    @PostMapping ("/addNote")

    public  CommonResult addNote(@RequestBody notePo notePo){

        try{
            noteService.addNotes(notePo);
        }catch (Exception ex){
            return new CommonResult(444, "添加帖子失败");
        }
        return new CommonResult(200, "添加帖子成功");

    }

    //    添加评论
    @ResponseBody
    @PostMapping("/addComment")
    public  CommonResult addComment(@RequestBody commentPo commentPo){

//        System.out.println(commentPo);
//        System.out.println("连接到了");
//        return new CommonResult(200, "添加评论成功");
        try{
            noteService.addComment(commentPo);
        }catch (Exception ex){
            return new CommonResult(444, "添加评论失败");
        }
        return new CommonResult(200, "添加评论成功");

    }
//    删除评论的方法
    @ResponseBody
    @DeleteMapping("/deleteComment/{ncid}")
    public CommonResult deleteCommentByNcid(@PathVariable("ncid") int ncid){
        try {
            noteService.deleteComment(ncid);
        }catch (Exception ex){
            return new CommonResult(444, "删除评论失败");
        }
        return new CommonResult(200, "删除评论成功");
    }
}
