package com.iap.ac.android.common.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.iap.ac.android.common.imageloader.IACImageLoader;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class ACImageLoader {
    public static final String NO_IMAGE_LOADER_ERROR = "No imageLoader impl!";
    public static final String TAG = "ACImageLoader";
    public static IACImageLoader sAcImageLoader = new IACImageLoader() { // from class: com.iap.ac.android.common.imageloader.ACImageLoader.1
        @Override // com.iap.ac.android.common.imageloader.IACImageLoader
        public final void loadImage(ImageView imageView, String str, Drawable drawable) {
            ACLog.e(ACImageLoader.TAG, ACImageLoader.NO_IMAGE_LOADER_ERROR);
            imageView.setImageDrawable(drawable);
        }

        @Override // com.iap.ac.android.common.imageloader.IACImageLoader
        public final void loadImageAsync(Context context, int i, int i2, String str, IACImageLoader.Callback callback) {
            ACLog.e(ACImageLoader.TAG, ACImageLoader.NO_IMAGE_LOADER_ERROR);
            callback.onLoadFailure(new Exception(ACImageLoader.NO_IMAGE_LOADER_ERROR));
        }
    };

    public static IACImageLoader getImageLoader() {
        return sAcImageLoader;
    }

    public static void setImageLoaderImpl(IACImageLoader iACImageLoader) {
        sAcImageLoader = iACImageLoader;
    }
}
