package com.iap.ac.android.acs.multilanguage.utils;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.iap.ac.android.common.log.ACLog;
import id.dana.data.here.model.HereUrlConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LanguageFormatter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7534a = LanguagePackageUtil.logTag("LanguageFormatter");
    private static final Map<String, String> b;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("en", HereUrlConstant.LANG_US);
        hashMap.put("de", "de-DE");
        hashMap.put(RVParams.ENABLE_SCROLLBAR, "es-ES");
        hashMap.put("fr", "fr-FR");
        hashMap.put("id", "id-ID");
        hashMap.put("it", "it-IT");
        hashMap.put("ja", "ja-JP");
        hashMap.put("ko", "ko-KR");
        hashMap.put("nl", "nl-NL");
        hashMap.put("pt", "pt-PT");
        hashMap.put("ru", "ru-RU");
        hashMap.put("th", "th-TH");
        hashMap.put(RVParams.SHOW_TITLE_LOADING, "tl-PH");
        hashMap.put("tr", "tr-TR");
        hashMap.put("uk", "uk-UA");
        hashMap.put("vi", "vi-VN");
        hashMap.put("zh", "zh-CN");
        hashMap.put("zh-Hans", "zh-CN");
        hashMap.put("zh-Hant", "zh-TW");
        hashMap.put("zh-tw", "zh-TW");
        hashMap.put("zh-TW", "zh-TW");
        hashMap.put("zh-hk", "zh-TW");
        hashMap.put("zh-HK", "zh-TW");
        hashMap.put("zh-MO", "zh-TW");
        hashMap.put("zh-mo", "zh-TW");
        hashMap.put("zh-SG", "zh-CN");
        hashMap.put("zh-sg", "zh-CN");
    }

    public static String formatWithPattern(String str) {
        if (TextUtils.isEmpty(str)) {
            MultiLanguageLogger.newLogger("ac_lang_package_code_matcher").addParams("errorMessage", "rawLanguageCode is empty").event();
            ACLog.d(f7534a, "rawLanguageCode is empty");
            return null;
        }
        Map<String, String> map = b;
        if (map.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("language ");
            sb.append(str);
            sb.append(" changed to ");
            sb.append(map.get(str));
            String obj = sb.toString();
            MultiLanguageLogger.newLogger("ac_lang_package_code_matcher").addParams("message", obj).event();
            ACLog.d(f7534a, obj);
            return map.get(str);
        }
        String splitPrefix = LanguagePackageUtil.splitPrefix(str);
        if (map.containsKey(splitPrefix)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("language code ");
            sb2.append(str);
            sb2.append(" changed to ");
            sb2.append(map.get(splitPrefix));
            String obj2 = sb2.toString();
            MultiLanguageLogger.newLogger("ac_lang_package_code_matcher").addParams("message", obj2).event();
            ACLog.d(f7534a, obj2);
            return map.get(splitPrefix);
        }
        return null;
    }
}
