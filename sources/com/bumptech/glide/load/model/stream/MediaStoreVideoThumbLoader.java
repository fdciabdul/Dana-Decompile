package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return BuiltInFictitiousFunctionClassFactory2(uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData<InputStream> KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, Options options) {
        Uri uri2 = uri;
        if (MediaStoreUtil.PlaceComponentResult(i, i2) && BuiltInFictitiousFunctionClassFactory(options)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri2), ThumbFetcher.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, uri2));
        }
        return null;
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.MyBillsEntityDataFactory = context.getApplicationContext();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Options options) {
        Option<Long> option = VideoDecoder.getAuthRequestContext;
        Long l = (Long) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option) : option.PlaceComponentResult);
        return l != null && l.longValue() == -1;
    }

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: avoid collision after fix types in other method */
    private static boolean BuiltInFictitiousFunctionClassFactory2(Uri uri) {
        return MediaStoreUtil.KClassImpl$Data$declaredNonStaticMembers$2(uri);
    }

    /* loaded from: classes3.dex */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context PlaceComponentResult;

        public Factory(Context context) {
            this.PlaceComponentResult = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.PlaceComponentResult);
        }
    }
}
