package id.dana.social.contract.friendsfeeds;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.feeds.domain.activation.interactor.GetCachedInitAndFeedStatus;
import id.dana.feeds.domain.activation.interactor.InitSocialFeed;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.notification.interactor.FetchFeedNotificationCount;
import id.dana.feeds.domain.profile.interactor.GetMyFeedsHeaderInfo;
import id.dana.feeds.domain.share.interactor.CheckPendingShareFeedDialog;
import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import id.dana.feeds.domain.share.interactor.DeleteFeedActivity;
import id.dana.feeds.domain.share.interactor.DeleteLastShareFeedRequest;
import id.dana.feeds.domain.share.interactor.FetchShareableActivities;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SkipShareableActivity;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.feeds.domain.timeline.interactor.GetTimelineWithTopFriends;
import id.dana.social.FeedUserConfigHelper;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.model.mapper.FeedModelMapper;
import id.dana.social.model.mapper.GroupedFeedMapper;
import id.dana.social.utils.FeedsContentAction;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FriendsFeedsPresenter_Factory implements Factory<FriendsFeedsPresenter> {
    private final Provider<FeedMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetShareFeedConsent> DatabaseTableConfigUtil;
    private final Provider<SkipShareableActivity> FragmentBottomSheetPaymentSettingBinding;
    private final Provider<GetMyFeedsHeaderInfo> GetContactSyncConfig;
    private final Provider<CreateFeedActivity> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DeleteFeedActivity> MyBillsEntityDataFactory;
    private final Provider<FetchFeedNotificationCount> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ObserveInitFeed> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetFeedConfig> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<SaveShareFeedConsent> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Provider<FriendFeedsContract.View> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final Provider<InitSocialFeed> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<GroupedFeedMapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<DeleteLastShareFeedRequest> PlaceComponentResult;
    private final Provider<GetTimeline> PrepareContext;
    private final Provider<CheckPendingShareFeedDialog> getAuthRequestContext;
    private final Provider<FeedModelMapper> getErrorConfigVersion;
    private final Provider<GetCachedInitAndFeedStatus> initRecordTimeStamp;
    private final Provider<GetTimelineWithTopFriends> isLayoutRequested;
    private final Provider<FeedUserConfigHelper> lookAheadTest;
    private final Provider<FeedsContentAction> moveToNextValue;
    private final Provider<GetUserInfo> newProxyInstance;
    private final Provider<FetchShareableActivities> scheduleImpl;

    private FriendsFeedsPresenter_Factory(Provider<FriendFeedsContract.View> provider, Provider<GetTimeline> provider2, Provider<GetTimelineWithTopFriends> provider3, Provider<FeedMapper> provider4, Provider<FeedModelMapper> provider5, Provider<GroupedFeedMapper> provider6, Provider<FeedsContentAction> provider7, Provider<ObserveInitFeed> provider8, Provider<InitSocialFeed> provider9, Provider<GetMyFeedsHeaderInfo> provider10, Provider<FetchFeedNotificationCount> provider11, Provider<GetUserInfo> provider12, Provider<CreateFeedActivity> provider13, Provider<GetShareFeedConsent> provider14, Provider<SaveShareFeedConsent> provider15, Provider<DeleteFeedActivity> provider16, Provider<DeleteLastShareFeedRequest> provider17, Provider<CheckPendingShareFeedDialog> provider18, Provider<GetFeedConfig> provider19, Provider<FetchShareableActivities> provider20, Provider<SkipShareableActivity> provider21, Provider<FeedUserConfigHelper> provider22, Provider<GetCachedInitAndFeedStatus> provider23) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = provider;
        this.PrepareContext = provider2;
        this.isLayoutRequested = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.getErrorConfigVersion = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider6;
        this.moveToNextValue = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider9;
        this.GetContactSyncConfig = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider11;
        this.newProxyInstance = provider12;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider13;
        this.DatabaseTableConfigUtil = provider14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = provider15;
        this.MyBillsEntityDataFactory = provider16;
        this.PlaceComponentResult = provider17;
        this.getAuthRequestContext = provider18;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider19;
        this.scheduleImpl = provider20;
        this.FragmentBottomSheetPaymentSettingBinding = provider21;
        this.lookAheadTest = provider22;
        this.initRecordTimeStamp = provider23;
    }

    public static FriendsFeedsPresenter_Factory MyBillsEntityDataFactory(Provider<FriendFeedsContract.View> provider, Provider<GetTimeline> provider2, Provider<GetTimelineWithTopFriends> provider3, Provider<FeedMapper> provider4, Provider<FeedModelMapper> provider5, Provider<GroupedFeedMapper> provider6, Provider<FeedsContentAction> provider7, Provider<ObserveInitFeed> provider8, Provider<InitSocialFeed> provider9, Provider<GetMyFeedsHeaderInfo> provider10, Provider<FetchFeedNotificationCount> provider11, Provider<GetUserInfo> provider12, Provider<CreateFeedActivity> provider13, Provider<GetShareFeedConsent> provider14, Provider<SaveShareFeedConsent> provider15, Provider<DeleteFeedActivity> provider16, Provider<DeleteLastShareFeedRequest> provider17, Provider<CheckPendingShareFeedDialog> provider18, Provider<GetFeedConfig> provider19, Provider<FetchShareableActivities> provider20, Provider<SkipShareableActivity> provider21, Provider<FeedUserConfigHelper> provider22, Provider<GetCachedInitAndFeedStatus> provider23) {
        return new FriendsFeedsPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FriendsFeedsPresenter(DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda4), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp));
    }
}
