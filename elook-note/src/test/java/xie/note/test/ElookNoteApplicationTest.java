package xie.note.test;

import cn.elook.common.entity.commentPo;
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
import java.util.HashMap;

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
    public void uuid(){

//    noteService.deleteComment(8);
    noteMapper.deleteCommentByNcid(8);
}

}
