package top.tomxwd.tms.service.system;

import java.util.List;
import java.util.Map;

import top.tomxwd.tms.pojo.system.Modular;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.QueryObj;

public interface ModularService {
	
	/**
	 * 检测模块名是否存在
	 * @param modularName
	 * @return
	 */
	Boolean findModularExistByName(String modularName);

	/**
	 * 获得模块列表
	 * @param pageObj
	 * @return
	 */
	PageObj<Modular> modularList(PageObj<Modular> pageObj);
	
	/**
	 * 添加新模块
	 * @param modular
	 * @return
	 */
	MsgObj insertModular(Modular modular);
	
	/**
	 * 编辑模块
	 * @param modular
	 * @return
	 */
	MsgObj updateModular(Modular modular);
	
	/**
	 * 删除模块 ，根据id
	 * @param id
	 * @return
	 */
	MsgObj deleteModularById(Integer id);
	
	/**
	 * 获得所有模块信息
	 * @return
	 */
	Map<String, Object> getAllModular();
	
	

}
