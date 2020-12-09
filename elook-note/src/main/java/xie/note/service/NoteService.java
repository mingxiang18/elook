package xie.note.service;

import cn.elook.common.entity.*;
import cn.elook.common.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xie.note.dao.NoteMapper;

import java.util.*;

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
    public CommonResult getPageBeanByCondition(int currentCount,int currentPage,String condition) {

        PageBean pageBean = new PageBean();
        //		设置当前页面 页面显示数
        pageBean.setCurrentCount(currentCount);
//		pageBean.setCurrentPage(1);
        pageBean.setCurrentPage(currentPage);


        //        先判断有没有空格服 有就断成两个 查询两次
        String[] split = condition.split(" +");

        int count = 0;
        for (String s : split) {
            //		获得总条数
            int tempcount = noteMapper.countOfNotesByCondition("%"+s+"%");
            count = count + tempcount;

        }

        pageBean.setTotalCount(count);
//		设置总页数
        int totalPage = (int) Math.ceil(1.0 * count / pageBean.getCurrentCount());
        pageBean.setTotalPage(totalPage);

//		分页查询获得notesList
        int index = (pageBean.getCurrentPage() - 1) * (pageBean.getCurrentCount());
        HashMap<String, Object> map = new HashMap<>();
        map.put("index", index);
        map.put("count", pageBean.getCurrentCount());
        List<note> allNotes = new ArrayList<note>();
        for (String s : split) {
            map.put("condition", s);
            List<note> allNotesByPageByCondition = noteMapper.getAllNotesByPageByCondition(map);
            allNotes.addAll(allNotesByPageByCondition);
        }

//		设置pageBean的notesList

            pageBean.setNotes(allNotes);



         if (allNotes.size()==0){
             return new CommonResult(444,"没有匹配的数据");
         }
         else{


             return new CommonResult(200,"成功查询到符合条件的该页数据", pageBean);
         }

    }

//添加帖子的方法
@Transactional
public void addNotes(notePo notePo){
//        先生成帖子id
    Random random = new Random();
    String str="";
    for(int i=0;i<8;i++){
        //首字母不能为0
        str += (random.nextInt(9)+1);
    }
    int nid=Integer.parseInt(str);

//    再生成日期
    Date date = new Date();
// 先写入帖子
    HashMap map1 = new HashMap();
    map1.put("nid",nid);
    map1.put("note_title",notePo.getNote_title());
    map1.put("note_content",notePo.getNote_content());
    map1.put("creatTime",date);
    map1.put("uid",notePo.getUid());
    noteMapper.addNote(map1);

//再写入图片
    HashMap map2 = new HashMap();
    List<String> photoUrl = notePo.getPhotoUrl();
    for (String s : photoUrl) {
        map2.put("nid",nid);
        map2.put("photoSrc",s);
        noteMapper.addNotePhoto(map2);
    }

//  写入关联商品
//    需要判断一下关联商品是不是空的 如果是就不用调用mapper了
    List<String> productList = notePo.getProductList();


    HashMap map3 = new HashMap();
    for (String pid :  productList) {
        System.out.println("商品橱窗的id"+pid);
        map3.put("nid",nid);
        map3.put("pid",pid);
        noteMapper.addNoteProduct(map3);
    }


}

@Transactional
//添加评论的方法
public void addComment(commentPo commentPo){
    Date date = new Date();
    HashMap map1 = new HashMap();
    map1.put("nid",commentPo.getNid());
    map1.put("uid",commentPo.getUid());
    map1.put("ncContent",commentPo.getNcContent());
    map1.put("creatTime",date);
    noteMapper.addComment(map1);

}
//删除评论的方法
    public  void deleteComment(int ncid){
             noteMapper.deleteCommentByNcid(ncid);
    }



//    通过uid获得所有的商品
public  CommonResult getProductsByUid(int uid){
    List<Product> productsByUid = noteMapper.getProductsByUid(uid);
    if (productsByUid.size()!=0){
        return new CommonResult(200,"成功查询到商品集合",productsByUid);
    }else{
        return new CommonResult(444,"您还没有上架商品");
    }


}



    //    通过uid获得所有的商品
    public  CommonResult getProductBeanByPage(int currentPage,int currentCount,int uid){
        ProductPageBean productPageBean = new ProductPageBean();
        //		设置当前页面 页面显示数
        productPageBean.setCurrentCount(currentCount);
//		pageBean.setCurrentPage(1);
        productPageBean.setCurrentPage(currentPage);

//		获得总条数
        int count = noteMapper.getProductCountByUid(uid);
        productPageBean.setTotalCount(count);
//		设置总页数
        int totalPage = (int) Math.ceil(1.0*count/productPageBean.getCurrentCount());
        productPageBean.setTotalPage(totalPage);

//		分页查询获得notesList
        int index = (productPageBean.getCurrentPage()-1)*(productPageBean.getCurrentCount());
        List<Product> productBeanByPage = noteMapper.getProductBeanByPage(index, productPageBean.getCurrentCount(), uid);
//		设置pageBean的notesList
        productPageBean.setProducts(productBeanByPage);
if (productBeanByPage.size()!=0){
        return new CommonResult(200,"成功查询到该页的数据", productPageBean);
}else{
    return new CommonResult(444,"您没有上架的商品");
}


    }


}
