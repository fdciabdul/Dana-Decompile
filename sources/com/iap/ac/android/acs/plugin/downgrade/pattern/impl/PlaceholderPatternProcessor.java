package com.iap.ac.android.acs.plugin.downgrade.pattern.impl;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.downgrade.pattern.IPatternProcessor;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PlaceholderPatternProcessor implements IPatternProcessor {
    public static final String FORMATTED_REGEX = "${%s}";
    public static final String TAG = ApiDowngradeUtils.logTag("PlaceholderPatternProcessor");
    public static final Pattern mPattern = Pattern.compile("(?<=\\$\\{)[^}]+");

    @Override // com.iap.ac.android.acs.plugin.downgrade.pattern.IPatternProcessor
    public String process(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            ACLog.w(TAG, "patternKeyword(): the rawString is empty");
            return str;
        }
        HashMap hashMap = new HashMap();
        Matcher matcher = mPattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            String str2 = "";
            if (!TextUtils.isEmpty(group) && jSONObject != null) {
                String[] split = group.split("\\.");
                int length = split.length - 1;
                JSONObject jSONObject2 = jSONObject;
                for (int i = 0; i < length && jSONObject2 != null; i++) {
                    jSONObject2 = jSONObject2.optJSONObject(split[i].trim());
                }
                if (jSONObject2 != null) {
                    str2 = jSONObject2.optString(split[length].trim(), "");
                }
            }
            hashMap.put(String.format(FORMATTED_REGEX, group), str2);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
        }
        return str;
    }
}
