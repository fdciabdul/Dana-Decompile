package com.alibaba.griver.base.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ImageLoader implements Runnable {
    public static final String TAG = "ImageLoader";

    /* renamed from: a */
    private static long f6281a = 5242880;
    private String b;
    private ImageListener c;

    public ImageLoader(String str, ImageListener imageListener) {
        this.b = str;
        this.c = imageListener;
    }

    public File getLocalUrlFile(String str) {
        if (GriverInnerConfig.getConfigBoolean("load_local_picture", true)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(GriverEnv.getApplicationContext().getExternalCacheDir());
                sb.append(File.separator);
                sb.append("imageload/pictures");
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                String mD5String = MD5Util.getMD5String(str);
                String[] split = str.split("/");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mD5String);
                sb2.append("_");
                sb2.append(split[split.length - 1]);
                return new File(file, sb2.toString());
            } catch (Exception e) {
                RVLogger.e(TAG, " getLocalUrl file error", e);
                HashMap hashMap = new HashMap();
                hashMap.put("url", str);
                if (!TextUtils.isEmpty(e.getMessage())) {
                    hashMap.put("errorMessage", e.getMessage());
                }
                GriverMonitor.event("mkdir_file_error", "GriverAppContainer", hashMap);
            }
        }
        return null;
    }

    public boolean readLocalBitmap(String str) {
        Exception e;
        final Bitmap decodeStream;
        int i;
        File localUrlFile = getLocalUrlFile(str);
        boolean z = true;
        if (localUrlFile != null && localUrlFile.exists()) {
            try {
                if (FileUtils.calculateSize(localUrlFile) > f6281a) {
                    WindowManager windowManager = (WindowManager) GriverEnv.getApplicationContext().getSystemService("window");
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    if (windowManager != null) {
                        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                        i = displayMetrics.widthPixels;
                    } else {
                        i = 0;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(localUrlFile.getAbsolutePath(), options);
                    int i2 = 1;
                    for (int i3 = options.outWidth; i3 > i; i3 /= 2) {
                        i2 *= 2;
                    }
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = i2;
                    decodeStream = BitmapFactory.decodeFile(localUrlFile.getAbsolutePath(), options);
                } else {
                    decodeStream = BitmapFactory.decodeStream(new FileInputStream(localUrlFile));
                }
                if (decodeStream != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("bitmap size : ");
                    sb.append(decodeStream.getAllocationByteCount());
                    GriverLogger.d(TAG, sb.toString());
                    try {
                        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.base.common.ImageLoader.1
                            {
                                ImageLoader.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                ImageLoader.this.c.onImage(decodeStream);
                            }
                        });
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        GriverLogger.e(TAG, " readLocalBitmap file error", e);
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", str);
                        hashMap.put("path", localUrlFile.getPath());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(localUrlFile.getTotalSpace());
                        hashMap.put("localUrlTotalSpace", sb2.toString());
                        if (!TextUtils.isEmpty(e.getMessage())) {
                            hashMap.put("errorMessage", e.getMessage());
                        }
                        GriverMonitor.event("file2bitmap_error", "GriverAppContainer", hashMap);
                        localUrlFile.delete();
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
        }
        return false;
    }

    public void saveLocalBitmap(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File localUrlFile = getLocalUrlFile(str);
        if (localUrlFile == null || bitmap == null) {
            return;
        }
        if (localUrlFile.exists()) {
            localUrlFile.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(localUrlFile);
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    if (bitmap.hasAlpha()) {
                        compressFormat = Bitmap.CompressFormat.PNG;
                    }
                    bitmap.compress(compressFormat, 100, fileOutputStream);
                    fileOutputStream.flush();
                    IOUtils.closeQuietly(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream;
                    GriverLogger.e(TAG, "saveLocalBitmap exception.", e);
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", str);
                    hashMap.put("path", localUrlFile.getPath());
                    if (!TextUtils.isEmpty(e.getMessage())) {
                        hashMap.put("errorMessage", e.getMessage());
                    }
                    GriverMonitor.event("bitmap2file_error", "GriverAppContainer", hashMap);
                    if (localUrlFile != null && localUrlFile.exists()) {
                        localUrlFile.delete();
                    }
                    IOUtils.closeQuietly(fileOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c == null || TextUtils.isEmpty(this.b) || readLocalBitmap(this.b)) {
            return;
        }
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(this.b).openConnection()));
            uRLConnection.setConnectTimeout(10000);
            uRLConnection.setReadTimeout(10000);
            final Bitmap decodeStream = BitmapFactory.decodeStream(uRLConnection.getInputStream());
            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.base.common.ImageLoader.2
                {
                    ImageLoader.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    GriverLogger.d(ImageLoader.TAG, "listener.onImage");
                    ImageLoader.this.c.onImage(decodeStream);
                }
            });
            saveLocalBitmap(this.b, decodeStream);
        } catch (Throwable th) {
            GriverLogger.e(TAG, "load image exception.", th);
            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.base.common.ImageLoader.3
                {
                    ImageLoader.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (ImageLoader.this.c != null) {
                        ImageLoader.this.c.onImage(null);
                    }
                }
            });
        }
    }
}
