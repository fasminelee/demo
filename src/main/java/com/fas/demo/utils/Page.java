package com.fas.demo.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    public Page(int pageon, int row, int rowcount) {
        pageNumber = 11;
        this.pageon = pageon;
        this.row = row;
        this.rowcount = rowcount;
        compute();
    }

    public Page(int pageon, int row) {
        pageNumber = 11;
        this.pageon = pageon;
        this.row = row;
    }

    public Page(int pageon) {
        pageNumber = 11;
        this.pageon = pageon;
    }

    public Page() {
        pageNumber = 11;
    }
//
//    public int getPageNumber() {
//        return pageNumber;
//    }
//
//    public void setPageNumber(int pageNumber) {
//        this.pageNumber = pageNumber;
//    }

    public void compute() {
        if (rowcount <= 0)
            return;
        if (row <= 0)
            row = 10;
        pagecount = rowcount % row != 0 ? rowcount / row + 1 : rowcount / row;
        if (pageon > pagecount)
            pageon = pagecount;
        if (pageon < 1)
            pageon = 1;
        start = (pageon - 1) * row;
        end = pageon * row;
        if (end > rowcount)
            end = rowcount;
    }

//    public int getStart() {
//        return start;
//    }
//
//    public void setStart(int start) {
//        this.start = start;
//    }

//    public int getEnd() {
//        return end;
//    }
//
//    public void setEnd(int end) {
//        this.end = end;
//    }

    public void setRowcountAndCompute(int rowcount) {
        this.rowcount = rowcount;
        compute();
    }

    private int pageon;
    private int rowcount;
    private int pagecount;
    private int row;
    private int start;
    private int end;
    private int pageNumber;
}
