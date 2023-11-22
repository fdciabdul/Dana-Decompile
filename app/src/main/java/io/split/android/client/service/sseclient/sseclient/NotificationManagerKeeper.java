package io.split.android.client.service.sseclient.sseclient;

import com.google.common.collect.Maps;
import com.google.gson.JsonSyntaxException;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.notifications.ControlNotification;
import io.split.android.client.service.sseclient.notifications.OccupancyNotification;
import io.split.android.client.telemetry.model.streaming.OccupancyPriStreamingEvent;
import io.split.android.client.telemetry.model.streaming.OccupancySecStreamingEvent;
import io.split.android.client.telemetry.model.streaming.StreamingStatusStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class NotificationManagerKeeper {
    private static final String CHANNEL_PRI_KEY = "PRI";
    private static final String CHANNEL_SEC_KEY = "SEC";
    private final PushManagerEventBroadcaster mBroadcasterChannel;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    Map<String, Publisher> mPublishers = Maps.newConcurrentMap();
    private final AtomicLong mLastControlTimestamp = new AtomicLong(0);
    private final AtomicBoolean mIsStreamingActive = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class Publisher {
        int count;
        long lastTimestamp;

        public Publisher(int i, long j) {
            this.count = i;
            this.lastTimestamp = j;
        }
    }

    public NotificationManagerKeeper(PushManagerEventBroadcaster pushManagerEventBroadcaster, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mBroadcasterChannel = pushManagerEventBroadcaster;
        this.mTelemetryRuntimeProducer = telemetryRuntimeProducer;
        this.mPublishers.put(CHANNEL_PRI_KEY, new Publisher(1, 0L));
        this.mPublishers.put(CHANNEL_SEC_KEY, new Publisher(0, 0L));
    }

    public void handleControlNotification(ControlNotification controlNotification) {
        if (this.mLastControlTimestamp.get() >= controlNotification.getTimestamp()) {
            return;
        }
        this.mLastControlTimestamp.set(controlNotification.getTimestamp());
        try {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[controlNotification.getControlType().ordinal()];
            if (i == 1) {
                this.mIsStreamingActive.set(false);
                this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_DOWN));
                this.mTelemetryRuntimeProducer.recordStreamingEvents(new StreamingStatusStreamingEvent(StreamingStatusStreamingEvent.Status.PAUSED, System.currentTimeMillis()));
            } else if (i == 2) {
                this.mIsStreamingActive.set(false);
                this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_DISABLED));
                this.mTelemetryRuntimeProducer.recordStreamingEvents(new StreamingStatusStreamingEvent(StreamingStatusStreamingEvent.Status.DISABLED, System.currentTimeMillis()));
            } else if (i == 3) {
                this.mIsStreamingActive.set(true);
                if (publishersCount() > 0) {
                    this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_UP));
                    this.mTelemetryRuntimeProducer.recordStreamingEvents(new StreamingStatusStreamingEvent(StreamingStatusStreamingEvent.Status.ENABLED, System.currentTimeMillis()));
                }
            } else {
                if (i == 4) {
                    this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_RESET));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown message received");
                sb.append(controlNotification.getControlType());
                Logger.e(sb.toString());
            }
        } catch (JsonSyntaxException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not parse control notification: ");
            sb2.append(controlNotification.getJsonData());
            sb2.append(" -> ");
            sb2.append(e.getLocalizedMessage());
            Logger.e(sb2.toString());
        } catch (Exception e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected error while processing control notification: ");
            sb3.append(e2.getLocalizedMessage());
            Logger.e(sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.split.android.client.service.sseclient.sseclient.NotificationManagerKeeper$1 */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType;

        static {
            int[] iArr = new int[ControlNotification.ControlType.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType = iArr;
            try {
                iArr[ControlNotification.ControlType.STREAMING_PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[ControlNotification.ControlType.STREAMING_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[ControlNotification.ControlType.STREAMING_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[ControlNotification.ControlType.STREAMING_RESET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void handleOccupancyNotification(OccupancyNotification occupancyNotification) {
        String channelKey = getChannelKey(occupancyNotification);
        if (channelKey == null || isOldTimestamp(occupancyNotification, channelKey)) {
            return;
        }
        int publishersCount = publishersCount();
        updateChannelInfo(channelKey, occupancyNotification.getMetrics().getPublishers(), occupancyNotification.getTimestamp());
        if (CHANNEL_PRI_KEY.equals(channelKey)) {
            this.mTelemetryRuntimeProducer.recordStreamingEvents(new OccupancyPriStreamingEvent(publishersCount(), System.currentTimeMillis()));
        } else if (CHANNEL_SEC_KEY.equals(channelKey)) {
            this.mTelemetryRuntimeProducer.recordStreamingEvents(new OccupancySecStreamingEvent(publishersCount(), System.currentTimeMillis()));
        }
        if (publishersCount() == 0 && publishersCount > 0) {
            this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_DOWN));
        } else if (publishersCount() > 0 && publishersCount == 0 && this.mIsStreamingActive.get()) {
            this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_UP));
        }
    }

    public boolean isStreamingActive() {
        return this.mIsStreamingActive.get();
    }

    private int publishersCount() {
        int i;
        int i2;
        synchronized (this) {
            i = this.mPublishers.get(CHANNEL_PRI_KEY).count;
            i2 = this.mPublishers.get(CHANNEL_SEC_KEY).count;
        }
        return i + i2;
    }

    private String getChannelKey(OccupancyNotification occupancyNotification) {
        if (occupancyNotification.isControlPriChannel()) {
            return CHANNEL_PRI_KEY;
        }
        if (occupancyNotification.isControlSecChannel()) {
            return CHANNEL_SEC_KEY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown occupancy channel ");
        sb.append(occupancyNotification.getChannel());
        Logger.w(sb.toString());
        return null;
    }

    private boolean isOldTimestamp(OccupancyNotification occupancyNotification, String str) {
        boolean z;
        synchronized (this) {
            z = this.mPublishers.get(str).lastTimestamp >= occupancyNotification.getTimestamp();
        }
        return z;
    }

    private void updateChannelInfo(String str, int i, long j) {
        synchronized (this) {
            Publisher publisher = this.mPublishers.get(str);
            if (publisher == null) {
                return;
            }
            publisher.lastTimestamp = j;
            publisher.count = i;
        }
    }
}
