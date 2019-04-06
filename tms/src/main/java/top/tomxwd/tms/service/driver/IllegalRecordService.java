package top.tomxwd.tms.service.driver;

import java.util.Map;

import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.driver.IllegalRecordPageObj;

public interface IllegalRecordService {
	
	/**
	 * 查找违规列表 可以根据一段时间查询
	 * @param pageObj
	 * @return
	 */
	IllegalRecordPageObj<IllegalRecord> illegalList(IllegalRecordPageObj<IllegalRecord> pageObj);

	Map<String, Object> illegalListMap(Map<String, Object> pageObj);
	
	/**
	 * 完成缴费
	 * @param id
	 * @return
	 */
	MsgObj updatePayStateById(Integer id);
	
	/**
	 * 删除记录 根据id
	 * @param id
	 * @return
	 */
	MsgObj deleteIllegalRecordById(Integer id);
	
	/**
	 * 编辑记录，根据记录修改
	 * @param record
	 * @return
	 */
	MsgObj updateIllegalInfoByRecord(IllegalRecord record);
	
	/**
	 * 插入新的违章记录
	 * @param record
	 * @return
	 */
	MsgObj insertNewIllegalRecord(IllegalRecord record);
	
}
