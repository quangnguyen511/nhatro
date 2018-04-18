package com.svs.nhatro.network.connect;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

public enum ApiConfigType {
    STAGING("staging"),
    DEV("dev"),
    PRELIVE("prelive"),
    LIVE("live");

    private String mTitle;

    ApiConfigType(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }
}
