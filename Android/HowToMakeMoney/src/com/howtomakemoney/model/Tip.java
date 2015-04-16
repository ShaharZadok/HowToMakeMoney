package com.howtomakemoney.model;

public class Tip {

	private String id;
	private String content;
	private String auther;
	private long createTime;
	private boolean isFavorite;
	
	public Tip(String id, String content, String auther, long createTime, boolean isFavorite)
	{
		this.setId(id);
		this.setContent(content);
		this.setAuther(auther);
		this.setCreateTime(createTime);
		this.setFavorite(isFavorite);
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	
}
