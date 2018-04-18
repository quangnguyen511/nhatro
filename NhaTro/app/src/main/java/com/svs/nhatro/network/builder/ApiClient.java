package com.svs.nhatro.network.builder;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import com.svs.nhatro.base.BaseApplication;
import com.svs.nhatro.network.api.ApiRequestListener;

public class ApiClient extends ApiClientBuilder {

    public ApiClient(ApiRequestListener listener, BaseApplication baseApp) {
        super(listener, baseApp);
    }

}
