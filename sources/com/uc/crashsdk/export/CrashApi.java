package com.uc.crashsdk.export;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.google.common.base.Ascii;
import com.uc.crashsdk.CrashLogFilesUploader;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a;
import com.uc.crashsdk.a.c;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.b;
import com.uc.crashsdk.d;
import com.uc.crashsdk.e;
import com.uc.crashsdk.f;
import com.uc.crashsdk.k;
import com.uc.crashsdk.p;
import com.uc.crashsdk.r;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class CrashApi {

    /* renamed from: a  reason: collision with root package name */
    private static CrashApi f7721a;
    private boolean b;
    private boolean c;
    private boolean e;
    public static final byte[] getAuthRequestContext = {117, -10, 119, -11, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 117;
    private boolean d = false;
    private final Object f = new Object();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = com.uc.crashsdk.export.CrashApi.getAuthRequestContext
            int r9 = r9 + 4
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            int r3 = r3 + 1
            int r9 = r9 + 1
            r4 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.export.CrashApi.g(short, byte, short, java.lang.Object[]):void");
    }

    public static CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, String str, boolean z, boolean z2, boolean z3) {
        CrashApi crashApi;
        synchronized (CrashApi.class) {
            if (f7721a == null) {
                f7721a = new CrashApi(context, customInfo, versionInfo, iCrashClient, str, z, z2, z3);
            }
            crashApi = f7721a;
        }
        return crashApi;
    }

    public static CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, String str) {
        return createInstance(context, customInfo, versionInfo, iCrashClient, str, true, true, true);
    }

    public static CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, String str) {
        return createInstance(context, customInfo, versionInfo, (ICrashClient) null, str);
    }

    public static CrashApi createInstance(Context context, String str, Bundle bundle) {
        return createInstance(context, str, bundle, (ValueCallback<Bundle>) null, (ValueCallback<Bundle>) null);
    }

    public static CrashApi createInstance(Context context, String str, Bundle bundle, ValueCallback<Bundle> valueCallback, ValueCallback<Bundle> valueCallback2) {
        createInstance(context, p.a(bundle), p.b(bundle), null, str, bundle.getBoolean("enableJavaLog", true), bundle.getBoolean("enableNaiveLog", true), bundle.getBoolean("enableUnexpLog", true));
        if (valueCallback != null) {
            d.c(valueCallback);
        }
        if (valueCallback2 != null) {
            d.a(valueCallback2);
        }
        String string = bundle.getString("soPathName");
        if (h.b(string) && f.c(string)) {
            f7721a.crashSoLoaded();
        }
        return f7721a;
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return d.c(valueCallback);
                }
                StringBuilder sb = new StringBuilder("Unknown event type: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            return d.b(valueCallback);
        }
        return d.a(valueCallback);
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        return p.b(customInfo);
    }

    public int updateCustomInfo(Bundle bundle) {
        return updateCustomInfo(p.a(bundle));
    }

    public static CrashApi getInstance() {
        return f7721a;
    }

    public void crashSoLoaded() {
        this.d = true;
        synchronized (this.f) {
            if (this.b && this.d) {
                if (!b.b) {
                    b();
                    JNIBridge.nativeInstallBreakpad();
                    b.b = true;
                    JNIBridge.nativeBreakpadInited(Build.FINGERPRINT);
                    p.d();
                } else if (p.G()) {
                    c.c("Has enabled native log!");
                }
            }
        }
        a();
        a.h();
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        p.a(versionInfo);
    }

    public void updateVersionInfo(Bundle bundle) {
        updateVersionInfo(p.b(bundle));
    }

    public void disableLog(int i) {
        synchronized (this.f) {
            b.a(i);
            if (LogType.isForJava(i) && b.f7716a) {
                f.l();
                b.f7716a = false;
            }
            if (LogType.isForNative(i)) {
                if (b.b) {
                    JNIBridge.nativeUninstallBreakpad();
                    b.b = false;
                } else {
                    this.b = false;
                }
            }
            if (LogType.isForUnexp(i)) {
                if (b.c) {
                    if (f.o()) {
                        b.c = false;
                    }
                } else {
                    this.c = false;
                }
            }
        }
    }

    public void setMainProcess() {
        b.r();
        if (b.d) {
            JNIBridge.nativeSetProcessType(b.s());
        }
        enableUnexpCrashStat();
        a.h();
        try {
            f.p();
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, true);
        }
    }

    public void enableUnexpCrashStat() {
        b.p();
        b.j();
        k.c();
        a();
        com.uc.crashsdk.a.k.b();
    }

    public boolean addStatInfo(String str, String str2) {
        if (h.a(str)) {
            throw null;
        }
        if (str.length() > 24) {
            throw new IllegalArgumentException("key is too long!");
        }
        if (str2 != null && str2.length() > 512) {
            str2 = str2.substring(0, 512);
        }
        return com.uc.crashsdk.a.k.a(str, str2);
    }

    public void setCrashLogUploadUrl(String str) {
        f.a(str, false);
    }

    public String getCrashLogUploadUrl() {
        return f.f();
    }

    public int getLastExitType() {
        return b.u();
    }

    public int reportCrashStats(boolean z) {
        if (z) {
            boolean a2 = k.a(b.c());
            com.uc.crashsdk.a.k.c();
            return a2 ? 1 : 0;
        }
        int a3 = k.a();
        com.uc.crashsdk.a.k.c();
        return a3;
    }

    public int resetCrashStats(boolean z) {
        if (z) {
            return k.b(b.c()) ? 1 : 0;
        }
        return k.b();
    }

    public void onExit() {
        b.a(false);
    }

    public void setNewInstall() {
        b.a(true);
    }

    public void setForeground(boolean z) {
        b.b(z);
    }

    public void uploadCrashLogs() {
        f.a(true);
    }

    public int registerThread(int i, String str) {
        return a.a(i, str);
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        StringBuilder sb;
        if (customLogInfo.mData == null || customLogInfo.mLogType == null) {
            throw new NullPointerException("mData or mLogType is null!");
        }
        if (customLogInfo.mLogType.indexOf("_") >= 0 || customLogInfo.mLogType.indexOf(" ") >= 0) {
            throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
        }
        if (customLogInfo.mDumpTids == null || customLogInfo.mDumpTids.size() <= 0) {
            sb = null;
        } else {
            sb = new StringBuilder();
            Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue());
                sb.append(" ");
            }
        }
        return f.a(customLogInfo.mData, customLogInfo.mLogType, customLogInfo.mAddHeader, customLogInfo.mAddFooter, customLogInfo.mAddLogcat, customLogInfo.mAddThreadsDump, customLogInfo.mUploadNow, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    public void addHeaderInfo(String str, String str2) {
        a.a(str, str2);
    }

    public int createCachedInfo(String str, int i, int i2) {
        if (i > 0) {
            if ((i2 & LZMA_Base.kMatchMaxLen) == 0) {
                return 0;
            }
            return a.a(str, i, i2);
        }
        throw new IllegalArgumentException("capacity must > 0!");
    }

    public int addCachedInfo(String str, String str2) {
        if (str == null || str2 == null) {
            throw null;
        }
        return a.b(str, str2);
    }

    public int registerInfoCallback(String str, int i) {
        if ((i & LZMA_Base.kMatchMaxLen) == 0) {
            return 0;
        }
        return a.a(str, i, (Callable<String>) null, 0L);
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((i & LZMA_Base.kMatchMaxLen) == 0) {
            return 0;
        }
        return a.a(str, i, callable, 0L);
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        if (dumpFileInfo.mCategory == null || dumpFileInfo.mFileTobeDump == null) {
            throw null;
        }
        if ((dumpFileInfo.mLogType & LZMA_Base.kMatchMaxLen) == 0) {
            return 0;
        }
        return a.a(dumpFileInfo.mCategory, dumpFileInfo.mFileTobeDump, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, dumpFileInfo.mLogType, dumpFileInfo.mDeleteAfterDump);
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    public Throwable getUncaughtException() {
        return f.m();
    }

    public boolean updateUnexpInfo() {
        return a.a(true);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:35:0x0058). Please submit an issue!!! */
    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, String str, boolean z, boolean z2, boolean z3) {
        this.b = false;
        this.c = false;
        this.e = false;
        if (customInfo == null || versionInfo == null) {
            throw null;
        }
        p.a(customInfo);
        this.b = z2;
        this.c = z3;
        try {
            f.a(str, true);
            e.a(context);
            p.a(customInfo, versionInfo);
            d.a(iCrashClient);
            f.i();
            a.f7699a = context.getPackageName();
        } catch (Throwable th) {
            a(th);
        }
        if (z) {
            try {
                if (!b.f7716a) {
                    f.k();
                    f.h();
                    b.f7716a = true;
                } else if (p.G()) {
                    c.c("Has enabled java log!");
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }
        try {
            r.a();
            com.uc.crashsdk.a.k.a();
            com.uc.crashsdk.a.f.a();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.a.a(th3, false);
        }
        try {
            if (!p.q() || this.e) {
                return;
            }
            CrashLogFilesUploader.a(context);
            this.e = true;
        } catch (Throwable th4) {
            com.uc.crashsdk.a.a.a(th4, true);
        }
    }

    private void a() {
        synchronized (this.f) {
            if (this.c && this.d && b.q()) {
                if (!b.c) {
                    if (!b.d) {
                        b();
                        p.d();
                    }
                    f.n();
                    b.c = true;
                }
            }
        }
    }

    private static void b() {
        if (b.d) {
            return;
        }
        p.b();
        JNIBridge.nativeInitNative();
        p.c();
        b.d = true;
    }

    private static void a(Throwable th) {
        f fVar = new f();
        try {
            byte b = (byte) (getAuthRequestContext[15] + 1);
            Object[] objArr = new Object[1];
            g(b, b, getAuthRequestContext[16], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-getAuthRequestContext[15]);
            Object[] objArr2 = new Object[1];
            g(b2, b2, getAuthRequestContext[15], objArr2);
            fVar.a((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null), th, true);
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }
}
