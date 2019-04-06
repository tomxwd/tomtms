package top.tomxwd.tms.mapper.driver;

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

import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;

public interface DriverAndCarMapper {
    @SelectProvider(type=DriverAndCarSqlProvider.class, method="countByExample")
    long countByExample(DriverAndCarExample example);

    @DeleteProvider(type=DriverAndCarSqlProvider.class, method="deleteByExample")
    int deleteByExample(DriverAndCarExample example);

    @Delete({
        "delete from t_driver_car",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_driver_car (id, car_id, ",
        "driver_id, rent_time, ",
        "rent_state, refuse_reson)",
        "values (#{id,jdbcType=INTEGER}, #{carId,jdbcType=INTEGER}, ",
        "#{driverId,jdbcType=INTEGER}, #{rentTime,jdbcType=TIMESTAMP}, ",
        "#{rentState,jdbcType=INTEGER}, #{refuseReson,jdbcType=VARCHAR})"
    })
    int insert(DriverAndCar record);

    @InsertProvider(type=DriverAndCarSqlProvider.class, method="insertSelective")
    int insertSelective(DriverAndCar record);

    @SelectProvider(type=DriverAndCarSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="car_id", property="carId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="rent_time", property="rentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rent_state", property="rentState", jdbcType=JdbcType.INTEGER),
        @Result(column="refuse_reson", property="refuseReson", jdbcType=JdbcType.VARCHAR)
    })
    List<DriverAndCar> selectByExample(DriverAndCarExample example);

    @Select({
        "select",
        "id, car_id, driver_id, rent_time, rent_state, refuse_reson",
        "from t_driver_car",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="car_id", property="carId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="rent_time", property="rentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rent_state", property="rentState", jdbcType=JdbcType.INTEGER),
        @Result(column="refuse_reson", property="refuseReson", jdbcType=JdbcType.VARCHAR)
    })
    DriverAndCar selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DriverAndCarSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DriverAndCar record, @Param("example") DriverAndCarExample example);

    @UpdateProvider(type=DriverAndCarSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DriverAndCar record, @Param("example") DriverAndCarExample example);

    @UpdateProvider(type=DriverAndCarSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DriverAndCar record);

    @Update({
        "update t_driver_car",
        "set car_id = #{carId,jdbcType=INTEGER},",
          "driver_id = #{driverId,jdbcType=INTEGER},",
          "rent_time = #{rentTime,jdbcType=TIMESTAMP},",
          "rent_state = #{rentState,jdbcType=INTEGER},",
          "refuse_reson = #{refuseReson,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DriverAndCar record);
}