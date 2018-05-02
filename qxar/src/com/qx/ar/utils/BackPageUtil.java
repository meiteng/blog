package com.qx.ar.utils;


public class BackPageUtil {
	private int addtime;// 分页时间
	private int size=3;// 分页条数
	private int currentPage;// 当前页
	private int totalPage;// 总页数
	private int totalNum;//总条数

	public BackPageUtil(int size,int currentPage,int totalNum) {
		this.size = size;       //
		this.totalNum=totalNum;
		this.calTotalPage();
		this.setCurrentPage(currentPage);
		
	}
	
	public BackPageUtil() {
		this.size = 3;
		this.addtime = (int) System.currentTimeMillis() / 1000;
	}

	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		
		if(currentPage > this.totalPage){
			this.currentPage=this.totalPage-1;
		}else if(currentPage <= 0){
			this.currentPage = 0;
		}else{
			this.currentPage=currentPage-1;
		}
		
		
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void calTotalPage(){
	     this.totalPage = (this.totalNum+this.size-1)/this.size;
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
	
	
	@Override
	public String toString() {
		return "BackPageUtil [addtime=" + addtime + ", size=" + size + ", currentPage=" + currentPage + ", totalPage="
				+ totalPage + ", totalNum=" + totalNum + ", getCurrentPage()=" + getCurrentPage() + ", getTotalPage()="
				+ getTotalPage() + ", getAddtime()=" + getAddtime() + ", getSize()=" + getSize() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
