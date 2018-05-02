package com.qx.ar.modle;

public class ResourcesInner {
	private Integer id;
	private Integer resourcesid;
	private String identificationUrl;
	private String identificationName;
	private String androidUrl;
	private String iosUrl;
	private Integer size;
	private Integer start;
	
	public ResourcesInner(Integer resourcesid, String identificationUrl, String identificationName, String androidUrl,
			String iosUrl) {
		super();
		this.resourcesid = resourcesid;
		this.identificationUrl = identificationUrl;
		this.identificationName = identificationName;
		this.androidUrl = androidUrl;
		this.iosUrl = iosUrl;
	}

	@Override
	public String toString() {
		return "ResourcesInner [id=" + id + ", resourcesid=" + resourcesid + ", identificationUrl=" + identificationUrl
				+ ", identificationName=" + identificationName + ", androidUrl=" + androidUrl + ", iosUrl=" + iosUrl
				+ ", size=" + size + ", start=" + start + "]";
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

	public ResourcesInner() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getResourcesid() {
		return resourcesid;
	}
	public void setResourcesid(Integer resourcesid) {
		this.resourcesid = resourcesid;
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

	
}
