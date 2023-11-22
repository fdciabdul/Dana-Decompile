package id.dana.danapoly.domain.config.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPlayerInfo_Factory implements Factory<GetPlayerInfo> {
    private final Provider<DanapolyConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetPlayerInfo_Factory(Provider<DanapolyConfigRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetPlayerInfo_Factory PlaceComponentResult(Provider<DanapolyConfigRepository> provider) {
        return new GetPlayerInfo_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPlayerInfo(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
