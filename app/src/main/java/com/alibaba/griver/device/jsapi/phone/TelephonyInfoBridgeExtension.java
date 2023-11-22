package com.alibaba.griver.device.jsapi.phone;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class TelephonyInfoBridgeExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6513a = "TelephonyInfoBridgeExtension";
    private HashMap<String, String> b = new HashMap<String, String>() { // from class: com.alibaba.griver.device.jsapi.phone.TelephonyInfoBridgeExtension.1
        {
            put("46000", "China Mobile");
            put("46002", "China Mobile");
            put("46007", "China Mobile");
            put("46001", "China Unicom");
            put("46006", "China Unicom");
            put("46003", "China Telecom");
            put("46005", "China Telecom");
            put("46011", "China Telecom");
            put("46020", "Chine Tietong");
            put("46004", "China Aerospace");
            put("CMCC", "China Mobile");
            put("CUCC", "China Unicom");
            put("CTCC", "China Telecom");
        }
    };

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getCarrierName(@BindingApiContext ApiContext apiContext) {
        String str;
        Activity activity = apiContext.getActivity();
        if (activity == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        String b = b(activity);
        String str2 = null;
        String b2 = !TextUtils.isEmpty(b) ? b(b) : null;
        if (TextUtils.isEmpty(b2)) {
            String str3 = f6513a;
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append(": from getSimOperator no name.");
            RVLogger.w(str3, sb.toString());
            str = d(activity);
            if (!TextUtils.isEmpty(str)) {
                b2 = c(str);
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(b2)) {
            String str4 = f6513a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" from getSubscriberId no name.");
            RVLogger.w(str4, sb2.toString());
            str2 = a(activity);
            if (!TextUtils.isEmpty(str2)) {
                b2 = a(str2);
            }
        }
        if (TextUtils.isEmpty(b2)) {
            RVLogger.w(f6513a, "take nothing from getSimOperatorName.");
        }
        String str5 = f6513a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("name=");
        sb3.append(str2);
        sb3.append(" sim=");
        sb3.append(b);
        sb3.append("imsi=");
        sb3.append(str);
        RVLogger.w(str5, sb3.toString());
        if (TextUtils.isEmpty(b2)) {
            return new BridgeResponse.NamedValue("carrierName", "");
        }
        return new BridgeResponse.NamedValue("carrierName", b2);
    }

    private String a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                return telephonyManager.getSimOperatorName();
            } catch (Exception e) {
                RVLogger.e(f6513a, e);
                return null;
            }
        }
        return null;
    }

    private String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                return telephonyManager.getSimOperator();
            } catch (Exception e) {
                RVLogger.e(f6513a, e);
                return null;
            }
        }
        return null;
    }

    private boolean c(Context context) {
        return ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, "android.permission.READ_PHONE_STATE") != 0;
    }

    private String d(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            if (!c(context) || telephonyManager == null) {
                return null;
            }
            return telephonyManager.getSubscriberId();
        } catch (Exception e) {
            RVLogger.e(f6513a, e);
            return null;
        }
    }

    private String a(String str) {
        String str2;
        try {
            str2 = this.b.get(str);
        } catch (Exception e) {
            RVLogger.e(f6513a, e);
            str2 = null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    private String b(String str) {
        try {
            return this.b.get(str);
        } catch (Exception e) {
            RVLogger.e(f6513a, e);
            return null;
        }
    }

    private String c(String str) {
        try {
            for (String str2 : this.b.keySet()) {
                if (str.startsWith(str2)) {
                    return this.b.get(str2);
                }
            }
            return null;
        } catch (Exception e) {
            RVLogger.e(f6513a, e);
            return null;
        }
    }
}
