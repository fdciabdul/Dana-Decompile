package id.dana.data.danaprotection.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.danaprotection.repository.source.DanaProtectionEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaProtectionInfoEntityRepository_Factory implements Factory<DanaProtectionInfoEntityRepository> {
    private final Provider<DanaProtectionEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AccountEntityRepository> MyBillsEntityDataFactory;

    private DanaProtectionInfoEntityRepository_Factory(Provider<DanaProtectionEntityDataFactory> provider, Provider<AccountEntityRepository> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static DanaProtectionInfoEntityRepository_Factory PlaceComponentResult(Provider<DanaProtectionEntityDataFactory> provider, Provider<AccountEntityRepository> provider2) {
        return new DanaProtectionInfoEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionInfoEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
