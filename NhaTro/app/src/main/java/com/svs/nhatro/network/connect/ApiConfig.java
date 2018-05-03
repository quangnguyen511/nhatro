package com.svs.nhatro.network.connect;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

public class ApiConfig {
    public static ApiConfigDetail createConnectionDetail(ApiConfigType type) {
        ApiConfigDetail connection = new ApiConfigDetail();
        if (type == null) {
            type = ApiConfigType.DEV;
        }
        switch (type) {
            case DEV:
                connection.setBaseURL("http://192.168.100.94/api/");
                connection.setApiKey("DEVNATSVSMOTEL01031995");
                break;
//            case STAGING:
//                connection.setBaseURL("http://stg.fxchange.rmlbs.co/api/v1/");
//                connection.setApiKey("STGACCRMLEXCHANGE26122017");
//                break;
//            case PRELIVE:
//                connection.setBaseURL("https://prelive.fxchange.rmlbs.co/api/v1/");
//                connection.setApiKey("DEVACCRMLEXCHANGE03052017");
//                break;
//            case LIVE:
//                connection.setBaseURL("https://live.fxchange.sg/api/v1/");
//                connection.setApiKey("LIVEACCRMLEXCHANGE03032017");
//                break;
            default:
                break;
        }
        return connection;
    }
}
