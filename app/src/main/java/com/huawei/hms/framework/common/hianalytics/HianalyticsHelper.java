package com.huawei.hms.framework.common.hianalytics;

import android.content.Context;
import android.provider.Settings;
import com.google.common.base.Ascii;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes7.dex */
public class HianalyticsHelper {
    private static volatile HianalyticsHelper getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private boolean moveToNextValue;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {94, Ascii.EM, -44, 73, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 231;
    private String lookAheadTest = "hms_hwid";
    private HiAnalyticsInstance MyBillsEntityDataFactory = null;
    private HiAnalyticsInstance PlaceComponentResult = null;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    private ExecutorService scheduleImpl = ExecutorsUtils.newSingleThreadExecutor("report_ha");

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.a(byte, byte, short, java.lang.Object[]):void");
    }

    private HianalyticsHelper() {
        try {
            HiAnalyticsManager.getInitFlag("_default_config_tag");
            this.moveToNextValue = true;
        } catch (Throwable unused) {
            Logger.i("HianalyticsHelper", "Hianalytics sdk not found");
            this.moveToNextValue = false;
        }
        if (!this.moveToNextValue) {
            Context appContext = ContextHolder.getAppContext();
            if (appContext == null) {
                Logger.i("HianalyticsHelper", "the appContext hasn't init");
            } else {
                try {
                    HMSBIInitializer.getInstance(appContext).initBI();
                    this.getErrorConfigVersion = true;
                } catch (NoClassDefFoundError unused2) {
                    Logger.w("HianalyticsHelper", "maybe you need add base sdk!");
                } catch (Throwable unused3) {
                    Logger.w("HianalyticsHelper", "the hms base has other error!");
                }
            }
        }
        Logger.v("HianalyticsHelper", "this time the ha %s, mini %s", Boolean.valueOf(this.moveToNextValue), Boolean.valueOf(this.getErrorConfigVersion));
    }

    public void setHaTag(String str) {
        this.lookAheadTest = str;
    }

