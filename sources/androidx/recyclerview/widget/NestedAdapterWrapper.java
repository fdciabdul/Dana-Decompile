package androidx.recyclerview.widget;

import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class NestedAdapterWrapper {
    final StableIdStorage.StableIdLookup BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    final Callback MyBillsEntityDataFactory;
    RecyclerView.AdapterDataObserver PlaceComponentResult = new RecyclerView.AdapterDataObserver() { // from class: androidx.recyclerview.widget.NestedAdapterWrapper.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.KClassImpl$Data$declaredNonStaticMembers$2 = nestedAdapterWrapper.getAuthRequestContext.getItemCount();
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(NestedAdapterWrapper.this, i, i2, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(NestedAdapterWrapper.this, i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            NestedAdapterWrapper.this.KClassImpl$Data$declaredNonStaticMembers$2 += i2;
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(NestedAdapterWrapper.this, i, i2);
            if (NestedAdapterWrapper.this.KClassImpl$Data$declaredNonStaticMembers$2 <= 0 || NestedAdapterWrapper.this.getAuthRequestContext.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.getAuthRequestContext();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            NestedAdapterWrapper.this.KClassImpl$Data$declaredNonStaticMembers$2 -= i2;
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(NestedAdapterWrapper.this, i, i2);
            if (NestedAdapterWrapper.this.KClassImpl$Data$declaredNonStaticMembers$2 > 0 || NestedAdapterWrapper.this.getAuthRequestContext.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.getAuthRequestContext();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            Preconditions.MyBillsEntityDataFactory(i3 == 1, "moving more than 1 item is not supported in RecyclerView");
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.getAuthRequestContext(NestedAdapterWrapper.this, i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            NestedAdapterWrapper.this.MyBillsEntityDataFactory.getAuthRequestContext();
        }
    };
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> getAuthRequestContext;
    final ViewTypeStorage.ViewTypeLookup getErrorConfigVersion;

    /* loaded from: classes3.dex */
    interface Callback {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

        void MyBillsEntityDataFactory(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

        void MyBillsEntityDataFactory(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2, Object obj);

        void getAuthRequestContext();

        void getAuthRequestContext(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Callback callback, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        this.getAuthRequestContext = adapter;
        this.MyBillsEntityDataFactory = callback;
        this.getErrorConfigVersion = viewTypeStorage.MyBillsEntityDataFactory(this);
        this.BuiltInFictitiousFunctionClassFactory = stableIdLookup;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = adapter.getItemCount();
        adapter.registerAdapterDataObserver(this.PlaceComponentResult);
    }
}
