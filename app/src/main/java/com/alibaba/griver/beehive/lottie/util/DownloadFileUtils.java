package com.alibaba.griver.beehive.lottie.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.APFileDownloadRspAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.ApplicationAapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.ZipHelperAdapter;
import com.alibaba.griver.beehive.lottie.adapter.listener.H5ListenerAdapter;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class DownloadFileUtils {
    private static String ANRMATION_RUNTIME_FILE_DIR = "antmation_runtime";
    private static String LOTTIE_FILE_DIR = "lottie";
    private static String LOTTIE_FONT_FILE_DIR = "lottie_font";
    private static String LOTTIE_SNAPSHOT_FILE_DIR = "lottie_snapshot";
    private static String LOTTIE_VIDEO_FILE_DIR = "lottie_video";
    private static String MARS_RUNTIME_FILE_DIR = "mars_runtime";
    public static final String MULTI_MEDIA_BIZ_TYPE = "MULTI_MEDIA_BIZ_TYPE";
    private static final String TAG = "DownloadFileUtils";

    /* loaded from: classes6.dex */
    public static abstract class WrapResponseListener implements H5ListenerAdapter {
        public static final int LOTTIE_DIR_CREATE_FAILED = 3;
        public static final int LOTTIE_FILE_IS_EMPTY = 5;
        public static final int LOTTIE_MD5_WRONG = 7;
        public static final int READ_LOTTIE_DIR_FAILED = 4;
        public static final int READ_LOTTIE_FAILED = 6;
        public static final int RESPONSE_IS_NULL = 1;
        public static final int UNZIP_FAILED = 2;
        private int errorCode = 0;

        public LottieParams getLottieParams() {
            return null;
        }

        public abstract void onError(String str);

        public abstract void onSuccess(InputStream inputStream, String str) throws Exception;

        public void setErrorCode(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        @Override // com.alibaba.griver.beehive.lottie.adapter.listener.H5ListenerAdapter
        public void onProviderCallBack(InputStream inputStream, String str) {
            if (inputStream != null) {
                try {
                    onSuccess(inputStream, null);
                    return;
                } catch (Exception e) {
                    onError(e.toString());
                    return;
                }
            }
            onError(str);
        }
    }

    public static APFileDownloadRspAdapter loadMeidaSync(String str, String str2, String str3) {
        return MultimediaServiceAdapter.loadMeidaSync(str, str2, str3);
    }

    public static void loadMeida(String str, final WrapResponseListener wrapResponseListener, String str2) {
        MultimediaServiceAdapter.loadMeida(str, str2, new MultimediaServiceAdapter.DjangoLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.1
            @Override // com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.DjangoLoadCallback
            public final void onSuccess(InputStream inputStream, String str3) {
                try {
                    WrapResponseListener.this.onSuccess(inputStream, str3);
                } catch (Exception e) {
                    GriverLogger.e(DownloadFileUtils.TAG, "媒体资源加载异常：", e);
                }
            }

            @Override // com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.DjangoLoadCallback
            public final void onError(String str3) {
                WrapResponseListener.this.onError(str3);
            }

            @Override // com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.DjangoLoadCallback
            public final void setErrorCode(int i) {
                WrapResponseListener.this.setErrorCode(i);
            }
        });
    }

    public static boolean unzipLottieFontSync(String str, String str2) {
        String[] list;
        StringBuilder sb = new StringBuilder();
        sb.append("unzipLottieFontSync path:");
        sb.append(str2);
        GriverLogger.d(TAG, sb.toString());
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(encrypt);
        sb2.append("_tmp");
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb3.append(File.separator);
        sb3.append(LOTTIE_FONT_FILE_DIR);
        sb3.append(File.separator);
        sb3.append(obj);
        File file = new File(sb3.toString());
        File lottieFontUnzipDir = getLottieFontUnzipDir(str);
        if (lottieFontUnzipDir.exists()) {
            String[] list2 = lottieFontUnzipDir.list();
            if (list2 != null && list2.length > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("unzipLottieFontSync 目标文件已经存在：");
                sb4.append(StringUtils.join(list2, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb4.toString());
                delFile(file);
                return true;
            }
            lottieFontUnzipDir.delete();
        }
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_unzip_file_sync_disabled"))) {
            return unzipAndCopyFile(str, str2, file, lottieFontUnzipDir);
        }
        synchronized (obj.intern()) {
            if (lottieFontUnzipDir.exists() && (list = lottieFontUnzipDir.list()) != null && list.length > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("并发返回,unzipLottieFontSync 目标文件已经存在：");
                sb5.append(StringUtils.join(list, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb5.toString());
                return true;
            }
            return unzipAndCopyFile(str, str2, file, lottieFontUnzipDir);
        }
    }

    public static boolean unzipAntmationRuntimeSync(String str, String str2) {
        String[] list;
        StringBuilder sb = new StringBuilder();
        sb.append("unzipAntmationRuntimeSync path:");
        sb.append(str2);
        GriverLogger.d(TAG, sb.toString());
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(encrypt);
        sb2.append("_tmp");
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb3.append(File.separator);
        sb3.append(ANRMATION_RUNTIME_FILE_DIR);
        sb3.append(File.separator);
        sb3.append(obj);
        File file = new File(sb3.toString());
        File antmationRuntimeUnzipDir = getAntmationRuntimeUnzipDir(str);
        if (antmationRuntimeUnzipDir.exists()) {
            String[] list2 = antmationRuntimeUnzipDir.list();
            if (list2 != null && list2.length > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("unzipAntmationRuntimeSync 目标文件已经存在：");
                sb4.append(StringUtils.join(list2, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb4.toString());
                delFile(file);
                return true;
            }
            antmationRuntimeUnzipDir.delete();
        }
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_unzip_file_sync_disabled"))) {
            return unzipAndCopyFile(str, str2, file, antmationRuntimeUnzipDir);
        }
        synchronized (obj.intern()) {
            if (antmationRuntimeUnzipDir.exists() && (list = antmationRuntimeUnzipDir.list()) != null && list.length > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("并发返回,unzipAntmationRuntimeSync 目标文件已经存在：");
                sb5.append(StringUtils.join(list, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb5.toString());
                return true;
            }
            return unzipAndCopyFile(str, str2, file, antmationRuntimeUnzipDir);
        }
    }

    public static boolean unzipMarsRuntimeSync(String str, String str2) {
        String[] list;
        StringBuilder sb = new StringBuilder();
        sb.append("unzipMarsRuntimeSync path:");
        sb.append(str2);
        GriverLogger.d(TAG, sb.toString());
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(encrypt);
        sb2.append("_tmp");
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb3.append(File.separator);
        sb3.append(MARS_RUNTIME_FILE_DIR);
        sb3.append(File.separator);
        sb3.append(obj);
        File file = new File(sb3.toString());
        File marsRuntimeUnzipDir = getMarsRuntimeUnzipDir(str);
        if (marsRuntimeUnzipDir.exists()) {
            String[] list2 = marsRuntimeUnzipDir.list();
            if (list2 != null && list2.length > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("unzipMarsRuntimeSync 目标文件已经存在：");
                sb4.append(StringUtils.join(list2, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb4.toString());
                delFile(file);
                return true;
            }
            marsRuntimeUnzipDir.delete();
        }
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_unzip_file_sync_disabled"))) {
            return unzipAndCopyFile(str, str2, file, marsRuntimeUnzipDir);
        }
        synchronized (obj.intern()) {
            if (marsRuntimeUnzipDir.exists() && (list = marsRuntimeUnzipDir.list()) != null && list.length > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("并发返回,unzipMarsRuntimeSync 目标文件已经存在：");
                sb5.append(StringUtils.join(list, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb5.toString());
                return true;
            }
            return unzipAndCopyFile(str, str2, file, marsRuntimeUnzipDir);
        }
    }

    public static boolean unzipVideoSync(String str, String str2) {
        String[] list;
        StringBuilder sb = new StringBuilder();
        sb.append("unzipVideoSync path:");
        sb.append(str2);
        GriverLogger.d(TAG, sb.toString());
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(encrypt);
        sb2.append("_tmp");
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb3.append(File.separator);
        sb3.append(LOTTIE_VIDEO_FILE_DIR);
        sb3.append(File.separator);
        sb3.append(obj);
        File file = new File(sb3.toString());
        File videoUnzipDir = getVideoUnzipDir(str);
        if (videoUnzipDir.exists()) {
            String[] list2 = videoUnzipDir.list();
            if (list2 != null && list2.length > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("video 目标文件已经存在：");
                sb4.append(StringUtils.join(list2, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb4.toString());
                delFile(file);
                return true;
            }
            videoUnzipDir.delete();
        }
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_unzip_file_sync_disabled"))) {
            return unzipAndCopyFile(str, str2, file, videoUnzipDir);
        }
        synchronized (obj.intern()) {
            if (videoUnzipDir.exists() && (list = videoUnzipDir.list()) != null && list.length > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("并发返回,unzipMarsRuntimeSync 目标文件已经存在：");
                sb5.append(StringUtils.join(list, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb5.toString());
                return true;
            }
            return unzipAndCopyFile(str, str2, file, videoUnzipDir);
        }
    }

    public static boolean unzipLottieSync(String str, String str2) {
        String[] list;
        StringBuilder sb = new StringBuilder();
        sb.append("unzipLottieSync path:");
        sb.append(str2);
        GriverLogger.d(TAG, sb.toString());
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(encrypt);
        sb2.append("_tmp");
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb3.append(File.separator);
        sb3.append(LOTTIE_FILE_DIR);
        sb3.append(File.separator);
        sb3.append(obj);
        File file = new File(sb3.toString());
        File lottieUnzipDir = getLottieUnzipDir(str);
        if (lottieUnzipDir.exists()) {
            String[] list2 = lottieUnzipDir.list();
            if (list2 != null && list2.length > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("unzipLottieSync 目标文件已经存在：");
                sb4.append(StringUtils.join(list2, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb4.toString());
                delFile(file);
                return true;
            }
            lottieUnzipDir.delete();
        }
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_unzip_file_sync_disabled"))) {
            return unzipAndCopyFile(str, str2, file, lottieUnzipDir);
        }
        synchronized (obj.intern()) {
            if (lottieUnzipDir.exists() && (list = lottieUnzipDir.list()) != null && list.length > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("并发返回,unzipLottieSync 目标文件已经存在：");
                sb5.append(StringUtils.join(list, HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
                GriverLogger.d(TAG, sb5.toString());
                return true;
            }
            return unzipAndCopyFile(str, str2, file, lottieUnzipDir);
        }
    }

    private static boolean unzipAndCopyFile(String str, String str2, File file, File file2) {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e;
        boolean mkdirs = file.mkdirs();
        StringBuilder sb = new StringBuilder();
        sb.append("unzipAndCopyFile mkdirRet=");
        sb.append(mkdirs);
        sb.append(" dir:");
        sb.append(file.getAbsolutePath());
        GriverLogger.d(TAG, sb.toString());
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            try {
                fileInputStream = new FileInputStream(new File(str2));
                try {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(file.getAbsolutePath());
                        sb2.append(File.separator);
                        boolean unZip = ZipHelperAdapter.unZip(fileInputStream, sb2.toString());
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("unzipAndCopyFile unzip=");
                            sb3.append(unZip);
                            GriverLogger.d(TAG, sb3.toString());
                            IOUtil.closeStream(fileInputStream);
                            if (unZip && !file2.exists()) {
                                boolean renameTo = file.renameTo(file2);
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("unzipAndCopyFile rename=");
                                sb4.append(renameTo);
                                GriverLogger.d(TAG, sb4.toString());
                            }
                            return unZip;
                        } catch (Exception e2) {
                            e = e2;
                            z = unZip;
                            fileInputStream2 = fileInputStream;
                            GriverLogger.e(TAG, "unzipAndCopyFile", e);
                            IOUtil.closeStream(fileInputStream2);
                            return z;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtil.closeStream(fileInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static File getLottieUnzipDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb = new StringBuilder();
        sb.append(getLottieDir());
        sb.append(encrypt);
        return new File(sb.toString());
    }

    public static String getLottieDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(LOTTIE_FILE_DIR);
        sb.append(File.separator);
        return sb.toString();
    }

    public static File getAntmationRuntimeUnzipDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb = new StringBuilder();
        sb.append(getAnrmationRuntimeDir());
        sb.append(encrypt);
        return new File(sb.toString());
    }

    public static File getVideoUnzipDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb = new StringBuilder();
        sb.append(getLottieVideoDir());
        sb.append(encrypt);
        return new File(sb.toString());
    }

    public static File getMarsRuntimeUnzipDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb = new StringBuilder();
        sb.append(getMarsRuntimeDir());
        sb.append(encrypt);
        return new File(sb.toString());
    }

    public static String getAnrmationRuntimeDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(ANRMATION_RUNTIME_FILE_DIR);
        sb.append(File.separator);
        return sb.toString();
    }

    public static String getMarsRuntimeDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(MARS_RUNTIME_FILE_DIR);
        sb.append(File.separator);
        return sb.toString();
    }

    public static File getLottieFontUnzipDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encrypt = MD5Util.encrypt(str);
        StringBuilder sb = new StringBuilder();
        sb.append(getLottieFontDir());
        sb.append(encrypt);
        return new File(sb.toString());
    }

    public static String getLottieFontDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(LOTTIE_FONT_FILE_DIR);
        sb.append(File.separator);
        return sb.toString();
    }

    public static String getLottieVideoDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(LOTTIE_VIDEO_FILE_DIR);
        sb.append(File.separator);
        return sb.toString();
    }

    public static String getLottieSnapshotFileDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationAapter.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(LOTTIE_SNAPSHOT_FILE_DIR);
        sb.append(File.separator);
        return sb.toString();
    }

    public static boolean delFile(File file) {
        File[] listFiles;
        if (file == null) {
            return false;
        }
        try {
            if (file.exists()) {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        delFile(file2);
                    }
                }
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("删除文件失败：");
            sb.append(e);
            GriverLogger.w(TAG, sb.toString());
            return false;
        }
    }

    public static String saveSnapshotBitmap(Bitmap bitmap, String str) {
        return MultimediaServiceAdapter.saveSnapshotBitmap(bitmap, str);
    }

    public static boolean directoryExistAndHasFile(File file) {
        File[] listFiles;
        return file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.2
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str) {
                return str.endsWith(".js");
            }
        })) != null && listFiles.length > 0;
    }
}
