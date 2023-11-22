package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LruCache<T, Y> {
    private long BuiltInFictitiousFunctionClassFactory;
    private final Map<T, Entry<Y>> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap(100, 0.75f, true);
    private final long MyBillsEntityDataFactory;
    private long PlaceComponentResult;

    public int BuiltInFictitiousFunctionClassFactory(Y y) {
        return 1;
    }

    protected void KClassImpl$Data$declaredNonStaticMembers$2(T t, Y y) {
    }

    public LruCache(long j) {
        this.MyBillsEntityDataFactory = j;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    public final long BuiltInFictitiousFunctionClassFactory() {
        long j;
        synchronized (this) {
            j = this.BuiltInFictitiousFunctionClassFactory;
        }
        return j;
    }

    public final long getAuthRequestContext() {
        long j;
        synchronized (this) {
            j = this.PlaceComponentResult;
        }
        return j;
    }

    public final Y MyBillsEntityDataFactory(T t) {
        Y y;
        synchronized (this) {
            Entry<Y> entry = this.KClassImpl$Data$declaredNonStaticMembers$2.get(t);
            y = entry != null ? entry.BuiltInFictitiousFunctionClassFactory : null;
        }
        return y;
    }

    public final Y getAuthRequestContext(T t, Y y) {
        synchronized (this) {
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(y);
            long j = BuiltInFictitiousFunctionClassFactory;
            if (j >= this.BuiltInFictitiousFunctionClassFactory) {
                KClassImpl$Data$declaredNonStaticMembers$2(t, y);
                return null;
            }
            if (y != null) {
                this.PlaceComponentResult += j;
            }
            Entry<Y> put = this.KClassImpl$Data$declaredNonStaticMembers$2.put(t, y == null ? null : new Entry<>(y, BuiltInFictitiousFunctionClassFactory));
            if (put != null) {
                this.PlaceComponentResult -= put.PlaceComponentResult;
                if (!put.BuiltInFictitiousFunctionClassFactory.equals(y)) {
                    KClassImpl$Data$declaredNonStaticMembers$2(t, put.BuiltInFictitiousFunctionClassFactory);
                }
            }
            MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
            return put != null ? put.BuiltInFictitiousFunctionClassFactory : null;
        }
    }

    public final Y KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        synchronized (this) {
            Entry<Y> remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(t);
            if (remove == null) {
                return null;
            }
            this.PlaceComponentResult -= remove.PlaceComponentResult;
            return remove.BuiltInFictitiousFunctionClassFactory;
        }
    }

    public final void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(long j) {
        synchronized (this) {
            while (this.PlaceComponentResult > j) {
                Iterator<Map.Entry<T, Entry<Y>>> it = this.KClassImpl$Data$declaredNonStaticMembers$2.entrySet().iterator();
                Map.Entry<T, Entry<Y>> next = it.next();
                Entry<Y> value = next.getValue();
                this.PlaceComponentResult -= value.PlaceComponentResult;
                T key = next.getKey();
                it.remove();
                KClassImpl$Data$declaredNonStaticMembers$2(key, value.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Entry<Y> {
        final Y BuiltInFictitiousFunctionClassFactory;
        final int PlaceComponentResult;

        Entry(Y y, int i) {
            this.BuiltInFictitiousFunctionClassFactory = y;
            this.PlaceComponentResult = i;
        }
    }
}
