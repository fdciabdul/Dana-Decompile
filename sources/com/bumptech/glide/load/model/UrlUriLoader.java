package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final Set<String> BuiltInFictitiousFunctionClassFactory = Collections.unmodifiableSet(new HashSet(Arrays.asList(SemanticAttributes.FaasTriggerValues.HTTP, "https")));
    private final ModelLoader<GlideUrl, Data> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return BuiltInFictitiousFunctionClassFactory2(uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, Options options) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(new GlideUrl(uri.toString()), i, i2, options);
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = modelLoader;
    }

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: avoid collision after fix types in other method */
    private static boolean BuiltInFictitiousFunctionClassFactory2(Uri uri) {
        return BuiltInFictitiousFunctionClassFactory.contains(uri.getScheme());
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(GlideUrl.class, InputStream.class));
        }
    }
}
