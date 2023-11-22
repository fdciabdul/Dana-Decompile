package io.split.android.client.events;

import io.split.android.client.api.Key;

/* loaded from: classes6.dex */
public interface EventsManagerRegistry {
    void registerEventsManager(Key key, ISplitEventsManager iSplitEventsManager);

    void unregisterEventsManager(Key key);
}
