package xie.note.controller;

import cn.elook.common.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xie.note.service.NoteService;

//解决跨域问题
@CrossOrigin(allowCredentials="true",origins = "*")
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

    }
