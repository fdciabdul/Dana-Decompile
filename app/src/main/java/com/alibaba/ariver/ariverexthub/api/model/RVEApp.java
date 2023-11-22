package com.alibaba.ariver.ariverexthub.api.model;

import com.alibaba.ariver.ariverexthub.api.RVEApiHandler;
import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class RVEApp {

    /* renamed from: a  reason: collision with root package name */
    private String f6008a;
    private ConcurrentHashMap<String, RVEApiHandler> b = new ConcurrentHashMap<>();

    private RVEApp() {
    }

    public RVEApp(String str) {
        this.f6008a = str;
    }

    public String getAppId() {
        return this.f6008a;
    }

    public void setAppId(String str) {
        this.f6008a = str;
    }

    public ConcurrentHashMap<String, RVEApiHandler> getHandlers() {
        return this.b;
    }

    public void setHandlers(ConcurrentHashMap<String, RVEApiHandler> concurrentHashMap) {
        this.b = concurrentHashMap;
    }

    public RVEApiHandler getHandler(String str) {
        return this.b.get(str);
    }
}
