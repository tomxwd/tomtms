package top.tomxwd.tms.mapper.system;

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

import top.tomxwd.tms.pojo.system.Taximeter;
import top.tomxwd.tms.pojo.system.TaximeterExample;

public interface TaximeterMapper {
    @SelectProvider(type=TaximeterProvider.class, method="countByExample")
    long countByExample(TaximeterExample example);

    @DeleteProvider(type=TaximeterProvider.class, method="deleteByExample")
    int deleteByExample(TaximeterExample example);

    @Delete({
        "delete from t_taximeter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_taximeter (id, date, ",
        "cost, driver_id)",
        "values (#{id,jdbcType=INTEGER}, #{date,jdbcType=TIMESTAMP}, ",
        "#{cost,jdbcType=DOUBLE}, #{driverId,jdbcType=INTEGER})"
    })
    int insert(Taximeter record);

    @InsertProvider(type=TaximeterProvider.class, method="insertSelective")
    int insertSelective(Taximeter record);

    @SelectProvider(type=TaximeterProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DOUBLE),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER)
    })
    List<Taximeter> selectByExample(TaximeterExample example);

    @Select({
        "select",
        "id, date, cost, driver_id",
        "from t_taximeter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DOUBLE),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER)
    })
    Taximeter selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TaximeterProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Taximeter record, @Param("example") TaximeterExample example);

    @UpdateProvider(type=TaximeterProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Taximeter record, @Param("example") TaximeterExample example);

    @UpdateProvider(type=TaximeterProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Taximeter record);

    @Update({
        "update t_taximeter",
        "set date = #{date,jdbcType=TIMESTAMP},",
          "cost = #{cost,jdbcType=DOUBLE},",
          "driver_id = #{driverId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Taximeter record);
}