package com.ap.zoloz.hummer.connect.api;

import android.app.Activity;
import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.rpc.BioRPCService;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.security.zim.api.ZIMFacade;
import com.alipay.zoloz.config.ConfigCenter;
import com.alipay.zoloz.config.IConfigCenterCallback;
import com.ap.zoloz.hummer.api.BaseFacade;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.biz.HummerLogger;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.ap.zoloz.hummer.common.AlertManager;
import com.ap.zoloz.hummer.common.HummerContext;
import com.ap.zoloz.hummer.common.HummerCore;
import com.ap.zoloz.hummer.common.HummerResponse;
import com.ap.zoloz.hummer.common.IAlertManagerCallback;
import com.ap.zoloz.hummer.common.IHummerCoreCallback;
import com.ap.zoloz.hummer.common.RecordManager;
import com.ap.zoloz.hummer.connect.biz.HummerConnectConstants;
import com.ap.zoloz.hummer.rpc.RpcManager;
import com.google.firebase.perf.FirebasePerformance;
import com.zoloz.zhub.common.factor.facade.HummerGWFacade;
import java.util.HashMap;
import java.util.UUID;
import zoloz.ap.com.toolkit.ui.CustomButton;
import zoloz.ap.com.toolkit.ui.CustomTextView;

/* loaded from: classes3.dex */
public class ConnectFacade extends BaseFacade {
    public static final String TAG = "ConnectFacade";
    private static ConnectFacade sInstance;
    private IAlertManagerCallback iAlertManagerCallback;
    private boolean isFromClient;
    private IConnectCallback mIConnectCallback;

    public static ConnectFacade getInstance() {
        if (sInstance == null) {
            synchronized (ConnectFacade.class) {
                if (sInstance == null) {
                    sInstance = new ConnectFacade();
                }
            }
        }
        return sInstance;
    }

    public ConnectFacade() {
        this.mHummerContext = new HummerContext();
        this.mHummerCore = new HummerCore();
    }

