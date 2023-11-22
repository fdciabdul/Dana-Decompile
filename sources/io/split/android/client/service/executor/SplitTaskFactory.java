package io.split.android.client.service.executor;

import io.split.android.client.dtos.Split;
import io.split.android.client.service.CleanUpDatabaseTask;
import io.split.android.client.service.events.EventsRecorderTask;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.splits.FilterSplitsInCacheTask;
import io.split.android.client.service.splits.LoadSplitsTask;
import io.split.android.client.service.splits.SplitInPlaceUpdateTask;
import io.split.android.client.service.splits.SplitKillTask;
import io.split.android.client.service.splits.SplitsSyncTask;
import io.split.android.client.service.splits.SplitsUpdateTask;
import io.split.android.client.service.telemetry.TelemetryTaskFactory;

/* loaded from: classes6.dex */
public interface SplitTaskFactory extends TelemetryTaskFactory, ImpressionsTaskFactory {
    CleanUpDatabaseTask createCleanUpDatabaseTask(long j);

    EventsRecorderTask createEventsRecorderTask();

    FilterSplitsInCacheTask createFilterSplitsInCacheTask();

    LoadSplitsTask createLoadSplitsTask();

    SplitKillTask createSplitKillTask(Split split);

    SplitsSyncTask createSplitsSyncTask(boolean z);

    SplitInPlaceUpdateTask createSplitsUpdateTask(Split split, long j);

    SplitsUpdateTask createSplitsUpdateTask(long j);
}
