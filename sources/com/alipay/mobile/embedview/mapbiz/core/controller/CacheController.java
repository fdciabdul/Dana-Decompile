package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.lang.ref.SoftReference;

/* loaded from: classes6.dex */
public class CacheController extends H5MapController {

    /* renamed from: a  reason: collision with root package name */
    private LruCache<String, SoftReference<Bitmap>> f7147a;
    private LruCache<String, SoftReference<String>> b;

    public CacheController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7147a = new LruCache<>(20);
        this.b = new LruCache<>(20);
    }

    public Bitmap getCacheOfDSL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SoftReference<Bitmap> softReference = this.f7147a.get(str);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void putCacheOfDSL(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7147a.put(str, new SoftReference<>(bitmap));
    }

    public String getBinaryOfDSL(String str) {
        SoftReference<String> softReference;
        if (TextUtils.isEmpty(str) || (softReference = this.b.get(str)) == null) {
            return null;
        }
        return softReference.get();
    }

    public void putBinaryOfDSL(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, new SoftReference<>(str2));
    }
}
