package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.feeds.domain.config.interactor.ApproveFriendRequest;
import id.dana.feeds.domain.config.interactor.DeclineFriendRequest;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.friend.interactor.AddFriend;
import id.dana.feeds.domain.friend.interactor.CancelAddFriend;
import id.dana.feeds.domain.friend.interactor.FindFriends;
import id.dana.feeds.domain.profile.interactor.GetFriendProfile;
import id.dana.feeds.domain.profile.interactor.GetProfileCta;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.ObserveProfileMuteUnmuteStatus;
import id.dana.feeds.domain.timeline.interactor.GetFriendTimeline;
import id.dana.social.contract.SocialProfileContract;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.model.mapper.GroupedFeedMapper;
import id.dana.social.utils.FeedsContentAction;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SocialProfilePresenter_Factory implements Factory<SocialProfilePresenter> {
    private final Provider<ApproveFriendRequest> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetProfileCta> DatabaseTableConfigUtil;
    private final Provider<GetSettingByKey> GetContactSyncConfig;
    private final Provider<CancelAddFriend> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedMapper> MyBillsEntityDataFactory;
    private final Provider<FindFriends> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetUserInfo> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<ModifyFollowerRelationshipWithPublishResult> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<SocialProfileContract.View> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<ModifyFollowingRelationshipWithPublishResult> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<DeclineFriendRequest> PlaceComponentResult;
    private final Provider<AddFriend> getAuthRequestContext;
    private final Provider<GetFriendTimeline> getErrorConfigVersion;
    private final Provider<GroupedFeedMapper> initRecordTimeStamp;
    private final Provider<ObserveProfileMuteUnmuteStatus> isLayoutRequested;
    private final Provider<GetFriendProfile> lookAheadTest;
    private final Provider<FeedsContentAction> moveToNextValue;
    private final Provider<GetFeedConfig> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SocialProfilePresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda8.get(), this.lookAheadTest.get(), this.isLayoutRequested.get(), this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get(), this.initRecordTimeStamp.get(), this.moveToNextValue.get(), this.GetContactSyncConfig.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.scheduleImpl.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.DatabaseTableConfigUtil.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
    }
}
