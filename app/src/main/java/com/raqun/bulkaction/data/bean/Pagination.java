package com.raqun.bulkaction.data.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyln on 01/05/2017.
 */

final class Pagination {
    @SerializedName("next_url")
    private String nextUrl;
    @SerializedName("next_max_id")
    private String nextMaxId;

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }

    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }
}
