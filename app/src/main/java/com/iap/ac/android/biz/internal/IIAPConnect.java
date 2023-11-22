package com.iap.ac.android.biz.internal;

import android.app.Application;
import android.content.Context;
import com.iap.ac.android.acs.translation.TranslateManager;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.callback.InquireQuoteCallback;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.biz.common.model.gol.SignContractRequest;
import com.iap.ac.android.mpm.DecodeParameter;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import java.util.List;

/* loaded from: classes3.dex */
public interface IIAPConnect {
    void clear();

    void decode(Context context, DecodeParameter decodeParameter, IDecodeCallback iDecodeCallback);

    void decode(Context context, String str, String str2, IDecodeCallback iDecodeCallback);

    List<String> getJSApiPermissionConfig(String str);

    void getPaymentCode(String str, IPaymentCodeListener iPaymentCodeListener);

    TranslateManager getTranslateManager(Context context);

    void init(Application application, InitConfig initConfig, InitCallback initCallback);

    void initWithContext(Context context, InitConfig initConfig);

    void inquireQuote(QuoteCurrency quoteCurrency, InquireQuoteCallback inquireQuoteCallback);

    void notifyAgreePaymentAuthCode(AuthResult authResult);

    boolean openACCenter();

    void signContract(SignContractRequest signContractRequest, AcCallback<AcBaseResult> acCallback);
}
