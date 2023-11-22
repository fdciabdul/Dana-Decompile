package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes3.dex */
public class ProcessUtils {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {105, Ascii.NAK, -43, 101, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 17;
    private static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("ProcessUtils");

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 6
            int r7 = 103 - r7
            int r6 = r6 * 5
            int r6 = 23 - r6
            int r8 = r8 * 22
            int r8 = 25 - r8
            byte[] r0 = androidx.work.impl.utils.ProcessUtils.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r8 = r8 + 1
            r4 = r0[r8]
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
            int r8 = r8 + r6
            int r6 = r8 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.ProcessUtils.a(int, short, short, java.lang.Object[]):void");
    }

    private ProcessUtils() {
    }

    public static boolean PlaceComponentResult(Context context, Configuration configuration) {
        String authRequestContext = getAuthRequestContext(context);
        if (!TextUtils.isEmpty(configuration.PlaceComponentResult)) {
            return TextUtils.equals(authRequestContext, configuration.PlaceComponentResult);
        }
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[41];
            byte b2 = (byte) (b + 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 7);
            byte b4 = BuiltInFictitiousFunctionClassFactory[41];
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            return TextUtils.equals(authRequestContext, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).processName);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static String getAuthRequestContext(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object invoke;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Class<?> cls = Class.forName(com.alibaba.ariver.kernel.common.utils.ProcessUtils.ACTIVITY_THREAD, false, ProcessUtils.class.getClassLoader());
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = cls.getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                invoke = declaredMethod.invoke(null, new Object[0]);
            } else {
                Method declaredMethod2 = cls.getDeclaredMethod(com.alibaba.ariver.kernel.common.utils.ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod(com.alibaba.ariver.kernel.common.utils.ProcessUtils.GET_PROCESS_NAME, new Class[0]);
                declaredMethod3.setAccessible(true);
                invoke = declaredMethod3.invoke(declaredMethod2.invoke(null, new Object[0]), new Object[0]);
            }
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th) {
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, "Unable to check ActivityThread for processName", th);
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
