package androidx.core.util;

/* loaded from: classes3.dex */
public final class Pools {

    /* loaded from: classes3.dex */
    public interface Pool<T> {
        T BuiltInFictitiousFunctionClassFactory();

        boolean MyBillsEntityDataFactory(T t);
    }

    private Pools() {
    }

    /* loaded from: classes3.dex */
    public static class SimplePool<T> implements Pool<T> {
        private int BuiltInFictitiousFunctionClassFactory;
        private final Object[] getAuthRequestContext;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.getAuthRequestContext = new Object[i];
        }

        @Override // androidx.core.util.Pools.Pool
        public T BuiltInFictitiousFunctionClassFactory() {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.getAuthRequestContext;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.BuiltInFictitiousFunctionClassFactory = i2;
                return t;
            }
            return null;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean MyBillsEntityDataFactory(T t) {
            if (PlaceComponentResult(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.BuiltInFictitiousFunctionClassFactory;
            Object[] objArr = this.getAuthRequestContext;
            if (i < objArr.length) {
                objArr[i] = t;
                this.BuiltInFictitiousFunctionClassFactory = i + 1;
                return true;
            }
            return false;
        }

        private boolean PlaceComponentResult(T t) {
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory; i++) {
                if (this.getAuthRequestContext[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object getAuthRequestContext;

        public SynchronizedPool(int i) {
            super(i);
            this.getAuthRequestContext = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public final T BuiltInFictitiousFunctionClassFactory() {
            T t;
            synchronized (this.getAuthRequestContext) {
                t = (T) super.BuiltInFictitiousFunctionClassFactory();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public final boolean MyBillsEntityDataFactory(T t) {
            boolean MyBillsEntityDataFactory;
            synchronized (this.getAuthRequestContext) {
                MyBillsEntityDataFactory = super.MyBillsEntityDataFactory(t);
            }
            return MyBillsEntityDataFactory;
        }
    }
}
