package com.huawei.secure.android.common.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes8.dex */
public class UriUtil {
    private static String BuiltInFictitiousFunctionClassFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.KClassImpl$Data$declaredNonStaticMembers$2("UriUtil", HummerZCodeConstant.URL_ERROR_MSG);
            return str;
        }
        try {
            if (!URLUtil.isNetworkUrl(str)) {
                LogsUtil.MyBillsEntityDataFactory("UriUtil", "url don't starts with http or https");
                return "";
            }
            return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (MalformedURLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getHostByURI error  MalformedURLException : ");
            sb.append(e.getMessage());
            LogsUtil.MyBillsEntityDataFactory("UriUtil", sb.toString());
            return "";
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str);
            if (TextUtils.isEmpty(str2)) {
                LogsUtil.KClassImpl$Data$declaredNonStaticMembers$2("UriUtil", "whiteListUrl is null");
                str2 = null;
            } else if (URLUtil.isNetworkUrl(str2)) {
                str2 = BuiltInFictitiousFunctionClassFactory(str2);
            }
            return TextUtils.equals(BuiltInFictitiousFunctionClassFactory, str2);
        }
        InstrumentInjector.log_e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (KClassImpl$Data$declaredNonStaticMembers$2(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.MyBillsEntityDataFactory("UriUtil", "whitelist is null");
        return false;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        String str3;
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str);
        if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory) || TextUtils.isEmpty(str2)) {
            LogsUtil.MyBillsEntityDataFactory("UriUtil", "url or whitelist is null");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            LogsUtil.KClassImpl$Data$declaredNonStaticMembers$2("UriUtil", "whiteListUrl is null");
            str3 = null;
        } else {
            boolean isNetworkUrl = URLUtil.isNetworkUrl(str2);
            str3 = str2;
            if (isNetworkUrl) {
                str3 = BuiltInFictitiousFunctionClassFactory(str2);
            }
        }
        if (TextUtils.isEmpty(str3)) {
            InstrumentInjector.log_e("UriUtil", "whitelist host is null");
            return false;
        } else if (str3.equals(BuiltInFictitiousFunctionClassFactory)) {
            return true;
        } else {
            if (BuiltInFictitiousFunctionClassFactory.endsWith(str3)) {
                try {
                    String substring = BuiltInFictitiousFunctionClassFactory.substring(0, BuiltInFictitiousFunctionClassFactory.length() - str3.length());
                    if (substring.endsWith(".")) {
                        return substring.matches("^[A-Za-z0-9.-]+$");
                    }
                    return false;
                } catch (IndexOutOfBoundsException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("IndexOutOfBoundsException");
                    sb.append(e.getMessage());
                    LogsUtil.MyBillsEntityDataFactory("UriUtil", sb.toString());
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Exception : ");
                    sb2.append(e2.getMessage());
                    LogsUtil.MyBillsEntityDataFactory("UriUtil", sb2.toString());
                    return false;
                }
            }
            return false;
        }
    }

    private static boolean PlaceComponentResult(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.contains("..") && !str.contains(AUScreenAdaptTool.PREFIX_ID)) {
                if (!str2.equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append("?");
                    if (!str.startsWith(sb.toString())) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append("#");
                        if (!str.startsWith(sb2.toString())) {
                            if (str2.endsWith("/")) {
                                if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                    return false;
                                }
                                return str.startsWith(str2);
                            }
                            return false;
                        }
                    }
                }
                return true;
            }
            InstrumentInjector.log_e("UriUtil", "url contains unsafe char");
        }
        return false;
    }

    public static boolean PlaceComponentResult(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (PlaceComponentResult(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.MyBillsEntityDataFactory("UriUtil", "whitelist is null");
        return false;
    }

    public static boolean getAuthRequestContext(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (BuiltInFictitiousFunctionClassFactory(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.MyBillsEntityDataFactory("UriUtil", "whitelist is null");
        return false;
    }
}
