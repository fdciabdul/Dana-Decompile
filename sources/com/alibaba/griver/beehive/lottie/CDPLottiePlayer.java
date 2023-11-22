package com.alibaba.griver.beehive.lottie;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.APDecodeResultAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.APImageInfoAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.APImageQueryResultAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.beehive.lottie.downgrade.DowngradeRuler;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.alibaba.griver.beehive.lottie.player.GrayHelper;
import com.alibaba.griver.beehive.lottie.player.ILottieDataStatus;
import com.alibaba.griver.beehive.lottie.player.LottieHelper;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.beehive.lottie.player.LottiePlayer;
import com.alibaba.griver.beehive.lottie.util.DeviceUtils;
import com.alibaba.griver.beehive.lottie.util.DownloadFileUtils;
import com.alibaba.griver.beehive.lottie.util.LottieCleanUtil;
import com.alibaba.griver.beehive.lottie.util.MultiThreadUtils;
import com.alibaba.griver.image.framework.utils.Format;
import com.alibaba.griver.lottie.LottieAnimationView;
import com.alibaba.griver.lottie.LottieComposition;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes6.dex */
public class CDPLottiePlayer extends LottiePlayer {
    public static final int ERROR_DECODE_PLACEHOLDER_FAILED = 13;
    public static final int ERROR_DOWNLOAD_PLACEHOLDER_TIMEOUT = 17;
    public static final int ERROR_GET_LOTTIE_FAILED = 12;
    public static final int ERROR_GET_PLACEHOLDER_FAILED = 14;
    public static final int ERROR_ILLEGAL_PARAMETER = 11;
    public static final int ERROR_LOTTIE_DIR_CREATE_FAILED = 3;
    public static final int ERROR_LOTTIE_FILE_IS_EMPTY = 5;
    public static final int ERROR_LOTTIE_MD5_WRONG = 7;
    public static final int ERROR_PARSE_LOTTIE_JSON_FAILED = 15;
    public static final int ERROR_READ_LOTTIE_DIR_FAILED = 4;
    public static final int ERROR_READ_LOTTIE_FAILED = 6;
    public static final int ERROR_RESPONSE_IS_NULL = 1;
    public static final int ERROR_SYSTEM_ERROR = 16;
    public static final int ERROR_UNZIP_FAILED = 2;
    private static final String TAG = "CDPLottiePlayer";
    private ILottieDataStatus bizLottieDataStatus;
    private boolean canDowngradeOnEmptyPlaceHolder;
    private String downgrade;
    private String dynamicLayer;
    private List<DynamicLayerModel> dynamicLayerModelList;
    private int loadPlaceholderCount;
    private String lottieDjangoId;
    private String lottieMd5;
    private boolean optimize;
    private LottieParams params;
    private String placeHolderDjangoId;
    private String scene;
    private boolean variableLottie;
    private Map<String, String> variableLottieParams;

    /* loaded from: classes6.dex */
    public static abstract class LottieInitCallback {
        public abstract void onFail(int i, String str);

        public void onSuccess(boolean z, Rect rect) {
        }

        @Deprecated
        public void onSuccess(boolean z, LottieComposition lottieComposition) {
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class ResourceLoadCallback {
        public abstract void onFail(int i, String str);

        public abstract void onSuccess();
    }

    public CDPLottiePlayer(Context context, String str, String str2, String str3, boolean z) {
        super(context, DanaLogConstants.BizType.CDP);
        this.canDowngradeOnEmptyPlaceHolder = false;
        this.loadPlaceholderCount = 0;
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str);
        this.lottieMd5 = str2;
        this.placeHolderDjangoId = str3;
        this.optimize = z;
    }

    public CDPLottiePlayer(Context context, String str, String str2, String str3, String str4, boolean z) {
        super(context, str);
        this.canDowngradeOnEmptyPlaceHolder = false;
        this.loadPlaceholderCount = 0;
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str2);
        this.lottieMd5 = str3;
        this.placeHolderDjangoId = str4;
        this.optimize = z;
    }

