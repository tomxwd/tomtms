package top.tomxwd.tms.mapper.car;

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

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarExample;

public interface CarMapper {
    @SelectProvider(type=CarSqlProvider.class, method="countByExample")
    long countByExample(CarExample example);

    @DeleteProvider(type=CarSqlProvider.class, method="deleteByExample")
    int deleteByExample(CarExample example);

    @Delete({
        "delete from t_car",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_car (id, fuel_subsidy, ",
        "contract_cost, car_number, ",
        "speed_changer, brand, ",
        "model, car_state, ",
        "buy_date, engine_number, ",
        "car_price, vin_num, ",
        "car_img, car_deleteState)",
        "values (#{id,jdbcType=INTEGER}, #{fuelSubsidy,jdbcType=DOUBLE}, ",
        "#{contractCost,jdbcType=DOUBLE}, #{carNumber,jdbcType=VARCHAR}, ",
        "#{speedChanger,jdbcType=INTEGER}, #{brand,jdbcType=VARCHAR}, ",
        "#{model,jdbcType=VARCHAR}, #{carState,jdbcType=INTEGER}, ",
        "#{buyDate,jdbcType=DATE}, #{engineNumber,jdbcType=VARCHAR}, ",
        "#{carPrice,jdbcType=DOUBLE}, #{vinNum,jdbcType=VARCHAR}, ",
        "#{carImg,jdbcType=VARCHAR}, #{carDeletestate,jdbcType=INTEGER})"
    })
    int insert(Car record);

    @InsertProvider(type=CarSqlProvider.class, method="insertSelective")
    int insertSelective(Car record);

    @SelectProvider(type=CarSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="fuel_subsidy", property="fuelSubsidy", jdbcType=JdbcType.DOUBLE),
        @Result(column="contract_cost", property="contractCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="car_number", property="carNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="speed_changer", property="speedChanger", jdbcType=JdbcType.INTEGER),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_state", property="carState", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_date", property="buyDate", jdbcType=JdbcType.DATE),
        @Result(column="engine_number", property="engineNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_price", property="carPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="vin_num", property="vinNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_img", property="carImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_deleteState", property="carDeletestate", jdbcType=JdbcType.INTEGER)
    })
    List<Car> selectByExample(CarExample example);

    @Select({
        "select",
        "id, fuel_subsidy, contract_cost, car_number, speed_changer, brand, model, car_state, ",
        "buy_date, engine_number, car_price, vin_num, car_img, car_deleteState",
        "from t_car",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="fuel_subsidy", property="fuelSubsidy", jdbcType=JdbcType.DOUBLE),
        @Result(column="contract_cost", property="contractCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="car_number", property="carNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="speed_changer", property="speedChanger", jdbcType=JdbcType.INTEGER),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_state", property="carState", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_date", property="buyDate", jdbcType=JdbcType.DATE),
        @Result(column="engine_number", property="engineNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_price", property="carPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="vin_num", property="vinNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_img", property="carImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_deleteState", property="carDeletestate", jdbcType=JdbcType.INTEGER)
    })
    Car selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Car record);

    @Update({
        "update t_car",
        "set fuel_subsidy = #{fuelSubsidy,jdbcType=DOUBLE},",
          "contract_cost = #{contractCost,jdbcType=DOUBLE},",
          "car_number = #{carNumber,jdbcType=VARCHAR},",
          "speed_changer = #{speedChanger,jdbcType=INTEGER},",
          "brand = #{brand,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "car_state = #{carState,jdbcType=INTEGER},",
          "buy_date = #{buyDate,jdbcType=DATE},",
          "engine_number = #{engineNumber,jdbcType=VARCHAR},",
          "car_price = #{carPrice,jdbcType=DOUBLE},",
          "vin_num = #{vinNum,jdbcType=VARCHAR},",
          "car_img = #{carImg,jdbcType=VARCHAR},",
          "car_deleteState = #{carDeletestate,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Car record);
}