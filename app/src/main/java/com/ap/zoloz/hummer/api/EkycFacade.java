package com.ap.zoloz.hummer.api;

import android.app.Activity;
import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.rpc.BioRPCService;
import com.alipay.mobile.security.bio.service.local.web.BioWebService;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.security.zim.api.ZIMFacade;
import com.alipay.zoloz.config.ConfigCenter;
import com.alipay.zoloz.config.IConfigCenterCallback;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.biz.HummerLogger;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.ap.zoloz.hummer.common.AlertManager;
import com.ap.zoloz.hummer.common.HummerContext;
import com.ap.zoloz.hummer.common.HummerCore;
import com.ap.zoloz.hummer.common.IAlertManagerCallback;
import com.ap.zoloz.hummer.common.IHummerCoreCallback;
import com.ap.zoloz.hummer.common.RecordManager;
import com.ap.zoloz.hummer.common.WebPageManager;
import com.ap.zoloz.hummer.common.WebTask;
import com.ap.zoloz.hummer.ekyc.biz.HummerEkycConstants;
import com.ap.zoloz.hummer.rpc.IRpcCallback;
import com.ap.zoloz.hummer.rpc.RpcManager;
import com.ap.zoloz.hummer.rpc.RpcResponse;
import com.zoloz.zhub.common.factor.facade.HummerGWFacade;
import java.util.HashMap;
import zoloz.ap.com.toolkit.ui.CustomButton;
import zoloz.ap.com.toolkit.ui.CustomTextView;

/* loaded from: classes3.dex */
public class EkycFacade extends BaseFacade {
    public static final String TAG = "EkycFacade";
    private static EkycFacade sInstance;
    private IEkycCallback mEkycCallback;
    private IAlertManagerCallback mIAlertManagerCallback;

    public EkycFacade() {
        this.mHummerContext = new HummerContext();
        this.mHummerContext.add(HummerConstants.CURRENT_TASK_NAME, HummerConstants.CONTEXT, TAG);
        this.mHummerCore = new HummerCore();
    }

    public static EkycFacade getInstance() {
        if (sInstance == null) {
            synchronized (EkycFacade.class) {
                if (sInstance == null) {
                    sInstance = new EkycFacade();
                }
            }
        }
        return sInstance;
    }

