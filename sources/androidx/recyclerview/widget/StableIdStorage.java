package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;

/* loaded from: classes3.dex */
interface StableIdStorage {

    /* loaded from: classes3.dex */
    public interface StableIdLookup {
        long BuiltInFictitiousFunctionClassFactory(long j);
    }

    StableIdLookup getAuthRequestContext();

    /* loaded from: classes3.dex */
    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup BuiltInFictitiousFunctionClassFactory = new StableIdLookup() { // from class: androidx.recyclerview.widget.StableIdStorage.NoStableIdStorage.1
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public final long BuiltInFictitiousFunctionClassFactory(long j) {
                return -1L;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        public final StableIdLookup getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes3.dex */
    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup MyBillsEntityDataFactory = new StableIdLookup() { // from class: androidx.recyclerview.widget.StableIdStorage.SharedPoolStableIdStorage.1
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public final long BuiltInFictitiousFunctionClassFactory(long j) {
                return j;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        public final StableIdLookup getAuthRequestContext() {
            return this.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes3.dex */
    public static class IsolatedStableIdStorage implements StableIdStorage {
        long MyBillsEntityDataFactory = 0;

        @Override // androidx.recyclerview.widget.StableIdStorage
        public final StableIdLookup getAuthRequestContext() {
            return new WrapperStableIdLookup();
        }

        /* loaded from: classes3.dex */
        class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> MyBillsEntityDataFactory = new LongSparseArray<>();

            WrapperStableIdLookup() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public final long BuiltInFictitiousFunctionClassFactory(long j) {
                Long MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(j, null);
                if (MyBillsEntityDataFactory == null) {
                    IsolatedStableIdStorage isolatedStableIdStorage = IsolatedStableIdStorage.this;
                    long j2 = isolatedStableIdStorage.MyBillsEntityDataFactory;
                    isolatedStableIdStorage.MyBillsEntityDataFactory = 1 + j2;
                    MyBillsEntityDataFactory = Long.valueOf(j2);
                    this.MyBillsEntityDataFactory.getAuthRequestContext(j, MyBillsEntityDataFactory);
                }
                return MyBillsEntityDataFactory.longValue();
            }
        }
    }
}
