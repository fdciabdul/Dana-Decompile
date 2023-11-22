package com.iap.ac.android.acs.plugin.ui.utils;

import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.callback.MultiLanguageCallback;
import com.iap.ac.android.biz.common.multilanguage.MultiLanguageManager;
import com.iap.ac.android.common.log.ACLog;
import java.util.Map;

/* loaded from: classes8.dex */
public class MultiLanguageUtils {
    public static final String MULTI_LANGUAGE_TEXT_BIZ_SCENE = "mobilephone";
    public static String locale;
    public static Map<String, String> multiLanguageTextMap;

    /* loaded from: classes8.dex */
    public interface Callback {
        void onGetMultiLanguageText(Map<String, String> map);
    }

    public static void clear() {
        ACLog.d("IAPConnectPlugin", "MultiLanguageUtils#clear");
        Map<String, String> map = multiLanguageTextMap;
        if (map != null) {
            map.clear();
        }
    }

    public static void getMultiLanguageTextMap(final Callback callback) {
        Map<String, String> map = multiLanguageTextMap;
        if (map != null && !map.isEmpty()) {
            callback.onGetMultiLanguageText(multiLanguageTextMap);
        } else {
            MultiLanguageManager.queryBizSceneMultiLanguage(locale, MULTI_LANGUAGE_TEXT_BIZ_SCENE, new MultiLanguageCallback<Map<String, String>>() { // from class: com.iap.ac.android.acs.plugin.ui.utils.MultiLanguageUtils.1
                @Override // com.iap.ac.android.biz.common.callback.MultiLanguageCallback
                public final void onResult(Map<String, String> map2) {
                    if (map2.isEmpty()) {
                        ACLog.e("IAPConnectPlugin", "MultiLanguageUtils#getMultiLanguageTextMap, CDN string map is empty");
                        MonitorUtil.monitorError("getBizScene empty");
                        return;
                    }
                    ACLog.d("IAPConnectPlugin", "MultiLanguageUtils#getMultiLanguageTextMap, get CDN string map successfully");
                    Map unused = MultiLanguageUtils.multiLanguageTextMap = map2;
                    Callback.this.onGetMultiLanguageText(map2);
                }
            });
        }
    }
}
