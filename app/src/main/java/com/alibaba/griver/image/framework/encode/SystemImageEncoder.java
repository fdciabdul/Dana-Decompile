package com.alibaba.griver.image.framework.encode;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.framework.decode.DecodeOptions;
import com.alibaba.griver.image.framework.decode.DecodeResult;
import com.alibaba.griver.image.framework.decode.SystemImageDecoder;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.framework.mode.APMaxLenMode;
import com.alibaba.griver.image.framework.mode.APMinLenMode;
import com.alibaba.griver.image.framework.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class SystemImageEncoder {
    public static APEncodeResult compress(File file, APEncodeOptions aPEncodeOptions) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        APEncodeResult aPEncodeResult = new APEncodeResult();
        if (FileUtils.checkFile(file)) {
            APImageInfo imageInfo = APImageInfo.getImageInfo(file.getAbsolutePath());
            a(SystemImageDecoder.decodeBitmap(file, a(imageInfo, aPEncodeOptions), imageInfo), aPEncodeOptions, imageInfo, aPEncodeResult);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("compress file: ");
        sb.append(file);
        sb.append(", options: ");
        sb.append(aPEncodeOptions);
        sb.append(", result: ");
        sb.append(aPEncodeResult);
        sb.append(", cost: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("SystemImageEncoder", sb.toString());
        return aPEncodeResult;
    }

    public static APEncodeResult compress(Bitmap bitmap, APEncodeOptions aPEncodeOptions) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        APEncodeResult aPEncodeResult = new APEncodeResult();
        if (bitmap != null && !bitmap.isRecycled()) {
            DecodeResult decodeResult = new DecodeResult();
            decodeResult.code = 0;
            decodeResult.bitmap = bitmap;
            a(decodeResult, aPEncodeOptions, APImageInfo.getImageInfo(bitmap, 0), aPEncodeResult);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("compress bitmap: ");
        sb.append(bitmap);
        sb.append(", options: ");
        sb.append(aPEncodeOptions);
        sb.append(", result: ");
        sb.append(aPEncodeResult);
        sb.append(", cost: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("SystemImageEncoder", sb.toString());
        return aPEncodeResult;
    }

    private static DecodeOptions a(APImageInfo aPImageInfo, APEncodeOptions aPEncodeOptions) {
        DecodeOptions decodeOptions = new DecodeOptions();
        int i = aPEncodeOptions.mode.type;
        if (i == 0) {
            decodeOptions.mode = new DecodeOptions.MaxLenMode(Integer.valueOf(((APMaxLenMode) aPEncodeOptions.mode).len));
        } else if (i == 1) {
            decodeOptions.mode = new DecodeOptions.MinLenMode(Integer.valueOf(((APMinLenMode) aPEncodeOptions.mode).len));
        } else if (i == 4) {
            decodeOptions.mode = new DecodeOptions.MaxLenMode(Integer.valueOf(Math.max(aPImageInfo.width, aPImageInfo.height)));
        } else {
            decodeOptions.mode = new DecodeOptions.MaxLenMode(Integer.valueOf((int) APEncodeOptions.DEFAULT_MAX_LEN));
        }
        return decodeOptions;
    }

    private static void a(DecodeResult decodeResult, APEncodeOptions aPEncodeOptions, APImageInfo aPImageInfo, APEncodeResult aPEncodeResult) {
        OutputStream outputStream;
        Throwable th;
        StringBuilder sb = new StringBuilder();
        sb.append("processEncode start decodeResult: ");
        sb.append(decodeResult);
        sb.append(", opts: ");
        sb.append(aPEncodeOptions);
        sb.append(", info: ");
        sb.append(aPImageInfo);
        sb.append(", encodeResult: ");
        sb.append(aPEncodeResult);
        sb.append(", flag: ");
        sb.append(decodeResult.isSuccess());
        RVLogger.d("SystemImageEncoder", sb.toString());
        if (decodeResult.isSuccess()) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("processEncode start, options: ");
                sb2.append(aPEncodeOptions);
                RVLogger.d("SystemImageEncoder", sb2.toString());
                if (!TextUtils.isEmpty(aPEncodeOptions.outputFile)) {
                    File file = new File(aPEncodeOptions.outputFile);
                    file.getParentFile().mkdirs();
                    outputStream = new FileOutputStream(file);
                } else {
                    outputStream = new ByteArrayOutputStream();
                }
            } catch (Throwable th2) {
                outputStream = null;
                th = th2;
            }
            try {
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                if (aPEncodeOptions.outFormat == 1) {
                    compressFormat = Bitmap.CompressFormat.PNG;
                }
                int i = 50;
                if (aPEncodeOptions.quality == 1) {
                    i = 90;
                } else if (aPEncodeOptions.quality == 4) {
                    i = 10;
                } else if (aPEncodeOptions.quality == 3) {
                    i = 100;
                }
                boolean compress = decodeResult.bitmap.compress(compressFormat, i, outputStream);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("bitmap compress result: ");
                sb3.append(compress);
                RVLogger.d("SystemImageEncoder", sb3.toString());
                aPEncodeResult.code = 0;
                aPEncodeResult.encodeFilePath = aPEncodeOptions.outputFile;
                aPEncodeResult.encodeData = outputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) outputStream).toByteArray() : null;
                aPEncodeResult.imageInfo = aPImageInfo;
            } catch (Throwable th3) {
                th = th3;
                try {
                    RVLogger.e("SystemImageEncoder", "processEncode error", th);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("processEncode decodeResult: ");
                    sb4.append(decodeResult);
                    sb4.append(", opts: ");
                    sb4.append(aPEncodeOptions);
                    sb4.append(", info: ");
                    sb4.append(aPImageInfo);
                    sb4.append(", encodeResult: ");
                    sb4.append(aPEncodeResult);
                    RVLogger.d("SystemImageEncoder", sb4.toString());
                } finally {
                    IOUtils.closeQuietly(outputStream);
                }
            }
        } else {
            aPEncodeResult.code = -1;
        }
        StringBuilder sb42 = new StringBuilder();
        sb42.append("processEncode decodeResult: ");
        sb42.append(decodeResult);
        sb42.append(", opts: ");
        sb42.append(aPEncodeOptions);
        sb42.append(", info: ");
        sb42.append(aPImageInfo);
        sb42.append(", encodeResult: ");
        sb42.append(aPEncodeResult);
        RVLogger.d("SystemImageEncoder", sb42.toString());
    }
}
