package com.qx.ar.utils;



public class PageUtil {
	private int addtime;//分页时间
	private int size;//分页条数
	
	public PageUtil(int addtime,int size){
		this.addtime=addtime;
		this.size=size;
	}
	
	public PageUtil(){
		this.size=20;
		this.addtime=(int)System.currentTimeMillis()/1000;
	}

	public int getAddtime() {
		return addtime;
	}

	public void setAddtime(int addtime) {
		this.addtime = addtime;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
