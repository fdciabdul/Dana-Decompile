package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;

/* loaded from: classes3.dex */
public class ObjectPool<T extends Poolable> {
    private static int BuiltInFictitiousFunctionClassFactory;
    private Object[] KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    public float PlaceComponentResult;
    private T getAuthRequestContext;
    private int getErrorConfigVersion;
    private int scheduleImpl;

    /* loaded from: classes3.dex */
    public static abstract class Poolable {
        public static int NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
        int PrepareContext = NetworkUserEntityData$$ExternalSyntheticLambda8;

        protected abstract Poolable MyBillsEntityDataFactory();
    }

    public static ObjectPool PlaceComponentResult(int i, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i, poolable);
            int i2 = BuiltInFictitiousFunctionClassFactory;
            objectPool.scheduleImpl = i2;
            BuiltInFictitiousFunctionClassFactory = i2 + 1;
        }
        return objectPool;
    }

    private ObjectPool(int i, T t) {
        if (i <= 0) {
            throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
        }
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Object[i];
        this.getErrorConfigVersion = 0;
        this.getAuthRequestContext = t;
        this.PlaceComponentResult = 1.0f;
        BuiltInFictitiousFunctionClassFactory(1.0f);
    }

    private void BuiltInFictitiousFunctionClassFactory(float f) {
        int i = this.MyBillsEntityDataFactory;
        int i2 = (int) (i * f);
        if (i2 <= 0) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2[i3] = this.getAuthRequestContext.MyBillsEntityDataFactory();
        }
        this.getErrorConfigVersion = i - 1;
    }

    public final T PlaceComponentResult() {
        T t;
        synchronized (this) {
            if (this.getErrorConfigVersion == -1 && this.PlaceComponentResult > 0.0f) {
                BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
            }
            t = (T) this.KClassImpl$Data$declaredNonStaticMembers$2[this.getErrorConfigVersion];
            t.PrepareContext = Poolable.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.getErrorConfigVersion--;
        }
        return t;
    }

    public final void BuiltInFictitiousFunctionClassFactory(T t) {
        synchronized (this) {
            if (t.PrepareContext != Poolable.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                if (t.PrepareContext == this.scheduleImpl) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("The object to recycle already belongs to poolId ");
                sb.append(t.PrepareContext);
                sb.append(".  Object cannot belong to two different pool instances simultaneously!");
                throw new IllegalArgumentException(sb.toString());
            }
            int i = this.getErrorConfigVersion + 1;
            this.getErrorConfigVersion = i;
            if (i >= this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                MyBillsEntityDataFactory();
            }
            t.PrepareContext = this.scheduleImpl;
            this.KClassImpl$Data$declaredNonStaticMembers$2[this.getErrorConfigVersion] = t;
        }
    }

    private void MyBillsEntityDataFactory() {
        int i = this.MyBillsEntityDataFactory;
        int i2 = i * 2;
        this.MyBillsEntityDataFactory = i2;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = this.KClassImpl$Data$declaredNonStaticMembers$2[i3];
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = objArr;
    }
}
