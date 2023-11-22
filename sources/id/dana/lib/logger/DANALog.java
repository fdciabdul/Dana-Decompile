package id.dana.lib.logger;

import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import timber.log.Timber;

/* loaded from: classes2.dex */
public final class DANALog {
    private DANALog() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (Timber.BuiltInFictitiousFunctionClassFactory() > 0) {
            Timber.getAuthRequestContext(str).BuiltInFictitiousFunctionClassFactory(str2, new Object[0]);
        }
        LoggerWrapper.d(str, str2);
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (Timber.BuiltInFictitiousFunctionClassFactory() > 0) {
            Timber.getAuthRequestContext(str).getAuthRequestContext(str2, new Object[0]);
        }
        LoggerWrapper.w(str, str2);
    }

    public static void MyBillsEntityDataFactory(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (Timber.BuiltInFictitiousFunctionClassFactory() > 0) {
            Timber.getAuthRequestContext(str).BuiltInFictitiousFunctionClassFactory(th, str2, new Object[0]);
        }
        LoggerWrapper.w(str, str2, th);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Timber.BuiltInFictitiousFunctionClassFactory() > 0) {
            Timber.getAuthRequestContext(str).getAuthRequestContext(th);
        }
        LoggerWrapper.w(str, th);
    }

    public static void PlaceComponentResult(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (Timber.BuiltInFictitiousFunctionClassFactory() > 0) {
            Timber.getAuthRequestContext(str).KClassImpl$Data$declaredNonStaticMembers$2(th, str2, new Object[0]);
        }
        LoggerWrapper.e(str, str2, th);
    }

    public static void PlaceComponentResult(String str, String str2) {
        LoggerWrapper.e(str, str2);
    }
}
