package com.iap.ac.android.acs.plugin.downgrade.resource;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.downgrade.jsapi.JSAPIReadAssetCallback;
import com.iap.ac.android.acs.plugin.utils.ConfigUtils;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.lang.reflect.ParameterizedType;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseConfigModel<T> {
    public T mode;

    public BaseConfigModel() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Class<T> getGenericClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        if (parameterizedType == null || parameterizedType.getActualTypeArguments().length <= 0) {
            return null;
        }
        return (Class) parameterizedType.getActualTypeArguments()[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPresetConfigFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "iapconnect_config.json";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("iapconnect_config_");
        sb.append(str.toLowerCase());
        sb.append(".json");
        return sb.toString();
    }

    public abstract String getSectionName();

    public boolean isValid() {
        return this.mode != null;
    }

    public void loadConfigFromAsset(final Context context, final String str, final JSAPIReadAssetCallback jSAPIReadAssetCallback) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.downgrade.resource.BaseConfigModel.1
            @Override // java.lang.Runnable
            public void run() {
                String readConfigFromAsset = Utils.readConfigFromAsset(context, BaseConfigModel.this.getPresetConfigFileName(str));
                if (!TextUtils.isEmpty(readConfigFromAsset)) {
                    try {
                        JSONObject jSONObject = new JSONObject(readConfigFromAsset);
                        if (jSONObject.has(BaseConfigModel.this.getSectionName())) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(BaseConfigModel.this.getSectionName());
                            BaseConfigModel.this.mode = (T) ConfigUtils.fromJson(jSONObject2.toString(), BaseConfigModel.this.getGenericClass());
                        }
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("BaseConfigModel error, parse mode null with json: ");
                        sb.append(readConfigFromAsset);
                        sb.append(",e:");
                        sb.append(th);
                        ACLog.d("IAPConnectPlugin", sb.toString());
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("BaseConfigModel error, parse mode null with json: ");
                    sb2.append(readConfigFromAsset);
                    ACLog.d("IAPConnectPlugin", sb2.toString());
                }
                jSAPIReadAssetCallback.onParseResult();
            }
        });
    }

    public BaseConfigModel(Context context, String str) {
        String readConfigFromAsset = Utils.readConfigFromAsset(context, getPresetConfigFileName(str));
        if (!TextUtils.isEmpty(readConfigFromAsset)) {
            try {
                JSONObject jSONObject = new JSONObject(readConfigFromAsset);
                if (jSONObject.has(getSectionName())) {
                    this.mode = (T) ConfigUtils.fromJson(jSONObject.getJSONObject(getSectionName()).toString(), getGenericClass());
                    return;
                }
                return;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("BaseConfigModel error, parse mode null with json: ");
                sb.append(readConfigFromAsset);
                sb.append(",e:");
                sb.append(th);
                ACLog.d("IAPConnectPlugin", sb.toString());
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BaseConfigModel error, parse mode null with json: ");
        sb2.append(readConfigFromAsset);
        ACLog.d("IAPConnectPlugin", sb2.toString());
    }
}
