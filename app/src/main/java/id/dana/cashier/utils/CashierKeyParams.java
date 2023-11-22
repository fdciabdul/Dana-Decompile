package id.dana.cashier.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/cashier/utils/CashierKeyParams;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface CashierKeyParams {
    public static final String AGREEMENT_INFO = "agreementInfo";
    public static final String ALLOW_ONEKLIK_TRANSACTION = "isOneKlikAvailable";
    public static final String ATTRIBUTE_CASHIER_PAY = "attributeCashierPay";
    public static final String BALANCE = "balance";
    public static final String BALANCE_MIX_PAY_MODEL = "balanceMixPayModel";
    public static final String BIZ_ORDER_ID = "bizOrderId";
    public static final String CASHIER_ORDER_GOODS = "cashierOrderGoods";
    public static final String CASHIER_ORDER_ID = "cashierOrderId";
    public static final String CASHIER_PAY_METHOD = "cashierPayMethod";
    public static final String CASHIER_PAY_MODEL = "cashierPayModel";
    public static final String CHECKOUT_EXTERNAL_INFO = "checkoutExternalInfo";
    public static final String CONTENT_TYPE = "contentType";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
    public static final String EXCHANGE_RATE = "exchangeRate";
    public static final String GET_ORDER_TITLE = "getOrderTitle";
    public static final String HTTP_METHOD = "http_method";
    public static final String INSTALLMENT_PERIOD = "installmentPeriod";
    public static final String INSTALLMENT_PLAN_ID = "installmentPlanId";
    public static final String IS_BINDING_PAY = "isBindingPay";
    public static final String IS_CARD_REBINDING = "isCardRebinding";
    public static final String IS_VERIFY_BANK_PHONE_OTP = "isVerifyBankPhoneOtp";
    public static final String LOAN_AGREEMENT_URL = "loanAgreementUrl";
    public static final String MASKED_PHONE_NO = "maskedPhoneNo";
    public static final String MERCHANT_ID = "merchantId";
    public static final String PAY_RESULT_MODEL = "payResultModel";
    public static final String REBINDING_VERIFY_ELEMENTS = "rebindingVerifyElements";
    public static final String REDIRECT_URL = "redirecturl";
    public static final String REDIRECT_URL_PARAM = "redirecturl_url_params";
    public static final String RISK_3DS_ADDITIONAL_DATA = "risk3dsAdditionalData";
    public static final String RISK_PHASE_2 = "riskPhase2";
    public static final String TOP_UP_ORDER_ID = "topUpOrderId";
    public static final String TOP_UP_VERIFY_REQUEST_MODEL = "topUpVerifyRequestModel";
    public static final String TOTAL_AMOUNT = "orderAmount";
    public static final String TRANSFER_TYPE = "transferType";
    public static final String VERIFICATION_METHOD = "verificationMethod";
    public static final String VERIFY_ELEMENTS_LIST = "verifyElementsList";
    public static final String VOUCHER_PROMO = "voucherPromo";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/utils/CashierKeyParams$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}
