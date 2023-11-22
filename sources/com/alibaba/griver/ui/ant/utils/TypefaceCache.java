package com.alibaba.griver.ui.ant.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes3.dex */
public class TypefaceCache {

    /* renamed from: a  reason: collision with root package name */
    private static TypefaceCache f6701a;
    private final Map<String, WeakReference<Typeface>> b = new ConcurrentHashMap();

    private TypefaceCache() {
    }

    public static TypefaceCache getInstance() {
        TypefaceCache typefaceCache;
        synchronized (TypefaceCache.class) {
            if (f6701a == null) {
                f6701a = new TypefaceCache();
            }
            typefaceCache = f6701a;
        }
        return typefaceCache;
    }

    public static Typeface getTypeface(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        Typeface typefaceByCat = getInstance().getTypefaceByCat(str, str2);
        if (typefaceByCat == null) {
            try {
                typefaceByCat = InstrumentInjector.typefaceCreateFromAsset(context.getAssets(), str2);
            } catch (Exception unused) {
                InstrumentInjector.log_d("ExtConfigManager", "getExtTypeface error");
            }
            if (typefaceByCat != null) {
                getInstance().putTypeface(str, str2, typefaceByCat);
            }
        }
        return typefaceByCat;
    }

    public void putTypeface(String str, String str2, Typeface typeface) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || typeface == null) {
            return;
        }
        Map<String, WeakReference<Typeface>> map = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        map.put(sb.toString(), new WeakReference<>(typeface));
    }

    public Typeface getTypefaceByCat(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Map<String, WeakReference<Typeface>> map = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        WeakReference<Typeface> weakReference = map.get(sb.toString());
        if (weakReference == null || weakReference.get() == null) {
            Map<String, WeakReference<Typeface>> map2 = this.b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            map2.remove(sb2.toString());
            return null;
        }
        return weakReference.get();
    }

    public void clear() {
        this.b.clear();
    }
}
