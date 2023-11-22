package id.dana.data.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.data.constant.DanaUrl;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UrlUtil {
    private UrlUtil() {
    }

    public static String getDynamicUrl(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        if (str.charAt(0) != '/') {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(str);
            str4 = sb.toString();
        } else {
            str4 = str;
        }
        if (TextUtils.isEmpty(str2)) {
            return str4;
        }
        if (containsQueryString(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append(str2.replace("?", ContainerUtils.FIELD_DELIMITER));
            return sb2.toString();
        } else if (str.endsWith("?")) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append(str2.replace("?", ""));
            return sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str4);
            sb4.append(str2);
            return sb4.toString();
        }
    }

    public static boolean isDeepLink(String str) {
        return !TextUtils.isEmpty(str) && str.trim().contains(DanaUrl.DEEPLINK_URL);
    }

    private static boolean containsQueryString(String str) {
        return str.contains("?") && str.contains("=");
    }

    public static Map<String, List<String>> splitQuery(URL url) {
        try {
            return splitQuery(url.getQuery());
        } catch (UnsupportedEncodingException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("UrlUtil", e.getMessage());
            return null;
        }
    }

    private static Map<String, List<String>> splitQuery(String str) throws UnsupportedEncodingException {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            throw new UnsupportedEncodingException();
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            int indexOf = str2.indexOf(61);
            String decode = indexOf > 0 ? URLDecoder.decode(str2.substring(0, indexOf), StandardCharsets.UTF_8.name()) : str2;
            if (!linkedHashMap.containsKey(decode)) {
                linkedHashMap.put(decode, new LinkedList());
            }
            ((List) linkedHashMap.get(decode)).add(removeArrayBracket((indexOf <= 0 || str2.length() <= (i = indexOf + 1)) ? null : URLDecoder.decode(str2.substring(i), StandardCharsets.UTF_8.name())));
        }
        return linkedHashMap;
    }

    private static String removeArrayBracket(String str) {
        if (str != null) {
            if (str.charAt(0) == '[') {
                str = str.replaceFirst("\\[", "");
            }
            return str.charAt(str.length() + (-1)) == ']' ? str.substring(0, str.length() - 1) : str;
        }
        return str;
    }
}
