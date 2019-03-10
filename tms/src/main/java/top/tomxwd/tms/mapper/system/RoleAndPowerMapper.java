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

import top.tomxwd.tms.pojo.system.Role;
import top.tomxwd.tms.pojo.system.RoleAndPower;
import top.tomxwd.tms.pojo.system.RoleAndPowerExample;

public interface RoleAndPowerMapper {
    @SelectProvider(type=RoleAndPowerSqlProvider.class, method="countByExample")
    long countByExample(RoleAndPowerExample example);

    @DeleteProvider(type=RoleAndPowerSqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleAndPowerExample example);

    @Delete({
        "delete from t_role_power",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_role_power (id, role_id, ",
        "power_id)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{powerId,jdbcType=INTEGER})"
    })
    int insert(RoleAndPower record);

    @InsertProvider(type=RoleAndPowerSqlProvider.class, method="insertSelective")
    int insertSelective(RoleAndPower record);

    @SelectProvider(type=RoleAndPowerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="power_id", property="powerId", jdbcType=JdbcType.INTEGER)
    })
    List<RoleAndPower> selectByExample(RoleAndPowerExample example);

    @Select({
        "select",
        "id, role_id, power_id",
        "from t_role_power",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="power_id", property="powerId", jdbcType=JdbcType.INTEGER)
    })
    RoleAndPower selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RoleAndPowerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoleAndPower record, @Param("example") RoleAndPowerExample example);

    @UpdateProvider(type=RoleAndPowerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RoleAndPower record, @Param("example") RoleAndPowerExample example);

    @UpdateProvider(type=RoleAndPowerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleAndPower record);

    @Update({
        "update t_role_power",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "power_id = #{powerId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RoleAndPower record);
    /**
     * 批量插入记录
     * @param role
     * @return
     */
    @Insert("<script>insert into t_role_power (role_id,power_id) values <foreach item='item' index='index' collection='powers' separator=','> (#{id},#{item}) </foreach></script>")
	int insertAllRecords(Role role);
}