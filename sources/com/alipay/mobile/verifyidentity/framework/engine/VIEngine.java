package com.alipay.mobile.verifyidentity.framework.engine;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.DefaultOnClickUrl;
import com.alipay.mobile.verifyidentity.base.OnClickUrl;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.ProductConstants;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.base.message.VIRespone;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.activity.SecVIVerify;
import com.alipay.mobile.verifyidentity.business.activity.SecVIVerifyInterface;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.framework.R;
import com.alipay.mobile.verifyidentity.framework.flow.NormalFlowController;
import com.alipay.mobile.verifyidentity.framework.module.VIModule;
import com.alipay.mobile.verifyidentity.framework.task.Task;
import com.alipay.mobile.verifyidentity.framework.task.TaskManager;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICInitRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VIEngine {
    private static final String TAG = "VIEngine";
    public static final long TIME_INTERVAL = 1000;
    private static String currentVerifyId;
    public static GetIfaaData ifaaData;
    private static long mLastClickTime;
    private static OnClickUrl onClickUrl;

    /* loaded from: classes3.dex */
    public interface OnQueryResult {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public interface VIListener {
        void onVerifyAction(VIAction vIAction);

        void onVerifyResult(VIResult vIResult);
    }

    public static void setIfaaData(GetIfaaData getIfaaData) {
        ifaaData = getIfaaData;
    }

    static {
        VIEngineUtils.initVIEngine();
        onClickUrl = new DefaultOnClickUrl();
        mLastClickTime = 0L;
    }

    public static void registerOnClickUrl(OnClickUrl onClickUrl2) {
        if (onClickUrl2 == null) {
            return;
        }
        onClickUrl = onClickUrl2;
    }

    public static OnClickUrl getOnClickUrl() {
        return onClickUrl;
    }

    public static void setProductRequest(final Activity activity, final String str, final String str2, final String str3, final String str4, final VerifyResponseCallBack verifyResponseCallBack) {
        final Dialog createLoadingDialog = CustomUi.createLoadingDialog(activity);
        createLoadingDialog.show();
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final MICRpcResponse execute() throws Exception {
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = RequestConstants.VERIFY;
                mICRpcRequest.action = str2;
                mICRpcRequest.module = str3;
                mICRpcRequest.data = str4;
                mICRpcRequest.prodmngId = str;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(activity)).toString();
                mICRpcRequest.version = "3.1.8.100";
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(MICRpcResponse mICRpcResponse) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (mICRpcResponse == null) {
                    VerifyResponseCallBack verifyResponseCallBack2 = verifyResponseCallBack;
                    if (verifyResponseCallBack2 != null) {
                        verifyResponseCallBack2.verifyRequestFail();
                        return;
                    }
                    return;
                }
                VerifyResponseCallBack verifyResponseCallBack3 = verifyResponseCallBack;
                if (verifyResponseCallBack3 != null) {
                    verifyResponseCallBack3.verifyRequestSuccess(mICRpcResponse);
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                VerifyResponseCallBack verifyResponseCallBack2 = verifyResponseCallBack;
                if (verifyResponseCallBack2 != null) {
                    verifyResponseCallBack2.verifyRequestFail();
                }
                CustomUi.showCenterToast(activity, iAPError.errorMessage);
            }
        });
    }

    public static void verifyRequest(final Activity activity, final String str, final String str2, final String str3, final VerifyResponseCallBack verifyResponseCallBack) {
        final Dialog createLoadingDialog = CustomUi.createLoadingDialog(activity);
        createLoadingDialog.show();
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final MICRpcResponse execute() throws Exception {
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = RequestConstants.VERIFY;
                mICRpcRequest.module = str2;
                mICRpcRequest.verifyId = str;
                mICRpcRequest.data = str3;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(activity)).toString();
                mICRpcRequest.version = "3.1.8.100";
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(MICRpcResponse mICRpcResponse) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (mICRpcResponse == null) {
                    VerifyResponseCallBack verifyResponseCallBack2 = verifyResponseCallBack;
                    if (verifyResponseCallBack2 != null) {
                        verifyResponseCallBack2.verifyRequestFail();
                        return;
                    }
                    return;
                }
                VerifyResponseCallBack verifyResponseCallBack3 = verifyResponseCallBack;
                if (verifyResponseCallBack3 != null) {
                    verifyResponseCallBack3.verifyRequestSuccess(mICRpcResponse);
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                VerifyResponseCallBack verifyResponseCallBack2 = verifyResponseCallBack;
                if (verifyResponseCallBack2 != null) {
                    verifyResponseCallBack2.verifyRequestFail();
                }
                CustomUi.showCenterToast(activity, iAPError.errorMessage);
            }
        });
    }

    public static void startVerify(Context context, int i, Map<String, Object> map, Map<String, String> map2, VIListener vIListener, OnQueryResult onQueryResult) {
        verify(context, i, RequestConstants.VerifyCallAllStart, map, map2, vIListener, onQueryResult);
    }

    public static void verify(Context context, int i, int i2, Map<String, Object> map, Map<String, String> map2, VIListener vIListener, OnQueryResult onQueryResult) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mLastClickTime > 1000) {
            mLastClickTime = currentTimeMillis;
            if (i == 8000) {
                startProduct(context, map, map2, onQueryResult);
            } else if (i == 8008) {
                if (i2 == 9009) {
                    VIEngineUtils.setVIListener(null);
                }
                if (VIEngineUtils.getVIListener() == null && vIListener != null) {
                    VIEngineUtils.setVIListener(vIListener);
                } else {
                    vIListener = VIEngineUtils.getVIListener();
                }
                startVerify(context, map, vIListener);
            }
        }
    }

    private static void startVerify(final Context context, final Map<String, Object> map, final VIListener vIListener) {
        int i;
        SecVIVerifyInterface secVIVerifyInterface;
        if (context == null || map == null || vIListener == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            return;
        }
        if (!map.containsKey("userId") && (secVIVerifyInterface = SecVIVerify.secVIVerifyInterface) != null) {
            String userId = secVIVerifyInterface.userId();
            if (!TextUtils.isEmpty(userId)) {
                map.put("userId", userId);
            }
        }
        final Dialog createLoadingDialog = CustomUi.createLoadingDialog(activity);
        createLoadingDialog.show();
        try {
            i = Integer.parseInt((String) map.get("verifyType"));
        } catch (Throwable unused) {
            i = 0;
        }
        if (2 == i) {
            IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.3
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
                public final MICRpcResponse execute() throws Exception {
                    MICInitRequest mICInitRequest = new MICInitRequest();
                    mICInitRequest.sceneId = (String) map.get("sceneId");
                    mICInitRequest.bizId = (String) map.get("bizId");
                    mICInitRequest.externParams = new HashMap();
                    mICInitRequest.externParams.put("userId", map.get("userId"));
                    mICInitRequest.externParams.put("call_back_url", "null");
                    String str = (String) map.get(RequestConstants.SecVIKeyTntInstId);
                    String str2 = (String) map.get("action");
                    if (!TextUtils.isEmpty(str2)) {
                        mICInitRequest.action = str2;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        mICInitRequest.externParams.put(RequestConstants.SecVIKeyTntInstId, str);
                    }
                    String str3 = (String) map.get(RequestConstants.SecVIKeyBankCardNumber);
                    if (!TextUtils.isEmpty(str3)) {
                        mICInitRequest.externParams.put(RequestConstants.SecVIKeyBankCardNumber, str3);
                    }
                    Map map2 = (Map) map.get(RequestConstants.SecVIKeyFastInitExtra);
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            mICInitRequest.externParams.put(entry.getKey(), entry.getValue());
                        }
                    }
                    mICInitRequest.envData = new JSONObject(VIEngineUtils.getEnvData(context)).toString();
                    if (VIEngine.ifaaData != null) {
                        mICInitRequest.externParams.put("secData", VIEngine.ifaaData.getPayData(context));
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("  zoloz  ");
                    sb.append(VIEngineUtils.getZolozFaceData(context.getApplicationContext()));
                    InstrumentInjector.log_e("king", sb.toString());
                    if (!TextUtils.isEmpty(VIEngineUtils.getZolozFaceData(context.getApplicationContext()))) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" bioMetaInfo  ");
                        sb2.append(VIEngineUtils.getZolozFaceData(context.getApplicationContext()));
                        InstrumentInjector.log_e("king", sb2.toString());
                        mICInitRequest.externParams.put(ProductConstants.KEY_PRODUCT_ENV_ZOLOZ, VIEngineUtils.getZolozFaceData(context.getApplicationContext()));
                    }
                    return RpcSettings.retrieveRpcService().initVerifyTaskOuter(mICInitRequest);
                }

                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                public final void onSuccess(MICRpcResponse mICRpcResponse) {
                    if (createLoadingDialog != null && !((Activity) context).isFinishing()) {
                        createLoadingDialog.dismiss();
                    }
                    if (mICRpcResponse == null && !((Activity) context).isFinishing()) {
                        Context context2 = context;
                        CustomUi.showCenterToast((Activity) context2, context2.getResources().getString(R.string.system_busy_error));
                        vIListener.onVerifyResult(new VIResult(1001));
                        return;
                    }
                    Message message = new Message(mICRpcResponse.toString());
                    message.setVerifyType(2);
                    if (!TextUtils.isEmpty(mICRpcResponse.data)) {
                        message.setUserId((String) map.get("userId"));
                        message.setTntInstId((String) map.get(RequestConstants.SecVIKeyTntInstId));
                        message.setUserInfo((String) map.get("userInfo"));
                        VIEngine.startVI(context, message, vIListener);
                        return;
                    }
                    VIResult vIResult = new VIResult(2002);
                    vIResult.setVerifyId(message.getVerifyId());
                    vIListener.onVerifyResult(vIResult);
                }

                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                public final void onFailure(IAPError iAPError) {
                    Dialog dialog = createLoadingDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    vIListener.onVerifyResult(new VIResult(1001));
                }
            });
        } else if (1 != i) {
            if (createLoadingDialog != null) {
                createLoadingDialog.dismiss();
            }
        } else {
            final String str = (String) map.get("verifyId");
            if (TextUtils.isEmpty(str)) {
                if (createLoadingDialog != null) {
                    createLoadingDialog.dismiss();
                }
                vIListener.onVerifyResult(new VIResult(2000));
            } else if (TextUtils.isEmpty(currentVerifyId) || !currentVerifyId.equalsIgnoreCase(str)) {
                currentVerifyId = str;
                ClientLogKitManager.getClientLogKit().log("event", new String[]{"a1.b1.c1", "0", ""}, null, "", "SecVI_Seed_Standard_DoView", "", str, false);
                IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.4
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
                    public final MICRpcResponse execute() throws Exception {
                        MICRpcRequest mICRpcRequest = new MICRpcRequest();
                        mICRpcRequest.module = "INIT";
                        mICRpcRequest.action = RequestConstants.VIEW;
                        mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(context)).toString();
                        mICRpcRequest.verifyId = (String) map.get("verifyId");
                        String str2 = (String) map.get("module");
                        if (!TextUtils.isEmpty(str2)) {
                            mICRpcRequest.module = str2;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (map.containsKey("userId")) {
                            jSONObject.put("userId", map.get("userId"));
                        }
                        if (VIEngine.ifaaData != null) {
                            jSONObject.put("secData", VIEngine.ifaaData.getPayData(context));
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("  zoloz  ");
                        sb.append(VIEngineUtils.getZolozFaceData(context.getApplicationContext()));
                        InstrumentInjector.log_e("king", sb.toString());
                        if (!TextUtils.isEmpty(VIEngineUtils.getZolozFaceData(context.getApplicationContext()))) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" bioMetaInfo  ");
                            sb2.append(VIEngineUtils.getZolozFaceData(context.getApplicationContext()));
                            InstrumentInjector.log_e("king", sb2.toString());
                            jSONObject.put(ProductConstants.KEY_PRODUCT_ENV_ZOLOZ, VIEngineUtils.getZolozFaceData(context.getApplicationContext()));
                        }
                        mICRpcRequest.data = jSONObject.toString();
                        try {
                            return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                        } catch (Throwable unused2) {
                            String unused3 = VIEngine.currentVerifyId = "";
                            return null;
                        }
                    }

                    @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                    public final void onSuccess(MICRpcResponse mICRpcResponse) {
                        String unused2 = VIEngine.currentVerifyId = "";
                        if (createLoadingDialog != null && !((Activity) context).isFinishing()) {
                            createLoadingDialog.dismiss();
                        }
                        if (mICRpcResponse == null && !((Activity) context).isFinishing()) {
                            Context context2 = context;
                            CustomUi.showCenterToast((Activity) context2, context2.getResources().getString(R.string.system_busy_error));
                            VIResult vIResult = new VIResult(1001);
                            vIResult.setVerifyId(str);
                            vIListener.onVerifyResult(vIResult);
                            return;
                        }
                        Message message = new Message(mICRpcResponse.toString());
                        message.setVerifyType(1);
                        if (!TextUtils.isEmpty(mICRpcResponse.data)) {
                            message.setUserId((String) map.get("userId"));
                            message.setUserInfo((String) map.get("userInfo"));
                            message.setTntInstId((String) map.get(RequestConstants.SecVIKeyTntInstId));
                            VIEngine.startVI(context, message, vIListener);
                            return;
                        }
                        VIResult vIResult2 = new VIResult(2002);
                        vIResult2.setVerifyId(message.getVerifyId());
                        vIListener.onVerifyResult(vIResult2);
                    }

                    @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                    public final void onFailure(IAPError iAPError) {
                        String unused2 = VIEngine.currentVerifyId = "";
                        Dialog dialog = createLoadingDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        VIResult vIResult = new VIResult(1001);
                        vIResult.setVerifyId((String) map.get("verifyId"));
                        vIListener.onVerifyResult(vIResult);
                    }
                });
            } else if (createLoadingDialog != null) {
                createLoadingDialog.dismiss();
            }
        }
    }

    public static String getSecData(Context context, String str) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject.toString();
        }
        GetIfaaData getIfaaData = ifaaData;
        if (getIfaaData != null) {
            jSONObject.put("secData", (Object) getIfaaData.getRegData(context, str));
        }
        return jSONObject.toString();
    }

    public static void enterBic(final Context context, Map<String, String> map, final OnQueryResult onQueryResult) {
        final String str;
        SecVIVerifyInterface secVIVerifyInterface;
        if (context == null || map == null) {
            if (onQueryResult != null) {
                onQueryResult.onFail();
                return;
            }
            return;
        }
        if (!map.containsKey("userId") && (secVIVerifyInterface = SecVIVerify.secVIVerifyInterface) != null) {
            String userId = secVIVerifyInterface.userId();
            if (!TextUtils.isEmpty(userId)) {
                map.put("userId", userId);
            }
        }
        final Dialog createLoadingDialog = CustomUi.createLoadingDialog((Activity) context);
        createLoadingDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.5
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getRepeatCount() == 0) {
                    Context context2 = context;
                    if (context2 instanceof DialogInterface.OnKeyListener) {
                        ((DialogInterface.OnKeyListener) context2).onKey(dialogInterface, i, keyEvent);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        createLoadingDialog.show();
        GetIfaaData getIfaaData = ifaaData;
        if (getIfaaData != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get("userId"));
            sb.append("_");
            sb.append(map.get(RequestConstants.SecVIKeyTntInstId));
            sb.append("_1");
            str = getIfaaData.getRegData(context, sb.toString());
        } else {
            str = "";
        }
        final String str2 = map.get("bizId");
        final String str3 = map.get("sceneId");
        final String str4 = map.get("userId");
        final String str5 = map.get(RequestConstants.SecVIKeyTntInstId);
        final String str6 = map.get("productId");
        final String str7 = map.get("action");
        final String str8 = map.get("type");
        final String str9 = map.get("productCode");
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final MICRpcResponse execute() throws Exception {
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.module = RequestConstants.BIC;
                mICRpcRequest.module = str9;
                mICRpcRequest.action = RequestConstants.QUERY_BIO_STATUS;
                mICRpcRequest.isDisplaySensitiveField = false;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(context)).toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("secData", str);
                jSONObject.put("bizId", str2);
                jSONObject.put("sceneId", str3);
                jSONObject.put("userId", str4);
                jSONObject.put(RequestConstants.SecVIKeyTntInstId, str5);
                jSONObject.put("productId", str6);
                jSONObject.put("productType", str6);
                mICRpcRequest.data = jSONObject.toString();
                mICRpcRequest.prodmngId = IAPSyncCommand.COMMAND_INIT;
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(MICRpcResponse mICRpcResponse) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                Context context2 = context;
                if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                    return;
                }
                if (mICRpcResponse == null) {
                    Context context3 = context;
                    CustomUi.showCenterToast((Activity) context3, context3.getResources().getString(R.string.system_busy_error));
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a4.b1.c1", "1", ""}, null, "", "SecVI_Seed_Bic_QueryStatus", "", "", false);
                    OnQueryResult onQueryResult2 = onQueryResult;
                    if (onQueryResult2 != null) {
                        onQueryResult2.onFail();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("finishedCode", mICRpcResponse.finishCode);
                hashMap.put("finishedMsg", mICRpcResponse.finishMessage);
                hashMap.put("verifyMsg", mICRpcResponse.verifyMessage);
                ClientLogKitManager.getClientLogKit().log("event", new String[]{"a4.b1.c1", "0", ""}, hashMap, "", "SecVI_Seed_Bic_QueryStatus", "", "", false);
                if (mICRpcResponse.success || (!mICRpcResponse.success && mICRpcResponse.finish && !"1001".equalsIgnoreCase(mICRpcResponse.finishCode))) {
                    Message convertToMessage = mICRpcResponse.convertToMessage();
                    convertToMessage.setSecData(str);
                    convertToMessage.setBizId(str2);
                    convertToMessage.setSceneId(str3);
                    convertToMessage.setUserId(str4);
                    convertToMessage.setTntInstId(str5);
                    convertToMessage.setProdmngId(mICRpcResponse.prodmngId);
                    convertToMessage.setProductType(str6);
                    if (!TextUtils.isEmpty(str7)) {
                        convertToMessage.setAction(str7);
                    }
                    if (!TextUtils.isEmpty(str8)) {
                        convertToMessage.setType(str8);
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        convertToMessage.setProductCode(str9);
                    }
                    VIEngine.startVI(context, convertToMessage, null);
                } else if (!TextUtils.isEmpty(mICRpcResponse.sysErrMsg)) {
                    CustomUi.showCenterToast((Activity) context, mICRpcResponse.sysErrMsg);
                }
                OnQueryResult onQueryResult3 = onQueryResult;
                if (onQueryResult3 != null) {
                    onQueryResult3.onSuccess();
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                Context context2 = context;
                if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                    return;
                }
                if (!TextUtils.isEmpty(iAPError.errorMessage)) {
                    Context context3 = context;
                    CustomUi.showCenterToast((Activity) context3, context3.getResources().getString(R.string.system_busy_error));
                }
                OnQueryResult onQueryResult2 = onQueryResult;
                if (onQueryResult2 != null) {
                    onQueryResult2.onFail();
                }
            }
        });
    }

    public static void startProduct(final Context context, final Map<String, Object> map, final Map<String, String> map2, final OnQueryResult onQueryResult) {
        SecVIVerifyInterface secVIVerifyInterface;
        SecVIVerifyInterface secVIVerifyInterface2;
        if (context == null || map == null) {
            if (onQueryResult != null) {
                onQueryResult.onFail();
                return;
            }
            return;
        }
        if (!map.containsKey("userId") && (secVIVerifyInterface2 = SecVIVerify.secVIVerifyInterface) != null) {
            String userId = secVIVerifyInterface2.userId();
            if (!TextUtils.isEmpty(userId)) {
                map.put("userId", userId);
            }
        }
        if (!map.containsKey(RequestConstants.SecVIKeyTntInstId) && (secVIVerifyInterface = SecVIVerify.secVIVerifyInterface) != null) {
            String tntInstId = secVIVerifyInterface.tntInstId();
            if (!TextUtils.isEmpty(tntInstId)) {
                map.put(RequestConstants.SecVIKeyTntInstId, tntInstId);
            }
        }
        final String str = (String) map.get("sceneId");
        final String str2 = (String) map.get("userId");
        final String str3 = (String) map.get(RequestConstants.SecVIKeyTntInstId);
        final String str4 = (String) map.get("productCode");
        String str5 = (String) map.get("verifyType");
        final String str6 = (String) map.get("productId");
        final String str7 = str4.equalsIgnoreCase(SecurityConstants.KEY_SQ) ? RequestConstants.QUERY_BIO_STATUS : RequestConstants.BUILD_MENU;
        final Dialog createLoadingDialog = CustomUi.createLoadingDialog((Activity) context);
        createLoadingDialog.show();
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final MICRpcResponse execute() throws Exception {
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = str7;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(context)).toString();
                mICRpcRequest.module = str4;
                mICRpcRequest.prodmngId = "query";
                if (str4.equalsIgnoreCase(SecurityConstants.KEY_SQ)) {
                    mICRpcRequest.action = RequestConstants.QUERY_BIO_STATUS;
                    mICRpcRequest.prodmngId = IAPSyncCommand.COMMAND_INIT;
                }
                if (!TextUtils.isEmpty((String) map.get("action"))) {
                    mICRpcRequest.action = (String) map.get("action");
                }
                if (!TextUtils.isEmpty((String) map.get(RequestConstants.SecVIKeyProductMngId))) {
                    mICRpcRequest.prodmngId = (String) map.get(RequestConstants.SecVIKeyProductMngId);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userId", str2);
                jSONObject.put("sceneId", str);
                jSONObject.put(RequestConstants.SecVIKeyTntInstId, str3);
                jSONObject.put("productType", str6);
                jSONObject.put("isMock", SummaryActivity.CHECKED);
                jSONObject.put("failedCase", "0");
                mICRpcRequest.data = jSONObject.toString();
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(MICRpcResponse mICRpcResponse) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (mICRpcResponse == null) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a4.b3.c2", "1", ""}, null, "", "SecVI_Seed_SecQuestion_QueryStatus", "", "", false);
                    Context context2 = context;
                    CustomUi.showCenterToast((Activity) context2, context2.getResources().getString(R.string.system_busy_error));
                    return;
                }
                Message message = new Message(mICRpcResponse.toString());
                if (!TextUtils.isEmpty(mICRpcResponse.data)) {
                    message.setUserId(str2);
                    message.setSceneId(str);
                    message.setTntInstId(str3);
                    message.setProductCode(str4);
                    message.setProdmngId(mICRpcResponse.prodmngId);
                    message.setProductType(str6);
                    if (!TextUtils.isEmpty((String) map.get("action"))) {
                        message.setAction((String) map.get("action"));
                    } else {
                        message.setAction(str7);
                    }
                    Map map3 = map2;
                    if (map3 != null && !TextUtils.isEmpty((CharSequence) map3.get(RequestConstants.SecVIKeySecuritySettingsConfig))) {
                        message.setSecData((String) map2.get(RequestConstants.SecVIKeySecuritySettingsConfig));
                    }
                    VIEngine.startVI(context, message, null);
                }
                OnQueryResult onQueryResult2 = onQueryResult;
                if (onQueryResult2 != null) {
                    onQueryResult2.onSuccess();
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                OnQueryResult onQueryResult2 = onQueryResult;
                if (onQueryResult2 != null) {
                    onQueryResult2.onFail();
                }
            }
        });
    }

    public static void startVI(final Context context, Message message, final VIListener vIListener) {
        if (context instanceof Activity) {
            try {
                final JSONObject jSONObject = new JSONObject(message.getData());
                if (SummaryActivity.CHECKED.equalsIgnoreCase(jSONObject.optString("completePPWFlag"))) {
                    CustomUi.showCommonDialog((Activity) context, "", context.getResources().getString(R.string.inter_set_pwd_needed), 1001, true, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.8
                        @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                        public final void onCancel() {
                        }

                        @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                        public final void onOk() {
                            InstrumentInjector.log_d("CustomUi", "  showAlertDialog   onOk");
                            if (VIEngine.getOnClickUrl() != null) {
                                VIEngine.getOnClickUrl().onClickHttpUrl(context, jSONObject.optString("completePPWUrl"));
                            }
                        }
                    });
                    return;
                }
            } catch (JSONException unused) {
            }
            VIModule create = new VIModule.Builder().create(context, message);
            if (create != null) {
                TaskManager.getInstance().execute(new Task(new NormalFlowController(create, new VIModule.Callback() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.9
                    @Override // com.alipay.mobile.verifyidentity.framework.module.VIModule.Callback
                    public final void onResult(IProduct iProduct, final VIRespone vIRespone) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Message responseMessage = vIRespone.getResponseMessage();
                                if (responseMessage != null && !TextUtils.isEmpty(responseMessage.getNextStep())) {
                                    if (vIRespone.getResult() == 1004) {
                                        if (VIListener.this != null) {
                                            VIListener.this.onVerifyResult(VIEngineUtils.buildResult(vIRespone));
                                            VIEngineUtils.setVIListener(null);
                                            return;
                                        }
                                        return;
                                    }
                                    VIEngine.startVI(context, responseMessage, VIListener.this);
                                } else if (VIListener.this != null) {
                                    VIListener.this.onVerifyResult(VIEngineUtils.buildResult(vIRespone));
                                    VIEngineUtils.setVIListener(null);
                                }
                            }
                        });
                    }

                    @Override // com.alipay.mobile.verifyidentity.framework.module.VIModule.Callback
                    public final void onAction(final String str) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.9.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (VIListener.this != null) {
                                    VIListener.this.onVerifyAction(new VIAction(str));
                                    VIEngineUtils.setVIListener(null);
                                }
                            }
                        });
                    }
                })));
            } else if (vIListener != null) {
                vIListener.onVerifyResult(new VIResult(1008));
            }
        }
    }

    public static void changeVerifyMethod(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("verifyType", "1");
        hashMap.put("module", RequestConstants.MENU);
        hashMap.put("verifyId", str);
        verify(context, RequestConstants.VerifyProductVerify, 9000, hashMap, null, new VIListener() { // from class: com.alipay.mobile.verifyidentity.framework.engine.VIEngine.10
            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
            public final void onVerifyAction(VIAction vIAction) {
            }

            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
            public final void onVerifyResult(VIResult vIResult) {
            }
        }, null);
    }

    public static String viClientData(Context context) {
        JSONObject jSONObject = new JSONObject();
        GetIfaaData getIfaaData = ifaaData;
        if (getIfaaData != null) {
            try {
                jSONObject.put("secData", getIfaaData.getPayData(context));
                jSONObject.put(ProductConstants.KEY_PRODUCT_ENV_ZOLOZ, "");
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }
}
