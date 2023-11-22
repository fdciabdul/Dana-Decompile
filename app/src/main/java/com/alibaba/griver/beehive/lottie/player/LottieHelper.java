package com.alibaba.griver.beehive.lottie.player;

import android.app.Application;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.APFileDownloadRspAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.ApplicationAapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.H5UtilsAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.NumberFontUtilAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.beehive.lottie.util.DownloadFileUtils;
import com.alibaba.griver.beehive.lottie.util.LottieCleanUtil;
import com.alibaba.griver.beehive.lottie.util.MultiThreadUtils;
import com.alibaba.griver.beehive.lottie.util.StringUtils;
import com.alibaba.griver.image.photo.PhotoContext;
import com.alibaba.griver.lottie.okio.Okio;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import id.dana.contract.payasset.SceneType;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LottieHelper {
    private static int MyBillsEntityDataFactory = 0;
    private static final String TAG = "LottieHelper";
    private static int[] clientVersionIntArray = null;
    private static int getAuthRequestContext = 1;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, -8, -8, 2, 38, 6, -5, -5, -49, -11, -23, -5, 9, -20, 18, 41, 2, -17, 12, -12, 75, -78, -15, 78, -75, 0, -13, -8, 2, -4, TarHeader.LF_LINK};
    public static final int PlaceComponentResult = 120;
    private static FilenameFilter downgradeInZipFilenameFilter = new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.1
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.equals("placeHolder.png") || str.equals("downgrade.png");
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r8, int r9, int r10, java.lang.Object[] r11) {
        /*
            int r9 = r9 * 15
            int r9 = r9 + 102
            int r10 = r10 * 2
            int r10 = 16 - r10
            int r8 = r8 * 15
            int r8 = r8 + 4
            byte[] r0 = com.alibaba.griver.beehive.lottie.player.LottieHelper.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L1a
            r9 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r10) goto L2a
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L35:
            int r10 = -r10
            int r8 = r8 + r10
            int r8 = r8 + (-5)
            int r9 = r9 + 1
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.player.LottieHelper.a(short, int, int, java.lang.Object[]):void");
    }

    static void ergodic(File file, String str, List<String> list) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    ergodic(file2, str, list);
                } else if (file2.getName().equals(str)) {
                    list.add(file2.getAbsolutePath());
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x03ce, code lost:
    
        if ((!((java.lang.Boolean) java.lang.String.class.getMethod("startsWith", java.lang.String.class).invoke(r18, "data://base64,")).booleanValue()) != true) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a7, code lost:
    
        if (((java.lang.Boolean) java.lang.String.class.getMethod("startsWith", java.lang.String.class).invoke(r18, com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil.RESOURCE)).booleanValue() != false) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0512  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getResourceWithUrl(java.lang.String r18, com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener r19, android.content.Context r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.player.LottieHelper.getResourceWithUrl(java.lang.String, com.alibaba.griver.beehive.lottie.util.DownloadFileUtils$WrapResponseListener, android.content.Context, java.lang.String):void");
    }

    public static void getResourceFromDjangoId(String str, DownloadFileUtils.WrapResponseListener wrapResponseListener, String str2) {
        DownloadFileUtils.loadMeida(str, wrapResponseListener, str2);
    }

    public static void getResourceFromDjangoIdForLottieZip(final String str, final String str2, final String str3, final DownloadFileUtils.WrapResponseListener wrapResponseListener, final String str4) {
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v10 */
            /* JADX WARN: Type inference failed for: r3v11, types: [java.io.InputStream] */
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                InputStream inputStream;
                String str5 = "getResourceFromDjangoIdForLottieZip,input stream close error,";
                LottieCleanUtil.cleanLottie();
                APFileDownloadRspAdapter loadMeidaSync = DownloadFileUtils.loadMeidaSync(str, str4, str2);
                if (loadMeidaSync == null) {
                    wrapResponseListener.setErrorCode(1);
                    wrapResponseListener.onError("rsp is null.");
                } else if (loadMeidaSync.getRetCode() == 4) {
                    wrapResponseListener.setErrorCode(7);
                    wrapResponseListener.onError("loadMeidaSync CODE_ERR_FILE_MD5_WRONG.");
                } else {
                    if (TextUtils.equals(loadMeidaSync.getCloudId(), str)) {
                        z = DownloadFileUtils.unzipLottieSync(str, loadMeidaSync.getSavePath());
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("下载文件结果不一致，返回文件id为：");
                        sb.append(loadMeidaSync.getCloudId());
                        sb.append(",djangoId=");
                        sb.append(str);
                        GriverLogger.w(LottieHelper.TAG, sb.toString());
                        z = false;
                    }
                    if (!z) {
                        wrapResponseListener.setErrorCode(2);
                        wrapResponseListener.onError("unzip is failed.");
                        return;
                    }
                    File lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(str);
                    if (lottieUnzipDir == null || !lottieUnzipDir.exists()) {
                        wrapResponseListener.setErrorCode(3);
                        wrapResponseListener.onError("lottieDir is null.");
                        return;
                    }
                    File[] listFiles = lottieUnzipDir.listFiles(new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.2.1
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file, String str6) {
                            return str6.endsWith(".json");
                        }
                    });
                    if (listFiles == null || listFiles.length == 0) {
                        DownloadFileUtils.delFile(lottieUnzipDir);
                        wrapResponseListener.setErrorCode(4);
                        wrapResponseListener.onError("there is no lottie file in lottieDir.");
                        return;
                    }
                    File file = listFiles[0];
                    if (listFiles.length > 1) {
                        for (File file2 : listFiles) {
                            if (LottieConstants.RENDER_TYPE_ANTMATIONS.equals(str3)) {
                                if ("antmation.json".equals(file2.getName())) {
                                    file = file2;
                                    break;
                                }
                            } else if (!"antmation.json".equals(file2.getName())) {
                                file = file2;
                                break;
                            }
                        }
                    }
                    if (file.length() == 0) {
                        wrapResponseListener.setErrorCode(5);
                        wrapResponseListener.onError("lottie file is empty.");
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("lottie file path: ");
                    sb2.append(file.getAbsolutePath());
                    GriverLogger.d(LottieHelper.TAG, sb2.toString());
                    StringBuilder sb3 = null;
                    InputStream inputStream2 = null;
                    try {
                        try {
                            inputStream = new FileInputStream(file);
                            try {
                                wrapResponseListener.onSuccess(inputStream, file.getAbsolutePath());
                                LottieCleanUtil.updateLastVisitTimeFile(lottieUnzipDir);
                                try {
                                    inputStream.close();
                                } catch (Exception e) {
                                    e = e;
                                    sb3 = new StringBuilder();
                                    sb3.append("getResourceFromDjangoIdForLottieZip,input stream close error,");
                                    sb3.append(file.getAbsolutePath());
                                    str5 = sb3.toString();
                                    GriverLogger.e(LottieHelper.TAG, str5, e);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                inputStream2 = inputStream;
                                GriverLogger.e(LottieHelper.TAG, "读取Lottie资源加载出错：", e);
                                wrapResponseListener.setErrorCode(6);
                                wrapResponseListener.onError(e.toString());
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e3) {
                                        e = e3;
                                        sb3 = new StringBuilder();
                                        sb3.append("getResourceFromDjangoIdForLottieZip,input stream close error,");
                                        sb3.append(file.getAbsolutePath());
                                        str5 = sb3.toString();
                                        GriverLogger.e(LottieHelper.TAG, str5, e);
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(str5);
                                        sb4.append(file.getAbsolutePath());
                                        GriverLogger.e(LottieHelper.TAG, sb4.toString(), e4);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = sb3;
                    }
                }
            }
        });
    }

    public static void getResourceFromDjangoIdForAntmationRuntimeZip(final String str, final String str2, final DownloadFileUtils.WrapResponseListener wrapResponseListener, final String str3) {
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.3
            @Override // java.lang.Runnable
            public final void run() {
                LottieCleanUtil.cleanLottie();
                APFileDownloadRspAdapter loadMeidaSync = DownloadFileUtils.loadMeidaSync(str, str3, str2);
                if (loadMeidaSync == null) {
                    wrapResponseListener.setErrorCode(1);
                    wrapResponseListener.onError("Antmation runtime rsp is null.");
                } else if (loadMeidaSync.getRetCode() == 4) {
                    wrapResponseListener.setErrorCode(7);
                    wrapResponseListener.onError("Antmation runtime loadMeidaSync CODE_ERR_FILE_MD5_WRONG.");
                } else {
                    boolean z = false;
                    if (TextUtils.equals(loadMeidaSync.getCloudId(), str)) {
                        z = DownloadFileUtils.unzipAntmationRuntimeSync(str, loadMeidaSync.getSavePath());
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Antmation runtime 下载文件结果不一致，返回文件id为：");
                        sb.append(loadMeidaSync.getCloudId());
                        sb.append(",djangoId=");
                        sb.append(str);
                        GriverLogger.w(LottieHelper.TAG, sb.toString());
                    }
                    if (!z) {
                        wrapResponseListener.setErrorCode(2);
                        wrapResponseListener.onError("Antmation runtime unzip is failed.");
                        return;
                    }
                    File antmationRuntimeUnzipDir = DownloadFileUtils.getAntmationRuntimeUnzipDir(str);
                    if (antmationRuntimeUnzipDir == null || !antmationRuntimeUnzipDir.exists()) {
                        wrapResponseListener.setErrorCode(3);
                        wrapResponseListener.onError("Antmation runtime dir is null.");
                        return;
                    }
                    File[] listFiles = antmationRuntimeUnzipDir.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        DownloadFileUtils.delFile(antmationRuntimeUnzipDir);
                        wrapResponseListener.setErrorCode(4);
                        wrapResponseListener.onError("there is no file in antmationRuntimeDir.");
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Antmation runtime file path: ");
                    sb2.append(antmationRuntimeUnzipDir.getAbsolutePath());
                    GriverLogger.d(LottieHelper.TAG, sb2.toString());
                    try {
                        wrapResponseListener.onSuccess(null, antmationRuntimeUnzipDir.getAbsolutePath());
                        LottieCleanUtil.updateLastVisitTimeFile(antmationRuntimeUnzipDir);
                    } catch (Exception e) {
                        GriverLogger.e(LottieHelper.TAG, "Antmation runtime 回调出错：", e);
                        wrapResponseListener.setErrorCode(6);
                        wrapResponseListener.onError(e.toString());
                    }
                }
            }
        });
    }

    public static void getResourceFromDjangoIdForMarsRuntimeZip(final String str, final String str2, final DownloadFileUtils.WrapResponseListener wrapResponseListener, final String str3) {
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.4
            @Override // java.lang.Runnable
            public final void run() {
                LottieCleanUtil.cleanLottie();
                APFileDownloadRspAdapter loadMeidaSync = DownloadFileUtils.loadMeidaSync(str, str3, str2);
                if (loadMeidaSync == null) {
                    wrapResponseListener.setErrorCode(1);
                    wrapResponseListener.onError("Mars runtime rsp is null.");
                } else if (loadMeidaSync.getRetCode() == 4) {
                    wrapResponseListener.setErrorCode(7);
                    wrapResponseListener.onError("Mars runtime loadMeidaSync CODE_ERR_FILE_MD5_WRONG.");
                } else {
                    boolean z = false;
                    if (TextUtils.equals(loadMeidaSync.getCloudId(), str)) {
                        z = DownloadFileUtils.unzipMarsRuntimeSync(str, loadMeidaSync.getSavePath());
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Mars runtime 下载文件结果不一致，返回文件id为：");
                        sb.append(loadMeidaSync.getCloudId());
                        sb.append(",djangoId=");
                        sb.append(str);
                        GriverLogger.w(LottieHelper.TAG, sb.toString());
                    }
                    if (!z) {
                        wrapResponseListener.setErrorCode(2);
                        wrapResponseListener.onError("Mars runtime unzip is failed.");
                        return;
                    }
                    File marsRuntimeUnzipDir = DownloadFileUtils.getMarsRuntimeUnzipDir(str);
                    if (marsRuntimeUnzipDir == null || !marsRuntimeUnzipDir.exists()) {
                        wrapResponseListener.setErrorCode(3);
                        wrapResponseListener.onError("Mars runtime dir is null.");
                        return;
                    }
                    File[] listFiles = marsRuntimeUnzipDir.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        DownloadFileUtils.delFile(marsRuntimeUnzipDir);
                        wrapResponseListener.setErrorCode(4);
                        wrapResponseListener.onError("there is no file in MarsRuntimeDir.");
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Mars runtime file path: ");
                    sb2.append(marsRuntimeUnzipDir.getAbsolutePath());
                    GriverLogger.d(LottieHelper.TAG, sb2.toString());
                    try {
                        wrapResponseListener.onSuccess(null, marsRuntimeUnzipDir.getAbsolutePath());
                        LottieCleanUtil.updateLastVisitTimeFile(marsRuntimeUnzipDir);
                    } catch (Exception e) {
                        GriverLogger.e(LottieHelper.TAG, "Mars runtime 回调出错：", e);
                        wrapResponseListener.setErrorCode(6);
                        wrapResponseListener.onError(e.toString());
                    }
                }
            }
        });
    }

    public static void downloadVideoResource(final String str, final String str2, final DownloadFileUtils.WrapResponseListener wrapResponseListener, final String str3, final boolean z) {
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.5
            @Override // java.lang.Runnable
            public final void run() {
                LottieCleanUtil.cleanLottie();
                APFileDownloadRspAdapter loadMeidaSync = DownloadFileUtils.loadMeidaSync(str, str3, str2);
                if (loadMeidaSync == null) {
                    wrapResponseListener.setErrorCode(1);
                    wrapResponseListener.onError("video download rsp is null.");
                } else if (loadMeidaSync.getRetCode() == 4) {
                    wrapResponseListener.setErrorCode(7);
                    wrapResponseListener.onError("video download loadMeidaSync CODE_ERR_FILE_MD5_WRONG.");
                } else if (!z) {
                    try {
                        wrapResponseListener.onSuccess(null, loadMeidaSync.getSavePath());
                    } catch (Exception unused) {
                    }
                } else {
                    boolean z2 = false;
                    if (TextUtils.equals(loadMeidaSync.getCloudId(), str)) {
                        z2 = DownloadFileUtils.unzipVideoSync(str, loadMeidaSync.getSavePath());
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("video下载文件结果不一致，返回文件id为：");
                        sb.append(loadMeidaSync.getCloudId());
                        sb.append(",djangoId=");
                        sb.append(str);
                        GriverLogger.w(LottieHelper.TAG, sb.toString());
                    }
                    if (!z2) {
                        wrapResponseListener.setErrorCode(2);
                        wrapResponseListener.onError("video unzip is failed.");
                        return;
                    }
                    File videoUnzipDir = DownloadFileUtils.getVideoUnzipDir(str);
                    if (videoUnzipDir == null || !videoUnzipDir.exists()) {
                        wrapResponseListener.setErrorCode(3);
                        wrapResponseListener.onError("video download dir is null.");
                        return;
                    }
                    File[] listFiles = videoUnzipDir.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        DownloadFileUtils.delFile(videoUnzipDir);
                        wrapResponseListener.setErrorCode(4);
                        wrapResponseListener.onError("there is no file in VideoDir.");
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("video file path: ");
                    sb2.append(videoUnzipDir.getAbsolutePath());
                    GriverLogger.d(LottieHelper.TAG, sb2.toString());
                    try {
                        wrapResponseListener.onSuccess(null, videoUnzipDir.getAbsolutePath());
                        LottieCleanUtil.updateLastVisitTimeFile(videoUnzipDir);
                    } catch (Exception e) {
                        GriverLogger.e(LottieHelper.TAG, "Mars runtime 回调出错：", e);
                        wrapResponseListener.setErrorCode(6);
                        wrapResponseListener.onError(e.toString());
                    }
                }
            }
        });
    }

    public static void downloadFontFromRemoteSync(LottieParams lottieParams, String str, String str2, DownloadFileUtils.WrapResponseListener wrapResponseListener, String str3) {
        File file;
        String str4;
        boolean startsWith = str2.startsWith(SemanticAttributes.FaasTriggerValues.HTTP);
        APFileDownloadRspAdapter loadMeidaSync = DownloadFileUtils.loadMeidaSync(str2, str3, null);
        if (loadMeidaSync == null) {
            wrapResponseListener.onError("下载失败: rsp == null");
        } else if (!TextUtils.equals(loadMeidaSync.getCloudId(), str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("下载失败: 下载文件结果不一致，返回文件id为：");
            sb.append(loadMeidaSync.getCloudId());
            sb.append(",url=");
            sb.append(str2);
            wrapResponseListener.onError(sb.toString());
        } else {
            if ((!startsWith) == false) {
                str4 = loadMeidaSync.getSavePath();
                file = null;
            } else if (!DownloadFileUtils.unzipLottieFontSync(str2, loadMeidaSync.getSavePath())) {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[6] - 1);
                Object[] objArr = new Object[1];
                a(b, b, r8[28], objArr);
                wrapResponseListener.onError((String) objArr[0]);
                str4 = null;
                file = null;
            } else {
                File lottieFontUnzipDir = DownloadFileUtils.getLottieFontUnzipDir(str2);
                if (lottieFontUnzipDir == null || !lottieFontUnzipDir.exists()) {
                    wrapResponseListener.onError("font dir is null.");
                    return;
                }
                File[] listFiles = lottieFontUnzipDir.listFiles(new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.6
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file2, String str5) {
                        return str5.toLowerCase().endsWith(".ttf");
                    }
                });
                if (listFiles == null || listFiles.length == 0) {
                    DownloadFileUtils.delFile(lottieFontUnzipDir);
                    wrapResponseListener.onError("there is no .ttf file in fontDir.");
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fontDir file path: ");
                sb2.append(lottieFontUnzipDir.getAbsolutePath());
                GriverLogger.d(TAG, sb2.toString());
                String absolutePath = listFiles[0].getAbsolutePath();
                file = lottieFontUnzipDir;
                str4 = absolutePath;
            }
            try {
                Typeface createFromFile = Typeface.createFromFile(str4);
                if (createFromFile != null) {
                    lottieParams.getFonts().put(str, createFromFile);
                    wrapResponseListener.onSuccess(null, str4);
                } else {
                    wrapResponseListener.onError("从文件创建font失败");
                }
                if (file != null) {
                    LottieCleanUtil.updateLastVisitTimeFile(file);
                }
            } catch (Exception e) {
                wrapResponseListener.onError(e.toString());
            }
        }
    }

    public static int getResourceFromDjangoIdSync(String str, String str2) {
        LottieCleanUtil.cleanLottie();
        APFileDownloadRspAdapter loadMeidaSync = DownloadFileUtils.loadMeidaSync(str, "MULTI_MEDIA_BIZ_TYPE", str2);
        if (loadMeidaSync == null) {
            return 1;
        }
        if (loadMeidaSync.getRetCode() == 4) {
            return 7;
        }
        if (DownloadFileUtils.unzipLottieSync(str, loadMeidaSync.getSavePath())) {
            File lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(str);
            if (lottieUnzipDir == null || !lottieUnzipDir.exists()) {
                return 3;
            }
            File[] listFiles = lottieUnzipDir.listFiles(new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.player.LottieHelper.7
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str3) {
                    return str3.endsWith(".json");
                }
            });
            if (listFiles == null || listFiles.length == 0) {
                DownloadFileUtils.delFile(lottieUnzipDir);
                return 4;
            }
            File file = listFiles[0];
            if (file.length() == 0) {
                return 5;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("lottie file path: ");
            sb.append(file.getAbsolutePath());
            GriverLogger.d(TAG, sb.toString());
            LottieCleanUtil.updateLastVisitTimeFile(lottieUnzipDir);
            return 0;
        }
        return 2;
    }

    public static HashMap<String, String> getAssetsFromJson(JSONObject jSONObject) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        JSONArray jSONArray = jSONObject.getJSONArray(SceneType.ASSETS);
        for (int i = 0; i < jSONArray.size(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2.containsKey(BranchLinkConstant.PayloadKey.PROMO_CODE)) {
                if (jSONObject2.containsKey("u")) {
                    str = jSONObject2.getString("u");
                    if (str.startsWith("/")) {
                        str = str.substring(1, str.length());
                    }
                    if (!str.endsWith("/")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append("/");
                        str = sb.toString();
                    }
                } else {
                    str = "";
                }
                String string = jSONObject2.getString("id");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(jSONObject2.getString(BranchLinkConstant.PayloadKey.PROMO_CODE));
                hashMap.put(string, sb2.toString());
            }
        }
        return hashMap;
    }

    public static HashMap<String, String> prepareAssets(JsonReader jsonReader) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            String str = "";
            String str2 = "";
            String str3 = str2;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 112) {
                    if (hashCode != 117) {
                        if (hashCode == 3355 && nextName.equals("id")) {
                            c = 2;
                        }
                    } else if (nextName.equals("u")) {
                        c = 1;
                    }
                } else if (nextName.equals(BranchLinkConstant.PayloadKey.PROMO_CODE)) {
                    c = 0;
                }
                if (c == 0) {
                    str = jsonReader.nextString();
                } else if (c == 1) {
                    str2 = jsonReader.nextString();
                } else if (c == 2) {
                    str3 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    str = sb.toString();
                }
                hashMap.put(str3, str);
            }
        }
        jsonReader.endArray();
        return hashMap;
    }

    public static HashMap<String, String> prepareFonts(JsonReader jsonReader) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            String str = "";
            String str2 = "";
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("fName")) {
                    str = jsonReader.nextString();
                } else if (nextName.equals("fPath")) {
                    str2 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if ("${DINPRO_FONT_NAME}".equals(str)) {
                StringBuilder sb = new StringBuilder();
                byte b = BuiltInFictitiousFunctionClassFactory[28];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                sb.append((String) objArr[0]);
                sb.append(NumberFontUtilAdapter.getDINProTtfPath());
                str2 = sb.toString();
            } else if ("${ALIPAY_NUM_FONT_NAME}".equals(str)) {
                StringBuilder sb2 = new StringBuilder();
                byte b3 = BuiltInFictitiousFunctionClassFactory[28];
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                sb2.append((String) objArr2[0]);
                sb2.append(NumberFontUtilAdapter.getAlipayNumberTtfPath());
                str2 = sb2.toString();
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                hashMap.put(str, str2);
            }
        }
        jsonReader.endArray();
        return hashMap;
    }

    public static PlayersModel preparePlayControl(JsonReader jsonReader, LottiePlayer lottiePlayer) throws IOException {
        PlayersModel playersModel = new PlayersModel();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        ArrayList arrayList2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("frameControl")) {
                parseFrameControl(jsonReader, lottiePlayer, arrayList);
            } else if (nextName.equals("frameControl_android")) {
                arrayList2 = new ArrayList();
                parseFrameControl(jsonReader, lottiePlayer, arrayList2);
            } else if (nextName.equals(LottieParams.KEY_RENDER_TYPE)) {
                playersModel.renderType = jsonReader.nextString();
            } else if (nextName.equals("client")) {
                playersModel.minVersion = parseClientMinVersion(jsonReader);
            } else if (nextName.equals("dynamicLayer")) {
                try {
                    playersModel.dynamicLayerModels = parseDynamicLayerModelList(jsonReader);
                } catch (Exception unused) {
                    playersModel.dynamicLayerModels = null;
                }
            } else if (nextName.equals("dynamicLayerEnable")) {
                playersModel.dynamicLayerEnable = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        playersModel.frameControl = (AbstractPlayCommand[]) arrayList.toArray(new AbstractPlayCommand[arrayList.size()]);
        return playersModel;
    }

    private static RectF parsePlaceholderRect(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        jsonReader.endArray();
        if (arrayList.size() >= 4) {
            return new RectF(((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue(), ((Float) arrayList.get(0)).floatValue() + ((Float) arrayList.get(2)).floatValue(), ((Float) arrayList.get(1)).floatValue() + ((Float) arrayList.get(3)).floatValue());
        }
        return null;
    }

    private static String parseClientMinVersion(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("minVersion")) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return str;
    }

    private static void parseFrameControl(JsonReader jsonReader, LottiePlayer lottiePlayer, List<AbstractPlayCommand> list) throws IOException {
        jsonReader.beginArray();
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 3553) {
                    if (hashCode != 100571) {
                        if (hashCode != 109757538) {
                            if (hashCode == 1571519540 && nextName.equals(LottieParams.KEY_REPEAT_COUNT)) {
                                c = 3;
                            }
                        } else if (nextName.equals("start")) {
                            c = 2;
                        }
                    } else if (nextName.equals("end")) {
                        c = 1;
                    }
                } else if (nextName.equals("op")) {
                    c = 0;
                }
                if (c == 0) {
                    str = jsonReader.nextString();
                } else if (c == 1) {
                    i2 = jsonReader.nextInt();
                } else if (c == 2) {
                    i3 = jsonReader.nextInt();
                } else if (c == 3) {
                    i = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if ("final".equals(str)) {
                list.add(new FinalPlayCommand());
            } else {
                list.add(new FramePlayCommand(lottiePlayer, i3, i2, i));
            }
        }
        jsonReader.endArray();
    }

    public static String replaceLottieStringWithParams(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            GriverLogger.w(TAG, "replaceLottieStringWithParams: lottie json is empty ");
            return str;
        }
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (String str2 : map.keySet()) {
                if (!str2.startsWith("TEXT@") || !str2.endsWith(AUScreenAdaptTool.PREFIX_ID)) {
                    hashMap.put(str2, map.get(str2));
                }
            }
        }
        if (hashMap.isEmpty()) {
            GriverLogger.w(TAG, "replaceLottieStringWithParams: lottie params is empty ");
            return str;
        }
        return StringUtils.replaceEach(str, (String[]) hashMap.keySet().toArray(new String[0]), (String[]) hashMap.values().toArray(new String[0]));
    }

    public static String getTinyFullPath(String str) {
        return H5UtilsAdapter.getTinyFullPath(str);
    }

    public static Map<String, String> prepareParamsConfig(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("key")) {
                    str = jsonReader.nextString();
                } else if (nextName.equals("type")) {
                    str2 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("prepareParamsConfig:参数异常:");
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                GriverLogger.w(TAG, sb.toString());
            }
        }
        jsonReader.endArray();
        return hashMap;
    }

    public static AntmationRuntimeModel prepareRuntimeConfig(JsonReader jsonReader) throws IOException {
        AntmationRuntimeModel antmationRuntimeModel = new AntmationRuntimeModel();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("id")) {
                antmationRuntimeModel.f6388id = jsonReader.nextString();
            } else if (nextName.equals("type")) {
                antmationRuntimeModel.type = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return antmationRuntimeModel;
    }

    public static List<PreloadModel> preparePreload(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("key")) {
                    str = jsonReader.nextString();
                } else if (nextName.equals("path")) {
                    str2 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                PreloadModel preloadModel = new PreloadModel();
                preloadModel.key = str;
                preloadModel.path = str2;
                arrayList.add(preloadModel);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("preparePreload:参数异常:");
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                GriverLogger.w(TAG, sb.toString());
            }
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static List<String> prepareMarsImageList(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String str = null;
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("url")) {
                    str = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static MarsRuntimeModel prepareMarsRuntime(JsonReader jsonReader) throws IOException {
        MarsRuntimeModel marsRuntimeModel = new MarsRuntimeModel();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("url")) {
                marsRuntimeModel.url = jsonReader.nextString();
            } else if (nextName.equals("type")) {
                marsRuntimeModel.type = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return marsRuntimeModel;
    }

    public static boolean containDowngradeFileInZip(String str) {
        File lottieUnzipDir;
        String[] list;
        return !SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_downgrade_local_path_disable")) && (lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(str)) != null && lottieUnzipDir.exists() && lottieUnzipDir.isDirectory() && (list = lottieUnzipDir.list(downgradeInZipFilenameFilter)) != null && list.length > 0;
    }

    public static String getLocalDowngradeFilePath(String str) {
        File lottieUnzipDir;
        String[] list;
        if (!SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_downgrade_local_path_disable")) && (lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(str)) != null && lottieUnzipDir.exists() && lottieUnzipDir.isDirectory() && (list = lottieUnzipDir.list(downgradeInZipFilenameFilter)) != null && list.length > 0) {
            String str2 = list[0];
            if (list.length > 1 && "placeHolder.png".equals(str2)) {
                str2 = list[1];
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PhotoContext.FILE_SCHEME);
            sb.append(lottieUnzipDir.getAbsolutePath());
            sb.append(File.separator);
            sb.append(str2);
            return sb.toString();
        }
        return "";
    }

    public static String getLocalPlaceHolderFilePath(String str) {
        File lottieUnzipDir;
        if (!SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_downgrade_local_path_disable")) && (lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(str)) != null && lottieUnzipDir.exists() && lottieUnzipDir.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            sb.append(lottieUnzipDir.getAbsolutePath());
            sb.append(File.separator);
            sb.append("placeHolder.png");
            String obj = sb.toString();
            if (new File(obj).exists()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(PhotoContext.FILE_SCHEME);
                sb2.append(obj);
                return sb2.toString();
            }
        }
        return "";
    }

    public static String getAssetDowngradeFilePath(String str) {
        String str2 = "";
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_downgrade_asset_path_disable"))) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str3 = null;
            if (!str.endsWith("/")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/");
                str = sb.toString();
            }
            String[] listAssetsDir = listAssetsDir(ApplicationAapter.getApplicationContext(), str);
            int length = listAssetsDir.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str4 = listAssetsDir[i];
                if ("placeHolder.png".equals(str4)) {
                    StringBuilder sb2 = new StringBuilder();
                    byte b = BuiltInFictitiousFunctionClassFactory[28];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    sb2.append((String) objArr[0]);
                    sb2.append(str);
                    sb2.append("placeHolder.png");
                    str3 = sb2.toString();
                }
                if ("downgrade.png".equals(str4)) {
                    StringBuilder sb3 = new StringBuilder();
                    byte b3 = BuiltInFictitiousFunctionClassFactory[28];
                    byte b4 = b3;
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    sb3.append((String) objArr2[0]);
                    sb3.append(str);
                    sb3.append("downgrade.png");
                    str2 = sb3.toString();
                    break;
                }
                i++;
            }
            return TextUtils.isEmpty(str2) ? !TextUtils.isEmpty(str3) ? str3 : str2 : str2;
        } catch (Exception e) {
            GriverLogger.e(TAG, "getAssetDowngradeFilePath异常:", e);
            return str2;
        }
    }

    public static String getAssetPlaceHolderFilePath(String str) {
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_downgrade_asset_path_disable"))) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.endsWith("/")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/");
                str = sb.toString();
            }
            for (String str2 : listAssetsDir(ApplicationAapter.getApplicationContext(), str)) {
                if ("placeHolder.png".equals(str2)) {
                    StringBuilder sb2 = new StringBuilder();
                    byte b = BuiltInFictitiousFunctionClassFactory[28];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    sb2.append((String) objArr[0]);
                    sb2.append(str);
                    sb2.append("placeHolder.png");
                    return sb2.toString();
                }
            }
            return "";
        } catch (Exception e) {
            GriverLogger.e(TAG, "getAssetPlaceHolderFilePath异常:", e);
            return "";
        }
    }

    public static boolean containDowngradeFileInAsset(String str) {
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_downgrade_asset_path_disable")) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith(".json")) {
            str = str.substring(0, str.lastIndexOf("/"));
        }
        return !TextUtils.isEmpty(getAssetDowngradeFilePath(str));
    }

    public static String[] listAssetsDir(Context context, String str) throws IOException {
        String substring = str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        String[] list = context.getAssets().list(substring);
        return (list.length != 0 || substring == str) ? list : context.getAssets().list(str);
    }

    public static boolean checkMinVersionSupport(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (clientVersionIntArray == null) {
                    Application applicationContext = ApplicationAapter.getApplicationContext();
                    String[] split = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName.split("\\.");
                    clientVersionIntArray = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        clientVersionIntArray[i] = Integer.parseInt(split[i]);
                    }
                }
                String[] split2 = str.split("\\.");
                int length = split2.length;
                int[] iArr = clientVersionIntArray;
                int length2 = length > iArr.length ? iArr.length : split2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    if (clientVersionIntArray[i2] < Integer.parseInt(split2[i2])) {
                        return false;
                    }
                    if (clientVersionIntArray[i2] > Integer.parseInt(split2[i2])) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                GriverLogger.e(TAG, "checkMinVersionSupport exception:", th);
            }
        }
        return true;
    }

    public static List<DynamicLayerModel> paraseDynamicLayerModelListByParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parseDynamicLayerModelList(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))));
        } catch (Exception unused) {
            return null;
        }
    }

    private static List<DynamicLayerModel> parseDynamicLayerModelList(JsonReader jsonReader) throws Exception {
        jsonReader.beginObject();
        ArrayList arrayList = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1886746083) {
                if (hashCode != 112202875) {
                    if (hashCode == 450080383 && nextName.equals("countdownInfo")) {
                        c = 2;
                    }
                } else if (nextName.equals("video")) {
                    c = 1;
                }
            } else if (nextName.equals("multiActionInfo")) {
                c = 0;
            }
            if (c == 0) {
                List<DynamicLayerModel> parseClickLayerModelList = parseClickLayerModelList(jsonReader);
                if (parseClickLayerModelList != null && parseClickLayerModelList.size() > 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(parseClickLayerModelList);
                }
            } else if (c != 1) {
                if (c == 2) {
                    List<DynamicLayerModel> parseTimerLayerModelList = parseTimerLayerModelList(jsonReader);
                    if (parseTimerLayerModelList != null && parseTimerLayerModelList.size() > 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.addAll(parseTimerLayerModelList);
                    }
                } else {
                    jsonReader.skipValue();
                }
            }
        }
        jsonReader.endObject();
        return arrayList;
    }

    private static List<DynamicLayerModel> parseClickLayerModelList(JsonReader jsonReader) throws Exception {
        jsonReader.beginObject();
        ArrayList arrayList = null;
        List<DynamicLayerModel> list = null;
        List<DynamicLayerModel> list2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("clickRect")) {
                list = parseClickRectModelList(jsonReader);
            } else if (nextName.equals("clickAction")) {
                list2 = parseClickActionModelList(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
            for (DynamicLayerModel dynamicLayerModel : list) {
                for (DynamicLayerModel dynamicLayerModel2 : list2) {
                    if (TextUtils.equals(dynamicLayerModel2.layerId, dynamicLayerModel.layerId)) {
                        dynamicLayerModel.dynamicLayerAction = dynamicLayerModel2.dynamicLayerAction;
                    }
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            arrayList = new ArrayList();
            arrayList.addAll(list2);
        }
        if (list != null && list.size() > 0) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.addAll(list);
        }
        return arrayList;
    }

    private static List<DynamicLayerModel> parseClickActionModelList(JsonReader jsonReader) throws Exception {
        jsonReader.beginObject();
        ArrayList arrayList = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.startsWith("__antmation_click")) {
                String nextString = jsonReader.nextString();
                DynamicLayerModel dynamicLayerModel = new DynamicLayerModel();
                dynamicLayerModel.layerId = nextName;
                dynamicLayerModel.forAim = DynamicLayerModel.FOR_ANIMATION;
                dynamicLayerModel.type = DynamicLayerModel.TYPE_CLICK;
                dynamicLayerModel.dynamicLayerAction = new DynamicLayerAction(!TextUtils.isEmpty(nextString), nextString);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(dynamicLayerModel);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return arrayList;
    }

    private static List<DynamicLayerModel> parseClickRectModelList(JsonReader jsonReader) throws Exception {
        RectF rectF;
        jsonReader.beginObject();
        ArrayList arrayList = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.startsWith("__antmation_click")) {
                rectF = parsePlaceholderRect(jsonReader);
            } else {
                jsonReader.skipValue();
                rectF = null;
            }
            DynamicLayerModel dynamicLayerModel = new DynamicLayerModel();
            dynamicLayerModel.layerId = nextName;
            dynamicLayerModel.forAim = "image";
            dynamicLayerModel.type = DynamicLayerModel.TYPE_CLICK;
            dynamicLayerModel.rect = rectF;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dynamicLayerModel);
        }
        jsonReader.endObject();
        return arrayList;
    }

    private static List<DynamicLayerModel> parseTimerLayerModelList(JsonReader jsonReader) throws Exception {
        jsonReader.beginObject();
        ArrayList arrayList = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        RectF rectF = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2130204763:
                    if (nextName.equals("deadlineText")) {
                        c = 0;
                        break;
                    }
                    break;
                case -41955764:
                    if (nextName.equals("layerId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3496420:
                    if (nextName.equals("rect")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3556653:
                    if (nextName.equals("text")) {
                        c = 3;
                        break;
                    }
                    break;
                case 503634520:
                    if (nextName.equals("deadline")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                str4 = jsonReader.nextString();
            } else if (c == 1) {
                str = jsonReader.nextString();
            } else if (c == 2) {
                rectF = parsePlaceholderRect(jsonReader);
            } else if (c == 3) {
                str2 = jsonReader.nextString();
            } else if (c == 4) {
                str3 = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (!TextUtils.isEmpty(str)) {
            DynamicLayerModel dynamicLayerModel = new DynamicLayerModel();
            dynamicLayerModel.layerId = str;
            dynamicLayerModel.forAim = DynamicLayerModel.FOR_ANIMATION;
            dynamicLayerModel.type = "timer";
            dynamicLayerModel.setTimerParams(new TimerLayerModel(str2, Long.parseLong(str3), str4));
            arrayList = new ArrayList();
            arrayList.add(dynamicLayerModel);
        }
        if (!TextUtils.isEmpty(str) && rectF != null) {
            DynamicLayerModel dynamicLayerModel2 = new DynamicLayerModel();
            dynamicLayerModel2.layerId = str;
            dynamicLayerModel2.forAim = "image";
            dynamicLayerModel2.type = "timer";
            dynamicLayerModel2.setTimerParams(new TimerLayerModel(str2, Long.parseLong(str3), str4));
            dynamicLayerModel2.rect = rectF;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dynamicLayerModel2);
        }
        return arrayList;
    }
}
