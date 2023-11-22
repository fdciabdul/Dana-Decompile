package com.alibaba.griver.image.framework.encode;

import android.graphics.Bitmap;
import java.io.File;

/* loaded from: classes6.dex */
public class ImageEncoder {
    public static APEncodeResult compress(File file, APEncodeOptions aPEncodeOptions) throws Exception {
        return SystemImageEncoder.compress(file, aPEncodeOptions);
    }

    public static APEncodeResult compress(Bitmap bitmap, APEncodeOptions aPEncodeOptions) throws Exception {
        return SystemImageEncoder.compress(bitmap, aPEncodeOptions);
    }
}
