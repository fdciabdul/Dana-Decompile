package com.iap.ac.android.region.cdp.delegate.defaults;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.region.cdp.delegate.ImageService;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes8.dex */
public class DefaultImageService implements ImageService {
    public static final String TAG = CdpUtils.logTag("DefaultImageService");
    public final LruCache<String, Bitmap> mMemoryCache;

    /* loaded from: classes8.dex */
    public static class LazyHolder {
        public static final DefaultImageService INSTANCE = new DefaultImageService();
    }

    public static DefaultImageService getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override // com.iap.ac.android.region.cdp.delegate.ImageService
    public void loadImage(Context context, final String str, ImageView imageView, final ImageService.CallBack callBack) {
        if (imageView == null) {
            ACLog.d(TAG, "image loading canceled: the imageView is null");
            return;
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("clear image view before loading: url = [");
        sb.append(str);
        sb.append("]");
        ACLog.d(str2, sb.toString());
        InstrumentInjector.Resources_setImageResource(imageView, 17170445);
        if (TextUtils.isEmpty(str)) {
            ACLog.d(str2, "image loading canceled: the url is empty");
            return;
        }
        Bitmap bitmap = this.mMemoryCache.get(str);
        if (bitmap != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("image loaded from the memory cache: url = [");
            sb2.append(str);
            sb2.append("]");
            ACLog.d(str2, sb2.toString());
            imageView.setImageBitmap(bitmap);
            if (callBack != null) {
                callBack.onSuccess(str);
                return;
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("no image in the memory cache: url = [");
        sb3.append(str);
        sb3.append("]");
        ACLog.d(str2, sb3.toString());
        imageView.setTag(str);
        final WeakReference weakReference = new WeakReference(imageView);
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<Bitmap>() { // from class: com.iap.ac.android.region.cdp.delegate.defaults.DefaultImageService.2
            @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
            public void onFailure(Exception exc) {
                ImageService.CallBack callBack2 = callBack;
                if (callBack2 != null) {
                    callBack2.onFail(str);
                }
                String str3 = DefaultImageService.TAG;
                StringBuilder a2 = a.a("download image failed (url = [");
                a2.append(str);
                a2.append("]): ");
                a2.append(exc);
                ACLog.e(str3, a2.toString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.iap.ac.android.common.task.async.IAPAsyncTask.Runner
            public Bitmap execute() throws Exception {
                String str3 = DefaultImageService.TAG;
                StringBuilder a2 = a.a("image downloading start: url = [");
                a2.append(str);
                a2.append("]");
                ACLog.d(str3, a2.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection())));
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }

            @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
            public void onSuccess(Bitmap bitmap2) {
                String str3 = DefaultImageService.TAG;
                StringBuilder a2 = a.a("image downloaded: url = [");
                a2.append(str);
                a2.append("]");
                ACLog.d(str3, a2.toString());
                if (DefaultImageService.this.mMemoryCache.get(str) == null) {
                    DefaultImageService.this.mMemoryCache.put(str, bitmap2);
                    String str4 = DefaultImageService.TAG;
                    StringBuilder a3 = a.a("memory image cache updated: url = [");
                    a3.append(str);
                    a3.append("]");
                    ACLog.d(str4, a3.toString());
                }
                ImageView imageView2 = (ImageView) weakReference.get();
                if (imageView2 == null) {
                    String str5 = DefaultImageService.TAG;
                    StringBuilder a4 = a.a("image downloaded but the imageView has been released: url = [");
                    a4.append(str);
                    a4.append("]");
                    ACLog.d(str5, a4.toString());
                    ImageService.CallBack callBack2 = callBack;
                    if (callBack2 != null) {
                        callBack2.onFail(str);
                        return;
                    }
                    return;
                }
                Object tag = imageView2.getTag();
                if (!(tag instanceof String) || !tag.equals(str)) {
                    String str6 = DefaultImageService.TAG;
                    StringBuilder a5 = a.a("image downloaded but the imageView's tag is mismatched: url = [");
                    a5.append(str);
                    a5.append("]");
                    ACLog.d(str6, a5.toString());
                    ImageService.CallBack callBack3 = callBack;
                    if (callBack3 != null) {
                        callBack3.onFail(str);
                        return;
                    }
                    return;
                }
                imageView2.setImageBitmap(bitmap2);
                ImageService.CallBack callBack4 = callBack;
                if (callBack4 != null) {
                    callBack4.onSuccess(str);
                }
            }
        });
    }

    public DefaultImageService() {
        this.mMemoryCache = new LruCache<String, Bitmap>((int) ((Runtime.getRuntime().maxMemory() / ConvertUtils.KB) / 8)) { // from class: com.iap.ac.android.region.cdp.delegate.defaults.DefaultImageService.1
            @Override // android.util.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }
}
