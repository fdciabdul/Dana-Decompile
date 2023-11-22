package id.dana.data.foundation.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.security.ClearCookieThrowable;
import id.dana.data.security.CookieNullThrowable;
import id.dana.data.security.CtokenNullThrowable;
import id.dana.data.security.SecureString;
import id.dana.data.security.SetCookieThrowable;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class CookieUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
    }

    private CookieUtil() {
    }

    public static List<String> BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SecureString MyBillsEntityDataFactory = MyBillsEntityDataFactory(str);
        if (MyBillsEntityDataFactory == null || TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter("Cookies for ctoken is null", "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log("Cookies for ctoken is null");
            CtokenNullThrowable ctokenNullThrowable = new CtokenNullThrowable();
            Intrinsics.checkNotNullParameter(ctokenNullThrowable, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(ctokenNullThrowable);
            return arrayList;
        }
        for (String str3 : MyBillsEntityDataFactory.toString().split(";")) {
            String[] split = str3.split("=");
            if (split.length == 2 && split[0].trim().equalsIgnoreCase(str2)) {
                arrayList.add(new SecureString(split[1].trim().toCharArray()).toString());
            }
        }
        return arrayList;
    }

    public static SecureString PlaceComponentResult() {
        return MyBillsEntityDataFactory("https://m.dana.id");
    }

    private static SecureString MyBillsEntityDataFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter("Domain is null", "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log("Domain is null");
            CookieNullThrowable cookieNullThrowable = new CookieNullThrowable();
            Intrinsics.checkNotNullParameter(cookieNullThrowable, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(cookieNullThrowable);
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie(str);
            Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            if (cookie.isEmpty()) {
                Intrinsics.checkNotNullParameter("Cookie from cookie manager is empty", "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log("Cookie from cookie manager is empty");
                CookieNullThrowable cookieNullThrowable2 = new CookieNullThrowable();
                Intrinsics.checkNotNullParameter(cookieNullThrowable2, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(cookieNullThrowable2);
            }
            SecureString secureString = new SecureString(cookieManager.getCookie(str).toCharArray());
            Crashlytics BuiltInFictitiousFunctionClassFactory3 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            if (secureString.length() == 0) {
                Intrinsics.checkNotNullParameter("Cookie from secure string is empty", "");
                BuiltInFictitiousFunctionClassFactory3.getAuthRequestContext.log("Cookie from secure string is empty");
                CookieNullThrowable cookieNullThrowable3 = new CookieNullThrowable();
                Intrinsics.checkNotNullParameter(cookieNullThrowable3, "");
                BuiltInFictitiousFunctionClassFactory3.getAuthRequestContext.recordException(cookieNullThrowable3);
            }
            return secureString;
        } catch (Exception | UnsatisfiedLinkError e) {
            Crashlytics BuiltInFictitiousFunctionClassFactory4 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter("Get Cookie Error", "");
            BuiltInFictitiousFunctionClassFactory4.getAuthRequestContext.log("Get Cookie Error");
            CookieNullThrowable cookieNullThrowable4 = new CookieNullThrowable(new Throwable(e));
            Intrinsics.checkNotNullParameter(cookieNullThrowable4, "");
            BuiltInFictitiousFunctionClassFactory4.getAuthRequestContext.recordException(cookieNullThrowable4);
            DanaLog.scheduleImpl("CookieUtil", e.getMessage());
            return null;
        }
    }

    public static SecureString getAuthRequestContext() {
        SecureString MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        String str = "";
        if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            if (MyBillsEntityDataFactory.toString().contains("ctoken=")) {
                str = MyBillsEntityDataFactory.toString().replace("ctoken=", "");
            } else {
                str = MyBillsEntityDataFactory.toString();
            }
        }
        return new SecureString(str.toCharArray());
    }

    public static SecureString MyBillsEntityDataFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2("https://m.dana.id", "ctoken");
    }

    private static SecureString KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        SecureString MyBillsEntityDataFactory = MyBillsEntityDataFactory(str);
        if (MyBillsEntityDataFactory == null || TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter("Cookies for ctoken is null", "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log("Cookies for ctoken is null");
            CtokenNullThrowable ctokenNullThrowable = new CtokenNullThrowable();
            Intrinsics.checkNotNullParameter(ctokenNullThrowable, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(ctokenNullThrowable);
            return new SecureString("".toCharArray());
        }
        for (String str3 : MyBillsEntityDataFactory.toString().split(";")) {
            String[] split = str3.split("=");
            if (split.length == 2 && split[0].trim().equalsIgnoreCase(str2)) {
                return new SecureString(str3.trim().toCharArray());
            }
        }
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("Cookies after split ; is empty", "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log("Cookies after split ; is empty");
        CtokenNullThrowable ctokenNullThrowable2 = new CtokenNullThrowable();
        Intrinsics.checkNotNullParameter(ctokenNullThrowable2, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(ctokenNullThrowable2);
        return new SecureString("".toCharArray());
    }

    public static String PlaceComponentResult(String str) {
        return MyBillsEntityDataFactory(str, KClassImpl$Data$declaredNonStaticMembers$2(str).toString());
    }

    public static String MyBillsEntityDataFactory(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("replaceOrAddParameter\t url:");
        sb.append(str);
        sb.append("\t ctokenValue: ");
        sb.append(str2);
        DanaLog.MyBillsEntityDataFactory("CookieUtil", sb.toString());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.contains(str2)) {
            return str;
        }
        int indexOf = str.indexOf("ctoken=");
        if (indexOf != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str.substring(0, indexOf));
            sb2.append(str2);
            int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf);
            if (indexOf2 != -1) {
                sb2.append(str.substring(indexOf2));
            }
            return sb2.toString();
        } else if (str.contains("?")) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(ContainerUtils.FIELD_DELIMITER);
            sb3.append(str2);
            return sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("?");
            sb4.append(str2);
            return sb4.toString();
        }
    }

    public static SecureString KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        SecureString KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, "ctoken");
        StringBuilder sb = new StringBuilder();
        sb.append("getCtokenFromCookie :");
        sb.append((Object) KClassImpl$Data$declaredNonStaticMembers$2);
        DanaLog.MyBillsEntityDataFactory("CookieUtil", sb.toString());
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static boolean getAuthRequestContext(String str) {
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str);
        String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory("https://m.dana.id");
        return (BuiltInFictitiousFunctionClassFactory == null || TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory) || BuiltInFictitiousFunctionClassFactory2 == null || !BuiltInFictitiousFunctionClassFactory.endsWith(BuiltInFictitiousFunctionClassFactory2)) ? false : true;
    }

    private static String BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2() {
        SecureString MyBillsEntityDataFactory;
        if (!lookAheadTest() || (MyBillsEntityDataFactory = MyBillsEntityDataFactory("https://m.dana.id")) == null) {
            return "";
        }
        String str = "";
        for (String str2 : MyBillsEntityDataFactory.toString().split(";")) {
            if (!TextUtils.isEmpty(str2) && str2.contains("userId")) {
                str = str2.trim().replace("userId=", "");
            }
        }
        return str;
    }

    private static boolean lookAheadTest() {
        SecureString MyBillsEntityDataFactory = MyBillsEntityDataFactory("https://m.dana.id");
        return (MyBillsEntityDataFactory == null || TextUtils.isEmpty(MyBillsEntityDataFactory) || !MyBillsEntityDataFactory.toString().contains("userId")) ? false : true;
    }

    public static void PlaceComponentResult(Context context) {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            new Handler(context.getMainLooper()).post(new Runnable() { // from class: id.dana.data.foundation.utils.CookieUtil$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CookieUtil.MyBillsEntityDataFactory(new ValueCallback() { // from class: id.dana.data.foundation.utils.CookieUtil$$ExternalSyntheticLambda1
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) {
                            Boolean bool = (Boolean) obj;
                            CookieUtil.BuiltInFictitiousFunctionClassFactory();
                        }
                    });
                }
            });
            return;
        }
        CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
        createInstance.startSync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        cookieManager.removeSessionCookie();
        createInstance.stopSync();
        createInstance.sync();
    }

    public static void MyBillsEntityDataFactory(Context context, ValueCallback<Boolean> valueCallback) {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            MyBillsEntityDataFactory(valueCallback);
            return;
        }
        CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
        createInstance.startSync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        cookieManager.removeSessionCookie();
        createInstance.stopSync();
        createInstance.sync();
        valueCallback.onReceiveValue(Boolean.TRUE);
    }

    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return Build.VERSION.SDK_INT >= 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MyBillsEntityDataFactory(ValueCallback<Boolean> valueCallback) {
        try {
            CookieManager.getInstance().removeAllCookies(valueCallback);
            CookieManager.getInstance().flush();
        } catch (AndroidRuntimeException e) {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            ClearCookieThrowable clearCookieThrowable = new ClearCookieThrowable(e);
            Intrinsics.checkNotNullParameter(clearCookieThrowable, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(clearCookieThrowable);
            valueCallback.onReceiveValue(Boolean.FALSE);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        SecureString MyBillsEntityDataFactory = MyBillsEntityDataFactory("https://m.dana.id");
        if (TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory("");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory((String) null);
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory) || MyBillsEntityDataFactory == null) {
            return;
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory("CookieUtil", "Cookie is not empty");
        PlaceComponentResult(context);
        MyBillsEntityDataFactory.clear();
    }

    public static void getAuthRequestContext(String str, String str2) {
        try {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            if (str2.isEmpty()) {
                if (str.isEmpty()) {
                    Intrinsics.checkNotNullParameter("url is empty", "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log("url is empty");
                }
                Intrinsics.checkNotNullParameter("Cookie is empty", "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log("Cookie is empty");
                CookieNullThrowable cookieNullThrowable = new CookieNullThrowable();
                Intrinsics.checkNotNullParameter(cookieNullThrowable, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(cookieNullThrowable);
            }
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setCookie(str, str2);
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
        } catch (Throwable th) {
            Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            SetCookieThrowable setCookieThrowable = new SetCookieThrowable(th);
            Intrinsics.checkNotNullParameter(setCookieThrowable, "");
            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(setCookieThrowable);
        }
    }
}
