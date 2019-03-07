package top.tomxwd.tms.vo;

public class QueryObj {
	private Integer begin = 0;
	private Integer size = 10;
	private String keyword = "";
	public QueryObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QueryObj(Integer begin, Integer size) {
		super();
		this.begin = begin;
		this.size = size;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public void init(Integer page, Integer rows) {
		this.begin=page;
		this.size=rows;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "QueryObj [begin=" + begin + ", size=" + size + ", keyword=" + keyword + "]";
	}

	
	
}
