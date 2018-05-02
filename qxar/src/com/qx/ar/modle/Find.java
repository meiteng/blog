package com.qx.ar.modle;

public class Find {
	private Integer id;
	private String title;
	private String desc;
	private String content;
	private String tags;
	private Integer sort;
	private Integer like;
	private Integer comment;
	private Integer addtime;
	private String androidUrl;
	private String iosUrl;
	private String identificationUrl;
	private String identificationName;
	private Integer typeId;
	private Integer size;
	private String imgUrl;
	private Integer start;

	
	public Find() {
		super();
	}

	public Find(String title, String desc, String content, String tags, String androidUrl, String iosUrl,
			Integer typeId, String imgUrl) {
		super();
		this.title = title;
		this.desc = desc;
		this.content = content;
		this.tags = tags;
		this.androidUrl = androidUrl;
		this.iosUrl = iosUrl;
		this.typeId = typeId;
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public Integer getAddtime() {
		return addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}


	public String getAndroidUrl() {
		return androidUrl;
	}

	public void setAndroidUrl(String androidUrl) {
		this.androidUrl = androidUrl;
	}

	public String getIosUrl() {
		return iosUrl;
	}

	public void setIosUrl(String iosUrl) {
		this.iosUrl = iosUrl;
	}

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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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
		return "Find [id=" + id + ", title=" + title + ", desc=" + desc + ", content=" + content + ", tags=" + tags
				+ ", sort=" + sort + ", like=" + like + ", comment=" + comment + ", addtime=" + addtime
				+ ", androidUrl=" + androidUrl + ", iosUrl=" + iosUrl + ", identificationUrl=" + identificationUrl
				+ ", identificationName=" + identificationName + ", typeId=" + typeId + ", size=" + size + ", imgUrl="
				+ imgUrl + ", start=" + start + "]";
	}

	

}
