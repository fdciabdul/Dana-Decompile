package id.dana.pushverify.view.verificationlist.list;

import dagger.Lazy;
import id.dana.domain.pushverify.interactor.GetActivePushVerificationList;
import id.dana.domain.pushverify.interactor.GetHistoryPushVerificationList;
import id.dana.domain.pushverify.model.PushVerificationList;
import id.dana.domain.pushverify.model.PushVerificationListParams;
import id.dana.domain.pushverify.model.VerificationDetailItem;
import id.dana.pushverify.mapper.VerifyListModelMapperKt;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000e¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\bX\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0012\u0010\t\u001a\u00020\bX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0003\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0005\u001a\u00020\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/pushverify/view/verificationlist/list/VerificationListPresenter;", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$Presenter;", "", "getAuthRequestContext", "()V", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "Lid/dana/domain/pushverify/interactor/GetActivePushVerificationList;", "Lid/dana/domain/pushverify/interactor/GetActivePushVerificationList;", "PlaceComponentResult", "Lid/dana/domain/pushverify/interactor/GetHistoryPushVerificationList;", "moveToNextValue", "Lid/dana/domain/pushverify/interactor/GetHistoryPushVerificationList;", "", "Z", "getErrorConfigVersion", "Ldagger/Lazy;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ldagger/Lazy;", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;", "scheduleImpl", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;", "lookAheadTest", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;Ldagger/Lazy;Lid/dana/domain/pushverify/interactor/GetActivePushVerificationList;Lid/dana/domain/pushverify/interactor/GetHistoryPushVerificationList;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationListPresenter implements VerificationListContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<PushVerifyTracker> moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetActivePushVerificationList PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetHistoryPushVerificationList getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final VerificationListContract.View lookAheadTest;

    @Inject
    public VerificationListPresenter(VerificationListContract.View view, Lazy<PushVerifyTracker> lazy, GetActivePushVerificationList getActivePushVerificationList, GetHistoryPushVerificationList getHistoryPushVerificationList) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(getActivePushVerificationList, "");
        Intrinsics.checkNotNullParameter(getHistoryPushVerificationList, "");
        this.lookAheadTest = view;
        this.moveToNextValue = lazy;
        this.PlaceComponentResult = getActivePushVerificationList;
        this.getAuthRequestContext = getHistoryPushVerificationList;
        this.MyBillsEntityDataFactory = 1;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        this.getErrorConfigVersion = true;
    }

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.Presenter
    public final void getAuthRequestContext() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            if (this.MyBillsEntityDataFactory == 1) {
                this.lookAheadTest.showProgress();
            }
            this.PlaceComponentResult.execute(new PushVerificationListParams(this.MyBillsEntityDataFactory, 10), new Function1<PushVerificationList, Unit>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListPresenter$getActivePushVerificationList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(PushVerificationList pushVerificationList) {
                    invoke2(pushVerificationList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(PushVerificationList pushVerificationList) {
                    Intrinsics.checkNotNullParameter(pushVerificationList, "");
                    VerificationListPresenter.MyBillsEntityDataFactory(VerificationListPresenter.this, pushVerificationList);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListPresenter$getActivePushVerificationList$2
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
                    VerificationListContract.View view;
                    Lazy lazy;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = VerificationListPresenter.this.lookAheadTest;
                    view.onError(th.getMessage());
                    lazy = VerificationListPresenter.this.moveToNextValue;
                    ((PushVerifyTracker) lazy.get()).getAuthRequestContext(th);
                }
            });
        }
    }

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.getErrorConfigVersion) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                this.lookAheadTest.showProgress();
            } else {
                this.lookAheadTest.MyBillsEntityDataFactory();
            }
            this.getAuthRequestContext.execute(new PushVerificationListParams(this.KClassImpl$Data$declaredNonStaticMembers$2, 10), new Function1<PushVerificationList, Unit>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListPresenter$getHistoryPushVerificationList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(PushVerificationList pushVerificationList) {
                    invoke2(pushVerificationList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(PushVerificationList pushVerificationList) {
                    Intrinsics.checkNotNullParameter(pushVerificationList, "");
                    VerificationListPresenter.BuiltInFictitiousFunctionClassFactory(VerificationListPresenter.this, pushVerificationList);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListPresenter$getHistoryPushVerificationList$2
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
                    VerificationListContract.View view;
                    Lazy lazy;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = VerificationListPresenter.this.lookAheadTest;
                    view.onError(th.getMessage());
                    lazy = VerificationListPresenter.this.moveToNextValue;
                    ((PushVerifyTracker) lazy.get()).getAuthRequestContext(th);
                }
            });
        }
    }

    @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory = 1;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        this.getErrorConfigVersion = true;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(VerificationListPresenter verificationListPresenter, PushVerificationList pushVerificationList) {
        List<VerificationDetailItem> component1 = pushVerificationList.component1();
        verificationListPresenter.BuiltInFictitiousFunctionClassFactory = pushVerificationList.getHasMore();
        List<VerificationDetailItem> list = component1;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(VerifyListModelMapperKt.BuiltInFictitiousFunctionClassFactory((VerificationDetailItem) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty() && verificationListPresenter.MyBillsEntityDataFactory == 1) {
            verificationListPresenter.lookAheadTest.getAuthRequestContext();
            return;
        }
        verificationListPresenter.lookAheadTest.PlaceComponentResult(arrayList2);
        verificationListPresenter.MyBillsEntityDataFactory++;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerificationListPresenter verificationListPresenter, PushVerificationList pushVerificationList) {
        List<VerificationDetailItem> component1 = pushVerificationList.component1();
        verificationListPresenter.getErrorConfigVersion = pushVerificationList.getHasMore();
        List<VerificationDetailItem> list = component1;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(VerifyListModelMapperKt.BuiltInFictitiousFunctionClassFactory((VerificationDetailItem) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty() && verificationListPresenter.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
            verificationListPresenter.lookAheadTest.getAuthRequestContext();
        } else if ((!arrayList2.isEmpty()) != false && verificationListPresenter.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
            verificationListPresenter.lookAheadTest.BuiltInFictitiousFunctionClassFactory(arrayList2);
            verificationListPresenter.KClassImpl$Data$declaredNonStaticMembers$2++;
        } else {
            verificationListPresenter.lookAheadTest.MyBillsEntityDataFactory(arrayList2);
            verificationListPresenter.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
    }
}
