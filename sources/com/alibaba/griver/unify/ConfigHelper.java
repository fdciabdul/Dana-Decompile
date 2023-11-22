package com.alibaba.griver.unify;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.lottie.utils.SharedPreferenceUtil;
import com.alibaba.griver.unify.model.IconModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ConfigHelper {
    public static final String CACHE_KEY = "RESOURCE_REPLACE_CACHE";
    public static final String ICONFONT_CACHE_KEY = "RESOURCE_ICONFONT_REPLACE_CACHE";
    public static final String ICONFONT_KEY_CACHE_KEY = "RESOURCE_ICONFONT_KEY_CACHE";
    public static final String LANGUAGE_SPIT_KEY = "_,";
    public static final String LOTTIE_CACHE_KEY = "RESOURCE_LOTTIE_REPLACE_CACHE";
    private static final String TAG = "ResourceConfigHelper";
    private static SharedPreferences defaultSharedPreference;

    public static Map<String, IconModel> getIconFontModel(String str) {
        if (TextUtils.isEmpty(str)) {
            GriverLogger.debug(TAG, "getIconFontModel value is empty");
            return null;
        }
        List<IconModel> parseArray = JSONObject.parseArray(str, IconModel.class);
        HashMap hashMap = new HashMap();
        for (IconModel iconModel : parseArray) {
            if (iconModel != null && !TextUtils.isEmpty(iconModel.key)) {
                String str2 = iconModel.key;
                StringBuilder sb = new StringBuilder();
                sb.append("getIconFontModel key = ");
                sb.append(str2);
                GriverLogger.debug(TAG, sb.toString());
                hashMap.put(str2, iconModel);
            }
        }
        return hashMap;
    }

    public static SharedPreferences getDefaultSharedPreference() {
        if (defaultSharedPreference == null) {
            defaultSharedPreference = SharedPreferenceUtil.getInstance().getDefaultSharedPreference(GriverEnv.getApplicationContext());
        }
        return defaultSharedPreference;
    }
}
