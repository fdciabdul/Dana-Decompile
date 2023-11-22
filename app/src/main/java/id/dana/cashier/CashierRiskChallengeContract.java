package id.dana.cashier;

import android.os.Bundle;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.model.CashierAgreementModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierRiskChallengeContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierRiskChallengeContract {

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\b\u0010\u0010J'\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0004\b\b\u0010\u0014J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015H&¢\u0006\u0004\b\n\u0010\u0016J'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierRiskChallengeContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Ljava/lang/String;)V", "Lid/dana/cashier/helper/CashierErrorState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/helper/CashierErrorState;)V", "MyBillsEntityDataFactory", "getErrorConfigVersion", "Landroid/os/Bundle;", "PlaceComponentResult", "(Landroid/os/Bundle;)V", "Lid/dana/cashier/model/CashierAgreementModel;", "(Lid/dana/cashier/model/CashierAgreementModel;)V", "", "p1", "p2", "(II)V", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()V", "initRecordTimeStamp", "DatabaseTableConfigUtil"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void DatabaseTableConfigUtil();

        void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2);

        void KClassImpl$Data$declaredNonStaticMembers$2(CashierErrorState p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(CashierAgreementModel p0);

        void MyBillsEntityDataFactory(CashierErrorState p0);

        void MyBillsEntityDataFactory(String p0, String p1, Throwable p2);

        void NetworkUserEntityData$$ExternalSyntheticLambda0(String p0);

        void NetworkUserEntityData$$ExternalSyntheticLambda1();

        void PlaceComponentResult(Bundle p0);

        void getAuthRequestContext(int i, int i2);

        void getErrorConfigVersion(CashierErrorState p0);

        void initRecordTimeStamp();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J*\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierRiskChallengeContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "createCashierAgreement", "", CashierKeyParams.CASHIER_ORDER_ID, "", "phoneNumber", "validateData", "receiveSms", "sendBankOtp", "sendBankOtpModel", "Lid/dana/cashier/model/SendBankOtpModel;", "isOneKlik", "", SummaryActivity.FIRST_STATE_SHARE_FEED, "sendOneklikOtp", "sendOtp", "sendStrategy", "merchantId", "isSendMoney", "verifyBankPhoneOtp", "verifyOtpOneklik", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(SendBankOtpModel sendBankOtpModel, boolean z, boolean z2);

        /* renamed from: id.dana.cashier.CashierRiskChallengeContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
        }
    }
}
