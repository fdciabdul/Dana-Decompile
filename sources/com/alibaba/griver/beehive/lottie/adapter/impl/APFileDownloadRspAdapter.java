package com.alibaba.griver.beehive.lottie.adapter.impl;

/* loaded from: classes6.dex */
public class APFileDownloadRspAdapter {
    public String cloudId;
    public String msg;
    public int retCode;
    public String savePath;

    public int getRetCode() {
        return this.retCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCloudId() {
        return this.cloudId;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public APFileDownloadRspAdapter() {
    }

    public APFileDownloadRspAdapter(int i, String str, String str2, String str3) {
        this.retCode = i;
        this.msg = str;
        this.cloudId = str2;
        this.savePath = str3;
    }
}
