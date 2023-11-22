package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.PaylaterOnboardingContentModel;
import id.dana.cashier.model.QueryInstallmentModel;
import id.dana.cashier.model.QueryInstallmentRequestModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierPayLaterContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierPayLaterContract {

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0003H&J \u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u000bH&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010 \u001a\u00020\u0003H&J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0016\u0010\"\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierPayLaterContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "dismissShimmerPayMethod", "", "showPayMethods", "", "", "onErrorConsultAgreement", "cacheCooldownCount", "", "isFromSelectPayMethod", "", "consultAgreementThrowable", "", "onErrorGetLoanRegistrationInfo", "errorMsg", "throwable", "operationType", "source", "onErrorQueryInstallment", "onSuccessCheckPayMethodDefaultOption", "cashierPayMethodModels", "Lid/dana/cashier/model/CashierPayMethodModel;", "isFromQueryInstallmentError", "onSuccessGetLoanRegistrationInfo", "result", "onSuccessGetPaylaterCicilOnboardingContent", "paylaterOnboardingContentModel", "Lid/dana/cashier/model/PaylaterOnboardingContentModel;", "onSuccessGetQueryInstallment", "queryInstallmentModel", "Lid/dana/cashier/model/QueryInstallmentModel;", "onSuccessPaylaterCicilCacheCooldown", "showOnboardingDialogShimmer", "showShimmerPayMethod", "hidePayMethods", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(QueryInstallmentModel queryInstallmentModel, Throwable th);

        void BuiltInFictitiousFunctionClassFactory(List<String> list);

        void KClassImpl$Data$declaredNonStaticMembers$2(int i, boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str, Throwable th, String str2, String str3);

        void PlaceComponentResult(int i, boolean z, Throwable th);

        void getAuthRequestContext(PaylaterOnboardingContentModel paylaterOnboardingContentModel, int i, boolean z);

        void getAuthRequestContext(List<? extends CashierPayMethodModel> list);

        /* renamed from: id.dana.cashier.CashierPayLaterContract$View$-CC */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH&J.\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0003H&J2\u0010\u0012\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\bH&J\u001c\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&JH\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\nH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\rH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierPayLaterContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "checkPayMethodDefaultOption", "", "cashierPayMethodModels", "", "Lid/dana/cashier/model/CashierPayMethodModel;", "defaultOption", "", "isFromQueryInstallmentError", "", "checkPaylaterCicilRegistrationCacheCooldown", "maxShowRegistrationCount", "", "delayRegistrationTime", "tncSpaceCode", "onboardingImageUrl", "clearCachePayLaterLoanWhitelist", "consultAgreement", "cacheCooldownCount", "isFromSelectPayMethod", "getLoanRegistrationInfo", "agreementKey", "getQueryInstallment", "queryInstallmentRequestModel", "Lid/dana/cashier/model/QueryInstallmentRequestModel;", "mixPaySelectedPayMethod", "refreshQueryInstallment", "selectedAddOnId", "", "selectedCouponIds", "isInMixPayMode", "savePaylaterCicilRegistrationCacheCooldownCount", "cooldownCount", "savePaylaterCicilRegistrationCacheCooldownDelay", "startDelayTime", "", "updatePayLaterLoanCache", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(int i, int i2, List<String> list, String str);

        void BuiltInFictitiousFunctionClassFactory(QueryInstallmentRequestModel queryInstallmentRequestModel, CashierPayMethodModel cashierPayMethodModel);

        void BuiltInFictitiousFunctionClassFactory(QueryInstallmentRequestModel queryInstallmentRequestModel, CashierPayMethodModel cashierPayMethodModel, Map<String, Boolean> map, List<String> list, boolean z);

        void BuiltInFictitiousFunctionClassFactory(List<? extends CashierPayMethodModel> list, String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory(long j);

        void PlaceComponentResult();

        void PlaceComponentResult(int i);

        void getAuthRequestContext(List<String> list, String str, int i, boolean z);

        /* renamed from: id.dana.cashier.CashierPayLaterContract$Presenter$-CC */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void PlaceComponentResult(Presenter presenter, List list, String str, int i, boolean z, int i2) {
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                if ((i2 & 8) != 0) {
                    z = false;
                }
                presenter.getAuthRequestContext(list, str, i, z);
            }
        }
    }
}
