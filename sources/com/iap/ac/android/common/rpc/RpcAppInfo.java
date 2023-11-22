package com.iap.ac.android.common.rpc;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RpcAppInfo {
    public String appId;
    public String appKey;
    public String authCode;
    public Map<String, String> headers;
    public String rpcGateWayUrl;
    public int timeoutMS;

    public RpcAppInfo() {
        this.headers = new HashMap();
        this.timeoutMS = 0;
    }

    public void addHeader(String str, Object obj) {
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        if (obj != null) {
            this.headers.put(str, String.valueOf(obj));
        } else {
            this.headers.put(str, null);
        }
    }

    public void addHeaders(Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        this.headers.putAll(map);
    }

    public void clearHeaders() {
        Map<String, String> map = this.headers;
        if (map != null) {
            map.clear();
        }
    }

    public RpcAppInfo(RpcAppInfo rpcAppInfo) {
        this.headers = new HashMap();
        this.timeoutMS = 0;
        this.appId = rpcAppInfo.appId;
        this.appKey = rpcAppInfo.appKey;
        this.authCode = rpcAppInfo.authCode;
        this.rpcGateWayUrl = rpcAppInfo.rpcGateWayUrl;
        this.headers = new HashMap(rpcAppInfo.headers);
        this.timeoutMS = rpcAppInfo.timeoutMS;
    }

    public RpcAppInfo(String str, String str2, String str3, String str4) {
        this.headers = new HashMap();
        this.timeoutMS = 0;
        this.appId = str;
        this.appKey = str2;
        this.authCode = str3;
        this.rpcGateWayUrl = str4;
    }
}
