package com.alibaba.ariver.kernel.common.log;

import com.google.common.net.HttpHeaders;
import id.dana.kyb.constant.KybDataSource;

/* loaded from: classes3.dex */
public enum LogType {
    CONNECTION(HttpHeaders.CONNECTION),
    API(KybDataSource.API),
    EVENT("Event"),
    PAGE("Page"),
    WORKER("Worker"),
    APP("Application"),
    CUSTOM("Custom");

    private String mLogType;

    LogType(String str) {
        this.mLogType = str;
    }

    public final String getTypeSting() {
        return this.mLogType;
    }
}
