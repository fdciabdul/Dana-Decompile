package com.alipay.mobile.security.bio.workspace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.security.bio.api.BioCallback;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipay.mobile.security.bio.api.BioParameter;
import com.alipay.mobile.security.bio.api.BioProgressCallback;
import com.alipay.mobile.security.bio.api.BioResponse;
import com.alipay.mobile.security.bio.common.statistics.RecordExtAction;
import com.alipay.mobile.security.bio.common.statistics.RecordExtService;
import com.alipay.mobile.security.bio.config.Constant;
import com.alipay.mobile.security.bio.constants.CodeConstants;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.module.MicroModule;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioAppManager;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadService;
import com.alipay.mobile.security.bio.service.local.rpc.BioRPCService;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class BioTransfer implements BioDetector {
    private static BioDetector sBusyBioDetector;
    private AuthBroadCastReceiver mAuthBroadCastReceiver;
    private BioAppManager mBioAppManager;
    private MicroModule mBioMicroModule;
    private BioServiceManager mBioServiceManager;
    Context mContext;
    private BioCallback mFcBioCallBack;
    JSONObject mFcSpecialData;
    BioParameter mIDFaceParam;
    private LocalBroadcastManager mLocalBroadcastManager;
    RecordExtService mRecordExtService;
    public static final byte[] MyBillsEntityDataFactory = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 38;
    private ArrayList<String> extKeyList = new ArrayList<>(Arrays.asList("userid", "apdid", "scene_id", "appid", "token_id", "usernamehidden", "abtest", BioDetector.EXT_KEY_VERIFYID));
    boolean isIDFaceFlag = false;
    int fcStep = 0;
    String fcToken = "";

    public BioTransfer(Context context, MicroModule microModule) {
        if (context == null) {
            throw new BioIllegalArgumentException();
        }
        String zimId = microModule == null ? null : microModule.getZimId();
        if (TextUtils.isEmpty(zimId)) {
            BioServiceManager.createInstance(context);
        } else {
            BioServiceManager.createInstance(context, zimId);
        }
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        this.mBioServiceManager = currentInstance;
        this.mRecordExtService = (RecordExtService) currentInstance.getBioService(RecordExtService.class);
        this.mBioAppManager = (BioAppManager) this.mBioServiceManager.getBioService(BioAppManager.class);
        this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        AuthBroadCastReceiver authBroadCastReceiver = new AuthBroadCastReceiver();
        this.mAuthBroadCastReceiver = authBroadCastReceiver;
        this.mLocalBroadcastManager.registerReceiver(authBroadCastReceiver, new IntentFilter(Constant.BIOLOGY_CALLBACK_ACTION));
        this.mLocalBroadcastManager.registerReceiver(this.mAuthBroadCastReceiver, new IntentFilter(Constant.BIOLOGY_CALLBACK_PROGRESS_ACTION));
        this.mContext = context.getApplicationContext();
        this.mBioMicroModule = microModule;
    }

    @Override // com.alipay.mobile.security.bio.api.BioDetector
    public void auth(BioParameter bioParameter, BioCallback bioCallback) {
        if (bioParameter == null || bioCallback == null) {
            throw new BioIllegalArgumentException();
        }
        synchronized (BioTransfer.class) {
            BioDetector bioDetector = sBusyBioDetector;
            if (bioDetector == null) {
                sBusyBioDetector = this;
            } else if (this != bioDetector) {
                BioResponse bioResponse = new BioResponse();
                bioResponse.setResult(400);
                bioResponse.subMsg = "pre bio session is running.";
                bioResponse.subCode = "";
                bioCallback.onResult(bioResponse);
                return;
            }
            this.mFcBioCallBack = bioCallback;
            buildBioParameter(bioParameter.getBundle(), bioParameter);
            BioAppDescription bioAppDescription = toBioAppDescription(bioParameter);
            String put = this.mBioAppManager.put(bioAppDescription, bioCallback);
            String remoteURL = bioParameter.getRemoteURL();
            if (!TextUtils.isEmpty(remoteURL)) {
                ((BioRPCService) this.mBioServiceManager.getBioService(BioRPCService.class)).setRemoteUrl(remoteURL);
            }
            ((BioUploadService) this.mBioServiceManager.getBioService(BioUploadService.class)).clearUp();
            if (StringUtil.isNullorEmpty(this.mBioServiceManager.startBioActivity(bioAppDescription, this.mBioMicroModule))) {
                sendResponse(put, 201, "app is not installed");
            }
        }
    }

    @Override // com.alipay.mobile.security.bio.api.BioDetector
    public String init(BioParameter bioParameter, BioCallback bioCallback) {
        if (bioParameter == null || bioCallback == null) {
            throw new BioIllegalArgumentException();
        }
        synchronized (BioTransfer.class) {
            BioDetector bioDetector = sBusyBioDetector;
            if (bioDetector == null) {
                sBusyBioDetector = this;
            } else if (this != bioDetector) {
                BioResponse bioResponse = new BioResponse();
                bioResponse.setResult(400);
                bioResponse.subMsg = "pre bio session is running.";
                bioResponse.subCode = "";
                bioCallback.onResult(bioResponse);
            }
        }
        buildBioParameter(bioParameter.getBundle(), bioParameter);
        String put = this.mBioAppManager.put(toBioAppDescription(bioParameter), bioCallback);
        String remoteURL = bioParameter.getRemoteURL();
        if (!TextUtils.isEmpty(remoteURL)) {
            ((BioRPCService) this.mBioServiceManager.getBioService(BioRPCService.class)).setRemoteUrl(remoteURL);
        }
        ((BioUploadService) this.mBioServiceManager.getBioService(BioUploadService.class)).clearUp();
        return put;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f A[Catch: all -> 0x0089, TryCatch #0 {all -> 0x0089, blocks: (B:10:0x0023, B:14:0x0048, B:16:0x004f, B:17:0x0079), top: B:22:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079 A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #0 {all -> 0x0089, blocks: (B:10:0x0023, B:14:0x0048, B:16:0x004f, B:17:0x0079), top: B:22:0x0023 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007c -> B:19:0x0081). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alipay.mobile.security.bio.service.BioAppDescription toBioAppDescription(com.alipay.mobile.security.bio.api.BioParameter r15) {
        /*
            r14 = this;
            android.content.Context r0 = r14.mContext
            int r0 = com.alipay.mobile.security.bio.workspace.Env.getProtocolFormat(r0)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "meta_serializer"
            r15.addExtProperty(r2, r1)
            boolean r1 = r15.isValidate
            r2 = 2
            if (r1 == 0) goto L1c
            if (r0 == r2) goto L19
            java.lang.String r0 = "com.alipay.mobile.security.bio.workspace.JsonToBioApp"
            goto L23
        L19:
            java.lang.String r0 = "com.alipay.mobile.security.bio.workspace.PbToBioApp"
            goto L23
        L1c:
            if (r0 == r2) goto L21
            java.lang.String r0 = "com.alipay.mobile.security.bio.workspace.JsonBioParameterToBioApp"
            goto L23
        L21:
            java.lang.String r0 = "com.alipay.mobile.security.bio.workspace.PbBioParameterToBioApp"
        L23:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L89
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L89
            r3 = 3
            byte[] r4 = com.alipay.mobile.security.bio.workspace.BioTransfer.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L89
            r5 = -1
            r6 = 23
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L89
            r7 = 22
            r8 = 97
            if (r4 != 0) goto L40
            r11 = r14
            r3 = r1
            r5 = r4
            r9 = r6
            r4 = 3
            r6 = -1
            r10 = 22
            goto L81
        L40:
            r10 = r14
            r3 = r1
            r5 = r4
            r8 = r6
            r4 = 3
            r6 = -1
            r9 = 97
        L48:
            r11 = 1
            int r6 = r6 + r11
            byte r12 = (byte) r9     // Catch: java.lang.Throwable -> L89
            r8[r6] = r12     // Catch: java.lang.Throwable -> L89
            if (r6 != r7) goto L79
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L89
            r5 = 0
            r4.<init>(r8, r5)     // Catch: java.lang.Throwable -> L89
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> L89
            r1[r5] = r4     // Catch: java.lang.Throwable -> L89
            java.lang.Class<com.alipay.mobile.security.bio.workspace.BioTransfer> r1 = com.alipay.mobile.security.bio.workspace.BioTransfer.class
            r3[r11] = r1     // Catch: java.lang.Throwable -> L89
            java.lang.reflect.Constructor r0 = r0.getConstructor(r3)     // Catch: java.lang.Throwable -> L89
            r0.setAccessible(r11)     // Catch: java.lang.Throwable -> L89
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L89
            android.content.Context r2 = r10.mContext     // Catch: java.lang.Throwable -> L89
            r1[r5] = r2     // Catch: java.lang.Throwable -> L89
            r1[r11] = r10     // Catch: java.lang.Throwable -> L89
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.Throwable -> L89
            com.alipay.mobile.security.bio.workspace.BaseBioParameterToBioApp r0 = (com.alipay.mobile.security.bio.workspace.BaseBioParameterToBioApp) r0     // Catch: java.lang.Throwable -> L89
            com.alipay.mobile.security.bio.service.BioAppDescription r15 = r0.toBioApp(r15)     // Catch: java.lang.Throwable -> L89
            goto L8a
        L79:
            int r4 = r4 + r11
            r11 = r5[r4]     // Catch: java.lang.Throwable -> L89
            r13 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r13
        L81:
            int r10 = r10 + r8
            int r8 = r10 + (-8)
            r10 = r11
            r13 = r9
            r9 = r8
            r8 = r13
            goto L48
        L89:
            r15 = 0
        L8a:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.bio.workspace.BioTransfer.toBioAppDescription(com.alipay.mobile.security.bio.api.BioParameter):com.alipay.mobile.security.bio.service.BioAppDescription");
    }

    private BioParameter buildBioParameter(Bundle bundle, BioParameter bioParameter) {
        if (bundle == null && bioParameter == null) {
            throw new BioIllegalArgumentException("paramter is null");
        }
        if (bundle == null) {
            return bioParameter;
        }
        String string = bundle.getString(BioDetector.EXT_KEY_MODULE_DATA_BUNDLE);
        if (TextUtils.isEmpty(string)) {
            return bioParameter;
        }
        JSONObject parseObject = JSONObject.parseObject(string);
        String string2 = parseObject.getString("sceneId");
        String string3 = parseObject.getString("USER_ID");
        String string4 = parseObject.getString(BioDetector.EXT_KEY_BISCFG_BUNDLE);
        String string5 = bundle.getString("TOKEN_ID");
        String string6 = bundle.getString("APDID");
        String string7 = bundle.getString(BioDetector.EXT_KEY_VERIFYID);
        String string8 = parseObject.getString("appid");
        String string9 = parseObject.getString("HAS_OTHERS");
        bioParameter.setHeadImageUrl(bundle != null ? bundle.getString("headurl") : null);
        if (!StringUtil.isNullorEmpty(string4)) {
            bioParameter.setProtocol(string4);
        }
        if (TextUtils.isEmpty(string7)) {
            string7 = "";
        }
        bioParameter.addExtProperty(BioDetector.EXT_KEY_VERIFYID, string7);
        if (TextUtils.isEmpty(string6)) {
            string6 = "";
        }
        bioParameter.addExtProperty("APDID", string6);
        if (TextUtils.isEmpty(string2)) {
            string2 = "";
        }
        bioParameter.addExtProperty("SCENE_ID", string2);
        if (TextUtils.isEmpty(string5)) {
            string5 = "";
        }
        bioParameter.addExtProperty("TOKEN_ID", string5);
        if (TextUtils.isEmpty(string3)) {
            string3 = "";
        }
        bioParameter.addExtProperty("userid", string3);
        if (TextUtils.isEmpty(string8)) {
            string8 = "";
        }
        bioParameter.addExtProperty("appid", string8);
        if (TextUtils.isEmpty(string9)) {
            string9 = "false";
        }
        bioParameter.addExtProperty("HAS_OTHERS", string9);
        if (bundle.containsKey("RequestPage")) {
            String valueOf = String.valueOf(bundle.getInt("RequestPage"));
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = "";
            }
            bioParameter.addExtProperty("pageNum", valueOf);
        }
        if (bundle.containsKey("RequestCardType")) {
            String string10 = bundle.getString("RequestCardType");
            if (TextUtils.isEmpty(string10)) {
                string10 = "";
            }
            bioParameter.addExtProperty(BioDetector.EXT_KEY_CARD_TYPE, string10);
        }
        if (bundle.containsKey("RequestTotalPagesNum")) {
            String valueOf2 = String.valueOf(bundle.getInt("RequestTotalPagesNum"));
            bioParameter.addExtProperty(BioDetector.EXT_KEY_TOTAL_PAGE_NUM, TextUtils.isEmpty(valueOf2) ? "" : valueOf2);
        }
        return bioParameter;
    }

    public void sendResponse(String str, int i, String str2) {
        Intent intent = new Intent(Constant.BIOLOGY_CALLBACK_ACTION);
        BioResponse bioResponse = new BioResponse();
        bioResponse.setSuccess(false);
        bioResponse.setResult(i);
        if (i == 201) {
            bioResponse.subCode = CodeConstants.INVALID_ARGUMENT;
            bioResponse.subMsg = CodeConstants.getMessage(bioResponse.subCode);
        }
        bioResponse.setResultMessage(str2);
        bioResponse.setTag(str);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BIOLOGY_INTENT_ACTION_REV, JSON.toJSONString(bioResponse));
        intent.putExtras(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(bioResponse);
        new RuntimeException(sb.toString());
        this.mLocalBroadcastManager.sendBroadcast(intent);
    }

    @Override // com.alipay.mobile.security.bio.api.BioDetector
    public void destroy() {
        this.mBioAppManager = null;
        this.mFcBioCallBack = null;
        LocalBroadcastManager localBroadcastManager = this.mLocalBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(this.mAuthBroadCastReceiver);
        }
        BioServiceManager.destroyInstance();
        sBusyBioDetector = null;
    }

    /* loaded from: classes7.dex */
    public class AuthBroadCastReceiver extends BroadcastReceiver {
        public AuthBroadCastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra(Constant.BIOLOGY_INTENT_ACTION_REV);
            if (TextUtils.isEmpty(stringExtra)) {
                new RuntimeException("why the AuthBroadCastReceiver.rev is empty?");
                return;
            }
            BioResponse bioResponse = null;
            try {
                bioResponse = (BioResponse) JSON.parseObject(stringExtra, BioResponse.class);
            } catch (Throwable unused) {
            }
            if (bioResponse == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to parse {");
                sb.append(stringExtra);
                sb.append("} to com.alipay.mobile.security.bio.api.BioResponse");
                new RuntimeException(sb.toString());
                return;
            }
            String tag = bioResponse.getTag();
            if (BioTransfer.this.mBioAppManager != null) {
                BioCallback bioCallback = BioTransfer.this.mBioAppManager.getBioCallback(tag);
                if (TextUtils.equals(Constant.BIOLOGY_CALLBACK_PROGRESS_ACTION, action)) {
                    if (bioCallback == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to getBioCallback() by ");
                        sb2.append(tag);
                        new RuntimeException(sb2.toString());
                        return;
                    } else if (bioCallback instanceof BioProgressCallback) {
                        ((BioProgressCallback) bioCallback).onFaceDetected(bioResponse.getExt());
                        return;
                    } else {
                        return;
                    }
                }
                if (bioCallback == null) {
                    try {
                        if (!BioTransfer.this.isIDFaceFlag) {
                            return;
                        }
                    } catch (Exception unused2) {
                        return;
                    }
                }
                Map<String, String> ext = bioResponse.getExt();
                if (ext != null && "face".equals(ext.get("fc"))) {
                    BioTransfer.this.fcStep = 1;
                    BioTransfer bioTransfer = BioTransfer.this;
                    bioTransfer.auth(bioTransfer.mIDFaceParam, BioTransfer.this.mFcBioCallBack);
                    return;
                }
                if (BioTransfer.this.isIDFaceFlag) {
                    bioResponse.setToken(BioTransfer.this.fcToken);
                    HashMap hashMap = new HashMap();
                    hashMap.put("fcToken", BioTransfer.this.fcToken);
                    if (BioTransfer.this.fcStep == 1) {
                        BioTransfer.this.mRecordExtService.write(RecordExtAction.RECORD_FC_FACE_CALL_BACK_BIS_SYSTEM, hashMap);
                    }
                    hashMap.put("param", bioResponse.toString());
                    BioTransfer.this.mRecordExtService.write(RecordExtAction.RECORD_FC_CALL_BACK_VERITY_SYSTEM, hashMap);
                }
                if (BioTransfer.this.isIDFaceFlag) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("fcToken", BioTransfer.this.fcToken);
                    BioTransfer.this.mRecordExtService.write(RecordExtAction.RECORD_FC_EXIT_SDK, hashMap2);
                }
                int bioAction = BioTransfer.this.mBioAppManager.getBioAppDescription(tag).getBioAction() - 1000;
                if (992 == bioAction || 993 == bioAction) {
                    if (ext == null) {
                        ext = new HashMap<>();
                        bioResponse.setExt(ext);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(bioAction);
                    ext.put(BioDetector.EXT_KEY_UI, sb3.toString());
                }
                bioCallback.onResult(bioResponse);
                return;
            }
            new RuntimeException("BioAppManager in receiver is null");
        }
    }

    @Override // com.alipay.mobile.security.bio.api.BioDetector
    public int preLoad() {
        return this.mBioServiceManager.preLoad();
    }

    @Override // com.alipay.mobile.security.bio.api.BioDetector
    public void command(int i) {
        String str;
        if (i == 8193) {
            str = Constant.BIOLOGY_FLAG_SERVER_FAIL;
        } else if (i != 8194) {
            switch (i) {
                case 4097:
                    str = Constant.BIOLOGY_FLAG_SERVER_SUCCESS;
                    break;
                case 4098:
                    str = Constant.BIOLOGY_FLAG_SERVER_CONTINUE;
                    break;
                case 4099:
                    str = Constant.BIOLOGY_FLAG_AUTOCLOSE;
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = Constant.BIOLOGY_FLAG_SERVER_RETRY;
        }
        if (StringUtil.isNullorEmpty(str)) {
            return;
        }
        this.mLocalBroadcastManager.sendBroadcast(new Intent(str));
    }
}
