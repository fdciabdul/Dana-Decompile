package com.ap.zoloz.hot.reload;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes7.dex */
public class StringsManager {
    private Map<String, Map<String, String>> mAllStrings = new HashMap();

    public void clear() {
        this.mAllStrings.clear();
    }

    public void add(String str, Map<String, String> map) {
        this.mAllStrings.put(str, map);
    }

    public String getString(Context context, String str, int i) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        String country = locale.getCountry();
        String language = locale.getLanguage();
        Map<String, Map<String, String>> map = this.mAllStrings;
        StringBuilder sb = new StringBuilder();
        sb.append("strings_");
        sb.append(language);
        sb.append("-");
        sb.append(country);
        sb.append(".json");
        Map<String, String> map2 = map.get(sb.toString());
        if (map2 == null) {
            Map<String, Map<String, String>> map3 = this.mAllStrings;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("strings_");
            sb2.append(language);
            sb2.append(".json");
            map2 = map3.get(sb2.toString());
        }
        if (map2 == null) {
            map2 = this.mAllStrings.get("strings_default.json");
        }
        if (map2 == null || map2.get(str) == null) {
            return i == 0 ? "" : context.getResources().getString(i);
        }
        return map2.get(str);
    }

    public boolean containsKey(String str) {
        Iterator<Map.Entry<String, Map<String, String>>> it = this.mAllStrings.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().containsKey(str)) {
                return true;
            }
        }
        return false;
    }
}
