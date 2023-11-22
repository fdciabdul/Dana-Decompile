package com.huawei.hms.push;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.alipay.alipaysecuritysdk.rds.constant.DictionaryKeys;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class k {
    public String B;
    public String FragmentBottomSheetPaymentSettingBinding;
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;
    public String NetworkUserEntityData$$ExternalSyntheticLambda5;
    public String NetworkUserEntityData$$ExternalSyntheticLambda6;
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public int PlaceComponentResult;
    public String PrepareContext;
    public String getAuthRequestContext;
    public String lookAheadTest;
    public String moveToNextValue;
    public String newProxyInstance;
    public int scheduleImpl;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
    public String DatabaseTableConfigUtil = "";
    public String GetContactSyncConfig = "";
    public String NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
    public String initRecordTimeStamp = "";
    public String NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
    public String NetworkUserEntityData$$ExternalSyntheticLambda7 = "";
    public String isLayoutRequested = "";
    public String NetworkUserEntityData$$ExternalSyntheticLambda3 = "";
    public int getSupportButtonTintMode = n.STYLE_DEFAULT.ordinal();
    public String whenAvailable = "";
    public String getCallingPid = "";
    public String readMicros = "";
    public int SubSequence = 0;
    public int VerifyPinStateManager$executeRiskChallenge$2$1 = 0;
    public String KClassImpl$Data$declaredNonStaticMembers$2 = "";
    public String BuiltInFictitiousFunctionClassFactory = "";
    public String MyBillsEntityDataFactory = "";
    public String getErrorConfigVersion = "";

    public k(byte[] bArr, byte[] bArr2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new String(bArr, x.PlaceComponentResult);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new String(bArr2, x.PlaceComponentResult);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("acn")) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = jSONObject.getString("acn");
        }
        if (jSONObject.has("intentUri")) {
            this.lookAheadTest = jSONObject.getString("intentUri");
        }
        if (jSONObject.has(DictionaryKeys.V2_PACKAGENAME)) {
            this.newProxyInstance = jSONObject.getString(DictionaryKeys.V2_PACKAGENAME);
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("param");
            if (jSONObject2.has("autoClear")) {
                this.scheduleImpl = jSONObject2.getInt("autoClear");
            } else {
                this.scheduleImpl = 0;
            }
            if (!GriverOnPreloadExtension.PARAMS_APP.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda1) && !"cosa".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                if ("url".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                    scheduleImpl(jSONObject2);
                    return true;
                } else if ("rp".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                    getErrorConfigVersion(jSONObject2);
                    return true;
                } else {
                    return true;
                }
            }
            BuiltInFictitiousFunctionClassFactory(jSONObject2);
            return true;
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", e);
            return false;
        }
    }

    private boolean MyBillsEntityDataFactory(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("msgId")) {
            Object obj = jSONObject.get("msgId");
            if (obj instanceof String) {
                this.DatabaseTableConfigUtil = (String) obj;
                return true;
            } else if (obj instanceof Integer) {
                this.DatabaseTableConfigUtil = String.valueOf(((Integer) obj).intValue());
                return true;
            } else {
                return true;
            }
        }
        HMSLog.i("PushSelfShowLog", "msgId == null");
        return false;
    }

    private boolean PlaceComponentResult(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("psContent")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("psContent");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = jSONObject2.getString(BridgeDSL.CMD);
            this.initRecordTimeStamp = jSONObject2.optString("content");
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = jSONObject2.optString("notifyIcon");
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = jSONObject2.optString("notifyTitle");
            this.isLayoutRequested = jSONObject2.optString("notifySummary");
            this.getAuthRequestContext = jSONObject2.optString("ticker");
            if ((!jSONObject2.has("notifyDetail") || getAuthRequestContext(jSONObject2)) && jSONObject2.has("param")) {
                return KClassImpl$Data$declaredNonStaticMembers$2(jSONObject2);
            }
        }
        return false;
    }

    private boolean getAuthRequestContext(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("notifyDetail");
            if (jSONObject2.has(ZebraData.ATTR_STYLE)) {
                this.getSupportButtonTintMode = jSONObject2.getInt(ZebraData.ATTR_STYLE);
            }
            this.whenAvailable = jSONObject2.optString("bigTitle");
            this.getCallingPid = jSONObject2.optString("bigContent");
            this.MyBillsEntityDataFactory = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e) {
            HMSLog.i("PushSelfShowLog", e.toString());
            return false;
        }
    }

    private boolean getErrorConfigVersion(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(DictionaryKeys.V2_PACKAGENAME)) {
            this.newProxyInstance = jSONObject.getString(DictionaryKeys.V2_PACKAGENAME);
        }
        if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
            this.FragmentBottomSheetPaymentSettingBinding = jSONObject.getString("rpl");
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = jSONObject.getString("rpt");
            if (jSONObject.has("rpct")) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = jSONObject.getString("rpct");
                return true;
            }
            return true;
        }
        HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
        return false;
    }

    private boolean scheduleImpl(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.PrepareContext = jSONObject.getString("url");
            if (jSONObject.has(DictionaryKeys.V2_PACKAGENAME)) {
                this.newProxyInstance = jSONObject.getString(DictionaryKeys.V2_PACKAGENAME);
            }
            if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
                this.FragmentBottomSheetPaymentSettingBinding = jSONObject.getString("rpl");
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = jSONObject.getString("rpt");
                if (jSONObject.has("rpct")) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda3 = jSONObject.getString("rpct");
                    return true;
                }
                return true;
            }
            return true;
        }
        HMSLog.d("PushSelfShowLog", HummerZCodeConstant.URL_ERROR_MSG);
        return false;
    }

    public final byte[] BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4.getBytes(x.PlaceComponentResult);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            if (TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = jSONObject.optString("group");
            StringBuilder sb = new StringBuilder();
            sb.append("NOTIFY_GROUP:");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            HMSLog.d("PushSelfShowLog", sb.toString());
            this.SubSequence = jSONObject.optInt("autoCancel", 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("autoCancel: ");
            sb2.append(this.SubSequence);
            HMSLog.d("PushSelfShowLog", sb2.toString());
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = jSONObject.optInt("visibility", 0);
            this.B = jSONObject.optString("when");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject.optString("tag");
            JSONObject jSONObject2 = jSONObject.getJSONObject("msgContent");
            if (MyBillsEntityDataFactory(jSONObject2)) {
                this.GetContactSyncConfig = jSONObject2.optString("dispPkgName");
                if (jSONObject2.has(RVParams.ANTI_PHISHING)) {
                    String string = jSONObject2.getString(RVParams.ANTI_PHISHING);
                    StringBuilder sb3 = new StringBuilder();
                    if (!TextUtils.isEmpty(string) && string.length() < 48) {
                        int length = string.length();
                        for (int i = 0; i < 48 - length; i++) {
                            sb3.append("0");
                        }
                        sb3.append(string);
                        this.moveToNextValue = sb3.toString();
                    } else {
                        this.moveToNextValue = string.substring(0, 48);
                    }
                }
                this.PlaceComponentResult = jSONObject2.optInt("notifyId", -1);
                this.BuiltInFictitiousFunctionClassFactory = jSONObject2.optString("data");
                this.getErrorConfigVersion = jSONObject2.optString("analyticInfo");
                return PlaceComponentResult(jSONObject2);
            }
            return false;
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e) {
            HMSLog.d("PushSelfShowLog", e.toString());
            return false;
        }
    }

    public final String PlaceComponentResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("msgId =");
        sb.append(this.DatabaseTableConfigUtil);
        HMSLog.d("PushSelfShowLog", sb.toString());
        return this.DatabaseTableConfigUtil;
    }

    public final byte[] MyBillsEntityDataFactory() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("autoClear", this.scheduleImpl);
            jSONObject.put("url", this.PrepareContext);
            jSONObject.put("rpl", this.FragmentBottomSheetPaymentSettingBinding);
            jSONObject.put("rpt", this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            jSONObject.put("rpct", this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            jSONObject.put(DictionaryKeys.V2_PACKAGENAME, this.newProxyInstance);
            jSONObject.put("acn", this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            jSONObject.put("intentUri", this.lookAheadTest);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BridgeDSL.CMD, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            jSONObject2.put("content", this.initRecordTimeStamp);
            jSONObject2.put("notifyIcon", this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            jSONObject2.put("notifyTitle", this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            jSONObject2.put("notifySummary", this.isLayoutRequested);
            jSONObject2.put("param", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(ZebraData.ATTR_STYLE, this.getSupportButtonTintMode);
            jSONObject3.put("bigTitle", this.whenAvailable);
            jSONObject3.put("bigContent", this.getCallingPid);
            jSONObject3.put("bigPic", this.readMicros);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dispPkgName", this.GetContactSyncConfig);
            jSONObject4.put("msgId", this.DatabaseTableConfigUtil);
            jSONObject4.put(RVParams.ANTI_PHISHING, this.moveToNextValue);
            jSONObject4.put("notifyId", this.PlaceComponentResult);
            jSONObject4.put("psContent", jSONObject2);
            jSONObject4.put("notifyDetail", jSONObject3);
            jSONObject4.put("ticker", this.getAuthRequestContext);
            jSONObject4.put("data", this.BuiltInFictitiousFunctionClassFactory);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("msgContent", jSONObject4);
            jSONObject5.put("group", this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            jSONObject5.put("tag", this.KClassImpl$Data$declaredNonStaticMembers$2);
            jSONObject5.put("autoCancel", this.SubSequence);
            jSONObject5.put("visibility", this.VerifyPinStateManager$executeRiskChallenge$2$1);
            jSONObject5.put("when", this.B);
            return jSONObject5.toString().getBytes(x.PlaceComponentResult);
        } catch (JSONException e) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e);
            return new byte[0];
        }
    }
}
