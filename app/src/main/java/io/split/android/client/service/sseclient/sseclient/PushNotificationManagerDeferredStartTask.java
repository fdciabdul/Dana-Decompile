package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;

/* loaded from: classes6.dex */
public class PushNotificationManagerDeferredStartTask implements SplitTask {
    private final PushNotificationManager mPushNotificationManager;

    public PushNotificationManagerDeferredStartTask(PushNotificationManager pushNotificationManager) {
        this.mPushNotificationManager = pushNotificationManager;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            this.mPushNotificationManager.start();
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception unused) {
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }
}
