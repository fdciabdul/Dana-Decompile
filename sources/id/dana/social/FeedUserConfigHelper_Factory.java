package id.dana.social;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.feeds.domain.activation.interactor.GetHasFetchedUserConfig;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedUserConfigHelper_Factory implements Factory<FeedUserConfigHelper> {
    private final Provider<ObserveInitFeed> BuiltInFictitiousFunctionClassFactory;
    private final Provider<LoginLogoutObserver> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetHasFetchedUserConfig> getAuthRequestContext;

    private FeedUserConfigHelper_Factory(Provider<GetHasFetchedUserConfig> provider, Provider<LoginLogoutObserver> provider2, Provider<ObserveInitFeed> provider3) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static FeedUserConfigHelper_Factory MyBillsEntityDataFactory(Provider<GetHasFetchedUserConfig> provider, Provider<LoginLogoutObserver> provider2, Provider<ObserveInitFeed> provider3) {
        return new FeedUserConfigHelper_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedUserConfigHelper(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
