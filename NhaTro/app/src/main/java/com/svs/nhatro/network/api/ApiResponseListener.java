package com.svs.nhatro.network.api;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import com.svs.nhatro.base.BaseModel;
import com.svs.nhatro.model.ErrorModel;

public interface ApiResponseListener {
    void onDataError(int nCode, ErrorModel t);

    void onDataResponse(int nCode, BaseModel nData);
}
