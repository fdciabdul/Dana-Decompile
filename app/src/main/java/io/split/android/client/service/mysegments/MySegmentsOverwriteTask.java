package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.synchronizer.MySegmentsChangeChecker;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class MySegmentsOverwriteTask implements SplitTask {
    private final SplitEventsManager mEventsManager;
    private final List<String> mMySegments;
    private MySegmentsChangeChecker mMySegmentsChangeChecker = new MySegmentsChangeChecker();
    private final MySegmentsStorage mMySegmentsStorage;

    public MySegmentsOverwriteTask(MySegmentsStorage mySegmentsStorage, List<String> list, SplitEventsManager splitEventsManager) {
        this.mMySegmentsStorage = (MySegmentsStorage) Preconditions.checkNotNull(mySegmentsStorage);
        this.mMySegments = list;
        this.mEventsManager = splitEventsManager;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            if (this.mMySegments == null) {
                logError("My segment list could not be null.");
                return SplitTaskExecutionInfo.error(SplitTaskType.MY_SEGMENTS_OVERWRITE);
            }
            if (this.mMySegmentsChangeChecker.mySegmentsHaveChanged(new ArrayList(this.mMySegmentsStorage.getAll()), this.mMySegments)) {
                this.mMySegmentsStorage.set(this.mMySegments);
                this.mEventsManager.notifyInternalEvent(SplitInternalEvent.MY_SEGMENTS_UPDATED);
            }
            Logger.d("My Segments have been overwritten");
            return SplitTaskExecutionInfo.success(SplitTaskType.MY_SEGMENTS_OVERWRITE);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown error while overwriting my segments: ");
            sb.append(e.getLocalizedMessage());
            logError(sb.toString());
            return SplitTaskExecutionInfo.error(SplitTaskType.MY_SEGMENTS_OVERWRITE);
        }
    }

    private void logError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while executing my segments overwrite task: ");
        sb.append(str);
        Logger.e(sb.toString());
    }

    public void setChangesChecker(MySegmentsChangeChecker mySegmentsChangeChecker) {
        this.mMySegmentsChangeChecker = mySegmentsChangeChecker;
    }
}
