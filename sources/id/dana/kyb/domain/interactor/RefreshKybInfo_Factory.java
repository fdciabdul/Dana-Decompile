package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RefreshKybInfo_Factory implements Factory<RefreshKybInfo> {
    private final Provider<GetKybTransactionHistory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<KybRepository> getAuthRequestContext;

    private RefreshKybInfo_Factory(Provider<KybRepository> provider, Provider<GetKybTransactionHistory> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static RefreshKybInfo_Factory PlaceComponentResult(Provider<KybRepository> provider, Provider<GetKybTransactionHistory> provider2) {
        return new RefreshKybInfo_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RefreshKybInfo(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
