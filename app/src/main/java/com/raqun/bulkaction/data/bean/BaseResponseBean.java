package com.raqun.bulkaction.data.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyln on 01/05/2017.
 */

public class BaseResponseBean {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("pagination")
    private Pagination pagination;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
