package com.alipay.iap.android.common.securityprofiles.provider;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class ConfigProfileProvider implements ProfileProvider {
    private static final String TAG = "ConfigProfileProvider";
    private JSONObject mProfile;

    public ConfigProfileProvider(String str) {
        try {
            this.mProfile = new JSONObject(str);
        } catch (JSONException e) {
            LoggerWrapper.e(TAG, "Cannot parse profile from json!", e);
        }
    }

    @Override // com.alipay.iap.android.common.securityprofiles.provider.ProfileProvider
    public String getProfileData(Context context, String str) {
        JSONObject jSONObject = this.mProfile;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(str);
    }
}
