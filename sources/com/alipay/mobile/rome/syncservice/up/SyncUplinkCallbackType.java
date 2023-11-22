package com.alipay.mobile.rome.syncservice.up;

/* loaded from: classes3.dex */
public enum SyncUplinkCallbackType {
    TYPE_NONE,
    TYPE_NORMAL,
    TYPE_LIKE_RPC;

    public static SyncUplinkCallbackType toType(int i) {
        if (i != 1) {
            if (i == 2) {
                return TYPE_LIKE_RPC;
            }
            return TYPE_NONE;
        }
        return TYPE_NORMAL;
    }
}
