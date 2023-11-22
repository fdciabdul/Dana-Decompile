package io.split.android.client.service.sseclient.notifications.mysegments;

import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.sseclient.notifications.MySegmentChangeNotification;
import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes6.dex */
public class MySegmentsNotificationProcessorConfiguration {
    private final BigInteger mHashedUserKey;
    private final BlockingQueue<MySegmentChangeNotification> mMySegmentUpdateNotificationsQueue;
    private final MySegmentsTaskFactory mMySegmentsTaskFactory;

    public MySegmentsNotificationProcessorConfiguration(MySegmentsTaskFactory mySegmentsTaskFactory, BlockingQueue<MySegmentChangeNotification> blockingQueue, BigInteger bigInteger) {
        this.mMySegmentsTaskFactory = mySegmentsTaskFactory;
        this.mMySegmentUpdateNotificationsQueue = blockingQueue;
        this.mHashedUserKey = bigInteger;
    }

    public MySegmentsTaskFactory getMySegmentsTaskFactory() {
        return this.mMySegmentsTaskFactory;
    }

    public BlockingQueue<MySegmentChangeNotification> getMySegmentUpdateNotificationsQueue() {
        return this.mMySegmentUpdateNotificationsQueue;
    }

    public BigInteger getHashedUserKey() {
        return this.mHashedUserKey;
    }
}
