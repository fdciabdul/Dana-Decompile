package io.split.android.client.validators;

import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.events.ListenableEventsManager;

/* loaded from: classes6.dex */
public interface TreatmentManagerFactory {
    TreatmentManager getTreatmentManager(Key key, ListenableEventsManager listenableEventsManager, AttributesManager attributesManager);
}
