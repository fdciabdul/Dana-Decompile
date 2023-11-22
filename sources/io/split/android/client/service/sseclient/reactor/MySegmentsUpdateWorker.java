package io.split.android.client.service.sseclient.reactor;

import com.google.common.base.Preconditions;
import io.split.android.client.service.sseclient.notifications.MySegmentChangeNotification;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes6.dex */
public class MySegmentsUpdateWorker extends UpdateWorker {
    private final BlockingQueue<MySegmentChangeNotification> mNotificationsQueue;
    private final MySegmentsSynchronizer mSynchronizer;

    public MySegmentsUpdateWorker(MySegmentsSynchronizer mySegmentsSynchronizer, BlockingQueue<MySegmentChangeNotification> blockingQueue) {
        this.mSynchronizer = (MySegmentsSynchronizer) Preconditions.checkNotNull(mySegmentsSynchronizer);
        this.mNotificationsQueue = (BlockingQueue) Preconditions.checkNotNull(blockingQueue);
    }

    @Override // io.split.android.client.service.sseclient.reactor.UpdateWorker
    protected void onWaitForNotificationLoop() throws InterruptedException {
        try {
            this.mNotificationsQueue.take();
            this.mSynchronizer.forceMySegmentsSync();
            Logger.d("A new notification to update segments has been received. Enqueuing polling task.");
        } catch (InterruptedException e) {
            Logger.d("My segments update worker has been interrupted");
            throw e;
        }
    }
}
