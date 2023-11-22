package com.iap.ac.android.region.cdp.component.defaults;

import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.component.AmcsConfigComponent;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DefaultAmcsConfigComponent extends BaseComponent implements AmcsConfigComponent {
    public static final String KEY_CDP_ENABLE = "cdp_enable";
    public static final String KEY_FORCE_CLEAR_CACHED_SPACE_CODES = "force_clear_cached_space_codes";
    public static final String SECTION_NAME = "cdp_config";
    public final String TAG = CdpUtils.logTag("DefaultAmcsConfigComponent");

    private JSONObject fetchJsonSection() {
        return ACConfig.getInstance("ac_biz").getSectionConfig(SECTION_NAME);
    }

    private <T> T getKeyOrDefault(String str, T t) {
        JSONObject fetchJsonSection = fetchJsonSection();
        if (fetchJsonSection == null) {
            return t;
        }
        try {
            T t2 = (T) fetchJsonSection.get(str);
            String str2 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("get value from config center, key: ");
            sb.append(str);
            sb.append(", value: ");
            sb.append(t2);
            ACLog.d(str2, sb.toString());
            return t2;
        } catch (Exception e) {
            String str3 = this.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getKeyOrDefault exception: ");
            sb2.append(e);
            ACLog.e(str3, sb2.toString());
            String str4 = this.TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("get value from config center fail, key: ");
            sb3.append(str);
            sb3.append(", use default value: ");
            sb3.append(t);
            ACLog.w(str4, sb3.toString());
            return t;
        }
    }

    @Override // com.iap.ac.android.region.cdp.component.AmcsConfigComponent
    public JSONObject getForceClearCachedSpaceCodes() {
        return (JSONObject) getKeyOrDefault(KEY_FORCE_CLEAR_CACHED_SPACE_CODES, new JSONObject());
    }

    @Override // com.iap.ac.android.region.cdp.component.AmcsConfigComponent
    public boolean isCdpEnable() {
        return ((Boolean) getKeyOrDefault(KEY_CDP_ENABLE, Boolean.TRUE)).booleanValue();
    }
}
