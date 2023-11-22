package com.alipay.mobile.security.zim.biz;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alipay.biometrics.ui.widget.LoadingProgressDialog;
import com.alipay.bis.common.service.facade.gw.zim.ZimInitGwRequest;
import com.alipay.bis.common.service.facade.gw.zim.ZimInitGwResponse;
import com.alipay.bis.common.service.facade.gw.zim.ZimValidateGwResponse;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipay.mobile.security.bio.api.BioDetectorBuilder;
import com.alipay.mobile.security.bio.api.BioParameter;
import com.alipay.mobile.security.bio.api.BioProgressCallback;
import com.alipay.mobile.security.bio.api.BioResponse;
import com.alipay.mobile.security.bio.constants.ZcodeConstants;
import com.alipay.mobile.security.bio.module.MicroModule;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.bio.service.BioUploadServiceCore;
import com.alipay.mobile.security.bio.service.ZimRecordService;
import com.alipay.mobile.security.bio.service.local.apsecurity.ApSecurityService;
import com.alipay.mobile.security.bio.service.local.monitorlog.MonitorLogService;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.security.bio.workspace.Env;
import com.alipay.mobile.security.zim.R;
import com.alipay.mobile.security.zim.api.ZIMCallback;
import com.alipay.mobile.security.zim.api.ZIMFacade;
import com.alipay.mobile.security.zim.api.ZIMResponse;
import com.alipay.mobile.security.zim.api.ZimProgressCallback;
import com.alipay.mobile.security.zim.gw.BaseGwService;
import com.alipay.mobile.security.zim.gw.BioUploadServiceCoreZhub;
import com.alipay.mobile.security.zim.gw.GwListener;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import zoloz.ap.com.toolkit.ui.DialogHelper;

/* loaded from: classes7.dex */
public class ZimPlatform extends ZIMFacade implements GwListener, BioProgressCallback {
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_RESULT = "result";
    public static final String KEY_RET_CODE = "retCode";
    public static final String KEY_SUB_CODE = "subCode";
    public static final String KEY_SUB_MSG = "subMsg";
    public static final String REASON_0 = "0";
    private static Context mH5Context;
    private static boolean sIsBusy;
    private BaseGwService mBaseGWService;
    private BioDetector mBioDetector;
    private BioServiceManager mBioServiceManager;
    private Context mContext;
    private String mFacePayInfo;
    private LoadingProgressDialog mLoadingProgressDialog;
    private Map<String, String> mParams;
    private ZIMCallback mZIMCallback;
    private ZimMessageChannel mZimMessageChannel;
    public static final String RESULT_TRUE = Boolean.TRUE.toString();
    public static final String RESULT_FALSE = Boolean.FALSE.toString();
    private String mZimId = "";
    private BioParameter mBioParameter = new BioParameter();
    private boolean isInit = false;

    public ZimPlatform(Context context) {
        this.mContext = context;
        try {
            Constructor<?> constructor = Class.forName(Env.getProtocolFormat(context) != 2 ? "com.alipay.mobile.security.zim.gw.JsonGwService" : "com.alipay.mobile.security.zim.gw.PbGwService").getConstructor(GwListener.class);
            constructor.setAccessible(true);
            this.mBaseGWService = (BaseGwService) constructor.newInstance(this);
        } catch (Throwable unused) {
            ZIMResponse zIMResponse = new ZIMResponse();
            zIMResponse.subCode = ZcodeConstants.ZCODE_PROGURD_ERROR;
            zIMResponse.msg = ZcodeConstants.getMessage(zIMResponse.subCode);
            zIMResponse.code = 1001;
            zIMResponse.extInfo.put(ZIMFacade.KEY_BIO_ACTION, RecordError.ERROR_VERIFY_APP);
            doCallZimCallback(zIMResponse);
        }
    }

    public static void setH5Context(Context context) {
        mH5Context = context;
    }

