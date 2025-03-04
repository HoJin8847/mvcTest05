package vo;

import java.util.Date;

public class BoardVo {
	private int idx;
	private String name;
	private String title;
	private String content;
	private String hostIP;
	private int readNum;
	private Date wDate;
	
	//getter, setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHostIP() {
		return hostIP;
	}
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	
	//toString
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", name=" + name + ", title=" + title + ", content=" + content + ", hostIP="
				+ hostIP + ", readNum=" + readNum + ", wDate=" + wDate + "]";
	}
}
