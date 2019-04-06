package top.tomxwd.tms.pojo.driver;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class IllegalRecord {
    private Integer id;

    private Integer carId;

    private Integer driverId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date recordDate;

    private String illegalReson;

    private Double illegalCost;

    private Integer payState;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date payDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getIllegalReson() {
        return illegalReson;
    }

    public void setIllegalReson(String illegalReson) {
        this.illegalReson = illegalReson;
    }

    public Double getIllegalCost() {
        return illegalCost;
    }

    public void setIllegalCost(Double illegalCost) {
        this.illegalCost = illegalCost;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}