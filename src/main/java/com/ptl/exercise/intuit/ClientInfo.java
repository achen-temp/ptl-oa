package com.ptl.exercise.intuit;

import java.util.HashMap;
import java.util.Map;

public class ClientInfo {
    private static Map<String, ClientInfo> map = null;

    String clientId;
    long intervalInSecond;
    int callsAllowed;

    public ClientInfo(String clientId, long intervalInSecond, int callsAllowed) {
        this.clientId = clientId;
        this.intervalInSecond = intervalInSecond;
        this.callsAllowed = callsAllowed;
    }

    /**
     * Returna a map of Client Information (the map contains the key as the clientId and the details)
     */
    public static Map<String, ClientInfo> getClientInfo() {
        if (map == null ){
            map = new HashMap<>();
            map.put("my_device_1432", new ClientInfo("my_device_1432", 30L, 3));
            map.put("my_device_1234", new ClientInfo("my_device_1234", 300L, 10));
            map.put("my_device_12212", new ClientInfo("my_device_12212", 3600L, 50));
        }
        return map;
    }


}
