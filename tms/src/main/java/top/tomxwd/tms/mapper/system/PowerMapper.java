package top.tomxwd.tms.mapper.system;

import java.util.List;
import java.util.Map;

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

import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.pojo.system.PowerExample;

public interface PowerMapper {
    @SelectProvider(type=PowerSqlProvider.class, method="countByExample")
    long countByExample(PowerExample example);

    @DeleteProvider(type=PowerSqlProvider.class, method="deleteByExample")
    int deleteByExample(PowerExample example);

    @Delete({
        "delete from t_power",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_power (id, power_name, ",
        "power_action, power_display, ",
        "modular_id)",
        "values (#{id,jdbcType=INTEGER}, #{powerName,jdbcType=VARCHAR}, ",
        "#{powerAction,jdbcType=VARCHAR}, #{powerDisplay,jdbcType=INTEGER}, ",
        "#{modularId,jdbcType=INTEGER})"
    })
    int insert(Power record);

    @InsertProvider(type=PowerSqlProvider.class, method="insertSelective")
    int insertSelective(Power record);

    @SelectProvider(type=PowerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="power_name", property="powerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="power_action", property="powerAction", jdbcType=JdbcType.VARCHAR),
        @Result(column="power_display", property="powerDisplay", jdbcType=JdbcType.INTEGER),
        @Result(column="modular_id", property="modularId", jdbcType=JdbcType.INTEGER)
    })
    List<Power> selectByExample(PowerExample example);

    @Select({
        "select",
        "id, power_name, power_action, power_display, modular_id",
        "from t_power",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="power_name", property="powerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="power_action", property="powerAction", jdbcType=JdbcType.VARCHAR),
        @Result(column="power_display", property="powerDisplay", jdbcType=JdbcType.INTEGER),
        @Result(column="modular_id", property="modularId", jdbcType=JdbcType.INTEGER)
    })
    Power selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PowerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Power record, @Param("example") PowerExample example);

    @UpdateProvider(type=PowerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Power record, @Param("example") PowerExample example);

    @UpdateProvider(type=PowerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Power record);

    @Update({
        "update t_power",
        "set power_name = #{powerName,jdbcType=VARCHAR},",
          "power_action = #{powerAction,jdbcType=VARCHAR},",
          "power_display = #{powerDisplay,jdbcType=INTEGER},",
          "modular_id = #{modularId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Power record);
    
    /**
     * 权限列表
     * @param keyword
     * @return
     */
    @SelectProvider(type=PowerSqlProvider.class,method="selectPowerListByKeyword")
	List<Map<String,Object>> selectPowerListByKeyword(String keyword);
}