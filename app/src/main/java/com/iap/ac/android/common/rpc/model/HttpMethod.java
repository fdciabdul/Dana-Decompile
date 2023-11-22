package com.iap.ac.android.common.rpc.model;

import com.google.firebase.perf.FirebasePerformance;

/* loaded from: classes3.dex */
public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT(FirebasePerformance.HttpMethod.PUT),
    HEAD(FirebasePerformance.HttpMethod.HEAD),
    TRACE(FirebasePerformance.HttpMethod.TRACE),
    PATCH(FirebasePerformance.HttpMethod.PATCH),
    DELETE("DELETE"),
    CONNECT(FirebasePerformance.HttpMethod.CONNECT),
    OPTIONS(FirebasePerformance.HttpMethod.OPTIONS);

    public String method;

    HttpMethod(String str) {
        this.method = str;
    }

    public static HttpMethod fromString(String str) {
        HttpMethod httpMethod = POST;
        if (httpMethod.method.equalsIgnoreCase(str)) {
            return httpMethod;
        }
        HttpMethod httpMethod2 = GET;
        if (httpMethod2.method.equalsIgnoreCase(str)) {
            return httpMethod2;
        }
        HttpMethod httpMethod3 = PUT;
        if (httpMethod3.method.equalsIgnoreCase(str)) {
            return httpMethod3;
        }
        HttpMethod httpMethod4 = HEAD;
        if (httpMethod4.method.equalsIgnoreCase(str)) {
            return httpMethod4;
        }
        HttpMethod httpMethod5 = TRACE;
        if (httpMethod5.method.equalsIgnoreCase(str)) {
            return httpMethod5;
        }
        HttpMethod httpMethod6 = PATCH;
        if (httpMethod6.method.equalsIgnoreCase(str)) {
            return httpMethod6;
        }
        HttpMethod httpMethod7 = DELETE;
        if (httpMethod7.method.equalsIgnoreCase(str)) {
            return httpMethod7;
        }
        HttpMethod httpMethod8 = CONNECT;
        if (httpMethod8.method.equalsIgnoreCase(str)) {
            return httpMethod8;
        }
        HttpMethod httpMethod9 = OPTIONS;
        if (httpMethod9.method.equalsIgnoreCase(str)) {
            return httpMethod9;
        }
        return null;
    }
}
