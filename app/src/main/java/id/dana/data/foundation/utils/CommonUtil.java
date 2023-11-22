package id.dana.data.foundation.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecException;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.util.RandomMatchers;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Locale;

/* loaded from: classes.dex */
public class CommonUtil {
    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        return str == null ? "" : str;
    }

    private CommonUtil() {
    }

    public static String PlaceComponentResult() {
        return Locale.getDefault().toString().endsWith("ID") ? "id_ID" : "en_US";
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SecurityGuardFacade securityGuardFacade, String str) {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    securityGuardFacade.PlaceComponentResult().getDynamicDataStoreComp().putStringDDpEx("clientKey", str, 0);
                    return;
                }
            } catch (SecException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.COMMON_TAG, "[SetClientKey]:SecException ", e);
                return;
            }
        }
        securityGuardFacade.PlaceComponentResult().getDynamicDataStoreComp().removeStringDDpEx("clientKey", 0);
    }

    public static void BuiltInFictitiousFunctionClassFactory(SecurityGuardFacade securityGuardFacade, String str) {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    securityGuardFacade.PlaceComponentResult().getDynamicDataStoreComp().putStringDDpEx("userId", str, 0);
                    return;
                }
            } catch (SecException e) {
                DanaLog.scheduleImpl("CommonUtil", e.getMessage());
                return;
            }
        }
        securityGuardFacade.PlaceComponentResult().getDynamicDataStoreComp().removeStringDDpEx("userId", 0);
    }

    public static String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(RandomMatchers.randomInt(62)));
        }
        return sb.toString();
    }

    public static String MyBillsEntityDataFactory(String str) {
        try {
            Uri parse = Uri.parse(str);
            String path = parse.getPath();
            String str2 = "";
            if (path == null) {
                path = "";
            }
            String query = parse.getQuery();
            if (query != null) {
                str2 = query;
            }
            if (TextUtils.isEmpty(path)) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return path;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append("?");
            sb.append(str2);
            return sb.toString();
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.COMMON_TAG, "EncodingParam ", e);
            return null;
        }
    }

    public static int BuiltInFictitiousFunctionClassFactory() {
        return ConfigCenter.getInstance().getIntConfig("legacyConfigVersion", 0);
    }

    public static long KClassImpl$Data$declaredNonStaticMembers$2() {
        return System.currentTimeMillis() / 1000;
    }

    public static String PlaceComponentResult(SecurityGuardFacade securityGuardFacade, String str) {
        try {
            String stringDDpEx = securityGuardFacade.PlaceComponentResult().getDynamicDataStoreComp().getStringDDpEx("clientKey", 0);
            if (stringDDpEx != null) {
                stringDDpEx = stringDDpEx.trim();
            }
            return stringDDpEx;
        } catch (SecException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("[GetClientKey]: Exception \t defaultValue");
            sb.append(str);
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.COMMON_TAG, sb.toString(), e);
            return str;
        }
    }

    public static String MyBillsEntityDataFactory(SecurityGuardFacade securityGuardFacade, String str) {
        try {
            String stringDDpEx = securityGuardFacade.PlaceComponentResult().getDynamicDataStoreComp().getStringDDpEx("userId", 0);
            if (stringDDpEx != null) {
                stringDDpEx = stringDDpEx.trim();
            }
            return stringDDpEx;
        } catch (SecException e) {
            DanaLog.scheduleImpl("CommonUtil", e.getMessage());
            return str;
        }
    }
}
