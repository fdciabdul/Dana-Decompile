package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.beehive.lottie.util.MD5Util;
import com.alibaba.griver.image.GriverImageService;
import com.alibaba.griver.image.framework.api.APImageDownLoadCallback;
import com.alibaba.griver.image.framework.decode.DecodeOptions;
import com.alibaba.griver.image.framework.decode.DecodeResult;
import com.alibaba.griver.image.framework.decode.SystemImageDecoder;
import com.alibaba.griver.image.framework.meta.APImageDownloadRsp;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.framework.meta.APImageLoadRequest;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alibaba.griver.mobilecommon.multimedia.api.data.APFileDownloadRsp;
import com.alibaba.griver.mobilecommon.multimedia.api.data.APFileReq;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class MultimediaServiceAdapter {
    public static final int CODE_ERR_FILE_MD5_WRONG = 4;
    public static final int ERROR_DECODE_PLACEHOLDER_FAILED = 13;
    public static final int ERROR_DOWNLOAD_PLACEHOLDER_TIMEOUT = 17;
    public static final int ERROR_GET_LOTTIE_FAILED = 12;
    public static final int ERROR_GET_PLACEHOLDER_FAILED = 14;
    public static final int ERROR_ILLEGAL_PARAMETER = 11;
    public static final int ERROR_PARSE_LOTTIE_JSON_FAILED = 15;
    public static final int ERROR_SYSTEM_ERROR = 16;
    public static final int LOTTIE_DIR_CREATE_FAILED = 3;
    public static final int LOTTIE_FILE_IS_EMPTY = 5;
    public static final int LOTTIE_MD5_WRONG = 7;
    public static final String MULTI_MEDIA_BIZ_TYPE = "MULTI_MEDIA_BIZ_TYPE";
    public static final int READ_LOTTIE_DIR_FAILED = 4;
    public static final int READ_LOTTIE_FAILED = 6;
    public static final int RESPONSE_IS_NULL = 1;
    private static final String TAG = "MultimediaServiceAdapter";
    public static final int UNZIP_FAILED = 2;
    static final Pattern pattern = Pattern.compile("\\S*[?]\\S*");

    /* loaded from: classes6.dex */
    public interface DjangoLoadCallback {
        void onError(String str);

        void onSuccess(InputStream inputStream, String str);

        void setErrorCode(int i);
    }

    /* loaded from: classes6.dex */
    public interface ImageLoadCallback {
        void onFail(int i, String str);

        void onSuccess();
    }

    public static APImageQueryResultAdapter doImageQuery(String str) {
        return null;
    }

    public static void doSaveCacheBitmap(Bitmap bitmap, String str, String str2) {
    }

    public static void loadImageAsync(final String str, final ImageLoadCallback imageLoadCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GriverImageService griverImageService = (GriverImageService) RVProxy.get(GriverImageService.class);
        if (griverImageService != null) {
            APImageLoadRequest aPImageLoadRequest = new APImageLoadRequest();
            aPImageLoadRequest.path = str;
            aPImageLoadRequest.loadType = 3;
            aPImageLoadRequest.callback = new APImageDownLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.1
                @Override // com.alibaba.griver.image.framework.api.APImageDownLoadCallback
                public final void onProcess(String str2, int i) {
                }

                @Override // com.alibaba.griver.image.framework.api.APImageDownLoadCallback
                public final void onSucc(APImageDownloadRsp aPImageDownloadRsp) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("download success:");
                    sb.append(str);
                    GriverLogger.d(MultimediaServiceAdapter.TAG, sb.toString());
                    ImageLoadCallback imageLoadCallback2 = imageLoadCallback;
                    if (imageLoadCallback2 != null) {
                        imageLoadCallback2.onSuccess();
                    }
                }

                @Override // com.alibaba.griver.image.framework.api.APImageDownLoadCallback
                public final void onError(APImageDownloadRsp aPImageDownloadRsp, Exception exc) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("download error:");
                    sb.append(str);
                    sb.append(",");
                    sb.append(exc);
                    GriverLogger.d(MultimediaServiceAdapter.TAG, sb.toString());
                    ImageLoadCallback imageLoadCallback2 = imageLoadCallback;
                    if (imageLoadCallback2 != null) {
                        imageLoadCallback2.onFail(14, String.valueOf(exc));
                    }
                }
            };
            griverImageService.loadImage(aPImageLoadRequest, DanaLogConstants.BizType.CDP);
            return;
        }
        GriverLogger.d(TAG, "multimediaImageService is null");
        if (imageLoadCallback != null) {
            imageLoadCallback.onFail(16, "MultimediaImageService is null.");
        }
    }

    public static int loadImageSync(final String str) {
        GriverImageService griverImageService = (GriverImageService) RVProxy.get(GriverImageService.class);
        if (griverImageService != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final int[] iArr = {0};
            APImageLoadRequest aPImageLoadRequest = new APImageLoadRequest();
            aPImageLoadRequest.path = str;
            aPImageLoadRequest.loadType = 3;
            aPImageLoadRequest.callback = new APImageDownLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.2
                @Override // com.alibaba.griver.image.framework.api.APImageDownLoadCallback
                public final void onProcess(String str2, int i) {
                }

                @Override // com.alibaba.griver.image.framework.api.APImageDownLoadCallback
                public final void onSucc(APImageDownloadRsp aPImageDownloadRsp) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("download success:");
                    sb.append(str);
                    GriverLogger.d(MultimediaServiceAdapter.TAG, sb.toString());
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.griver.image.framework.api.APImageDownLoadCallback
                public final void onError(APImageDownloadRsp aPImageDownloadRsp, Exception exc) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("download error:");
                    sb.append(str);
                    sb.append(",");
                    sb.append(exc);
                    GriverLogger.d(MultimediaServiceAdapter.TAG, sb.toString());
                    iArr[0] = 14;
                    countDownLatch.countDown();
                }
            };
            griverImageService.loadImage(aPImageLoadRequest, DanaLogConstants.BizType.CDP);
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
                return iArr[0];
            } catch (InterruptedException e) {
                GriverLogger.e(TAG, "latch timeout", e);
                return 17;
            }
        }
        GriverLogger.d(TAG, "multimediaImageService is null");
        return 16;
    }

    public static Bitmap doLoadCacheBitmap(String str) {
        GriverImageService griverImageService = (GriverImageService) RVProxy.get(GriverImageService.class);
        return null;
    }

    public static APDecodeResultAdapter decodeBitmap(byte[] bArr) {
        try {
            DecodeResult decodeBitmap = SystemImageDecoder.decodeBitmap(bArr, new DecodeOptions());
            if (decodeBitmap != null) {
                return new APDecodeResultAdapter(decodeBitmap.code, decodeBitmap.bitmap, decodeBitmap.extra, decodeBitmap.srcInfo);
            }
            return null;
        } catch (Exception e) {
            GriverLogger.e(TAG, "图片解析异常：", e);
            return null;
        }
    }

    public static APDecodeResultAdapter decodeBitmap(InputStream inputStream) {
        try {
            DecodeResult decodeBitmap = SystemImageDecoder.decodeBitmap(IOUtils.readToByte(inputStream), new DecodeOptions());
            if (decodeBitmap != null) {
                return new APDecodeResultAdapter(decodeBitmap.code, decodeBitmap.bitmap, decodeBitmap.extra, decodeBitmap.srcInfo);
            }
            return null;
        } catch (Exception e) {
            GriverLogger.e(TAG, "图片解析异常：", e);
            return null;
        }
    }

    public static APDecodeResultAdapter decodeBitmap(File file) {
        try {
            DecodeResult decodeBitmap = SystemImageDecoder.decodeBitmap(file, new DecodeOptions(), APImageInfo.getImageInfo(file.getAbsolutePath()));
            if (decodeBitmap != null) {
                return new APDecodeResultAdapter(decodeBitmap.code, decodeBitmap.bitmap, decodeBitmap.extra, decodeBitmap.srcInfo);
            }
            return null;
        } catch (Exception e) {
            GriverLogger.e(TAG, "图片解析异常：", e);
            return null;
        }
    }

    public static boolean isAnimationFile(String str) {
        return FileUtils.isAnimationFile(str);
    }

    public static APImageInfoAdapter parseImageInfo(String str) {
        APImageInfo parseImageInfo;
        GriverImageService griverImageService = (GriverImageService) RVProxy.get(GriverImageService.class);
        if (griverImageService == null || (parseImageInfo = griverImageService.parseImageInfo(str)) == null) {
            return null;
        }
        return new APImageInfoAdapter(parseImageInfo.width, parseImageInfo.height, parseImageInfo.orientation);
    }

    public static String saveSnapshotBitmap(Bitmap bitmap, String str) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(" saveSnapshotBitmap return bitmap:");
            sb.append(bitmap);
            GriverLogger.d(TAG, sb.toString());
            return "";
        }
        return "";
    }

    public static APFileDownloadRspAdapter loadMeidaSync(String str, String str2, String str3) {
        APFileDownloadRsp aPFileDownloadRsp;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        APFileReq aPFileReq = new APFileReq();
        aPFileReq.setCloudId(str);
        if (ResourcesReplaceUtilAdapter.isLottieReplaced(str)) {
            String replacedLottieMd5 = ResourcesReplaceUtilAdapter.getReplacedLottieMd5(str);
            StringBuilder sb = new StringBuilder();
            sb.append("getReplacedLottieMd5 oldMd5:");
            sb.append(str3);
            sb.append(",replacedMd5:");
            sb.append(replacedLottieMd5);
            GriverLogger.d(TAG, sb.toString());
            if (!TextUtils.isEmpty(replacedLottieMd5)) {
                str3 = replacedLottieMd5;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            aPFileReq.setMd5(str3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadMeidaSync setmd5:");
            sb2.append(str3);
            GriverLogger.d(TAG, sb2.toString());
        }
        try {
            aPFileDownloadRsp = downLoadSync(aPFileReq);
        } catch (Exception e) {
            GriverLogger.e(TAG, "loadMeidaSync error", e);
            aPFileDownloadRsp = new APFileDownloadRsp();
            aPFileDownloadRsp.setRetCode(1);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("loadMeidaSync ");
        sb3.append(str);
        GriverLogger.d(TAG, sb3.toString());
        if (aPFileDownloadRsp != null && aPFileDownloadRsp.getRetCode() == 4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("loadMeidaSync CODE_ERR_FILE_MD5_WRONG ");
            sb4.append(str);
            GriverLogger.w(TAG, sb4.toString());
        }
        if (aPFileDownloadRsp != null) {
            return new APFileDownloadRspAdapter(aPFileDownloadRsp.getRetCode(), aPFileDownloadRsp.getMsg(), aPFileDownloadRsp.getFileReq().getCloudId(), aPFileDownloadRsp.getFileReq().getSavePath());
        }
        return null;
    }

    public static void loadMeida(final String str, String str2, final DjangoLoadCallback djangoLoadCallback) {
        new APFileReq().setCloudId(str);
        StringBuilder sb = new StringBuilder();
        sb.append(GriverEnv.getApplicationContext().getFilesDir());
        sb.append(File.separator);
        sb.append("griver/download/file");
        sb.append("/");
        sb.append(MD5Util.encrypt(str));
        sb.append(".");
        sb.append(parseSuffix(str));
        GriverTransport.downloadFile(str, sb.toString(), new DownloadCallback() { // from class: com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.3
            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public final void onCancel(String str3) {
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public final void onPrepare(String str3) {
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public final void onProgress(String str3, int i) {
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onFinish(java.lang.String r8) {
                /*
                    r7 = this;
                    java.lang.String r0 = "loadMeida,input stream close error,"
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "loadMeida,onDownloadFinished:"
                    r1.append(r2)
                    java.lang.String r2 = r1
                    r1.append(r2)
                    java.lang.String r2 = ",path="
                    r1.append(r2)
                    r1.append(r8)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "MultimediaServiceAdapter"
                    com.alibaba.griver.base.common.logger.GriverLogger.d(r2, r1)
                    r1 = 0
                    java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
                    r3.<init>(r8)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
                    com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter$DjangoLoadCallback r1 = r2     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                    r1.onSuccess(r3, r8)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                    r3.close()     // Catch: java.lang.Exception -> L31
                    return
                L31:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    goto L61
                L37:
                    r1 = move-exception
                    goto L73
                L39:
                    r1 = move-exception
                    r6 = r3
                    r3 = r1
                    r1 = r6
                    goto L41
                L3e:
                    r3 = move-exception
                    goto L76
                L40:
                    r3 = move-exception
                L41:
                    java.lang.String r4 = "媒体资源加载异常："
                    com.alibaba.griver.base.common.logger.GriverLogger.e(r2, r4, r3)     // Catch: java.lang.Throwable -> L6f
                    com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter$DjangoLoadCallback r4 = r2     // Catch: java.lang.Throwable -> L6f
                    r5 = 6
                    r4.setErrorCode(r5)     // Catch: java.lang.Throwable -> L6f
                    com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter$DjangoLoadCallback r4 = r2     // Catch: java.lang.Throwable -> L6f
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L6f
                    r4.onError(r3)     // Catch: java.lang.Throwable -> L6f
                    if (r1 == 0) goto L6e
                    r1.close()     // Catch: java.lang.Exception -> L5c
                    return
                L5c:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                L61:
                    r1.append(r0)
                    r1.append(r8)
                    java.lang.String r8 = r1.toString()
                    com.alibaba.griver.base.common.logger.GriverLogger.w(r2, r8)
                L6e:
                    return
                L6f:
                    r3 = move-exception
                    r6 = r3
                    r3 = r1
                    r1 = r6
                L73:
                    r6 = r3
                    r3 = r1
                    r1 = r6
                L76:
                    if (r1 == 0) goto L8e
                    r1.close()     // Catch: java.lang.Exception -> L7c
                    goto L8e
                L7c:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r0)
                    r1.append(r8)
                    java.lang.String r8 = r1.toString()
                    com.alibaba.griver.base.common.logger.GriverLogger.w(r2, r8)
                L8e:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.AnonymousClass3.onFinish(java.lang.String):void");
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public final void onFailed(String str3, int i, String str4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("loadMeida,onDownloadError:");
                sb2.append(str);
                sb2.append(",path=");
                sb2.append(str3);
                sb2.append(",errorCode=");
                sb2.append(i);
                sb2.append(",errorMsg=");
                sb2.append(str4);
                GriverLogger.d(MultimediaServiceAdapter.TAG, sb2.toString());
                DjangoLoadCallback djangoLoadCallback2 = djangoLoadCallback;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("loadMeida,onDownloadError:");
                sb3.append(str);
                djangoLoadCallback2.onError(sb3.toString());
            }
        });
    }

    public static void loadImage(String str, ImageView imageView) {
        ImageUtils.loadImage(imageView, null, str);
    }

    private static APFileDownloadRsp downLoadSync(APFileReq aPFileReq) {
        APFileDownloadRsp aPFileDownloadRsp = new APFileDownloadRsp();
        aPFileDownloadRsp.setFileReq(aPFileReq);
        StringBuilder sb = new StringBuilder();
        sb.append(GriverEnv.getApplicationContext().getFilesDir());
        sb.append(File.separator);
        sb.append("griver/download/file");
        sb.append("/");
        sb.append(MD5Util.encrypt(aPFileReq.getCloudId()));
        sb.append(".");
        sb.append(parseSuffix(aPFileReq.getCloudId()));
        aPFileReq.setSavePath(sb.toString());
        if (GriverTransport.downloadFile(aPFileReq.getCloudId(), aPFileReq.getSavePath())) {
            aPFileDownloadRsp.setRetCode(0);
            if (!TextUtils.isEmpty(aPFileReq.getMd5())) {
                if (!TextUtils.equals(aPFileReq.getMd5(), com.alibaba.griver.base.common.utils.MD5Util.getFileMD5String(new File(aPFileReq.getSavePath())))) {
                    aPFileDownloadRsp.setRetCode(4);
                }
            }
        }
        return aPFileDownloadRsp;
    }

    private static String parseSuffix(String str) {
        Matcher matcher = pattern.matcher(str);
        String[] split = str.toString().split("/");
        String str2 = split[split.length - 1];
        if (matcher.find()) {
            return str2.split("\\?")[0].split("\\.")[1];
        }
        return str2.split("\\.")[1];
    }
}
