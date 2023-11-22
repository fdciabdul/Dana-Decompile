package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes3.dex */
public class ModelCache<A, B> {
    public final LruCache<ModelKey<A>, B> PlaceComponentResult;

    public ModelCache() {
        this(250L);
    }

    public ModelCache(long j) {
        this.PlaceComponentResult = new LruCache<ModelKey<A>, B>(j) { // from class: com.bumptech.glide.load.model.ModelCache.1
            @Override // com.bumptech.glide.util.LruCache
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, Object obj2) {
                ModelKey<?> modelKey = (ModelKey) obj;
                Queue<ModelKey<?>> queue = ModelKey.MyBillsEntityDataFactory;
                synchronized (queue) {
                    queue.offer(modelKey);
                }
            }
        };
    }

    public final B getAuthRequestContext(A a2) {
        ModelKey<A> authRequestContext = ModelKey.getAuthRequestContext(a2);
        B MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory((LruCache<ModelKey<A>, B>) authRequestContext);
        Queue<ModelKey<?>> queue = ModelKey.MyBillsEntityDataFactory;
        synchronized (queue) {
            queue.offer(authRequestContext);
        }
        return MyBillsEntityDataFactory;
    }

    /* loaded from: classes3.dex */
    public static final class ModelKey<A> {
        static final Queue<ModelKey<?>> MyBillsEntityDataFactory = Util.BuiltInFictitiousFunctionClassFactory(0);
        private int BuiltInFictitiousFunctionClassFactory;
        private A PlaceComponentResult;
        private int getAuthRequestContext;

        public static <A> ModelKey<A> getAuthRequestContext(A a2) {
            ModelKey<A> modelKey;
            Queue<ModelKey<?>> queue = MyBillsEntityDataFactory;
            synchronized (queue) {
                modelKey = (ModelKey<A>) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            ((ModelKey) modelKey).PlaceComponentResult = a2;
            ((ModelKey) modelKey).getAuthRequestContext = 0;
            ((ModelKey) modelKey).BuiltInFictitiousFunctionClassFactory = 0;
            return modelKey;
        }

        private ModelKey() {
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ModelKey) {
                ModelKey modelKey = (ModelKey) obj;
                return this.getAuthRequestContext == modelKey.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory == modelKey.BuiltInFictitiousFunctionClassFactory && this.PlaceComponentResult.equals(modelKey.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.BuiltInFictitiousFunctionClassFactory * 31) + this.getAuthRequestContext) * 31) + this.PlaceComponentResult.hashCode();
        }
    }
}
