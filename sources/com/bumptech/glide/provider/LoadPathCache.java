package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class LoadPathCache {
    public static final LoadPath<?, ?, ?> BuiltInFictitiousFunctionClassFactory = new LoadPath<>(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);
    public final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> PlaceComponentResult = new ArrayMap<>();
    private final AtomicReference<MultiClassKey> MyBillsEntityDataFactory = new AtomicReference<>();

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(LoadPath<?, ?, ?> loadPath) {
        return BuiltInFictitiousFunctionClassFactory.equals(loadPath);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> KClassImpl$Data$declaredNonStaticMembers$2(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey andSet = this.MyBillsEntityDataFactory.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.MyBillsEntityDataFactory = cls;
        andSet.KClassImpl$Data$declaredNonStaticMembers$2 = cls2;
        andSet.BuiltInFictitiousFunctionClassFactory = cls3;
        synchronized (this.PlaceComponentResult) {
            loadPath = (LoadPath<Data, TResource, Transcode>) this.PlaceComponentResult.get(andSet);
        }
        this.MyBillsEntityDataFactory.set(andSet);
        return loadPath;
    }
}
