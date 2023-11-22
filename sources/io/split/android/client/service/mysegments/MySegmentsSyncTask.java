package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.MySegment;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherException;
import io.split.android.client.service.synchronizer.MySegmentsChangeChecker;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class MySegmentsSyncTask implements SplitTask {
    private final boolean mAvoidCache;
    private final SplitEventsManager mEventsManager;
    private final MySegmentsChangeChecker mMySegmentsChangeChecker = new MySegmentsChangeChecker();
    private final HttpFetcher<List<MySegment>> mMySegmentsFetcher;
    private final MySegmentsStorage mMySegmentsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public MySegmentsSyncTask(HttpFetcher<List<MySegment>> httpFetcher, MySegmentsStorage mySegmentsStorage, boolean z, SplitEventsManager splitEventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mMySegmentsFetcher = (HttpFetcher) Preconditions.checkNotNull(httpFetcher);
        this.mMySegmentsStorage = (MySegmentsStorage) Preconditions.checkNotNull(mySegmentsStorage);
        this.mAvoidCache = z;
        this.mEventsManager = splitEventsManager;
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        Throwable th;
        long j;
        SplitTaskExecutionInfo error;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = 0;
        try {
            try {
                List<MySegment> execute = this.mMySegmentsFetcher.execute(new HashMap(), getHeaders());
                long currentTimeMillis2 = System.currentTimeMillis();
                j = currentTimeMillis2 - currentTimeMillis;
                try {
                    ArrayList arrayList = new ArrayList(this.mMySegmentsStorage.getAll());
                    List<String> nameList = getNameList(execute);
                    this.mMySegmentsStorage.set(nameList);
                    this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.MY_SEGMENT, currentTimeMillis2);
                    fireMySegmentsUpdatedIfNeeded(arrayList, nameList);
                    this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.MY_SEGMENT, j);
                    Logger.d("My Segments have been updated");
                    return SplitTaskExecutionInfo.success(SplitTaskType.MY_SEGMENTS_SYNC);
                } catch (HttpFetcherException e) {
                    e = e;
                    j2 = j;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Network error while retrieving my segments: ");
                    sb.append(e.getLocalizedMessage());
                    logError(sb.toString());
                    this.mTelemetryRuntimeProducer.recordSyncError(OperationType.MY_SEGMENT, e.getHttpStatus());
                    error = SplitTaskExecutionInfo.error(SplitTaskType.MY_SEGMENTS_SYNC);
                    this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.MY_SEGMENT, j2);
                    return error;
                } catch (Exception e2) {
                    e = e2;
                    j2 = j;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown error while retrieving my segments: ");
                    sb2.append(e.getLocalizedMessage());
                    logError(sb2.toString());
                    error = SplitTaskExecutionInfo.error(SplitTaskType.MY_SEGMENTS_SYNC);
                    this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.MY_SEGMENT, j2);
                    return error;
                } catch (Throwable th2) {
                    th = th2;
                    long j3 = j;
                    th = th;
                    j2 = j3;
                    this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.MY_SEGMENT, j2);
                    throw th;
                }
            } catch (HttpFetcherException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
                this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.MY_SEGMENT, j2);
                throw th;
            }
        } catch (Throwable th4) {
            long j4 = j2;
            th = th4;
            j = j4;
        }
    }

    private void logError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while executing my segments sync task: ");
        sb.append(str);
        Logger.e(sb.toString());
    }

    private List<String> getNameList(List<MySegment> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<MySegment> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().name);
        }
        return arrayList;
    }

    private Map<String, String> getHeaders() {
        if (this.mAvoidCache) {
            return SplitHttpHeadersBuilder.noCacheHeaders();
        }
        return null;
    }

    private void fireMySegmentsUpdatedIfNeeded(List<String> list, List<String> list2) {
        SplitEventsManager splitEventsManager = this.mEventsManager;
        if (splitEventsManager == null) {
            return;
        }
        splitEventsManager.notifyInternalEvent(getInternalEvent(list, list2));
    }

    private SplitInternalEvent getInternalEvent(List<String> list, List<String> list2) {
        if (this.mMySegmentsChangeChecker.mySegmentsHaveChanged(list, list2)) {
            return SplitInternalEvent.MY_SEGMENTS_UPDATED;
        }
        return SplitInternalEvent.MY_SEGMENTS_FETCHED;
    }
}
