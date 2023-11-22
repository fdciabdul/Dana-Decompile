package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
    private final Resources MyBillsEntityDataFactory;
    private final ModelLoader<Uri, Data> PlaceComponentResult;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Integer num) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(Integer num, int i, int i2, Options options) {
        Uri authRequestContext = getAuthRequestContext(num);
        if (authRequestContext == null) {
            return null;
        }
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, i, i2, options);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.MyBillsEntityDataFactory = resources;
        this.PlaceComponentResult = modelLoader;
    }

    private Uri getAuthRequestContext(Integer num) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.MyBillsEntityDataFactory.getResourcePackageName(num.intValue()));
            sb.append('/');
            sb.append(this.MyBillsEntityDataFactory.getResourceTypeName(num.intValue()));
            sb.append('/');
            sb.append(this.MyBillsEntityDataFactory.getResourceEntryName(num.intValue()));
            return Uri.parse(sb.toString());
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received invalid resource id: ");
                sb2.append(num);
                InstrumentInjector.log_w("ResourceLoader", sb2.toString(), e);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {
        private final Resources getAuthRequestContext;

        public StreamFactory(Resources resources) {
            this.getAuthRequestContext = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Integer, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.getAuthRequestContext, multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        private final Resources getAuthRequestContext;

        public FileDescriptorFactory(Resources resources) {
            this.getAuthRequestContext = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Integer, ParcelFileDescriptor> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.getAuthRequestContext, multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        private final Resources getAuthRequestContext;

        public AssetFileDescriptorFactory(Resources resources) {
            this.getAuthRequestContext = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Integer, AssetFileDescriptor> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.getAuthRequestContext, multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {
        private final Resources BuiltInFictitiousFunctionClassFactory;

        public UriFactory(Resources resources) {
            this.BuiltInFictitiousFunctionClassFactory = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Integer, Uri> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.BuiltInFictitiousFunctionClassFactory, UnitModelLoader.getAuthRequestContext());
        }
    }
}
