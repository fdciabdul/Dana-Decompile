package com.iap.ac.android.gol.google.model;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class BaseResult implements Serializable {
    public String passThroughInfo;
    public Result result;
    private String traceId;

    /* loaded from: classes8.dex */
    public static class Result {
        public String resultCode;
        public String resultMessage;
        public String resultStatus;
    }

    public boolean isSuccess() {
        Result result = this.result;
        return result != null && "SUCCESS".equals(result.resultCode);
    }

    public String getResultCode() {
        Result result = this.result;
        return result != null ? result.resultCode : "";
    }

    public String getResultMessage() {
        Result result = this.result;
        return result != null ? result.resultMessage : "";
    }
}
