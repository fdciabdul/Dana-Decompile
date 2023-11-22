package id.dana.feeds.data.synccontact.source;

import dagger.internal.Factory;
import id.dana.feeds.data.synccontact.source.local.PreferenceFeedsLocalSyncContactEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsLocalSyncEntityDataFactory_Factory implements Factory<FeedsLocalSyncEntityDataFactory> {
    private final Provider<PreferenceFeedsLocalSyncContactEntityData> MyBillsEntityDataFactory;

    private FeedsLocalSyncEntityDataFactory_Factory(Provider<PreferenceFeedsLocalSyncContactEntityData> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static FeedsLocalSyncEntityDataFactory_Factory PlaceComponentResult(Provider<PreferenceFeedsLocalSyncContactEntityData> provider) {
        return new FeedsLocalSyncEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsLocalSyncEntityDataFactory(this.MyBillsEntityDataFactory.get());
    }
}
