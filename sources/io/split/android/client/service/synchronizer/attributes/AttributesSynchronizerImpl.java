package io.split.android.client.service.synchronizer.attributes;

import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.attributes.AttributeTaskFactory;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.synchronizer.LoadLocalDataListener;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;

/* loaded from: classes6.dex */
public class AttributesSynchronizerImpl implements AttributesSynchronizer {
    private final AttributeTaskFactory mAttributeTaskFactory;
    private final LoadLocalDataListener mLoadLocalAttributesListener;
    private final PersistentAttributesStorage mPersistentAttributeStorage;
    private final SplitTaskExecutor mTaskExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributesSynchronizerImpl(SplitTaskExecutor splitTaskExecutor, SplitEventsManager splitEventsManager, AttributeTaskFactory attributeTaskFactory, PersistentAttributesStorage persistentAttributesStorage) {
        this.mTaskExecutor = splitTaskExecutor;
        this.mAttributeTaskFactory = attributeTaskFactory;
        this.mPersistentAttributeStorage = persistentAttributesStorage;
        this.mLoadLocalAttributesListener = new LoadLocalDataListener(splitEventsManager, SplitInternalEvent.ATTRIBUTES_LOADED_FROM_STORAGE);
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizer
    public void loadAttributesFromCache() {
        this.mTaskExecutor.submit(this.mAttributeTaskFactory.createLoadAttributesTask(this.mPersistentAttributeStorage), this.mLoadLocalAttributesListener);
    }
}
