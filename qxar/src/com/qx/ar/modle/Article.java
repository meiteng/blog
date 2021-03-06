package com.qx.ar.modle;


public class Article {
	private Integer id;
	private String img_url;
	private String title;
	private String content;
	private String addtime;
	private String apptoken;
	private Integer size;
	private Integer start;

	public Integer getId() {
		return id;
	}

	public Article(String img_url, String title, String content) {
		super();
		this.img_url = img_url;
		this.title = title;
		this.content = content;
		this.addtime = addtime;
	}

	public Article() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
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

	

	public String getAddtime() {
		
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getApptoken() {
		return apptoken;
	}

	public void setApptoken(String apptoken) {
		this.apptoken = apptoken;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	
	@Override
	public String toString() {
		return "Article [id=" + id + ", img_url=" + img_url + ", title=" + title + ", content=" + content + ", addtime="
				+ addtime + ", apptoken=" + apptoken + ", size=" + size + ", start=" + start + "]";
	}

}
