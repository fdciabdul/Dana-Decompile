package id.dana.social.presenter;

import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.reactions.interactor.GetActivityReactions;
import id.dana.feeds.domain.reactions.interactor.GetMyActivityReactionInfo;
import id.dana.feeds.domain.reactions.model.ActivityReactions;
import id.dana.feeds.domain.reactions.model.MyActivityReactionInfo;
import id.dana.feeds.ui.model.ActivityReactionsModel;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import id.dana.social.contract.ActivityReactionsContract;
import id.dana.social.mapper.ActivityReactionsModelMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020 \u0012\u0006\u0010\u0004\u001a\u00020\u0018\u0012\u0006\u0010\u0006\u001a\u00020\u001a¢\u0006\u0004\b$\u0010%J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\n\u001a\u00020\u00052\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\n\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\n\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0014\u0010\r\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/social/presenter/ActivityReactionsPresenter;", "Lid/dana/social/contract/ActivityReactionsContract$Presenter;", "", "p0", "p1", "", "p2", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Z)V", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "", "MyBillsEntityDataFactory", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "(Ljava/util/List;)Z", "onDestroy", "(Z)V", "Lid/dana/feeds/ui/model/ActivityReactionsModel;", "Lid/dana/feeds/ui/model/ActivityReactionsModel;", "Lid/dana/feeds/domain/reactions/interactor/GetActivityReactions;", "Lid/dana/feeds/domain/reactions/interactor/GetActivityReactions;", "Lid/dana/feeds/domain/reactions/interactor/GetMyActivityReactionInfo;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/reactions/interactor/GetMyActivityReactionInfo;", "Lid/dana/feeds/domain/reactions/model/MyActivityReactionInfo;", "Lid/dana/feeds/domain/reactions/model/MyActivityReactionInfo;", "Z", "Lid/dana/social/contract/ActivityReactionsContract$View;", "scheduleImpl", "Lid/dana/social/contract/ActivityReactionsContract$View;", "lookAheadTest", "<init>", "(Lid/dana/social/contract/ActivityReactionsContract$View;Lid/dana/feeds/domain/reactions/interactor/GetActivityReactions;Lid/dana/feeds/domain/reactions/interactor/GetMyActivityReactionInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionsPresenter implements ActivityReactionsContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetMyActivityReactionInfo MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ActivityReactionsModel getAuthRequestContext;
    private final GetActivityReactions PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private MyActivityReactionInfo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ActivityReactionsContract.View lookAheadTest;

    @Inject
    public ActivityReactionsPresenter(ActivityReactionsContract.View view, GetActivityReactions getActivityReactions, GetMyActivityReactionInfo getMyActivityReactionInfo) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getActivityReactions, "");
        Intrinsics.checkNotNullParameter(getMyActivityReactionInfo, "");
        this.lookAheadTest = view;
        this.PlaceComponentResult = getActivityReactions;
        this.MyBillsEntityDataFactory = getMyActivityReactionInfo;
        this.getAuthRequestContext = new ActivityReactionsModel(null, null, null, false, 15, null);
    }

    @Override // id.dana.social.contract.ActivityReactionsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<MyActivityReactionInfo, Unit>() { // from class: id.dana.social.presenter.ActivityReactionsPresenter$getMyActivityReactionInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MyActivityReactionInfo myActivityReactionInfo) {
                invoke2(myActivityReactionInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MyActivityReactionInfo myActivityReactionInfo) {
                ActivityReactionsContract.View view;
                Intrinsics.checkNotNullParameter(myActivityReactionInfo, "");
                ActivityReactionsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = myActivityReactionInfo;
                view = ActivityReactionsPresenter.this.lookAheadTest;
                view.getAuthRequestContext();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.ActivityReactionsPresenter$getMyActivityReactionInfo$2
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
                ActivityReactionsContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, th.getMessage());
                view = ActivityReactionsPresenter.this.lookAheadTest;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.social.contract.ActivityReactionsContract.Presenter
    public final int MyBillsEntityDataFactory() {
        if (this.getAuthRequestContext.PlaceComponentResult != null) {
            return r0.size() - 1;
        }
        return 0;
    }

    @Override // id.dana.social.contract.ActivityReactionsContract.Presenter
    public final void PlaceComponentResult(boolean p0) {
        this.BuiltInFictitiousFunctionClassFactory = p0;
    }

    @Override // id.dana.social.contract.ActivityReactionsContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult.executeJava1(new GetActivityReactions.Params(p0, p1, this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory), new Function1<ActivityReactions, Unit>() { // from class: id.dana.social.presenter.ActivityReactionsPresenter$getActivityReactions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ActivityReactions activityReactions) {
                invoke2(activityReactions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityReactions activityReactions) {
                Intrinsics.checkNotNullParameter(activityReactions, "");
                ActivityReactionsPresenter.BuiltInFictitiousFunctionClassFactory(ActivityReactionsPresenter.this, ActivityReactionsModelMapperKt.BuiltInFictitiousFunctionClassFactory(activityReactions), p2);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.ActivityReactionsPresenter$getActivityReactions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                ActivityReactionsContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.ACTIVITY_REACTIONS, th.getMessage());
                view = ActivityReactionsPresenter.this.lookAheadTest;
                return view.MyBillsEntityDataFactory();
            }
        }, this.lookAheadTest.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // id.dana.social.contract.ActivityReactionsContract.Presenter
    public final void PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (this.getAuthRequestContext.getMyBillsEntityDataFactory()) {
            getAuthRequestContext(p0, p1, true);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }

    private final boolean PlaceComponentResult(List<ActivityReactionsUserModel> p0) {
        if (p0 != null) {
            Iterator<ActivityReactionsUserModel> it = p0.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                ActivityReactionsUserModel next = it.next();
                MyActivityReactionInfo myActivityReactionInfo = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (myActivityReactionInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    myActivityReactionInfo = null;
                }
                if (Intrinsics.areEqual(myActivityReactionInfo.getUserId(), next.PlaceComponentResult)) {
                    break;
                }
                i++;
            }
            return i >= 0;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ActivityReactionsPresenter activityReactionsPresenter, ActivityReactionsModel activityReactionsModel, boolean z) {
        List<ActivityReactionsUserModel> list;
        List mutableList;
        List<ActivityReactionsUserModel> list2;
        List mutableList2;
        if (!z && activityReactionsPresenter.BuiltInFictitiousFunctionClassFactory && !activityReactionsPresenter.PlaceComponentResult(activityReactionsModel.PlaceComponentResult) && (list2 = activityReactionsModel.PlaceComponentResult) != null && (mutableList2 = CollectionsKt.toMutableList((Collection) list2)) != null) {
            MyActivityReactionInfo myActivityReactionInfo = 0;
            ActivityReactionsUserModel activityReactionsUserModel = new ActivityReactionsUserModel(myActivityReactionInfo, null, null, null, null, null, null, 127, null);
            MyActivityReactionInfo myActivityReactionInfo2 = activityReactionsPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            if (myActivityReactionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                myActivityReactionInfo2 = null;
            }
            activityReactionsUserModel.MyBillsEntityDataFactory = myActivityReactionInfo2.getNickname();
            MyActivityReactionInfo myActivityReactionInfo3 = activityReactionsPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            if (myActivityReactionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                myActivityReactionInfo = myActivityReactionInfo3;
            }
            activityReactionsUserModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = myActivityReactionInfo.getAvatarUrl();
            mutableList2.add(0, activityReactionsUserModel);
        }
        ActivityReactionsModel activityReactionsModel2 = activityReactionsPresenter.getAuthRequestContext;
        List<ActivityReactionsUserModel> list3 = activityReactionsModel.PlaceComponentResult;
        if (list3 != null && (list = activityReactionsModel2.PlaceComponentResult) != null && (mutableList = CollectionsKt.toMutableList((Collection) list)) != null) {
            mutableList.addAll(list3);
        }
        activityReactionsModel2.MyBillsEntityDataFactory = activityReactionsModel.getMyBillsEntityDataFactory();
        String str = activityReactionsModel.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(str, "");
        activityReactionsModel2.BuiltInFictitiousFunctionClassFactory = str;
        activityReactionsPresenter.lookAheadTest.BuiltInFictitiousFunctionClassFactory(activityReactionsModel.PlaceComponentResult);
    }
}
