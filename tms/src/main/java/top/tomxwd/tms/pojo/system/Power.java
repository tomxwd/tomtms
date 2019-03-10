package top.tomxwd.tms.pojo.system;

public class Power {
	private Integer id;

	private String powerName;

	private String powerAction;

	private Integer powerDisplay;

	private Integer modularId;

	private String precode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getPowerAction() {
		return powerAction;
	}

	public void setPowerAction(String powerAction) {
		this.powerAction = powerAction;
	}

	public Integer getPowerDisplay() {
		return powerDisplay;
	}

	public void setPowerDisplay(Integer powerDisplay) {
		this.powerDisplay = powerDisplay;
	}

	public Integer getModularId() {
		return modularId;
	}

	public void setModularId(Integer modularId) {
		this.modularId = modularId;
	}

	public String getPrecode() {
		return precode;
	}

	public void setPrecode(String precode) {
		this.precode = precode;
	}
}