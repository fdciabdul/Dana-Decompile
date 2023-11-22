package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.detail.interactor.AddActivityComment;
import id.dana.feeds.domain.detail.interactor.DeleteComment;
import id.dana.feeds.domain.detail.interactor.GetFeedComment;
import id.dana.feeds.domain.detail.interactor.SubmitFeedCommentReport;
import id.dana.feeds.domain.detail.model.AddActivityCommentInfo;
import id.dana.feeds.domain.detail.model.FeedCommentResult;
import id.dana.feeds.domain.notification.interactor.MarkAsReadNotification;
import id.dana.feeds.domain.profile.interactor.GetMyFeedsHeaderInfo;
import id.dana.feeds.domain.profile.model.MyFeedsHeaderInfo;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.social.contract.FeedCommentContract;
import id.dana.social.mapper.AddActivityCommentModelMapperKt;
import id.dana.social.model.FeedCommentResultModel;
import id.dana.social.model.FeedCommentResultModelKt;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 R2\u00020\u0001:\u0001RBa\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020D\u0012\u0006\u0010\u0005\u001a\u00020\u001a\u0012\u0006\u0010\u0018\u001a\u00020'\u0012\u0006\u0010H\u001a\u00020?\u0012\u0006\u0010I\u001a\u00020\u001d\u0012\u0006\u0010J\u001a\u00020-\u0012\u0006\u0010K\u001a\u000200\u0012\u0006\u0010L\u001a\u00020$\u0012\u0006\u0010M\u001a\u000203\u0012\u0006\u0010N\u001a\u00020=\u0012\u0006\u0010O\u001a\u00020*¢\u0006\u0004\bP\u0010QJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\t\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\t\u0010\u000fJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0007\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0007\u0010\u0016J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0019R\u0014\u0010\u0012\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u000b\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020 X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010!R\u0014\u0010\t\u001a\u0004\u0018\u00010\"X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010\u0007\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u001e\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\u001b\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010%\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0012\u00101\u001a\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u00107R\u0014\u0010:\u001a\u0004\u0018\u000108X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u00109R \u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040;X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010<R\u0014\u00104\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010>R\u0014\u0010+\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0012\u0010C\u001a\u00020\u0004X\u0086\"¢\u0006\u0006\n\u0004\b6\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F"}, d2 = {"Lid/dana/social/presenter/FeedCommentPresenter;", "Lid/dana/social/contract/FeedCommentContract$Presenter;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "p0", "", "p1", "", "PlaceComponentResult", "(Lid/dana/feeds/ui/model/FeedCommentModel;Ljava/lang/String;)V", "getAuthRequestContext", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "", "", "(Ljava/util/List;I)V", "(Ljava/util/List;)V", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "", "()Z", "onDestroy", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/feeds/domain/detail/interactor/AddActivityComment;", "scheduleImpl", "Lid/dana/feeds/domain/detail/interactor/AddActivityComment;", "Lid/dana/feeds/domain/detail/interactor/DeleteComment;", "getErrorConfigVersion", "Lid/dana/feeds/domain/detail/interactor/DeleteComment;", "Ljava/util/Queue;", "Ljava/util/Queue;", "Lid/dana/domain/social/model/FeedConfig;", "Lid/dana/domain/social/model/FeedConfig;", "Lid/dana/social/model/mapper/FeedMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/model/mapper/FeedMapper;", "Lid/dana/feeds/domain/detail/interactor/GetFeedComment;", "lookAheadTest", "Lid/dana/feeds/domain/detail/interactor/GetFeedComment;", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "DatabaseTableConfigUtil", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "Lid/dana/feeds/domain/profile/interactor/GetMyFeedsHeaderInfo;", "GetContactSyncConfig", "Lid/dana/feeds/domain/profile/interactor/GetMyFeedsHeaderInfo;", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "Lid/dana/domain/account/interactor/GetUserId;", "initRecordTimeStamp", "Lid/dana/domain/account/interactor/GetUserId;", "moveToNextValue", "Z", "Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "Ljava/util/Map;", "Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification;", "Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification;", "Lid/dana/feeds/domain/detail/interactor/SubmitFeedCommentReport;", "isLayoutRequested", "Lid/dana/feeds/domain/detail/interactor/SubmitFeedCommentReport;", "Ljava/lang/String;", "newProxyInstance", "Lid/dana/social/contract/FeedCommentContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/social/contract/FeedCommentContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Lid/dana/social/contract/FeedCommentContract$View;Lid/dana/feeds/domain/detail/interactor/AddActivityComment;Lid/dana/feeds/domain/detail/interactor/GetFeedComment;Lid/dana/feeds/domain/detail/interactor/SubmitFeedCommentReport;Lid/dana/feeds/domain/detail/interactor/DeleteComment;Lid/dana/feeds/domain/profile/interactor/GetMyFeedsHeaderInfo;Lid/dana/feeds/domain/timeline/interactor/GetTimeline;Lid/dana/social/model/mapper/FeedMapper;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification;Lid/dana/feeds/domain/config/interactor/GetFeedConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedCommentPresenter implements FeedCommentContract.Presenter {
    final Queue<FeedCommentModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final GetFeedConfig getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final GetMyFeedsHeaderInfo scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    FeedCommentResult NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final FeedMapper PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final MarkAsReadNotification initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final GetTimeline NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final FeedCommentContract.View NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    FeedConfig getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    Map<String, String> GetContactSyncConfig;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final DeleteComment KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final GetUserId moveToNextValue;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final SubmitFeedCommentReport DatabaseTableConfigUtil;
    private final GetFeedComment lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final AddActivityComment MyBillsEntityDataFactory;

    @Inject
    public FeedCommentPresenter(FeedCommentContract.View view, AddActivityComment addActivityComment, GetFeedComment getFeedComment, SubmitFeedCommentReport submitFeedCommentReport, DeleteComment deleteComment, GetMyFeedsHeaderInfo getMyFeedsHeaderInfo, GetTimeline getTimeline, FeedMapper feedMapper, GetUserId getUserId, MarkAsReadNotification markAsReadNotification, GetFeedConfig getFeedConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(addActivityComment, "");
        Intrinsics.checkNotNullParameter(getFeedComment, "");
        Intrinsics.checkNotNullParameter(submitFeedCommentReport, "");
        Intrinsics.checkNotNullParameter(deleteComment, "");
        Intrinsics.checkNotNullParameter(getMyFeedsHeaderInfo, "");
        Intrinsics.checkNotNullParameter(getTimeline, "");
        Intrinsics.checkNotNullParameter(feedMapper, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(markAsReadNotification, "");
        Intrinsics.checkNotNullParameter(getFeedConfig, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = view;
        this.MyBillsEntityDataFactory = addActivityComment;
        this.lookAheadTest = getFeedComment;
        this.DatabaseTableConfigUtil = submitFeedCommentReport;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deleteComment;
        this.scheduleImpl = getMyFeedsHeaderInfo;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getTimeline;
        this.PlaceComponentResult = feedMapper;
        this.moveToNextValue = getUserId;
        this.initRecordTimeStamp = markAsReadNotification;
        this.getErrorConfigVersion = getFeedConfig;
        this.BuiltInFictitiousFunctionClassFactory = new LinkedList();
        this.GetContactSyncConfig = new LinkedHashMap();
        this.moveToNextValue.execute(new DefaultObserver<String>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getCurrentlyLoggedInUserId$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                super.onNext(str);
                FeedCommentPresenter feedCommentPresenter = FeedCommentPresenter.this;
                Intrinsics.checkNotNullParameter(str, "");
                feedCommentPresenter.newProxyInstance = str;
            }
        });
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.initRecordTimeStamp.execute(new MarkAsReadNotification.Params(CollectionsKt.listOf(p0)), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$markAsRead$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$markAsRead$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final boolean PlaceComponentResult() {
        FeedCommentResult feedCommentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (feedCommentResult != null) {
            return feedCommentResult.getHasNext();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if ((r3.length() == 0) != false) goto L9;
     */
    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(id.dana.feeds.ui.model.FeedCommentModel r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r2.BuiltInFictitiousFunctionClassFactory()
            if (r0 != 0) goto L1c
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 == 0) goto L21
        L1c:
            id.dana.social.contract.FeedCommentContract$View r0 = r1.NetworkUserEntityData$$ExternalSyntheticLambda7
            r0.BuiltInFictitiousFunctionClassFactory(r2)
        L21:
            java.util.Queue<id.dana.feeds.ui.model.FeedCommentModel> r0 = r1.BuiltInFictitiousFunctionClassFactory
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L32
            java.util.Queue<id.dana.feeds.ui.model.FeedCommentModel> r0 = r1.BuiltInFictitiousFunctionClassFactory
            r0.add(r2)
            r1.PlaceComponentResult(r2, r3)
            return
        L32:
            java.util.Queue<id.dana.feeds.ui.model.FeedCommentModel> r3 = r1.BuiltInFictitiousFunctionClassFactory
            r3.add(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.presenter.FeedCommentPresenter.BuiltInFictitiousFunctionClassFactory(id.dana.feeds.ui.model.FeedCommentModel, java.lang.String):void");
    }

    private final void PlaceComponentResult(final FeedCommentModel p0, final String p1) {
        this.MyBillsEntityDataFactory.executeJava1(new AddActivityComment.Params(String.valueOf(p0.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult), p1, p0.PlaceComponentResult, p0.moveToNextValue), new Function1<AddActivityCommentInfo, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$addActivityComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AddActivityCommentInfo addActivityCommentInfo) {
                invoke2(addActivityCommentInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AddActivityCommentInfo addActivityCommentInfo) {
                FeedCommentContract.View view;
                Intrinsics.checkNotNullParameter(addActivityCommentInfo, "");
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                FeedCommentModel poll = FeedCommentPresenter.this.BuiltInFictitiousFunctionClassFactory.poll();
                Intrinsics.checkNotNullExpressionValue(poll, "");
                view.PlaceComponentResult(poll, AddActivityCommentModelMapperKt.PlaceComponentResult(addActivityCommentInfo));
                FeedCommentPresenter.BuiltInFictitiousFunctionClassFactory(FeedCommentPresenter.this, p1);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.FeedCommentPresenter$addActivityComment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FeedCommentContract.View view;
                FeedCommentContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                FeedCommentModel poll = FeedCommentPresenter.this.BuiltInFictitiousFunctionClassFactory.poll();
                Intrinsics.checkNotNullExpressionValue(poll, "");
                view.BuiltInFictitiousFunctionClassFactory(poll);
                StringBuilder sb = new StringBuilder();
                sb.append("[FeedInputComment] ");
                sb.append(th.getLocalizedMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FEED_INPUT_COMMENT, sb.toString());
                FeedCommentPresenter.BuiltInFictitiousFunctionClassFactory(FeedCommentPresenter.this, p1);
                view2 = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                return view2.BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory());
            }
        }, this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory());
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.scheduleImpl.execute(NoParams.INSTANCE, new Function1<MyFeedsHeaderInfo, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getUserInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MyFeedsHeaderInfo myFeedsHeaderInfo) {
                invoke2(myFeedsHeaderInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MyFeedsHeaderInfo myFeedsHeaderInfo) {
                FeedCommentContract.View view;
                Intrinsics.checkNotNullParameter(myFeedsHeaderInfo, "");
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                MyFeedHeaderModel.Companion companion = MyFeedHeaderModel.INSTANCE;
                MyFeedHeaderModel.Companion companion2 = MyFeedHeaderModel.INSTANCE;
                view.MyBillsEntityDataFactory(MyFeedHeaderModel.Companion.PlaceComponentResult(MyFeedHeaderModel.Companion.MyBillsEntityDataFactory(myFeedsHeaderInfo)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getUserInfo$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("[FeedComment] : ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FEED_COMMENT, sb.toString());
            }
        });
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void getAuthRequestContext(final List<String> p0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(p0, "");
        FeedConfig feedConfig = this.getAuthRequestContext;
        if (feedConfig != null) {
            getAuthRequestContext(p0, feedConfig.getFeedVersion());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.getErrorConfigVersion.execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$fetchDataBubble$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(FeedConfig feedConfig2) {
                    invoke2(feedConfig2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FeedConfig feedConfig2) {
                    FeedCommentContract.View view;
                    Intrinsics.checkNotNullParameter(feedConfig2, "");
                    FeedCommentPresenter.this.getAuthRequestContext = feedConfig2;
                    view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    view.PlaceComponentResult(feedConfig2);
                    FeedCommentPresenter.this.getAuthRequestContext(p0, feedConfig2.getFeedVersion());
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$fetchDataBubble$2$2
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_FEED_CONFIG, th.getLocalizedMessage(), th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(List<String> p0, final int p1) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new GetTimeline.Params(10, "", Integer.valueOf(p1), p0), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$doFetchTimeline$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FeedMapper feedMapper2;
                FeedCommentContract.View view;
                FeedCommentContract.View view2;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                if (socialFeed.getActivities().isEmpty()) {
                    view2 = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    view2.BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                feedMapper = FeedCommentPresenter.this.PlaceComponentResult;
                feedMapper.PlaceComponentResult = p1 >= 5;
                feedMapper2 = FeedCommentPresenter.this.PlaceComponentResult;
                FeedViewHolderModel feedViewHolderModel = (FeedViewHolderModel) CollectionsKt.first((List) feedMapper2.MyBillsEntityDataFactory(socialFeed.getActivities()));
                if (feedViewHolderModel != null) {
                    view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    view.KClassImpl$Data$declaredNonStaticMembers$2(feedViewHolderModel);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$doFetchTimeline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeedCommentContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.executeJava1(new DeleteComment.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$deleteComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FeedCommentContract.View view;
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.PlaceComponentResult();
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.FeedCommentPresenter$deleteComment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FeedCommentContract.View view;
                FeedCommentContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
                view2 = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                return view2.KClassImpl$Data$declaredNonStaticMembers$2(SocialActivityDetail.ActivityDetailErrorType.DELETE_COMMENT);
            }
        }, this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory());
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.GetContactSyncConfig = new LinkedHashMap();
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return;
        }
        if (p0.length() == 0) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        GetFeedComment getFeedComment = this.lookAheadTest;
        FeedCommentResult feedCommentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String maxId = feedCommentResult != null ? feedCommentResult.getMaxId() : null;
        getFeedComment.executeJava1(new GetFeedComment.Params(p0, null, maxId == null ? "" : maxId, null, GetFeedComment.CommentType.FEED_PARENT_COMMENT, 10, null), new Function1<FeedCommentResult, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getFeedComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedCommentResult feedCommentResult2) {
                invoke2(feedCommentResult2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedCommentResult feedCommentResult2) {
                FeedCommentContract.View view;
                Intrinsics.checkNotNullParameter(feedCommentResult2, "");
                FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = feedCommentResult2;
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                FeedCommentResultModel.Companion companion = FeedCommentResultModel.INSTANCE;
                view.MyBillsEntityDataFactory(FeedCommentResultModel.Companion.MyBillsEntityDataFactory(feedCommentResult2));
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getFeedComment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FeedCommentContract.View view;
                FeedCommentContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.KClassImpl$Data$declaredNonStaticMembers$2(th);
                StringBuilder sb = new StringBuilder();
                sb.append("[FeedComment] ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FEED_COMMENT, sb.toString());
                view2 = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                return view2.KClassImpl$Data$declaredNonStaticMembers$2(SocialActivityDetail.ActivityDetailErrorType.FETCH_COMMENT);
            }
        }, this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory());
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void PlaceComponentResult(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.DatabaseTableConfigUtil.executeJava1(new SubmitFeedCommentReport.Params(p0, p1, p2), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$submitReportComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FeedCommentContract.View view;
                FeedCommentContract.View view2;
                if (z) {
                    view2 = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    view2.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    return;
                }
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.getAuthRequestContext();
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.FeedCommentPresenter$submitReportComment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FeedCommentContract.View view;
                FeedCommentContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.getAuthRequestContext();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_CONSULT, th.getMessage(), th);
                view2 = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                return view2.KClassImpl$Data$declaredNonStaticMembers$2(SocialActivityDetail.ActivityDetailErrorType.REPORT_COMMENT);
            }
        }, this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory());
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.lookAheadTest.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.DatabaseTableConfigUtil.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.scheduleImpl.dispose();
        this.BuiltInFictitiousFunctionClassFactory.clear();
        this.initRecordTimeStamp.dispose();
        this.getErrorConfigVersion.dispose();
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getErrorConfigVersion.execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getFeedConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedConfig feedConfig) {
                invoke2(feedConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedConfig feedConfig) {
                FeedCommentContract.View view;
                Intrinsics.checkNotNullParameter(feedConfig, "");
                FeedCommentPresenter.this.getAuthRequestContext = feedConfig;
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.PlaceComponentResult(feedConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getFeedConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_FEED_CONFIG, th.getLocalizedMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final void getAuthRequestContext(String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return;
        }
        if (p0.length() == 0) {
            return;
        }
        if (p1.length() == 0) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        GetFeedComment getFeedComment = this.lookAheadTest;
        String str = this.GetContactSyncConfig.get(p1);
        getFeedComment.execute(new GetFeedComment.Params(p0, p1, str == null ? "" : str, null, GetFeedComment.CommentType.FEED_SUB_COMMENT, 8, null), new Function1<FeedCommentResult, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getFeedSubComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedCommentResult feedCommentResult) {
                invoke2(feedCommentResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedCommentResult feedCommentResult) {
                FeedCommentContract.View view;
                FeedCommentContract.View view2;
                Intrinsics.checkNotNullParameter(feedCommentResult, "");
                FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                FeedCommentPresenter.this.GetContactSyncConfig.put(p1, feedCommentResult.getMaxId());
                if (feedCommentResult.getComments().isEmpty()) {
                    view2 = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    view2.MyBillsEntityDataFactory(p1, feedCommentResult.getNumberOfReportedComments());
                    return;
                }
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.BuiltInFictitiousFunctionClassFactory(FeedCommentResultModelKt.MyBillsEntityDataFactory(feedCommentResult.getComments()), feedCommentResult.getNumberOfReportedComments());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FeedCommentPresenter$getFeedSubComment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeedCommentContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                view = FeedCommentPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                view.PlaceComponentResult(th);
                StringBuilder sb = new StringBuilder();
                sb.append("[FeedComment] ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FEED_COMMENT, sb.toString());
            }
        });
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FeedCommentPresenter feedCommentPresenter, String str) {
        if ((!feedCommentPresenter.BuiltInFictitiousFunctionClassFactory.isEmpty()) == true) {
            FeedCommentModel peek = feedCommentPresenter.BuiltInFictitiousFunctionClassFactory.peek();
            Intrinsics.checkNotNullExpressionValue(peek, "");
            feedCommentPresenter.PlaceComponentResult(peek, str);
        }
    }

    @Override // id.dana.social.contract.FeedCommentContract.Presenter
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = this.newProxyInstance;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }
}