    public void startEkyc(final EkycRequest ekycRequest, IEkycCallback iEkycCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("EkycFacade startEkyc ");
        sb.append(ekycRequest.toString());
        HummerLogger.i(sb.toString());
        synchronized (EkycFacade.class) {
            if (sIsBusy) {
                forceQuit();
            }
        }
        sIsBusy = true;
        this.mEkycCallback = iEkycCallback;
        if (ekycRequest == null || this.mHummerContext == null || this.mHummerCore == null) {
            HummerLogger.e("illegal request!");
            return;
        }
        if (ekycRequest.bizConfig != null && ekycRequest.bizConfig.containsKey(HummerConstants.HUMMER_CONTEXT) && (ekycRequest.bizConfig.get(HummerConstants.HUMMER_CONTEXT) instanceof Activity)) {
            setContext((Context) ekycRequest.bizConfig.get(HummerConstants.HUMMER_CONTEXT));
        }
        if (this.mHummerContext.mContext == null) {
            HummerLogger.e("context is null!");
            EkycResponse ekycResponse = new EkycResponse();
            ekycResponse.code = 1003;
            ekycResponse.subCode = HummerZCodeConstant.CONTEXT_ERROR_CODE;
            ekycResponse.result = HummerZCodeConstant.CONTEXT_ERROR_MSG;
            finalizeEkyc(ekycResponse);
            return;
        }
        this.mIAlertManagerCallback = new IAlertManagerCallback() { // from class: com.ap.zoloz.hummer.api.EkycFacade.1
            @Override // com.ap.zoloz.hummer.common.IAlertManagerCallback
            public void onHandelNetworkError(boolean z) {
            }

            @Override // com.ap.zoloz.hummer.common.IAlertManagerCallback
            public void onHandelSystemError() {
                EkycFacade.this.cancelEkyc();
            }
        };
        if (StringUtil.isNullorEmpty(ekycRequest.eKYCId)) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.HUMMERID_ERROR_CODE);
            this.mHummerContext.updateZStack(TAG, HummerZCodeConstant.HUMMERID_ERROR_CODE);
            AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
            return;
        }
        this.mHummerContext.mHummerId = ekycRequest.eKYCId;
        ConfigCenter.getInstance().getBizConfig().putAll(ekycRequest.bizConfig);
        if (StringUtil.isNullorEmpty(ekycRequest.clientCfg)) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.CLIENT_CFG_ERROR_CODE);
            this.mHummerContext.updateZStack(TAG, HummerZCodeConstant.CLIENT_CFG_ERROR_CODE);
            AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
        } else if (!parseAndSetConfig(ekycRequest.clientCfg)) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.INCORRECT_CLIENT_CONFIG);
            this.mHummerContext.updateZStack(TAG, HummerZCodeConstant.INCORRECT_CLIENT_CONFIG);
            AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(HummerConstants.HUMMER_ID, this.mHummerContext.mHummerId);
            if (this.mHummerContext.query("DEVICE_ID") != null) {
                hashMap.put("DEVICE_ID", (String) this.mHummerContext.query("DEVICE_ID"));
            }
            if (this.mHummerContext.query("MERCHANT_USER_ID") != null) {
                hashMap.put("userId", (String) this.mHummerContext.query("MERCHANT_USER_ID"));
            }
            if (this.mHummerContext.query(HummerConstants.REMOTELOG_URL) != null) {
                hashMap.put(HummerConstants.REMOTELOG_URL, (String) this.mHummerContext.query(HummerConstants.REMOTELOG_URL));
            }
            if (ConfigCenter.getInstance().getBizConfig().get(HummerConstants.AUTH_TYPE) != null) {
                hashMap.put(HummerConstants.AUTH_TYPE, (String) ConfigCenter.getInstance().getBizConfig().get(HummerConstants.AUTH_TYPE));
            } else {
                hashMap.put(HummerConstants.AUTH_TYPE, "EKYC");
            }
            RecordManager.getInstance().init(this.mHummerContext.mContext, hashMap);
            HashMap hashMap2 = new HashMap();
            String str = null;
            hashMap2.put("sdkVersion", ZIMFacade.getZimMetaInfo(this.mHummerContext.mContext, null).getBioMetaInfo());
            RecordManager.getInstance().record(HummerEkycConstants.START_EKYC, hashMap2);
            if (ekycRequest.bizConfig != null && ekycRequest.bizConfig.containsKey(HummerConstants.HUMMER_CONFIG_PATH)) {
                str = (String) ekycRequest.bizConfig.get(HummerConstants.HUMMER_CONFIG_PATH);
            }
            if (ekycRequest.bizConfig != null && ekycRequest.bizConfig.containsKey("zlz_font_style")) {
                String str2 = (String) ekycRequest.bizConfig.get("zlz_font_style");
                CustomTextView.setFontName(str2);
                CustomButton.setFontName(str2);
            }
            ConfigCenter.getInstance().init(this.mHummerContext.mContext.getApplicationContext(), str, new IConfigCenterCallback() { // from class: com.ap.zoloz.hummer.api.EkycFacade.2
                @Override // com.alipay.zoloz.config.IConfigCenterCallback
                public void onConfigSuccess() {
                    synchronized (EkycFacade.this) {
                        if (EkycFacade.this.mHummerContext == null) {
                            return;
                        }
                        HummerLogger.i(EkycFacade.TAG, "onConfigSuccess");
                        if (!EkycFacade.this.customizePublicKey()) {
                            EkycFacade.this.mHummerContext.recordSystemError(EkycFacade.TAG, HummerZCodeConstant.PUBLIC_KEY_NULL_ERROR);
                            EkycFacade.this.mHummerContext.updateZStack(EkycFacade.TAG, HummerZCodeConstant.PUBLIC_KEY_NULL_ERROR);
                            AlertManager.getInstance().alertSystemError(EkycFacade.this.mIAlertManagerCallback);
                            return;
                        }
                        BioRPCService bioRPCService = (BioRPCService) BioServiceManager.getLocalService(EkycFacade.this.mHummerContext.mContext.getApplicationContext(), BioRPCService.class);
                        bioRPCService.setRemoteUrl(String.valueOf(EkycFacade.this.mHummerContext.query(HummerConstants.GATEWAY_URL_KEY)));
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("WORKSPACE_ID", String.valueOf(EkycFacade.this.mHummerContext.query("WORKSPACE_ID")));
                        hashMap3.put("APP_ID", String.valueOf(EkycFacade.this.mHummerContext.query("APP_ID")));
                        bioRPCService.setExtProperties(hashMap3);
                        RpcManager.getInstance().init((HummerGWFacade) bioRPCService.getRpcProxy(HummerGWFacade.class));
                        if (!EkycFacade.this.parseUIConfig("UI.json")) {
                            EkycFacade.this.mHummerContext.recordSystemError(EkycFacade.TAG, HummerZCodeConstant.PARSE_CONFIG_ERROR_CODE);
                            EkycFacade.this.mHummerContext.updateZStack(EkycFacade.TAG, HummerZCodeConstant.PARSE_CONFIG_ERROR_CODE);
                            AlertManager.getInstance().alertSystemError(EkycFacade.this.mIAlertManagerCallback);
                            return;
                        }
                        WebPageManager.getInstance().init((BioWebService) BioServiceManager.getLocalService(EkycFacade.this.mHummerContext.mContext.getApplicationContext(), BioWebService.class));
                        RecordManager.getInstance().record(HummerConstants.ZTECH_CHECK_PASS, null);
                        EkycFacade.this.customizeLocale(ekycRequest.bizConfig);
                        EkycFacade.this.mHummerCore.schedule(EkycFacade.this.mHummerContext, new IHummerCoreCallback() { // from class: com.ap.zoloz.hummer.api.EkycFacade.2.1
                            /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
                            @Override // com.ap.zoloz.hummer.common.IHummerCoreCallback
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public void onCompletion(com.ap.zoloz.hummer.common.HummerContext r5) {
                                /*
                                    r4 = this;
                                    com.ap.zoloz.hummer.api.EkycFacade$2 r0 = com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.this
                                    com.ap.zoloz.hummer.api.EkycFacade r0 = com.ap.zoloz.hummer.api.EkycFacade.this
                                    com.ap.zoloz.hummer.common.HummerContext r0 = r0.mHummerContext
                                    java.lang.String r1 = "currentTaskName"
                                    java.lang.String r2 = "context"
                                    java.lang.String r3 = "EkycFacade"
                                    r0.add(r1, r2, r3)
                                    com.ap.zoloz.hummer.api.EkycResponse r0 = new com.ap.zoloz.hummer.api.EkycResponse
                                    r0.<init>()
                                    com.ap.zoloz.hummer.api.EkycFacade$2 r1 = com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.this
                                    com.ap.zoloz.hummer.api.EkycFacade r1 = com.ap.zoloz.hummer.api.EkycFacade.this
                                    r1.mHummerContext = r5
                                    com.ap.zoloz.hummer.api.EkycFacade$2 r5 = com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.this
                                    com.ap.zoloz.hummer.api.EkycFacade r5 = com.ap.zoloz.hummer.api.EkycFacade.this
                                    com.ap.zoloz.hummer.common.HummerContext r5 = r5.mHummerContext
                                    java.lang.String r1 = "hummer_response"
                                    java.lang.Object r5 = r5.query(r1)
                                    com.ap.zoloz.hummer.common.HummerResponse r5 = (com.ap.zoloz.hummer.common.HummerResponse) r5
                                    if (r5 == 0) goto L80
                                    java.lang.String r1 = r5.hummerId
                                    r0.eKYCId = r1
                                    int r1 = r5.code
                                    r2 = 1000(0x3e8, float:1.401E-42)
                                    if (r1 == r2) goto L76
                                    r2 = 1003(0x3eb, float:1.406E-42)
                                    if (r1 == r2) goto L4d
                                    r2 = 2006(0x7d6, float:2.811E-42)
                                    if (r1 == r2) goto L4b
                                    r5 = 3000(0xbb8, float:4.204E-42)
                                    if (r1 != r5) goto L51
                                    r0.code = r5
                                    java.lang.String r5 = "Z7005"
                                    r0.subCode = r5
                                    java.lang.String r5 = "Zoloz eKYC is pending"
                                    r0.result = r5
                                    goto L80
                                L4b:
                                    r0.code = r2
                                L4d:
                                    int r5 = r5.code
                                    r0.code = r5
                                L51:
                                    com.ap.zoloz.hummer.api.EkycFacade$2 r5 = com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.this
                                    com.ap.zoloz.hummer.api.EkycFacade r5 = com.ap.zoloz.hummer.api.EkycFacade.this
                                    com.ap.zoloz.hummer.common.HummerContext r5 = r5.mHummerContext
                                    if (r5 == 0) goto L80
                                    com.ap.zoloz.hummer.api.EkycFacade$2 r5 = com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.this
                                    com.ap.zoloz.hummer.api.EkycFacade r5 = com.ap.zoloz.hummer.api.EkycFacade.this
                                    com.ap.zoloz.hummer.common.HummerContext r5 = r5.mHummerContext
                                    java.lang.String r5 = r5.getLastZStackCode()
                                    r0.subCode = r5
                                    com.ap.zoloz.hummer.api.EkycFacade$2 r5 = com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.this
                                    com.ap.zoloz.hummer.api.EkycFacade r5 = com.ap.zoloz.hummer.api.EkycFacade.this
                                    com.ap.zoloz.hummer.common.HummerContext r5 = r5.mHummerContext
                                    java.util.List r5 = r5.getZStack()
                                    java.lang.String r5 = com.alibaba.fastjson.JSON.toJSONString(r5)
                                    r0.result = r5
                                    goto L80
                                L76:
                                    r0.code = r2
                                    java.lang.String r5 = "Z7003"
                                    r0.subCode = r5
                                    java.lang.String r5 = "Zoloz eKYC success"
                                    r0.result = r5
                                L80:
                                    com.ap.zoloz.hummer.api.EkycFacade$2 r5 = com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.this
                                    com.ap.zoloz.hummer.api.EkycFacade r5 = com.ap.zoloz.hummer.api.EkycFacade.this
                                    com.ap.zoloz.hummer.api.EkycFacade.access$200(r5, r0)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.ap.zoloz.hummer.api.EkycFacade.AnonymousClass2.AnonymousClass1.onCompletion(com.ap.zoloz.hummer.common.HummerContext):void");
                            }
                        }, true);
                    }
                }

                @Override // com.alipay.zoloz.config.IConfigCenterCallback
                public void onConfigFail(String str3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onConfigFail ");
                    sb2.append(str3);
                    HummerLogger.i(EkycFacade.TAG, sb2.toString());
                    EkycFacade.this.mHummerContext.recordSystemError(EkycFacade.TAG, str3);
                    EkycFacade.this.mHummerContext.updateZStack(EkycFacade.TAG, str3);
                    AlertManager.getInstance().alertSystemError(EkycFacade.this.mIAlertManagerCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ap.zoloz.hummer.api.BaseFacade
    public void release() {
        synchronized (this) {
            HummerLogger.i("releasing");
            super.release();
            sIsBusy = false;
            if (sInstance != null) {
                sInstance = null;
            }
            this.mEkycCallback = null;
            this.mIAlertManagerCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ap.zoloz.hummer.api.BaseFacade
    public void forceQuit() {
        HummerLogger.i("forceQuitting");
        super.forceQuit();
        this.mIAlertManagerCallback = null;
    }

    public void forceRelease() {
        if (sIsBusy) {
            HashMap hashMap = new HashMap();
            hashMap.put(HummerEkycConstants.END_STATUS, HummerEkycConstants.LOGIN_EXPIRED);
            RecordManager.getInstance().record(HummerEkycConstants.END_EKYC, hashMap);
            forceQuit();
            release();
        }
    }

    public HummerContext getHummerContext() {
        return this.mHummerContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finalizeEkyc(EkycResponse ekycResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put(HummerConstants.PROD_RET_CODE, String.valueOf(ekycResponse.code));
        hashMap.put(HummerConstants.PROD_SUB_RET_CODE, ekycResponse.subCode);
        RecordManager.getInstance().record(HummerEkycConstants.END_EKYC, hashMap);
        IEkycCallback iEkycCallback = this.mEkycCallback;
        if (iEkycCallback != null) {
            iEkycCallback.onCompletion(ekycResponse);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ekyc response =");
        sb.append(ekycResponse.toString());
        HummerLogger.i(sb.toString());
        release();
    }

    public void endWebTask(int i, String str) {
        HummerLogger.i("endWebTask ");
        if (this.mHummerContext == null || this.mHummerCore == null) {
            return;
        }
        if (this.mHummerContext.getCurrentTaskConfig().type.equals(HummerConstants.WEB_TASK)) {
            WebTask webTask = (WebTask) this.mHummerCore.getCurrentTask();
            if (webTask != null) {
                webTask.handleResult(i, str);
                return;
            }
            return;
        }
        this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.WEBTASK_ERROR_CODE);
        this.mHummerContext.updateZStack(TAG, HummerZCodeConstant.WEBTASK_ERROR_CODE);
        AlertManager.getInstance().alertSystemError(this.mIAlertManagerCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelEkyc() {
        if (this.mHummerContext == null) {
            return;
        }
        int cancelIndex = this.mHummerContext.getCancelIndex();
        if (cancelIndex == 0) {
            this.mHummerContext.recordSystemError(TAG, HummerZCodeConstant.INVALID_CANCEL_INDEX);
            cancelExit();
            return;
        }
        RpcManager.getInstance().sendRpc(new IRpcCallback() { // from class: com.ap.zoloz.hummer.api.EkycFacade.3
            @Override // com.ap.zoloz.hummer.rpc.IRpcCallback
            public void onCompletion(RpcResponse rpcResponse) {
                EkycFacade.this.cancelExit();
            }
        }, RpcManager.getInstance().formatRequest(this.mHummerContext, cancelIndex, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelExit() {
        WebPageManager.getInstance().exitSession();
        EkycResponse ekycResponse = new EkycResponse();
        ekycResponse.code = 1003;
        if (this.mHummerContext != null) {
            ekycResponse.subCode = this.mHummerContext.getLastZStackCode();
            ekycResponse.result = JSON.toJSONString(this.mHummerContext.getZStack());
        }
        finalizeEkyc(ekycResponse);
    }
}
