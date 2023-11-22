package com.iap.ac.android.biz.common.internal.config.common;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AMCSConfigModel {
    public boolean mainSwitchOn = true;

    public boolean getAMCSToggle() {
        return this.mainSwitchOn;
    }

    public boolean parseFromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            ACLog.e(Constants.TAG, "AMCSConfigModel, parse error, invalid input");
            return false;
        }
        try {
            this.mainSwitchOn = new JSONObject(str).getBoolean(InnerConstants.KEY_AMCS_TOGGLE);
            return true;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("AMCSConfigModel, parseFromJson exception: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return false;
        }
    }
}
