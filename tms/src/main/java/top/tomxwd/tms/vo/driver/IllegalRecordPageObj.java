package top.tomxwd.tms.vo.driver;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import top.tomxwd.tms.vo.PageObj;

public class IllegalRecordPageObj<T> extends PageObj<T> {
		
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
	
}
