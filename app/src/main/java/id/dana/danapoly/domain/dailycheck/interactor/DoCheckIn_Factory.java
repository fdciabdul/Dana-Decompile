package id.dana.danapoly.domain.dailycheck.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.dailycheck.DanapolyCheckInRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DoCheckIn_Factory implements Factory<DoCheckIn> {
    private final Provider<DanapolyCheckInRepository> PlaceComponentResult;

    private DoCheckIn_Factory(Provider<DanapolyCheckInRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static DoCheckIn_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<DanapolyCheckInRepository> provider) {
        return new DoCheckIn_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DoCheckIn(this.PlaceComponentResult.get());
    }
}
