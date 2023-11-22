package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
interface ViewTypeStorage {

    /* loaded from: classes3.dex */
    public interface ViewTypeLookup {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        int MyBillsEntityDataFactory(int i);

        int PlaceComponentResult(int i);
    }

    NestedAdapterWrapper MyBillsEntityDataFactory(int i);

    ViewTypeLookup MyBillsEntityDataFactory(NestedAdapterWrapper nestedAdapterWrapper);

    /* loaded from: classes3.dex */
    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {
        SparseArray<List<NestedAdapterWrapper>> BuiltInFictitiousFunctionClassFactory = new SparseArray<>();

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public final NestedAdapterWrapper MyBillsEntityDataFactory(int i) {
            List<NestedAdapterWrapper> list = this.BuiltInFictitiousFunctionClassFactory.get(i);
            if (list == null || list.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot find the wrapper for global view type ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            return list.get(0);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public final ViewTypeLookup MyBillsEntityDataFactory(NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        /* loaded from: classes3.dex */
        class WrapperViewTypeLookup implements ViewTypeLookup {
            final NestedAdapterWrapper KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public final int PlaceComponentResult(int i) {
                return i;
            }

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public final int MyBillsEntityDataFactory(int i) {
                List<NestedAdapterWrapper> list = SharedIdRangeViewTypeStorage.this.BuiltInFictitiousFunctionClassFactory.get(i);
                if (list == null) {
                    list = new ArrayList<>();
                    SharedIdRangeViewTypeStorage.this.BuiltInFictitiousFunctionClassFactory.put(i, list);
                }
                if (!list.contains(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    list.add(this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                return i;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                SharedIdRangeViewTypeStorage sharedIdRangeViewTypeStorage = SharedIdRangeViewTypeStorage.this;
                NestedAdapterWrapper nestedAdapterWrapper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                for (int size = sharedIdRangeViewTypeStorage.BuiltInFictitiousFunctionClassFactory.size() - 1; size >= 0; size--) {
                    List<NestedAdapterWrapper> valueAt = sharedIdRangeViewTypeStorage.BuiltInFictitiousFunctionClassFactory.valueAt(size);
                    if (valueAt.remove(nestedAdapterWrapper) && valueAt.isEmpty()) {
                        sharedIdRangeViewTypeStorage.BuiltInFictitiousFunctionClassFactory.removeAt(size);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class IsolatedViewTypeStorage implements ViewTypeStorage {
        SparseArray<NestedAdapterWrapper> MyBillsEntityDataFactory = new SparseArray<>();
        int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public final NestedAdapterWrapper MyBillsEntityDataFactory(int i) {
            NestedAdapterWrapper nestedAdapterWrapper = this.MyBillsEntityDataFactory.get(i);
            if (nestedAdapterWrapper != null) {
                return nestedAdapterWrapper;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find the wrapper for global view type ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public final ViewTypeLookup MyBillsEntityDataFactory(NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        /* loaded from: classes3.dex */
        class WrapperViewTypeLookup implements ViewTypeLookup {
            final NestedAdapterWrapper KClassImpl$Data$declaredNonStaticMembers$2;
            private SparseIntArray MyBillsEntityDataFactory = new SparseIntArray(1);
            private SparseIntArray getAuthRequestContext = new SparseIntArray(1);

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public final int MyBillsEntityDataFactory(int i) {
                int indexOfKey = this.MyBillsEntityDataFactory.indexOfKey(i);
                if (indexOfKey >= 0) {
                    return this.MyBillsEntityDataFactory.valueAt(indexOfKey);
                }
                IsolatedViewTypeStorage isolatedViewTypeStorage = IsolatedViewTypeStorage.this;
                NestedAdapterWrapper nestedAdapterWrapper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = isolatedViewTypeStorage.KClassImpl$Data$declaredNonStaticMembers$2;
                isolatedViewTypeStorage.KClassImpl$Data$declaredNonStaticMembers$2 = i2 + 1;
                isolatedViewTypeStorage.MyBillsEntityDataFactory.put(i2, nestedAdapterWrapper);
                this.MyBillsEntityDataFactory.put(i, i2);
                this.getAuthRequestContext.put(i2, i);
                return i2;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public final int PlaceComponentResult(int i) {
                int indexOfKey = this.getAuthRequestContext.indexOfKey(i);
                if (indexOfKey < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("requested global type ");
                    sb.append(i);
                    sb.append(" does not belong to the adapter:");
                    sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
                    throw new IllegalStateException(sb.toString());
                }
                return this.getAuthRequestContext.valueAt(indexOfKey);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                IsolatedViewTypeStorage isolatedViewTypeStorage = IsolatedViewTypeStorage.this;
                NestedAdapterWrapper nestedAdapterWrapper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                for (int size = isolatedViewTypeStorage.MyBillsEntityDataFactory.size() - 1; size >= 0; size--) {
                    if (isolatedViewTypeStorage.MyBillsEntityDataFactory.valueAt(size) == nestedAdapterWrapper) {
                        isolatedViewTypeStorage.MyBillsEntityDataFactory.removeAt(size);
                    }
                }
            }
        }
    }
}
