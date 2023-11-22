package com.alipay.mobile.rome.longlinkservice;

/* loaded from: classes3.dex */
public interface ISyncUpCallback {

    /* loaded from: classes3.dex */
    public enum SyncUpState {
        SUCCEED
    }

    void onSyncUpResult(String str, String str2, SyncUpState syncUpState);
}
