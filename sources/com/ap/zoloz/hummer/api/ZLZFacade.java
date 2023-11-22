package com.ap.zoloz.hummer.api;

import android.content.Context;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.biz.HummerLogger;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.ap.zoloz.hummer.connect.api.ConnectFacade;
import com.ap.zoloz.hummer.connect.api.ConnectRequest;
import com.ap.zoloz.hummer.connect.api.ConnectResponse;
import com.ap.zoloz.hummer.connect.api.IConnectCallback;
import com.google.firebase.perf.FirebasePerformance;

/* loaded from: classes7.dex */
public class ZLZFacade {
    public static final String TAG = "ZLZFacade";
    private static ZLZFacade sInstance;
    protected static boolean sIsBusy;
    private IZLZCallback mIZLZCallback;

    public static ZLZFacade getInstance() {
        if (sInstance == null) {
            synchronized (ZLZFacade.class) {
                if (sInstance == null) {
                    sInstance = new ZLZFacade();
                }
            }
        }
        return sInstance;
    }

    public void start(ZLZRequest zLZRequest, IZLZCallback iZLZCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("ZLZFacade start ");
        sb.append(zLZRequest.toString());
        HummerLogger.i(sb.toString());
        synchronized (ZLZFacade.class) {
            if (sIsBusy) {
                this.mIZLZCallback = null;
            }
        }
        sIsBusy = true;
        this.mIZLZCallback = iZLZCallback;
        String authType = StringUtil.isNullorEmpty(zLZRequest.zlzConfig) ? null : BaseFacade.getAuthType(zLZRequest.zlzConfig);
        switchConstants(zLZRequest);
        if (!isSupporttedAuthType(authType)) {
            ZLZResponse zLZResponse = new ZLZResponse();
            zLZResponse.retCode = HummerZCodeConstant.INCORRECT_CLIENT_CONFIG;
            this.mIZLZCallback.onInterrupted(zLZResponse);
            release();
        } else if (authType.equals("REALID") || authType.equals("REALIDLITE_KYC")) {
            EkycFacade ekycFacade = EkycFacade.getInstance();
            EkycRequest ekycRequest = new EkycRequest();
            ekycRequest.bizConfig = zLZRequest.bizConfig;
            ekycRequest.bizConfig.put(HummerConstants.AUTH_TYPE, authType);
            ekycRequest.clientCfg = zLZRequest.zlzConfig;
            ekycRequest.eKYCId = BaseFacade.getFlowId(zLZRequest.zlzConfig);
            ekycFacade.startEkyc(ekycRequest, new IEkycCallback() { // from class: com.ap.zoloz.hummer.api.ZLZFacade.1
                @Override // com.ap.zoloz.hummer.api.IEkycCallback
                public void onCompletion(EkycResponse ekycResponse) {
                    ZLZResponse zLZResponse2 = new ZLZResponse();
                    zLZResponse2.retCode = ekycResponse.subCode;
                    zLZResponse2.extInfo = ekycResponse.extInfo;
                    if (ekycResponse.code == 1003) {
                        ZLZFacade.this.mIZLZCallback.onInterrupted(zLZResponse2);
                    } else {
                        ZLZFacade.this.mIZLZCallback.onCompleted(zLZResponse2);
                    }
                    ZLZFacade.this.release();
                }
            });
        } else {
            ConnectFacade connectFacade = ConnectFacade.getInstance();
            ConnectRequest connectRequest = new ConnectRequest();
            connectRequest.bizConfig = zLZRequest.bizConfig;
            connectRequest.bizConfig.put(HummerConstants.AUTH_TYPE, authType);
            connectRequest.connectConfig = zLZRequest.zlzConfig;
            connectRequest.connectId = BaseFacade.getFlowId(zLZRequest.zlzConfig);
            connectFacade.startConnect(connectRequest, new IConnectCallback() { // from class: com.ap.zoloz.hummer.api.ZLZFacade.2
                @Override // com.ap.zoloz.hummer.connect.api.IConnectCallback
                public void onCompletion(ConnectResponse connectResponse) {
                    ZLZResponse zLZResponse2 = new ZLZResponse();
                    zLZResponse2.retCode = connectResponse.subCode;
                    zLZResponse2.extInfo = connectResponse.extInfo;
                    if (connectResponse.code == 1003) {
                        ZLZFacade.this.mIZLZCallback.onInterrupted(zLZResponse2);
                    } else {
                        ZLZFacade.this.mIZLZCallback.onCompleted(zLZResponse2);
                    }
                    ZLZFacade.this.release();
                }
            });
        }
    }

    private void switchConstants(ZLZRequest zLZRequest) {
        updateValue(zLZRequest, ZLZConstants.CONTEXT, HummerConstants.HUMMER_CONTEXT);
        updateValue(zLZRequest, ZLZConstants.LOCALE, HummerConstants.HUMMER_LOCALE);
        updateValue(zLZRequest, "public_key", "public_key");
        updateValue(zLZRequest, ZLZConstants.CHAMELEON_CONFIG_PATH, HummerConstants.HUMMER_CONFIG_PATH);
    }

    private void updateValue(ZLZRequest zLZRequest, String str, String str2) {
        if (!str.equals(str2) && zLZRequest.bizConfig.containsKey(str)) {
            zLZRequest.bizConfig.put(str2, zLZRequest.bizConfig.remove(str));
        }
    }

    private boolean isSupporttedAuthType(String str) {
        return !StringUtil.isNullorEmpty(str) && (str.equals(FirebasePerformance.HttpMethod.CONNECT) || str.equals("ZDOC") || str.equals("ZFACE") || str.equals("REALID"));
    }

    public static String getMetaInfo(Context context) {
        return BaseFacade.getMetaInfo(context);
    }

    public void release() {
        this.mIZLZCallback = null;
        sIsBusy = false;
        sInstance = null;
    }
}
