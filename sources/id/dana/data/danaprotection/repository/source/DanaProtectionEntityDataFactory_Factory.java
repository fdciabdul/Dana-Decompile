package id.dana.data.danaprotection.repository.source;

import dagger.internal.Factory;
import id.dana.data.danaprotection.repository.source.local.LocalDanaProtectionInfoEntityData;
import id.dana.data.danaprotection.repository.source.network.NetworkDanaProtectionInfoEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaProtectionEntityDataFactory_Factory implements Factory<DanaProtectionEntityDataFactory> {
    private final Provider<LocalDanaProtectionInfoEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NetworkDanaProtectionInfoEntityData> getAuthRequestContext;

    private DanaProtectionEntityDataFactory_Factory(Provider<NetworkDanaProtectionInfoEntityData> provider, Provider<LocalDanaProtectionInfoEntityData> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static DanaProtectionEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkDanaProtectionInfoEntityData> provider, Provider<LocalDanaProtectionInfoEntityData> provider2) {
        return new DanaProtectionEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionEntityDataFactory(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
