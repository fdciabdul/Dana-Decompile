package id.dana.utils;

import android.content.Context;
import id.dana.constants.ErrorCode;
import id.dana.network.exception.NetworkException;

/* loaded from: classes2.dex */
public class ErrorUtil {
    private ErrorUtil() {
        throw new UnsupportedOperationException();
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context context) {
        return context.getString(id.dana.R.string.general_error_msg);
    }

    public static String MyBillsEntityDataFactory(Context context) {
        return context.getString(id.dana.R.string.home_error);
    }

    public static String PlaceComponentResult(Context context) {
        return context.getString(id.dana.R.string.error_number_used);
    }

    public static String getAuthRequestContext(Context context) {
        return context.getString(id.dana.R.string.challenge_error);
    }

    public static String MyBillsEntityDataFactory(Context context, Throwable th) {
        boolean z = th instanceof NetworkException;
        if (z) {
            NetworkException networkException = (NetworkException) th;
            if (ErrorCode.PHONE_NUMBER_RISK_REJECTED.equals(networkException.getErrorCode())) {
                return th.getMessage();
            }
            if (z) {
                return networkException.getMessage();
            }
            return context.getString(id.dana.R.string.general_error_msg);
        }
        return context.getString(id.dana.R.string.home_error);
    }

    public static String PlaceComponentResult(Throwable th, Context context) {
        if (th instanceof NetworkException) {
            return ((NetworkException) th).getMessage();
        }
        return context.getString(id.dana.R.string.general_error_msg);
    }

    public static String getAuthRequestContext(Throwable th, Context context) {
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            if (!"AE15001858018002".equals(networkException.getErrorCode())) {
                return networkException.getMessage();
            }
            return context.getString(id.dana.R.string.paylater_unavailable);
        }
        return context.getString(id.dana.R.string.paylater_unavailable);
    }

    public static String MyBillsEntityDataFactory(Class cls, Class cls2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error when ");
        sb.append(cls.getSimpleName());
        sb.append(" in ");
        sb.append(cls2.getSimpleName());
        sb.append(" Cause : ");
        sb.append(str);
        return sb.toString();
    }

    public static Integer getAuthRequestContext(Integer num) {
        if (num == null) {
            return 0;
        }
        return num;
    }
}
