package io.split.android.client;

import io.split.android.client.api.Key;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;

/* loaded from: classes6.dex */
public interface SplitClientFactory {
    SplitClient getClient(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager splitEventsManager, boolean z);
}