    public void startConnect(final ConnectRequest connectRequest, IConnectCallback iConnectCallback) {
        this.mIConnectCallback = iConnectCallback;
        synchronized (ConnectFacade.class) {
            if (sIsBusy) {
                forceQuit();
            }
        }
        sIsBusy = true;
        if (connectRequest == null || this.mHummerContext == null || this.mHummerCore == null) {
            HummerLogger.e("illegal request!");
            return;
        }
        CustomTextView.setFontName("");
        CustomButton.setFontName("");
        if (connectRequest.bizConfig != null && connectRequest.bizConfig.containsKey(HummerConstants.HUMMER_CONTEXT)) {
            if (connectRequest.bizConfig.get(HummerConstants.HUMMER_CONTEXT) instanceof Activity) {
                setContext((Context) connectRequest.bizConfig.get(HummerConstants.HUMMER_CONTEXT));
            } else {
                HummerLogger.e("context is not activity context!");
                return;
            }
        }
        if (this.mHummerContext.mContext == null) {
            HummerLogger.e("context is null!");
            return;
        }
        if (StringUtil.isNullorEmpty(connectRequest.connectId)) {
            this.isFromClient = true;
        } else {
            this.isFromClient = false;
        }
        if (this.isFromClient && (connectRequest.bizConfig == null || !connectRequest.bizConfig.containsKey(HummerConnectConstants.BIZ_SENCE) || !connectRequest.bizConfig.containsKey("merchantId"))) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.CONNECT_INPUT_PARAM_CHECK_FAIL_CODE);
            this.mHummerContext.updateZStack(TAG, HummerZCodeConstant.CONNECT_INPUT_PARAM_CHECK_FAIL_CODE);
            AlertManager.getInstance().alertSystemError(this.iAlertManagerCallback);
        } else if (StringUtil.isNullorEmpty(connectRequest.connectConfig) || !parseAndSetConfig(connectRequest.connectConfig)) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.CONNECT_INPUT_PARAM_CHECK_FAIL_CODE);
            this.mHummerContext.updateZStack(TAG, HummerZCodeConstant.CONNECT_INPUT_PARAM_CHECK_FAIL_CODE);
            AlertManager.getInstance().alertSystemError(this.iAlertManagerCallback);
        } else {
            ConfigCenter.getInstance().getBizConfig().putAll(connectRequest.bizConfig);
            HashMap hashMap = new HashMap();
            if (this.mHummerContext.query("DEVICE_ID") != null) {
                hashMap.put("DEVICE_ID", (String) this.mHummerContext.query("DEVICE_ID"));
            }
            if (this.mHummerContext.query("MERCHANT_USER_ID") != null) {
                hashMap.put("userId", (String) this.mHummerContext.query("MERCHANT_USER_ID"));
            }
            if (this.mHummerContext.query(HummerConstants.REMOTELOG_URL) != null) {
                hashMap.put(HummerConstants.REMOTELOG_URL, (String) this.mHummerContext.query(HummerConstants.REMOTELOG_URL));
            }
            if (this.isFromClient) {
                hashMap.put("bizId", UUID.randomUUID().toString());
            } else {
                this.mHummerContext.mHummerId = connectRequest.connectId;
                hashMap.put(HummerConstants.HUMMER_ID, this.mHummerContext.mHummerId);
            }
            if (ConfigCenter.getInstance().getBizConfig().get(HummerConstants.AUTH_TYPE) != null) {
                hashMap.put(HummerConstants.AUTH_TYPE, (String) ConfigCenter.getInstance().getBizConfig().get(HummerConstants.AUTH_TYPE));
            } else {
                hashMap.put(HummerConstants.AUTH_TYPE, FirebasePerformance.HttpMethod.CONNECT);
            }
            RecordManager.getInstance().init(this.mHummerContext.mContext, hashMap);
            HashMap hashMap2 = new HashMap();
            String str = null;
            if (this.mHummerContext != null && this.mHummerContext.mContext != null) {
                hashMap2.put("sdkVersion", ZIMFacade.getZimMetaInfo(this.mHummerContext.mContext, null).getBioMetaInfo());
                if (this.isFromClient) {
                    hashMap2.put(HummerConnectConstants.BIZ_SENCE, (String) connectRequest.bizConfig.get(HummerConnectConstants.BIZ_SENCE));
                }
            }
            RecordManager.getInstance().record(HummerConnectConstants.START_CONNECT, hashMap2);
            hashMap2.clear();
            hashMap2.put("module", "hummer");
            RecordManager.getInstance().record(HummerConstants.ZTECH_ENRTER, hashMap2);
            this.iAlertManagerCallback = new IAlertManagerCallback() { // from class: com.ap.zoloz.hummer.connect.api.ConnectFacade.1
                @Override // com.ap.zoloz.hummer.common.IAlertManagerCallback
                public void onHandelNetworkError(boolean z) {
                }

                @Override // com.ap.zoloz.hummer.common.IAlertManagerCallback
                public void onHandelSystemError() {
                    ConnectResponse connectResponse = new ConnectResponse();
                    connectResponse.code = 1003;
                    if (ConnectFacade.this.mHummerContext != null) {
                        connectResponse.subCode = ConnectFacade.this.mHummerContext.getLastZStackCode();
                        connectResponse.result = JSON.toJSONString(ConnectFacade.this.mHummerContext.getZStack());
                    }
                    ConnectFacade.this.finalizeConnect(connectResponse);
                }
            };
            if (connectRequest.bizConfig != null && connectRequest.bizConfig.containsKey(HummerConstants.HUMMER_CONFIG_PATH)) {
                str = (String) connectRequest.bizConfig.get(HummerConstants.HUMMER_CONFIG_PATH);
            }
            if (connectRequest.bizConfig != null && connectRequest.bizConfig.containsKey("zlz_font_style")) {
                String str2 = (String) connectRequest.bizConfig.get("zlz_font_style");
                CustomTextView.setFontName(str2);
                CustomButton.setFontName(str2);
            }
            ConfigCenter.getInstance().init(this.mHummerContext.mContext.getApplicationContext(), str, new IConfigCenterCallback() { // from class: com.ap.zoloz.hummer.connect.api.ConnectFacade.2
                @Override // com.alipay.zoloz.config.IConfigCenterCallback
                public void onConfigSuccess() {
                    synchronized (ConnectFacade.this) {
                        ConnectFacade.this.customizeLocale(connectRequest.bizConfig);
                        if (!ConnectFacade.this.customizePublicKey()) {
                            ConnectFacade.this.mHummerContext.recordSystemError(ConnectFacade.TAG, HummerZCodeConstant.PUBLIC_KEY_NULL_ERROR);
                            ConnectFacade.this.mHummerContext.updateZStack(ConnectFacade.TAG, HummerZCodeConstant.PUBLIC_KEY_NULL_ERROR);
                            AlertManager.getInstance().alertSystemError(ConnectFacade.this.iAlertManagerCallback);
                            return;
                        }
                        BioRPCService bioRPCService = (BioRPCService) BioServiceManager.getLocalService(ConnectFacade.this.mHummerContext.mContext.getApplicationContext(), BioRPCService.class);
                        bioRPCService.setRemoteUrl(String.valueOf(ConnectFacade.this.mHummerContext.query(HummerConstants.GATEWAY_URL_KEY)));
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("WORKSPACE_ID", String.valueOf(ConnectFacade.this.mHummerContext.query("WORKSPACE_ID")));
                        hashMap3.put("APP_ID", String.valueOf(ConnectFacade.this.mHummerContext.query("APP_ID")));
                        bioRPCService.setExtProperties(hashMap3);
                        RpcManager.getInstance().init((HummerGWFacade) bioRPCService.getRpcProxy(HummerGWFacade.class));
                        if (!ConnectFacade.this.isFromClient) {
                            ConnectFacade.this.startProcess();
                        }
                    }
                }

                @Override // com.alipay.zoloz.config.IConfigCenterCallback
                public void onConfigFail(String str3) {
                    ConnectFacade.this.mHummerContext.recordSystemError(ConnectFacade.TAG, str3);
                    ConnectFacade.this.mHummerContext.updateZStack(ConnectFacade.TAG, str3);
                    AlertManager.getInstance().alertSystemError(ConnectFacade.this.iAlertManagerCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finalizeConnect(ConnectResponse connectResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put(HummerConstants.PROD_RET_CODE, String.valueOf(connectResponse.code));
        hashMap.put(HummerConstants.PROD_SUB_RET_CODE, connectResponse.subCode);
        RecordManager.getInstance().record(HummerConnectConstants.END_CONNECT, hashMap);
        IConnectCallback iConnectCallback = this.mIConnectCallback;
        if (iConnectCallback != null) {
            iConnectCallback.onCompletion(connectResponse);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Connect response =");
        sb.append(connectResponse.toString());
        HummerLogger.i(sb.toString());
        hashMap.clear();
        hashMap.put("module", "hummer");
        RecordManager.getInstance().record(HummerConstants.ZTECH_EXIT, hashMap);
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startProcess() {
        this.mHummerCore.schedule(this.mHummerContext, new IHummerCoreCallback() { // from class: com.ap.zoloz.hummer.connect.api.ConnectFacade.3
            @Override // com.ap.zoloz.hummer.common.IHummerCoreCallback
            public void onCompletion(HummerContext hummerContext) {
                ConnectFacade.this.mHummerContext.add(HummerConstants.CURRENT_TASK_NAME, HummerConstants.CONTEXT, ConnectFacade.TAG);
                ConnectResponse connectResponse = new ConnectResponse();
                ConnectFacade.this.mHummerContext = hummerContext;
                HummerResponse hummerResponse = (HummerResponse) ConnectFacade.this.mHummerContext.query(HummerConstants.HUMMER_RESPONSE);
                if (hummerResponse != null) {
                    int i = hummerResponse.code;
                    if (i == 1000) {
                        connectResponse.code = 1000;
                        connectResponse.subCode = ConnectResponse.ZOLOZ_CONNECT_SUCCESS;
                        connectResponse.result = ConnectResponse.ZOLOZ_CONNECT_SUCCESS_MSG;
                    } else if (i == 2006) {
                        connectResponse.code = 2006;
                        if (ConnectFacade.this.mHummerContext != null) {
                            connectResponse.subCode = ConnectFacade.this.mHummerContext.getLastZStackCode();
                            connectResponse.result = JSON.toJSONString(ConnectFacade.this.mHummerContext.getZStack());
                        }
                    } else {
                        connectResponse.code = 1003;
                        if (ConnectFacade.this.mHummerContext != null) {
                            connectResponse.subCode = ConnectFacade.this.mHummerContext.getLastZStackCode();
                            connectResponse.result = JSON.toJSONString(ConnectFacade.this.mHummerContext.getZStack());
                        }
                    }
                    ConnectFacade.this.finalizeConnect(connectResponse);
                }
            }
        }, false);
    }

    @Override // com.ap.zoloz.hummer.api.BaseFacade
    public void release() {
        synchronized (this) {
            super.release();
            if (sInstance != null) {
                sInstance = null;
            }
            this.mIConnectCallback = null;
        }
    }
}
