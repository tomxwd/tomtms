package top.tomxwd.tms.mapper.driver;

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

import top.tomxwd.tms.mapper.car.CarMaintainSqlProvider;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample;

public interface IllegalRecordMapper {
    @SelectProvider(type=IllegalRecordProvider.class, method="countByExample")
    long countByExample(IllegalRecordExample example);

    @DeleteProvider(type=IllegalRecordProvider.class, method="deleteByExample")
    int deleteByExample(IllegalRecordExample example);

    @Delete({
        "delete from t_illegalrecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_illegalrecord (id, car_id, ",
        "driver_id, record_date, ",
        "illegal_reson, illegal_cost, ",
        "pay_state, pay_date)",
        "values (#{id,jdbcType=INTEGER}, #{carId,jdbcType=INTEGER}, ",
        "#{driverId,jdbcType=INTEGER}, #{recordDate,jdbcType=DATE}, ",
        "#{illegalReson,jdbcType=VARCHAR}, #{illegalCost,jdbcType=DOUBLE}, ",
        "#{payState,jdbcType=INTEGER}, #{payDate,jdbcType=DATE})"
    })
    int insert(IllegalRecord record);

    @InsertProvider(type=IllegalRecordProvider.class, method="insertSelective")
    int insertSelective(IllegalRecord record);

    @SelectProvider(type=IllegalRecordProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="car_id", property="carId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="record_date", property="recordDate", jdbcType=JdbcType.DATE),
        @Result(column="illegal_reson", property="illegalReson", jdbcType=JdbcType.VARCHAR),
        @Result(column="illegal_cost", property="illegalCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="pay_state", property="payState", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_date", property="payDate", jdbcType=JdbcType.DATE)
    })
    List<IllegalRecord> selectByExample(IllegalRecordExample example);

    @Select({
        "select",
        "id, car_id, driver_id, record_date, illegal_reson, illegal_cost, pay_state, ",
        "pay_date",
        "from t_illegalrecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="car_id", property="carId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="record_date", property="recordDate", jdbcType=JdbcType.DATE),
        @Result(column="illegal_reson", property="illegalReson", jdbcType=JdbcType.VARCHAR),
        @Result(column="illegal_cost", property="illegalCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="pay_state", property="payState", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_date", property="payDate", jdbcType=JdbcType.DATE)
    })
    IllegalRecord selectByPrimaryKey(Integer id);

    @UpdateProvider(type=IllegalRecordProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IllegalRecord record, @Param("example") IllegalRecordExample example);

    @UpdateProvider(type=IllegalRecordProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IllegalRecord record, @Param("example") IllegalRecordExample example);

    @UpdateProvider(type=IllegalRecordProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IllegalRecord record);

    @Update({
        "update t_illegalrecord",
        "set car_id = #{carId,jdbcType=INTEGER},",
          "driver_id = #{driverId,jdbcType=INTEGER},",
          "record_date = #{recordDate,jdbcType=DATE},",
          "illegal_reson = #{illegalReson,jdbcType=VARCHAR},",
          "illegal_cost = #{illegalCost,jdbcType=DOUBLE},",
          "pay_state = #{payState,jdbcType=INTEGER},",
          "pay_date = #{payDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(IllegalRecord record);
    
    @SelectProvider(type=IllegalRecordProvider.class,method="selectByKeywordOrStartDateAndEndDate")
	List<Map<String, Object>> selectByKeywordOrStartDateAndEndDate(Map<String,String> map);

}