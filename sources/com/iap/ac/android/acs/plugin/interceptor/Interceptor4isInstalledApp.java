package com.iap.ac.android.acs.plugin.interceptor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4isInstalledApp extends BaseInterceptor {
    public static final String PARAM_PACKAGE_NAME = "packagename";
    public static final String TAG = "IAPConnectPlugin";

    private void checkAppInstalled(String str, Context context, IAPConnectPluginCallback iAPConnectPluginCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4isInstalledApp#checkAppInstalled, start to check whether app is installed, packageName: ");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        boolean z = false;
        for (int i = 0; i < installedPackages.size(); i++) {
            if (str.equals(installedPackages.get(i).packageName)) {
                z = true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("installed", z);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4isInstalledApp#checkAppInstalled, convert result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_IS_INSTALLED_APP, e);
        }
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4isInstalledApp#handle, jsParameters is null", Constants.JS_API_IS_INSTALLED_APP, "parameter is null", iAPConnectPluginCallback);
            return;
        }
        String optString = jSONObject.optString(PARAM_PACKAGE_NAME);
        if (TextUtils.isEmpty(optString)) {
            a.a("IAPConnectPlugin", "Interceptor4isInstalledApp#handle, packagename is empty", Constants.JS_API_IS_INSTALLED_APP, "packagename is empty", iAPConnectPluginCallback);
        } else {
            checkAppInstalled(optString, iAPConnectPluginContext.getContext(), iAPConnectPluginCallback);
        }
    }
}
