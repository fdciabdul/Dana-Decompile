package id.dana.social.presenter;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck;
import id.dana.feeds.domain.activation.interactor.InitSocialFeed;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.timeline.interactor.GetCachedFeedsForWidget;
import id.dana.feeds.domain.timeline.interactor.GetCachedTimeline;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.social.FeedUserConfigHelper;
import id.dana.social.contract.SocialWidgetContract;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.model.mapper.GroupedFeedMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NewSocialWidgetPresenter_Factory implements Factory<NewSocialWidgetPresenter> {
    private final Provider<FeedMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SocialWidgetContract.View> DatabaseTableConfigUtil;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedUserConfigHelper> MyBillsEntityDataFactory;
    private final Provider<GetFriendsFeedWithInitFeedAndFeatureCheck> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ObserveInitFeed> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<InitSocialFeed> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<GetCachedTimeline> PlaceComponentResult;
    private final Provider<GetCachedFeedsForWidget> getAuthRequestContext;
    private final Provider<GetFeedConfig> getErrorConfigVersion;
    private final Provider<SaveShareFeedConsent> initRecordTimeStamp;
    private final Provider<GetShareFeedConsent> lookAheadTest;
    private final Provider<GetTimeline> moveToNextValue;
    private final Provider<GroupedFeedMapper> scheduleImpl;

    private NewSocialWidgetPresenter_Factory(Provider<Context> provider, Provider<GetTimeline> provider2, Provider<GetFriendsFeedWithInitFeedAndFeatureCheck> provider3, Provider<SaveShareFeedConsent> provider4, Provider<GetShareFeedConsent> provider5, Provider<ObserveInitFeed> provider6, Provider<InitSocialFeed> provider7, Provider<SocialWidgetContract.View> provider8, Provider<FeedMapper> provider9, Provider<GroupedFeedMapper> provider10, Provider<GetFeedConfig> provider11, Provider<GetCachedTimeline> provider12, Provider<FeedUserConfigHelper> provider13, Provider<GetCachedFeedsForWidget> provider14) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.moveToNextValue = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider3;
        this.initRecordTimeStamp = provider4;
        this.lookAheadTest = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider7;
        this.DatabaseTableConfigUtil = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
        this.scheduleImpl = provider10;
        this.getErrorConfigVersion = provider11;
        this.PlaceComponentResult = provider12;
        this.MyBillsEntityDataFactory = provider13;
        this.getAuthRequestContext = provider14;
    }

    public static NewSocialWidgetPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<GetTimeline> provider2, Provider<GetFriendsFeedWithInitFeedAndFeatureCheck> provider3, Provider<SaveShareFeedConsent> provider4, Provider<GetShareFeedConsent> provider5, Provider<ObserveInitFeed> provider6, Provider<InitSocialFeed> provider7, Provider<SocialWidgetContract.View> provider8, Provider<FeedMapper> provider9, Provider<GroupedFeedMapper> provider10, Provider<GetFeedConfig> provider11, Provider<GetCachedTimeline> provider12, Provider<FeedUserConfigHelper> provider13, Provider<GetCachedFeedsForWidget> provider14) {
        return new NewSocialWidgetPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NewSocialWidgetPresenter(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
