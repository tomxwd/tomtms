package top.tomxwd.tms.service.system.notice;

import java.util.Map;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.system.notice.Notice;
import top.tomxwd.tms.pojo.system.notice.NoticeContent;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

public interface NoticeService {
	
	/**
	 * 添加新的公告
	 * @param title
	 * @param content
	 * @return
	 */
	MsgObj insertNewNotice(String title, String content);
	
	/**
	 * 公告列表
	 * @param pageObj
	 * @return
	 */
	PageObj<Notice> getNoticeList(PageObj<Notice> pageObj);
	
	/**
	 * 查找公告内容 根据id
	 * @param id
	 * @return
	 */
	NoticeContent getNoticeConentById(Integer id);
	
	/**
	 * 展示或撤下公告 最多只能十条
	 * @param notice
	 * @return
	 */
	MsgObj updateNoticeShow(Notice notice);
	
	/**
	 * 删除或恢复公告，根据id
	 * @param notice
	 * @return
	 */
	MsgObj updateNoticeStatus(Notice notice);
	
	/**
	 * 根据id获取公告详情
	 * @param id
	 * @return
	 */
	Map<String, Object> getNoticeAndContentById(Integer id);
	
	/**
	 * 获取公共的公告列表
	 * @param pageObj
	 * @return
	 */
	PageObj<Notice> getPublicNoticeList(PageObj<Notice> pageObj);

}
