package xie.note.service;

import cn.elook.common.entity.PageBean;
import cn.elook.common.entity.note;
import cn.elook.common.utils.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xie.note.dao.NoteMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class NoteService {
@Autowired
NoteMapper noteMapper;

    //获取首页所有帖子项
    public CommonResult getAllNotes() {
        List<note> allNotes = noteMapper.getAllNotes();
        if(allNotes.size()!=0){
            return new CommonResult(200,"帖子数据加载成功",allNotes);
        }else {
            return new CommonResult(444,"无帖子数据");
        }
    }


//    根据id获取指定帖子
    public CommonResult getNoteByNid(int nid){
        note noteByNid = noteMapper.getNoteByNid(nid);
        return new CommonResult(200,"帖子数据加载成功",noteByNid);
    }


    //根据关键字查找帖子集合
    public CommonResult getNotesByCondition( String condition){
        System.out.println(condition);
//        先判断有没有空格服 有就断成两个 查询两次
        String[] split = condition.split(" +");
        System.out.println(split.length);
        List<note> allNotes =new ArrayList<note>();
        for (String s : split) {

            List<note> allNotesByCondition = noteMapper.getAllNotesByCondition("%"+s+"%");
            System.out.println(allNotesByCondition);
            allNotes.addAll(allNotesByCondition);
        }
        if(allNotes.size()!=0){
            return new CommonResult(200,"帖子数据加载成功",allNotes);
        }else {
            return new CommonResult(444,"无帖子数据");
        }
    }

//    分页查询功能
    public CommonResult getNotesByPage(int index ,int count){
        List<note> allNotes = noteMapper.getAllNotesByPage(index, count);
        if(allNotes.size()!=0){
            return new CommonResult(200,"帖子数据加载成功",allNotes);
        }else {
            return new CommonResult(444,"无帖子数据");
        }

    }


    //    根据uid获取用户的所有帖子
    public CommonResult getNoteByUid(int uid){
        List<note> notesByUid = noteMapper.getNotesByUid(uid);
        if (notesByUid.size()!=0){
            return new CommonResult(200,"帖子数据加载成功",notesByUid);
        }
        else {
            return new CommonResult(444,"该用户无帖子数据");
        }
    }


//    根据帖子id删除提诶子
@Transactional
public void deleteNoteByNid(int nid){
    //    需要先删字表里的数据

    noteMapper.deleteCommentByNid(nid);
    noteMapper.deletePhotoByNid(nid);

    noteMapper.deleteProductByNid(nid);

    noteMapper.deleteNoteByNid(nid);


}
//获取系统总页数
    public CommonResult countOfNotes(){
        int i = noteMapper.countOfNotes();
        return new CommonResult(200,"成功查询到系统中帖子的数量",i);
    }


    //获得分页数据pageBean
    public CommonResult getPageBean(int currentCount,int currentPage){

        PageBean pageBean = new PageBean();
        //		设置当前页面 页面显示数
        pageBean.setCurrentCount(currentCount);
//		pageBean.setCurrentPage(1);
        pageBean.setCurrentPage(currentPage);

//		获得总条数
        int count = noteMapper.countOfNotes();
        pageBean.setTotalCount(count);
//		设置总页数
        int totalPage = (int) Math.ceil(1.0*count/pageBean.getCurrentCount());
        pageBean.setTotalPage(totalPage);

//		分页查询获得notesList
        int index = (pageBean.getCurrentPage()-1)*(pageBean.getCurrentCount());
//        List<Product> ProductList = dao.findProductListForPageBeanByCid(index,pageBean.getCurrentCount(),parameter);
        List<note> allNotesByPage = noteMapper.getAllNotesByPage(index, pageBean.getCurrentCount());
//		设置pageBean的notesList
       pageBean.setNotes(allNotesByPage);

        return new CommonResult(200,"成功查询到该页的数据", pageBean);
    }


    //获取模糊查询总页数
    public CommonResult countOfNotes(String condition){
        int i = noteMapper.countOfNotesByCondition(condition);
        return new CommonResult(200,"成功查询到符合帖子的数量",i);
    }

    //分页获取模糊查询数据pageBean
    public CommonResult getPageBeanByCondition(int currentCount,int currentPage,String condition){

        PageBean pageBean = new PageBean();
        //		设置当前页面 页面显示数
        pageBean.setCurrentCount(currentCount);
//		pageBean.setCurrentPage(1);
        pageBean.setCurrentPage(currentPage);

//		获得总条数
        int count = noteMapper.countOfNotesByCondition(condition);
        pageBean.setTotalCount(count);
//		设置总页数
        int totalPage = (int) Math.ceil(1.0*count/pageBean.getCurrentCount());
        pageBean.setTotalPage(totalPage);

//		分页查询获得notesList
        int index = (pageBean.getCurrentPage()-1)*(pageBean.getCurrentCount());
        HashMap<String, Object> map = new HashMap<>();
        map.put("index",index);
        map.put("count",pageBean.getCurrentCount());
        map.put("condition",condition);
        List<note> allNotesByPageByCondition = noteMapper.getAllNotesByPageByCondition(map);
//		设置pageBean的notesList
        pageBean.setNotes(allNotesByPageByCondition);

        return new CommonResult(200,"成功查询到符合条件的该页数据", pageBean);
    }




}
