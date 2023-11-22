package com.alibaba.griver.image.framework.utils;

import android.graphics.Bitmap;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.image.framework.decode.DecodeOptions;
import com.alibaba.griver.image.framework.decode.ImageDecoder;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class FalconDecoderBridge {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6587a = ImageUtils.isSdkMatch();

    public Bitmap cutImage_keepRatio(InputStream inputStream, int i, int i2) throws Exception {
        return cutImageKeepRatio_new(IOUtils.readToByte(inputStream), i, i2);
    }

    public Bitmap cutImageKeepRatio_new(byte[] bArr, int i, int i2) throws Exception {
        DecodeOptions decodeOptions = new DecodeOptions();
        decodeOptions.autoUseAshmem = this.f6587a;
        decodeOptions.mode = new DecodeOptions.MaxLenMode(Integer.valueOf(Math.max(i, i2)));
        return ImageDecoder.decodeBitmap(bArr, decodeOptions).bitmap;
    }

    public void setIsUseNewMethod(boolean z) {
        this.f6587a = z && ImageUtils.isSdkMatch();
    }
}
