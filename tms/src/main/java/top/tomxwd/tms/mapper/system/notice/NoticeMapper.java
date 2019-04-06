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

import top.tomxwd.tms.pojo.system.notice.Notice;
import top.tomxwd.tms.pojo.system.notice.NoticeExample;

public interface NoticeMapper {
    @SelectProvider(type=NoticeProvider.class, method="countByExample")
    long countByExample(NoticeExample example);

    @DeleteProvider(type=NoticeProvider.class, method="deleteByExample")
    int deleteByExample(NoticeExample example);

    @Delete({
        "delete from t_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_notice (id, title, ",
        "create_date, notice_status, ",
        "notice_show)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{noticeStatus,jdbcType=INTEGER}, ",
        "#{noticeShow,jdbcType=INTEGER})"
    })
    int insert(Notice record);

    @InsertProvider(type=NoticeProvider.class, method="insertSelective")
    int insertSelective(Notice record);

    @SelectProvider(type=NoticeProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notice_status", property="noticeStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="notice_show", property="noticeShow", jdbcType=JdbcType.INTEGER)
    })
    List<Notice> selectByExample(NoticeExample example);

    @Select({
        "select",
        "id, title, create_date, notice_status, notice_show",
        "from t_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notice_status", property="noticeStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="notice_show", property="noticeShow", jdbcType=JdbcType.INTEGER)
    })
    Notice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NoticeProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update t_notice",
        "set title = #{title,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "notice_status = #{noticeStatus,jdbcType=INTEGER},",
          "notice_show = #{noticeShow,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);
}