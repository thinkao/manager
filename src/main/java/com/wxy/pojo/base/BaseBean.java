package com.wxy.pojo.base;

public class BaseBean {

    private Integer offset = 0;

    private Integer limit = 10;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
