package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.NotificationProcessor;
import io.split.android.client.service.sseclient.notifications.SplitsChangeNotification;
import io.split.android.client.service.synchronizer.SyncGuardian;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes6.dex */
public class StreamingComponents {
    private NotificationParser mNotificationParser;
    private NotificationProcessor mNotificationProcessor;
    private PushManagerEventBroadcaster mPushManagerEventBroadcaster;
    private PushNotificationManager mPushNotificationManager;
    private BlockingQueue<SplitsChangeNotification> mSplitsUpdateNotificationQueue;
    private SseAuthenticator mSseAuthenticator;
    private SyncGuardian mSyncGuardian;

    public StreamingComponents() {
    }

    public StreamingComponents(PushNotificationManager pushNotificationManager, BlockingQueue<SplitsChangeNotification> blockingQueue, NotificationParser notificationParser, NotificationProcessor notificationProcessor, SseAuthenticator sseAuthenticator, PushManagerEventBroadcaster pushManagerEventBroadcaster, SyncGuardian syncGuardian) {
        this.mPushNotificationManager = pushNotificationManager;
        this.mSplitsUpdateNotificationQueue = blockingQueue;
        this.mNotificationParser = notificationParser;
        this.mNotificationProcessor = notificationProcessor;
        this.mSseAuthenticator = sseAuthenticator;
        this.mPushManagerEventBroadcaster = pushManagerEventBroadcaster;
        this.mSyncGuardian = syncGuardian;
    }

    public PushNotificationManager getPushNotificationManager() {
        return this.mPushNotificationManager;
    }

    public BlockingQueue<SplitsChangeNotification> getSplitsUpdateNotificationQueue() {
        return this.mSplitsUpdateNotificationQueue;
    }

    public PushManagerEventBroadcaster getPushManagerEventBroadcaster() {
        return this.mPushManagerEventBroadcaster;
    }

    public NotificationParser getNotificationParser() {
        return this.mNotificationParser;
    }

    public NotificationProcessor getNotificationProcessor() {
        return this.mNotificationProcessor;
    }

    public SseAuthenticator getSseAuthenticator() {
        return this.mSseAuthenticator;
    }

    public SyncGuardian getSyncGuardian() {
        return this.mSyncGuardian;
    }
}
