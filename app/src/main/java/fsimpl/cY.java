package fsimpl;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.ariver.kernel.RVStartParams;

/* loaded from: classes.dex */
public class cY {

    /* renamed from: a  reason: collision with root package name */
    public static String f7905a = "FS_STARTUP";
    public static String b = "FS_PREFS";

    private static SharedPreferences a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getBasePackageName());
        sb.append(".");
        sb.append(str);
        return context.getSharedPreferences(sb.toString(), 0);
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            return a2.getString(a(str2), null);
        }
        return null;
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(RVStartParams.KEY_FULLSCREEN_SHORT);
        sb.append(str);
        return sb.toString();
    }

    public static boolean a(Context context, String str, String str2, Boolean bool) {
        if (bool == null) {
            return d(context, str, str2);
        }
        SharedPreferences.Editor b2 = b(context, str);
        if (b2 != null) {
            b2.putBoolean(a(str2), bool.booleanValue());
            b2.commit();
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2, Long l) {
        if (l == null) {
            return d(context, str, str2);
        }
        SharedPreferences.Editor b2 = b(context, str);
        if (b2 != null) {
            b2.putLong(a(str2), l.longValue());
            b2.commit();
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        if (str3 == null || str3.isEmpty()) {
            return d(context, str, str2);
        }
        SharedPreferences.Editor b2 = b(context, str);
        if (b2 != null) {
            b2.putString(a(str2), str3);
            b2.commit();
            return true;
        }
        return false;
    }

    private static SharedPreferences.Editor b(Context context, String str) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            return a2.edit();
        }
        return null;
    }

    public static Boolean b(Context context, String str, String str2) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            String a3 = a(str2);
            if (a2.contains(a3)) {
                return Boolean.valueOf(a2.getBoolean(a3, false));
            }
            return null;
        }
        return null;
    }

    public static Long c(Context context, String str, String str2) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            String a3 = a(str2);
            if (a2.contains(a3)) {
                return Long.valueOf(a2.getLong(a3, 0L));
            }
            return null;
        }
        return null;
    }

    public static boolean d(Context context, String str, String str2) {
        SharedPreferences.Editor b2 = b(context, str);
        if (b2 != null) {
            b2.remove(a(str2));
            b2.commit();
            return true;
        }
        return false;
    }
}
