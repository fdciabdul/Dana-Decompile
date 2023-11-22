package io.split.android.client.service.sseclient.notifications;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SplitKillNotification extends IncomingNotification {
    @SerializedName("changeNumber")
    private long changeNumber;
    @SerializedName("defaultTreatment")
    private String defaultTreatment;
    @SerializedName("splitName")
    private String splitName;

    public long getChangeNumber() {
        return this.changeNumber;
    }

    public String getSplitName() {
        return this.splitName;
    }

    public String getDefaultTreatment() {
        return this.defaultTreatment;
    }
}
