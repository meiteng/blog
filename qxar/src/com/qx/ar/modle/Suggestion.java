package com.qx.ar.modle;

public class Suggestion {
	private Integer id;
	private String content;
	private Integer addtime;
	private String contact;
	private Integer userid;
	private String apptoken;
	private Integer size;
	private String nickname;
	private String phone;
	
	
	public Suggestion(String content, String contact
			) {
		super();
		this.content = content;
		this.contact = contact;
		
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Suggestion(){
		super();
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

	private Integer start;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getApptoken() {
		return apptoken;
	}

	public void setApptoken(String apptoken) {
		this.apptoken = apptoken;
	}
	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", content=" + content + ", addtime=" + addtime + ", contact=" + contact
				+ ", userid=" + userid + ", apptoken=" + apptoken + ", size=" + size + ", nickname=" + nickname
				+ ", phone=" + phone + ", start=" + start + "]";
	}
	




}
