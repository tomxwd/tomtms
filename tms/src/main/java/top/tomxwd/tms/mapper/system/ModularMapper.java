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

import top.tomxwd.tms.pojo.system.Modular;
import top.tomxwd.tms.pojo.system.ModularExample;
import top.tomxwd.tms.vo.QueryObj;

public interface ModularMapper {
    @SelectProvider(type=ModularSqlProvider.class, method="countByExample")
    long countByExample(ModularExample example);

    @DeleteProvider(type=ModularSqlProvider.class, method="deleteByExample")
    int deleteByExample(ModularExample example);

    @Delete({
        "delete from t_modular",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_modular (id, modular_name)",
        "values (#{id,jdbcType=INTEGER}, #{modularName,jdbcType=VARCHAR})"
    })
    int insert(Modular record);

    @InsertProvider(type=ModularSqlProvider.class, method="insertSelective")
    int insertSelective(Modular record);

    @SelectProvider(type=ModularSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="modular_name", property="modularName", jdbcType=JdbcType.VARCHAR)
    })
    List<Modular> selectByExample(ModularExample example);

    @Select({
        "select",
        "id, modular_name",
        "from t_modular",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="modular_name", property="modularName", jdbcType=JdbcType.VARCHAR)
    })
    Modular selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ModularSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Modular record, @Param("example") ModularExample example);

    @UpdateProvider(type=ModularSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Modular record, @Param("example") ModularExample example);

    @UpdateProvider(type=ModularSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Modular record);

    @Update({
        "update t_modular",
        "set modular_name = #{modularName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Modular record);
    
    /**
     * 查询模块列表
     * @param query
     * @return
     */
    @SelectProvider(type=ModularSqlProvider.class,method="modularList")
	List<Modular> modularList(QueryObj queryObj);
    
}