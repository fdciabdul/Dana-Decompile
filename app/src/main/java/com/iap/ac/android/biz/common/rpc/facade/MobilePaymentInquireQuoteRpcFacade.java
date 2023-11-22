package com.iap.ac.android.biz.common.rpc.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentInquireQuoteRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentInquireQuoteResult;

/* loaded from: classes3.dex */
public interface MobilePaymentInquireQuoteRpcFacade {
    @ACRpcRequest
    @OperationType(Constants.OperationType.INQUIRE_QUOTE)
    @SignCheck
    MobilePaymentInquireQuoteResult inquireQuote(MobilePaymentInquireQuoteRequest mobilePaymentInquireQuoteRequest);
}
