package io.split.android.client.service.sseclient.feedbackchannel;

/* loaded from: classes6.dex */
public class PushStatusEvent {
    private final EventType mMessage;

    /* loaded from: classes6.dex */
    public enum EventType {
        PUSH_SUBSYSTEM_UP,
        PUSH_SUBSYSTEM_DOWN,
        PUSH_RETRYABLE_ERROR,
        PUSH_NON_RETRYABLE_ERROR,
        PUSH_DISABLED,
        PUSH_RESET,
        SUCCESSFUL_SYNC,
        PUSH_DELAY_RECEIVED
    }

    public PushStatusEvent(EventType eventType) {
        this.mMessage = eventType;
    }

    public EventType getMessage() {
        return this.mMessage;
    }
}
