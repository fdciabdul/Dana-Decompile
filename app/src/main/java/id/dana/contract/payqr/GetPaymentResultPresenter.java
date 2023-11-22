package id.dana.contract.payqr;

import android.text.TextUtils;
import dagger.Lazy;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.globalnetwork.interactor.ClearAllPaymentCodes;
import id.dana.domain.globalnetwork.interactor.GetUniPaymentResult;
import id.dana.domain.model.f2fpay.F2FPaymentResultStatus;
import id.dana.domain.model.f2fpay.response.F2FPayResultResponse;
import id.dana.domain.qrpay.interactor.GetPaymentResult;
import id.dana.tracker.mixpanel.RegistrationEvent;
import id.dana.utils.BalanceUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class GetPaymentResultPresenter implements GetPaymentResultContract.Presenter {
    final Lazy<GetUniPaymentResult> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<GetPaymentResult> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<GetPaymentResultContract.View> MyBillsEntityDataFactory;
    private final Lazy<ClearAllPaymentCodes> PlaceComponentResult;

    @Inject
    public GetPaymentResultPresenter(Lazy<GetPaymentResultContract.View> lazy, Lazy<GetPaymentResult> lazy2, Lazy<GetUniPaymentResult> lazy3, Lazy<ClearAllPaymentCodes> lazy4) {
        this.MyBillsEntityDataFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        this.PlaceComponentResult = lazy4;
    }

    @Override // id.dana.contract.payqr.GetPaymentResultContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.payqr.GetPaymentResultPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetPaymentResultPresenter.this.MyBillsEntityDataFactory((F2FPayResultResponse) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.payqr.GetPaymentResultPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetPaymentResultPresenter.this.PlaceComponentResult((Throwable) obj);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.contract.payqr.GetPaymentResultContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.get().execute(Unit.INSTANCE, new Function1() { // from class: id.dana.contract.payqr.GetPaymentResultPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final GetPaymentResultPresenter getPaymentResultPresenter = GetPaymentResultPresenter.this;
                if (((Boolean) obj).booleanValue()) {
                    getPaymentResultPresenter.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.payqr.GetPaymentResultPresenter$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            GetPaymentResultPresenter.this.MyBillsEntityDataFactory((F2FPayResultResponse) obj2);
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.contract.payqr.GetPaymentResultPresenter$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            GetPaymentResultPresenter.this.PlaceComponentResult((Throwable) obj2);
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.payqr.GetPaymentResultPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetPaymentResultPresenter getPaymentResultPresenter = GetPaymentResultPresenter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.QRCODE_PAY_RESULT_PREFIX);
                sb.append(getPaymentResultPresenter.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), (Throwable) obj);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(F2FPayResultResponse f2FPayResultResponse) {
        if (f2FPayResultResponse == null || f2FPayResultResponse.getOrderInfo() == null || f2FPayResultResponse.getStatus() == null) {
            return;
        }
        String cashierUrl = f2FPayResultResponse.getOrderInfo().getCashierUrl();
        String tradeNo = f2FPayResultResponse.getOrderInfo().getTradeNo();
        String merchantId = f2FPayResultResponse.getOrderInfo().getMerchantId();
        int i = AnonymousClass1.MyBillsEntityDataFactory[f2FPayResultResponse.getStatus().ordinal()];
        if (i == 1) {
            GetPaymentResultContract.View view = this.MyBillsEntityDataFactory.get();
            if (!TextUtils.isEmpty(cashierUrl)) {
                cashierUrl = UrlUtil.PlaceComponentResult(cashierUrl, "disableChange=true");
            }
            view.PlaceComponentResult(cashierUrl, tradeNo, merchantId);
        } else if (i != 2) {
            if (i == 3) {
                String payAmount = f2FPayResultResponse.getOrderInfo().getPayAmount();
                this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2(payAmount != null ? BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(payAmount) : RegistrationEvent.ProfilePhotoSource.NO_ANSWER, cashierUrl, tradeNo, merchantId);
            }
        } else {
            this.MyBillsEntityDataFactory.get().BuiltInFictitiousFunctionClassFactory(cashierUrl, tradeNo, f2FPayResultResponse.getOrderInfo().getStateReasonDesc(), merchantId);
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.QRCODE_PAY_RESULT_PREFIX);
            sb.append(getClass().getName());
            sb.append("Failure:cashierUrl=");
            sb.append(cashierUrl);
            sb.append("tradeNo=");
            sb.append(tradeNo);
            DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
        }
    }

    /* renamed from: id.dana.contract.payqr.GetPaymentResultPresenter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[F2FPaymentResultStatus.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[F2FPaymentResultStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[F2FPaymentResultStatus.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[F2FPaymentResultStatus.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(Throwable th) {
        this.MyBillsEntityDataFactory.get().onError(th.getMessage());
        StringBuilder sb = new StringBuilder();
        sb.append(DanaLogConstants.Prefix.QRCODE_PAY_RESULT_PREFIX);
        sb.append(getClass().getName());
        sb.append(":onError");
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.PlaceComponentResult.get().dispose();
    }
}
