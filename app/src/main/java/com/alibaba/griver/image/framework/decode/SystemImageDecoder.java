package com.alibaba.griver.image.framework.decode;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.framework.utils.FileUtils;
import java.io.File;

/* loaded from: classes6.dex */
public class SystemImageDecoder {
    public static DecodeResult decodeBitmap(File file, DecodeOptions decodeOptions, APImageInfo aPImageInfo) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        DecodeResult decodeResult = new DecodeResult();
        if (FileUtils.checkFile(file)) {
            decodeResult = InnerDecoder.decodeFile(file, decodeOptions, aPImageInfo);
            a(decodeResult, decodeOptions, aPImageInfo);
            decodeResult.srcInfo = aPImageInfo;
        } else {
            decodeResult.code = -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("decodeBitmap file: ");
        sb.append(file);
        sb.append(", options: ");
        sb.append(decodeOptions);
        sb.append(", result: ");
        sb.append(decodeResult);
        sb.append(", cost: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("SystemImageDecoder", sb.toString());
        return decodeResult;
    }

    public static DecodeResult decodeBitmap(byte[] bArr, DecodeOptions decodeOptions) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        DecodeResult decodeResult = new DecodeResult();
        if (bArr != null && bArr.length > 0) {
            APImageInfo imageInfo = APImageInfo.getImageInfo(bArr);
            DecodeResult decodeByteArray = InnerDecoder.decodeByteArray(bArr, imageInfo, decodeOptions);
            a(decodeByteArray, decodeOptions, imageInfo);
            decodeByteArray.srcInfo = imageInfo;
            decodeResult = decodeByteArray;
        } else {
            decodeResult.code = -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("decodeBitmap data: ");
        sb.append(bArr);
        sb.append(", options: ");
        sb.append(decodeOptions);
        sb.append(", result: ");
        sb.append(decodeResult);
        sb.append(", cost: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d("SystemImageDecoder", sb.toString());
        return decodeResult;
    }

    private static void a(DecodeResult decodeResult, DecodeOptions decodeOptions, APImageInfo aPImageInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("doImageDecodeProcess result: ");
        sb.append(decodeResult);
        sb.append(", options: ");
        sb.append(decodeOptions);
        sb.append(", info: ");
        sb.append(aPImageInfo);
        RVLogger.d("SystemImageDecoder", sb.toString());
        if (!decodeResult.isSuccess()) {
            return;
        }
        Bitmap bitmap = decodeResult.bitmap;
        int i = aPImageInfo.rotation;
        if (aPImageInfo.rotation <= 0 && (decodeOptions.forceRotate == null || decodeOptions.forceRotate.intValue() == 0)) {
            decodeResult.code = 0;
            decodeResult.bitmap = bitmap;
            return;
        }
        Matrix matrix = new Matrix();
        if (decodeOptions.forceRotate != null) {
            i = decodeOptions.forceRotate.intValue();
        }
        matrix.postRotate(i);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 5) {
                return;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                decodeResult.code = 0;
                decodeResult.bitmap = createBitmap;
                bitmap.recycle();
                return;
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("processBitmap process bitmap error, t: ");
                sb2.append(th);
                RVLogger.d("SystemImageDecoder", sb2.toString());
                decodeResult.code = -1;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("processBitmap degrade, scale: ");
                sb3.append(0.5f);
                RVLogger.d("SystemImageDecoder", sb3.toString());
                matrix.postScale(0.5f, 0.5f);
                float pow = (float) Math.pow(0.5d, i3);
                if (bitmap.getWidth() * pow == 0.0f || bitmap.getHeight() * pow == 0.0f) {
                    if (decodeResult.bitmap == null || decodeResult.bitmap.isRecycled()) {
                        return;
                    }
                    decodeResult.bitmap.recycle();
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("doImageDecodeProcess targetScale: ");
                sb4.append(pow);
                sb4.append(", times: ");
                sb4.append(i3);
                RVLogger.d("SystemImageDecoder", sb4.toString());
                i2 = i3;
            }
        }
    }
}
