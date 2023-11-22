package com.huawei.hms.push;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class l {
    public static final byte[] getAuthRequestContext = {109, -87, 105, -77, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int BuiltInFictitiousFunctionClassFactory = 71;

    private static int KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            byte b = getAuthRequestContext[41];
            byte b2 = (byte) (b + 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory & 1);
            byte b4 = getAuthRequestContext[41];
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).icon;
            if (i == 0) {
                int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
                HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
                if (identifier == 0) {
                    HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
                    return 17301651;
                }
                return identifier;
            }
            return i;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.huawei.hms.push.l.getAuthRequestContext
            int r7 = r7 * 22
            int r7 = 26 - r7
            int r6 = r6 * 5
            int r6 = 23 - r6
            int r8 = r8 * 6
            int r8 = 103 - r8
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r6
            r4 = r7
            r3 = 0
            goto L30
        L17:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L30:
            int r7 = r7 + 1
            int r6 = r6 + r4
            int r6 = r6 + (-8)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.l.a(int, int, int, java.lang.Object[]):void");
    }

    public static Bitmap BuiltInFictitiousFunctionClassFactory(Context context, k kVar) {
        if (context == null || kVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            } else if ("com.huawei.android.pushagent".equals(kVar.GetContactSyncConfig)) {
                return null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("get left bitmap from ");
                sb.append(kVar.GetContactSyncConfig);
                HMSLog.i("PushSelfShowLog", sb.toString());
                return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(kVar.GetContactSyncConfig)).getBitmap();
            }
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, Notification.Builder builder, k kVar) {
        if (context != null && kVar != null) {
            int i = 0;
            if (context != null && kVar != null) {
                if (!TextUtils.isEmpty(kVar.MyBillsEntityDataFactory)) {
                    String[] split = kVar.MyBillsEntityDataFactory.split("/");
                    if (split.length == 3) {
                        i = r.BuiltInFictitiousFunctionClassFactory(context, split[1], split[2]);
                    }
                }
                if (i == 0) {
                    i = r.PlaceComponentResult(context, "com.huawei.messaging.default_notification_icon");
                }
                if (i == 0) {
                    i = KClassImpl$Data$declaredNonStaticMembers$2(context);
                }
            } else {
                HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            }
            builder.setSmallIcon(i);
            return;
        }
        HMSLog.e("PushSelfShowLog", "msg is null");
    }
}
