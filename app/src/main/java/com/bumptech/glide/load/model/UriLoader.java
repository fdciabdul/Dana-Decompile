package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class UriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final Set<String> getAuthRequestContext = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));
    private final LocalUriFetcherFactory<Data> MyBillsEntityDataFactory;

    /* loaded from: classes3.dex */
    public interface LocalUriFetcherFactory<Data> {
        DataFetcher<Data> BuiltInFictitiousFunctionClassFactory(Uri uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return KClassImpl$Data$declaredNonStaticMembers$2(uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, Options options) {
        Uri uri2 = uri;
        return new ModelLoader.LoadData(new ObjectKey(uri2), this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(uri2));
    }

    public UriLoader(LocalUriFetcherFactory<Data> localUriFetcherFactory) {
        this.MyBillsEntityDataFactory = localUriFetcherFactory;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
        return getAuthRequestContext.contains(uri.getScheme());
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {
        private final ContentResolver MyBillsEntityDataFactory;

        public StreamFactory(ContentResolver contentResolver) {
            this.MyBillsEntityDataFactory = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public final DataFetcher<InputStream> BuiltInFictitiousFunctionClassFactory(Uri uri) {
            return new StreamLocalUriFetcher(this.MyBillsEntityDataFactory, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {
        private final ContentResolver BuiltInFictitiousFunctionClassFactory;

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this.BuiltInFictitiousFunctionClassFactory = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public final DataFetcher<ParcelFileDescriptor> BuiltInFictitiousFunctionClassFactory(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.BuiltInFictitiousFunctionClassFactory, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, ParcelFileDescriptor> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {
        private final ContentResolver getAuthRequestContext;

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this.getAuthRequestContext = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, AssetFileDescriptor> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public final DataFetcher<AssetFileDescriptor> BuiltInFictitiousFunctionClassFactory(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.getAuthRequestContext, uri);
        }
    }
}
