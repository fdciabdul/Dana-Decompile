package com.alibaba.ariver.kernel.common.rpc;

import java.util.Map;

/* loaded from: classes6.dex */
public class RVRpcResponse {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f6154a;
    private Object b;
    private String c;

    public RVRpcResponse(Map<String, String> map, Object obj) {
        this.f6154a = map;
        this.b = obj;
    }

    public RVRpcResponse(Map<String, String> map, Object obj, String str) {
        this.f6154a = map;
        this.b = obj;
        this.c = str;
    }

    public Map<String, String> getHeaders() {
        return this.f6154a;
    }

    public Object getResponse() {
        return this.b;
    }

    public String getTimeCost() {
        return this.c;
    }
}
