package id.dana.data.offlinepay.source;

import android.text.TextUtils;
import com.alipay.iap.android.f2fpay.client.pay.F2FPayResult;
import com.alipay.iap.android.f2fpay.client.pay.F2FPayResultStatus;
import com.alipay.iap.android.f2fpay.client.pay.F2fPayOrderInfo;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.domain.model.f2fpay.F2FPayOrderInfo;
import id.dana.domain.model.f2fpay.F2FPaymentResultStatus;
import id.dana.domain.model.f2fpay.response.F2FPayResultResponse;
import id.dana.domain.model.f2fpay.response.F2FPaymentCodeResponse;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* loaded from: classes2.dex */
public class PaymentModelMapper {
    private static final String LANGUAGE_EN = "EN";
    private static final String LANGUAGE_ID = "ID";

    @Inject
    public PaymentModelMapper() {
    }

    public F2FPaymentCodeResponse transform(F2FPaymentCodeInfo f2FPaymentCodeInfo) {
        F2FPaymentCodeResponse f2FPaymentCodeResponse = new F2FPaymentCodeResponse();
        f2FPaymentCodeResponse.setPaymentCode(f2FPaymentCodeInfo.paymentCode);
        f2FPaymentCodeResponse.setTotp(f2FPaymentCodeInfo.totp);
        return f2FPaymentCodeResponse;
    }

    public F2FPayResultResponse transform(F2FPayResult f2FPayResult) {
        F2FPayResultResponse f2FPayResultResponse = new F2FPayResultResponse();
        if (f2FPayResult.status != null) {
            if (f2FPayResult.status == F2FPayResultStatus.Success) {
                f2FPayResultResponse.setStatus(F2FPaymentResultStatus.SUCCESS);
            } else if (f2FPayResult.status == F2FPayResultStatus.Pending) {
                f2FPayResultResponse.setStatus(F2FPaymentResultStatus.PENDING);
            } else if (f2FPayResult.status == F2FPayResultStatus.Failure) {
                f2FPayResultResponse.setStatus(F2FPaymentResultStatus.FAILURE);
            }
        }
        if (f2FPayResult.orderInfo != null) {
            F2FPayOrderInfo f2FPayOrderInfo = new F2FPayOrderInfo();
            F2fPayOrderInfo f2fPayOrderInfo = f2FPayResult.orderInfo;
            f2FPayOrderInfo.setTradeNo(f2fPayOrderInfo.tradeNo);
            f2FPayOrderInfo.setBuyerPhoneNo(f2fPayOrderInfo.buyerPhoneNo);
            f2FPayOrderInfo.setBuyerUserId(f2fPayOrderInfo.buyerUserId);
            f2FPayOrderInfo.setPaymentCode(f2fPayOrderInfo.paymentCode);
            f2FPayOrderInfo.setSellerUserId(f2fPayOrderInfo.sellerUserId);
            f2FPayOrderInfo.setSellerName(f2fPayOrderInfo.sellerName);
            f2FPayOrderInfo.setProductCode(f2fPayOrderInfo.productCode);
            f2FPayOrderInfo.setState(f2fPayOrderInfo.state);
            f2FPayOrderInfo.setAmount(f2fPayOrderInfo.amount);
            f2FPayOrderInfo.setPayAmount(parseAmountByDivision(f2FPayResult.orderInfo.payAmount));
            f2FPayOrderInfo.setPayAmountCurrency(f2fPayOrderInfo.payAmountCurrency);
            f2FPayOrderInfo.setTradeAmount(f2fPayOrderInfo.tradeAmount);
            f2FPayOrderInfo.setTradeAmountCurrency(f2fPayOrderInfo.tradeAmountCurrency);
            f2FPayOrderInfo.setCashierUrl(CookieUtil.PlaceComponentResult(f2fPayOrderInfo.cashierUrl));
            f2FPayOrderInfo.setExtendInfo(f2fPayOrderInfo.extendInfo);
            f2FPayOrderInfo.setPayMethod(f2fPayOrderInfo.payMethod);
            f2FPayOrderInfo.setStateReasonCode(f2fPayOrderInfo.stateReasonCode);
            f2FPayOrderInfo.setStateReasonDesc(getStateReasonDescByLanguage(f2fPayOrderInfo.stateReasonDesc));
            f2FPayResultResponse.setOrderInfo(f2FPayOrderInfo);
        }
        return f2FPayResultResponse;
    }

    private String parseAmountByDivision(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return String.valueOf(Long.valueOf(Long.parseLong(str) / 100));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private String getStateReasonDescByLanguage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = Locale.getDefault().getLanguage().toUpperCase(Locale.ROOT);
        if (upperCase.equalsIgnoreCase("in")) {
            upperCase = "ID";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has(upperCase) ? jSONObject.getString(upperCase) : jSONObject.getString(LANGUAGE_EN);
        } catch (JSONException unused) {
            return null;
        }
    }
}
