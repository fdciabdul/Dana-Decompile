package io.split.android.client.service.sseclient.notifications;

import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.google.gson.annotations.SerializedName;
import io.split.android.client.common.CompressionType;

/* loaded from: classes6.dex */
public class SplitsChangeNotification extends IncomingNotification {
    @SerializedName("changeNumber")
    private long changeNumber;
    @SerializedName("c")
    private Integer compressionType;
    @SerializedName(d.f7256a)
    private String data;
    @SerializedName("pcn")
    private Long previousChangeNumber;

    public SplitsChangeNotification() {
    }

    public SplitsChangeNotification(long j) {
        this.changeNumber = j;
    }

    public long getChangeNumber() {
        return this.changeNumber;
    }

    public Long getPreviousChangeNumber() {
        return this.previousChangeNumber;
    }

    public String getData() {
        return this.data;
    }

    public CompressionType getCompressionType() {
        Integer num = this.compressionType;
        if (num != null) {
            if (num.intValue() == 0) {
                return CompressionType.NONE;
            }
            if (this.compressionType.intValue() == 1) {
                return CompressionType.GZIP;
            }
            if (this.compressionType.intValue() == 2) {
                return CompressionType.ZLIB;
            }
            return null;
        }
        return null;
    }
}
