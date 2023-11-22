package com.iap.ac.android.biz.common.internal.config.utils;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.CPMConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.RegionCodeTypeMapConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.mpm.HookUrlConfig;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class ConfigUtils {
    public static <T> T fromJson(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        try {
            return (T) JsonUtils.fromJson(str, (Class) cls);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigUtils, fromJson exception: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }

    public static List<CPMConfig> parseCpmConfigList(String str) {
        try {
            return Arrays.asList((CPMConfig[]) JsonUtils.fromJson(str, CPMConfig[].class));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseCpmConfigList exception: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }

    public static List<HookUrlConfig> parseHookeUrlConfigList(String str) {
        try {
            return Arrays.asList((HookUrlConfig[]) JsonUtils.fromJson(str, HookUrlConfig[].class));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseHookUrlConfigList exception: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return JsonUtils.toJson(obj);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigUtils, toJson exception: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }

    public static List<RegionCodeTypeMapConfig> parseRegionCodeTypeMapList(String str) {
        try {
            return Arrays.asList((RegionCodeTypeMapConfig[]) JsonUtils.fromJson(str, RegionCodeTypeMapConfig[].class));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseRegionCodeTypeMapList exception: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }
}
