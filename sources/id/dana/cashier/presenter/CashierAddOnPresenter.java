package id.dana.cashier.presenter;

import android.content.Context;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.domain.interactor.GetCashierAddOnInfo;
import id.dana.cashier.domain.model.CashierAddOnInfo;
import id.dana.cashier.model.CashierAddOnModalContentModelKt;
import id.dana.cashier.model.CashierAddOnModalTooltipModelKt;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u0004\u001a\u00020\u0012\u0012\u0006\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/cashier/presenter/CashierAddOnPresenter;", "Lid/dana/cashier/CashierAddOnContract$Presenter;", "", "p0", "p1", "p2", "", "p3", "p4", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/cashier/domain/interactor/GetCashierAddOnInfo;", "getAuthRequestContext", "Lid/dana/cashier/domain/interactor/GetCashierAddOnInfo;", "MyBillsEntityDataFactory", "Lid/dana/cashier/CashierAddOnContract$View;", "PlaceComponentResult", "Lid/dana/cashier/CashierAddOnContract$View;", "<init>", "(Lid/dana/cashier/domain/interactor/GetCashierAddOnInfo;Lid/dana/cashier/CashierAddOnContract$View;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnPresenter implements CashierAddOnContract.Presenter {
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CashierAddOnContract.View getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetCashierAddOnInfo MyBillsEntityDataFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public CashierAddOnPresenter(GetCashierAddOnInfo getCashierAddOnInfo, CashierAddOnContract.View view, Context context) {
        Intrinsics.checkNotNullParameter(getCashierAddOnInfo, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = getCashierAddOnInfo;
        this.getAuthRequestContext = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.cashier.CashierAddOnContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, boolean p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p4, "");
        this.getAuthRequestContext.showProgress();
        this.MyBillsEntityDataFactory.execute(new GetCashierAddOnInfo.Params(p0, p1, p2, p3, p4), new Function1<CashierAddOnInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierAddOnPresenter$getCashierAddOnInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierAddOnInfo cashierAddOnInfo) {
                invoke2(cashierAddOnInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierAddOnInfo cashierAddOnInfo) {
                CashierAddOnContract.View view;
                CashierAddOnContract.View view2;
                CashierAddOnContract.View view3;
                Intrinsics.checkNotNullParameter(cashierAddOnInfo, "");
                view = CashierAddOnPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                if (cashierAddOnInfo instanceof CashierAddOnInfo.FromApi) {
                    view3 = CashierAddOnPresenter.this.getAuthRequestContext;
                    CashierAddOnInfo.FromApi fromApi = (CashierAddOnInfo.FromApi) cashierAddOnInfo;
                    view3.KClassImpl$Data$declaredNonStaticMembers$2(CashierAddOnModalTooltipModelKt.BuiltInFictitiousFunctionClassFactory(fromApi.getCashierAddonModalTooltip()), CashierAddOnModalContentModelKt.BuiltInFictitiousFunctionClassFactory(fromApi.getCashierAddOnModalContent()));
                } else if (cashierAddOnInfo instanceof CashierAddOnInfo.FromCdn) {
                    view2 = CashierAddOnPresenter.this.getAuthRequestContext;
                    CashierAddOnInfo.FromCdn fromCdn = (CashierAddOnInfo.FromCdn) cashierAddOnInfo;
                    view2.BuiltInFictitiousFunctionClassFactory(fromCdn.getImage(), fromCdn.getTitle(), fromCdn.getContent());
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierAddOnPresenter$getCashierAddOnInfo$2
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
                CashierAddOnContract.View view;
                CashierAddOnContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = CashierAddOnPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = CashierAddOnPresenter.this.getAuthRequestContext;
                context = CashierAddOnPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
            }
        });
    }
}
