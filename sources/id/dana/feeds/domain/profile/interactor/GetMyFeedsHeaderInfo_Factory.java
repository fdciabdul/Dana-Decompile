package id.dana.feeds.domain.profile.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.user.repository.UserRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetMyFeedsHeaderInfo_Factory implements Factory<GetMyFeedsHeaderInfo> {
    private final Provider<FeedsShareRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserRepository> getAuthRequestContext;

    private GetMyFeedsHeaderInfo_Factory(Provider<UserRepository> provider, Provider<AccountRepository> provider2, Provider<FeedsShareRepository> provider3) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static GetMyFeedsHeaderInfo_Factory getAuthRequestContext(Provider<UserRepository> provider, Provider<AccountRepository> provider2, Provider<FeedsShareRepository> provider3) {
        return new GetMyFeedsHeaderInfo_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetMyFeedsHeaderInfo(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
