package io.split.android.client.service.synchronizer;

import com.google.common.base.Preconditions;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;

/* loaded from: classes6.dex */
public class LoadLocalDataListener implements SplitTaskExecutionListener {
    private final SplitInternalEvent mEventToFire;
    private final ISplitEventsManager mSplitEventsManager;

    public LoadLocalDataListener(ISplitEventsManager iSplitEventsManager, SplitInternalEvent splitInternalEvent) {
        this.mSplitEventsManager = (ISplitEventsManager) Preconditions.checkNotNull(iSplitEventsManager);
        this.mEventToFire = (SplitInternalEvent) Preconditions.checkNotNull(splitInternalEvent);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
        if (splitTaskExecutionInfo.getStatus().equals(SplitTaskExecutionStatus.SUCCESS)) {
            this.mSplitEventsManager.notifyInternalEvent(this.mEventToFire);
        }
    }
}
