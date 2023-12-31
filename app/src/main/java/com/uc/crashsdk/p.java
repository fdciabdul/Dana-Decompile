package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f7732a = true;
    private static CustomInfo b;
    private static VersionInfo c;
    private static String e;
    private static String f;
    private static String g;
    private static Object d = new Object();
    private static Object h = new Object();

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        b = customInfo2;
        c(customInfo2);
        c = new VersionInfo(versionInfo);
        try {
            b.n();
            b.m();
            if (b.mBackupLogs) {
                File file = new File(P());
                if (file.exists()) {
                    return;
                }
                file.mkdirs();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
    }

    public static void a(CustomInfo customInfo) {
        boolean z = f7732a;
        if (!z && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!z && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static boolean a() {
        return b != null;
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (d) {
            c = new VersionInfo(versionInfo);
            f.a();
            if (b.d) {
                JNIBridge.nativeSetVersionInfo(c.mVersion, c.mSubVersion, c.mBuildSeq, "170706161743");
                JNIBridge.nativeUpdateCrashLogNames();
            }
        }
    }

    private static void a(String str) {
        String a2 = f.a(str);
        JNIBridge.nativeSyncInfo("mLogTypeSuffix", a2, 0L, 0L);
        f.b(a2);
    }

    public static void b() {
        JNIBridge.nativeSetFolderNames(e.f7720a, b.mTagFilesFolderName, b.mCrashLogsFolderName, P());
        JNIBridge.nativeSetProcessNames(f.d(), b.a());
        JNIBridge.nativeSetVersionInfo(c.mVersion, c.mSubVersion, c.mBuildSeq, "170706161743");
        JNIBridge.nativeSetMobileInfo(Build.MODEL, Build.VERSION.RELEASE, f.j());
        JNIBridge.nativeSetLogStrategy(b.mCallNativeDefaultHandler, b.mDumpUserSolibBuildId, b.mReservedNativeMemoryBytes);
        Q();
    }

    private static void Q() {
        JNIBridge.nativeSetCrashLogFileNames(b.mNativeCrashLogFileName, b.mUnexpCrashLogFileName, b.mCrashLogPrefix);
    }

    public static void c() {
        R();
        S();
        T();
        a(b.mLogTypeSuffix);
    }

    private static void R() {
        JNIBridge.nativeSetCrashCustoms(G(), b.mBackupLogs, b.mCrashRestartInterval, b.mMaxCrashLogFilesCount, b.mMaxNativeLogcatLineCount, b.mMaxUnexpLogcatLineCount, b.mOverrideLibcMalloc, b.mModifyAbortCode, b.mUnexpOnlyKnownReason, b.mIsUsedByUCM, Build.VERSION.SDK_INT, b.mOmitNativeCrash);
    }

    private static void S() {
        JNIBridge.nativeUpdateSignals(b.mDisableSignals, b.mDisableBackgroundSignals, 0);
    }

    private static void T() {
        JNIBridge.nativeSetZip(b.mZipLog, b.mZippedLogExtension, b.mLogMaxBytesLimit);
    }

    public static void d() {
        W();
        if (f.e()) {
            JNIBridge.nativeSetCrashLogFilesUploaded();
        }
        JNIBridge.nativeReserveFileHandle(b.mReservedNativeFileHandleCount, b.mFdDumpMinLimit);
        JNIBridge.nativeSetForeground(b.o());
        JNIBridge.nativeSetProcessType(b.s());
        a.b();
        a.d();
        a.e();
        a.f();
        JNIBridge.nativeSetPackageInfo(a.f7699a, "", "");
        U();
        JNIBridge.nativeSyncInfo("aver", a.a(), 0L, 0L);
        V();
        b.v();
    }

    private static void U() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("thdump", null, b.mThreadsDumpMinLimit, 0L);
        }
    }

    public static String e() {
        return b.mCrashLogPrefix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f() {
        return com.uc.crashsdk.a.h.b(b.mJavaCrashLogFileName) || com.uc.crashsdk.a.h.b(b.mNativeCrashLogFileName) || com.uc.crashsdk.a.h.b(b.mUnexpCrashLogFileName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return b.mJavaCrashLogFileName;
    }

    public static int h() {
        return b.mCrashRestartInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return b.mCallJavaDefaultHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return b.mDumpHprofDataForJavaOOM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        return b.mRenameFileToDefaultName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l() {
        return b.mMaxCrashLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m() {
        return b.mMaxCustomLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n() {
        return b.mMaxJavaLogcatLineCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o() {
        return b.mUnexpDelayMillSeconds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p() {
        return b.mBackupLogs;
    }

    public static boolean q() {
        return b.mUploadUcebuCrashLog;
    }

    public static boolean r() {
        return b.mSyncUploadSetupCrashLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s() {
        return b.mOmitJavaCrash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        return b.mAutoDeleteOldVersionStats;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return b.mZipLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String v() {
        return b.mZippedLogExtension;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w() {
        return b.mLogMaxBytesLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x() {
        return b.mLogMaxUploadBytesLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long y() {
        return b.mMaxUploadBytesPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z() {
        return b.mMaxUploadCrashLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A() {
        return b.mMaxUploadCustomLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B() {
        return b.mMaxCustomLogCountPerTypePerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C() {
        return b.mUnexpInfoUpdateInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D() {
        return b.mReservedJavaFileHandleCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E() {
        return b.mFdDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F() {
        return b.mThreadsDumpMinLimit;
    }

    public static boolean G() {
        CustomInfo customInfo = b;
        return customInfo == null || customInfo.mDebugCrashSDK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String H() {
        return b.mLogTypeSuffix;
    }

    public static boolean I() {
        return b.mEnableStatReport;
    }

    public static boolean J() {
        return b.mIsInternational;
    }

    public static String K() {
        return c.mVersion;
    }

    public static String L() {
        return c.mSubVersion;
    }

    public static String M() {
        return c.mBuildSeq;
    }

    public static String N() {
        if (e == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.f7720a);
            sb.append(File.separatorChar);
            sb.append(b.mTagFilesFolderName);
            sb.append(File.separatorChar);
            e = sb.toString();
        }
        return e;
    }

    public static String O() {
        if (f == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.f7720a);
            sb.append(File.separatorChar);
            sb.append(b.mCrashLogsFolderName);
            sb.append(File.separatorChar);
            f = sb.toString();
        }
        return f;
    }

    public static String P() {
        String str;
        if (g == null) {
            if (!com.uc.crashsdk.a.h.a(b.mLogsBackupPathName)) {
                String trim = b.mLogsBackupPathName.trim();
                if (!trim.endsWith(File.separator)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(trim);
                    sb.append(File.separator);
                    trim = sb.toString();
                }
                g = trim;
            } else {
                try {
                    str = Environment.getExternalStorageDirectory().getPath();
                } catch (Throwable th) {
                    com.uc.crashsdk.a.a.a(th, false);
                    str = "/sdcard";
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(File.separatorChar);
                sb2.append(b.mCrashLogsFolderName);
                sb2.append(File.separatorChar);
                g = sb2.toString();
            }
        }
        return g;
    }

    public static CustomInfo a(Bundle bundle) {
        CustomInfo customInfo;
        CustomInfo customInfo2 = b;
        if (customInfo2 == null) {
            customInfo = new CustomInfo();
        } else {
            customInfo = new CustomInfo(customInfo2);
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.a.a(e2, false);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo b(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = c;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.h.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.h.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildSeq");
        if (!com.uc.crashsdk.a.h.a(string3)) {
            versionInfo.mBuildSeq = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.h.a(string4)) {
            a.b = string4;
            V();
        }
        return versionInfo;
    }

    private static void V() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("crver", a.b, 0L, 1L);
        }
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static int b(CustomInfo customInfo) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (h) {
            i = 0;
            if (customInfo != null) {
                c(customInfo);
                if (b == null) {
                    b = new CustomInfo();
                }
                CustomInfo customInfo2 = b;
                if (a(customInfo.mCrashLogPrefix, customInfo2.mCrashLogPrefix)) {
                    i2 = 0;
                    z = false;
                } else {
                    customInfo2.mCrashLogPrefix = customInfo.mCrashLogPrefix;
                    i2 = 1;
                    z = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i2++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    customInfo2.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
                    i2++;
                    z = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    customInfo2.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
                    i2++;
                    z = true;
                }
                if (z) {
                    f.a();
                    if (b.d) {
                        Q();
                        JNIBridge.nativeUpdateCrashLogNames();
                    }
                }
                if (customInfo2.mDebugCrashSDK != customInfo.mDebugCrashSDK) {
                    customInfo2.mDebugCrashSDK = customInfo.mDebugCrashSDK;
                    i2++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (customInfo2.mBackupLogs != customInfo.mBackupLogs) {
                    customInfo2.mBackupLogs = customInfo.mBackupLogs;
                    i2++;
                    z2 = true;
                }
                if (customInfo2.mOmitNativeCrash != customInfo.mOmitNativeCrash) {
                    customInfo2.mOmitNativeCrash = customInfo.mOmitNativeCrash;
                    i2++;
                    z2 = true;
                }
                if (customInfo2.mCrashRestartInterval != customInfo.mCrashRestartInterval) {
                    customInfo2.mCrashRestartInterval = customInfo.mCrashRestartInterval;
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        r.a();
                    }
                    i2++;
                    z2 = true;
                }
                if (customInfo2.mMaxCrashLogFilesCount != customInfo.mMaxCrashLogFilesCount) {
                    customInfo2.mMaxCrashLogFilesCount = customInfo.mMaxCrashLogFilesCount;
                    i2++;
                    z2 = true;
                }
                if (customInfo2.mMaxNativeLogcatLineCount != customInfo.mMaxNativeLogcatLineCount) {
                    customInfo2.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
                    i2++;
                    z2 = true;
                }
                if (customInfo2.mMaxJavaLogcatLineCount != customInfo.mMaxJavaLogcatLineCount) {
                    customInfo2.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
                    i2++;
                }
                if (customInfo2.mMaxUnexpLogcatLineCount != customInfo.mMaxUnexpLogcatLineCount) {
                    customInfo2.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
                    i2++;
                    z2 = true;
                }
                if (customInfo2.mUnexpOnlyKnownReason != customInfo.mUnexpOnlyKnownReason) {
                    customInfo2.mUnexpOnlyKnownReason = customInfo.mUnexpOnlyKnownReason;
                    i2++;
                    z2 = true;
                }
                if (customInfo2.mIsUsedByUCM != customInfo.mIsUsedByUCM) {
                    customInfo2.mIsUsedByUCM = customInfo.mIsUsedByUCM;
                    i2++;
                    z2 = true;
                }
                if (z2 && b.d) {
                    R();
                }
                if (customInfo2.mZipLog != customInfo.mZipLog) {
                    customInfo2.mZipLog = customInfo.mZipLog;
                    i2++;
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i2++;
                    z3 = true;
                }
                if (customInfo2.mLogMaxBytesLimit != customInfo.mLogMaxBytesLimit) {
                    customInfo2.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
                    i2++;
                    z3 = true;
                }
                if (z3 && b.d) {
                    T();
                }
                if (customInfo2.mSyncUploadSetupCrashLogs != customInfo.mSyncUploadSetupCrashLogs) {
                    customInfo2.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
                    i2++;
                }
                if (customInfo2.mMaxCustomLogFilesCount != customInfo.mMaxCustomLogFilesCount) {
                    customInfo2.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
                    i2++;
                }
                if (customInfo2.mOmitJavaCrash != customInfo.mOmitJavaCrash) {
                    customInfo2.mOmitJavaCrash = customInfo.mOmitJavaCrash;
                    i2++;
                }
                if (customInfo2.mLogMaxUploadBytesLimit != customInfo.mLogMaxUploadBytesLimit) {
                    customInfo2.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
                    i2++;
                }
                if (customInfo2.mMaxUploadBytesPerDay != customInfo.mMaxUploadBytesPerDay) {
                    customInfo2.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
                    i2++;
                }
                if (customInfo2.mMaxUploadCrashLogCountPerDay != customInfo.mMaxUploadCrashLogCountPerDay) {
                    customInfo2.mMaxUploadCrashLogCountPerDay = customInfo.mMaxUploadCrashLogCountPerDay;
                    i2++;
                }
                if (customInfo2.mMaxUploadCustomLogCountPerDay != customInfo.mMaxUploadCustomLogCountPerDay) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
                    i2++;
                }
                if (customInfo2.mMaxCustomLogCountPerTypePerDay != customInfo.mMaxCustomLogCountPerTypePerDay) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
                    i2++;
                }
                if (customInfo2.mCallJavaDefaultHandler != customInfo.mCallJavaDefaultHandler) {
                    customInfo2.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
                    i2++;
                }
                if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler || customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                    customInfo2.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
                    customInfo2.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
                    if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler) {
                        i2++;
                    }
                    if (customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                        i2++;
                    }
                    if (b.d) {
                        JNIBridge.nativeSetLogStrategy(b.mCallNativeDefaultHandler, b.mDumpUserSolibBuildId, b.mReservedNativeMemoryBytes);
                    }
                    i2++;
                }
                if (customInfo2.mDumpHprofDataForJavaOOM != customInfo.mDumpHprofDataForJavaOOM) {
                    customInfo2.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
                    i2++;
                }
                if (customInfo2.mRenameFileToDefaultName != customInfo.mRenameFileToDefaultName) {
                    customInfo2.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
                    i2++;
                }
                if (customInfo2.mAutoDeleteOldVersionStats != customInfo.mAutoDeleteOldVersionStats) {
                    customInfo2.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
                    i2++;
                }
                if (customInfo2.mFdDumpMinLimit != customInfo.mFdDumpMinLimit) {
                    customInfo2.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
                    if (b.d) {
                        JNIBridge.nativeReserveFileHandle(0, b.mFdDumpMinLimit);
                    }
                    i2++;
                }
                if (customInfo2.mThreadsDumpMinLimit != customInfo.mThreadsDumpMinLimit) {
                    customInfo2.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
                    U();
                }
                if (customInfo2.mUnexpInfoUpdateInterval != customInfo.mUnexpInfoUpdateInterval) {
                    if (customInfo2.mUnexpInfoUpdateInterval <= 0 && customInfo.mUnexpInfoUpdateInterval > 0) {
                        a.a(false);
                    }
                    customInfo2.mUnexpInfoUpdateInterval = customInfo.mUnexpInfoUpdateInterval;
                    i2++;
                }
                if (!a(customInfo.mLogTypeSuffix, customInfo2.mLogTypeSuffix)) {
                    customInfo2.mLogTypeSuffix = customInfo.mLogTypeSuffix;
                    if (b.d) {
                        a(customInfo2.mLogTypeSuffix);
                    }
                    i2++;
                }
                if (customInfo2.mDisableBackgroundSignals != customInfo.mDisableBackgroundSignals) {
                    customInfo2.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
                    if (b.d) {
                        S();
                    }
                    i2++;
                }
                if (customInfo2.mEnableStatReport != customInfo.mEnableStatReport) {
                    customInfo2.mEnableStatReport = customInfo.mEnableStatReport;
                    i2++;
                }
                i = i2;
                if (customInfo2.mIsInternational != customInfo.mIsInternational) {
                    customInfo2.mIsInternational = customInfo.mIsInternational;
                    W();
                    i++;
                }
            }
        }
        return i;
    }

    private static void W() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("inter", null, b.mIsInternational ? 2L : 1L, 0L);
        }
    }
}
