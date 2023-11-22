package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.MultiClassKey;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Registry {
    private final ResourceDecoderRegistry BuiltInFictitiousFunctionClassFactory;
    public final EncoderRegistry KClassImpl$Data$declaredNonStaticMembers$2;
    public final DataRewinderRegistry MyBillsEntityDataFactory;
    public final ImageHeaderParserRegistry PlaceComponentResult;
    public final ResourceEncoderRegistry getAuthRequestContext;
    private final ModelLoaderRegistry getErrorConfigVersion;
    private final TranscoderRegistry moveToNextValue;
    private final Pools.Pool<List<Throwable>> scheduleImpl;
    private final ModelToResourceClassCache NetworkUserEntityData$$ExternalSyntheticLambda0 = new ModelToResourceClassCache();
    private final LoadPathCache lookAheadTest = new LoadPathCache();

    public Registry() {
        Pools.Pool<List<Throwable>> MyBillsEntityDataFactory = FactoryPools.MyBillsEntityDataFactory();
        this.scheduleImpl = MyBillsEntityDataFactory;
        this.getErrorConfigVersion = new ModelLoaderRegistry(MyBillsEntityDataFactory);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new EncoderRegistry();
        this.BuiltInFictitiousFunctionClassFactory = new ResourceDecoderRegistry();
        this.getAuthRequestContext = new ResourceEncoderRegistry();
        this.MyBillsEntityDataFactory = new DataRewinderRegistry();
        this.moveToNextValue = new TranscoderRegistry();
        this.PlaceComponentResult = new ImageHeaderParserRegistry();
        List asList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        ResourceDecoderRegistry resourceDecoderRegistry = this.BuiltInFictitiousFunctionClassFactory;
        synchronized (resourceDecoderRegistry) {
            ArrayList<String> arrayList2 = new ArrayList(resourceDecoderRegistry.KClassImpl$Data$declaredNonStaticMembers$2);
            resourceDecoderRegistry.KClassImpl$Data$declaredNonStaticMembers$2.clear();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                resourceDecoderRegistry.KClassImpl$Data$declaredNonStaticMembers$2.add((String) it2.next());
            }
            for (String str : arrayList2) {
                if (!arrayList.contains(str)) {
                    resourceDecoderRegistry.KClassImpl$Data$declaredNonStaticMembers$2.add(str);
                }
            }
        }
    }

    public final <Data> Registry getAuthRequestContext(Class<Data> cls, Encoder<Data> encoder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(cls, encoder);
        return this;
    }

    public final <Data, TResource> Registry BuiltInFictitiousFunctionClassFactory(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(str, resourceDecoder, cls, cls2);
        return this;
    }

    public final <TResource> Registry KClassImpl$Data$declaredNonStaticMembers$2(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.getAuthRequestContext.PlaceComponentResult(cls, resourceEncoder);
        return this;
    }

    public final Registry getAuthRequestContext(DataRewinder.Factory<?> factory) {
        DataRewinderRegistry dataRewinderRegistry = this.MyBillsEntityDataFactory;
        synchronized (dataRewinderRegistry) {
            dataRewinderRegistry.PlaceComponentResult.put(factory.KClassImpl$Data$declaredNonStaticMembers$2(), factory);
        }
        return this;
    }

    public final <TResource, Transcode> Registry BuiltInFictitiousFunctionClassFactory(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(cls, cls2, resourceTranscoder);
        return this;
    }

    public final Registry MyBillsEntityDataFactory(ImageHeaderParser imageHeaderParser) {
        ImageHeaderParserRegistry imageHeaderParserRegistry = this.PlaceComponentResult;
        synchronized (imageHeaderParserRegistry) {
            imageHeaderParserRegistry.KClassImpl$Data$declaredNonStaticMembers$2.add(imageHeaderParser);
        }
        return this;
    }

    public final <Model, Data> Registry BuiltInFictitiousFunctionClassFactory(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        ModelLoaderRegistry modelLoaderRegistry = this.getErrorConfigVersion;
        synchronized (modelLoaderRegistry) {
            MultiModelLoaderFactory multiModelLoaderFactory = modelLoaderRegistry.PlaceComponentResult;
            synchronized (multiModelLoaderFactory) {
                MultiModelLoaderFactory.Entry<?, ?> entry = new MultiModelLoaderFactory.Entry<>(cls, cls2, modelLoaderFactory);
                List<MultiModelLoaderFactory.Entry<?, ?>> list = multiModelLoaderFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                list.add(list.size(), entry);
            }
            modelLoaderRegistry.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.clear();
        }
        return this;
    }

    public final <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> KClassImpl$Data$declaredNonStaticMembers$2(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        boolean equals;
        LoadPath<Data, TResource, Transcode> KClassImpl$Data$declaredNonStaticMembers$2 = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(cls, cls2, cls3);
        equals = LoadPathCache.BuiltInFictitiousFunctionClassFactory.equals(KClassImpl$Data$declaredNonStaticMembers$2);
        if (equals) {
            return null;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            ArrayList arrayList = new ArrayList();
            for (Class cls4 : this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(cls, cls2)) {
                for (Class cls5 : this.moveToNextValue.getAuthRequestContext(cls4, cls3)) {
                    arrayList.add(new DecodePath(cls, cls4, cls5, this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(cls, cls4), this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(cls4, cls5), this.scheduleImpl));
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = arrayList.isEmpty() ? null : new LoadPath<>(cls, cls2, cls3, arrayList, this.scheduleImpl);
            LoadPathCache loadPathCache = this.lookAheadTest;
            synchronized (loadPathCache.PlaceComponentResult) {
                loadPathCache.PlaceComponentResult.put(new MultiClassKey(cls, cls2, cls3), KClassImpl$Data$declaredNonStaticMembers$2 == null ? LoadPathCache.BuiltInFictitiousFunctionClassFactory : KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final <Model, TResource, Transcode> List<Class<?>> BuiltInFictitiousFunctionClassFactory(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(cls, cls2, cls3);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
            Iterator<Class<?>> it = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(it.next(), cls2)) {
                    if (!this.moveToNextValue.getAuthRequestContext(cls4, cls3).isEmpty() && !BuiltInFictitiousFunctionClassFactory.contains(cls4)) {
                        BuiltInFictitiousFunctionClassFactory.add(cls4);
                    }
                }
            }
            ModelToResourceClassCache modelToResourceClassCache = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            List<Class<?>> unmodifiableList = Collections.unmodifiableList(BuiltInFictitiousFunctionClassFactory);
            synchronized (modelToResourceClassCache.getAuthRequestContext) {
                modelToResourceClassCache.getAuthRequestContext.put(new MultiClassKey(cls, cls2, cls3), unmodifiableList);
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean getAuthRequestContext(Resource<?> resource) {
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(resource.KClassImpl$Data$declaredNonStaticMembers$2()) != null;
    }

    public final <Model> List<ModelLoader<Model, ?>> KClassImpl$Data$declaredNonStaticMembers$2(Model model) {
        List MyBillsEntityDataFactory = this.getErrorConfigVersion.MyBillsEntityDataFactory(ModelLoaderRegistry.PlaceComponentResult(model));
        if (MyBillsEntityDataFactory.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        int size = MyBillsEntityDataFactory.size();
        List<ModelLoader<Model, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            ModelLoader<Model, ?> modelLoader = (ModelLoader) MyBillsEntityDataFactory.get(i);
            if (modelLoader.BuiltInFictitiousFunctionClassFactory(model)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(modelLoader);
            }
        }
        if (emptyList.isEmpty()) {
            throw new NoModelLoaderAvailableException(model, MyBillsEntityDataFactory);
        }
        return emptyList;
    }

    /* loaded from: classes3.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public NoModelLoaderAvailableException(java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Failed to find any ModelLoaders registered for model class: "
                r0.append(r1)
                java.lang.Class r3 = r3.getClass()
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Registry.NoModelLoaderAvailableException.<init>(java.lang.Object):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public <M> NoModelLoaderAvailableException(M r3, java.util.List<com.bumptech.glide.load.model.ModelLoader<M, ?>> r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Found ModelLoaders for model class: "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = ", but none that handle this specific model instance: "
                r0.append(r4)
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Registry.NoModelLoaderAvailableException.<init>(java.lang.Object, java.util.List):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public NoModelLoaderAvailableException(java.lang.Class<?> r3, java.lang.Class<?> r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Failed to find any ModelLoaders for model: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " and data: "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Registry.NoModelLoaderAvailableException.<init>(java.lang.Class, java.lang.Class):void");
        }
    }

    /* loaded from: classes3.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public NoResultEncoderAvailableException(java.lang.Class<?> r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Failed to find result encoder for resource class: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary."
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Registry.NoResultEncoderAvailableException.<init>(java.lang.Class):void");
        }
    }

    /* loaded from: classes3.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public NoSourceEncoderAvailableException(java.lang.Class<?> r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Failed to find source encoder for data class: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Registry.NoSourceEncoderAvailableException.<init>(java.lang.Class):void");
        }
    }

    /* loaded from: classes3.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }
}