    public void enablePrivacyPolicy(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    public static HianalyticsHelper getInstance() {
        if (getAuthRequestContext == null) {
            synchronized (HianalyticsHelper.class) {
                if (getAuthRequestContext == null) {
                    getAuthRequestContext = new HianalyticsHelper();
                }
            }
        }
        return getAuthRequestContext;
    }

    public boolean isEnableReport(Context context) {
        if (this.getErrorConfigVersion) {
            return true;
        }
        if (this.moveToNextValue) {
            return isEnableReportNoSeed(context);
        }
        return false;
    }

    public boolean isEnableReportNoSeed(Context context) {
        if (this.getErrorConfigVersion) {
            return true;
        }
        if (!this.moveToNextValue) {
            Logger.i("HianalyticsHelper", "Hianalytics sdk need to be initialized");
            return false;
        } else if (context == null) {
            Logger.i("HianalyticsHelper", "HianalyticsHelper context can't be null");
            return false;
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return MyBillsEntityDataFactory();
        } else {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "user_experience_involved", -1) == 1) {
                    return MyBillsEntityDataFactory();
                }
            } catch (IllegalStateException unused) {
                Logger.w("HianalyticsHelper", "the setting has illegalStateException");
            } catch (Throwable unused2) {
                Logger.w("HianalyticsHelper", "the setting has other error");
            }
            Logger.i("HianalyticsHelper", "user experience involved needs to be opened");
            return false;
        }
    }

    private boolean MyBillsEntityDataFactory() {
        if (HiAnalyticsManager.getInitFlag("_default_config_tag")) {
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = HiAnalyticsManager.getInstanceByTag("_default_config_tag");
            }
            return this.PlaceComponentResult != null;
        }
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = HiAnalyticsManager.getInstanceByTag(this.lookAheadTest);
        }
        return this.MyBillsEntityDataFactory != null;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str) {
        onEvent(linkedHashMap, str, 1);
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str, int i) {
        HiAnalyticsInstance hiAnalyticsInstance;
        if (this.getErrorConfigVersion) {
            Context appContext = ContextHolder.getAppContext();
            if (appContext != null && linkedHashMap != null) {
                Logger.v("HianalyticsHelper", "data = %s", linkedHashMap);
                try {
                    HiAnalyticsUtils.getInstance().onNewEvent(appContext, str, linkedHashMap, i);
                } catch (NoSuchMethodError unused) {
                    Logger.w("HianalyticsHelper", "may be you need upgrade stats sdk");
                } catch (Throwable unused2) {
                    Logger.i("HianalyticsHelper", "the stats has other error,pls check it");
                }
            }
        } else if (i == 0) {
            Logger.v("HianalyticsHelper", "the base sdk isn't exsit, and reportType is %s", Integer.valueOf(i));
            return;
        }
        if (this.moveToNextValue && linkedHashMap != null) {
            Logger.v("HianalyticsHelper", "data = %s", linkedHashMap);
            if (HiAnalyticsManager.getInitFlag("_default_config_tag") && (hiAnalyticsInstance = this.PlaceComponentResult) != null) {
                hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
                return;
            }
            HiAnalyticsInstance hiAnalyticsInstance2 = this.MyBillsEntityDataFactory;
            if (hiAnalyticsInstance2 != null) {
                hiAnalyticsInstance2.onEvent(1, str, linkedHashMap);
            } else {
                Logger.e("HianalyticsHelper", "the ha has error,has init but is null!");
            }
        }
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap) {
        onEvent(linkedHashMap, HianalyticsBaseData.EVENT_ID);
    }

    public ExecutorService getReportExecutor() {
        return this.scheduleImpl;
    }

    public void executeReportHa(HianalyticsBaseData hianalyticsBaseData, String str) {
        getReportExecutor().execute(new HianalyticsRunnable(hianalyticsBaseData, str));
    }

    public void reportException(final Throwable th, final String str) {
        if (getInstance().isEnableReport(ContextHolder.getAppContext())) {
            try {
                Object[] objArr = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[15], KClassImpl$Data$declaredNonStaticMembers$2[22], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr2);
                final String name = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
                try {
                    this.scheduleImpl.submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CrashHianalyticsData crashHianalyticsData = new CrashHianalyticsData();
                            crashHianalyticsData.put(HianalyticsBaseData.SDK_VERSION, "5.0.10.302");
                            crashHianalyticsData.put(CrashHianalyticsData.CRASH_TYPE, "exception");
                            crashHianalyticsData.put(CrashHianalyticsData.THREAD_NAME, name);
                            crashHianalyticsData.put(CrashHianalyticsData.EXCEPTION_NAME, th.getClass().getName());
                            crashHianalyticsData.put("message", StringUtils.anonymizeMessage(th.getMessage()));
                            crashHianalyticsData.put(CrashHianalyticsData.STACK_TRACE, StringUtils.getTraceInfo(th));
                            HianalyticsHelper.getInstance().onEvent(crashHianalyticsData.get(), str);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    Logger.i("HianalyticsHelper", "reportException error RejectedExecutionException");
                } catch (Exception unused2) {
                    Logger.i("HianalyticsHelper", "reportException error!", th);
                }
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }

    public void reportData(Context context, LinkedHashMap<String, String> linkedHashMap, String str, int i) {
        if (isEnableReportNoSeed(context)) {
            onEvent(linkedHashMap, str, i);
        }
    }

    /* loaded from: classes7.dex */
    static class HianalyticsRunnable implements Runnable {
        private final String MyBillsEntityDataFactory;
        private final HianalyticsBaseData getAuthRequestContext;

        HianalyticsRunnable(HianalyticsBaseData hianalyticsBaseData, String str) {
            this.getAuthRequestContext = hianalyticsBaseData;
            this.MyBillsEntityDataFactory = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HianalyticsHelper.getInstance().onEvent(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory);
        }
    }
}
