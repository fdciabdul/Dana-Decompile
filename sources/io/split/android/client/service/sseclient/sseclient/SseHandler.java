package io.split.android.client.service.sseclient.sseclient;

import com.google.common.base.Preconditions;
import com.google.gson.JsonSyntaxException;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.notifications.ControlNotification;
import io.split.android.client.service.sseclient.notifications.IncomingNotification;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.NotificationProcessor;
import io.split.android.client.service.sseclient.notifications.NotificationType;
import io.split.android.client.service.sseclient.notifications.OccupancyNotification;
import io.split.android.client.service.sseclient.notifications.StreamingError;
import io.split.android.client.telemetry.model.streaming.AblyErrorStreamingEvent;
import io.split.android.client.telemetry.model.streaming.SseConnectionErrorStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;

/* loaded from: classes6.dex */
public class SseHandler {
    private final PushManagerEventBroadcaster mBroadcasterChannel;
    private final NotificationManagerKeeper mNotificationManagerKeeper;
    private final NotificationParser mNotificationParser;
    private final NotificationProcessor mNotificationProcessor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public SseHandler(NotificationParser notificationParser, NotificationProcessor notificationProcessor, TelemetryRuntimeProducer telemetryRuntimeProducer, PushManagerEventBroadcaster pushManagerEventBroadcaster) {
        this(notificationParser, notificationProcessor, new NotificationManagerKeeper(pushManagerEventBroadcaster, telemetryRuntimeProducer), pushManagerEventBroadcaster, telemetryRuntimeProducer);
    }

    public SseHandler(NotificationParser notificationParser, NotificationProcessor notificationProcessor, NotificationManagerKeeper notificationManagerKeeper, PushManagerEventBroadcaster pushManagerEventBroadcaster, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mNotificationParser = (NotificationParser) Preconditions.checkNotNull(notificationParser);
        this.mNotificationProcessor = (NotificationProcessor) Preconditions.checkNotNull(notificationProcessor);
        this.mBroadcasterChannel = (PushManagerEventBroadcaster) Preconditions.checkNotNull(pushManagerEventBroadcaster);
        this.mNotificationManagerKeeper = (NotificationManagerKeeper) Preconditions.checkNotNull(notificationManagerKeeper);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    public boolean isConnectionConfirmed(Map<String, String> map) {
        if (map.get("data") != null && map.get("data") == null && map.get("event") == null) {
            return true;
        }
        return (map.get("data") == null || this.mNotificationParser.isError(map)) ? false : true;
    }

    public void handleIncomingMessage(Map<String, String> map) {
        String str = map.get("data");
        if (str != null) {
            if (this.mNotificationParser.isError(map)) {
                handleError(str);
                return;
            }
            IncomingNotification parseIncoming = this.mNotificationParser.parseIncoming(str);
            if (parseIncoming == null) {
                return;
            }
            switch (AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[parseIncoming.getType().ordinal()]) {
                case 1:
                    handleControlNotification(parseIncoming);
                    return;
                case 2:
                    handleOccupancyNotification(parseIncoming);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    if (this.mNotificationManagerKeeper.isStreamingActive()) {
                        this.mNotificationProcessor.process(parseIncoming);
                        return;
                    }
                    return;
                default:
                    Logger.w("SSE Handler: Unknown notification");
                    return;
            }
        }
    }

    /* renamed from: io.split.android.client.service.sseclient.sseclient.SseHandler$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType;

        static {
            int[] iArr = new int[NotificationType.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType = iArr;
            try {
                iArr[NotificationType.CONTROL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.OCCUPANCY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.SPLIT_KILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.SPLIT_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MY_SEGMENTS_UPDATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MY_SEGMENTS_UPDATE_V2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public void handleError(boolean z) {
        this.mBroadcasterChannel.pushMessage(new PushStatusEvent(z ? PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR : PushStatusEvent.EventType.PUSH_NON_RETRYABLE_ERROR));
        this.mTelemetryRuntimeProducer.recordStreamingEvents(new SseConnectionErrorStreamingEvent(z ? SseConnectionErrorStreamingEvent.Status.REQUESTED : SseConnectionErrorStreamingEvent.Status.NON_REQUESTED, System.currentTimeMillis()));
    }

    public boolean isRetryableError(Map<String, String> map) {
        String str = map.get("data");
        if (str == null) {
            return true;
        }
        try {
            return this.mNotificationParser.parseError(str).isRetryable();
        } catch (JsonSyntaxException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could no parse ably error: ");
            sb.append(str);
            Logger.e(sb.toString());
            return true;
        }
    }

    private void handleControlNotification(IncomingNotification incomingNotification) {
        try {
            ControlNotification parseControl = this.mNotificationParser.parseControl(incomingNotification.getJsonData());
            parseControl.setTimestamp(incomingNotification.getTimestamp());
            this.mNotificationManagerKeeper.handleControlNotification(parseControl);
        } catch (JsonSyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not parse control notification: ");
            sb.append(incomingNotification.getJsonData());
            sb.append(" -> ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected error while processing control notification: ");
            sb2.append(e2.getLocalizedMessage());
            Logger.e(sb2.toString());
        }
    }

    private void handleOccupancyNotification(IncomingNotification incomingNotification) {
        try {
            OccupancyNotification parseOccupancy = this.mNotificationParser.parseOccupancy(incomingNotification.getJsonData());
            parseOccupancy.setChannel(incomingNotification.getChannel());
            parseOccupancy.setTimestamp(incomingNotification.getTimestamp());
            this.mNotificationManagerKeeper.handleOccupancyNotification(parseOccupancy);
        } catch (JsonSyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not parse occupancy notification: ");
            sb.append(incomingNotification.getJsonData());
            sb.append(" -> ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected error while processing occupancy notification: ");
            sb2.append(e2.getLocalizedMessage());
            Logger.e(sb2.toString());
        }
    }

    private void handleError(String str) {
        try {
            StreamingError parseError = this.mNotificationParser.parseError(str);
            StringBuilder sb = new StringBuilder();
            sb.append("Streaming error notification received: ");
            sb.append(parseError.getMessage());
            Logger.w(sb.toString());
            if (parseError.shouldBeIgnored()) {
                Logger.w("Error ignored");
                return;
            }
            this.mTelemetryRuntimeProducer.recordStreamingEvents(new AblyErrorStreamingEvent(parseError.getCode(), System.currentTimeMillis()));
            this.mBroadcasterChannel.pushMessage(new PushStatusEvent(parseError.isRetryable() ? PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR : PushStatusEvent.EventType.PUSH_NON_RETRYABLE_ERROR));
        } catch (JsonSyntaxException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not parse occupancy notification: ");
            sb2.append(str);
            sb2.append(" -> ");
            sb2.append(e.getLocalizedMessage());
            Logger.e(sb2.toString());
        } catch (Exception e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected error while processing occupancy notification: ");
            sb3.append(e2.getLocalizedMessage());
            Logger.e(sb3.toString());
        }
    }
}
