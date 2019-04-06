package top.tomxwd.tms.service.system;

import java.util.List;
import java.util.Map;

import top.tomxwd.tms.pojo.system.Taximeter;
import top.tomxwd.tms.vo.MsgObj;

public interface CompanySituationService {
	
	/**
	 * 司机学历分布报表
	 * @return
	 */
	List<Map<String, Object>> selectChartDriverEducation();
	
	/**
	 * 司机政治面貌分布表
	 * @return
	 */
	List<Map<String, Object>> selectChartDriverPolitics();
	
	/**
	 * 近十二个月违规违章记录
	 * @return
	 */
	Map<String, Object> selectChartDriverIllegal();
	
	/**
	 * 近十二个月维修记录
	 * @return
	 */
	Map<String, Object> selectchartDriverMaintain();
	
	/**
	 * 插入一条新的司机薪资来源记录
	 * @param taximeter
	 * @return
	 */
	MsgObj insertNewTaximeter(Taximeter taximeter);
	
	/**
	 * 公司所有司机近30天的薪资记录
	 * @return
	 */
	Map<String, Object> selectchartDriverTaximeter();
	
	/**
	 * 司机本人近30天的薪资记录
	 * @return
	 */
	Map<String, Object> selectChartDriverPersonalTaximeter();
	
}
