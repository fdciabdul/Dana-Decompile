package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class TranscoderRegistry {
    private final List<Entry<?, ?>> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();

    public final <Z, R> void KClassImpl$Data$declaredNonStaticMembers$2(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        synchronized (this) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(new Entry<>(cls, cls2, resourceTranscoder));
        }
    }

    public final <Z, R> ResourceTranscoder<Z, R> KClassImpl$Data$declaredNonStaticMembers$2(Class<Z> cls, Class<R> cls2) {
        synchronized (this) {
            if (cls2.isAssignableFrom(cls)) {
                return UnitTranscoder.BuiltInFictitiousFunctionClassFactory();
            }
            for (Entry<?, ?> entry : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (entry.MyBillsEntityDataFactory(cls, cls2)) {
                    return (ResourceTranscoder<Z, R>) entry.BuiltInFictitiousFunctionClassFactory;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No transcoder registered to transcode from ");
            sb.append(cls);
            sb.append(" to ");
            sb.append(cls2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final <Z, R> List<Class<R>> getAuthRequestContext(Class<Z> cls, Class<R> cls2) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            if (cls2.isAssignableFrom(cls)) {
                arrayList.add(cls2);
                return arrayList;
            }
            Iterator<Entry<?, ?>> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                if (it.next().MyBillsEntityDataFactory(cls, cls2)) {
                    arrayList.add(cls2);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Entry<Z, R> {
        final ResourceTranscoder<Z, R> BuiltInFictitiousFunctionClassFactory;
        private final Class<Z> MyBillsEntityDataFactory;
        private final Class<R> PlaceComponentResult;

        Entry(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
            this.MyBillsEntityDataFactory = cls;
            this.PlaceComponentResult = cls2;
            this.BuiltInFictitiousFunctionClassFactory = resourceTranscoder;
        }

        public final boolean MyBillsEntityDataFactory(Class<?> cls, Class<?> cls2) {
            return this.MyBillsEntityDataFactory.isAssignableFrom(cls) && cls2.isAssignableFrom(this.PlaceComponentResult);
        }
    }
}
