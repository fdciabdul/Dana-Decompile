package io.split.android.client.service.sseclient.notifications;

/* loaded from: classes6.dex */
public class ControlNotification extends IncomingNotification {
    private ControlType controlType;

    /* loaded from: classes6.dex */
    public enum ControlType {
        STREAMING_RESUMED,
        STREAMING_DISABLED,
        STREAMING_PAUSED,
        STREAMING_RESET
    }

    public ControlType getControlType() {
        return this.controlType;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
