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
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverExample;

public interface DriverMapper {
    @SelectProvider(type=DriverSqlProvider.class, method="countByExample")
    long countByExample(DriverExample example);

    @DeleteProvider(type=DriverSqlProvider.class, method="deleteByExample")
    int deleteByExample(DriverExample example);

    @Delete({
        "delete from t_driver",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_driver (id, user_id, ",
        "driver_gender, driver_education, ",
        "driver_address, politics_status, ",
        "identity_number, taximeter_id, ",
        "headImg, acount_state, ",
        "driver_name)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{driverGender,jdbcType=INTEGER}, #{driverEducation,jdbcType=INTEGER}, ",
        "#{driverAddress,jdbcType=VARCHAR}, #{politicsStatus,jdbcType=INTEGER}, ",
        "#{identityNumber,jdbcType=CHAR}, #{taximeterId,jdbcType=INTEGER}, ",
        "#{headimg,jdbcType=VARCHAR}, #{acountState,jdbcType=INTEGER}, ",
        "#{driverName,jdbcType=VARCHAR})"
    })
    int insert(Driver record);

    @InsertProvider(type=DriverSqlProvider.class, method="insertSelective")
    int insertSelective(Driver record);

    @SelectProvider(type=DriverSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_gender", property="driverGender", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_education", property="driverEducation", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_address", property="driverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="politics_status", property="politicsStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="identity_number", property="identityNumber", jdbcType=JdbcType.CHAR),
        @Result(column="taximeter_id", property="taximeterId", jdbcType=JdbcType.INTEGER),
        @Result(column="headImg", property="headimg", jdbcType=JdbcType.VARCHAR),
        @Result(column="acount_state", property="acountState", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_name", property="driverName", jdbcType=JdbcType.VARCHAR)
    })
    List<Driver> selectByExample(DriverExample example);

    @Select({
        "select",
        "id, user_id, driver_gender, driver_education, driver_address, politics_status, ",
        "identity_number, taximeter_id, headImg, acount_state, driver_name",
        "from t_driver",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_gender", property="driverGender", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_education", property="driverEducation", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_address", property="driverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="politics_status", property="politicsStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="identity_number", property="identityNumber", jdbcType=JdbcType.CHAR),
        @Result(column="taximeter_id", property="taximeterId", jdbcType=JdbcType.INTEGER),
        @Result(column="headImg", property="headimg", jdbcType=JdbcType.VARCHAR),
        @Result(column="acount_state", property="acountState", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_name", property="driverName", jdbcType=JdbcType.VARCHAR)
    })
    Driver selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DriverSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Driver record, @Param("example") DriverExample example);

    @UpdateProvider(type=DriverSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Driver record, @Param("example") DriverExample example);

    @UpdateProvider(type=DriverSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Driver record);

    @Update({
        "update t_driver",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "driver_gender = #{driverGender,jdbcType=INTEGER},",
          "driver_education = #{driverEducation,jdbcType=INTEGER},",
          "driver_address = #{driverAddress,jdbcType=VARCHAR},",
          "politics_status = #{politicsStatus,jdbcType=INTEGER},",
          "identity_number = #{identityNumber,jdbcType=CHAR},",
          "taximeter_id = #{taximeterId,jdbcType=INTEGER},",
          "headImg = #{headimg,jdbcType=VARCHAR},",
          "acount_state = #{acountState,jdbcType=INTEGER},",
          "driver_name = #{driverName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
	int updateByPrimaryKey(Driver record);

    @Select("select t1.phone phone,t1.email email,t1.qq qq,t1.regtime regtime,t2.driverGender,t2.driverEducation,t2.driverAddress,t2.politicsStatus,t2.identityNumber,t2.headimg,t2.driverName from t_sysuser t1 join (select t2.user_id userId,t2.driver_gender driverGender,t2.driver_education driverEducation,t2.driver_address driverAddress,t2.politics_status politicsStatus,t2.identity_number identityNumber,t2.headImg headimg,t2.driver_name driverName from t_driver_car t1 join t_driver t2 on t1.driver_id = t2.id where t1.car_id = #{id} and t1.rent_state in (0,1)) t2 on t1.id = t2.userId;")
	Map<String, Object> getDriverInfoByCarId(Integer id);
    
    @Select("select t1.id,t1.driver_name driverName from t_driver t1 join t_driver_car t2 on t1.id = t2.driver_id where t2.rent_state =1")
	List<Driver> selectAllDriverAndHaveCar();
    
	/**
	 * 该司机近30天收入记录
	 * @param id
	 * @return
	 */
	@Select("select round(sum(cost),1) as 'value',left(date,10) as 'name' from t_taximeter where DATE_FORMAT(date,'%Y-%m-%d')>DATE_FORMAT(date_sub(curdate(), interval 30 day),'%Y-%m-%d') and driver_id=#{id} group by name;")
	List<Map<String, Object>> selectChartDriverPersonalTaximeter(Integer id);
	
	/**
	 * 该司机近30天的违章记录
	 * @param id
	 * @return
	 */
	@Select("select count(driver_id) as 'value',left(record_date,10) as 'name' from t_illegalrecord where DATE_FORMAT(record_date,'%Y-%m-%d')>DATE_FORMAT(date_sub(curdate(), interval 30 day),'%Y-%m-%d') and driver_id=#{id} group by name;")
	List<Map<String, Object>> selectChartDriverPersonalIllegal(Integer id);

	/**
	 * 该司机近30天的维修记录
	 * @param id
	 * @return
	 */
	@Select("select count(driver_id) as 'value',left(maintainTime,10) as 'name' from t_carmaintain where DATE_FORMAT(maintainTime,'%Y-%m-%d')>DATE_FORMAT(date_sub(curdate(), interval 30 day),'%Y-%m-%d') and driver_id=#{id} group by name;")
	List<Map<String, Object>> selectChartDriverPersonalMaintain(Integer id);
	
	/**
     * 根据车牌号可以查找车辆使用记录
     * @param keyword
     * @return
     */
    @SelectProvider(type=DriverSqlProvider.class,method="selectUseCarRecordListByKeyword")
	List<Map<String, Object>> selectUseCarRecordListByKeyword(Map<String, String> params);

	
}