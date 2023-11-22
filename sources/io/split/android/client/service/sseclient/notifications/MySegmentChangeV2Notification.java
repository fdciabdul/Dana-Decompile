package io.split.android.client.service.sseclient.notifications;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.common.CompressionType;

/* loaded from: classes6.dex */
public class MySegmentChangeV2Notification extends IncomingNotification {
    private static final String FIELD_CHANGE_NUMBER = "changeNumber";
    private static final String FIELD_COMPRESSION = "c";
    private static final String FIELD_DATE = "d";
    private static final String FIELD_SEGMENT_NAME = "segmentName";
    private static final String FIELD_UPDATE_STRATEGY = "u";
    @SerializedName(FIELD_CHANGE_NUMBER)
    private Long changeNumber;
    @SerializedName("c")
    private CompressionType compression;
    @SerializedName("d")
    private String data;
    @SerializedName(FIELD_SEGMENT_NAME)
    private String segmentName;
    @SerializedName("u")
    private MySegmentUpdateStrategy updateStrategy;

    public Long getChangeNumber() {
        return this.changeNumber;
    }

    public String getSegmentName() {
        return this.segmentName;
    }

    public CompressionType getCompression() {
        return this.compression;
    }

    public MySegmentUpdateStrategy getUpdateStrategy() {
        return this.updateStrategy;
    }

    public String getData() {
        return this.data;
    }
}
