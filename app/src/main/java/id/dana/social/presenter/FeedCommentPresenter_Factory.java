package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.detail.interactor.AddActivityComment;
import id.dana.feeds.domain.detail.interactor.DeleteComment;
import id.dana.feeds.domain.detail.interactor.GetFeedComment;
import id.dana.feeds.domain.detail.interactor.SubmitFeedCommentReport;
import id.dana.feeds.domain.notification.interactor.MarkAsReadNotification;
import id.dana.feeds.domain.profile.interactor.GetMyFeedsHeaderInfo;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.social.contract.FeedCommentContract;
import id.dana.social.model.mapper.FeedMapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class FeedCommentPresenter_Factory implements Factory<FeedCommentPresenter> {
    private final Provider<AddActivityComment> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DeleteComment> MyBillsEntityDataFactory;
    private final Provider<MarkAsReadNotification> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FeedCommentContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<GetFeedConfig> PlaceComponentResult;
    private final Provider<GetFeedComment> getAuthRequestContext;
    private final Provider<GetMyFeedsHeaderInfo> getErrorConfigVersion;
    private final Provider<SubmitFeedCommentReport> lookAheadTest;
    private final Provider<GetTimeline> moveToNextValue;
    private final Provider<GetUserId> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedCommentPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.getErrorConfigVersion.get(), this.moveToNextValue.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.PlaceComponentResult.get());
    }
}
