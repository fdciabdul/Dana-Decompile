package com.alibaba.griver.base.t2;

import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class T2Store {

    /* renamed from: a  reason: collision with root package name */
    private String f6384a;
    private String b;
    private String c;
    private JSONObject d;

    public T2Store(String str, String str2, String str3, JSONObject jSONObject) {
        this.f6384a = str;
        this.b = str2;
        this.c = str3;
        this.d = jSONObject;
    }

    public String getEnableJsT2() {
        return this.f6384a;
    }

    public void setEnableJsT2(String str) {
        this.f6384a = str;
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

    public JSONObject getExtraJsT2MapStr() {
        return this.d;
    }

    public void setExtraJsT2MapStr(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("T2Store{enableJsT2='");
        sb.append(this.f6384a);
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
