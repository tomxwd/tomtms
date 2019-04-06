package top.tomxwd.tms.service.system.notice.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.system.notice.NoticeContentMapper;
import top.tomxwd.tms.mapper.system.notice.NoticeMapper;
import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarExample;
import top.tomxwd.tms.pojo.system.notice.Notice;
import top.tomxwd.tms.pojo.system.notice.NoticeContent;
import top.tomxwd.tms.pojo.system.notice.NoticeExample;
import top.tomxwd.tms.pojo.system.notice.NoticeExample.Criteria;
import top.tomxwd.tms.service.system.notice.NoticeService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;
	@Autowired
	private NoticeContentMapper contentMapper;

	@Override
	public MsgObj insertNewNotice(String title, String content) {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setCreateDate(new Date());
		int i = mapper.insertSelective(notice);
		NoticeContent noticeContent = new NoticeContent();
		noticeContent.setId(notice.getId());
		noticeContent.setContent(content);
		int j = contentMapper.insertSelective(noticeContent);
		MsgObj msgObj = new MsgObj();
		if (i != 0 && j != 0) {
			msgObj.setOk(1);
			msgObj.setMsg("提交公告成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，提交公告失败！");
		}
		return msgObj;
	}

	@Override
	public PageObj<Notice> getNoticeList(PageObj<Notice> pageObj) {
		PageHelper.startPage(pageObj.getPage(), pageObj.getRows());
		NoticeExample example = new NoticeExample();
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			example.createCriteria().andTitleLike("%" + pageObj.getKeyword() + "%");
		}
		example.setOrderByClause("id desc");
		List<Notice> list = mapper.selectByExample(example);
		pageObj.setRoot(list);
		PageInfo<Notice> pageInfo = new PageInfo<>(list);
		pageObj.setRecords((int) pageInfo.getTotal());
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

	@Override
	public NoticeContent getNoticeConentById(Integer id) {
		NoticeContent noticeContent = contentMapper.selectByPrimaryKey(id);
		return noticeContent;
	}

	@Override
	public MsgObj updateNoticeShow(Notice notice) {
		if (notice.getNoticeShow() == 1) {
			NoticeExample example = new NoticeExample();
			example.createCriteria().andNoticeShowEqualTo(1);
			long count = mapper.countByExample(example);
			if (count >= 10) {
				return new MsgObj(0, "最多只能展示十条公告，请先撤下其他公告！");
			}
		}
		int i = mapper.updateByPrimaryKeySelective(notice);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if (i == 1) {
			if (notice.getNoticeShow() == 1) {
				msgObj.setMsg("公告展示成功！");
			} else {
				msgObj.setMsg("公告撤下成功！");
			}
		} else {
			msgObj.setMsg("系统故障！请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateNoticeStatus(Notice notice) {
		MsgObj msgObj = new MsgObj();
		int i = mapper.updateByPrimaryKeySelective(notice);
		msgObj.setOk(i);
		if (i == 1) {
			if(notice.getNoticeStatus()==1) {
				msgObj.setMsg("恢复成功！");
			}else {
				msgObj.setMsg("删除成功！");
			}
		} else {
			msgObj.setMsg("系统故障！请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public Map<String, Object> getNoticeAndContentById(Integer id) {
		Notice notice = mapper.selectByPrimaryKey(id);
		NoticeContent content = contentMapper.selectByPrimaryKey(id);
		Map<String,Object> map = new HashMap<>();
		map.put("notice", notice);
		map.put("content", content);
		return map;
	}

	@Override
	public PageObj<Notice> getPublicNoticeList(PageObj<Notice> pageObj) {
		PageHelper.startPage(pageObj.getPage(), pageObj.getRows());
		NoticeExample example = new NoticeExample();
		Criteria criteria = example.createCriteria();
		//未删除
		criteria.andNoticeStatusEqualTo(1);
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			criteria.andTitleLike("%" + pageObj.getKeyword() + "%");
		}
		example.setOrderByClause("id desc");
		List<Notice> list = mapper.selectByExample(example);
		pageObj.setRoot(list);
		PageInfo<Notice> pageInfo = new PageInfo<>(list);
		pageObj.setRecords((int) pageInfo.getTotal());
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

}
