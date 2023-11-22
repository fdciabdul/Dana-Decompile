package com.alipay.iap.android.aplog.core;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alipay.iap.android.aplog.api.ProcessInfo;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ProcessInfoImpl implements ProcessInfo {
    private static final String TAG = "ProcessInfoImpl";
    private Context mContext;
    private boolean mIsMainProcess;
    private boolean mIsToolsProcess;
    private String mMainProcessName;
    private String mPackageName;
    private String mProcessAlias;
    private String mProcessName;
    private String mProcessTag;
    private String mToolsProcessName;

    public ProcessInfoImpl(Context context) {
        this.mIsMainProcess = false;
        this.mIsToolsProcess = false;
        this.mProcessTag = "";
        this.mProcessAlias = "";
        this.mPackageName = "";
        this.mProcessName = "";
        this.mMainProcessName = "";
        this.mToolsProcessName = "";
        this.mContext = context;
        this.mPackageName = context.getPackageName();
        this.mProcessName = getCurrentProcessName();
        this.mMainProcessName = this.mPackageName;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mPackageName);
        sb.append(":");
        sb.append(ProcessInfo.ALIAS_TOOLS);
        this.mToolsProcessName = sb.toString();
        this.mIsMainProcess = this.mMainProcessName.equals(this.mProcessName);
        boolean equals = this.mToolsProcessName.equals(this.mProcessName);
        this.mIsToolsProcess = equals;
        if (this.mIsMainProcess) {
            this.mProcessAlias = "main";
        } else if (equals) {
            this.mProcessAlias = ProcessInfo.ALIAS_TOOLS;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mPackageName);
        sb2.append("-");
        sb2.append(this.mProcessAlias);
        this.mProcessTag = sb2.toString();
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public boolean isToolsProcess() {
        return this.mIsToolsProcess;
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public String getPackageName() {
        return this.mPackageName;
    }

    private String getCurrentProcessName() {
        String str;
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = loadClass.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = loadClass.getDeclaredMethod(ProcessUtils.GET_PROCESS_NAME, new Class[0]);
            declaredMethod2.setAccessible(true);
            str = (String) declaredMethod2.invoke(invoke, new Object[0]);
        } catch (Throwable th) {
            InstrumentInjector.log_e(TAG, "getCurrentProcessName 1", th);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                Method declaredMethod3 = getClass().getClassLoader().loadClass("android.ddm.DdmHandleAppName").getDeclaredMethod("getAppName", new Class[0]);
                declaredMethod3.setAccessible(true);
                str = (String) declaredMethod3.invoke(null, new Object[0]);
            } catch (Throwable th2) {
                InstrumentInjector.log_e(TAG, "getCurrentProcessName 2", th2);
            }
            return !TextUtils.isEmpty(str) ? str : getProcessNameByID(getProcessID());
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        r0 = r2.processName;
     */
    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getProcessNameByID(int r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.mContext     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L26
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Throwable -> L26
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L26
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L26
        L13:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L26
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch: java.lang.Throwable -> L26
            int r3 = r2.pid     // Catch: java.lang.Throwable -> L26
            if (r3 != r5) goto L13
            java.lang.String r0 = r2.processName     // Catch: java.lang.Throwable -> L26
            goto L3d
        L26:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getProcessNameByID: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "ProcessInfoImpl"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r1, r5)
        L3d:
            if (r0 != 0) goto L41
            java.lang.String r0 = ""
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.ProcessInfoImpl.getProcessNameByID(int):java.lang.String");
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public int getProcessID() {
        return Process.myPid();
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public String getProcessTag() {
        return this.mProcessTag;
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public String getProcessAlias() {
        return this.mProcessAlias;
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public String getMainProcessName() {
        return this.mProcessName;
    }

    @Override // com.alipay.iap.android.aplog.api.ProcessInfo
    public String getToolsProcessName() {
        return this.mToolsProcessName;
    }
}
