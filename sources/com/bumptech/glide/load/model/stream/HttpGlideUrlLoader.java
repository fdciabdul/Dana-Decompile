package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    public static final Option<Integer> getAuthRequestContext = Option.PlaceComponentResult("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    private final ModelCache<GlideUrl, GlideUrl> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(GlideUrl glideUrl) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData<InputStream> KClassImpl$Data$declaredNonStaticMembers$2(GlideUrl glideUrl, int i, int i2, Options options) {
        GlideUrl glideUrl2 = glideUrl;
        ModelCache<GlideUrl, GlideUrl> modelCache = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (modelCache != null) {
            GlideUrl authRequestContext = modelCache.getAuthRequestContext(glideUrl2);
            if (authRequestContext == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getAuthRequestContext(ModelCache.ModelKey.getAuthRequestContext(glideUrl2), glideUrl2);
            } else {
                glideUrl2 = authRequestContext;
            }
        }
        Option<Integer> option = getAuthRequestContext;
        return new ModelLoader.LoadData<>(glideUrl2, new HttpUrlFetcher(glideUrl2, ((Integer) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option) : option.PlaceComponentResult)).intValue()));
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = modelCache;
    }

    /* loaded from: classes3.dex */
    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private final ModelCache<GlideUrl, GlideUrl> getAuthRequestContext = new ModelCache<>(500);

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<GlideUrl, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.getAuthRequestContext);
        }
    }
}
