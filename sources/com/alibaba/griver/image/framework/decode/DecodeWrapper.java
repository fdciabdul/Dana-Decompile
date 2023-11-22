package com.alibaba.griver.image.framework.decode;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class DecodeWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static String f6576a = "DecodeWrapper";

    public static Bitmap decodeByImageDecoder(File file, final int i) {
        try {
            return android.graphics.ImageDecoder.decodeBitmap(android.graphics.ImageDecoder.createSource(file), new ImageDecoder.OnHeaderDecodedListener() { // from class: com.alibaba.griver.image.framework.decode.DecodeWrapper.1
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    imageDecoder.setTargetSampleSize(i);
                    imageDecoder.setMutableRequired(true);
                }
            });
        } catch (Throwable th) {
            String str = f6576a;
            StringBuilder sb = new StringBuilder();
            sb.append("decodeFileByImageDecoder exp file=");
            sb.append(file);
            sb.append(" ;sampleSize=");
            sb.append(i);
            RVLogger.e(str, sb.toString(), th);
            return null;
        }
    }

    public static Bitmap decodeByImageDecoder(byte[] bArr, final int i) {
        try {
            return android.graphics.ImageDecoder.decodeBitmap(android.graphics.ImageDecoder.createSource(ByteBuffer.wrap(bArr)), new ImageDecoder.OnHeaderDecodedListener() { // from class: com.alibaba.griver.image.framework.decode.DecodeWrapper.2
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    imageDecoder.setTargetSampleSize(i);
                    imageDecoder.setMutableRequired(true);
                }
            });
        } catch (Throwable th) {
            String str = f6576a;
            StringBuilder sb = new StringBuilder();
            sb.append("decodeByImageDecoder exp data len=");
            sb.append(bArr != null ? bArr.length : 0);
            sb.append(" ;sampleSize=");
            sb.append(i);
            RVLogger.e(str, sb.toString(), th);
            return null;
        }
    }
}
