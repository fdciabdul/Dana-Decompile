package com.huawei.hms.framework.common.grs;

import com.huawei.hms.framework.common.StringUtils;
import java.util.Locale;

/* loaded from: classes7.dex */
public class GrsUtils {
    public static String[] parseParams(String str) {
        if (str.endsWith("/")) {
            str = StringUtils.substring(str, str.indexOf("grs://"), str.length() - 1);
        }
        return parseGRSSchema(str);
    }

    public static String[] parseGRSSchema(String str) {
        String[] split = StringUtils.substring(str, str.toLowerCase(Locale.ENGLISH).indexOf("grs://") + 6).split("/", 3);
        return split.length == 1 ? new String[]{split[0], "ROOT"} : split;
    }

    public static String fixResult(String[] strArr, String str) {
        if (strArr.length > 2) {
            if (str.endsWith("/")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(strArr[2]);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("/");
            sb2.append(strArr[2]);
            return sb2.toString();
        }
        return str;
    }

    public static boolean isGRSSchema(String str) {
        return str != null && str.startsWith("grs://");
    }
}
