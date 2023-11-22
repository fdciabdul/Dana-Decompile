package io.split.android.client.events;

import io.split.android.client.events.executors.SplitEventExecutorResources;

/* loaded from: classes6.dex */
public interface ListenableEventsManager {
    boolean eventAlreadyTriggered(SplitEvent splitEvent);

    SplitEventExecutorResources getExecutorResources();

    void register(SplitEvent splitEvent, SplitEventTask splitEventTask);
}
