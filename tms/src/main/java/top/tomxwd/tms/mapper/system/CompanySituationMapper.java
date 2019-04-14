package top.tomxwd.tms.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface CompanySituationMapper {
	
	/**
	 * 司机学历分布
	 * @return
	 */
	@Select("select case driver_education when 0 then '小学' when 1 then '初中' when 2 then '高中' when 3 then '专科' else '本科及以上' end as name,count(*) value from t_driver where acount_state=1 group by driver_education")
	List<Map<String, Object>> selectChartDriverEducation();
	
	/**
	 * 司机性别分布
	 * @return
	 */
	@Select("select case driver_gender when 0 then '男' when 1 then '女' end as name,count(*) value from t_driver where acount_state=1 group by driver_gender;")
	List<Map<String,Object>> selectChartDrvierGender();
	
	/**
	 * 司机政治面貌分布
	 * @return
	 */
	@Select("select case politics_status when 0 then '群众' when 1 then '团员' when 2 then '党员' end as name,count(*) value from t_driver where acount_state=1 group by politics_status;")
	List<Map<String,Object>> selectChartDriverPolitics();
		
	/**
	 * 近12个月内违章记录
	 * @return
	 */
	@Select("select count(*) as 'value',left(record_date,7) as 'name' from t_illegalrecord where DATE_FORMAT(record_date,'%Y-%m')>DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m') group by name;")
	List<Map<String,Object>> selectChartDriverIllegal();
	
	/**
	 * 近12个月内维修记录
	 * @return
	 */
	@Select("select count(*) as 'value',left(maintainTime,7) as 'name' from t_carmaintain where DATE_FORMAT(maintainTime,'%Y-%m')>DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m') group by name;")
	List<Map<String, Object>> selectChartDriverMaintain();
	
	/**
	 * 公司近30天 司机总收入
	 * @return
	 */
	@Select("select round(sum(cost),1) as 'value',left(date,10) as 'name' from t_taximeter where DATE_FORMAT(date,'%Y-%m-%d')>DATE_FORMAT(date_sub(curdate(), interval 30 day),'%Y-%m-%d') group by name;")
	List<Map<String, Object>> selectChartDriverTaximeter();
	
}
