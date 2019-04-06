package top.tomxwd.tms.service.system.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;

import top.tomxwd.tms.mapper.system.notice.NoticeContentMapper;
import top.tomxwd.tms.mapper.system.notice.NoticeMapper;
import top.tomxwd.tms.pojo.system.notice.Notice;
import top.tomxwd.tms.pojo.system.notice.NoticeContent;
import top.tomxwd.tms.pojo.system.notice.NoticeExample;
import top.tomxwd.tms.service.system.PublicPageService;

@Service
public class PublicPageServiceImpl implements PublicPageService {

	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private NoticeContentMapper noticeContentMapper;

	@Override
	public List<Notice> getPublicNotice() {
//		List<Map<String,Object>> list = new ArrayList<>();
//		Map<String,Object> map = null;
//		NoticeExample example = new NoticeExample();
//		example.createCriteria().andNoticeShowEqualTo(1);
//		List<Notice> notices = noticeMapper.selectByExample(example);
//		for (Notice notice : notices) {
//			NoticeContent content = noticeContentMapper.selectByPrimaryKey(notice.getId());
//			content.setContent(content.getContent().substring(0, 30));
//			System.out.println(content.getContent());
//			map = new HashMap<>();
//			map.put("notice", JSON.toJSONString(notice));
//			map.put("content", JSON.toJSONString(content));
//			list.add(map);
//		}
		NoticeExample example = new NoticeExample();
		example.createCriteria().andNoticeShowEqualTo(1);
		example.setOrderByClause("id desc");
		List<Notice> list = noticeMapper.selectByExample(example);
		return list;
	}

}
