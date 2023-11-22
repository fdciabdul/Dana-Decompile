package io.split.android.client.service.sseclient.notifications;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class RawNotification {
    @SerializedName("channel")
    private String channel;
    @SerializedName("clientId")
    private String clientId;
    @SerializedName("data")
    private String data;
    @SerializedName("name")
    private String name;
    @SerializedName("timestamp")
    private long timestamp;

    public String getClientId() {
        return this.clientId;
    }

    public String getData() {
        return this.data;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getName() {
        return this.name;
    }
}
