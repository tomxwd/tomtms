package top.tomxwd.tms.pojo.system.notice;

import java.util.Date;

public class Notice {
    @Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", createDate=" + createDate + ", noticeStatus=" + noticeStatus
				+ ", noticeShow=" + noticeShow + "]";
	}

	private Integer id;

    private String title;

    private Date createDate;

    private Integer noticeStatus;

    private Integer noticeShow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public Integer getNoticeShow() {
        return noticeShow;
    }

    public void setNoticeShow(Integer noticeShow) {
        this.noticeShow = noticeShow;
    }
}