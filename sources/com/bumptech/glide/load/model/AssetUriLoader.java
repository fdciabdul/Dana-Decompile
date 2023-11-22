package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final int PlaceComponentResult = 22;
    private final AssetFetcherFactory<Data> BuiltInFictitiousFunctionClassFactory;
    private final AssetManager getAuthRequestContext;

    /* loaded from: classes3.dex */
    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> KClassImpl$Data$declaredNonStaticMembers$2(AssetManager assetManager, String str);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return PlaceComponentResult(uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, Options options) {
        Uri uri2 = uri;
        return new ModelLoader.LoadData(new ObjectKey(uri2), this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, uri2.toString().substring(PlaceComponentResult)));
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.getAuthRequestContext = assetManager;
        this.BuiltInFictitiousFunctionClassFactory = assetFetcherFactory;
    }

    private static boolean PlaceComponentResult(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {
        private final AssetManager BuiltInFictitiousFunctionClassFactory;

        public StreamFactory(AssetManager assetManager) {
            this.BuiltInFictitiousFunctionClassFactory = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.BuiltInFictitiousFunctionClassFactory, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public final DataFetcher<InputStream> KClassImpl$Data$declaredNonStaticMembers$2(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, AssetFetcherFactory<ParcelFileDescriptor> {
        private final AssetManager MyBillsEntityDataFactory;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.MyBillsEntityDataFactory = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, ParcelFileDescriptor> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.MyBillsEntityDataFactory, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public final DataFetcher<ParcelFileDescriptor> KClassImpl$Data$declaredNonStaticMembers$2(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }
    }
}
