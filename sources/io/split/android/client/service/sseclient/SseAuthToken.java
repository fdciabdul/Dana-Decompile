package io.split.android.client.service.sseclient;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
class SseAuthToken {
    @SerializedName("x-ably-capability")
    private final String channelList;
    @SerializedName("exp")
    private final long expirationAt;
    @SerializedName("iat")
    private final long issuedAt;

    public SseAuthToken(String str, long j, long j2) {
        this.channelList = str;
        this.issuedAt = j;
        this.expirationAt = j2;
    }

    public String getChannelList() {
        return this.channelList;
    }

    public long getIssuedAt() {
        return this.issuedAt;
    }

    public long getExpirationAt() {
        return this.expirationAt;
    }
}
