
package com.cheezycode.techiedesi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Replies {

    @SerializedName("totalItems")
    @Expose
    private String totalItems;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

}
