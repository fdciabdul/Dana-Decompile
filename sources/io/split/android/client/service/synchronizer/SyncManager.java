package io.split.android.client.service.synchronizer;

import io.split.android.client.dtos.Event;
import io.split.android.client.impressions.Impression;
import io.split.android.client.lifecycle.SplitLifecycleAware;
import io.split.android.client.shared.UserConsent;

/* loaded from: classes6.dex */
public interface SyncManager extends SplitLifecycleAware {
    void flush();

    void pushEvent(Event event);

    void pushImpression(Impression impression);

    void setupUserConsent(UserConsent userConsent);

    void start();

    void stop();
}
