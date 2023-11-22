package com.iap.ac.android.region.cdp.component.defaults;

import android.text.TextUtils;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.component.UpdatePolicyComponent;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import com.iap.ac.android.region.cdp.util.SpProvider;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DefaultUpdatePolicyComponent extends BaseComponent implements UpdatePolicyComponent {
    public static final String TAG = CdpUtils.logTag("DefaultUpdatePolicyComponent");
    public static final String UPDATE_POLICY_INTERVAL_TIME = "time";
    public static final String UPDATE_POLICY_TYPE = "type";

    @Override // com.iap.ac.android.region.cdp.component.UpdatePolicyComponent
    public boolean shouldUpdate(CdpSpaceInfo cdpSpaceInfo) {
        JSONObject jSONObject;
        if (cdpSpaceInfo != null && !TextUtils.isEmpty(cdpSpaceInfo.spaceCode) && !TextUtils.isEmpty(cdpSpaceInfo.updatePolicy)) {
            long lastUpdateTime = SpProvider.getInstance().getLastUpdateTime(cdpSpaceInfo.spaceCode);
            long currentTimeMillis = System.currentTimeMillis();
            if (lastUpdateTime == 0) {
                ACLog.d(TAG, "lastUpdateTime is 0, never update before");
                return true;
            }
            try {
                jSONObject = new JSONObject(cdpSpaceInfo.updatePolicy);
            } catch (Exception e) {
                String str = TAG;
                StringBuilder a2 = a.a("parse update policy error, updatePolicy: ");
                a2.append(cdpSpaceInfo.updatePolicy);
                ACLog.e(str, a2.toString(), e);
                jSONObject = null;
            }
            if (jSONObject == null) {
                return true;
            }
            String optString = jSONObject.optString("type");
            long optLong = jSONObject.optLong("time");
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("update policy type: ");
            sb.append(optString);
            sb.append(", lastUpdateTime: ");
            sb.append(lastUpdateTime);
            sb.append(", currentTime: ");
            sb.append(currentTimeMillis);
            ACLog.d(str2, sb.toString());
            optString.hashCode();
            char c = 65535;
            switch (optString.hashCode()) {
                case 67452:
                    if (optString.equals("DAY")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2223588:
                    if (optString.equals("HOUR")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2660340:
                    if (optString.equals("WEEK")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1353045189:
                    if (optString.equals(CdpSpaceInfo.UPDATE_POLICY_INTERVAL)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c == 3 && currentTimeMillis - lastUpdateTime <= optLong * 1000) {
                            return false;
                        }
                    } else if (currentTimeMillis - lastUpdateTime <= TimeUnit.DAYS.toMillis(optLong * 7)) {
                        return false;
                    }
                } else if (currentTimeMillis - lastUpdateTime <= TimeUnit.HOURS.toMillis(optLong)) {
                    return false;
                }
            } else if (currentTimeMillis - lastUpdateTime <= TimeUnit.DAYS.toMillis(optLong)) {
                return false;
            }
        }
        return true;
    }
}
