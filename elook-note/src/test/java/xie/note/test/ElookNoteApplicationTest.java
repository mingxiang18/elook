package xie.note.test;

import cn.elook.common.entity.note;
import cn.elook.common.utils.CommonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xie.note.dao.NoteMapper;
import xie.note.dao.NoteTest;
import xie.note.service.NoteService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElookNoteApplicationTest {
    @Autowired
    NoteTest noteTest;
    @Autowired
DataSource dataSource;
    @Autowired
    NoteMapper noteMapper;
    @Autowired
    NoteService noteService;
@Test
    public  void getDatasource() throws SQLException {
    System.out.println(dataSource.getClass());
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    System.out.println(noteTest.getTest());

}
    @Test
    public void  shiwu(){
        try{
            noteService.deleteNoteByNid(6);
        }catch (Exception ex){
            System.out.println(ex);
        }


    }

@Test
public void getAllNotes(){
    List<note> allNotes = noteMapper.getAllNotes();
    System.out.println(allNotes);
//    List<note> allNotes = noteService.getAllNotes();
//    System.out.println(allNotes);
//    List<note> allNotesByCondition = noteMapper.getAllNotesByCondition("%张三%");
//    System.out.println(allNotesByCondition);
//    CommonResult s = noteService.getNotesByCondition("帕梅拉  张三");
//    System.out.println(s);
//    List<note> a = noteMapper.getAllNotesByCondition("%aaaaaaaaaa%");
//    if (a!=null){
//        System.out.println(a.size());
//        System.out.println(a);
//    }
//    else{
//        System.out.println("是空的");
//    }

}
}