    public CDPLottiePlayer(Context context, String str, String str2, String str3, boolean z, boolean z2) {
        super(context);
        this.canDowngradeOnEmptyPlaceHolder = false;
        this.loadPlaceholderCount = 0;
        this.lottieMd5 = str;
        this.optimize = z2;
        this.placeHolderDjangoId = str2;
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str3);
        this.variableLottie = z;
    }

    public void setLottieMd5(String str) {
        this.lottieMd5 = str;
    }

    public void setOptimize(boolean z) {
        this.optimize = z;
    }

    public void setPlaceHolderDjangoId(String str) {
        this.placeHolderDjangoId = str;
    }

    public void setLottieDjangoId(String str) {
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str);
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public CDPLottiePlayer(Context context, String str, String str2, String str3, boolean z, String str4) {
        super(context, DanaLogConstants.BizType.CDP);
        this.canDowngradeOnEmptyPlaceHolder = false;
        this.loadPlaceholderCount = 0;
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str);
        this.lottieMd5 = str2;
        this.placeHolderDjangoId = str3;
        this.optimize = z;
        this.scene = str4;
    }

    public CDPLottiePlayer(Context context, String str, String str2, String str3, String str4, boolean z, String str5) {
        super(context, str);
        this.canDowngradeOnEmptyPlaceHolder = false;
        this.loadPlaceholderCount = 0;
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str2);
        this.lottieMd5 = str3;
        this.placeHolderDjangoId = str4;
        this.optimize = z;
        this.scene = str5;
    }

    public CDPLottiePlayer(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        super(context);
        this.canDowngradeOnEmptyPlaceHolder = false;
        this.loadPlaceholderCount = 0;
        this.lottieMd5 = str;
        this.optimize = z2;
        this.placeHolderDjangoId = str2;
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str3);
        this.variableLottie = z;
        this.scene = str4;
    }

    public CDPLottiePlayer(Context context, String str) {
        super(context, str);
        this.canDowngradeOnEmptyPlaceHolder = false;
        this.loadPlaceholderCount = 0;
    }

    public boolean isCanDowngradeOnEmptyPlaceHolder() {
        return this.canDowngradeOnEmptyPlaceHolder;
    }

    public void setCanDowngradeOnEmptyPlaceHolder(boolean z) {
        this.canDowngradeOnEmptyPlaceHolder = z;
    }

    public void initLottieAnimationAsync(final LottieInitCallback lottieInitCallback) {
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.1
            @Override // java.lang.Runnable
            public void run() {
                if (CDPLottiePlayer.checkLottieResourceIsReady(CDPLottiePlayer.this.lottieDjangoId, CDPLottiePlayer.this.placeHolderDjangoId, CDPLottiePlayer.this.optimize, CDPLottiePlayer.this.scene, CDPLottiePlayer.this.canDowngradeOnEmptyPlaceHolder)) {
                    GriverLogger.d(CDPLottiePlayer.TAG, "initLottieAnimationAsync：资源已准备好，直接初始化LottieAnimationView");
                    CDPLottiePlayer.this.initLottieAnimationSync(lottieInitCallback);
                    return;
                }
                GriverLogger.d(CDPLottiePlayer.TAG, "initLottieAnimationAsync：资源未准备好，准备下载资源...");
                if (!CDPLottiePlayer.isJustLoadPlaceHolder(CDPLottiePlayer.this.lottieDjangoId, CDPLottiePlayer.this.placeHolderDjangoId, CDPLottiePlayer.this.optimize, CDPLottiePlayer.this.scene, CDPLottiePlayer.this.canDowngradeOnEmptyPlaceHolder)) {
                    CDPLottiePlayer.this.preparePlaceHolderFirst();
                }
                CDPLottiePlayer.loadLottieResource(CDPLottiePlayer.this.lottieDjangoId, CDPLottiePlayer.this.lottieMd5, CDPLottiePlayer.this.placeHolderDjangoId, CDPLottiePlayer.this.optimize, new ResourceLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.1.1
                    @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.ResourceLoadCallback
                    public void onSuccess() {
                        GriverLogger.d(CDPLottiePlayer.TAG, "initLottieAnimationAsync：资源下载成功");
                        CDPLottiePlayer.this.initLottieAnimationSync(lottieInitCallback);
                    }

                    @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.ResourceLoadCallback
                    public void onFail(int i, String str) {
                        CDPLottiePlayer.this.fireOnFail(lottieInitCallback, i, str);
                    }
                }, CDPLottiePlayer.this.scene, CDPLottiePlayer.this.canDowngradeOnEmptyPlaceHolder, CDPLottiePlayer.this.mSource);
            }
        });
    }

    public void initLottieAnimationSync(LottieInitCallback lottieInitCallback) {
        this.params = new LottieParams();
        File lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(this.lottieDjangoId);
        this.params.setDjangoId(this.lottieDjangoId);
        this.params.setLottieFile(lottieUnzipDir);
        this.params.setPlaceholder(this.placeHolderDjangoId);
        this.params.setMd5(this.lottieMd5);
        this.params.setOptimize(this.optimize);
        this.params.setVariableLottie(this.variableLottie);
        this.params.setRepeatCount(-1);
        this.params.setLottieParams(this.variableLottieParams);
        this.params.setScene(this.scene);
        if (!TextUtils.isEmpty(this.downgrade)) {
            this.params.setDowngrade(this.downgrade);
        }
        if (!TextUtils.isEmpty(this.dynamicLayer)) {
            this.dynamicLayerModelList = LottieHelper.paraseDynamicLayerModelListByParams(this.dynamicLayer);
        }
        List<DynamicLayerModel> list = this.dynamicLayerModelList;
        if (list != null && list.size() > 0) {
            this.params.setDynamicLayerModelList(this.dynamicLayerModelList);
        }
        setLottieParam(this.params);
        boolean isJustLoadPlaceHolder = isJustLoadPlaceHolder(this.lottieDjangoId, this.placeHolderDjangoId, this.optimize, this.scene, this.canDowngradeOnEmptyPlaceHolder);
        String downgradeFile = getDowngradeFile(this.lottieDjangoId, this.placeHolderDjangoId);
        if (isJustLoadPlaceHolder && !TextUtils.isEmpty(downgradeFile)) {
            initPlaceholder(lottieInitCallback);
        } else if (isJustLoadPlaceHolder && TextUtils.isEmpty(downgradeFile)) {
            StringBuilder sb = new StringBuilder();
            sb.append("兜底图为空，降级失败.DjangoId=");
            sb.append(this.lottieDjangoId);
            sb.append(",scene=");
            sb.append(this.scene);
            GriverLogger.e(TAG, sb.toString());
            fireOnFail(lottieInitCallback, 14, "兜底图为空，降级失败.");
        } else {
            initAnimation(lottieInitCallback);
        }
    }

    private void initAnimation(final LottieInitCallback lottieInitCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("不降级，准备加载动画：");
        sb.append(this.lottieDjangoId);
        sb.append(":");
        sb.append(this.placeHolderDjangoId);
        sb.append(":");
        sb.append(this.optimize);
        GriverLogger.d(TAG, sb.toString());
        preparePlaceHolderFirst();
        if (this.params.isVariableLottie() && this.variableLottieParams == null) {
            GriverLogger.d(TAG, "参数化 lottie 动画，等待调用 fillVariableValue");
            setOnFillVariableValueListener(new LottiePlayer.OnFillVariableValueListener() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.2
                @Override // com.alibaba.griver.beehive.lottie.player.LottiePlayer.OnFillVariableValueListener
                public void onFillVariableValue(Map<String, String> map) {
                    CDPLottiePlayer.this.params.setLottieParams(map);
                    CDPLottiePlayer cDPLottiePlayer = CDPLottiePlayer.this;
                    cDPLottiePlayer.parseLottieUnZipFile(cDPLottiePlayer.params, lottieInitCallback);
                }
            });
            return;
        }
        parseLottieUnZipFile(this.params, lottieInitCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preparePlaceHolderFirst() {
        if (!this.loadPlaceholderFirst || this.hasLoadPlaceholder) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preparePlaceHolderFirst,loadPlaceholderFirst=");
        sb.append(this.loadPlaceholderFirst);
        sb.append(",hasLoadPlaceholder=");
        sb.append(this.hasLoadPlaceholder);
        GriverLogger.d(TAG, sb.toString());
        preparePlaceHolder(this.placeHolderDjangoId, false, true, null);
    }

    public void initPlaceholder(final LottieInitCallback lottieInitCallback) {
        boolean isAnimationFile;
        this.mIsLoadSuccess = false;
        this.mFailedMessage = "到兜底图降级";
        String downgradeFile = getDowngradeFile(this.lottieDjangoId, this.placeHolderDjangoId);
        StringBuilder sb = new StringBuilder();
        sb.append("降级暂时，只显示placeHolder：");
        sb.append(this.lottieDjangoId);
        sb.append(":");
        sb.append(downgradeFile);
        sb.append(":");
        sb.append(this.optimize);
        GriverLogger.d(TAG, sb.toString());
        APImageQueryResultAdapter doImageQuery = MultimediaServiceAdapter.doImageQuery(downgradeFile);
        if (doImageQuery != null && doImageQuery.success) {
            this.lottieRect = new Rect(0, 0, doImageQuery.width, doImageQuery.height);
            String str = doImageQuery.path;
            if (!TextUtils.isEmpty(downgradeFile) && downgradeFile.startsWith("file:///[asset]/") && downgradeFile.endsWith(Format.SUFFIX_GIF)) {
                str = downgradeFile;
                isAnimationFile = true;
            } else {
                isAnimationFile = MultimediaServiceAdapter.isAnimationFile(doImageQuery.path);
            }
            if (isAnimationFile) {
                this.isDowngrade = true;
                this.animationPlaceHolderFilePath = str;
                APImageInfoAdapter parseImageInfo = MultimediaServiceAdapter.parseImageInfo(doImageQuery.path);
                this.lottieRect.set(0, 0, parseImageInfo.width, parseImageInfo.height);
                this.placeHolderAnimationInited = true;
                downgradeToPlaceholder();
                fireOnSuccess(lottieInitCallback, this.lottieRect, true);
                return;
            }
            try {
                final APDecodeResultAdapter decodeBitmap = MultimediaServiceAdapter.decodeBitmap(new File(doImageQuery.path));
                if (decodeBitmap != null && decodeBitmap.isSuccess()) {
                    this.lottieRect.set(0, 0, decodeBitmap.bitmap.getWidth(), decodeBitmap.bitmap.getHeight());
                    MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.3
                        @Override // java.lang.Runnable
                        public void run() {
                            CDPLottiePlayer.this.mPlaceholder.setImageBitmap(decodeBitmap.bitmap);
                            CDPLottiePlayer.this.downgradeToPlaceholder();
                            CDPLottiePlayer cDPLottiePlayer = CDPLottiePlayer.this;
                            cDPLottiePlayer.fireOnSuccess(lottieInitCallback, cDPLottiePlayer.lottieRect, true);
                        }
                    });
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("解码缓存图片失败：");
                sb2.append(downgradeFile);
                sb2.append(",图片解码失败,");
                sb2.append(decodeBitmap);
                GriverLogger.w(TAG, sb2.toString());
                fireOnFail(lottieInitCallback, 13, "解码placeHolder图片缓存失败");
                return;
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("解码缓存图片失败：");
                sb3.append(downgradeFile);
                sb3.append(",");
                sb3.append(th.getLocalizedMessage());
                GriverLogger.w(TAG, sb3.toString());
                fireOnFail(lottieInitCallback, 13, "解码placeHolder图片缓存失败");
                return;
            }
        }
        int i = this.loadPlaceholderCount + 1;
        this.loadPlaceholderCount = i;
        if (i > 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("placeHolder资源下载成功(下载触发多次)，读取placeHolder失败（缓存文件可能被删除）:");
            sb4.append(downgradeFile);
            GriverLogger.w(TAG, sb4.toString());
            fireOnFail(lottieInitCallback, 12, "placeHolder资源多次下载成功，读取placeHolder失败.缓存文件可能被删除");
            this.loadPlaceholderCount = 0;
            return;
        }
        loadPlaceholderResource(this.lottieDjangoId, downgradeFile, new ResourceLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.4
            @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.ResourceLoadCallback
            public void onSuccess() {
                CDPLottiePlayer.this.initPlaceholder(lottieInitCallback);
            }

            @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.ResourceLoadCallback
            public void onFail(int i2, String str2) {
                CDPLottiePlayer.this.fireOnFail(lottieInitCallback, i2, str2);
            }
        });
    }

    public void parseLottieUnZipFile(LottieParams lottieParams, final LottieInitCallback lottieInitCallback) {
        FileInputStream fileInputStream;
        File lottieFile = lottieParams.getLottieFile();
        File[] listFiles = lottieFile.listFiles(new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.5
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            lottieParams.getRenderType();
            File file = listFiles[0];
            if (listFiles.length > 1) {
                for (File file2 : listFiles) {
                    if (LottieConstants.RENDER_TYPE_ANTMATIONS.equals(lottieParams.getRenderType())) {
                        if ("antmation.json".equals(file2.getName())) {
                            file = file2;
                            break;
                        }
                    } else if (LottieConstants.RENDER_TYPE_MARS.equals(lottieParams.getRenderType())) {
                        if ("mars.json".equals(file2.getName())) {
                            file = file2;
                            break;
                        }
                    } else {
                        if (!"antmation.json".equals(file2.getName()) && !"mars.json".equals(file2.getName())) {
                            file = file2;
                            break;
                        }
                    }
                }
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            lottieParams.setLottieJson(new String(bArr));
                            super.setLottieDataStatus(new ILottieDataStatus() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.6
                                @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
                                public void onDataLoadReady() {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("onDataLoadReady:");
                                    sb.append(CDPLottiePlayer.this.lottieDjangoId);
                                    GriverLogger.d(CDPLottiePlayer.TAG, sb.toString());
                                    if (CDPLottiePlayer.this.bizLottieDataStatus == null || CDPLottiePlayer.this.bizLottieDataStatus == this) {
                                        return;
                                    }
                                    CDPLottiePlayer.this.bizLottieDataStatus.onDataLoadReady();
                                }

                                @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
                                public void onDataReady() {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("onDataReady:");
                                    sb.append(CDPLottiePlayer.this.lottieDjangoId);
                                    GriverLogger.d(CDPLottiePlayer.TAG, sb.toString());
                                    if (CDPLottiePlayer.this.bizLottieDataStatus != null && CDPLottiePlayer.this.bizLottieDataStatus != this) {
                                        CDPLottiePlayer.this.bizLottieDataStatus.onDataReady();
                                    }
                                    CDPLottiePlayer cDPLottiePlayer = CDPLottiePlayer.this;
                                    cDPLottiePlayer.fireOnSuccess(lottieInitCallback, cDPLottiePlayer.lottieRect, false);
                                }

                                @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
                                public void onDataFailed(String str) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("onDataFailed:");
                                    sb.append(CDPLottiePlayer.this.lottieDjangoId);
                                    sb.append(",");
                                    sb.append(str);
                                    GriverLogger.e(CDPLottiePlayer.TAG, sb.toString());
                                    if (CDPLottiePlayer.this.bizLottieDataStatus != null && CDPLottiePlayer.this.bizLottieDataStatus != this) {
                                        CDPLottiePlayer.this.bizLottieDataStatus.onDataFailed(str);
                                    }
                                    CDPLottiePlayer.this.fireOnFail(lottieInitCallback, 16, str);
                                }
                            });
                            applyParams(lottieParams);
                            LottieCleanUtil.cleanLottie();
                            LottieCleanUtil.updateLastVisitTimeFile(lottieFile);
                            fileInputStream.close();
                        } catch (Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            StringBuilder sb = new StringBuilder();
                            sb.append("解释Lottie JSON出错:");
                            sb.append(this.lottieDjangoId);
                            GriverLogger.e(TAG, sb.toString(), e);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Lottie动画解释出错:");
                            sb2.append(e.getLocalizedMessage());
                            fireOnFail(lottieInitCallback, 15, sb2.toString());
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
            }
        } else {
            DownloadFileUtils.delFile(lottieFile);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("动画文件不存在:");
            sb3.append(this.lottieDjangoId);
            GriverLogger.w(TAG, sb3.toString());
            fireOnFail(lottieInitCallback, 15, "Lottie动画文件不存在");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSuccess(final LottieInitCallback lottieInitCallback, final Rect rect, final boolean z) {
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.7
            @Override // java.lang.Runnable
            public void run() {
                LottieInitCallback lottieInitCallback2 = lottieInitCallback;
                if (lottieInitCallback2 != null) {
                    lottieInitCallback2.onSuccess(z, CDPLottiePlayer.this.getComposition());
                    lottieInitCallback.onSuccess(z, rect);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnFail(final LottieInitCallback lottieInitCallback, final int i, final String str) {
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.8
            @Override // java.lang.Runnable
            public void run() {
                LottieInitCallback lottieInitCallback2 = lottieInitCallback;
                if (lottieInitCallback2 != null) {
                    lottieInitCallback2.onFail(i, str);
                }
            }
        });
    }

    public String getLottieDjangoId() {
        return this.lottieDjangoId;
    }

    public boolean isOptimize() {
        return this.optimize;
    }

    public boolean isVariableLottie() {
        return this.variableLottie;
    }

    public String getPlaceHolderDjangoId() {
        return this.placeHolderDjangoId;
    }

    @Deprecated
    public static void loadLottieResource(String str, String str2, String str3, boolean z, ResourceLoadCallback resourceLoadCallback, String str4) {
        loadLottieResource(str, str2, str3, z, resourceLoadCallback, str4, false, "MULTI_MEDIA_BIZ_TYPE");
    }

    public static void loadLottieResource(String str, String str2, final String str3, boolean z, final ResourceLoadCallback resourceLoadCallback, String str4, boolean z2, String str5) {
        final String replaceDjangoId = GrayHelper.getReplaceDjangoId(str);
        if (TextUtils.isEmpty(replaceDjangoId) && TextUtils.isEmpty(str3)) {
            GriverLogger.w(TAG, "lottieDjangoId && placeHolderImageDjangoId are not set.");
            if (resourceLoadCallback != null) {
                resourceLoadCallback.onFail(11, "lottieDjangoId && placeHolderImageDjangoId are not set.");
            }
        } else if (isJustLoadPlaceHolder(replaceDjangoId, str3, z, str4, z2)) {
            String downgradeFile = getDowngradeFile(replaceDjangoId, str3);
            if (!TextUtils.isEmpty(downgradeFile)) {
                loadPlaceholderResource(replaceDjangoId, downgradeFile, resourceLoadCallback);
                return;
            }
            File lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(replaceDjangoId);
            if (lottieUnzipDir != null && lottieUnzipDir.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("兜底图为空，降级失败.DjangoId=");
                sb.append(downgradeFile);
                sb.append(",scene=");
                sb.append(str4);
                GriverLogger.e(TAG, sb.toString());
                if (resourceLoadCallback != null) {
                    resourceLoadCallback.onFail(14, "兜底图为空，降级失败.");
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("降级，兜底图为空，下载lottie资源，检查lottie资源包里的降级图片.DjangoId=");
            sb2.append(replaceDjangoId);
            sb2.append(",scene=");
            sb2.append(str4);
            GriverLogger.e(TAG, sb2.toString());
            loadLottieResourceByDjangoId(replaceDjangoId, str2, new ResourceLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.9
                @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.ResourceLoadCallback
                public final void onSuccess() {
                    String downgradeFile2 = CDPLottiePlayer.getDowngradeFile(replaceDjangoId, str3);
                    if (resourceLoadCallback != null) {
                        if (TextUtils.isEmpty(downgradeFile2)) {
                            resourceLoadCallback.onFail(14, "兜底图为空，降级失败.");
                        } else {
                            resourceLoadCallback.onSuccess();
                        }
                    }
                }

                @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.ResourceLoadCallback
                public final void onFail(int i, String str6) {
                    ResourceLoadCallback resourceLoadCallback2 = resourceLoadCallback;
                    if (resourceLoadCallback2 != null) {
                        resourceLoadCallback2.onFail(i, str6);
                    }
                }
            }, str5);
        } else {
            loadLottieResourceByDjangoId(replaceDjangoId, str2, resourceLoadCallback, str5);
        }
    }

    @Deprecated
    public static int loadLottieResourceSync(String str, String str2, String str3, boolean z, String str4) {
        return loadLottieResourceSync(str, str2, str3, z, str4, false);
    }

    public static int loadLottieResourceSync(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        String replaceDjangoId = GrayHelper.getReplaceDjangoId(str);
        if (TextUtils.isEmpty(replaceDjangoId) && TextUtils.isEmpty(str3)) {
            return 11;
        }
        boolean isJustLoadPlaceHolder = isJustLoadPlaceHolder(replaceDjangoId, str3, z, str4, z2);
        String downgradeFile = getDowngradeFile(replaceDjangoId, str3);
        if (isJustLoadPlaceHolder && !TextUtils.isEmpty(downgradeFile)) {
            return loadPlaceholderResourceSync(downgradeFile);
        }
        if (isJustLoadPlaceHolder && TextUtils.isEmpty(downgradeFile)) {
            File lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(replaceDjangoId);
            if (lottieUnzipDir != null && lottieUnzipDir.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("兜底图为空，降级失败.DjangoId=");
                sb.append(replaceDjangoId);
                sb.append(",scene=");
                sb.append(str4);
                GriverLogger.e(TAG, sb.toString());
                return 14;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadLottieResourceSync降级，兜底图为空，下载lottie资源，检查lottie资源包里的降级图片.DjangoId=");
            sb2.append(replaceDjangoId);
            sb2.append(",scene=");
            sb2.append(str4);
            GriverLogger.e(TAG, sb2.toString());
            return (loadLottieResourceByDjangoIdSync(replaceDjangoId, str2) != 0 || TextUtils.isEmpty(getDowngradeFile(replaceDjangoId, str3))) ? 14 : 0;
        }
        return loadLottieResourceByDjangoIdSync(replaceDjangoId, str2);
    }

    private static int loadLottieResourceByDjangoIdSync(String str, String str2) {
        return LottieHelper.getResourceFromDjangoIdSync(GrayHelper.getReplaceDjangoId(str), str2);
    }

    private static int loadPlaceholderResourceSync(String str) {
        return MultimediaServiceAdapter.loadImageSync(str);
    }

    public static boolean isJustLoadPlaceHolder(String str, String str2, boolean z, String str3, boolean z2) {
        String replaceDjangoId = GrayHelper.getReplaceDjangoId(str);
        if (TextUtils.isEmpty(replaceDjangoId) && !TextUtils.isEmpty(str2)) {
            GriverLogger.w(TAG, "无Lottie相关数据，并设置了Placeholder，直接降级：");
            return true;
        }
        DowngradeRuler downgradeRuler = new DowngradeRuler();
        downgradeRuler.setLottieDjangoId(replaceDjangoId).setPlaceHolder(str2).setOptimize(z).setScene(str3).setCanDowngradeOnEmptyPlaceHolder(z2);
        return downgradeRuler.downgradeToPlaceholder();
    }

    @Deprecated
    public static boolean checkLottieResourceIsReady(String str, String str2, boolean z) {
        return checkLottieResourceIsReady(str, str2, z, null, false);
    }

    @Deprecated
    public static boolean checkLottieResourceIsReady(String str, String str2, boolean z, String str3) {
        return checkLottieResourceIsReady(str, str2, z, str3, false);
    }

    public static boolean checkLottieResourceIsReady(String str, String str2, boolean z, String str3, boolean z2) {
        String replaceDjangoId = GrayHelper.getReplaceDjangoId(str);
        boolean isJustLoadPlaceHolder = isJustLoadPlaceHolder(replaceDjangoId, str2, z, str3, z2);
        String downgradeFile = getDowngradeFile(replaceDjangoId, str2);
        if (isJustLoadPlaceHolder && !TextUtils.isEmpty(downgradeFile)) {
            APImageQueryResultAdapter doImageQuery = MultimediaServiceAdapter.doImageQuery(downgradeFile);
            return doImageQuery != null && doImageQuery.success;
        } else if (isJustLoadPlaceHolder && TextUtils.isEmpty(downgradeFile)) {
            StringBuilder sb = new StringBuilder();
            sb.append("兜底图为空，降级失败.DjangoId=");
            sb.append(replaceDjangoId);
            sb.append(",scene=");
            sb.append(str3);
            GriverLogger.e(TAG, sb.toString());
            return false;
        } else {
            File lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(replaceDjangoId);
            if (lottieUnzipDir != null && lottieUnzipDir.exists()) {
                File[] listFiles = lottieUnzipDir.listFiles(new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.10
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file, String str4) {
                        return str4.endsWith(".json");
                    }
                });
                if (listFiles != null && listFiles.length > 0) {
                    return true;
                }
                DownloadFileUtils.delFile(lottieUnzipDir);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDowngradeFile(String str, String str2) {
        return TextUtils.isEmpty(str2) ? LottieHelper.getLocalDowngradeFilePath(str) : str2;
    }

    private static void loadLottieResourceByDjangoId(String str, String str2, final ResourceLoadCallback resourceLoadCallback, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String replaceDjangoId = GrayHelper.getReplaceDjangoId(str);
        LottieHelper.getResourceFromDjangoIdForLottieZip(str, str2, null, new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.11
            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public final void onSuccess(InputStream inputStream, String str4) throws Exception {
                StringBuilder sb = new StringBuilder();
                sb.append("getResourceFromDjangoIdForLottieZip onsucess :");
                sb.append(replaceDjangoId);
                GriverLogger.d(CDPLottiePlayer.TAG, sb.toString());
                ResourceLoadCallback resourceLoadCallback2 = resourceLoadCallback;
                if (resourceLoadCallback2 != null) {
                    resourceLoadCallback2.onSuccess();
                }
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public final void onError(String str4) {
                int errorCode = getErrorCode() > 0 ? getErrorCode() : 12;
                StringBuilder sb = new StringBuilder();
                sb.append("getResourceFromDjangoIdForLottieZip onError:");
                sb.append(replaceDjangoId);
                sb.append(",errorCode:");
                sb.append(errorCode);
                GriverLogger.d(CDPLottiePlayer.TAG, sb.toString());
                ResourceLoadCallback resourceLoadCallback2 = resourceLoadCallback;
                if (resourceLoadCallback2 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("parseLottieFromDjangoId failed:");
                    sb2.append(str4);
                    resourceLoadCallback2.onFail(errorCode, sb2.toString());
                }
            }
        }, str3);
    }

    private static void loadPlaceholderResource(String str, String str2, final ResourceLoadCallback resourceLoadCallback) {
        MultimediaServiceAdapter.loadImageAsync(str2, new MultimediaServiceAdapter.ImageLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.CDPLottiePlayer.12
            @Override // com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.ImageLoadCallback
            public final void onSuccess() {
                ResourceLoadCallback.this.onSuccess();
            }

            @Override // com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.ImageLoadCallback
            public final void onFail(int i, String str3) {
                ResourceLoadCallback.this.onFail(i, str3);
            }
        });
    }

    public Rect getLottieRect() {
        return this.lottieRect;
    }

    @Deprecated
    public LottieComposition getComposition() {
        if (this.mParams != null && this.mParams.getLottieComposition() != null) {
            return this.mParams.getLottieComposition();
        }
        LottieAnimationView lottie = getLottie();
        if (lottie != null) {
            return lottie.getComposition();
        }
        return null;
    }

    @Deprecated
    public static boolean isDowngrade(String str, boolean z) {
        if (TextUtils.isEmpty(GrayHelper.getReplaceDjangoId(str))) {
            return true;
        }
        return z && DeviceUtils.getDeviceLevel() == 1;
    }

    public void setVariableLottie(boolean z) {
        this.variableLottie = z;
    }

    public void setVariableLottieParams(Map<String, String> map) {
        this.variableLottieParams = map;
    }

    public void setBizLottieDataStatus(ILottieDataStatus iLottieDataStatus) {
        this.bizLottieDataStatus = iLottieDataStatus;
    }

    public void setDowngrade(String str) {
        this.downgrade = str;
    }

    public void setDynamicLayer(String str) {
        this.dynamicLayer = str;
    }
}
