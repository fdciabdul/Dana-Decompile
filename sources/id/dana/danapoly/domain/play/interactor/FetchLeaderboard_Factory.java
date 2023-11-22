package id.dana.danapoly.domain.play.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import id.dana.danapoly.domain.play.DanapolyPlayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FetchLeaderboard_Factory implements Factory<FetchLeaderboard> {
    private final Provider<DanapolyPlayRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DanapolyConfigRepository> MyBillsEntityDataFactory;

    private FetchLeaderboard_Factory(Provider<DanapolyConfigRepository> provider, Provider<DanapolyPlayRepository> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static FetchLeaderboard_Factory MyBillsEntityDataFactory(Provider<DanapolyConfigRepository> provider, Provider<DanapolyPlayRepository> provider2) {
        return new FetchLeaderboard_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FetchLeaderboard(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
