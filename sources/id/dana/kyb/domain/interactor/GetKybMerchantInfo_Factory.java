package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybMerchantInfo_Factory implements Factory<GetKybMerchantInfo> {
    private final Provider<KybRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UserRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetKybMerchantInfo_Factory(Provider<KybRepository> provider, Provider<UserRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static GetKybMerchantInfo_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<KybRepository> provider, Provider<UserRepository> provider2) {
        return new GetKybMerchantInfo_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybMerchantInfo(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
