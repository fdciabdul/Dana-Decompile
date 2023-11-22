package com.iap.ac.config.lite.preset;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.preset.PresetConfig;
import java.util.List;

/* loaded from: classes8.dex */
public class PresetParser {
    public static final String FILE_EXT = ".json";
    public static final String FILE_NAME = "amcs_config";
    public static final String UNDERLINE = "_";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7649a = e.b("PresetParser");

    public static PresetConfig.SiteConfig getSiteConfig(Context context, String str, String str2) {
        List<PresetConfig.SiteConfig> list;
        PresetConfig parsePresetConfig = parsePresetConfig(context, str2);
        if (parsePresetConfig != null && (list = parsePresetConfig.firstPartyConfig) != null) {
            for (PresetConfig.SiteConfig siteConfig : list) {
                if (siteConfig.env.toUpperCase().equals(str.toUpperCase())) {
                    return siteConfig;
                }
            }
        }
        ACLog.e(f7649a, String.format("doesn't find any siteConfig, env = %s, bizCode = %s", str, str2));
        return new PresetConfig.SiteConfig();
    }

    public static PresetConfig parsePresetConfig(Context context, String str) {
        String obj;
        StringBuilder sb = new StringBuilder();
        sb.append(FILE_NAME);
        if (TextUtils.isEmpty(str)) {
            obj = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("_");
            sb2.append(str);
            obj = sb2.toString();
        }
        sb.append(obj);
        sb.append(".json");
        String b = e.b(context, sb.toString());
        ACLog.d(f7649a, String.format("amcs_config.json content = %s", b));
        try {
            return (PresetConfig) JsonUtils.fromJson(b, PresetConfig.class);
        } catch (Exception e) {
            String str2 = f7649a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("parsePresetConfig e : ");
            sb3.append(e);
            ACLog.d(str2, sb3.toString());
            return null;
        }
    }
}
