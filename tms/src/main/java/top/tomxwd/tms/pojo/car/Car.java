package top.tomxwd.tms.pojo.car;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Car {
    private Integer id;

    private Double fuelSubsidy;

    private Double contractCost;

    private String carNumber;

    private Integer speedChanger;

    private String brand;

    private String model;

    private Integer carState;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date buyDate;

    private String engineNumber;

    private Double carPrice;

    private String vinNum;

    private String carImg;

    private Integer carDeletestate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFuelSubsidy() {
        return fuelSubsidy;
    }

    public void setFuelSubsidy(Double fuelSubsidy) {
        this.fuelSubsidy = fuelSubsidy;
    }

    public Double getContractCost() {
        return contractCost;
    }

    public void setContractCost(Double contractCost) {
        this.contractCost = contractCost;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getSpeedChanger() {
        return speedChanger;
    }

    public void setSpeedChanger(Integer speedChanger) {
        this.speedChanger = speedChanger;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCarState() {
        return carState;
    }

    public void setCarState(Integer carState) {
        this.carState = carState;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public String getVinNum() {
        return vinNum;
    }

    public void setVinNum(String vinNum) {
        this.vinNum = vinNum;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public Integer getCarDeletestate() {
        return carDeletestate;
    }

    public void setCarDeletestate(Integer carDeletestate) {
        this.carDeletestate = carDeletestate;
    }
}