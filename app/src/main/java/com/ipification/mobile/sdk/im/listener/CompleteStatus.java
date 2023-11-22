package com.ipification.mobile.sdk.im.listener;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lcom/ipification/mobile/sdk/im/listener/CompleteStatus;", "", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NOT_FOUND", "FINISHED", "PENDING", "UNKNOWN"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public enum CompleteStatus {
    NOT_FOUND("not_found"),
    FINISHED("finished"),
    PENDING("pending"),
    UNKNOWN("");

    private final String status;

    CompleteStatus(String str) {
        this.status = str;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }
}
