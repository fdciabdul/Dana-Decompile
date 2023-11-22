package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ConcatAdapterController;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ConcatAdapterController KClassImpl$Data$declaredNonStaticMembers$2;

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(Config.KClassImpl$Data$declaredNonStaticMembers$2, adapterArr);
    }

    @SafeVarargs
    private ConcatAdapter(Config config, RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(config, Arrays.asList(adapterArr));
    }

    private ConcatAdapter(Config config, List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ConcatAdapterController(this, config);
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> it = list.iterator();
        while (it.hasNext()) {
            PlaceComponentResult(it.next());
        }
        super.setHasStableIds(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }

    private boolean PlaceComponentResult(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult((RecyclerView.Adapter<RecyclerView.ViewHolder>) adapter);
    }

    public final boolean MyBillsEntityDataFactory(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((RecyclerView.Adapter<RecyclerView.ViewHolder>) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        ConcatAdapterController concatAdapterController = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ConcatAdapterController.WrapperAndLocalPosition BuiltInFictitiousFunctionClassFactory = concatAdapterController.BuiltInFictitiousFunctionClassFactory(i);
        NestedAdapterWrapper nestedAdapterWrapper = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory = nestedAdapterWrapper.getErrorConfigVersion.MyBillsEntityDataFactory(nestedAdapterWrapper.getAuthRequestContext.getItemViewType(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory));
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = false;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
        concatAdapterController.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        return MyBillsEntityDataFactory;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        NestedAdapterWrapper MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.MyBillsEntityDataFactory(i);
        return MyBillsEntityDataFactory.getAuthRequestContext.onCreateViewHolder(viewGroup, MyBillsEntityDataFactory.getErrorConfigVersion.PlaceComponentResult(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ConcatAdapterController concatAdapterController = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ConcatAdapterController.WrapperAndLocalPosition BuiltInFictitiousFunctionClassFactory = concatAdapterController.BuiltInFictitiousFunctionClassFactory(i);
        concatAdapterController.BuiltInFictitiousFunctionClassFactory.put(viewHolder, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        NestedAdapterWrapper nestedAdapterWrapper = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        nestedAdapterWrapper.getAuthRequestContext.bindViewHolder(viewHolder, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = false;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
        concatAdapterController.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        ConcatAdapterController concatAdapterController = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ConcatAdapterController.WrapperAndLocalPosition BuiltInFictitiousFunctionClassFactory = concatAdapterController.BuiltInFictitiousFunctionClassFactory(i);
        NestedAdapterWrapper nestedAdapterWrapper = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        long BuiltInFictitiousFunctionClassFactory2 = nestedAdapterWrapper.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(nestedAdapterWrapper.getAuthRequestContext.getItemId(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory));
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = false;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
        concatAdapterController.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        return BuiltInFictitiousFunctionClassFactory2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getGetAuthRequestContext() {
        Iterator<NestedAdapterWrapper> it = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(viewHolder).getAuthRequestContext.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(viewHolder).getAuthRequestContext.onViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        ConcatAdapterController concatAdapterController = this.KClassImpl$Data$declaredNonStaticMembers$2;
        NestedAdapterWrapper remove = concatAdapterController.BuiltInFictitiousFunctionClassFactory.remove(viewHolder);
        if (remove == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find wrapper for ");
            sb.append(viewHolder);
            sb.append(", seems like it is not bound by this adapter: ");
            sb.append(concatAdapterController);
            throw new IllegalStateException(sb.toString());
        }
        remove.getAuthRequestContext.onViewRecycled(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ConcatAdapterController concatAdapterController = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (concatAdapterController.BuiltInFictitiousFunctionClassFactory(recyclerView)) {
            return;
        }
        concatAdapterController.MyBillsEntityDataFactory.add(new WeakReference<>(recyclerView));
        Iterator<NestedAdapterWrapper> it = concatAdapterController.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ConcatAdapterController concatAdapterController = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int size = concatAdapterController.MyBillsEntityDataFactory.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference<RecyclerView> weakReference = concatAdapterController.MyBillsEntityDataFactory.get(size);
            if (weakReference.get() == null) {
                concatAdapterController.MyBillsEntityDataFactory.remove(size);
            } else if (weakReference.get() == recyclerView) {
                concatAdapterController.MyBillsEntityDataFactory.remove(size);
                break;
            }
            size--;
        }
        Iterator<NestedAdapterWrapper> it = concatAdapterController.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int findRelativeAdapterPositionIn(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, RecyclerView.ViewHolder viewHolder, int i) {
        ConcatAdapterController concatAdapterController = this.KClassImpl$Data$declaredNonStaticMembers$2;
        NestedAdapterWrapper nestedAdapterWrapper = concatAdapterController.BuiltInFictitiousFunctionClassFactory.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return -1;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = i - concatAdapterController.KClassImpl$Data$declaredNonStaticMembers$2(nestedAdapterWrapper);
        int getAuthRequestContext = nestedAdapterWrapper.getAuthRequestContext.getGetAuthRequestContext();
        if (KClassImpl$Data$declaredNonStaticMembers$2 < 0 || KClassImpl$Data$declaredNonStaticMembers$2 >= getAuthRequestContext) {
            StringBuilder sb = new StringBuilder();
            sb.append("Detected inconsistent adapter updates. The local position of the view holder maps to ");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(" which is out of bounds for the adapter with size ");
            sb.append(getAuthRequestContext);
            sb.append(".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
            sb.append(viewHolder);
            sb.append("adapter:");
            sb.append(adapter);
            throw new IllegalStateException(sb.toString());
        }
        return nestedAdapterWrapper.getAuthRequestContext.findRelativeAdapterPositionIn(adapter, viewHolder, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* loaded from: classes3.dex */
    public static final class Config {
        public static final Config KClassImpl$Data$declaredNonStaticMembers$2 = new Config(StableIdMode.NO_STABLE_IDS);
        public final StableIdMode MyBillsEntityDataFactory;
        public final boolean PlaceComponentResult = true;

        /* loaded from: classes6.dex */
        public static final class Builder {
            private boolean MyBillsEntityDataFactory = Config.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
            private StableIdMode PlaceComponentResult = Config.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        }

        /* loaded from: classes3.dex */
        public enum StableIdMode {
            NO_STABLE_IDS,
            ISOLATED_STABLE_IDS,
            SHARED_STABLE_IDS
        }

        private Config(StableIdMode stableIdMode) {
            this.MyBillsEntityDataFactory = stableIdMode;
        }
    }
}
