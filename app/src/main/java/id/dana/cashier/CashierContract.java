package id.dana.cashier;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierFaceAuthModel;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.PaylaterCashierRequestCheckoutModel;
import id.dana.cashier.model.QueryPromotionModel;
import id.dana.cashier.model.QueryPromotionRequestModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.constant.UrlParam;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierContract {

    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0018\u0010\r\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\fH&J$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001b\u001a\u00020\u0006H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0006H&J \u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u000bH&J\b\u0010&\u001a\u00020\u0003H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0006H&J\b\u0010)\u001a\u00020\u0003H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\fH&J\b\u0010,\u001a\u00020\u0003H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\fH&J(\u0010/\u001a\u00020\u00032\u000e\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u000b2\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006H&J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000206H&J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u000209H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H&J\u0018\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\fH&J\u001a\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010$2\u0006\u0010D\u001a\u00020\u0006H&J0\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\f2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000bH&J \u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020MH&J\b\u0010N\u001a\u00020\u0003H&J\b\u0010O\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006PÀ\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "clearRequestId", "", "dismissSecureProgress", "isSkipLastAnimation", "", "getIsGpsActive", "onCancelFaceAuth", "onCheckShowcaseAvailability", "availableScenarios", "", "", "onConsultAgreementTncCardPayment", "agreementInfos", "Lid/dana/domain/useragreement/model/AgreementInfo;", "onErrorAutorouteActivation", "onErrorFaceAuth", "onErrorPayCashier", "errorState", "Lid/dana/cashier/helper/CashierErrorState;", "onErrorPayQuery", "onErrorPaymentInfo", "onErrorQueryCardPolicy", "errorMessage", "onFallbackAddOnCheckBox", "selectedAddOnId", "isInsufficientPaylaterLimit", "onGetKybProduct", "merchantModel", "Lid/dana/cashier/model/CashierMerchantModel;", "onMixPayNotAvailable", "onRecordAgreementTncCardPayment", "userAgreed", "onSelectedVoucherCashier", "selectedVoucherCashier", "Lid/dana/cashier/model/VoucherCashierModel;", "voucherCashierModelList", "onShowSmartpayDialog", "onSomeCardNotSupportMixPay", "someCardNotSupport", "onSuccessAutorouteActivation", "onSuccessCreateOrder", "checkoutUrl", "onSuccessFaceAuth", "onSuccessGetCurrencyByCountryCode", "symbol", "onSuccessGetPayMethodList", "payMethodModels", "Lid/dana/cashier/model/CashierPayMethodModel;", "isAutoroutedAssetExist", "isNeedToShowMixPayTooltip", "onSuccessGetPaymentInfo", "cashierCheckoutModel", "Lid/dana/cashier/model/CashierCheckoutModel;", "onSuccessGetQueryPromotion", "queryPromotionModel", "Lid/dana/cashier/model/QueryPromotionModel;", "onSuccessPayCashier", CashierKeyParams.CASHIER_PAY_MODEL, "Lid/dana/cashier/model/CashierPayModel;", "onSuccessPayQuery", "onSuccessQueryCardPolicy", "queryCardPolicyInfoModel", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "cardNumber", "onSuccessReconsultMixPayPromo", "voucherCashierModel", "isNeedToChangeCheckBoxMixPayBalance", "onSuccessRefreshCashierAddOn", "attributeModel", "Lid/dana/cashier/model/AttributeModel;", "isAddOnChecked", "onTrackDisplayedError", "operationType", "displayedMessage", "throwable", "", "showSecureProgress", "showSkeletonLoading", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(CashierErrorState cashierErrorState);

        void BuiltInFictitiousFunctionClassFactory(CashierMerchantModel cashierMerchantModel);

        void DatabaseTableConfigUtil();

        void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel cashierPayModel);

        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(CashierCheckoutModel cashierCheckoutModel);

        void MyBillsEntityDataFactory(CashierPayModel cashierPayModel);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(String str, String str2, Throwable th);

        void MyBillsEntityDataFactory(List<String> list);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void PlaceComponentResult(CashierErrorState cashierErrorState);

        void PlaceComponentResult(QueryPromotionModel queryPromotionModel);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext();

        void getAuthRequestContext(CashierErrorState cashierErrorState);

        void getAuthRequestContext(AttributeModel attributeModel, boolean z, String str, List<? extends CashierPayMethodModel> list);

        void getAuthRequestContext(VoucherCashierModel voucherCashierModel, List<VoucherCashierModel> list);

        void getAuthRequestContext(VoucherCashierModel voucherCashierModel, boolean z);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(String str, String str2, boolean z);

        void getAuthRequestContext(List<? extends CashierPayMethodModel> list, boolean z, boolean z2);

        void getErrorConfigVersion();

        void lookAheadTest();

        void moveToNextValue();

        void scheduleImpl();

        /* renamed from: id.dana.cashier.CashierContract$View$-CC */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
        }
    }

    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J2\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J@\u0010\u001d\u001a\u00020\u00032\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001fj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e` 2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u000eH&J\"\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0007H&J\u001a\u0010)\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010*\u001a\u00020\u0007H&J*\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u000e2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u0007H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u000eH&J\b\u00103\u001a\u00020\u0003H&J*\u00104\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u000e2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000bH&J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H&J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H&J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H&J\u001c\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H&J\b\u0010>\u001a\u00020\u0007H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0007H&J\b\u0010@\u001a\u00020\u0007H&Jd\u0010A\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000b2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010C\u001a\u00020\u00072\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00142\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH&Jr\u0010I\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u000e2\u0006\u0010L\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010M\u001a\u00020\u00072\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00142\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000eH&JC\u0010N\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010O\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010P\u001a\u00020\u00072\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010TJ$\u0010U\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u000e2\b\u0010K\u001a\u0004\u0018\u00010\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u000eH&J(\u0010V\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000bH&J^\u0010W\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u000b2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00142\b\u0010B\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\u000eH&J\u0018\u0010Z\u001a\u00020\u00032\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010\u0014H&J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0007H&J%\u0010_\u001a\u00020\u00032\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010aJ\u0012\u0010b\u001a\u00020\u00032\b\u0010c\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020RH&J\u0010\u0010f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010g\u001a\u00020\u0003H&J\u0010\u0010h\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u000bH&J\b\u0010i\u001a\u00020\u0003H&J\u001c\u0010j\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u000e2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000eH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006kÀ\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "checkAutoRouteOnSuccessCashierInfo", "", "checkoutModel", "Lid/dana/cashier/model/CashierCheckoutModel;", "isAutorouteAssetsExist", "", "isNeedToShowMixPayTooltip", "checkAutoRouteOnSuccessRefreshCashier", "currentPayMethod", "Lid/dana/cashier/model/CashierPayMethodModel;", "isAddOnChecked", "selectedAddOnId", "", "checkAutorouteSplitFeatureEnable", "onCheckCompleted", "Lkotlin/Function0;", "checkShowcaseAvailability", "scenarios", "", "clearAddOnAttributeCache", "createCashierOrder", "merchantModel", "Lid/dana/cashier/model/CashierMerchantModel;", "amount", "doFaceAuth", "cashierFaceAuthModel", "Lid/dana/cashier/model/CashierFaceAuthModel;", "doPreCreateCashierOrder", "nativelyDecodedQr", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scanResultStr", UrlParam.REQUEST_ID, "doReconsultMixPayPromo", "cashierRequestModel", "Lid/dana/cashier/model/CashierCheckoutRequestModel;", "voucherCashierModel", "Lid/dana/cashier/model/VoucherCashierModel;", "isNeedToChangeCheckBoxMixPayBalance", "getCashierInfo", SummaryActivity.FIRST_STATE_SHARE_FEED, "getCashierInfoForMixPay", CashierKeyParams.CASHIER_ORDER_ID, "payMethod", "showAutorouteSwitch", "getCashierKybProduct", "orderId", "getCurrencyFromCdn", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "getCustomLoading3dsUrls", "getFeatureConfigMixPay", "getQueryPromotion", "queryPromotionRequestModel", "Lid/dana/cashier/model/QueryPromotionRequestModel;", "newPayMethod", "getSelectedAddOnNames", "getSelectedAddonsId", "getSelectedAddonsIdWithoutParentId", "handleCashierCheckoutResult", "cashierCheckoutModel", "isInMixPaymentMode", "isNeedToShowSmartpayDialog", "isPaylaterAvailableForMixpay", "payCashier", "voucher", "isRefreshCashierInfoAndPay", "selectedAddonsId", "mixPaySelectedPayMethod", "transType", "paylaterCashierRequestCheckoutModel", "Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;", "payCashierWithRisk", "selectedPayMethod", "validateData", CashierKeyParams.VERIFICATION_METHOD, "isCvvRisk", "payQueryCashier", "query3dsParams", "isReload", "delay", "", "cashierRequestId", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "payQueryCashierWithRisk", "refreshCashierInfoAddOn", "refreshCashierInfoAndPay", "saveShowcaseShowed", "scenario", "setAvailableAddOn", "addOns", "Lid/dana/cashier/model/CashierOrderGoodModel;", "setCheckBoxMixPayBalance", "isCheckBoxMixPayBalanceChecked", "setMixpayAvailability", "isInMixpayMode", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "setParentAddonId", "parentAddOnId", "setRemainingAmount", "remainingAmount", "setSelectedAddonsId", "setSmartpayDialogHasShow", "setVoucherCashier", "switchAutoRouteState", "updateOrder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        List<String> BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(CashierCheckoutModel cashierCheckoutModel, boolean z);

        void BuiltInFictitiousFunctionClassFactory(CashierFaceAuthModel cashierFaceAuthModel);

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(List<CashierOrderGoodModel> list);

        List<String> KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(CashierCheckoutRequestModel cashierCheckoutRequestModel, VoucherCashierModel voucherCashierModel, boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2(Boolean bool, Boolean bool2);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, CashierCheckoutRequestModel cashierCheckoutRequestModel, CashierPayMethodModel cashierPayMethodModel, List<String> list, VoucherCashierModel voucherCashierModel, PaylaterCashierRequestCheckoutModel paylaterCashierRequestCheckoutModel, CashierPayMethodModel cashierPayMethodModel2, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, boolean z, Long l, String str3);

        void KClassImpl$Data$declaredNonStaticMembers$2(HashMap<String, String> hashMap, String str, String str2);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(long j);

        void MyBillsEntityDataFactory(CashierCheckoutRequestModel cashierCheckoutRequestModel, boolean z, String str, CashierPayMethodModel cashierPayMethodModel);

        void MyBillsEntityDataFactory(CashierMerchantModel cashierMerchantModel, String str);

        void MyBillsEntityDataFactory(QueryPromotionRequestModel queryPromotionRequestModel, CashierPayMethodModel cashierPayMethodModel);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(String str, CashierPayMethodModel cashierPayMethodModel, String str2, String str3, VoucherCashierModel voucherCashierModel, boolean z, List<String> list, PaylaterCashierRequestCheckoutModel paylaterCashierRequestCheckoutModel, CashierPayMethodModel cashierPayMethodModel2, String str4);

        void MyBillsEntityDataFactory(boolean z);

        boolean NetworkUserEntityData$$ExternalSyntheticLambda0();

        void PlaceComponentResult();

        void PlaceComponentResult(CashierCheckoutModel cashierCheckoutModel);

        void PlaceComponentResult(CashierCheckoutRequestModel cashierCheckoutRequestModel, boolean z);

        void PlaceComponentResult(CashierPayMethodModel cashierPayMethodModel);

        void PlaceComponentResult(String str);

        void PlaceComponentResult(String str, CashierPayMethodModel cashierPayMethodModel, VoucherCashierModel voucherCashierModel, boolean z, List<String> list, CashierPayMethodModel cashierPayMethodModel2, String str2, PaylaterCashierRequestCheckoutModel paylaterCashierRequestCheckoutModel);

        List<String> getAuthRequestContext();

        void getAuthRequestContext(String str);

        void getAuthRequestContext(List<String> list);

        boolean getErrorConfigVersion();

        void lookAheadTest();

        void scheduleImpl();

        /* renamed from: id.dana.cashier.CashierContract$Presenter$-CC */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Presenter presenter, String str, CashierPayMethodModel cashierPayMethodModel, VoucherCashierModel voucherCashierModel, List list, CashierPayMethodModel cashierPayMethodModel2, String str2, PaylaterCashierRequestCheckoutModel paylaterCashierRequestCheckoutModel, int i) {
                presenter.PlaceComponentResult(str, cashierPayMethodModel, (i & 4) != 0 ? null : voucherCashierModel, false, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : cashierPayMethodModel2, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : paylaterCashierRequestCheckoutModel);
            }

            public static /* synthetic */ void PlaceComponentResult(Presenter presenter, CashierCheckoutModel cashierCheckoutModel) {
                presenter.PlaceComponentResult(cashierCheckoutModel);
            }
        }
    }
}
