package id.dana.danapoly.data.dailycheck.repository;

import dagger.internal.Factory;
import id.dana.danapoly.data.dailycheck.repository.source.DanapolyCheckInDataFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyCheckInEntityRepository_Factory implements Factory<DanapolyCheckInEntityRepository> {
    private final Provider<DanapolyCheckInDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    private DanapolyCheckInEntityRepository_Factory(Provider<DanapolyCheckInDataFactory> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DanapolyCheckInEntityRepository_Factory MyBillsEntityDataFactory(Provider<DanapolyCheckInDataFactory> provider) {
        return new DanapolyCheckInEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyCheckInEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
