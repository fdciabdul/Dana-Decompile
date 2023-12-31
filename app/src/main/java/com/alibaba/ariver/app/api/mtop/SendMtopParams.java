package com.alibaba.ariver.app.api.mtop;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class SendMtopParams implements Serializable {
    private static final long serialVersionUID = -33061885727159462L;
    public String accountSite;
    public String api;
    public String method;
    public String mpHost;
    public boolean needAuth;
    public boolean needLogin;
    public String pageUrl;
    public boolean post;
    public String sessionOption;
    public String sourceAppId;
    private Bundle startParams;
    public long timer;
    public String ttid;
    public String userAgent;
    public String v;
    public String dataType = "originaljson";
    public int wuaFlag = -1;
    private Map<String, String> dataMap = new HashMap();
    private Map<String, String> parameterMap = new HashMap();
    private Map<String, String> headers = new HashMap();

    public SendMtopParams(String str, Bundle bundle) {
        this.sourceAppId = str;
        this.startParams = bundle;
    }

    public SendMtopParams() {
    }

    public Map<String, String> getDataMap() {
        return this.dataMap;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, String> getParameterMap() {
        return this.parameterMap;
    }

    public void addParameterMap(String str, String str2) {
        this.parameterMap.put(str, str2);
    }

    public void addData(String str, String str2) {
        this.dataMap.put(str, str2);
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void setHeaders(Map<String, String> map) {
        this.headers.putAll(map);
    }

    public Bundle getStartParams() {
        return this.startParams;
    }
}
