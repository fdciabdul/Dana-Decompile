package com.alibaba.ariver.resource.api.models;

/* loaded from: classes6.dex */
public class T2Store {

    /* renamed from: a  reason: collision with root package name */
    private String f6212a;
    private String b;
    private String c;
    private String d;

    public T2Store(String str, String str2, String str3, String str4) {
        this.f6212a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public String getEnableJsT2() {
        return this.f6212a;
    }

    public void setEnableJsT2(String str) {
        this.f6212a = str;
    }

    public String getUcJsT2() {
        return this.b;
    }

    public void setUcJsT2(String str) {
        this.b = str;
    }

    public String getUcJsT2State() {
        return this.c;
    }

    public void setUcJsT2State(String str) {
        this.c = str;
    }

    public String getExtraJsT2MapStr() {
        return this.d;
    }

    public void setExtraJsT2MapStr(String str) {
        this.d = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("T2Store{enableJsT2='");
        sb.append(this.f6212a);
        sb.append('\'');
        sb.append(", ucJsT2='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", ucJsT2State='");
        sb.append(this.c);
        sb.append('\'');
        sb.append(", extraJsT2MapStr='");
        sb.append(this.d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
