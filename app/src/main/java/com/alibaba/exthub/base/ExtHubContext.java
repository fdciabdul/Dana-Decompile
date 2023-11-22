package com.alibaba.exthub.base;

import android.app.Activity;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class ExtHubContext {

    /* renamed from: a  reason: collision with root package name */
    private String f6259a;
    private JSONObject b;
    private Activity c;
    private String d;
    private String e;
    private Node f;

    public String getName() {
        return this.f6259a;
    }

    public void setName(String str) {
        this.f6259a = str;
    }

    public JSONObject getParams() {
        return this.b;
    }

    public void setParams(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public Activity getActivity() {
        return this.c;
    }

    public void setActivity(Activity activity) {
        this.c = activity;
    }

    public String getBizType() {
        return this.e;
    }

    public void setBizType(String str) {
        this.e = str;
    }

    public String getAppId() {
        return this.d;
    }

    public void setAppId(String str) {
        this.d = str;
    }

    public Node getNode() {
        return this.f;
    }

    public void setNode(Node node) {
        this.f = node;
    }
}
