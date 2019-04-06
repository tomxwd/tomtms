package top.tomxwd.tms.pojo.car;

import java.util.Date;

public class CarMaintain {
    private Integer id;

    private Date maintaintime;

    private Integer carId;

    private Integer driverId;

    private Double maintainCost;

    private String maintainReson;

    private String maintainDetail;

    private String feedback;

    private Integer insuranceType;

    private Integer payState;

    private Integer maintainState;

    private Date completeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMaintaintime() {
        return maintaintime;
    }

    public void setMaintaintime(Date maintaintime) {
        this.maintaintime = maintaintime;
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

    public Double getMaintainCost() {
        return maintainCost;
    }

    public void setMaintainCost(Double maintainCost) {
        this.maintainCost = maintainCost;
    }

    public String getMaintainReson() {
        return maintainReson;
    }

    public void setMaintainReson(String maintainReson) {
        this.maintainReson = maintainReson;
    }

    public String getMaintainDetail() {
        return maintainDetail;
    }

    public void setMaintainDetail(String maintainDetail) {
        this.maintainDetail = maintainDetail;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(Integer insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getMaintainState() {
        return maintainState;
    }

    public void setMaintainState(Integer maintainState) {
        this.maintainState = maintainState;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}