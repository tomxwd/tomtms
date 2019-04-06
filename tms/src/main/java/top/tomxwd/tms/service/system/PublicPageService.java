package top.tomxwd.tms.service.system;

import java.util.List;
import java.util.Map;

import top.tomxwd.tms.pojo.system.notice.Notice;

public interface PublicPageService {

	/**
	 * 得到公告栏
	 * @return
	 */
	List<Notice> getPublicNotice();
	
}
