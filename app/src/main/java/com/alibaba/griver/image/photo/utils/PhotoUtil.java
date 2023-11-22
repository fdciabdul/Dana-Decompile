package com.alibaba.griver.image.photo.utils;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.image.framework.meta.Size;
import com.alibaba.griver.image.framework.utils.PathUtils;
import com.alibaba.griver.image.photo.meta.CloudConfig;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import com.alipay.multimedia.adjuster.api.APMSandboxProcessor;
import com.alipay.multimedia.adjuster.api.data.APMInsertReq;
import java.util.Calendar;

/* loaded from: classes6.dex */
public class PhotoUtil {
    public static final float DEFAULT_HEIGHT_SCALE = 0.5625f;
    public static final float MAX_HEIGHT_SCALE = 1.3333334f;
    public static final int MAX_WIDTH = 800;
    public static final float MIN_HEIGHT_SCALE = 0.18518518f;
    public static final String TAG = "PhotoUtil";

    public static boolean isPowerOfTwo(int i) {
        return (i > 0) & ((i & (i + (-1))) == 0);
    }

    public static void startAnimation(View view, int i) {
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), i));
    }

    public static final void notifyScanner(String str, String str2) {
        if (isQCompact()) {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            if (!TextUtils.isEmpty(str2) && str2.contains("video")) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            }
            APMSandboxProcessor.insertMediaFile(new APMInsertReq.Builder(uri, str, a(str)).mimeType(str2).build());
            StringBuilder sb = new StringBuilder();
            sb.append("notifyScanner:### Q compact.path =");
            sb.append(str);
            RVLogger.d(TAG, sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyScanner:###");
        sb2.append(str);
        RVLogger.d(TAG, sb2.toString());
        MediaScannerConnection.scanFile(GriverEnv.getApplicationContext(), new String[]{str}, new String[]{str2}, null);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String substring = str.substring(str.lastIndexOf("\\") + 1);
            return substring.substring(0, substring.lastIndexOf("."));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getNameFromPath### Exception = ");
            sb.append(th.getMessage());
            RVLogger.e(TAG, sb.toString());
            return str;
        }
    }

    public static long getThisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        calendar.set(5, 1);
        return calendar.getTimeInMillis();
    }

    public static long getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        calendar.set(5, 1);
        calendar.add(2, -1);
        return calendar.getTimeInMillis();
    }

    public static void runOnMain(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static final int dp2px(Context context, int i) {
        return Math.round(TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics()));
    }

    public static final Size reorderSize(Size size) {
        return PathUtils.getDjangoNearestImageSize(size);
    }

    public static final Size reorderSize(int i) {
        return reorderSize(new Size(i, i));
    }

    public static final Size getPhotoSize(PhotoInfo photoInfo) {
        try {
            if (photoInfo.oriPhotoSize != null) {
                return photoInfo.oriPhotoSize;
            }
            int photoWidth = photoInfo.getPhotoWidth();
            int photoHeight = photoInfo.getPhotoHeight();
            if (photoInfo.getPhotoOrientation() == 90 || photoInfo.getPhotoOrientation() == 270) {
                photoHeight = photoWidth;
                photoWidth = photoHeight;
            }
            photoInfo.oriPhotoSize = new Size(photoWidth, photoHeight);
            return photoInfo.oriPhotoSize;
        } catch (Exception unused) {
            return new Size(0, 0);
        }
    }

    public static boolean isQVersion() {
        return Build.VERSION.SDK_INT > 28 || (Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    public static boolean isQCompact() {
        return isQVersion() && !CloudConfig.isConfigToDisableQCompact();
    }
}
