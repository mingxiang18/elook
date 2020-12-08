package xie.note.dao;

import cn.elook.common.entity.note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoteMapper {

//获取所有帖子
    public List<note> getAllNotes();

//    根据id获取指定帖子
    public  note getNoteByNid(int nid);

//    分页查询获取帖子集合
    public  List<note> getAllNotesByPage(@Param("index") int index,@Param("count") int count);

//    模糊查询获取帖子集合
    public  List<note> getAllNotesByCondition(@Param("condition") String condition);


    //根据用户uid获取所有帖子
    public List<note> getNotesByUid(@Param("uid") int uid);


//    根据nid删除帖子
     public int deleteNoteByNid(int nid);

//      根据nid 删除图片
  public int deletePhotoByNid(int nid);
//      根据nid 删除评论
public int deleteCommentByNid(int nid);
//      更加nid删除商品
public int deleteProductByNid(int nid);

//获取系统总页数
public int countOfNotes();


    //    模糊查询获取帖子总页数
    public int countOfNotesByCondition(@Param("condition") String condition);

    //    模糊查询分页获取帖子
    public  List<note> getAllNotesByPageByCondition(Map map);

//    添加帖子
     public  void  addNote(Map map);
//添加评论
     public  void addComment(Map map);
// 删除指定的评论
public int deleteCommentByNcid(@Param("ncid")int ncid);
//添加帖子图片
public  void  addNotePhoto(Map map);
//添加帖子关联商品
public  void  addNoteProduct(Map map);


}
