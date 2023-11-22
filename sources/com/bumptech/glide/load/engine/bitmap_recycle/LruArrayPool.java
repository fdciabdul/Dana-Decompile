package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class LruArrayPool implements ArrayPool {
    private final Map<Class<?>, ArrayAdapterInterface<?>> BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final KeyPool MyBillsEntityDataFactory;
    private final GroupedLinkedMap<Key, Object> PlaceComponentResult;
    private final int getAuthRequestContext;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> moveToNextValue;

    public LruArrayPool() {
        this.PlaceComponentResult = new GroupedLinkedMap<>();
        this.MyBillsEntityDataFactory = new KeyPool();
        this.moveToNextValue = new HashMap();
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        this.getAuthRequestContext = 4194304;
    }

    public LruArrayPool(int i) {
        this.PlaceComponentResult = new GroupedLinkedMap<>();
        this.MyBillsEntityDataFactory = new KeyPool();
        this.moveToNextValue = new HashMap();
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        this.getAuthRequestContext = i;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public final <T> void BuiltInFictitiousFunctionClassFactory(T t) {
        synchronized (this) {
            Class<?> cls = t.getClass();
            ArrayAdapterInterface<T> PlaceComponentResult = PlaceComponentResult(cls);
            int BuiltInFictitiousFunctionClassFactory = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((ArrayAdapterInterface<T>) t);
            int KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2() * BuiltInFictitiousFunctionClassFactory;
            if (BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2)) {
                KeyPool keyPool = this.MyBillsEntityDataFactory;
                Object obj = (Poolable) keyPool.PlaceComponentResult.poll();
                if (obj == null) {
                    obj = keyPool.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                Key key = (Key) obj;
                key.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
                key.MyBillsEntityDataFactory = cls;
                this.PlaceComponentResult.MyBillsEntityDataFactory(key, t);
                NavigableMap<Integer, Integer> authRequestContext = getAuthRequestContext(cls);
                Integer num = (Integer) authRequestContext.get(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2));
                authRequestContext.put(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
                this.KClassImpl$Data$declaredNonStaticMembers$2 += KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public final <T> T BuiltInFictitiousFunctionClassFactory(Class<T> cls) {
        T t;
        synchronized (this) {
            KeyPool keyPool = this.MyBillsEntityDataFactory;
            Object obj = (Poolable) keyPool.PlaceComponentResult.poll();
            if (obj == null) {
                obj = keyPool.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            Key key = (Key) obj;
            key.KClassImpl$Data$declaredNonStaticMembers$2 = 8;
            key.MyBillsEntityDataFactory = cls;
            t = (T) MyBillsEntityDataFactory(key, cls);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public final <T> T KClassImpl$Data$declaredNonStaticMembers$2(int i, Class<T> cls) {
        Key key;
        T t;
        synchronized (this) {
            Integer ceilingKey = getAuthRequestContext(cls).ceilingKey(Integer.valueOf(i));
            if (BuiltInFictitiousFunctionClassFactory(i, ceilingKey)) {
                KeyPool keyPool = this.MyBillsEntityDataFactory;
                int intValue = ceilingKey.intValue();
                Object obj = (Poolable) keyPool.PlaceComponentResult.poll();
                if (obj == null) {
                    obj = keyPool.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                key = (Key) obj;
                key.KClassImpl$Data$declaredNonStaticMembers$2 = intValue;
                key.MyBillsEntityDataFactory = cls;
            } else {
                KeyPool keyPool2 = this.MyBillsEntityDataFactory;
                Object obj2 = (Poolable) keyPool2.PlaceComponentResult.poll();
                if (obj2 == null) {
                    obj2 = keyPool2.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                key = (Key) obj2;
                key.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                key.MyBillsEntityDataFactory = cls;
            }
            t = (T) MyBillsEntityDataFactory(key, cls);
        }
        return t;
    }

    private <T> T MyBillsEntityDataFactory(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> PlaceComponentResult = PlaceComponentResult(cls);
        T t = (T) this.PlaceComponentResult.getAuthRequestContext(key);
        if (t != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 -= PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((ArrayAdapterInterface<T>) t) * PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            PlaceComponentResult(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((ArrayAdapterInterface<T>) t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(), 2)) {
                String BuiltInFictitiousFunctionClassFactory = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb = new StringBuilder();
                sb.append("Allocated ");
                sb.append(key.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(" bytes");
                InstrumentInjector.log_v(BuiltInFictitiousFunctionClassFactory, sb.toString());
            }
            return PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(key.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return t;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int i) {
        return i <= this.getAuthRequestContext / 2;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int i, Integer num) {
        return num != null && (MyBillsEntityDataFactory() || num.intValue() <= i * 8);
    }

    private boolean MyBillsEntityDataFactory() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return i == 0 || this.getAuthRequestContext / i >= 2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public final void getAuthRequestContext() {
        synchronized (this) {
            KClassImpl$Data$declaredNonStaticMembers$2(0);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public final void MyBillsEntityDataFactory(int i) {
        synchronized (this) {
            try {
                if (i >= 40) {
                    synchronized (this) {
                        KClassImpl$Data$declaredNonStaticMembers$2(0);
                    }
                } else if (i >= 20 || i == 15) {
                    KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext / 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        while (this.KClassImpl$Data$declaredNonStaticMembers$2 > i) {
            Object PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult();
            Preconditions.PlaceComponentResult(PlaceComponentResult);
            ArrayAdapterInterface PlaceComponentResult2 = PlaceComponentResult(PlaceComponentResult.getClass());
            this.KClassImpl$Data$declaredNonStaticMembers$2 -= PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory((ArrayAdapterInterface) PlaceComponentResult) * PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2();
            PlaceComponentResult(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory((ArrayAdapterInterface) PlaceComponentResult), PlaceComponentResult.getClass());
            if (Log.isLoggable(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(), 2)) {
                String BuiltInFictitiousFunctionClassFactory = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb = new StringBuilder();
                sb.append("evicted: ");
                sb.append(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory((ArrayAdapterInterface) PlaceComponentResult));
                InstrumentInjector.log_v(BuiltInFictitiousFunctionClassFactory, sb.toString());
            }
        }
    }

    private void PlaceComponentResult(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> authRequestContext = getAuthRequestContext(cls);
        Integer num = (Integer) authRequestContext.get(Integer.valueOf(i));
        if (num == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(i);
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num.intValue() == 1) {
            authRequestContext.remove(Integer.valueOf(i));
        } else {
            authRequestContext.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> getAuthRequestContext(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.moveToNextValue.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.moveToNextValue.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private <T> ArrayAdapterInterface<T> PlaceComponentResult(Class<T> cls) {
        IntegerArrayAdapter integerArrayAdapter = (ArrayAdapterInterface<T>) this.BuiltInFictitiousFunctionClassFactory.get(cls);
        if (integerArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                integerArrayAdapter = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                integerArrayAdapter = new ByteArrayAdapter();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("No array pool found for: ");
                sb.append(cls.getSimpleName());
                throw new IllegalArgumentException(sb.toString());
            }
            this.BuiltInFictitiousFunctionClassFactory.put(cls, integerArrayAdapter);
        }
        return integerArrayAdapter;
    }

    /* loaded from: classes3.dex */
    static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public final /* synthetic */ Key KClassImpl$Data$declaredNonStaticMembers$2() {
            return new Key(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Key implements Poolable {
        int KClassImpl$Data$declaredNonStaticMembers$2;
        Class<?> MyBillsEntityDataFactory;
        private final KeyPool PlaceComponentResult;

        Key(KeyPool keyPool) {
            this.PlaceComponentResult = keyPool;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                return this.KClassImpl$Data$declaredNonStaticMembers$2 == key.KClassImpl$Data$declaredNonStaticMembers$2 && this.MyBillsEntityDataFactory == key.MyBillsEntityDataFactory;
            }
            return false;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Key{size=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("array=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append('}');
            return sb.toString();
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void BuiltInFictitiousFunctionClassFactory() {
            KeyPool keyPool = this.PlaceComponentResult;
            if (keyPool.PlaceComponentResult.size() < 20) {
                keyPool.PlaceComponentResult.offer(this);
            }
        }

        public final int hashCode() {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Class<?> cls = this.MyBillsEntityDataFactory;
            return (i * 31) + (cls != null ? cls.hashCode() : 0);
        }
    }
}
