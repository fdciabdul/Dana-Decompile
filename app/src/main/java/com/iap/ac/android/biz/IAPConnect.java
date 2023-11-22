package com.iap.ac.android.biz;

import android.app.Application;
import android.content.Context;
import com.iap.ac.android.acs.translation.TranslateManager;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.callback.InquireQuoteCallback;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.biz.common.model.gol.SignContractRequest;
import com.iap.ac.android.biz.internal.ACFactory;
import com.iap.ac.android.biz.internal.IIAPConnect;
import com.iap.ac.android.mpm.DecodeParameter;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class IAPConnect {
    public static volatile IIAPConnect sIAPConnectImpl;

    public static void clear() {
        if (sIAPConnectImpl != null) {
            sIAPConnectImpl.clear();
        }
    }

    @Deprecated
    public static void decode(Context context, String str, String str2, IDecodeCallback iDecodeCallback) {
        if (sIAPConnectImpl != null) {
            sIAPConnectImpl.decode(context, str, str2, iDecodeCallback);
        }
    }

    public static List<String> getJSApiPermissionConfig(String str) {
        if (sIAPConnectImpl != null) {
            return sIAPConnectImpl.getJSApiPermissionConfig(str);
        }
        return null;
    }

    public static void getPaymentCode(String str, IPaymentCodeListener iPaymentCodeListener) {
        if (sIAPConnectImpl != null) {
            sIAPConnectImpl.getPaymentCode(str, iPaymentCodeListener);
        }
    }

    public static TranslateManager getTranslateManager(Context context) {
        if (sIAPConnectImpl != null) {
            return sIAPConnectImpl.getTranslateManager(context);
        }
        return null;
    }

    public static void init(Application application, InitConfig initConfig, InitCallback initCallback) {
        if (sIAPConnectImpl == null) {
            synchronized (IAPConnect.class) {
                if (sIAPConnectImpl == null) {
                    sIAPConnectImpl = ACFactory.createIAPConnectImpl();
                }
            }
        }
        sIAPConnectImpl.init(application, initConfig, initCallback);
    }

    @Deprecated
    public static void initWithContext(Context context, InitConfig initConfig) {
        synchronized (IAPConnect.class) {
            if (sIAPConnectImpl == null) {
                sIAPConnectImpl = ACFactory.createIAPConnectImpl();
            }
            sIAPConnectImpl.initWithContext(context, initConfig);
        }
    }

    public static void inquireQuote(QuoteCurrency quoteCurrency, InquireQuoteCallback inquireQuoteCallback) {
        if (sIAPConnectImpl != null) {
            sIAPConnectImpl.inquireQuote(quoteCurrency, inquireQuoteCallback);
        }
    }

    public static void notifyAgreePaymentAuthCode(AuthResult authResult) {
        if (sIAPConnectImpl != null) {
            sIAPConnectImpl.notifyAgreePaymentAuthCode(authResult);
        }
    }

    public static boolean openACCenter() {
        synchronized (IAPConnect.class) {
            if (sIAPConnectImpl != null) {
                return sIAPConnectImpl.openACCenter();
            }
            return false;
        }
    }

    public static boolean shouldInterceptRequest(String str) {
        return str != null && str.startsWith(InnerConstants.PREFIX_INTERCEPT_AND_GET_CODE_URL);
    }

    public static void signContract(SignContractRequest signContractRequest, AcCallback<AcBaseResult> acCallback) {
        if (sIAPConnectImpl != null) {
            sIAPConnectImpl.signContract(signContractRequest, acCallback);
        }
    }

    public static void decode(Context context, DecodeParameter decodeParameter, IDecodeCallback iDecodeCallback) {
        if (sIAPConnectImpl != null) {
            sIAPConnectImpl.decode(context, decodeParameter, iDecodeCallback);
        }
    }
}
