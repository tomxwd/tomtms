package top.tomxwd.tms.mapper.car;

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

import top.tomxwd.tms.mapper.system.PowerSqlProvider;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.car.CarMaintainExample;

public interface CarMaintainMapper {
    @SelectProvider(type=CarMaintainSqlProvider.class, method="countByExample")
    long countByExample(CarMaintainExample example);

    @DeleteProvider(type=CarMaintainSqlProvider.class, method="deleteByExample")
    int deleteByExample(CarMaintainExample example);

    @Delete({
        "delete from t_carmaintain",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_carmaintain (id, maintainTime, ",
        "car_id, driver_id, ",
        "maintain_cost, maintain_reson, ",
        "maintain_detail, feedback, ",
        "insurance_type, pay_state, ",
        "maintain_state, complete_date)",
        "values (#{id,jdbcType=INTEGER}, #{maintaintime,jdbcType=DATE}, ",
        "#{carId,jdbcType=INTEGER}, #{driverId,jdbcType=INTEGER}, ",
        "#{maintainCost,jdbcType=DOUBLE}, #{maintainReson,jdbcType=VARCHAR}, ",
        "#{maintainDetail,jdbcType=VARCHAR}, #{feedback,jdbcType=VARCHAR}, ",
        "#{insuranceType,jdbcType=INTEGER}, #{payState,jdbcType=INTEGER}, ",
        "#{maintainState,jdbcType=INTEGER}, #{completeDate,jdbcType=DATE})"
    })
    int insert(CarMaintain record);

    @InsertProvider(type=CarMaintainSqlProvider.class, method="insertSelective")
    int insertSelective(CarMaintain record);

    @SelectProvider(type=CarMaintainSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="maintainTime", property="maintaintime", jdbcType=JdbcType.DATE),
        @Result(column="car_id", property="carId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="maintain_cost", property="maintainCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="maintain_reson", property="maintainReson", jdbcType=JdbcType.VARCHAR),
        @Result(column="maintain_detail", property="maintainDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="feedback", property="feedback", jdbcType=JdbcType.VARCHAR),
        @Result(column="insurance_type", property="insuranceType", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_state", property="payState", jdbcType=JdbcType.INTEGER),
        @Result(column="maintain_state", property="maintainState", jdbcType=JdbcType.INTEGER),
        @Result(column="complete_date", property="completeDate", jdbcType=JdbcType.DATE)
    })
    List<CarMaintain> selectByExample(CarMaintainExample example);

    @Select({
        "select",
        "id, maintainTime, car_id, driver_id, maintain_cost, maintain_reson, maintain_detail, ",
        "feedback, insurance_type, pay_state, maintain_state, complete_date",
        "from t_carmaintain",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="maintainTime", property="maintaintime", jdbcType=JdbcType.DATE),
        @Result(column="car_id", property="carId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="maintain_cost", property="maintainCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="maintain_reson", property="maintainReson", jdbcType=JdbcType.VARCHAR),
        @Result(column="maintain_detail", property="maintainDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="feedback", property="feedback", jdbcType=JdbcType.VARCHAR),
        @Result(column="insurance_type", property="insuranceType", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_state", property="payState", jdbcType=JdbcType.INTEGER),
        @Result(column="maintain_state", property="maintainState", jdbcType=JdbcType.INTEGER),
        @Result(column="complete_date", property="completeDate", jdbcType=JdbcType.DATE)
    })
    CarMaintain selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CarMaintainSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CarMaintain record, @Param("example") CarMaintainExample example);

    @UpdateProvider(type=CarMaintainSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CarMaintain record, @Param("example") CarMaintainExample example);

    @UpdateProvider(type=CarMaintainSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CarMaintain record);

    @Update({
        "update t_carmaintain",
        "set maintainTime = #{maintaintime,jdbcType=DATE},",
          "car_id = #{carId,jdbcType=INTEGER},",
          "driver_id = #{driverId,jdbcType=INTEGER},",
          "maintain_cost = #{maintainCost,jdbcType=DOUBLE},",
          "maintain_reson = #{maintainReson,jdbcType=VARCHAR},",
          "maintain_detail = #{maintainDetail,jdbcType=VARCHAR},",
          "feedback = #{feedback,jdbcType=VARCHAR},",
          "insurance_type = #{insuranceType,jdbcType=INTEGER},",
          "pay_state = #{payState,jdbcType=INTEGER},",
          "maintain_state = #{maintainState,jdbcType=INTEGER},",
          "complete_date = #{completeDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CarMaintain record);
    
    /**
     * 根据司机姓名可以查找维修记录
     * @param keyword
     * @return
     */
    @SelectProvider(type=CarMaintainSqlProvider.class,method="selectCarMaintainListByKeyword")
	List<Map<String, Object>> selectCarMaintainListByKeyword(String keyword);
}