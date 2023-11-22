package com.alibaba.griver.image.framework.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.alibaba.griver.image.framework.meta.StaticOptions;

/* loaded from: classes6.dex */
public class BaseDecodeOptions {
    public static final int FORMAT_BITMAP = 0;
    public static final int FORMAT_YUV = 1;
    public boolean autoUseAshmem;
    public BitmapFactory.Options baseOptions;
    public boolean canUseJpgThumbnailData;
    public Integer forceRotate;
    public int frameIndex;
    public boolean isForceUseSysDecode;
    public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
    public boolean autoRotate = true;
    public boolean inPreferQualityOverSpeed = false;
    public int resultFormat = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseDecodeOptions() {
        this.autoUseAshmem = Build.VERSION.SDK_INT < 21;
        this.frameIndex = 0;
        this.canUseJpgThumbnailData = StaticOptions.useThumbnailData;
        this.isForceUseSysDecode = false;
    }
}
