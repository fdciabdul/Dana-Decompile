package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.InquireQuoteCallback;
import com.iap.ac.android.biz.common.model.ForeignExchangeQuote;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4inquireQuote extends BaseInterceptor {
    public static final String PARAM_BUY_CURRENCY = "buyCurrency";
    public static final String PARAM_SELL_CURRENCY = "sellCurrency";
    public static final String TAG = "IAPConnectPlugin";

    private void inquireQuote(String str, String str2, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        QuoteCurrency quoteCurrency = new QuoteCurrency();
        quoteCurrency.sellCurrency = str;
        quoteCurrency.buyCurrency = str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4inquireQuote#inquireQuote, start to inquire quote, sellCurrency: ");
        sb.append(str);
        sb.append(", buyCurrency: ");
        sb.append(str2);
        ACLog.d("IAPConnectPlugin", sb.toString());
        ACManager.getInstance().inquireQuote(quoteCurrency, new InquireQuoteCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4inquireQuote.1
            @Override // com.iap.ac.android.biz.common.callback.InquireQuoteCallback
            public void onResult(String str3, ForeignExchangeQuote foreignExchangeQuote) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", str3);
                    if (foreignExchangeQuote != null) {
                        jSONObject.put("quoteId", foreignExchangeQuote.quoteId);
                        jSONObject.put("quoteCurrencyPair", foreignExchangeQuote.quoteCurrencyPair);
                        jSONObject.put("quotePrice", foreignExchangeQuote.quotePrice);
                        jSONObject.put("baseCurrency", foreignExchangeQuote.baseCurrency);
                        jSONObject.put("quoteUnit", foreignExchangeQuote.quoteUnit);
                        jSONObject.put("quoteStartTime", foreignExchangeQuote.quoteStartTime);
                        jSONObject.put("quoteExpiryTime", foreignExchangeQuote.quoteExpiryTime);
                    }
                    iAPConnectPluginCallback.onResult(jSONObject);
                } catch (JSONException e) {
                    ACLog.e("IAPConnectPlugin", "Interceptor4inquireQuote#inquireQuote, convert result to JSON error");
                    MonitorUtil.monitorJSONError(Constants.JS_API_INQUIRE_QUOTE, e);
                }
            }
        });
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4inquireQuote#handle, jsParameters is null", Constants.JS_API_INQUIRE_QUOTE, "parameter is null", iAPConnectPluginCallback);
            return;
        }
        String optString = jSONObject.optString(PARAM_SELL_CURRENCY);
        if (TextUtils.isEmpty(optString)) {
            a.a("IAPConnectPlugin", "Interceptor4inquireQuote#handle, sellCurrency is empty", Constants.JS_API_INQUIRE_QUOTE, "sellCurrency is empty", iAPConnectPluginCallback);
            return;
        }
        String optString2 = jSONObject.optString(PARAM_BUY_CURRENCY);
        if (TextUtils.isEmpty(optString2)) {
            a.a("IAPConnectPlugin", "Interceptor4inquireQuote#handle, buyCurrency is empty", Constants.JS_API_INQUIRE_QUOTE, "buyCurrency is empty", iAPConnectPluginCallback);
        } else {
            inquireQuote(optString, optString2, iAPConnectPluginCallback);
        }
    }
}
