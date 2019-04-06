package top.tomxwd.tms.pojo.driver;

import java.util.Date;

public class DriverAndCar {
    @Override
	public String toString() {
		return "DriverAndCar [id=" + id + ", carId=" + carId + ", driverId=" + driverId + ", rentTime=" + rentTime
				+ ", rentState=" + rentState + ", refuseReson=" + refuseReson + "]";
	}

	private Integer id;

    private Integer carId;

    private Integer driverId;

    private Date rentTime;

    private Integer rentState;

    private String refuseReson;

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

    public Date getRentTime() {
        return rentTime;
    }

    public void setRentTime(Date rentTime) {
        this.rentTime = rentTime;
    }

    public Integer getRentState() {
        return rentState;
    }

    public void setRentState(Integer rentState) {
        this.rentState = rentState;
    }

    public String getRefuseReson() {
        return refuseReson;
    }

    public void setRefuseReson(String refuseReson) {
        this.refuseReson = refuseReson;
    }
}