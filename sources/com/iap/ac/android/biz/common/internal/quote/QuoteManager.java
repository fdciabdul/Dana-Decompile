package com.iap.ac.android.biz.common.internal.quote;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.callback.InquireQuoteCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.ForeignExchangeQuote;
import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentInquireQuoteResult;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;

/* loaded from: classes3.dex */
public class QuoteManager {
    public static ForeignExchangeQuote convertQuoteModel(MobilePaymentInquireQuoteResult mobilePaymentInquireQuoteResult) {
        ForeignExchangeQuote foreignExchangeQuote = new ForeignExchangeQuote();
        foreignExchangeQuote.baseCurrency = mobilePaymentInquireQuoteResult.baseCurrency;
        foreignExchangeQuote.quoteCurrencyPair = mobilePaymentInquireQuoteResult.quoteCurrencyPair;
        foreignExchangeQuote.quoteExpiryTime = Utils.stringToLong(mobilePaymentInquireQuoteResult.quoteExpiryTime, 0L);
        foreignExchangeQuote.quoteStartTime = Utils.stringToLong(mobilePaymentInquireQuoteResult.quoteStartTime, 0L);
        foreignExchangeQuote.quoteId = mobilePaymentInquireQuoteResult.quoteId;
        foreignExchangeQuote.quotePrice = mobilePaymentInquireQuoteResult.quotePrice;
        foreignExchangeQuote.quoteUnit = mobilePaymentInquireQuoteResult.quoteUnit;
        return foreignExchangeQuote;
    }

    public static void inquireQuote(final QuoteCurrency quoteCurrency, final InquireQuoteCallback inquireQuoteCallback) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final LogResult logResult = new LogResult();
        if (quoteCurrency != null && inquireQuoteCallback != null) {
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.biz.common.internal.quote.QuoteManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    MobilePaymentInquireQuoteResult inquireQuote;
                    try {
                        inquireQuote = new InquireQuoteProcessor().inquireQuote(QuoteCurrency.this);
                    } catch (Throwable th) {
                        LogResult logResult2 = logResult;
                        logResult2.resultCode = ResultCode.INVALID_NETWORK;
                        StringBuilder sb = new StringBuilder();
                        sb.append("inquireQuote exception: ");
                        sb.append(th);
                        logResult2.resultMessage = sb.toString();
                    }
                    if (inquireQuote != null && inquireQuote.success) {
                        inquireQuoteCallback.onResult("SUCCESS", QuoteManager.convertQuoteModel(inquireQuote));
                        logResult.resultCode = "SUCCESS";
                        logResult.traceId = inquireQuote.traceId;
                        ACLogEvent.commonEvent(LogConstants.EVENT_ID_INQUIRE_QUOTE, elapsedRealtime, logResult);
                    } else if (!inquireQuote.success) {
                        inquireQuoteCallback.onResult(inquireQuote.errorCode, null);
                        logResult.traceId = inquireQuote.traceId;
                        logResult.resultCode = inquireQuote.errorCode;
                        logResult.resultMessage = inquireQuote.errorMessage;
                        ACLogEvent.commonEvent(LogConstants.EVENT_ID_INQUIRE_QUOTE, elapsedRealtime, logResult);
                    } else {
                        logResult.resultCode = ResultCode.INVALID_NETWORK;
                        logResult.resultMessage = "server return null result";
                        inquireQuoteCallback.onResult(ResultCode.INVALID_NETWORK, null);
                        ACLog.e(Constants.TAG, logResult.resultMessage);
                        ACLogEvent.commonEvent(LogConstants.EVENT_ID_INQUIRE_QUOTE, elapsedRealtime, logResult);
                    }
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("inquireQuote with invalid paramters, quoteCurrency: ");
        sb.append(quoteCurrency);
        sb.append(", callback: ");
        sb.append(inquireQuoteCallback);
        String obj = sb.toString();
        ACLog.e(Constants.TAG, obj);
        if (inquireQuoteCallback != null) {
            inquireQuoteCallback.onResult("PARAM_ILLEGAL", null);
        }
        logResult.resultCode = "PARAM_ILLEGAL";
        logResult.resultMessage = obj;
        ACLogEvent.commonEvent(LogConstants.EVENT_ID_INQUIRE_QUOTE, elapsedRealtime, logResult);
    }
}
