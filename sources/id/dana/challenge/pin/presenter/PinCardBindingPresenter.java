package id.dana.challenge.pin.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.model.CashierPayParamRequestExtKt;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.model.Attribute;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001d\u0012\u0006\u0010\r\u001a\u00020\u001f\u0012\u0006\u0010\u0010\u001a\u00020!\u0012\u0006\u0010\u0011\u001a\u00020\u001b\u0012\u0006\u0010\u0013\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ!\u0010\u000e\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u000e\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0012J?\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0005\u0010\u0014JA\u0010\u000e\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u000e\u0010\u0016J7\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0003\u0010\u0017J#\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\b\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\n\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0014\u0010\u000e\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 R\u0014\u0010\u0003\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0014\u0010\b\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$"}, d2 = {"Lid/dana/challenge/pin/presenter/PinCardBindingPresenter;", "Lid/dana/challenge/pin/AbstractPinContract$CardBindingPinPresenter;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "Lid/dana/cardbinding/model/CashierPayParamModel;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cardbinding/model/CashierPayParamModel;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Z)V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p4", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Landroid/app/Activity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/cashier/domain/interactor/PayCashier;", "Lid/dana/cashier/domain/interactor/PayCashier;", "Lid/dana/cashier/domain/interactor/PayQueryCashier;", "Lid/dana/cashier/domain/interactor/PayQueryCashier;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "<init>", "(Landroid/content/Context;Lid/dana/cashier/domain/interactor/PayCashier;Lid/dana/cashier/domain/interactor/PayQueryCashier;Lid/dana/cashier/mapper/CashierPayModelMapper;Lid/dana/challenge/pin/AbstractPinContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PinCardBindingPresenter implements AbstractPinContract.CardBindingPinPresenter {
    private final AbstractPinContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PayCashier getAuthRequestContext;
    private final PayQueryCashier MyBillsEntityDataFactory;
    private final CashierPayModelMapper PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        AbstractPinContract.Presenter.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
        AbstractPinContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, Bundle p1) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Trust2RiskLoginModel trust2RiskLoginModel) {
        AbstractPinContract.Presenter.CC.getErrorConfigVersion();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        AbstractPinContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        AbstractPinContract.Presenter.CC.moveToNextValue();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void MyBillsEntityDataFactory(String str, String str2) {
        AbstractPinContract.Presenter.CC.getAuthRequestContext();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1, String p2, String p3) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void PlaceComponentResult(String p0, String p1, boolean p2, String p3, String p4) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str) {
        AbstractPinContract.Presenter.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, String p2, Boolean p3, Activity p4) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, String p2, boolean p3) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str, String str2, boolean z, boolean z2) {
        AbstractPinContract.Presenter.CC.PlaceComponentResult();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, boolean p1) {
    }

    @Inject
    public PinCardBindingPresenter(Context context, PayCashier payCashier, PayQueryCashier payQueryCashier, CashierPayModelMapper cashierPayModelMapper, AbstractPinContract.View view) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(payCashier, "");
        Intrinsics.checkNotNullParameter(payQueryCashier, "");
        Intrinsics.checkNotNullParameter(cashierPayModelMapper, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.getAuthRequestContext = payCashier;
        this.MyBillsEntityDataFactory = payQueryCashier;
        this.PlaceComponentResult = cashierPayModelMapper;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.CardBindingPinPresenter
    public final void BuiltInFictitiousFunctionClassFactory(CashierPayParamModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.getAuthRequestContext.execute(PayCashier.Params.Companion.createPayCashierRequest$default(PayCashier.Params.INSTANCE, CashierPayParamRequestExtKt.BuiltInFictitiousFunctionClassFactory(p0.BuiltInFictitiousFunctionClassFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.lookAheadTest, p0.scheduleImpl), false, null, 4, null), new Function1<CashierPay, Unit>() { // from class: id.dana.challenge.pin.presenter.PinCardBindingPresenter$getCashierPay$1
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
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                CashierPayModelMapper cashierPayModelMapper;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                view = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                cashierPayModelMapper = PinCardBindingPresenter.this.PlaceComponentResult;
                view2.BuiltInFictitiousFunctionClassFactory(cashierPayModelMapper.apply(cashierPay), false);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinCardBindingPresenter$getCashierPay$2
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
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                Context context;
                AbstractPinContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                if (th instanceof NetworkException) {
                    view3 = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    NetworkException networkException = (NetworkException) th;
                    view3.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
                    return;
                }
                view2 = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                context = PinCardBindingPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
            }
        });
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.CardBindingPinPresenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final CashierPayParamModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.MyBillsEntityDataFactory.dispose();
        this.MyBillsEntityDataFactory.execute(PayQueryCashier.Params.Companion.createPayQueryRequest$default(PayQueryCashier.Params.INSTANCE, p0.BuiltInFictitiousFunctionClassFactory, p0.lookAheadTest, null, null, p0.NetworkUserEntityData$$ExternalSyntheticLambda0, false, null, null, p0.getPlaceComponentResult(), null, null, 1740, null), new Function1<CashierPay, Unit>() { // from class: id.dana.challenge.pin.presenter.PinCardBindingPresenter$getPayQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                AbstractPinContract.View view3;
                AbstractPinContract.View view4;
                CashierPayModelMapper cashierPayModelMapper;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                Attribute attributes = cashierPay.getAttributes();
                PinCardBindingPresenter pinCardBindingPresenter = PinCardBindingPresenter.this;
                CashierPayParamModel cashierPayParamModel = p0;
                if (attributes == null) {
                    view = pinCardBindingPresenter.BuiltInFictitiousFunctionClassFactory;
                    view.dismissProgress();
                    view2 = pinCardBindingPresenter.BuiltInFictitiousFunctionClassFactory;
                    view2.onError(null);
                } else if (!Intrinsics.areEqual(attributes.getQueryAgain(), Boolean.TRUE)) {
                    view3 = pinCardBindingPresenter.BuiltInFictitiousFunctionClassFactory;
                    view3.dismissProgress();
                    view4 = pinCardBindingPresenter.BuiltInFictitiousFunctionClassFactory;
                    cashierPayModelMapper = pinCardBindingPresenter.PlaceComponentResult;
                    view4.BuiltInFictitiousFunctionClassFactory(cashierPayModelMapper.apply(cashierPay), true);
                } else {
                    cashierPayParamModel.PlaceComponentResult = true;
                    pinCardBindingPresenter.KClassImpl$Data$declaredNonStaticMembers$2(cashierPayParamModel);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinCardBindingPresenter$getPayQuery$2
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
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                Context context;
                AbstractPinContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                if (th instanceof NetworkException) {
                    view3 = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    NetworkException networkException = (NetworkException) th;
                    view3.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
                    return;
                }
                view2 = PinCardBindingPresenter.this.BuiltInFictitiousFunctionClassFactory;
                context = PinCardBindingPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
