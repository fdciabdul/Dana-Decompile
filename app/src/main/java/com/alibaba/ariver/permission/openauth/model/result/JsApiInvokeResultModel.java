package com.alibaba.ariver.permission.openauth.model.result;

import java.util.Map;

/* loaded from: classes6.dex */
public final class JsApiInvokeResultModel {
    private Map<String, String> extInfo;
    private String response;

    public JsApiInvokeResultModel(JsApiInvokeResultModel jsApiInvokeResultModel) {
        if (jsApiInvokeResultModel == null) {
            return;
        }
        this.response = jsApiInvokeResultModel.response;
        this.extInfo = jsApiInvokeResultModel.extInfo;
    }

    public JsApiInvokeResultModel() {
    }

    public final Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public final void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public final String getResponse() {
        return this.response;
    }

    public final void setResponse(String str) {
        this.response = str;
    }
}
