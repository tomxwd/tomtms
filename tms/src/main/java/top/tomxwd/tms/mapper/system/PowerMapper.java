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
        "modular_id, precode)",
        "values (#{id,jdbcType=INTEGER}, #{powerName,jdbcType=VARCHAR}, ",
        "#{powerAction,jdbcType=VARCHAR}, #{powerDisplay,jdbcType=INTEGER}, ",
        "#{modularId,jdbcType=INTEGER}, #{precode,jdbcType=VARCHAR})"
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
        @Result(column="modular_id", property="modularId", jdbcType=JdbcType.INTEGER),
        @Result(column="precode", property="precode", jdbcType=JdbcType.VARCHAR)
    })
    List<Power> selectByExample(PowerExample example);

    @Select({
        "select",
        "id, power_name, power_action, power_display, modular_id, precode",
        "from t_power",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="power_name", property="powerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="power_action", property="powerAction", jdbcType=JdbcType.VARCHAR),
        @Result(column="power_display", property="powerDisplay", jdbcType=JdbcType.INTEGER),
        @Result(column="modular_id", property="modularId", jdbcType=JdbcType.INTEGER),
        @Result(column="precode", property="precode", jdbcType=JdbcType.VARCHAR)
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
          "modular_id = #{modularId,jdbcType=INTEGER},",
          "precode = #{precode,jdbcType=VARCHAR}",
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
    
    /**
     * 得到角色所拥有的权限列表
     * @param map
     * @return
     */
    @SelectProvider(type=PowerSqlProvider.class,method="selectRoleHavingPowerListById")
	List<Map<String, Object>> selectRoleHavingPowerListById(Map<String, Object> map);
    
    /**
     * 根据角色id查找其拥有的权限
     * @param roleId
     * @return
     */
    @Select("select t2.power_id from t_role t1 join t_role_power t2 on t1.id=t2.role_id where t1.id = #{roleId}")
	List<Integer> selectPowersByRoleId(Integer roleId);
    
    /**
     * 根据用户id查找所有权限
     * @param userId
     * @return
     */
//    @Select("select t1.id id,t1.power_name powerName,t1.power_action powerAction,t1.power_display powerDisplay,t1.modular_id modularId,t1.precode precode from t_power t1 join (select t2.power_id from t_sysuser t1 join t_role_power t2 on t1.role_id=t2.role_id where t1.id=#{userId})t2 on t1.id=t2.power_id")
    @SelectProvider(type=PowerSqlProvider.class,method="selectUserPowersByUserId")
	List<Power> selectUserPowersByUserId(Integer userId);
}