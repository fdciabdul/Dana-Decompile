package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybStartupConfig_Factory implements Factory<GetKybStartupConfig> {
    private final Provider<KybRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetKybStartupConfig_Factory(Provider<KybRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetKybStartupConfig_Factory MyBillsEntityDataFactory(Provider<KybRepository> provider) {
        return new GetKybStartupConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybStartupConfig(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
