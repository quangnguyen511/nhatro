package com.svs.nhatro.network.builder;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import java.util.HashMap;
import java.util.Map;

public class ApiParams {

    private Map<String, Object> mParams = new HashMap<>();

    public void add(String key, Object value) {
        mParams.put(key, value);
    }

    public Map<String, Object> getParams() {
        return mParams;
    }
}
