package io.split.android.client.shared;

import io.split.android.client.api.Key;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;

/* loaded from: classes6.dex */
public interface ClientComponentsRegister {
    void registerComponents(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager splitEventsManager);

    void unregisterComponentsForKey(Key key);
}
