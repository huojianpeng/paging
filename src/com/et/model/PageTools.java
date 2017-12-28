package com.et.model;

import java.util.List;

/**
 * ��ҳ�Ĳ���
 * @author THINK
 *
 */

public class PageTools {
	
	/**
	 * �������
	 * @param curPage	ҳ�洫��ĵ�ǰҳ
	 * @param totalCount	���ݿ��ѯ���ܼ�¼��
	 * @param pageCount	  ÿҳ��ʾ������
	 */
	
	public PageTools(Integer curPage,Integer totalCount,Integer pageCount){
		this.curPage=curPage;
		this.totalCount=totalCount;
		this.pageCount=pageCount==null?this.pageCount:pageCount;
		this.prePage=(curPage==1?1:curPage-1);
		this.totalPage=totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1;
		this.nextPage=(curPage==totalPage)?totalPage:(curPage+1);
		this.startIndex=(curPage-1)*this.pageCount+1;
		this.endIndex=curPage*this.pageCount;
	}

	/**
	 * ��ǰҳ(��̬����ҳ�洫�ݵ�)
	 */
	private Integer curPage;
	/**
	 * ÿҳ��ʾ������
	 */
	private Integer pageCount=6;
	/**
	 * ��һҳ
	 * 
	 * prePage=(curPage==1?1:curPage-1)
	 * 
	 */
	private Integer prePage;
	/**
	 * ��һҳ
	 * 
	 * nextPage=(curPage=totalPage)?totalPage:(curPage+1)
	 * 
	 */
	private Integer nextPage;
	/**
	 * ��ҳ��
	 * 
	 * totalPage=totalCount%pageCount==0?totalCount/totalCount/pageCount+1
	 * 
	 */
	private Integer totalPage;
	/**
	 * �ܼ�¼��(�����ݿ��ѯ)
	 */
	private Integer totalCount;
	/**
	 * ��ʼ����
	 * 
	 * (curPage-1)*pageCount+1 		curPage*pageCount
	 * 
	 */
	private Integer startIndex;
	/**
	 * ��������
	 */
	private Integer endIndex;
	/**
	 * �洢���ղ�ѯ������
	 */
	private List data;
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	
	public static void main(String[] args) {
		
		int curPage=3;
		int totalCount=26;
		int pageCount=5;
		
		PageTools pt=new PageTools(curPage, totalCount, pageCount);
		
		System.out.println(pt.getNextPage());
		System.out.println(pt.getPrePage());
		System.out.println(pt.getTotalPage());
		System.out.println(pt.getStartIndex());
		System.out.println(pt.getEndIndex());
	}
	
}
