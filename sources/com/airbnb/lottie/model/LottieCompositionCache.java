package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes3.dex */
public class LottieCompositionCache {
    private static final LottieCompositionCache getAuthRequestContext = new LottieCompositionCache();
    public final LruCache<String, LottieComposition> KClassImpl$Data$declaredNonStaticMembers$2 = new LruCache<>(20);

    public static LottieCompositionCache BuiltInFictitiousFunctionClassFactory() {
        return getAuthRequestContext;
    }

    LottieCompositionCache() {
    }
}
