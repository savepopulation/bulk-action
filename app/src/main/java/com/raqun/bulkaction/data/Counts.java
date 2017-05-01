package com.raqun.bulkaction.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyln on 01/05/2017.
 */

public final class Counts {
    @SerializedName("media")
    private long media;

    @SerializedName("follows")
    private long follows;

    @SerializedName("followed_by")
    private long followedBy;

    public long getMedia() {
        return media;
    }

    public long getFollows() {
        return follows;
    }

    public long getFollowedBy() {
        return followedBy;
    }
}
