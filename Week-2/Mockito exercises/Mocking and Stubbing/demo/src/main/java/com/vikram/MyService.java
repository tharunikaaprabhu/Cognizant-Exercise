package com.vikram;

import com.External.externalApi;

public class MyService {
    private final externalApi externalApi;

    public MyService(externalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        try {
            String data = externalApi.getData();
            if (data == null) {
                return "No data available";
            }
            return data;
        } catch (RuntimeException e) {
            throw e;
        }
    }
}