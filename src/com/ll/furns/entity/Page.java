package com.ll.furns.entity;

import java.util.List;

public class Page<T>{
    public static final Integer PAGE_SIZE = 3;

    private Integer pageSize = PAGE_SIZE;
    private Integer pageNo;
    private Integer pageTotalCount;
    private Integer totalRow;
    private List<T> items;
    private String url;

    public Page() {
    }

    public Page(Integer pageSize, Integer pageNo, Integer pageTotalCount, Integer totalRow, List<T> items, String url) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.pageTotalCount = pageTotalCount;
        this.totalRow = totalRow;
        this.items = items;
        this.url = url;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
