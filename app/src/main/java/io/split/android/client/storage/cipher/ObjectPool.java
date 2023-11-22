package io.split.android.client.storage.cipher;

import androidx.core.util.Pools;

/* loaded from: classes6.dex */
class ObjectPool<T> {
    private final ObjectPoolFactory<T> mFactory;
    private final Pools.SynchronizedPool<T> mPool;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectPool(int i, ObjectPoolFactory<T> objectPoolFactory) {
        this.mFactory = objectPoolFactory;
        this.mPool = new Pools.SynchronizedPool<>(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T acquire() {
        T BuiltInFictitiousFunctionClassFactory = this.mPool.BuiltInFictitiousFunctionClassFactory();
        return BuiltInFictitiousFunctionClassFactory == null ? this.mFactory.createObject() : BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release(T t) {
        this.mPool.MyBillsEntityDataFactory(t);
    }
}
