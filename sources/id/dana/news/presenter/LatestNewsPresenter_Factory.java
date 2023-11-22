package id.dana.news.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.feeds.interactor.GetGlobalFeeds;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.feeds.mapper.FeedsModelMapper;
import id.dana.news.LatestNewsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LatestNewsPresenter_Factory implements Factory<LatestNewsPresenter> {
    private final Provider<LatestNewsContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveNewsWidgetActivitiesIntoPersistence> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetGlobalFeeds> MyBillsEntityDataFactory;
    private final Provider<GetDefaultFeedFromConfig> PlaceComponentResult;
    private final Provider<FeedsModelMapper> getAuthRequestContext;

    private LatestNewsPresenter_Factory(Provider<LatestNewsContract.View> provider, Provider<GetGlobalFeeds> provider2, Provider<FeedsModelMapper> provider3, Provider<GetDefaultFeedFromConfig> provider4, Provider<SaveNewsWidgetActivitiesIntoPersistence> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
    }

    public static LatestNewsPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<LatestNewsContract.View> provider, Provider<GetGlobalFeeds> provider2, Provider<FeedsModelMapper> provider3, Provider<GetDefaultFeedFromConfig> provider4, Provider<SaveNewsWidgetActivitiesIntoPersistence> provider5) {
        return new LatestNewsPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LatestNewsPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
