package id.dana.contract.feeds;

import dagger.internal.Factory;
import id.dana.contract.feeds.UserFeedsContract;
import id.dana.domain.feeds.interactor.DeleteFeeds;
import id.dana.domain.feeds.interactor.GetUserFeeds;
import id.dana.feeds.mapper.FeedsModelMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UserFeedsPresenter_Factory implements Factory<UserFeedsPresenter> {
    private final Provider<GetUserFeeds> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeleteFeeds> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsModelMapper> MyBillsEntityDataFactory;
    private final Provider<UserFeedsContract.View> getAuthRequestContext;

    private UserFeedsPresenter_Factory(Provider<UserFeedsContract.View> provider, Provider<GetUserFeeds> provider2, Provider<DeleteFeeds> provider3, Provider<FeedsModelMapper> provider4) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static UserFeedsPresenter_Factory MyBillsEntityDataFactory(Provider<UserFeedsContract.View> provider, Provider<GetUserFeeds> provider2, Provider<DeleteFeeds> provider3, Provider<FeedsModelMapper> provider4) {
        return new UserFeedsPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserFeedsPresenter(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
