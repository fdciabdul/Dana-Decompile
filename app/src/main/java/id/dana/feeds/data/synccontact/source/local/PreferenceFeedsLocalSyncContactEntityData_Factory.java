package id.dana.feeds.data.synccontact.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceFeedsLocalSyncContactEntityData_Factory implements Factory<PreferenceFeedsLocalSyncContactEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Serializer> MyBillsEntityDataFactory;

    private PreferenceFeedsLocalSyncContactEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static PreferenceFeedsLocalSyncContactEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PreferenceFeedsLocalSyncContactEntityData_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreferenceFeedsLocalSyncContactEntityData(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
