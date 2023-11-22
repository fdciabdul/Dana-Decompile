package androidx.constraintlayout.core;

/* loaded from: classes3.dex */
final class Pools {

    /* loaded from: classes3.dex */
    interface Pool<T> {
        T MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(T[] tArr, int i);

        boolean PlaceComponentResult(T t);
    }

    private Pools() {
    }

    /* loaded from: classes3.dex */
    static class SimplePool<T> implements Pool<T> {
        private int BuiltInFictitiousFunctionClassFactory;
        private final Object[] PlaceComponentResult = new Object[256];

        @Override // androidx.constraintlayout.core.Pools.Pool
        public final T MyBillsEntityDataFactory() {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.PlaceComponentResult;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.BuiltInFictitiousFunctionClassFactory = i2;
                return t;
            }
            return null;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public final boolean PlaceComponentResult(T t) {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            Object[] objArr = this.PlaceComponentResult;
            if (i < objArr.length) {
                objArr[i] = t;
                this.BuiltInFictitiousFunctionClassFactory = i + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public final void MyBillsEntityDataFactory(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.BuiltInFictitiousFunctionClassFactory;
                Object[] objArr = this.PlaceComponentResult;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.BuiltInFictitiousFunctionClassFactory = i3 + 1;
                }
            }
        }
    }
}
