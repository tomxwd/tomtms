package top.tomxwd.tms.mapper.system.notice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import top.tomxwd.tms.pojo.system.notice.NoticeContent;
import top.tomxwd.tms.pojo.system.notice.NoticeContentExample;

public interface NoticeContentMapper {
    @SelectProvider(type=NoticeContentProvider.class, method="countByExample")
    long countByExample(NoticeContentExample example);

    @DeleteProvider(type=NoticeContentProvider.class, method="deleteByExample")
    int deleteByExample(NoticeContentExample example);

    @Delete({
        "delete from t_notice_content",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_notice_content (id, content)",
        "values (#{id,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(NoticeContent record);

    @InsertProvider(type=NoticeContentProvider.class, method="insertSelective")
    int insertSelective(NoticeContent record);

    @SelectProvider(type=NoticeContentProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<NoticeContent> selectByExampleWithBLOBs(NoticeContentExample example);

    @SelectProvider(type=NoticeContentProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<NoticeContent> selectByExample(NoticeContentExample example);

    @Select({
        "select",
        "id, content",
        "from t_notice_content",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    NoticeContent selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NoticeContentProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NoticeContent record, @Param("example") NoticeContentExample example);

    @UpdateProvider(type=NoticeContentProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") NoticeContent record, @Param("example") NoticeContentExample example);

    @UpdateProvider(type=NoticeContentProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NoticeContent record, @Param("example") NoticeContentExample example);

    @UpdateProvider(type=NoticeContentProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NoticeContent record);

    @Update({
        "update t_notice_content",
        "set content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(NoticeContent record);
}