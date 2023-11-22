package io.split.android.client.service.synchronizer.attributes;

import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.attributes.AttributeTaskFactory;

/* loaded from: classes6.dex */
public interface AttributesSynchronizerFactory {
    AttributesSynchronizer getSynchronizer(AttributeTaskFactory attributeTaskFactory, SplitEventsManager splitEventsManager);
}
