package xie.note.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoteTest {
    @Select("select count(*) from product")
    int getTest();
}
