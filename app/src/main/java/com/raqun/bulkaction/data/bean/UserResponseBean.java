package com.raqun.bulkaction.data.bean;

import com.google.gson.annotations.SerializedName;
import com.raqun.bulkaction.data.User;

/**
 * Created by tyln on 28/04/2017.
 */

public class UserResponseBean extends BaseResponseBean {
    @SerializedName("data")
    private User user;

    public User getUser() {
        return user;
    }
}
