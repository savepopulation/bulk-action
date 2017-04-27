package com.raqun.bulkaction.data.bean;

import com.google.gson.annotations.SerializedName;
import com.raqun.bulkaction.data.User;

/**
 * Created by tyln on 28/04/2017.
 */

public class UserWrapper {
    @SerializedName("data")
    public User user;
}
