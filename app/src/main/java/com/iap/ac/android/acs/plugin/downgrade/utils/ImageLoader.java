package com.iap.ac.android.acs.plugin.downgrade.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iap.ac.android.common.log.ACLog;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes3.dex */
public class ImageLoader {
    public static final String TAG = ApiDowngradeUtils.logTag(com.alibaba.griver.base.common.ImageLoader.TAG);
    public static final int TIMEOUT_IN_MILLIS = 10000;

    /* loaded from: classes3.dex */
    public static class ImageLoaderRunnable implements Runnable {
        public OnLoaderListener listener;
        public String url;

        public ImageLoaderRunnable(String str, OnLoaderListener onLoaderListener) {
            this.url = str;
            this.listener = onLoaderListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.listener == null || TextUtils.isEmpty(this.url)) {
                return;
            }
            String str = ImageLoader.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("load image url: ");
            sb.append(this.url);
            ACLog.d(str, sb.toString());
            try {
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(this.url).openConnection()));
                uRLConnection.setConnectTimeout(10000);
                uRLConnection.setReadTimeout(10000);
                String str2 = ImageLoader.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("load image length: ");
                sb2.append(uRLConnection.getContentLength());
                ACLog.d(str2, sb2.toString());
                final Bitmap decodeStream = BitmapFactory.decodeStream(uRLConnection.getInputStream());
                ApiDowngradeUtils.runOnMain(new Runnable() { // from class: com.iap.ac.android.acs.plugin.downgrade.utils.ImageLoader.ImageLoaderRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ACLog.d(ImageLoader.TAG, "listener.onImageLoaded");
                        ImageLoaderRunnable.this.listener.onImageLoaded(decodeStream);
                    }
                });
            } catch (Throwable th) {
                ACLog.e(ImageLoader.TAG, "load onImageLoaded exception.", th);
                ApiDowngradeUtils.runOnMain(new Runnable() { // from class: com.iap.ac.android.acs.plugin.downgrade.utils.ImageLoader.ImageLoaderRunnable.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ImageLoaderRunnable.this.listener != null) {
                            ImageLoaderRunnable.this.listener.onImageLoaded(null);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnLoaderListener {
        void onImageLoaded(Bitmap bitmap);
    }

    public static void loadImage(final ImageView imageView, String str, final Drawable drawable) {
        AsyncTask.execute(new ImageLoaderRunnable(str, new OnLoaderListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.utils.ImageLoader.1
            @Override // com.iap.ac.android.acs.plugin.downgrade.utils.ImageLoader.OnLoaderListener
            public final void onImageLoaded(Bitmap bitmap) {
                if (bitmap == null) {
                    imageView.setImageDrawable(drawable);
                } else {
                    imageView.setImageBitmap(bitmap);
                }
                String str2 = ImageLoader.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("loadImage() onImageLoaded bitmap is ");
                sb.append(bitmap);
                ACLog.d(str2, sb.toString());
            }
        }));
    }
}
