package io.split.android.client.service.events;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.split.android.client.dtos.Event;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class EventsRecorderTask implements SplitTask {
    public static final int FAILING_CHUNK_SIZE = 20;
    private final EventsRecorderTaskConfig mConfig;
    private final HttpRecorder<List<Event>> mHttpRecorder;
    private final PersistentEventsStorage mPersistentEventsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public EventsRecorderTask(HttpRecorder<List<Event>> httpRecorder, PersistentEventsStorage persistentEventsStorage, EventsRecorderTaskConfig eventsRecorderTaskConfig, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mHttpRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder);
        this.mPersistentEventsStorage = (PersistentEventsStorage) Preconditions.checkNotNull(persistentEventsStorage);
        this.mConfig = (EventsRecorderTaskConfig) Preconditions.checkNotNull(eventsRecorderTaskConfig);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        List<Event> pop;
        long j;
        long j2;
        long currentTimeMillis;
        SplitTaskExecutionStatus splitTaskExecutionStatus = SplitTaskExecutionStatus.SUCCESS;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        long j3 = 0;
        do {
            pop = this.mPersistentEventsStorage.pop(this.mConfig.getEventsPerPush());
            if (pop.size() > 0) {
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    Logger.d("Posting %d Split events", Integer.valueOf(pop.size()));
                    this.mHttpRecorder.execute(pop);
                    currentTimeMillis = System.currentTimeMillis();
                    j2 = currentTimeMillis - currentTimeMillis2;
                } catch (HttpRecorderException e) {
                    e = e;
                    j2 = 0;
                } catch (Throwable th) {
                    th = th;
                    j = 0;
                }
                try {
                    try {
                        this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.EVENTS, currentTimeMillis);
                        this.mPersistentEventsStorage.delete(pop);
                        Logger.d("%d split events sent", Integer.valueOf(pop.size()));
                        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.EVENTS, j2);
                    } catch (Throwable th2) {
                        th = th2;
                        j = j2;
                        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.EVENTS, j);
                        throw th;
                    }
                } catch (HttpRecorderException e2) {
                    e = e2;
                    SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.ERROR;
                    i += this.mConfig.getEventsPerPush();
                    j3 += sumEventBytes(pop);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Event recorder task: Some events couldn't be sentSaving to send them in a new iteration: ");
                    sb.append(e.getLocalizedMessage());
                    Logger.e(sb.toString());
                    arrayList.addAll(pop);
                    this.mTelemetryRuntimeProducer.recordSyncError(OperationType.EVENTS, e.getHttpStatus());
                    this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.EVENTS, j2);
                    splitTaskExecutionStatus = splitTaskExecutionStatus2;
                }
            }
        } while (pop.size() == this.mConfig.getEventsPerPush());
        Iterator it = Lists.partition(arrayList, 20).iterator();
        while (it.hasNext()) {
            this.mPersistentEventsStorage.setActive((List) it.next());
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            HashMap hashMap = new HashMap();
            hashMap.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(i));
            hashMap.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(j3));
            return SplitTaskExecutionInfo.error(SplitTaskType.EVENTS_RECORDER, hashMap);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.EVENTS_RECORDER);
    }

    private long sumEventBytes(List<Event> list) {
        Iterator<Event> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().getSizeInBytes();
        }
        return j;
    }
}
