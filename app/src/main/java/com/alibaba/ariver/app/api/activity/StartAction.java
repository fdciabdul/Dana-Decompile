package com.alibaba.ariver.app.api.activity;

/* loaded from: classes3.dex */
public enum StartAction {
    SHOW_LOADING,
    SHOW_ERROR,
    DIRECT_START;

    public final boolean needWaitIpc() {
        return this == SHOW_LOADING;
    }
}
