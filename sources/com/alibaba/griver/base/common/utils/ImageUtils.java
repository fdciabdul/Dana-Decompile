package com.alibaba.griver.base.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.ImageLoader;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.image.framework.api.APImageFormat;
import com.alibaba.griver.image.framework.api.GriverImageLoadExtension;
import com.alibaba.griver.image.framework.mode.GriverImageLoadRequest;
import com.alibaba.griver.image.framework.utils.Format;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ImageUtils {
    static final String TAG = "ImageUtil";
    public static String gifBase64 = "data:image/gif;base64,";
    public static String iconBase64 = "data:image/x-icon;base64,";
    public static String jpgBae64 = "data:image/jpeg;base64,";
    public static String pngBase64 = "data:image/png;base64,";
    public static LruCache<String, Bitmap> LRUcache = new LruCache<String, Bitmap>(5242880) { // from class: com.alibaba.griver.base.common.utils.ImageUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public final int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static String[] f6312a = {APImageFormat.SUFFIX_PNG, APImageFormat.SUFFIX_JPG, "jpeg", APImageFormat.SUFFIX_WEBP, "bmp", APImageFormat.SUFFIX_GIF, "tif"};

    public static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(i / width, i2 / height);
        Matrix matrix = new Matrix();
        matrix.postScale(min, min);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e) {
            GriverLogger.e(TAG, "OutOfMemoryError", e);
            return null;
        }
    }

    public static Drawable byteToDrawable(String str) {
        byte[] decode = Base64.decode(base64Deal(str), 0);
        if (decode != null) {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        }
        return null;
    }

    public static String getImageTempDir(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        sb.append("/h5container/image/temp");
        sb.append(File.separator);
        return sb.toString();
    }

    public static Bitmap imageQuality(Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        if (i >= 100) {
            return bitmap;
        }
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, poolingByteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(poolingByteArrayOutputStream.toByteArray());
        try {
            try {
                bitmap2 = BitmapFactory.decodeStream(byteArrayInputStream, null, new BitmapFactory.Options());
            } catch (OutOfMemoryError e) {
                GriverLogger.e(TAG, "exception detail", e);
            }
            return bitmap2;
        } finally {
            IOUtils.closeQuietly(poolingByteArrayOutputStream);
            IOUtils.closeQuietly(byteArrayInputStream);
        }
    }

    public static Bitmap getDiskBitmap(String str, int i, int i2) {
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        if (FileUtils.exists(str)) {
            GriverLogger.debug(TAG, "getDiskBitmap begin");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ALPHA_8;
            options.inJustDecodeBounds = true;
            options.inDither = false;
            options.inTempStorage = new byte[32768];
            GriverLogger.debug(TAG, "getDiskBitmap decodeFile begin");
            BitmapFactory.decodeFile(str, options);
            GriverLogger.debug(TAG, "getDiskBitmap decodeFile after");
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            if ((i3 <= i && i4 <= i2) || i <= 0 || i2 <= 0) {
                return BitmapFactory.decodeFile(str);
            }
            float f = i3;
            float f2 = f / i;
            float f3 = i4;
            float f4 = f3 / i2;
            if (f2 > f4) {
                i2 = (int) (f3 / f2);
            } else {
                i = (int) (f / f4);
            }
            options.inSampleSize = Math.min(i3 / i, i4 / i2);
            options.inJustDecodeBounds = false;
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (FileNotFoundException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(e);
                GriverLogger.e(TAG, sb.toString());
                fileInputStream = null;
            }
            try {
                if (fileInputStream != null) {
                    GriverLogger.debug(TAG, "getDiskBitmap decodeFileDescriptor begin");
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options);
                    GriverLogger.debug(TAG, "getDiskBitmap decodeFileDescriptor after");
                    bitmap = Bitmap.createScaledBitmap(decodeFileDescriptor, i, i2, true);
                    if (decodeFileDescriptor != bitmap) {
                        decodeFileDescriptor.recycle();
                    }
                    fileInputStream.close();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("not file.");
                    sb2.append(str);
                    GriverLogger.e(TAG, sb2.toString());
                }
            } catch (IOException e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("create bitmap exception:");
                sb3.append(e2);
                GriverLogger.e(TAG, sb3.toString());
            }
            GriverLogger.debug(TAG, "getDiskBitmap after");
            return bitmap;
        }
        return null;
    }

    public static Bitmap getDiskBitmap(String str, int i, int i2, int i3) {
        Bitmap diskBitmap = getDiskBitmap(str, i, i2);
        if (diskBitmap == null) {
            return null;
        }
        if (i3 < 50 || i3 > 100) {
            GriverLogger.d(TAG, "set quality as default 75.");
            i3 = 75;
        }
        if (i3 != 100) {
            PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
            diskBitmap.compress(Bitmap.CompressFormat.JPEG, i3, poolingByteArrayOutputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(poolingByteArrayOutputStream.toByteArray());
            diskBitmap.recycle();
            Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream, null, null);
            IOUtils.closeQuietly(poolingByteArrayOutputStream);
            return decodeStream;
        }
        return diskBitmap;
    }

    public static void writeImage(Bitmap bitmap, Bitmap.CompressFormat compressFormat, String str) {
        FileOutputStream fileOutputStream;
        if (bitmap == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        bitmap.compress(compressFormat, 100, fileOutputStream);
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        GriverLogger.e(TAG, "exception detail.", e);
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                GriverLogger.e(TAG, "Exception", e2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                GriverLogger.e(TAG, "Exception", e4);
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static String bitmapToString(Bitmap bitmap, String str) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
        bitmap.compress(str.equals(APImageFormat.SUFFIX_JPG) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, poolingByteArrayOutputStream);
        byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
        IOUtils.closeQuietly(poolingByteArrayOutputStream);
        return Base64.encodeToString(byteArray, 2);
    }

    public static Bitmap base64ToBitmap(String str) {
        try {
            byte[] decode = Base64.decode(base64Deal(str), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable th) {
            GriverLogger.e(TAG, "base64 to bitmap error", th);
            return null;
        }
    }

    @Deprecated
    public static String getMimeType(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        byte[] decode = Base64.decode(base64Deal(str), 0);
        BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
        StringBuilder sb = new StringBuilder();
        sb.append("--type is ");
        sb.append(options.outMimeType);
        GriverLogger.d(TAG, sb.toString());
        return options.outMimeType;
    }

    public static String base64Deal(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(gifBase64)) {
            return str.replace(gifBase64, "");
        }
        if (str.startsWith(pngBase64)) {
            return str.replace(pngBase64, "");
        }
        if (str.startsWith(jpgBae64)) {
            return str.replace(jpgBae64, "");
        }
        return str.startsWith(iconBase64) ? str.replace(iconBase64, "") : str;
    }

    public static InputStream base64ToInputStream(String str) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        if (!"no".equalsIgnoreCase(GriverInnerConfig.getConfigWithProcessCache(GriverConfigConstants.KEY_ENABLE_BASE64_TO_IS, "YES"))) {
            return a(str);
        }
        try {
            byte[] decode = Base64.decode(base64Deal(str), 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
            try {
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, poolingByteArrayOutputStream);
                return new ByteArrayInputStream(poolingByteArrayOutputStream.toByteArray());
            } catch (Throwable unused) {
                try {
                    GriverLogger.d(TAG, "base64ToInputStream, inputStream is null");
                    return null;
                } finally {
                    IOUtils.closeQuietly(poolingByteArrayOutputStream);
                }
            }
        } catch (Throwable unused2) {
            poolingByteArrayOutputStream = null;
        }
    }

    private static InputStream a(String str) {
        try {
            GriverLogger.d(TAG, "");
            return new ByteArrayInputStream(Base64.decode(base64Deal(str), 0));
        } catch (Throwable th) {
            GriverLogger.e(TAG, "error", th);
            return null;
        }
    }

    public static boolean checkBitmap(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    @Deprecated
    public static void loadImage(final String str, final ImageListener imageListener) {
        Bitmap bitmap;
        if (!TextUtils.isEmpty(str) && (bitmap = LRUcache.get(str)) != null) {
            imageListener.onImage(bitmap);
        } else {
            GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new ImageLoader(str, new ImageListener() { // from class: com.alibaba.griver.base.common.utils.ImageUtils.2
                @Override // com.alibaba.griver.base.common.adapter.ImageListener
                public final void onImage(Bitmap bitmap2) {
                    ImageListener imageListener2 = ImageListener.this;
                    if (imageListener2 != null) {
                        imageListener2.onImage(bitmap2);
                        if (bitmap2 != null) {
                            ImageUtils.LRUcache.put(str, bitmap2);
                        }
                    }
                }
            }));
        }
    }

    public static void loadImage(final ImageView imageView, final Drawable drawable, String str) {
        if (drawable != null && TextUtils.isEmpty(str)) {
            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.base.common.utils.ImageUtils.3
                @Override // java.lang.Runnable
                public final void run() {
                    imageView.setImageDrawable(drawable);
                }
            });
            return;
        }
        try {
            GriverImageLoadExtension griverImageLoadExtension = (GriverImageLoadExtension) RVProxy.get(GriverImageLoadExtension.class);
            GriverImageLoadRequest griverImageLoadRequest = new GriverImageLoadRequest();
            griverImageLoadRequest.path = str;
            griverImageLoadRequest.defaultDrawable = drawable;
            griverImageLoadRequest.target = imageView;
            griverImageLoadRequest.context = GriverEnv.getApplicationContext();
            griverImageLoadExtension.loadImage(griverImageLoadRequest);
        } catch (Exception e) {
            GriverLogger.e(TAG, "load image ", e);
            loadImage(str, new ImageListener() { // from class: com.alibaba.griver.base.common.utils.ImageUtils.4
                @Override // com.alibaba.griver.base.common.adapter.ImageListener
                public final void onImage(Bitmap bitmap) {
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    } else {
                        imageView.setImageDrawable(drawable);
                    }
                }
            });
        }
    }

    public static final boolean isImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(Format.SUFFIX_GIF) || str.endsWith(Format.SUFFIX_BMP) || str.endsWith(".tiff") || str.endsWith(".pcx") || str.endsWith(".tga") || str.endsWith(".exif") || str.endsWith(".fpx") || str.endsWith(".svg") || str.endsWith(".psd") || str.endsWith(".cdr") || str.endsWith(".pcd") || str.endsWith(".dxf") || str.endsWith(".ufo") || str.endsWith(".eps") || str.endsWith(".ai") || str.endsWith(".raw") || str.endsWith(Format.SUFFIX_WEBP);
    }

    public static boolean checkSuffixSupported(String str) {
        boolean z;
        String substring = str.substring(str.lastIndexOf(".") + 1);
        StringBuilder sb = new StringBuilder();
        sb.append("checkSuffixSupported...suffix=");
        sb.append(substring);
        RVLogger.d(TAG, sb.toString());
        if (RVLogger.isEmpty(substring)) {
            RVLogger.d(TAG, "checkSuffixSupported... suffix is null");
            return false;
        }
        String lowerCase = substring.toLowerCase();
        String[] strArr = f6312a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (strArr[i].equals(lowerCase)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkSuffixSupported...unsupported suffix = ");
        sb2.append(substring);
        RVLogger.d(TAG, sb2.toString());
        return false;
    }

    public static float getScale(int i, int i2, float f, float f2) {
        if (i <= 0 || i2 <= 0) {
            if (i > 0) {
                return i / f;
            }
            if (i2 > 0) {
                return i2 / f2;
            }
            return 1.0f;
        }
        return Math.min(i / f, i2 / f2);
    }

    public static boolean isSdkMatch() {
        return Build.VERSION.SDK_INT >= 15 && Build.VERSION.SDK_INT < 21;
    }
}
