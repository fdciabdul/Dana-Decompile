package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.sseclient.SseJwtToken;

/* loaded from: classes6.dex */
public class SseAuthenticationResult {
    private final Integer httpStatus;
    private boolean isErrorRecoverable;
    private SseJwtToken jwtToken;
    private boolean pushEnabled;
    private long sseConnectionDelay;
    private boolean success;

    public SseAuthenticationResult(boolean z, boolean z2, boolean z3, long j, SseJwtToken sseJwtToken, Integer num) {
        this.success = z;
        this.isErrorRecoverable = z2;
        this.pushEnabled = z3;
        this.sseConnectionDelay = j;
        this.jwtToken = sseJwtToken;
        this.httpStatus = num;
    }

    public SseAuthenticationResult(boolean z, boolean z2, boolean z3, long j, SseJwtToken sseJwtToken) {
        this(z, z2, z3, j, sseJwtToken, null);
    }

    public SseAuthenticationResult(boolean z, boolean z2) {
        this(z, z2, false, 0L, null);
    }

    public SseAuthenticationResult(int i) {
        this(false, true, false, 0L, null, Integer.valueOf(i));
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isErrorRecoverable() {
        return this.isErrorRecoverable;
    }

    public boolean isPushEnabled() {
        return this.pushEnabled;
    }

    public long getSseConnectionDelay() {
        return this.sseConnectionDelay;
    }

    public SseJwtToken getJwtToken() {
        return this.jwtToken;
    }

    public Integer getHttpStatus() {
        return this.httpStatus;
    }
}
