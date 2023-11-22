package com.alibaba.griver.image.framework.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.framework.decode.BitmapLock;
import com.alibaba.griver.image.framework.decode.DecodeOptions;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.framework.meta.ImageFileType;
import com.alibaba.griver.image.framework.meta.StaticOptions;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class InnerDecoder {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<DecodeFilter> f6577a = new ArrayList<>();
    public static boolean bCheckDecodeOritation = false;
    public static boolean bSysImageDecoderByte = false;
    public static boolean bSysImageDecoderFile = false;
    public static int hevcDecodeThreadNum = 2;
    public static int hevcDecodeTimeout;

    public static DecodeResult decodeFile(File file, DecodeOptions decodeOptions, APImageInfo aPImageInfo) throws IOException {
        DecodeResult decodeResult;
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeOptions.autoUseAshmem && Build.VERSION.SDK_INT < 21) {
            decodeResult = decodeByteArray(getBytes(file), aPImageInfo, decodeOptions);
        } else {
            DecodeResult decodeResult2 = new DecodeResult();
            decodeResult2.code = -1;
            a(file, (byte[]) null, decodeResult2, aPImageInfo, a(aPImageInfo, decodeOptions), decodeOptions != null ? decodeOptions.canUseJpgThumbnailData : StaticOptions.useThumbnailData);
            decodeResult = decodeResult2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("decodeFile file: ");
        sb.append(file);
        sb.append(", opts: ");
        sb.append(decodeOptions);
        sb.append(", result: ");
        sb.append(decodeResult);
        sb.append(", cost: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("InnerDecoder", sb.toString());
        return decodeResult;
    }

    private static void a(final File file, final byte[] bArr, DecodeResult decodeResult, final APImageInfo aPImageInfo, final BitmapFactory.Options options, final boolean z) {
        boolean isJPEG = bArr != null ? ImageFileType.isJPEG(bArr) : ImageFileType.isJPEG(file);
        do {
            try {
                final boolean z2 = isJPEG;
                Bitmap handleBitmap = BitmapLock.handleBitmap(new BitmapLock.ImageHandler() { // from class: com.alibaba.griver.image.framework.decode.InnerDecoder.1
                    @Override // com.alibaba.griver.image.framework.decode.BitmapLock.ImageHandler
                    public final Bitmap handle() {
                        return InnerDecoder.a(file, bArr, aPImageInfo, options, z, z2);
                    }
                });
                decodeResult.bitmap = handleBitmap;
                if (handleBitmap != null) {
                    decodeResult.code = 0;
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            } catch (OutOfMemoryError unused2) {
            }
        } while (a(decodeResult, aPImageInfo, options, isJPEG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap a(File file, byte[] bArr, APImageInfo aPImageInfo, BitmapFactory.Options options, boolean z, boolean z2) {
        BitmapFactory.Options calcThumbnailOptions;
        if (bArr != null) {
            return a(bArr, options);
        }
        if (z2 && z && StaticOptions.useThumbnailData && (calcThumbnailOptions = calcThumbnailOptions(aPImageInfo, options)) != null) {
            return a(aPImageInfo.getThumbnailInfo().data, calcThumbnailOptions);
        }
        if (a(aPImageInfo)) {
            return null;
        }
        return a(file, options);
    }

    public static BitmapFactory.Options calcThumbnailOptions(APImageInfo aPImageInfo, BitmapFactory.Options options) {
        APImageInfo thumbnailInfo = aPImageInfo.getThumbnailInfo();
        if (thumbnailInfo != null) {
            int i = aPImageInfo.correctWidth / options.inSampleSize;
            int i2 = aPImageInfo.correctHeight / options.inSampleSize;
            if (i - StaticOptions.thumbnail_allow_delta >= thumbnailInfo.correctWidth || i2 - StaticOptions.thumbnail_allow_delta >= thumbnailInfo.correctHeight) {
                return null;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inDensity = options.inDensity;
            options2.inTargetDensity = options.inTargetDensity;
            options2.inScreenDensity = options.inScreenDensity;
            options2.inMutable = options.inMutable;
            options2.inDither = options.inDither;
            options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
            options2.inPreferredConfig = options.inPreferredConfig;
            options2.inSampleSize = b(thumbnailInfo, Integer.valueOf(Math.max(i, i2)));
            return options2;
        }
        return null;
    }

    private static boolean a(DecodeResult decodeResult, APImageInfo aPImageInfo, BitmapFactory.Options options, boolean z) {
        if (options.inPreferredConfig == Bitmap.Config.ARGB_8888 && aPImageInfo.rotation == 0 && z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            decodeResult.extra = 1;
            return true;
        }
        int max = Math.max(aPImageInfo.width, aPImageInfo.height);
        if (max / options.inSampleSize <= 10000 || max <= 0) {
            return false;
        }
        do {
            options.inSampleSize <<= 1;
            if (options.inSampleSize == 0) {
                return false;
            }
        } while (max / options.inSampleSize > 10000);
        decodeResult.extra |= 2;
        return true;
    }

    public static DecodeResult decodeByteArray(byte[] bArr, APImageInfo aPImageInfo, DecodeOptions decodeOptions) {
        DecodeResult decodeResult = new DecodeResult();
        decodeResult.code = -1;
        long currentTimeMillis = System.currentTimeMillis();
        a((File) null, bArr, decodeResult, aPImageInfo, a(aPImageInfo, decodeOptions), decodeOptions != null ? decodeOptions.canUseJpgThumbnailData : StaticOptions.useThumbnailData);
        StringBuilder sb = new StringBuilder();
        sb.append("decodeByteArray data: ");
        sb.append(bArr);
        sb.append(", opts: ");
        sb.append(decodeOptions);
        sb.append(", result: ");
        sb.append(decodeResult);
        sb.append(", cost: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("InnerDecoder", sb.toString());
        return decodeResult;
    }

    private static BitmapFactory.Options a(APImageInfo aPImageInfo, DecodeOptions decodeOptions) {
        int b = b(aPImageInfo, decodeOptions);
        BitmapFactory.Options options = decodeOptions.baseOptions == null ? new BitmapFactory.Options() : decodeOptions.baseOptions;
        options.inSampleSize = b;
        options.inPreferredConfig = decodeOptions.inPreferredConfig;
        options.inDither = true;
        options.inMutable = true;
        if (decodeOptions.autoUseAshmem && Build.VERSION.SDK_INT < 21) {
            options.inPurgeable = true;
            options.inInputShareable = true;
        }
        if (decodeOptions.inPreferQualityOverSpeed) {
            options.inPreferQualityOverSpeed = true;
        }
        return options;
    }

    private static int b(APImageInfo aPImageInfo, DecodeOptions decodeOptions) {
        if (aPImageInfo == null || aPImageInfo.width <= 0 || aPImageInfo.height <= 0 || decodeOptions.mode == null) {
            return 1;
        }
        int i = decodeOptions.mode.type;
        if (i != 1) {
            if (i == 2) {
                return a(aPImageInfo, (DecodeOptions.FitRectMode) decodeOptions.mode);
            }
            return b(aPImageInfo, ((DecodeOptions.MaxLenMode) decodeOptions.mode).len);
        }
        return a(aPImageInfo, ((DecodeOptions.MinLenMode) decodeOptions.mode).len);
    }

    private static int a(APImageInfo aPImageInfo, DecodeOptions.FitRectMode fitRectMode) {
        int i;
        float f;
        int i2;
        if (aPImageInfo == null) {
            i = 1;
        } else if ((fitRectMode.rectWidth >= fitRectMode.rectHeight && aPImageInfo.width >= aPImageInfo.height) || (fitRectMode.rectWidth <= fitRectMode.rectHeight && aPImageInfo.width <= aPImageInfo.height)) {
            i = b(aPImageInfo, Integer.valueOf(Math.max(fitRectMode.rectWidth, fitRectMode.rectHeight)));
        } else {
            if (fitRectMode.rectWidth > fitRectMode.rectHeight) {
                f = fitRectMode.rectHeight;
                i2 = fitRectMode.rectWidth;
            } else {
                f = fitRectMode.rectWidth;
                i2 = fitRectMode.rectHeight;
            }
            i = a(aPImageInfo, Integer.valueOf((int) (Math.min(fitRectMode.rectWidth, fitRectMode.rectHeight) * (f / i2))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("calcFitRectSampleSize info: ");
        sb.append(aPImageInfo);
        sb.append(", mode: ");
        sb.append(fitRectMode);
        sb.append(", sampleSize: ");
        sb.append(i);
        RVLogger.d("InnerDecoder", sb.toString());
        return i;
    }

    private static int a(APImageInfo aPImageInfo, Integer num) {
        int a2 = a(num, Math.min(aPImageInfo.width, aPImageInfo.height), num != null && num.intValue() > 10000);
        StringBuilder sb = new StringBuilder();
        sb.append("calcMinLenSampleSize info: ");
        sb.append(aPImageInfo);
        sb.append(", len: ");
        sb.append(num);
        sb.append(", sampleSize: ");
        sb.append(a2);
        RVLogger.d("InnerDecoder", sb.toString());
        return a2;
    }

    private static int a(Integer num, int i, boolean z) {
        int i2 = 1;
        if (num != null && num.intValue() > 0 && i > num.intValue()) {
            int i3 = 2;
            int i4 = 1;
            while (i3 != 0 && i / i3 >= num.intValue()) {
                i4 = i3;
                i3 <<= 1;
            }
            if (!z || (i3 > 0 && Math.abs((i / i4) - num.intValue()) < Math.abs((i / i3) - num.intValue()))) {
                i3 = i4;
            }
            if (i3 > 0) {
                i2 = i3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getSampleSize len: ");
        sb.append(num);
        sb.append(", side: ");
        sb.append(i);
        sb.append(", optimize: ");
        sb.append(z);
        sb.append(", sampleSize: ");
        sb.append(i2);
        RVLogger.d("InnerDecoder", sb.toString());
        return i2;
    }

    private static int b(APImageInfo aPImageInfo, Integer num) {
        int a2 = a(num, Math.max(aPImageInfo.width, aPImageInfo.height), num != null && num.intValue() > 10000);
        StringBuilder sb = new StringBuilder();
        sb.append("calcMaxLenSampleSize info: ");
        sb.append(aPImageInfo);
        sb.append(", len: ");
        sb.append(num);
        sb.append(", sampleSize: ");
        sb.append(a2);
        RVLogger.d("InnerDecoder", sb.toString());
        return a2;
    }

    private static Bitmap a(File file, BitmapFactory.Options options) {
        if (useSystemImageDecoderFile()) {
            return DecodeWrapper.decodeByImageDecoder(file, options.inSampleSize);
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    private static Bitmap a(byte[] bArr, BitmapFactory.Options options) {
        if (useSystemImageDecoderByte()) {
            return DecodeWrapper.decodeByImageDecoder(bArr, options.inSampleSize);
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static boolean useSystemImageDecoderFile() {
        return Build.VERSION.SDK_INT >= 28 && bSysImageDecoderFile;
    }

    public static boolean useSystemImageDecoderByte() {
        return Build.VERSION.SDK_INT >= 28 && bSysImageDecoderByte;
    }

    private static boolean a(APImageInfo aPImageInfo) {
        if (aPImageInfo == null) {
            return false;
        }
        synchronized (f6577a) {
            for (int i = 0; i < f6577a.size(); i++) {
                if (f6577a.get(i).checkFilter(aPImageInfo.format.intValue(), aPImageInfo.correctWidth, aPImageInfo.correctHeight)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("checkImageFileter true info: ");
                    sb.append(aPImageInfo);
                    RVLogger.d("InnerDecoder", sb.toString());
                    return true;
                }
            }
            return false;
        }
    }

    public static byte[] getBytes(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    IOUtils.closeQuietly(fileInputStream);
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }
}