    private void initZoloz(Context context, String str, ZimMessageChannel zimMessageChannel) {
        if (!this.isInit) {
            createLoadingDialog();
        }
        this.mBioDetector = BioDetectorBuilder.create(context, new MicroModule(str));
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        this.mBioServiceManager = currentInstance;
        ApSecurityService apSecurityService = (ApSecurityService) currentInstance.getBioService(ApSecurityService.class);
        if (apSecurityService != null) {
            apSecurityService.init(this.mContext);
        }
        this.mZimMessageChannel = zimMessageChannel;
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public ZimInitGwResponse parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mBaseGWService.convert(str);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void verify(String str, Map<String, String> map, ZIMCallback zIMCallback) {
        verify(str, map, (ZimMessageChannel) null, zIMCallback);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void verify(String str, Map<String, String> map, ZimMessageChannel zimMessageChannel, ZIMCallback zIMCallback) {
        if (map != null) {
            r0 = map.containsKey("zimInitResp") ? parse(map.remove("zimInitResp")) : null;
            if (r0 == null) {
                if (map.containsKey(ZIMFacade.KEY_INIT_RESP_OLD)) {
                    r0 = parse(map.remove(ZIMFacade.KEY_INIT_RESP_OLD));
                }
            } else {
                map.remove(ZIMFacade.KEY_INIT_RESP_OLD);
            }
        }
        verify(str, r0, map, zimMessageChannel, zIMCallback);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void verify(String str, ZimInitGwResponse zimInitGwResponse, Map<String, String> map, ZIMCallback zIMCallback) {
        verify(str, zimInitGwResponse, map, null, zIMCallback);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void verify(String str, ZimInitGwResponse zimInitGwResponse, Map<String, String> map, ZimMessageChannel zimMessageChannel, ZIMCallback zIMCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("zimId cant be null");
        }
        if (zIMCallback == null) {
            throw new IllegalArgumentException("ZIMCallback cant be null");
        }
        synchronized (ZimPlatform.class) {
            if (sIsBusy) {
                ZIMResponse zIMResponse = new ZIMResponse();
                zIMResponse.code = 2006;
                zIMResponse.reason = "busy";
                zIMResponse.subCode = ZcodeConstants.ZCODE_ZIM_IS_BUSY;
                zIMResponse.extInfo.put(ZIMFacade.KEY_BIO_ACTION, "400");
                recordVerifyResponse(zIMResponse);
                zIMCallback.response(zIMResponse);
                return;
            }
            sIsBusy = true;
            this.mZimId = str;
            this.mParams = map;
            this.mZIMCallback = zIMCallback;
            StringUtil.map2String(map);
            String str2 = null;
            if (map != null && map.containsKey(ZIMFacade.KEY_ENV_NAME)) {
                str2 = map.remove(ZIMFacade.KEY_ENV_NAME);
            }
            initEnv(this.mContext, str2);
            initZoloz(this.mContext, str, zimMessageChannel);
            RecordProcessor recordProcessor = RecordProcessor.getInstance();
            if (recordProcessor == null) {
                recordProcessor = RecordProcessor.createInstance(this.mContext);
            }
            recordProcessor.zimInit(str);
            recordProcessor.record(RecordProcessor.KEY_ZIM_START);
            recordProcessor.record(RecordProcessor.KEY_VERIFY_REQUEST);
            HashMap hashMap = new HashMap();
            hashMap.put("module", "zim");
            recordProcessor.record(RecordProcessor.KEY_ZTECH_ENRTER, hashMap);
            boolean z = zimInitGwResponse != null;
            String bool = Boolean.toString(z);
            this.mBioParameter.addExtProperty("mock", bool);
            if (z) {
                onInit(zimInitGwResponse);
            } else {
                performInitRequest(str, map, bool);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performInitRequest(String str, Map<String, String> map, String str2) {
        showLoadingDialog();
        ZimInitGwRequest zimInitGwRequest = new ZimInitGwRequest();
        zimInitGwRequest.zimId = str;
        zimInitGwRequest.metaInfo = getMetaInfos(this.mContext, null, false);
        if (map != null && map.containsKey(ZIMFacade.KEY_BIZ_DATA)) {
            zimInitGwRequest.bizData = map.get(ZIMFacade.KEY_BIZ_DATA);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mock", str2);
        hashMap.put("payload", String.valueOf(JSON.toJSONString(zimInitGwRequest).getBytes().length / 1024.0f));
        RecordProcessor.getInstance().record(RecordProcessor.KEY_INITPROD_REQUEST, hashMap);
        this.mBaseGWService.init(zimInitGwRequest);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void init(String str, ZimInitGwResponse zimInitGwResponse, Map<String, String> map, ZIMCallback zIMCallback) {
        init(str, zimInitGwResponse, map, null, zIMCallback);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void init(String str, ZimInitGwResponse zimInitGwResponse, Map<String, String> map, ZimMessageChannel zimMessageChannel, ZIMCallback zIMCallback) {
        this.isInit = true;
        verify(str, zimInitGwResponse, map, zimMessageChannel, zIMCallback);
    }

    @Override // com.alipay.mobile.security.bio.api.BioCallback
    public void onResult(BioResponse bioResponse) {
        HashMap hashMap = new HashMap(2);
        StringBuilder sb = new StringBuilder();
        sb.append(bioResponse.isSuccess());
        hashMap.put("result", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bioResponse.getResultMessage());
        hashMap.put("message", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(bioResponse.getResult());
        hashMap.put("retCode", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(bioResponse.subCode);
        hashMap.put("subCode", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(bioResponse.subMsg);
        hashMap.put(KEY_SUB_MSG, sb5.toString());
        RecordProcessor recordProcessor = RecordProcessor.getInstance();
        if (recordProcessor == null) {
            recordProcessor = RecordProcessor.createInstance(this.mContext);
        }
        recordProcessor.zimInit(this.mZimId);
        recordProcessor.record(RecordProcessor.KEY_AUTH_RESPONSE, hashMap);
        Map<String, String> ext = bioResponse.getExt();
        ZIMResponse zIMResponse = null;
        boolean z = true;
        if (ext != null && !ext.isEmpty()) {
            if (ext.containsKey(BioDetector.EXT_KEY_UPLOAD_RESPONSE)) {
                BioUploadResult bioUploadResult = (BioUploadResult) JSON.parseObject(ext.remove(BioDetector.EXT_KEY_UPLOAD_RESPONSE), BioUploadResult.class);
                ZIMResponse zIMResponse2 = new ZIMResponse();
                zIMResponse2.code = bioUploadResult.validationRetCode;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(bioUploadResult.validationRetCode);
                zIMResponse2.reason = sb6.toString();
                zIMResponse2.subCode = bioUploadResult.subCode;
                zIMResponse2.msg = bioUploadResult.subMsg;
                if (bioUploadResult.extParams != null && !bioUploadResult.extParams.isEmpty()) {
                    zIMResponse2.extInfo.putAll(bioUploadResult.extParams);
                }
                if (!ext.isEmpty()) {
                    zIMResponse2.extInfo.putAll(ext);
                }
                zIMResponse = zIMResponse2;
            } else if (ext.containsKey(BioDetector.EXT_KEY_RETRY_UI_TYPE)) {
                retry(ext.get(BioDetector.EXT_KEY_RETRY_UI_TYPE));
                z = false;
            }
        }
        if (z) {
            int result = bioResponse.getResult();
            if (zIMResponse == null) {
                zIMResponse = new ZIMResponse();
                if (bioResponse.getResult() != 205 && bioResponse.getResult() != 301 && bioResponse.getResult() != 202 && bioResponse.getResult() != 210 && bioResponse.getResult() != 207) {
                    if (bioResponse.getResult() == 200 || bioResponse.getResult() == 101 || bioResponse.getResult() == 100 || bioResponse.getResult() == 102) {
                        zIMResponse.code = 1003;
                        result = 100;
                    } else if (bioResponse.getResult() != 203) {
                        if (bioResponse.getResult() == 300 || bioResponse.getResult() == 208) {
                            zIMResponse.code = 1003;
                        } else if (bioResponse.getResult() == 209) {
                            zIMResponse.code = 1005;
                        } else if (bioResponse.getResult() == 3001) {
                            zIMResponse.code = 2006;
                        } else {
                            zIMResponse.code = 1001;
                        }
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(bioResponse.getResult());
                    zIMResponse.reason = sb7.toString();
                    zIMResponse.subCode = bioResponse.subCode;
                    zIMResponse.msg = bioResponse.subMsg;
                }
                zIMResponse.code = 1003;
                StringBuilder sb72 = new StringBuilder();
                sb72.append(bioResponse.getResult());
                zIMResponse.reason = sb72.toString();
                zIMResponse.subCode = bioResponse.subCode;
                zIMResponse.msg = bioResponse.subMsg;
            }
            recordVerifyResponse(zIMResponse);
            zIMResponse.extInfo.put(ZIMFacade.KEY_BIO_ACTION, String.valueOf(result));
            doCallZimCallback(zIMResponse);
        }
    }

    @Override // com.alipay.mobile.security.zim.gw.GwListener
    public void onInit(ZimInitGwResponse zimInitGwResponse) {
        Class<?> cls;
        try {
            LoadingProgressDialog loadingProgressDialog = this.mLoadingProgressDialog;
            if (loadingProgressDialog != null) {
                loadingProgressDialog.cancel();
            }
        } catch (Throwable unused) {
        }
        boolean z = false;
        if (zimInitGwResponse.retCode == 1001 || zimInitGwResponse.retCode == 200) {
            z = true;
        } else {
            if (!StringUtil.isNullorEmpty(zimInitGwResponse.zimId) && !zimInitGwResponse.zimId.equals(this.mZimId)) {
                this.mZimId = zimInitGwResponse.zimId;
            }
            if (zimInitGwResponse.extParams != null && !zimInitGwResponse.extParams.isEmpty()) {
                this.mFacePayInfo = zimInitGwResponse.extParams.get(ZIMFacade.KEY_FACE_PAY_INFO);
            }
            this.mBioParameter.setProtocol(zimInitGwResponse.protocol);
            Map<String, String> map = this.mParams;
            if (map != null && map.containsKey(ZIMFacade.KEY_AUTO_CLOSE)) {
                this.mBioParameter.setAutoClose(Boolean.parseBoolean(this.mParams.remove(ZIMFacade.KEY_AUTO_CLOSE)));
            }
            Map<String, String> extProperty = this.mBioParameter.getExtProperty();
            extProperty.put(BioDetector.EXT_KEY_VERIFYID, this.mZimId);
            extProperty.put("TOKEN_ID", this.mZimId);
            Map<String, String> map2 = this.mParams;
            if (map2 != null && !map2.isEmpty()) {
                extProperty.putAll(this.mParams);
            }
            RecordProcessor recordProcessor = RecordProcessor.getInstance();
            if (recordProcessor == null) {
                recordProcessor = RecordProcessor.createInstance(this.mContext);
            }
            recordProcessor.zimInit(this.mZimId);
            RecordProcessor.getInstance().record(RecordProcessor.KEY_AUTH_REQUEST);
            this.mBioParameter.isValidate = true;
            try {
                HashMap hashMap = new HashMap();
                ZimMessageChannel zimMessageChannel = this.mZimMessageChannel;
                if (zimMessageChannel != null) {
                    hashMap.put(ZIMFacade.KEY_ZIM_MSG_CHANNEL, zimMessageChannel);
                }
                Map<String, String> map3 = this.mParams;
                if (map3 != null && !map3.isEmpty()) {
                    if (this.mParams.containsKey(ZIMFacade.KEY_CERT_NAME)) {
                        hashMap.put(ZIMFacade.KEY_CERT_NAME, this.mParams.get(ZIMFacade.KEY_CERT_NAME));
                    }
                    if (this.mParams.containsKey(ZIMFacade.KEY_CERT_NO)) {
                        hashMap.put(ZIMFacade.KEY_CERT_NO, this.mParams.get(ZIMFacade.KEY_CERT_NO));
                    }
                }
                if (2 == Env.getProtocolFormat(this.mContext)) {
                    cls = Class.forName("com.alipay.mobile.security.bio.service.impl.BioUploadServiceCoreZhubPb");
                } else {
                    cls = Class.forName("com.alipay.mobile.security.bio.service.impl.BioUploadServiceCoreZhubJson");
                }
                String name = BioUploadServiceCore.class.getName();
                BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
                currentInstance.putBioService(name, cls);
                ((BioUploadServiceCoreZhub) currentInstance.getBioService(name)).setExtParams(this.mZimId, hashMap);
            } catch (Throwable unused2) {
            }
            if (zimInitGwResponse.retCode == 2002 && showRetryDialog(zimInitGwResponse)) {
                return;
            }
            auth(this.mBioParameter);
        }
        if (z) {
            ZIMResponse zIMResponse = new ZIMResponse();
            if (200 == zimInitGwResponse.retCode) {
                zIMResponse.code = 2006;
            } else {
                zIMResponse.code = zimInitGwResponse.retCode;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(zimInitGwResponse.retCode);
            zIMResponse.reason = sb.toString();
            zIMResponse.subCode = zimInitGwResponse.retCodeSub;
            zIMResponse.msg = zimInitGwResponse.retMessageSub;
            zIMResponse.extInfo.put(ZIMFacade.KEY_BIO_ACTION, RecordError.ERROR_VERIFY_APP);
            recordVerifyResponse(zIMResponse);
            doCallZimCallback(zIMResponse);
        }
    }

    private boolean showRetryDialog(final ZimInitGwResponse zimInitGwResponse) {
        Context context = this.mContext;
        if (context != null && (context instanceof Activity)) {
            new DialogHelper((Activity) this.mContext).alert(this.mContext.getString(R.string.alert_network_error_title), this.mContext.getString(R.string.alert_network_error_msg), this.mContext.getString(R.string.btn_retry), new DialogInterface.OnClickListener() { // from class: com.alipay.mobile.security.zim.biz.ZimPlatform.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ZimPlatform zimPlatform = ZimPlatform.this;
                    zimPlatform.performInitRequest(zimPlatform.mZimId, ZimPlatform.this.mParams, "false");
                }
            }, this.mContext.getString(R.string.btn_exit), new DialogInterface.OnClickListener() { // from class: com.alipay.mobile.security.zim.biz.ZimPlatform.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ZimPlatform zimPlatform = ZimPlatform.this;
                    zimPlatform.auth(zimPlatform.mBioParameter);
                    ZIMResponse zIMResponse = new ZIMResponse();
                    if (200 == zimInitGwResponse.retCode) {
                        zIMResponse.code = 2006;
                    } else {
                        zIMResponse.code = zimInitGwResponse.retCode;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(zimInitGwResponse.retCode);
                    zIMResponse.reason = sb.toString();
                    zIMResponse.subCode = zimInitGwResponse.retCodeSub;
                    zIMResponse.msg = zimInitGwResponse.retMessageSub;
                    zIMResponse.extInfo.put(ZIMFacade.KEY_BIO_ACTION, RecordError.ERROR_VERIFY_APP);
                    ZimPlatform.this.recordVerifyResponse(zIMResponse);
                    ZimPlatform.this.doCallZimCallback(zIMResponse);
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auth(BioParameter bioParameter) {
        for (String str : mCustomEnvs.keySet()) {
            bioParameter.getExtProperty().put(str, (String) mCustomEnvs.get(str));
        }
        try {
            if (!this.isInit) {
                this.mBioDetector.auth(bioParameter, this);
                return;
            }
            String init = this.mBioDetector.init(bioParameter, this);
            ZIMResponse zIMResponse = new ZIMResponse();
            if (!TextUtils.isEmpty(init)) {
                zIMResponse.code = 100;
                zIMResponse.singleTag = init;
            } else {
                zIMResponse.code = 200;
            }
            this.mZIMCallback.response(zIMResponse);
        } catch (Throwable th) {
            ZIMResponse zIMResponse2 = new ZIMResponse();
            zIMResponse2.code = 1001;
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            zIMResponse2.reason = sb.toString();
            zIMResponse2.extInfo.put(ZIMFacade.KEY_BIO_ACTION, RecordError.ERROR_VERIFY_APP);
            zIMResponse2.subCode = ZcodeConstants.ZCODE_AUTH_BIO_ERROR;
            zIMResponse2.msg = ZcodeConstants.getMessage(zIMResponse2.subCode);
            recordVerifyResponse(zIMResponse2);
            doCallZimCallback(zIMResponse2);
        }
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void retry(String str) {
        command(4099);
        ((ZimRecordService) this.mBioServiceManager.getBioService(ZimRecordService.class)).retry();
        this.mBioParameter.addExtProperty(BioDetector.EXT_KEY_RETRY_UI_TYPE, str);
        auth(this.mBioParameter);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void retry() {
        command(4099);
        ((ZimRecordService) this.mBioServiceManager.getBioService(ZimRecordService.class)).retry();
        auth(this.mBioParameter);
    }

    @Override // com.alipay.mobile.security.bio.api.BioProgressCallback
    public boolean onFaceDetected(Map<String, String> map) {
        if (this.mZIMCallback instanceof ZimProgressCallback) {
            if (!TextUtils.isEmpty(this.mFacePayInfo)) {
                map.put(ZIMFacade.KEY_FACE_PAY_INFO, this.mFacePayInfo);
            }
            ((ZimProgressCallback) this.mZIMCallback).onFaceDetected(map);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doCallZimCallback(ZIMResponse zIMResponse) {
        MonitorLogService monitorLogService;
        StringBuilder sb = new StringBuilder();
        sb.append("doCallZimCallback(): zimResponse=");
        sb.append(zIMResponse);
        sb.append(", mZIMCallback=");
        sb.append(this.mZIMCallback);
        new RuntimeException(sb.toString());
        boolean response = this.mZIMCallback.response(zIMResponse);
        RecordProcessor recordProcessor = RecordProcessor.getInstance();
        if (recordProcessor != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("subCode", zIMResponse.subCode);
            recordProcessor.record(RecordProcessor.KEY_ZIM_EXIT, hashMap);
        }
        BioServiceManager bioServiceManager = this.mBioServiceManager;
        if (bioServiceManager != null && (monitorLogService = (MonitorLogService) bioServiceManager.getBioService(MonitorLogService.class)) != null) {
            monitorLogService.trigUpload();
        }
        if (response) {
            destroy();
        }
        return response;
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void destroy() {
        sIsBusy = false;
        RecordProcessor recordProcessor = RecordProcessor.getInstance();
        HashMap hashMap = new HashMap();
        hashMap.put("module", "zim");
        recordProcessor.record(RecordProcessor.KEY_ZTECH_EXIT, hashMap);
        if (recordProcessor != null) {
            if (recordProcessor.destroyable()) {
                recordProcessor.destroy();
            } else {
                recordProcessor.clear();
            }
        }
        BioDetector bioDetector = this.mBioDetector;
        if (bioDetector != null) {
            bioDetector.destroy();
        }
        BaseGwService baseGwService = this.mBaseGWService;
        if (baseGwService != null) {
            baseGwService.destroy();
        }
        this.mContext = null;
        mH5Context = null;
        this.mBioServiceManager = null;
        this.mZimMessageChannel = null;
    }

    private void recordValidateResponse(ZimValidateGwResponse zimValidateGwResponse) {
        HashMap hashMap = new HashMap();
        if (zimValidateGwResponse != null) {
            int i = zimValidateGwResponse.validationRetCode;
            if (i == 100 || i == 1000) {
                hashMap.put("result", RESULT_TRUE);
            } else {
                hashMap.put("result", RESULT_FALSE);
            }
            hashMap.put("message", "");
            StringBuilder sb = new StringBuilder();
            sb.append(zimValidateGwResponse.validationRetCode);
            hashMap.put("retCode", sb.toString());
            hashMap.put("subCode", zimValidateGwResponse.retCodeSub);
            hashMap.put(KEY_SUB_MSG, zimValidateGwResponse.retMessageSub);
        } else {
            hashMap.put("result", RESULT_FALSE);
            hashMap.put("message", "0");
            hashMap.put("retCode", "0");
            hashMap.put("subCode", "");
            hashMap.put(KEY_SUB_MSG, "");
        }
        RecordProcessor.getInstance().record(RecordProcessor.KEY_VALIDATE_RESPONSE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordVerifyResponse(ZIMResponse zIMResponse) {
        HashMap hashMap = new HashMap(2);
        if (zIMResponse != null) {
            int i = zIMResponse.code;
            if (i == 100 || i == 1000) {
                hashMap.put("result", RESULT_TRUE);
            } else {
                hashMap.put("result", RESULT_FALSE);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(zIMResponse.reason);
            hashMap.put("message", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(zIMResponse.code);
            hashMap.put("retCode", sb2.toString());
            hashMap.put("subCode", zIMResponse.subCode);
            hashMap.put(KEY_SUB_MSG, zIMResponse.msg);
        } else {
            hashMap.put("result", RESULT_FALSE);
            hashMap.put("message", "0");
            hashMap.put("retCode", "0");
            hashMap.put("subCode", "");
            hashMap.put(KEY_SUB_MSG, "");
        }
        RecordProcessor.getInstance().record(RecordProcessor.KEY_VERIFY_RESPONSE, hashMap);
    }

    @Override // com.alipay.mobile.security.zim.api.ZIMFacade
    public void command(int i) {
        this.mBioDetector.command(i);
    }

    private void createLoadingDialog() {
        Context context = this.mContext;
        if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        ((Activity) this.mContext).runOnUiThread(new Runnable() { // from class: com.alipay.mobile.security.zim.biz.ZimPlatform.3
            @Override // java.lang.Runnable
            public void run() {
                ZimPlatform.this.mLoadingProgressDialog = new LoadingProgressDialog(ZimPlatform.this.mContext);
                ZimPlatform.this.mLoadingProgressDialog.setContentView(R.layout.zim_layout_loading_dialog);
            }
        });
    }

    private void showLoadingDialog() {
        Context context;
        LoadingProgressDialog loadingProgressDialog = this.mLoadingProgressDialog;
        if (loadingProgressDialog == null || loadingProgressDialog.isShowing() || (context = this.mContext) == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.alipay.mobile.security.zim.biz.ZimPlatform.4
            @Override // java.lang.Runnable
            public void run() {
                if (ZimPlatform.this.mContext == null || ((Activity) ZimPlatform.this.mContext).isFinishing()) {
                    return;
                }
                ZimPlatform.this.mLoadingProgressDialog.show();
            }
        });
    }
}
