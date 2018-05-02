package com.qx.ar.modle;

public class Resources {

	private Integer id;
	private String title;
	private String imgUrl;
	private String content;
	private Integer addtime;
	private String desc;
	private String apptoken;
	private Integer size;
	private Integer start;
	private String identificationUrl;
	private String identificationName;
	private String allResources;
	private String resourcesName;

	public String getIdentificationUrl() {
		return identificationUrl;
	}

	public void setIdentificationUrl(String identificationUrl) {
		this.identificationUrl = identificationUrl;
	}

	public String getIdentificationName() {
		return identificationName;
	}

	public void setIdentificationName(String identificationName) {
		this.identificationName = identificationName;
	}

	public String getAllResources() {
		return allResources;
	}

	public void setAllResources(String allResources) {
		this.allResources = allResources;
	}

	public String getResourcesName() {
		return resourcesName;
	}

	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}

	public Resources() {
		super();
	}

	public Resources(String title, String imgUrl, String content, String desc, String identificationUrl,
			String identificationName) {
		super();
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.desc = desc;
		this.identificationUrl = identificationUrl;
		this.identificationName = identificationName;
		this.allResources = allResources;
		this.resourcesName = resourcesName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public Integer getAddtime() {
		return addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "Resources [id=" + id + ", title=" + title + ", imgUrl=" + imgUrl + ", content=" + content + ", addtime="
				+ addtime + ", desc=" + desc + ", apptoken=" + apptoken + ", size=" + size + ", start=" + start
				+ ", identificationUrl=" + identificationUrl + ", identificationName=" + identificationName
				+ ", allResources=" + allResources + ", resourcesName=" + resourcesName + "]";
	}

}
