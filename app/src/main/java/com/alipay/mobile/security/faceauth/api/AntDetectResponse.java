package com.alipay.mobile.security.faceauth.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class AntDetectResponse implements Serializable {
    private static final long serialVersionUID = 110;
    String token = "";
    String resultMessage = "";
    int result = 0;
    boolean isSuccess = false;
    String tag = "";
    Map<String, String> ext = new HashMap();

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String str) {
        this.resultMessage = str;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public void setExt(Map<String, String> map) {
        this.ext = map;
    }
}
