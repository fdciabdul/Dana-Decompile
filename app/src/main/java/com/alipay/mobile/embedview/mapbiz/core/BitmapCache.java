package com.alipay.mobile.embedview.mapbiz.core;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import java.lang.ref.SoftReference;

/* loaded from: classes6.dex */
public class BitmapCache {
    public static final BitmapCache INSTANCE = new BitmapCache();

    /* renamed from: a  reason: collision with root package name */
    private LruCache<String, SoftReference<Bitmap>> f7137a = new LruCache<>(50);

    private BitmapCache() {
    }

    public Bitmap getCacheOfWeb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SoftReference<Bitmap> softReference = this.f7137a.get(str);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void putCacheOfWeb(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7137a.put(str, new SoftReference<>(bitmap));
    }
}
