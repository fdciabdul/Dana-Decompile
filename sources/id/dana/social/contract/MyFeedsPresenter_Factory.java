package id.dana.social.contract;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.CheckFeedHighlight;
import id.dana.domain.notificationcenter.interactor.MarkNotificationAsRead;
import id.dana.feeds.domain.notification.interactor.GetGlobalNotification;
import id.dana.feeds.domain.timeline.interactor.GetMyFeeds;
import id.dana.kyb.domain.interactor.IsKybNativeEnabled;
import id.dana.social.contract.MyFeedsContract;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.utils.FeedsContentAction;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyFeedsPresenter_Factory implements Factory<MyFeedsPresenter> {
    private final Provider<FeedsContentAction> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetGlobalNotification> MyBillsEntityDataFactory;
    private final Provider<IsKybNativeEnabled> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<CheckFeedHighlight> PlaceComponentResult;
    private final Provider<GetMyFeeds> getAuthRequestContext;
    private final Provider<MyFeedsContract.View> getErrorConfigVersion;
    private final Provider<MarkNotificationAsRead> scheduleImpl;

    private MyFeedsPresenter_Factory(Provider<MyFeedsContract.View> provider, Provider<GetMyFeeds> provider2, Provider<FeedMapper> provider3, Provider<FeedsContentAction> provider4, Provider<MarkNotificationAsRead> provider5, Provider<GetGlobalNotification> provider6, Provider<CheckFeedHighlight> provider7, Provider<IsKybNativeEnabled> provider8) {
        this.getErrorConfigVersion = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.scheduleImpl = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.PlaceComponentResult = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider8;
    }

    public static MyFeedsPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<MyFeedsContract.View> provider, Provider<GetMyFeeds> provider2, Provider<FeedMapper> provider3, Provider<FeedsContentAction> provider4, Provider<MarkNotificationAsRead> provider5, Provider<GetGlobalNotification> provider6, Provider<CheckFeedHighlight> provider7, Provider<IsKybNativeEnabled> provider8) {
        return new MyFeedsPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyFeedsPresenter(this.getErrorConfigVersion.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.scheduleImpl.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
    }
}
