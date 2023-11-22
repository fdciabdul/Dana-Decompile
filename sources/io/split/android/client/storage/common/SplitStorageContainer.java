package io.split.android.client.storage.common;

import com.google.common.base.Preconditions;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.AttributesStorageContainer;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.storage.events.EventsStorage;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.storage.impressions.ImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.splits.PersistentSplitsStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorage;

/* loaded from: classes6.dex */
public class SplitStorageContainer {
    private final AttributesStorageContainer mAttributesStorageContainer;
    private final EventsStorage mEventsStorage;
    private final ImpressionsStorage mImpressionsStorage;
    private final MySegmentsStorageContainer mMySegmentsStorageContainer;
    private final PersistentAttributesStorage mPersistentAttributesStorage;
    private final PersistentEventsStorage mPersistentEventsStorage;
    private final PersistentImpressionsCountStorage mPersistentImpressionsCountStorage;
    private final PersistentImpressionsStorage mPersistentImpressionsStorage;
    private final PersistentImpressionsUniqueStorage mPersistentImpressionsUniqueStorage;
    private final PersistentSplitsStorage mPersistentSplitsStorage;
    private final SplitsStorage mSplitStorage;
    private final TelemetryStorage mTelemetryStorage;

    public SplitStorageContainer(SplitsStorage splitsStorage, MySegmentsStorageContainer mySegmentsStorageContainer, PersistentSplitsStorage persistentSplitsStorage, EventsStorage eventsStorage, PersistentEventsStorage persistentEventsStorage, ImpressionsStorage impressionsStorage, PersistentImpressionsStorage persistentImpressionsStorage, PersistentImpressionsCountStorage persistentImpressionsCountStorage, PersistentImpressionsUniqueStorage persistentImpressionsUniqueStorage, AttributesStorageContainer attributesStorageContainer, PersistentAttributesStorage persistentAttributesStorage, TelemetryStorage telemetryStorage) {
        this.mSplitStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mMySegmentsStorageContainer = (MySegmentsStorageContainer) Preconditions.checkNotNull(mySegmentsStorageContainer);
        this.mPersistentSplitsStorage = (PersistentSplitsStorage) Preconditions.checkNotNull(persistentSplitsStorage);
        this.mEventsStorage = (EventsStorage) Preconditions.checkNotNull(eventsStorage);
        this.mPersistentEventsStorage = (PersistentEventsStorage) Preconditions.checkNotNull(persistentEventsStorage);
        this.mImpressionsStorage = (ImpressionsStorage) Preconditions.checkNotNull(impressionsStorage);
        this.mPersistentImpressionsStorage = (PersistentImpressionsStorage) Preconditions.checkNotNull(persistentImpressionsStorage);
        this.mPersistentImpressionsCountStorage = (PersistentImpressionsCountStorage) Preconditions.checkNotNull(persistentImpressionsCountStorage);
        this.mAttributesStorageContainer = (AttributesStorageContainer) Preconditions.checkNotNull(attributesStorageContainer);
        this.mPersistentAttributesStorage = (PersistentAttributesStorage) Preconditions.checkNotNull(persistentAttributesStorage);
        this.mTelemetryStorage = (TelemetryStorage) Preconditions.checkNotNull(telemetryStorage);
        this.mPersistentImpressionsUniqueStorage = (PersistentImpressionsUniqueStorage) Preconditions.checkNotNull(persistentImpressionsUniqueStorage);
    }

    public SplitsStorage getSplitsStorage() {
        return this.mSplitStorage;
    }

    public MySegmentsStorageContainer getMySegmentsStorageContainer() {
        return this.mMySegmentsStorageContainer;
    }

    public MySegmentsStorage getMySegmentsStorage(String str) {
        return this.mMySegmentsStorageContainer.getStorageForKey(str);
    }

    public PersistentSplitsStorage getPersistentSplitsStorage() {
        return this.mPersistentSplitsStorage;
    }

    public EventsStorage getEventsStorage() {
        return this.mEventsStorage;
    }

    public PersistentEventsStorage getPersistentEventsStorage() {
        return this.mPersistentEventsStorage;
    }

    public ImpressionsStorage getImpressionsStorage() {
        return this.mImpressionsStorage;
    }

    public PersistentImpressionsStorage getPersistentImpressionsStorage() {
        return this.mPersistentImpressionsStorage;
    }

    public PersistentImpressionsCountStorage getImpressionsCountStorage() {
        return this.mPersistentImpressionsCountStorage;
    }

    public AttributesStorage getAttributesStorage(String str) {
        return this.mAttributesStorageContainer.getStorageForKey(str);
    }

    public AttributesStorageContainer getAttributesStorageContainer() {
        return this.mAttributesStorageContainer;
    }

    public PersistentAttributesStorage getPersistentAttributesStorage() {
        return this.mPersistentAttributesStorage;
    }

    public TelemetryStorage getTelemetryStorage() {
        return this.mTelemetryStorage;
    }

    public PersistentImpressionsUniqueStorage getPersistentImpressionsUniqueStorage() {
        return this.mPersistentImpressionsUniqueStorage;
    }
}
