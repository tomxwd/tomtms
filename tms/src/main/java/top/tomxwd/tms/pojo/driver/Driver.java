package top.tomxwd.tms.pojo.driver;

public class Driver {
    @Override
	public String toString() {
		return "Driver [id=" + id + ", userId=" + userId + ", driverGender=" + driverGender + ", driverEducation="
				+ driverEducation + ", driverAddress=" + driverAddress + ", politicsStatus=" + politicsStatus
				+ ", identityNumber=" + identityNumber + ", taximeterId=" + taximeterId + ", headimg=" + headimg
				+ ", acountState=" + acountState + ", driverName=" + driverName + "]";
	}

	private Integer id;

    private Integer userId;

    private Integer driverGender;

    private Integer driverEducation;

    private String driverAddress;

    private Integer politicsStatus;

    private String identityNumber;

    private Integer taximeterId;

    private String headimg;

    private Integer acountState;

    private String driverName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(Integer driverGender) {
        this.driverGender = driverGender;
    }

    public Integer getDriverEducation() {
        return driverEducation;
    }

    public void setDriverEducation(Integer driverEducation) {
        this.driverEducation = driverEducation;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public Integer getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(Integer politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Integer getTaximeterId() {
        return taximeterId;
    }

    public void setTaximeterId(Integer taximeterId) {
        this.taximeterId = taximeterId;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public Integer getAcountState() {
        return acountState;
    }

    public void setAcountState(Integer acountState) {
        this.acountState = acountState;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}