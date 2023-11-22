package id.dana.contract.feeds;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.feeds.GlobalFeedsContract;
import id.dana.domain.feeds.interactor.GetGlobalFeeds;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.feeds.mapper.FeedsModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalFeedsPresenter_Factory implements Factory<GlobalFeedsPresenter> {
    private final Provider<FeedsModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetGlobalFeeds> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetDefaultFeedFromConfig> MyBillsEntityDataFactory;
    private final Provider<GlobalFeedsContract.View> PlaceComponentResult;
    private final Provider<SaveNewsWidgetActivitiesIntoPersistence> getAuthRequestContext;

    private GlobalFeedsPresenter_Factory(Provider<GlobalFeedsContract.View> provider, Provider<GetGlobalFeeds> provider2, Provider<FeedsModelMapper> provider3, Provider<GetDefaultFeedFromConfig> provider4, Provider<SaveNewsWidgetActivitiesIntoPersistence> provider5) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static GlobalFeedsPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalFeedsContract.View> provider, Provider<GetGlobalFeeds> provider2, Provider<FeedsModelMapper> provider3, Provider<GetDefaultFeedFromConfig> provider4, Provider<SaveNewsWidgetActivitiesIntoPersistence> provider5) {
        return new GlobalFeedsPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalFeedsPresenter(this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
