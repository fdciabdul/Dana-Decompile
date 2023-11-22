package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class StringLoader<Data> implements ModelLoader<String, Data> {
    private final ModelLoader<Uri, Data> BuiltInFictitiousFunctionClassFactory;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(String str, int i, int i2, Options options) {
        Uri fromFile;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            fromFile = null;
        } else if (str2.charAt(0) != '/') {
            Uri parse = Uri.parse(str2);
            fromFile = parse.getScheme() == null ? Uri.fromFile(new File(str2)) : parse;
        } else {
            fromFile = Uri.fromFile(new File(str2));
        }
        if (fromFile == null || !this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(fromFile)) {
            return null;
        }
        return this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(fromFile, i, i2, options);
    }

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.BuiltInFictitiousFunctionClassFactory = modelLoader;
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<String, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<String, ParcelFileDescriptor> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<String, AssetFileDescriptor> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(Uri.class, AssetFileDescriptor.class));
        }
    }
}
