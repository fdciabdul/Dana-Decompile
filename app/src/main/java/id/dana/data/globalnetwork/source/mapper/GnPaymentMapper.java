package id.dana.data.globalnetwork.source.mapper;

import com.iap.ac.android.biz.common.model.ForeignExchangeQuote;
import id.dana.data.globalnetwork.model.ForexResult;
import id.dana.data.globalnetwork.model.PayRequest;
import id.dana.data.globalnetwork.source.mapper.parser.GnPaymentParser;
import id.dana.domain.globalnetwork.model.Pay;
import id.dana.domain.model.f2fpay.F2FPayOrderInfo;
import id.dana.domain.model.f2fpay.F2FPaymentResultStatus;
import id.dana.domain.model.f2fpay.response.F2FPayResultResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class GnPaymentMapper {
    private GnPaymentMapper() {
    }

    public static ForexResult map(ForeignExchangeQuote foreignExchangeQuote) {
        ForexResult forexResult = new ForexResult();
        if (foreignExchangeQuote != null) {
            forexResult.setId(foreignExchangeQuote.quoteId);
            forexResult.setPrice(foreignExchangeQuote.quotePrice);
            forexResult.setCurrencyPair(foreignExchangeQuote.quoteCurrencyPair);
        }
        return forexResult;
    }

    public static F2FPayResultResponse map(String str) {
        return toF2FPayResultResponse(GnPaymentParser.parseToF2FPayResultResponses(str));
    }

    private static F2FPayResultResponse toF2FPayResultResponse(List<F2FPayOrderInfo> list) {
        F2FPayResultResponse f2FPayResultResponse = new F2FPayResultResponse();
        if (list != null && !list.isEmpty()) {
            f2FPayResultResponse.setOrderInfo(new F2FPayOrderInfo());
            for (F2FPayOrderInfo f2FPayOrderInfo : list) {
                String state = f2FPayOrderInfo.getState();
                if ("success".equals(state)) {
                    f2FPayResultResponse.setStatus(F2FPaymentResultStatus.SUCCESS);
                } else if ("pending".equals(state)) {
                    f2FPayResultResponse.setStatus(F2FPaymentResultStatus.PENDING);
                } else if ("failed".equals(state)) {
                    f2FPayResultResponse.setStatus(F2FPaymentResultStatus.FAILURE);
                }
                f2FPayResultResponse.setOrderInfo(f2FPayOrderInfo);
            }
        }
        return f2FPayResultResponse;
    }

    public static Pay transform(PayRequest payRequest) {
        String str;
        String str2;
        Map hashMap = new HashMap();
        if (payRequest.getPaymentRequest().paymentAmount != null) {
            str = payRequest.getPaymentRequest().paymentAmount.value;
            str2 = payRequest.getPaymentRequest().paymentAmount.currency;
        } else {
            str = "";
            str2 = str;
        }
        if (payRequest.getPaymentRequest().extendedInfo != null) {
            hashMap = payRequest.getPaymentRequest().extendedInfo;
        }
        return new Pay(str, str2, hashMap, payRequest.getPaymentRequest().type, payRequest.getPaymentRequest().paymentString, payRequest.isFromMiniProgram());
    }
}
