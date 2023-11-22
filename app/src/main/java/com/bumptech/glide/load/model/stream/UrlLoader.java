package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes3.dex */
public class UrlLoader implements ModelLoader<URL, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> PlaceComponentResult;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(URL url) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData<InputStream> KClassImpl$Data$declaredNonStaticMembers$2(URL url, int i, int i2, Options options) {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(new GlideUrl(url), i, i2, options);
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.PlaceComponentResult = modelLoader;
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory implements ModelLoaderFactory<URL, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<URL, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(GlideUrl.class, InputStream.class));
        }
    }
}
