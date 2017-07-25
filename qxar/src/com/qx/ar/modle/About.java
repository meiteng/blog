package com.qx.ar.modle;

public class About {
	private Integer id;
	private String img_url;
	private String title;
	private String content;
	private Integer addtime;
	private String apptoken;

	public Integer getId() {
		return id;
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

	public Integer getAddtime() {
		return addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public String getApptoken() {
		return apptoken;
	}

	public void setApptoken(String apptoken) {
		this.apptoken = apptoken;
	}

	@Override
	public String toString() {
		return "About [id=" + id + ", img_url=" + img_url + ", title=" + title + ", content=" + content + ", addtime="
				+ addtime + ", apptoken=" + apptoken + "]";
	}

}
