package id.dana.cashier.tracker;

import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.tracker.PaymentConfirmationOpenTrackerParams;
import id.dana.cashier.model.tracker.PaymentExecutionTrackerParams;
import id.dana.cashier.model.tracker.PaymentResultTrackerParams;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0003H&J5\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H&¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0003H&J\u0012\u0010'\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Lid/dana/cashier/tracker/CashierAnalyticTracker;", "", "paymentSelectedMethods", "", "getPaymentSelectedMethods", "()Ljava/lang/String;", "setPaymentSelectedMethods", "(Ljava/lang/String;)V", "trackDisplayedError", "", "throwable", "", "operationType", "displayedMessage", "source", "trackNpsSurveyShow", "trackNpsSurveySubmit", "trackPaymentBannerOpen", "bannerName", "trackPaymentConfirmationOpen", "params", "Lid/dana/cashier/model/tracker/PaymentConfirmationOpenTrackerParams;", "trackPaymentExecution", "Lid/dana/cashier/model/tracker/PaymentExecutionTrackerParams;", "trackPaymentResult", "Lid/dana/cashier/model/tracker/PaymentResultTrackerParams;", "trackPaymentResultAction", "actionType", "trackPaymentRiskChallenge", CashierKeyParams.CASHIER_ORDER_ID, "riskType", "isShowPin", "", "isFaceVerification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "trackPaymentSelectMethod", InvoiceConstant.PAYMENT_METHOD, "Lid/dana/cashier/model/CashierPayMethodModel;", "trackPaymentTopupAndPayOpen", "trackPaymentTryAgainAction", "trackSmartpayOffering", "activationResult", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierAnalyticTracker {
    void BuiltInFictitiousFunctionClassFactory(String str);

    void BuiltInFictitiousFunctionClassFactory(String str, String str2, Boolean bool);

    void KClassImpl$Data$declaredNonStaticMembers$2();

    void KClassImpl$Data$declaredNonStaticMembers$2(String str);

    void KClassImpl$Data$declaredNonStaticMembers$2(String str, CashierPayMethodModel cashierPayMethodModel);

    void MyBillsEntityDataFactory(PaymentExecutionTrackerParams paymentExecutionTrackerParams);

    void MyBillsEntityDataFactory(String str);

    void PlaceComponentResult();

    void PlaceComponentResult(PaymentConfirmationOpenTrackerParams paymentConfirmationOpenTrackerParams);

    void PlaceComponentResult(PaymentResultTrackerParams paymentResultTrackerParams);

    void PlaceComponentResult(String str);

    void getAuthRequestContext(String str);

    void lookAheadTest(String str);

    /* renamed from: id.dana.cashier.tracker.CashierAnalyticTracker$-CC */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierAnalyticTracker cashierAnalyticTracker, String str, String str2, Boolean bool, int i) {
            if ((i & 8) != 0) {
                bool = null;
            }
            cashierAnalyticTracker.BuiltInFictitiousFunctionClassFactory(str, str2, bool);
        }
    }
}
