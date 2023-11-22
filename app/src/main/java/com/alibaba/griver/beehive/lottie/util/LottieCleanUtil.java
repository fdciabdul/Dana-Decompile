package com.alibaba.griver.beehive.lottie.util;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.APSharedPreferencesAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.ApplicationAapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SharedPreferencesManagerAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class LottieCleanUtil {
    private static final String LOTTIE_CLEAN_CLOSE_SWITCH = "BeeLottie_Purgeable_Clean_Disable";
    private static final String LOTTIE_CLEAN_INTERVAL_SWITCH = "BeeLottie_Purgeable_Date_Diff";
    private static final String LOTTIE_CLEAN_UPDATE_LASTVISITTIME_DISABLE_SWITCH = "BeeLottie_Purgeable_Record_Disable";
    private static final String TAG = "LottiePlayer:LottieCleanUtil";
    private static int cleanDay = -1;
    private static long cleanInterval = 2592000000L;
    private static boolean cleanSwitchClosed;
    private static long lastCleanTimestamp;
    private static APSharedPreferencesAdapter sharedPreferences;
    private static boolean updateLastVisitTimeDisabled;

    static {
        try {
            cleanSwitchClosed = SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue(LOTTIE_CLEAN_CLOSE_SWITCH));
            updateLastVisitTimeDisabled = SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue(LOTTIE_CLEAN_UPDATE_LASTVISITTIME_DISABLE_SWITCH));
            if (!cleanSwitchClosed) {
                long sharedCacheLongByKey = getSharedCacheLongByKey("lastCleanTimestamp");
                lastCleanTimestamp = sharedCacheLongByKey;
                if (sharedCacheLongByKey > 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(lastCleanTimestamp);
                    cleanDay = calendar.get(5);
                }
                if (!TextUtils.isEmpty(SwitchConfigUtilsAdapter.getConfigValue(LOTTIE_CLEAN_INTERVAL_SWITCH))) {
                    cleanInterval = Float.parseFloat(r1) * 1000.0f * 24 * 60 * 60;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cleanSwitchClosed=");
            sb.append(cleanSwitchClosed);
            sb.append(",lastCleanTimestamp=");
            sb.append(lastCleanTimestamp);
            sb.append(",cleanInterval=");
            sb.append(cleanInterval);
            sb.append(",updateLastVisitTimeDisabled=");
            sb.append(updateLastVisitTimeDisabled);
            sb.append(",cleanDay=");
            sb.append(cleanDay);
            GriverLogger.d(TAG, sb.toString());
            if (cleanInterval > 0) {
            }
        } catch (Throwable th) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("开关读取失败:");
                sb2.append(th);
                GriverLogger.w(TAG, sb2.toString());
            } finally {
                if (cleanInterval <= 0) {
                    cleanInterval = 2592000000L;
                }
            }
        }
    }

    public static void cleanLottie() {
        if (cleanSwitchClosed || Calendar.getInstance().get(5) == cleanDay || System.currentTimeMillis() - lastCleanTimestamp <= cleanInterval) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("10s后开始执行清除任务,lastCleanTimestamp=");
        sb.append(lastCleanTimestamp);
        sb.append(",cleanDay=");
        sb.append(cleanDay);
        GriverLogger.d(TAG, sb.toString());
        cleanDay = Calendar.getInstance().get(5);
        lastCleanTimestamp = System.currentTimeMillis();
        MultiThreadUtils.runOnUiThreadDelay(new CleanRunnable(), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CleanRunnable implements Runnable {
        private CleanRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.util.LottieCleanUtil.CleanRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    String lottieDir = DownloadFileUtils.getLottieDir();
                    String anrmationRuntimeDir = DownloadFileUtils.getAnrmationRuntimeDir();
                    String lottieFontDir = DownloadFileUtils.getLottieFontDir();
                    String marsRuntimeDir = DownloadFileUtils.getMarsRuntimeDir();
                    StringBuilder sb = new StringBuilder();
                    sb.append("开始执行清除任务,lastCleanTimestamp=");
                    sb.append(LottieCleanUtil.lastCleanTimestamp);
                    sb.append(",lottieDir=");
                    sb.append(lottieDir);
                    sb.append(",resourceDir=");
                    sb.append(anrmationRuntimeDir);
                    sb.append(",fontDir=");
                    sb.append(lottieFontDir);
                    GriverLogger.d(LottieCleanUtil.TAG, sb.toString());
                    try {
                        LottieCleanUtil.cleanFiles(lottieDir);
                        LottieCleanUtil.cleanFiles(anrmationRuntimeDir);
                        LottieCleanUtil.cleanFiles(marsRuntimeDir);
                        LottieCleanUtil.cleanFiles(lottieFontDir);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                        calendar.set(14, 0);
                        long unused = LottieCleanUtil.lastCleanTimestamp = calendar.getTimeInMillis();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("完成清除任务,lastCleanTimestamp=");
                        sb2.append(LottieCleanUtil.lastCleanTimestamp);
                        sb2.append(",lottieDir=");
                        sb2.append(lottieDir);
                        GriverLogger.d(LottieCleanUtil.TAG, sb2.toString());
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cleanFiles(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            cleanFiles(file2);
        }
    }

    private static void cleanFiles(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                long fileLastVisitTime = getFileLastVisitTime(file);
                if (System.currentTimeMillis() - fileLastVisitTime >= cleanInterval) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("cleanFiles,");
                    sb.append(file);
                    sb.append(",lastCleanTimestamp=");
                    sb.append(lastCleanTimestamp);
                    sb.append(",lastModified=");
                    sb.append(fileLastVisitTime);
                    sb.append(",cleanInterval=");
                    sb.append(cleanInterval);
                    GriverLogger.d(TAG, sb.toString());
                    boolean delFile = DownloadFileUtils.delFile(file);
                    cleanLottieFilesLog(file.getName(), delFile, delFile ? "" : "unknow");
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cleanFile异常：");
                sb2.append(file);
                sb2.append(",");
                sb2.append(th);
                GriverLogger.w(TAG, sb2.toString());
                cleanLottieFilesLog(file.getName(), false, th.getLocalizedMessage());
            }
        }
    }

    private static long getFileLastVisitTime(File file) {
        File lastVisitTimeFileCreateOnNotExists = getLastVisitTimeFileCreateOnNotExists(file);
        if (lastVisitTimeFileCreateOnNotExists.exists()) {
            long lastModified = lastVisitTimeFileCreateOnNotExists.lastModified();
            if (lastModified == 0) {
                recordLottieLastVisitTimeLog("readFileFail", file.getName(), false, "wrongTime");
                return System.currentTimeMillis();
            }
            return lastModified;
        }
        recordLottieLastVisitTimeLog("readFileFail", file.getName(), false, "noFile");
        return System.currentTimeMillis();
    }

    private static File getLastVisitTimeFileCreateOnNotExists(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        sb.append(File.separator);
        sb.append(".lastVisitTime");
        File file2 = new File(sb.toString());
        if (!file2.exists()) {
            try {
                boolean createNewFile = file2.createNewFile();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("创建.lastVisitTime文件结果：");
                sb2.append(file2);
                sb2.append(",result=");
                sb2.append(createNewFile);
                GriverLogger.d(TAG, sb2.toString());
                if (!createNewFile) {
                    recordLottieLastVisitTimeLog("createFile", file.getName(), false, "unknow");
                }
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("创建最近使用文件出错：");
                sb3.append(file);
                sb3.append(",");
                sb3.append(th);
                GriverLogger.w(TAG, sb3.toString());
                recordLottieLastVisitTimeLog("createFile", file.getName(), false, th.getLocalizedMessage());
            }
        }
        return file2;
    }

    public static void updateLastVisitTimeFile(File file) {
        if (updateLastVisitTimeDisabled || file == null || !file.exists() || !file.isDirectory()) {
            return;
        }
        try {
            File lastVisitTimeFileCreateOnNotExists = getLastVisitTimeFileCreateOnNotExists(file);
            if (lastVisitTimeFileCreateOnNotExists.exists()) {
                boolean lastModified = lastVisitTimeFileCreateOnNotExists.setLastModified(System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("updateLastVisitTimeFile,file=");
                sb.append(lastVisitTimeFileCreateOnNotExists);
                sb.append(",result=");
                sb.append(lastModified);
                GriverLogger.d(TAG, sb.toString());
                if (lastModified) {
                    return;
                }
                recordLottieLastVisitTimeLog("modifyFile", file.getName(), false, "unknow");
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateLastVisitTimeFile异常：");
            sb2.append(file);
            sb2.append(",");
            sb2.append(th);
            GriverLogger.w(TAG, sb2.toString());
            recordLottieLastVisitTimeLog("modifyFile", file.getName(), false, th.getLocalizedMessage());
        }
    }

    private static void cleanLottieFilesLog(String str, boolean z, String str2) {
        eventLog("CleanLottieDir", "removeItem", str, z, str2);
    }

    private static void recordLottieLastVisitTimeLog(String str, String str2, boolean z, String str3) {
        eventLog("PurgeFile", str, str2, z, str3);
    }

    private static void eventLog(String str, String str2, String str3, boolean z, String str4) {
        HashMap hashMap = new HashMap(5);
        hashMap.put("type", str);
        hashMap.put("operation", str2);
        hashMap.put("itemKey", str3);
        hashMap.put("success", String.valueOf(z));
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        hashMap.put(ZdocRecordService.REASON, str4);
    }

    private static APSharedPreferencesAdapter getSharedPreferences() {
        Application applicationContext = ApplicationAapter.getApplicationContext();
        if (sharedPreferences == null) {
            sharedPreferences = SharedPreferencesManagerAdapter.getInstance(applicationContext, "com.alipay.mobile.beehive.lottie.util");
        }
        return sharedPreferences;
    }

    private static long getSharedCacheLongByKey(String str) {
        APSharedPreferencesAdapter sharedPreferences2 = getSharedPreferences();
        if (sharedPreferences2 != null) {
            return sharedPreferences2.getLong(str, 0L);
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putSharedCacheLongByKey(String str, long j) {
        APSharedPreferencesAdapter sharedPreferences2 = getSharedPreferences();
        if (sharedPreferences2 != null) {
            sharedPreferences2.putLong(str, j);
            sharedPreferences2.commit();
        }
    }
}
