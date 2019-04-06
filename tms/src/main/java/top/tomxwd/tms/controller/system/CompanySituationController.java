package top.tomxwd.tms.controller.system;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.system.Taximeter;
import top.tomxwd.tms.service.system.CompanySituationService;
import top.tomxwd.tms.vo.MsgObj;

@Controller
@RequestMapping("/system")
public class CompanySituationController {
	
	@Autowired
	private CompanySituationService service;
	
	@RequestMapping(value="/toCompanySituation",method=RequestMethod.GET)
	@RequiresPermissions("company:chartPage")
	public String toCompanySituation() {
		return "system/companySituation";
	}
	
	@RequestMapping(value="/chartDriverEducation",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> chartDriverEducation(){
		return service.selectChartDriverEducation();
	}
	
	@RequestMapping(value="/chartDriverPolitics",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> chartDriverPolitics(){
		return service.selectChartDriverPolitics();
	}
	
	@RequestMapping(value="/chartDriverIllegal",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> chartDriverIllegal(){
		return service.selectChartDriverIllegal();
	}
	
	@RequestMapping(value="/chartDriverMaintain",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> chartDriverMaintain(){
		return service.selectchartDriverMaintain();
	}
	
	@RequestMapping(value="/chartDriverTaximeter",method=RequestMethod.GET)
	@RequiresPermissions("company:income")
	@ResponseBody
	public Map<String,Object> chartDriverTaximeter(){
		return service.selectchartDriverTaximeter();
	}
	
	@RequestMapping(value="/chartDriverPersonalTaximeter",method=RequestMethod.GET)
	@RequiresPermissions("driver:personalIncome")
	@ResponseBody
	public Map<String,Object> chartDriverPersonalTaximeter(){
		return service.selectChartDriverPersonalTaximeter();
	}
	
	@RequestMapping(value="/toAddTaximeter",method=RequestMethod.GET)
	@RequiresPermissions("teximeter:addPage")
	public String toAddTaximeter() {
		return "system/addTaximeter";
	}
	
	@RequestMapping(value="/addTaximeter",method=RequestMethod.POST)
	@RequiresPermissions("teximeter:add")
	@ResponseBody
	public MsgObj addTaximeter(Taximeter taximeter) {
		return service.insertNewTaximeter(taximeter);
	}
	
	
}
