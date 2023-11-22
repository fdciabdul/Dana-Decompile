package com.ap.zoloz.hummer.h5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.ap.zoloz.hummer.api.EkycFacade;
import com.ap.zoloz.hummer.api.EkycRequest;
import com.ap.zoloz.hummer.api.EkycResponse;
import com.ap.zoloz.hummer.api.IEkycCallback;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.biz.HummerLogger;
import com.ap.zoloz.hummer.common.AlertManager;
import com.ap.zoloz.hummer.common.HummerContext;
import com.ap.zoloz.hummer.common.IAlertCallback;
import com.ap.zoloz.hummer.common.RecordManager;
import com.ap.zoloz.hummer.rpc.IRpcCallback;
import com.ap.zoloz.hummer.rpc.RpcManager;
import com.ap.zoloz.hummer.rpc.RpcResponse;
import com.zoloz.zhub.common.factor.model.FactorNextResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class ZolozEkycH5Handler {
    public static final String HUMMER_FOUNDATION_ADD = "add";
    public static final String HUMMER_FOUNDATION_DELETE = "delete";
    public static final String HUMMER_FOUNDATION_GET_INTPUT_PARAMS = "getInputParams";
    public static final String HUMMER_FOUNDATION_GET_LANGUAGE = "getLanguage";
    public static final String HUMMER_FOUNDATION_GET_OUTPUT_PARAMS = "getOutputParams";
    public static final String HUMMER_FOUNDATION_HIDE_LOADING_DIALOG = "hideLoadingDialog";
    private static final String HUMMER_FOUNDATION_KEY = "key";
    public static final String HUMMER_FOUNDATION_LOGGING = "logging";
    public static final String HUMMER_FOUNDATION_LOG_MESS = "logMessage";
    public static final String HUMMER_FOUNDATION_LOG_SEED_ID = "logSeedID";
    public static final String HUMMER_FOUNDATION_MESSAGE = "message";
    public static final String HUMMER_FOUNDATION_NEED_RPC = "needRpc";
    public static final String HUMMER_FOUNDATION_NEGATIVE = "negative";
    private static final String HUMMER_FOUNDATION_PIPE_TYPE = "pipeType";
    public static final String HUMMER_FOUNDATION_POSITIVE = "positive";
    public static final String HUMMER_FOUNDATION_QUERY = "query";
    public static final String HUMMER_FOUNDATION_SEND_RPC = "sendRpc";
    public static final String HUMMER_FOUNDATION_SHOW_ALERT = "showAlert";
    public static final String HUMMER_FOUNDATION_SHOW_LOADING_DIALOG = "showLoadingDialog";
    public static final String HUMMER_FOUNDATION_TITLE = "title";
    private static final String HUMMER_FOUNDATION_TYPE = "type";
    private static final String HUMMER_FOUNDATION_VALUE = "value";
    public static final String TAG = "ZolozEkycH5Handler";
    public static final String ZIM_IDENTIFY_ACTION = "action";
    public static final String ZIM_IDENTIFY_BIZCONFIG = "bizParam";
    public static final String ZIM_IDENTIFY_EKYCID = "ekycId";
    public static final String ZIM_IDENTIFY_EKYCONFIG = "ekycConfig";
    public static final String ZIM_IDENTIFY_FINISH_WEB_TASK = "finishWebTask";
    public static final String ZIM_IDENTIFY_NEXTINDEX = "nextIndex";
    public static final String ZIM_IDENTIFY_START_EKYC = "startEkyc";
    public static final String ZIM_IDENTIFY_STATUS = "status";

    public void identify(JSONObject jSONObject, Context context, final IH5HandlerCallback iH5HandlerCallback) {
        if (jSONObject == null || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" jsapi");
        sb.append(jSONObject.toJSONString());
        HummerLogger.i(TAG, sb.toString());
        String string = jSONObject.getString("action");
        if (StringUtil.isNullorEmpty(string)) {
            return;
        }
        EkycFacade ekycFacade = EkycFacade.getInstance();
        ekycFacade.setContext(context);
        if (ZIM_IDENTIFY_START_EKYC.equals(string)) {
            String string2 = jSONObject.getString("ekycId");
            EkycRequest ekycRequest = new EkycRequest();
            ekycRequest.eKYCId = string2;
            JSONObject jSONObject2 = jSONObject.getJSONObject("bizParam");
            Map<? extends String, ? extends Object> hashMap = new HashMap<>();
            if (jSONObject2 != null && jSONObject2.size() > 0) {
                hashMap = (Map) JSONObject.toJavaObject(jSONObject2, Map.class);
            } else {
                String string3 = jSONObject.getString("bizParam");
                if (!StringUtil.isNullorEmpty(string3)) {
                    hashMap = (Map) JSON.parseObject(string3, Map.class);
                }
            }
            ekycRequest.bizConfig.putAll(hashMap);
            ekycRequest.clientCfg = jSONObject.getString(ZIM_IDENTIFY_EKYCONFIG);
            ekycFacade.startEkyc(ekycRequest, new IEkycCallback() { // from class: com.ap.zoloz.hummer.h5.ZolozEkycH5Handler.1
                @Override // com.ap.zoloz.hummer.api.IEkycCallback
                public void onCompletion(EkycResponse ekycResponse) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("code", (Object) Integer.valueOf(ekycResponse.code));
                    jSONObject3.put("subCode", (Object) ekycResponse.subCode);
                    jSONObject3.put("result", (Object) ekycResponse.result);
                    if (ekycResponse.extInfo != null) {
                        jSONObject3.put("extInfo", (Object) ekycResponse.extInfo);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" Ekyc response ");
                    sb2.append(jSONObject3.toString());
                    HummerLogger.i(ZolozEkycH5Handler.TAG, sb2.toString());
                    iH5HandlerCallback.onCompletion(jSONObject3);
                }
            });
            return;
        }
        if (ZIM_IDENTIFY_FINISH_WEB_TASK.equals(string)) {
            EkycFacade.getInstance().endWebTask(jSONObject.getInteger("nextIndex") != null ? jSONObject.getInteger("nextIndex").intValue() : 0, jSONObject.getString("status"));
            iH5HandlerCallback.onCompletion(new JSONObject());
        } else if (HUMMER_FOUNDATION_LOGGING.equals(string)) {
            RecordManager.getInstance().record(jSONObject.getString(HUMMER_FOUNDATION_LOG_SEED_ID), (Map) JSONObject.toJavaObject(jSONObject.getJSONObject(HUMMER_FOUNDATION_LOG_MESS), Map.class));
        } else if (HUMMER_FOUNDATION_SEND_RPC.equals(string)) {
            String string4 = jSONObject.getString("type");
            EkycFacade.getInstance().getHummerContext().updateRpcIndexList();
            RpcManager.getInstance().sendRpc(new IRpcCallback() { // from class: com.ap.zoloz.hummer.h5.ZolozEkycH5Handler.2
                @Override // com.ap.zoloz.hummer.rpc.IRpcCallback
                public void onCompletion(RpcResponse rpcResponse) {
                    HummerContext hummerContext = EkycFacade.getInstance().getHummerContext();
                    if (rpcResponse == null || HummerConstants.NETWOTK_EXCEPTION.equals(rpcResponse.exception)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("success", (Object) Boolean.FALSE);
                        iH5HandlerCallback.onCompletion(jSONObject3);
                        return;
                    }
                    hummerContext.overwriteZStack(rpcResponse.factorNextResponse.zStack);
                    FactorNextResponse factorNextResponse = rpcResponse.factorNextResponse;
                    String str = factorNextResponse.versionToken;
                    if (!StringUtil.isNullorEmpty(str)) {
                        hummerContext.add(HummerConstants.VERSION_TOKEN, HummerConstants.CONTEXT, str);
                    }
                    for (int i = 0; i < factorNextResponse.response.size(); i++) {
                        for (Map.Entry<String, Object> entry : factorNextResponse.response.get(i).outParams.entrySet()) {
                            hummerContext.add(entry.getKey(), HummerConstants.SERVER_RESPONSE, entry.getValue());
                        }
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("success", (Object) Boolean.TRUE);
                    jSONObject4.put(HummerConstants.NEXT_RESPONSE, (Object) factorNextResponse);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ZolozEkycH5Handler sendBridgeResult ");
                    sb2.append(jSONObject4.toString());
                    HummerLogger.i(sb2.toString());
                    iH5HandlerCallback.onCompletion(jSONObject4);
                }
            }, RpcManager.getInstance().formatRequest(EkycFacade.getInstance().getHummerContext(), EkycFacade.getInstance().getHummerContext().getNextIndex(string4), false));
        } else if (HUMMER_FOUNDATION_SHOW_ALERT.equals(string)) {
            AlertManager.getInstance().alert(jSONObject.getString("title"), jSONObject.getString("message"), jSONObject.getString("positive"), jSONObject.getString(HUMMER_FOUNDATION_NEGATIVE), new IAlertCallback() { // from class: com.ap.zoloz.hummer.h5.ZolozEkycH5Handler.3
                @Override // com.ap.zoloz.hummer.common.IAlertCallback
                public void onPositive() {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("positive", (Object) Boolean.TRUE);
                    iH5HandlerCallback.onCompletion(jSONObject3);
                }

                @Override // com.ap.zoloz.hummer.common.IAlertCallback
                public void onNegative() {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("positive", (Object) Boolean.FALSE);
                    iH5HandlerCallback.onCompletion(jSONObject3);
                }
            });
        } else if (HUMMER_FOUNDATION_SHOW_LOADING_DIALOG.equals(string)) {
            AlertManager.getInstance().showProgressDialog("", false, new DialogInterface.OnCancelListener() { // from class: com.ap.zoloz.hummer.h5.ZolozEkycH5Handler.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            }, true);
        } else if (HUMMER_FOUNDATION_HIDE_LOADING_DIALOG.equals(string)) {
            AlertManager.getInstance().dismissDialog();
        } else if (HUMMER_FOUNDATION_ADD.equals(string)) {
            EkycFacade.getInstance().getHummerContext().add(jSONObject.getString("key"), jSONObject.getString("pipeType"), jSONObject.getObject("value", Object.class));
            iH5HandlerCallback.onCompletion(new JSONObject());
        } else if ("query".equals(string)) {
            String string5 = jSONObject.getString("key");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("value", EkycFacade.getInstance().getHummerContext().query(string5));
            iH5HandlerCallback.onCompletion(jSONObject3);
        } else if ("delete".equals(string)) {
            EkycFacade.getInstance().getHummerContext().delete(jSONObject.getString("key"));
            iH5HandlerCallback.onCompletion(new JSONObject());
        } else if (HUMMER_FOUNDATION_NEED_RPC.equals(string)) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(HUMMER_FOUNDATION_NEED_RPC, (Object) Boolean.valueOf(EkycFacade.getInstance().getHummerContext().needRPC(jSONObject.getString("type"))));
            iH5HandlerCallback.onCompletion(jSONObject4);
        } else if (HUMMER_FOUNDATION_GET_INTPUT_PARAMS.equals(string)) {
            JSONObject jSONObject5 = new JSONObject();
            Map<String, Object> inputParam = EkycFacade.getInstance().getHummerContext().getInputParam();
            if (inputParam != null) {
                jSONObject5.putAll(inputParam);
            }
            iH5HandlerCallback.onCompletion(jSONObject5);
        } else if (HUMMER_FOUNDATION_GET_OUTPUT_PARAMS.equals(string)) {
            JSONObject jSONObject6 = new JSONObject();
            JSONObject outputParam = EkycFacade.getInstance().getHummerContext().getOutputParam(jSONObject.getString("type"));
            if (outputParam != null) {
                jSONObject6 = outputParam;
            }
            iH5HandlerCallback.onCompletion(jSONObject6);
        } else if (HUMMER_FOUNDATION_GET_LANGUAGE.equals(string)) {
            String str = (String) EkycFacade.getInstance().getHummerContext().query(HummerConstants.HUMMER_LOCALE);
            if (!StringUtil.isNullorEmpty(str)) {
                updateLocale(context, str);
            } else {
                Locale systemLocale = getSystemLocale(context);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(systemLocale.getLanguage());
                sb2.append("-");
                sb2.append(systemLocale.getCountry());
                str = sb2.toString();
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("language", (Object) str);
            iH5HandlerCallback.onCompletion(jSONObject7);
        }
    }

    private Locale getSystemLocale(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (Build.VERSION.SDK_INT >= 24) {
                return context.getResources().getConfiguration().getLocales().get(0);
            }
            return context.getResources().getConfiguration().locale;
        }
        return context.getResources().getConfiguration().locale;
    }

    private void updateLocale(Context context, String str) {
        Locale locale;
        if (str != null) {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                if (str.contains("-")) {
                    String[] split = str.split("-");
                    if (split.length == 2) {
                        locale = new Locale(split[0], split[1]);
                    } else if (split.length == 1) {
                        locale = new Locale(split[0]);
                    } else if (Build.VERSION.SDK_INT >= 24) {
                        locale = context.getResources().getConfiguration().getLocales().get(0);
                    } else {
                        locale = context.getResources().getConfiguration().locale;
                    }
                } else {
                    locale = new Locale(str);
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    configuration.setLocale(locale);
                } else {
                    configuration.locale = locale;
                }
                context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
            } catch (Exception unused) {
            }
        }
    }
}
