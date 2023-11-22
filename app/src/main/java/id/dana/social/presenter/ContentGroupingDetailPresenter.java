package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.social.contract.ContentGroupingDetailContract;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.utils.FeedsContentAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u00015B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020,\u0012\u0006\u0010\u0007\u001a\u00020#\u0012\u0006\u00100\u001a\u00020\u001b\u0012\u0006\u00101\u001a\u00020\u001e\u0012\u0006\u00102\u001a\u00020&¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ7\u0010\f\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\b\u0010\u0013J\u000f\u0010\f\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\f\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u001d\u0010\b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016¢\u0006\u0004\b\b\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0005\u0010\u0017R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000e\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\b\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010!\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010$\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0012\u0010\u001c\u001a\u00020)X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010*R\u0012\u0010\u001f\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0012\u0010'\u001a\u00020\u0002X\u0086\"¢\u0006\u0006\n\u0004\b\f\u0010+R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/social/presenter/ContentGroupingDetailPresenter;", "Lid/dana/social/contract/ContentGroupingDetailContract$Presenter;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/HashMap;)V", "PlaceComponentResult", "()V", "()Ljava/lang/String;", "", "getAuthRequestContext", "()Z", "onDestroy", "", "(Ljava/util/List;)V", "(Z)V", "Ljava/util/List;", "", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/social/model/mapper/FeedMapper;", "getErrorConfigVersion", "Lid/dana/social/model/mapper/FeedMapper;", "Lid/dana/social/utils/FeedsContentAction;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/utils/FeedsContentAction;", "moveToNextValue", "Z", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "lookAheadTest", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "Lid/dana/domain/account/interactor/GetUserId;", "scheduleImpl", "Lid/dana/domain/account/interactor/GetUserId;", "", "I", "Ljava/lang/String;", "Lid/dana/social/contract/ContentGroupingDetailContract$View;", "initRecordTimeStamp", "Lid/dana/social/contract/ContentGroupingDetailContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p2", "p3", "p4", "<init>", "(Lid/dana/social/contract/ContentGroupingDetailContract$View;Lid/dana/feeds/domain/timeline/interactor/GetTimeline;Lid/dana/social/model/mapper/FeedMapper;Lid/dana/social/utils/FeedsContentAction;Lid/dana/domain/account/interactor/GetUserId;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContentGroupingDetailPresenter implements ContentGroupingDetailContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    List<ActivityResponse> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final FeedsContentAction PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final FeedMapper KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final ContentGroupingDetailContract.View NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetTimeline moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetUserId lookAheadTest;

    @Inject
    public ContentGroupingDetailPresenter(ContentGroupingDetailContract.View view, GetTimeline getTimeline, FeedMapper feedMapper, FeedsContentAction feedsContentAction, GetUserId getUserId) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getTimeline, "");
        Intrinsics.checkNotNullParameter(feedMapper, "");
        Intrinsics.checkNotNullParameter(feedsContentAction, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = view;
        this.moveToNextValue = getTimeline;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedMapper;
        this.PlaceComponentResult = feedsContentAction;
        this.lookAheadTest = getUserId;
        this.BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();
        this.getAuthRequestContext = new ArrayList();
        this.lookAheadTest.execute(new DefaultObserver<String>() { // from class: id.dana.social.presenter.ContentGroupingDetailPresenter$getCurrentlyLoggedInUserId$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                super.onNext(str);
                ContentGroupingDetailPresenter contentGroupingDetailPresenter = ContentGroupingDetailPresenter.this;
                Intrinsics.checkNotNullParameter(str, "");
                contentGroupingDetailPresenter.scheduleImpl = str;
            }
        });
    }

    @Override // id.dana.social.contract.ContentGroupingDetailContract.Presenter
    public final void MyBillsEntityDataFactory(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory = p0;
    }

    @Override // id.dana.social.contract.ContentGroupingDetailContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        this.MyBillsEntityDataFactory = p0;
    }

    @Override // id.dana.social.contract.ContentGroupingDetailContract.Presenter
    public final void PlaceComponentResult() {
        List<String> subList;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        int i = this.getErrorConfigVersion * 10;
        if (MyBillsEntityDataFactory()) {
            int i2 = i + 10;
            if (i2 > this.BuiltInFictitiousFunctionClassFactory.size()) {
                List<String> list = this.BuiltInFictitiousFunctionClassFactory;
                subList = list.subList(i, list.size());
            } else {
                subList = this.BuiltInFictitiousFunctionClassFactory.subList(i, i2);
            }
            GetTimeline getTimeline = this.moveToNextValue;
            Intrinsics.checkNotNullParameter(subList, "");
            BaseUseCaseWithAnalytics.executeJava1$default(getTimeline, new GetTimeline.Params(10, "", Integer.valueOf(this.MyBillsEntityDataFactory ? 5 : 2), subList), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.ContentGroupingDetailPresenter$fetchGroupedActivities$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
                    invoke2(socialFeed);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SocialFeed socialFeed) {
                    FeedMapper feedMapper;
                    ContentGroupingDetailContract.View view;
                    FeedMapper feedMapper2;
                    Intrinsics.checkNotNullParameter(socialFeed, "");
                    if ((!socialFeed.getActivities().isEmpty()) != false) {
                        ContentGroupingDetailPresenter.this.getErrorConfigVersion++;
                        ContentGroupingDetailPresenter.this.getAuthRequestContext.addAll(socialFeed.getActivities());
                    }
                    feedMapper = ContentGroupingDetailPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    feedMapper.PlaceComponentResult = socialFeed.getFeedVersion() >= 5;
                    view = ContentGroupingDetailPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    feedMapper2 = ContentGroupingDetailPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view.MyBillsEntityDataFactory(feedMapper2.MyBillsEntityDataFactory(socialFeed.getActivities()));
                    ContentGroupingDetailPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                }
            }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.ContentGroupingDetailPresenter$fetchGroupedActivities$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Throwable th) {
                    ContentGroupingDetailContract.View view;
                    ContentGroupingDetailContract.View view2;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = ContentGroupingDetailPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    view.PlaceComponentResult();
                    ContentGroupingDetailPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                    view2 = ContentGroupingDetailPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    return view2.BuiltInFictitiousFunctionClassFactory();
                }
            }, null, 8, null);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory(CollectionsKt.emptyList());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Override // id.dana.social.contract.ContentGroupingDetailContract.Presenter
    public final boolean MyBillsEntityDataFactory() {
        return this.getErrorConfigVersion * 10 < this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Override // id.dana.social.contract.ContentGroupingDetailContract.Presenter
    public final boolean getAuthRequestContext() {
        return !this.getAuthRequestContext.isEmpty();
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.getErrorConfigVersion * 10 < this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.getAuthRequestContext(p0);
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(HashMap<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        FeedsContentAction feedsContentAction = this.PlaceComponentResult;
        feedsContentAction.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        feedsContentAction.scheduleImpl.get().dispose();
        this.lookAheadTest.dispose();
        this.moveToNextValue.dispose();
    }

    @Override // id.dana.social.contract.ContentGroupingDetailContract.Presenter
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = this.scheduleImpl;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }
}
