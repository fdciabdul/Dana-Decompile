package id.dana.cashier.presenter;

import android.content.Context;
import id.dana.cashier.PayResultContract;
import id.dana.cashier.domain.interactor.GetQueryPayOption;
import id.dana.cashier.domain.interactor.ProcessEventCheckoutFinish;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.utils.ErrorUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u001b\u0012\u0006\u0010\f\u001a\u00020\u0010\u0012\u0006\u0010\r\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\u000e\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001c"}, d2 = {"Lid/dana/cashier/presenter/PayResultPresenter;", "Lid/dana/cashier/PayResultContract$Presenter;", "", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/util/List;)V", "onDestroy", "()V", "", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/cashier/mapper/CashierPayMethodModelMapper;", "PlaceComponentResult", "Lid/dana/cashier/mapper/CashierPayMethodModelMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/cashier/domain/interactor/GetQueryPayOption;", "Lid/dana/cashier/domain/interactor/GetQueryPayOption;", "Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish;", "getAuthRequestContext", "Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish;", "Lid/dana/cashier/PayResultContract$View;", "Lid/dana/cashier/PayResultContract$View;", "p4", "<init>", "(Landroid/content/Context;Lid/dana/cashier/PayResultContract$View;Lid/dana/cashier/mapper/CashierPayMethodModelMapper;Lid/dana/cashier/domain/interactor/GetQueryPayOption;Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayResultPresenter implements PayResultContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final PayResultContract.View MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetQueryPayOption BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CashierPayMethodModelMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final ProcessEventCheckoutFinish getAuthRequestContext;

    @Inject
    public PayResultPresenter(Context context, PayResultContract.View view, CashierPayMethodModelMapper cashierPayMethodModelMapper, GetQueryPayOption getQueryPayOption, ProcessEventCheckoutFinish processEventCheckoutFinish) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodModelMapper, "");
        Intrinsics.checkNotNullParameter(getQueryPayOption, "");
        Intrinsics.checkNotNullParameter(processEventCheckoutFinish, "");
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierPayMethodModelMapper;
        this.BuiltInFictitiousFunctionClassFactory = getQueryPayOption;
        this.getAuthRequestContext = processEventCheckoutFinish;
    }

    @Override // id.dana.cashier.PayResultContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(GetQueryPayOption.Params.INSTANCE.createQueryPayOptionRequest(p0, p1), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.PayResultPresenter$getQueryPayOption$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                PayResultContract.View view;
                CashierPayMethodModelMapper cashierPayMethodModelMapper;
                List<CashierPayMethodModel> list;
                AttributeModel attributeModel;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                view = PayResultPresenter.this.MyBillsEntityDataFactory;
                cashierPayMethodModelMapper = PayResultPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                CashierCheckoutModel apply = cashierPayMethodModelMapper.KClassImpl$Data$declaredNonStaticMembers$2.apply(cashierPay);
                if (apply == null || (attributeModel = apply.getAuthRequestContext) == null) {
                    list = null;
                } else {
                    Intrinsics.checkNotNullParameter(attributeModel, "");
                    ArrayList arrayList = new ArrayList();
                    if (attributeModel.W.isEmpty()) {
                        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"BALANCE", "CREDIT_CARD", "DEBIT_CARD", "DIRECT_DEBIT_DEBIT_CARD", "DIRECT_DEBIT_CREDIT_CARD", "NET_BANKING"});
                        Intrinsics.checkNotNullParameter(listOf, "");
                        attributeModel.W = listOf;
                    }
                    cashierPayMethodModelMapper.PlaceComponentResult(attributeModel, arrayList, false);
                    CashierPayMethodModelMapper.MyBillsEntityDataFactory(attributeModel, arrayList, true);
                    list = cashierPayMethodModelMapper.getAuthRequestContext(arrayList, "");
                }
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                view.KClassImpl$Data$declaredNonStaticMembers$2(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.PayResultPresenter$getQueryPayOption$2
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
                PayResultContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = PayResultPresenter.this.MyBillsEntityDataFactory;
                context = PayResultPresenter.this.PlaceComponentResult;
                view.onError(ErrorUtil.PlaceComponentResult(th, context));
            }
        });
    }

    @Override // id.dana.cashier.PayResultContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getAuthRequestContext.execute(ProcessEventCheckoutFinish.Params.INSTANCE.createCheckoutFinishEntity(true, str, str2, str3), new Function1<Unit, Unit>() { // from class: id.dana.cashier.presenter.PayResultPresenter$processEventCheckoutFinish$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.PayResultPresenter$processEventCheckoutFinish$2
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

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
    }
}
