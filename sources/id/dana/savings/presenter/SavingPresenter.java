package id.dana.savings.presenter;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import id.dana.R;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.saving.repository.source.network.exception.GoalsApiException;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature;
import id.dana.domain.saving.interactor.GetSavingEmptyState;
import id.dana.domain.saving.interactor.GetSavingSummary;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.saving.model.SavingCreateInit;
import id.dana.domain.saving.model.SavingEmptyState;
import id.dana.domain.saving.model.SavingSummary;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.mapper.SavingEmptyStateModelMapperKt;
import id.dana.savings.mapper.SavingSummaryModelMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.C;
import o.E;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0006\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\b\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/savings/presenter/SavingPresenter;", "Lid/dana/savings/contract/SavingContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext", "PlaceComponentResult", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "Lid/dana/domain/featureconfig/interactor/CheckGoalsBalanceFeature;", "Lid/dana/domain/featureconfig/interactor/CheckGoalsBalanceFeature;", "Lid/dana/domain/saving/interactor/GetSavingEmptyState;", "Lid/dana/domain/saving/interactor/GetSavingEmptyState;", "Lid/dana/domain/saving/interactor/GetSavingSummary;", "Lid/dana/domain/saving/interactor/GetSavingSummary;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/saving/interactor/InitSavingCreate;", "Lid/dana/domain/saving/interactor/InitSavingCreate;", "Lid/dana/savings/contract/SavingContract$View;", "lookAheadTest", "Lid/dana/savings/contract/SavingContract$View;", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/savings/contract/SavingContract$View;Lid/dana/domain/saving/interactor/GetSavingSummary;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;Lid/dana/domain/saving/interactor/InitSavingCreate;Lid/dana/domain/featureconfig/interactor/CheckGoalsBalanceFeature;Lid/dana/domain/saving/interactor/GetSavingEmptyState;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SavingPresenter implements SavingContract.Presenter {
    private final GetUserInfoWithKyc BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetSavingEmptyState MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetSavingSummary PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CheckGoalsBalanceFeature getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final InitSavingCreate KClassImpl$Data$declaredNonStaticMembers$2;
    private final SavingContract.View lookAheadTest;

    @Inject
    public SavingPresenter(SavingContract.View view, GetSavingSummary getSavingSummary, GetUserInfoWithKyc getUserInfoWithKyc, InitSavingCreate initSavingCreate, CheckGoalsBalanceFeature checkGoalsBalanceFeature, GetSavingEmptyState getSavingEmptyState) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSavingSummary, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        Intrinsics.checkNotNullParameter(initSavingCreate, "");
        Intrinsics.checkNotNullParameter(checkGoalsBalanceFeature, "");
        Intrinsics.checkNotNullParameter(getSavingEmptyState, "");
        this.lookAheadTest = view;
        this.PlaceComponentResult = getSavingSummary;
        this.BuiltInFictitiousFunctionClassFactory = getUserInfoWithKyc;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = initSavingCreate;
        this.getAuthRequestContext = checkGoalsBalanceFeature;
        this.MyBillsEntityDataFactory = getSavingEmptyState;
    }

    @Override // id.dana.savings.contract.SavingContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.lookAheadTest.showProgress();
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<SavingSummary, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$getSavingSummary$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingSummary savingSummary) {
                invoke2(savingSummary);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingSummary savingSummary) {
                SavingContract.View view;
                SavingContract.View view2;
                SavingContract.View view3;
                Intrinsics.checkNotNullParameter(savingSummary, "");
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SavingPresenter.this.lookAheadTest;
                view2.MyBillsEntityDataFactory(SavingSummaryModelMapperKt.PlaceComponentResult(savingSummary));
                view3 = SavingPresenter.this.lookAheadTest;
                view3.PlaceComponentResult();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$getSavingSummary$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $BuiltInFictitiousFunctionClassFactory = 0;
            private static int $PlaceComponentResult = 1;
            private static int MyBillsEntityDataFactory = 269894792;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                Unit unit;
                int i = $PlaceComponentResult + 25;
                $BuiltInFictitiousFunctionClassFactory = i % 128;
                if (!(i % 2 != 0)) {
                    invoke2(th);
                    unit = Unit.INSTANCE;
                } else {
                    invoke2(th);
                    unit = Unit.INSTANCE;
                    int i2 = 17 / 0;
                }
                int i3 = $PlaceComponentResult + 51;
                $BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingContract.View view;
                int i = $BuiltInFictitiousFunctionClassFactory + 31;
                $PlaceComponentResult = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                SavingPresenter.BuiltInFictitiousFunctionClassFactory(SavingPresenter.this, th);
                Object[] objArr = new Object[1];
                a(new char[]{65517, 65531, 16, 3, '\b', 1}, TextUtils.getOffsetBefore("", 0) + 275, 6 - ExpandableListView.getPackedPositionGroup(0L), false, Drawable.resolveOpacity(0, 0) + 6, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to get saving summary", th);
                int i3 = $PlaceComponentResult + 3;
                $BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if ((i3 % 2 != 0 ? '2' : '*') != '*') {
                    Object[] objArr2 = null;
                    int length = objArr2.length;
                }
            }

            private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
                int i4;
                A a2 = new A();
                char[] cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i2) {
                    int i5 = $11 + 51;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                    cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                    int i7 = a2.MyBillsEntityDataFactory;
                    cArr2[i7] = (char) (cArr2[i7] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
                    a2.MyBillsEntityDataFactory++;
                    try {
                        int i8 = $10 + 97;
                        $11 = i8 % 128;
                        int i9 = i8 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                if (i3 > 0) {
                    a2.BuiltInFictitiousFunctionClassFactory = i3;
                    char[] cArr3 = new char[i2];
                    System.arraycopy(cArr2, 0, cArr3, 0, i2);
                    System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                    System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                    int i10 = $10 + 21;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                }
                if (z) {
                    char[] cArr4 = new char[i2];
                    a2.MyBillsEntityDataFactory = 0;
                    while (true) {
                        if ((a2.MyBillsEntityDataFactory < i2 ? (char) 30 : 'a') == 'a') {
                            break;
                        }
                        int i12 = $11 + 31;
                        $10 = i12 % 128;
                        if (i12 % 2 != 0) {
                            cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 >>> a2.MyBillsEntityDataFactory) * 1];
                            i4 = a2.MyBillsEntityDataFactory << 1;
                        } else {
                            cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                            i4 = a2.MyBillsEntityDataFactory + 1;
                        }
                        a2.MyBillsEntityDataFactory = i4;
                    }
                    cArr2 = cArr4;
                }
                objArr[0] = new String(cArr2);
            }
        });
    }

    @Override // id.dana.savings.contract.SavingContract.Presenter
    public final void getAuthRequestContext() {
        this.lookAheadTest.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.savings.presenter.SavingPresenter$getKycStatus$1

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            public boolean MyBillsEntityDataFactory;

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                this.MyBillsEntityDataFactory = userInfoResponse.isKycCertified();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                SavingContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                SavingPresenter.getAuthRequestContext(SavingPresenter.this, p0);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onComplete() {
                SavingContract.View view;
                SavingContract.View view2;
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SavingPresenter.this.lookAheadTest;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
            }
        }, GetUserInfoWithKyc.Params.forParams(true));
    }

    @Override // id.dana.savings.contract.SavingContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<SavingCreateInit, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$initSaving$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingCreateInit savingCreateInit) {
                invoke2(savingCreateInit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingCreateInit savingCreateInit) {
                SavingContract.View view;
                SavingContract.View view2;
                Intrinsics.checkNotNullParameter(savingCreateInit, "");
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SavingPresenter.this.lookAheadTest;
                view2.getAuthRequestContext(savingCreateInit);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$initSaving$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $BuiltInFictitiousFunctionClassFactory = 0;
            private static int $KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            private static int MyBillsEntityDataFactory = 269894684;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                $BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                try {
                    try {
                        invoke2(th);
                        Unit unit = Unit.INSTANCE;
                        int i3 = $BuiltInFictitiousFunctionClassFactory + 61;
                        $KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        if ((i3 % 2 == 0 ? (char) 19 : 'A') != 19) {
                            return unit;
                        }
                        int i4 = 14 / 0;
                        return unit;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingContract.View view;
                int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 111;
                $BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                SavingPresenter.getAuthRequestContext(SavingPresenter.this, th);
                Object[] objArr = new Object[1];
                a(new char[]{1, 65517, 65531, 16, 3, '\b'}, 160 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6, false, -TextUtils.lastIndexOf("", '0'), objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to init saving create ", th);
                int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                $BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            }

            private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
                A a2 = new A();
                char[] cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((a2.MyBillsEntityDataFactory < i2 ? (char) 23 : 'Z') != 23) {
                        break;
                    }
                    int i4 = $11 + 107;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                    cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                    int i6 = a2.MyBillsEntityDataFactory;
                    cArr2[i6] = (char) (cArr2[i6] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
                    a2.MyBillsEntityDataFactory++;
                }
                if (!(i3 <= 0)) {
                    try {
                        a2.BuiltInFictitiousFunctionClassFactory = i3;
                        char[] cArr3 = new char[i2];
                        System.arraycopy(cArr2, 0, cArr3, 0, i2);
                        System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                        System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                    } catch (Exception e) {
                        throw e;
                    }
                }
                if (z) {
                    char[] cArr4 = new char[i2];
                    a2.MyBillsEntityDataFactory = 0;
                    int i7 = $10 + 7;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    while (a2.MyBillsEntityDataFactory < i2) {
                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                        a2.MyBillsEntityDataFactory++;
                    }
                    cArr2 = cArr4;
                }
                objArr[0] = new String(cArr2);
            }
        });
    }

    @Override // id.dana.savings.contract.SavingContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$checkGoalsBalanceFeatureEnable$1
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
                SavingContract.View view;
                view = SavingPresenter.this.lookAheadTest;
                view.getAuthRequestContext(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$checkGoalsBalanceFeatureEnable$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $BuiltInFictitiousFunctionClassFactory = 1;
            private static int $getAuthRequestContext = 0;
            private static long KClassImpl$Data$declaredNonStaticMembers$2 = 4360990799332652212L;
            private static char MyBillsEntityDataFactory = 21377;
            private static int PlaceComponentResult = -956812108;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                int i = $BuiltInFictitiousFunctionClassFactory + 31;
                $getAuthRequestContext = i % 128;
                int i2 = i % 2;
                invoke2(th);
                Unit unit = Unit.INSTANCE;
                int i3 = $BuiltInFictitiousFunctionClassFactory + 15;
                $getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? Typography.dollar : (char) 2) != '$') {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return unit;
                }
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingContract.View view;
                SavingContract.View view2;
                int i = $getAuthRequestContext + 97;
                $BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingPresenter.this.lookAheadTest;
                view.getAuthRequestContext(false);
                view2 = SavingPresenter.this.lookAheadTest;
                view2.onError(th.getMessage());
                Object[] objArr = new Object[1];
                a(new char[]{58509, 39541, 62234, 16380, 37232, 30168}, new char[]{50805, 46490, 53453, 13614}, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 11984), new char[]{0, 0, 0, 0}, ViewConfiguration.getMaximumDrawingCacheSize() >> 24, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to check ewallet goals balance feature ", th);
                int i3 = $getAuthRequestContext + 113;
                $BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return;
                }
                int i4 = 19 / 0;
            }

            private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
                E e = new E();
                int length = cArr2.length;
                char[] cArr4 = new char[length];
                int length2 = cArr3.length;
                char[] cArr5 = new char[length2];
                System.arraycopy(cArr2, 0, cArr4, 0, length);
                System.arraycopy(cArr3, 0, cArr5, 0, length2);
                cArr4[0] = (char) (cArr4[0] ^ c);
                cArr5[2] = (char) (cArr5[2] + ((char) i));
                int length3 = cArr.length;
                char[] cArr6 = new char[length3];
                e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                while (true) {
                    if (e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3) {
                        break;
                    }
                    int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                    int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                    e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
                    cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
                    cArr4[i3] = e.MyBillsEntityDataFactory;
                    cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (MyBillsEntityDataFactory ^ 4360990799332652212L)));
                    e.KClassImpl$Data$declaredNonStaticMembers$2++;
                    int i4 = $11 + 5;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                }
                String str = new String(cArr6);
                int i6 = $11 + 41;
                $10 = i6 % 128;
                if (!(i6 % 2 != 0)) {
                    objArr[0] = str;
                    return;
                }
                Object[] objArr2 = null;
                int length4 = objArr2.length;
                objArr[0] = str;
            }
        });
    }

    @Override // id.dana.savings.contract.SavingContract.Presenter
    public final void PlaceComponentResult() {
        this.lookAheadTest.showProgress();
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<SavingEmptyState, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$getSavingEmptyState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingEmptyState savingEmptyState) {
                invoke2(savingEmptyState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingEmptyState savingEmptyState) {
                SavingContract.View view;
                SavingContract.View view2;
                SavingContract.View view3;
                Intrinsics.checkNotNullParameter(savingEmptyState, "");
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SavingPresenter.this.lookAheadTest;
                view2.PlaceComponentResult(SavingEmptyStateModelMapperKt.MyBillsEntityDataFactory(savingEmptyState));
                view3 = SavingPresenter.this.lookAheadTest;
                view3.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingPresenter$getSavingEmptyState$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $BuiltInFictitiousFunctionClassFactory = 0;
            private static int $getErrorConfigVersion = 1;
            private static char KClassImpl$Data$declaredNonStaticMembers$2 = 27021;
            private static char MyBillsEntityDataFactory = 55259;
            private static char PlaceComponentResult = 26793;
            private static char getAuthRequestContext = 31092;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                int i = $getErrorConfigVersion + 99;
                $BuiltInFictitiousFunctionClassFactory = i % 128;
                char c = i % 2 != 0 ? Typography.dollar : (char) 29;
                invoke2(th);
                Unit unit = Unit.INSTANCE;
                if (c == '$') {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingContract.View view;
                SavingContract.View view2;
                SavingContract.View view3;
                int i = $BuiltInFictitiousFunctionClassFactory + 5;
                $getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SavingPresenter.this.lookAheadTest;
                view2.onError(th.getMessage());
                view3 = SavingPresenter.this.lookAheadTest;
                view3.MyBillsEntityDataFactory();
                Object[] objArr = new Object[1];
                a(6 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{42720, 16558, 8965, 35820, 20883, 54601}, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to get saving empty state config", th);
                int i3 = $getErrorConfigVersion + 57;
                $BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                C c = new C();
                char[] cArr2 = new char[cArr.length];
                c.BuiltInFictitiousFunctionClassFactory = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '\f' : '7') != '7') {
                        cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                        cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                        int i2 = 58224;
                        int i3 = 0;
                        while (true) {
                            if (!(i3 < 16)) {
                                break;
                            }
                            int i4 = $10 + 25;
                            $11 = i4 % 128;
                            int i5 = i4 % 2;
                            cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                            cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                            i2 -= 40503;
                            i3++;
                            int i6 = $10 + 11;
                            $11 = i6 % 128;
                            int i7 = i6 % 2;
                        }
                        cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                        cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                        c.BuiltInFictitiousFunctionClassFactory += 2;
                    } else {
                        objArr[0] = new String(cArr2, 0, i);
                        return;
                    }
                }
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SavingPresenter savingPresenter, Throwable th) {
        UiTextModel.StringResource stringResource;
        if (th instanceof NoInternetConnectionException) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            stringResource = new UiTextModel.DynamicString(message);
        } else {
            ?? r3 = 0;
            stringResource = new UiTextModel.StringResource(R.string.saving_unable_to_load_error_message, r3, 2, r3);
        }
        savingPresenter.lookAheadTest.getAuthRequestContext(stringResource);
        savingPresenter.lookAheadTest.PlaceComponentResult();
        savingPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(th, "dana.saving.summary.consult", stringResource, "Goals Summary Consult");
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    public static final /* synthetic */ void getAuthRequestContext(SavingPresenter savingPresenter, Throwable th) {
        if (th instanceof NoInternetConnectionException) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            UiTextModel.DynamicString dynamicString = new UiTextModel.DynamicString(message);
            savingPresenter.lookAheadTest.PlaceComponentResult(dynamicString);
            savingPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(th, "dana.saving.add.init", dynamicString, "Goals Add Init");
            return;
        }
        int i = 2;
        ?? r4 = 0;
        if (th instanceof GoalsApiException.ReachMaximum) {
            UiTextModel.StringResource stringResource = new UiTextModel.StringResource(R.string.error_saving_exceed_max, r4, i, r4);
            savingPresenter.lookAheadTest.getAuthRequestContext();
            savingPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(th, "dana.saving.add.init", stringResource, "Goals Add Init");
            return;
        }
        UiTextModel.StringResource stringResource2 = new UiTextModel.StringResource(R.string.saving_unable_to_create_error_message, r4, i, r4);
        savingPresenter.lookAheadTest.PlaceComponentResult(stringResource2);
        savingPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(th, "dana.saving.add.init", stringResource2, "Goals Add Init");
    }
}
