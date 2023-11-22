package com.xiaomi.channel.commonutils.android;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.xiaomi.push.z;

/* loaded from: classes8.dex */
public class a {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {68, -4, -93, 76, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int MyBillsEntityDataFactory = 237;
    private static InterfaceC0156a PlaceComponentResult;

    /* renamed from: com.xiaomi.channel.commonutils.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0156a {
        boolean MyBillsEntityDataFactory();

        boolean getAuthRequestContext();
    }

    /* loaded from: classes8.dex */
    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a  reason: collision with other field name */
        private final int f74a;

        b(int i) {
            this.f74a = i;
        }

        public final int a() {
            return this.f74a;
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static int MyBillsEntityDataFactory(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return 0;
                }
                return applicationInfo.metaData.getInt("SupportForPushVersionCode");
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return 0;
    }

    public static Drawable MyBillsEntityDataFactory(Context context, String str) {
        ApplicationInfo NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(context, str);
        Drawable drawable = null;
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            try {
                drawable = NetworkUserEntityData$$ExternalSyntheticLambda0.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = NetworkUserEntityData$$ExternalSyntheticLambda0.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("get app icon drawable failed, ");
                sb.append(e);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            }
        }
        return drawable == null ? new ColorDrawable(0) : drawable;
    }

    private static ApplicationInfo NetworkUserEntityData$$ExternalSyntheticLambda0(Context context, String str) {
        if (!str.equals(context.getPackageName())) {
            try {
                return context.getPackageManager().getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("not found app info ");
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                return null;
            }
        }
        try {
            byte b2 = (byte) (MyBillsEntityDataFactory & 3);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[41];
            Object[] objArr = new Object[1];
            a(b2, b3, (byte) (b3 + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[41];
            Object[] objArr2 = new Object[1];
            a(b4, (byte) (b4 + 1), KClassImpl$Data$declaredNonStaticMembers$2[41], objArr2);
            return (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int PlaceComponentResult(Context context, String str) {
        ApplicationInfo NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(context, str);
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0.icon;
            return i == 0 ? NetworkUserEntityData$$ExternalSyntheticLambda0.logo : i;
        }
        return 0;
    }

    private static b PlaceComponentResult(Context context, ApplicationInfo applicationInfo) {
        Boolean bool;
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return b.UNKNOWN;
        }
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object authRequestContext = i >= 29 ? z.getAuthRequestContext(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                bool = authRequestContext != null ? (Boolean) z.MyBillsEntityDataFactory(authRequestContext, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid)) : null;
            }
            if (bool != null) {
                return bool.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("are notifications enabled error ");
            sb.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
        return b.UNKNOWN;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 6
            int r8 = 103 - r8
            int r7 = r7 * 22
            int r7 = r7 + 4
            byte[] r0 = com.xiaomi.channel.commonutils.android.a.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 * 5
            int r6 = r6 + 18
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r8 = r8 + 1
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-8)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.a.a(byte, short, int, java.lang.Object[]):void");
    }

    public static b getAuthRequestContext(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        b PlaceComponentResult2;
        if (context == null || TextUtils.isEmpty(str)) {
            return b.UNKNOWN;
        }
        try {
            if (str.equals(context.getPackageName())) {
                try {
                    byte b2 = (byte) (MyBillsEntityDataFactory & 3);
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[41];
                    Object[] objArr = new Object[1];
                    a(b2, b3, (byte) (b3 + 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[41];
                    Object[] objArr2 = new Object[1];
                    a(b4, (byte) (b4 + 1), KClassImpl$Data$declaredNonStaticMembers$2[41], objArr2);
                    applicationInfo = (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } else {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            }
            PlaceComponentResult2 = PlaceComponentResult(context, applicationInfo);
        } catch (Throwable th2) {
            StringBuilder sb = new StringBuilder();
            sb.append("get app op error ");
            sb.append(th2);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
        if (PlaceComponentResult2 != b.UNKNOWN) {
            return PlaceComponentResult2;
        }
        Integer num = (Integer) z.getAuthRequestContext(AppOpsManager.class, "OP_POST_NOTIFICATION");
        if (num == null) {
            return b.UNKNOWN;
        }
        Integer num2 = (Integer) z.getAuthRequestContext((AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
        int i = (Integer) z.getAuthRequestContext(AppOpsManager.class, "MODE_ALLOWED");
        int i2 = (Integer) z.getAuthRequestContext(AppOpsManager.class, "MODE_IGNORED");
        com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(String.format("get app mode %s|%s|%s", num2, i, i2));
        if (i == null) {
            i = 0;
        }
        if (i2 == null) {
            i2 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i2) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(i) ? b.ALLOWED : b.NOT_ALLOWED;
        }
        return b.UNKNOWN;
    }

    public static boolean getAuthRequestContext() {
        InterfaceC0156a interfaceC0156a = PlaceComponentResult;
        return interfaceC0156a != null && interfaceC0156a.MyBillsEntityDataFactory();
    }

    public static boolean getAuthRequestContext(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (f.BuiltInFictitiousFunctionClassFactory()) {
            InterfaceC0156a interfaceC0156a = PlaceComponentResult;
            return interfaceC0156a != null && interfaceC0156a.getAuthRequestContext();
        }
        return context.getPackageName().equals(str);
    }

    public static boolean getErrorConfigVersion(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String moveToNextValue(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }
}
