package com.testapi.testapi.Dtos;

import java.util.List;

public class PagedResult<T> {
    public PagedResult() {}

    public long getTotalRecords() {
        return TotalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        TotalRecords = totalRecords;
    }

    public long getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(long totalPages) {
        TotalPages = totalPages;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }

    private List<T> Data;
    private long TotalRecords;
    private long TotalPages;
    private int PageNumber;
    private int PageSize;
    private int CurrentPage;

}
