package com.alibaba.ariver.permission.model;

/* loaded from: classes6.dex */
public class AuthScope {

    /* renamed from: a  reason: collision with root package name */
    private String f6183a;
    private String b;

    public AuthScope(String str, String str2) {
        this.f6183a = str;
        this.b = str2;
    }

    public String getScopeName() {
        return this.f6183a;
    }

    public void setScopeName(String str) {
        this.f6183a = str;
    }

    public String getScopeContent() {
        return this.b;
    }

    public void setScopeContent(String str) {
        this.b = str;
    }
}
