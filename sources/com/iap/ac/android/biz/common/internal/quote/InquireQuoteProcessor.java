package com.iap.ac.android.biz.common.internal.quote;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.biz.common.rpc.facade.MobilePaymentInquireQuoteRpcFacade;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentInquireQuoteRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentInquireQuoteResult;

/* loaded from: classes3.dex */
public class InquireQuoteProcessor extends BaseNetwork<MobilePaymentInquireQuoteRpcFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MobilePaymentInquireQuoteRpcFacade> getFacadeClass() {
        return MobilePaymentInquireQuoteRpcFacade.class;
    }

    public MobilePaymentInquireQuoteResult inquireQuote(QuoteCurrency quoteCurrency) {
        MobilePaymentInquireQuoteRequest mobilePaymentInquireQuoteRequest = new MobilePaymentInquireQuoteRequest();
        mobilePaymentInquireQuoteRequest.sellCurrency = quoteCurrency.sellCurrency;
        mobilePaymentInquireQuoteRequest.buyCurrency = quoteCurrency.buyCurrency;
        return getFacade().inquireQuote(mobilePaymentInquireQuoteRequest);
    }
}
