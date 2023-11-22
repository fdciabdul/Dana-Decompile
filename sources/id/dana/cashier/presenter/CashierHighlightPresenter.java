package id.dana.cashier.presenter;

import dagger.Lazy;
import id.dana.cashier.CashierHighlightContract;
import id.dana.cashier.domain.interactor.GetCashierHighlightCache;
import id.dana.cashier.domain.interactor.GetCashierHighlightConfig;
import id.dana.cashier.domain.interactor.GetHighlightNewInstId;
import id.dana.cashier.domain.interactor.SaveHighlightNewInstId;
import id.dana.cashier.domain.interactor.SaveHighlightTimeShown;
import id.dana.cashier.domain.interactor.SaveHighlightVersion;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bk\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\t\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\t\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\t\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\t\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\t¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\f"}, d2 = {"Lid/dana/cashier/presenter/CashierHighlightPresenter;", "Lid/dana/cashier/CashierHighlightContract$Presenter;", "", "onDestroy", "()V", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "Ldagger/Lazy;", "Lid/dana/cashier/domain/interactor/GetCashierHighlightCache;", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/cashier/domain/interactor/GetCashierHighlightConfig;", "MyBillsEntityDataFactory", "Lid/dana/cashier/domain/interactor/GetHighlightNewInstId;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/domain/interactor/SaveHighlightNewInstId;", "getErrorConfigVersion", "Lid/dana/cashier/domain/interactor/SaveHighlightTimeShown;", "Lid/dana/cashier/domain/interactor/SaveHighlightVersion;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/cashier/CashierHighlightContract$View;", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierHighlightPresenter implements CashierHighlightContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<SaveHighlightTimeShown> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Lazy<GetHighlightNewInstId> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Lazy<SaveHighlightVersion> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<CashierHighlightContract.View> lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy<GetCashierHighlightConfig> MyBillsEntityDataFactory;
    public final Lazy<GetCashierHighlightCache> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<SaveHighlightNewInstId> PlaceComponentResult;

    @Inject
    public CashierHighlightPresenter(Lazy<GetCashierHighlightConfig> lazy, Lazy<GetCashierHighlightCache> lazy2, Lazy<GetHighlightNewInstId> lazy3, Lazy<SaveHighlightVersion> lazy4, Lazy<SaveHighlightNewInstId> lazy5, Lazy<SaveHighlightTimeShown> lazy6, Lazy<CashierHighlightContract.View> lazy7) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        this.MyBillsEntityDataFactory = lazy;
        this.getAuthRequestContext = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy4;
        this.PlaceComponentResult = lazy5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy6;
        this.lookAheadTest = lazy7;
    }

    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.get().execute(p0, new Function1<Boolean, Unit>() { // from class: id.dana.cashier.presenter.CashierHighlightPresenter$saveCashierHighlightNewInstId$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierHighlightPresenter$saveCashierHighlightNewInstId$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierHighlightNewShown]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}
