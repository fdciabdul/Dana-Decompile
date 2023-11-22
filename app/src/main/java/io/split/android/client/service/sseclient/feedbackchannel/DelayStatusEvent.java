package io.split.android.client.service.sseclient.feedbackchannel;

import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;

/* loaded from: classes6.dex */
public class DelayStatusEvent extends PushStatusEvent {
    private final long mDelay;

    public DelayStatusEvent(long j) {
        super(PushStatusEvent.EventType.PUSH_DELAY_RECEIVED);
        this.mDelay = j;
    }

    public Long getDelay() {
        return Long.valueOf(this.mDelay);
    }
}
