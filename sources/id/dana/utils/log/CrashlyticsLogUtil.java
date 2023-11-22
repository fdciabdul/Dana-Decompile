package id.dana.utils.log;

import android.text.TextUtils;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class CrashlyticsLogUtil {
    private static String BuiltInFictitiousFunctionClassFactory = "";

    private CrashlyticsLogUtil() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj);
        DanaLog.scheduleImpl(str, str2);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2, Throwable th) {
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("bizType", "");
        Intrinsics.checkNotNullParameter(str, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.setCustomKey("bizType", str);
        Intrinsics.checkNotNullParameter("exceptionType", "");
        Intrinsics.checkNotNullParameter(str2, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.setCustomKey("exceptionType", str2);
        Intrinsics.checkNotNullParameter(th, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(th);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        BuiltInFictitiousFunctionClassFactory = str;
    }

    public static void PlaceComponentResult(String str, String str2, Throwable th) {
        String str3;
        String userId = UserInfoManager.instance().getUserId();
        if (!TextUtils.isEmpty(userId) && userId.length() > 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("****");
            sb.append(userId.substring(userId.length() - 8, userId.length()));
            userId = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(", [userId]: ");
        sb2.append(userId);
        sb2.append(", [utdid]: ");
        sb2.append(BuiltInFictitiousFunctionClassFactory);
        String obj = sb2.toString();
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(obj);
        String obj2 = sb3.toString();
        Intrinsics.checkNotNullParameter(obj2, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj2);
        Intrinsics.checkNotNullParameter(th, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(th);
        boolean equals = "DanaLogin".equals(str);
        String str4 = DanaLogConstants.TAG.SENDMONEY_NAMECHECK_TAG;
        if (equals) {
            str4 = "login";
            str3 = DanaLogConstants.ExceptionType.LOGIN_EXCEPTION;
        } else if (DanaLogConstants.TAG.REGISTER_TAG.equals(str)) {
            str4 = DanaLogConstants.BizType.REGISTER;
            str3 = DanaLogConstants.ExceptionType.REGISTER_EXCEPTION;
        } else if (DanaLogConstants.TAG.SENDMONEY_NAMECHECK_TAG.equals(str)) {
            str3 = DanaLogConstants.ExceptionType.NAMECHECK_EXCEPTION;
        } else {
            str4 = DanaLogConstants.BizType.UNKNOWN_BIZTYPE;
            str3 = DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION;
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory(str4, str3, obj);
    }
}
