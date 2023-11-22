package io.split.android.client.telemetry.model.streaming;

import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.e;
import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class StreamingEvent {
    @SerializedName(d.f7256a)
    private final Long eventData;
    @SerializedName(e.PlaceComponentResult)
    private final int eventType;
    @SerializedName(SecurityConstants.KEY_TEXT)
    private final long timestamp;

    public StreamingEvent(EventTypeEnum eventTypeEnum, Long l, long j) {
        this.eventType = eventTypeEnum.getNumericValue();
        this.eventData = l;
        this.timestamp = j;
    }

    public int getEventType() {
        return this.eventType;
    }

    public Long getEventData() {
        return this.eventData;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
