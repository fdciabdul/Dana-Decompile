package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ResourceDecoderRegistry {
    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    private final Map<String, List<Entry<?, ?>>> BuiltInFictitiousFunctionClassFactory = new HashMap();

    public final <T, R> List<ResourceDecoder<T, R>> KClassImpl$Data$declaredNonStaticMembers$2(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            Iterator<String> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                List<Entry<?, ?>> list = this.BuiltInFictitiousFunctionClassFactory.get(it.next());
                if (list != null) {
                    for (Entry<?, ?> entry : list) {
                        if (entry.getAuthRequestContext(cls, cls2)) {
                            arrayList.add(entry.BuiltInFictitiousFunctionClassFactory);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final <T, R> List<Class<R>> BuiltInFictitiousFunctionClassFactory(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            Iterator<String> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                List<Entry<?, ?>> list = this.BuiltInFictitiousFunctionClassFactory.get(it.next());
                if (list != null) {
                    for (Entry<?, ?> entry : list) {
                        if (entry.getAuthRequestContext(cls, cls2) && !arrayList.contains(entry.PlaceComponentResult)) {
                            arrayList.add(entry.PlaceComponentResult);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final <T, R> void PlaceComponentResult(String str, ResourceDecoder<T, R> resourceDecoder, Class<T> cls, Class<R> cls2) {
        synchronized (this) {
            PlaceComponentResult(str).add(new Entry<>(cls, cls2, resourceDecoder));
        }
    }

    private List<Entry<?, ?>> PlaceComponentResult(String str) {
        List<Entry<?, ?>> list;
        synchronized (this) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.contains(str)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(str);
            }
            list = this.BuiltInFictitiousFunctionClassFactory.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.BuiltInFictitiousFunctionClassFactory.put(str, list);
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Entry<T, R> {
        final ResourceDecoder<T, R> BuiltInFictitiousFunctionClassFactory;
        private final Class<T> KClassImpl$Data$declaredNonStaticMembers$2;
        final Class<R> PlaceComponentResult;

        public Entry(Class<T> cls, Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cls;
            this.PlaceComponentResult = cls2;
            this.BuiltInFictitiousFunctionClassFactory = resourceDecoder;
        }

        public final boolean getAuthRequestContext(Class<?> cls, Class<?> cls2) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isAssignableFrom(cls) && cls2.isAssignableFrom(this.PlaceComponentResult);
        }
    }
}
