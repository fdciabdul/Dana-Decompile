package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.social.contract.ContentGroupingDetailContract;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.utils.FeedsContentAction;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ContentGroupingDetailPresenter_Factory implements Factory<ContentGroupingDetailPresenter> {
    private final Provider<ContentGroupingDetailContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetTimeline> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsContentAction> MyBillsEntityDataFactory;
    private final Provider<GetUserId> PlaceComponentResult;
    private final Provider<FeedMapper> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContentGroupingDetailPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
