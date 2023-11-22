package io.split.android.client.storage.db;

import io.split.android.client.service.ServiceConstants;
import io.split.android.client.storage.attributes.AttributesStorageContainer;
import io.split.android.client.storage.attributes.AttributesStorageContainerImpl;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.storage.attributes.SqLitePersistentAttributesStorage;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.cipher.SplitCipherFactory;
import io.split.android.client.storage.events.EventsStorage;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.storage.events.SqLitePersistentEventsStorage;
import io.split.android.client.storage.impressions.ImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.storage.impressions.SqLitePersistentImpressionsCountStorage;
import io.split.android.client.storage.impressions.SqLitePersistentImpressionsStorage;
import io.split.android.client.storage.impressions.SqlitePersistentUniqueStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainerImpl;
import io.split.android.client.storage.mysegments.SqLitePersistentMySegmentsStorage;
import io.split.android.client.storage.splits.PersistentSplitsStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.storage.splits.SplitsStorageImpl;
import io.split.android.client.storage.splits.SqLitePersistentSplitsStorage;
import io.split.android.client.telemetry.storage.InMemoryTelemetryStorage;
import io.split.android.client.telemetry.storage.NoOpTelemetryStorage;
import io.split.android.client.telemetry.storage.TelemetryStorage;

/* loaded from: classes6.dex */
public class StorageFactory {
    public static SplitsStorage getSplitsStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new SplitsStorageImpl(getPersistentSplitsStorage(splitRoomDatabase, splitCipher));
    }

    public static SplitsStorage getSplitsStorageForWorker(SplitRoomDatabase splitRoomDatabase, String str, boolean z) {
        return getSplitsStorage(splitRoomDatabase, SplitCipherFactory.create(str, z));
    }

    public static MySegmentsStorageContainer getMySegmentsStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return getMySegmentsStorageContainer(splitRoomDatabase, splitCipher);
    }

    public static MySegmentsStorageContainer getMySegmentsStorageForWorker(SplitRoomDatabase splitRoomDatabase, String str, boolean z) {
        return getMySegmentsStorageContainer(splitRoomDatabase, SplitCipherFactory.create(str, z));
    }

    public static EventsStorage getEventsStorage(PersistentEventsStorage persistentEventsStorage, boolean z) {
        return new EventsStorage(persistentEventsStorage, z);
    }

    public static PersistentSplitsStorage getPersistentSplitsStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new SqLitePersistentSplitsStorage(splitRoomDatabase, splitCipher);
    }

    public static ImpressionsStorage getImpressionsStorage(PersistentImpressionsStorage persistentImpressionsStorage, boolean z) {
        return new ImpressionsStorage(persistentImpressionsStorage, z);
    }

    public static PersistentImpressionsStorage getPersistentImpressionsStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new SqLitePersistentImpressionsStorage(splitRoomDatabase, ServiceConstants.RECORDED_DATA_EXPIRATION_PERIOD, splitCipher);
    }

    public static PersistentImpressionsStorage getPersistentImpressionsStorageForWorker(SplitRoomDatabase splitRoomDatabase, String str, boolean z) {
        return getPersistentImpressionsStorage(splitRoomDatabase, SplitCipherFactory.create(str, z));
    }

    public static PersistentEventsStorage getPersistentEventsStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new SqLitePersistentEventsStorage(splitRoomDatabase, ServiceConstants.RECORDED_DATA_EXPIRATION_PERIOD, splitCipher);
    }

    public static PersistentEventsStorage getPersistentEventsStorageForWorker(SplitRoomDatabase splitRoomDatabase, String str, boolean z) {
        return getPersistentEventsStorage(splitRoomDatabase, SplitCipherFactory.create(str, z));
    }

    public static PersistentImpressionsCountStorage getPersistentImpressionsCountStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new SqLitePersistentImpressionsCountStorage(splitRoomDatabase, ServiceConstants.RECORDED_DATA_EXPIRATION_PERIOD, splitCipher);
    }

    public static AttributesStorageContainer getAttributesStorage() {
        return getAttributesStorageContainerInstance();
    }

    public static PersistentAttributesStorage getPersistentAttributesStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new SqLitePersistentAttributesStorage(splitRoomDatabase.attributesDao(), splitCipher);
    }

    public static PersistentImpressionsUniqueStorage getPersistentImpressionsUniqueStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new SqlitePersistentUniqueStorage(splitRoomDatabase, 864000L, splitCipher);
    }

    public static PersistentImpressionsUniqueStorage getPersistentImpressionsUniqueStorageForWorker(SplitRoomDatabase splitRoomDatabase, String str, boolean z) {
        return getPersistentImpressionsUniqueStorage(splitRoomDatabase, SplitCipherFactory.create(str, z));
    }

    public static TelemetryStorage getTelemetryStorage(boolean z) {
        if (z) {
            return new InMemoryTelemetryStorage();
        }
        return new NoOpTelemetryStorage();
    }

    private static MySegmentsStorageContainer getMySegmentsStorageContainer(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        return new MySegmentsStorageContainerImpl(new SqLitePersistentMySegmentsStorage(splitRoomDatabase, splitCipher));
    }

    private static AttributesStorageContainer getAttributesStorageContainerInstance() {
        return new AttributesStorageContainerImpl();
    }
}
