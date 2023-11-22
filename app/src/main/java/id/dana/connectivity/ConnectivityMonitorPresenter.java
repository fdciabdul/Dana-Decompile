package id.dana.connectivity;

import dagger.Lazy;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.connectivity.ConnectivityMonitorContract;
import id.dana.data.qrpay.constants.F2fPayTracker;
import id.dana.domain.connectionbar.interactor.GetIsFeatureConnectionBarWithSignalOn;
import id.dana.domain.core.usecase.NoParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\t"}, d2 = {"Lid/dana/connectivity/ConnectivityMonitorPresenter;", "Lid/dana/connectivity/ConnectivityMonitorContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/connectionbar/interactor/GetIsFeatureConnectionBarWithSignalOn;", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/connectivity/ConnectivityMonitorContract$View;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectivityMonitorPresenter implements ConnectivityMonitorContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<ConnectivityMonitorContract.View> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<GetIsFeatureConnectionBarWithSignalOn> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public ConnectivityMonitorPresenter(Lazy<ConnectivityMonitorContract.View> lazy, Lazy<GetIsFeatureConnectionBarWithSignalOn> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.MyBillsEntityDataFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
    }

    @Override // id.dana.connectivity.ConnectivityMonitorContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.connectivity.ConnectivityMonitorPresenter$getIsFeatureConnectionBarWithSignalOn$1
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
                Lazy lazy;
                Lazy lazy2;
                if (z) {
                    lazy2 = ConnectivityMonitorPresenter.this.MyBillsEntityDataFactory;
                    ((ConnectivityMonitorContract.View) lazy2.get()).getAuthRequestContext();
                    return;
                }
                lazy = ConnectivityMonitorPresenter.this.MyBillsEntityDataFactory;
                ((ConnectivityMonitorContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.connectivity.ConnectivityMonitorPresenter$getIsFeatureConnectionBarWithSignalOn$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = ConnectivityMonitorPresenter.this.MyBillsEntityDataFactory;
                ((ConnectivityMonitorContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("f2fpay", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "f2fpay");
                Intrinsics.checkNotNullParameter(F2fPayTracker.EVENT_NAME, "");
                Intrinsics.checkNotNullParameter(F2fPayTracker.PAYMENT_CODE_IS_EMPTY, "");
                authRequestContext.getAuthRequestContext.setCustomKey(F2fPayTracker.EVENT_NAME, F2fPayTracker.PAYMENT_CODE_IS_EMPTY);
                String simpleName = ConnectivityMonitorPresenter.this.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "");
                Intrinsics.checkNotNullParameter(F2fPayTracker.CLASS_NAME, "");
                Intrinsics.checkNotNullParameter(simpleName, "");
                authRequestContext.getAuthRequestContext.setCustomKey(F2fPayTracker.CLASS_NAME, simpleName);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}
