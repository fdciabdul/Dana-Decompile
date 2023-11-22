package io.split.android.client.service.sseclient;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SseAuthenticationResponse {
    private boolean isClientError;
    @SerializedName("pushEnabled")
    private boolean isStreamingEnabled;
    @SerializedName("connDelay")
    private Long sseConnectionDelay;
    private String token;

    public SseAuthenticationResponse() {
        this.isClientError = false;
    }

    public SseAuthenticationResponse(boolean z) {
        this.isClientError = z;
    }

    public boolean isClientError() {
        return this.isClientError;
    }

    public boolean isStreamingEnabled() {
        return this.isStreamingEnabled;
    }

    public String getToken() {
        return this.token;
    }

    public Long getSseConnectionDelay() {
        return this.sseConnectionDelay;
    }
}
