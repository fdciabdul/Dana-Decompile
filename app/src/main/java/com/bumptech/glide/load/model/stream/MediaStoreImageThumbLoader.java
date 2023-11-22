package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context getAuthRequestContext;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return getAuthRequestContext(uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData<InputStream> KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, Options options) {
        Uri uri2 = uri;
        if (MediaStoreUtil.PlaceComponentResult(i, i2)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri2), ThumbFetcher.PlaceComponentResult(this.getAuthRequestContext, uri2));
        }
        return null;
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.getAuthRequestContext = context.getApplicationContext();
    }

    private static boolean getAuthRequestContext(Uri uri) {
        return MediaStoreUtil.BuiltInFictitiousFunctionClassFactory(uri);
    }

    /* loaded from: classes3.dex */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context getAuthRequestContext;

        public Factory(Context context) {
            this.getAuthRequestContext = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.getAuthRequestContext);
        }
    }
}
