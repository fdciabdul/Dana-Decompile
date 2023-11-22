package androidx.recyclerview.widget;

import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ConcatAdapterController implements NestedAdapterWrapper.Callback {
    private final ConcatAdapter.Config.StableIdMode NetworkUserEntityData$$ExternalSyntheticLambda0;
    final ViewTypeStorage getAuthRequestContext;
    private final ConcatAdapter getErrorConfigVersion;
    private final StableIdStorage moveToNextValue;
    List<WeakReference<RecyclerView>> MyBillsEntityDataFactory = new ArrayList();
    final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> BuiltInFictitiousFunctionClassFactory = new IdentityHashMap<>();
    List<NestedAdapterWrapper> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    WrapperAndLocalPosition PlaceComponentResult = new WrapperAndLocalPosition();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConcatAdapterController(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.getErrorConfigVersion = concatAdapter;
        if (config.PlaceComponentResult) {
            this.getAuthRequestContext = new ViewTypeStorage.IsolatedViewTypeStorage();
        } else {
            this.getAuthRequestContext = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = config.MyBillsEntityDataFactory;
        if (config.MyBillsEntityDataFactory == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.moveToNextValue = new StableIdStorage.NoStableIdStorage();
        } else if (config.MyBillsEntityDataFactory == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.moveToNextValue = new StableIdStorage.IsolatedStableIdStorage();
        } else if (config.MyBillsEntityDataFactory == ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
            this.moveToNextValue = new StableIdStorage.SharedPoolStableIdStorage();
        } else {
            throw new IllegalArgumentException("unknown stable id mode");
        }
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = 0; i < size; i++) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).getAuthRequestContext == adapter) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        return MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.size(), adapter);
    }

    private boolean MyBillsEntityDataFactory(int i, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        if (i < 0 || i > this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index must be between 0 and ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.size());
            sb.append(". Given:");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (PlaceComponentResult()) {
            Preconditions.MyBillsEntityDataFactory(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (adapter.hasStableIds()) {
            InstrumentInjector.log_w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(adapter);
        if ((KClassImpl$Data$declaredNonStaticMembers$2 == -1 ? null : this.KClassImpl$Data$declaredNonStaticMembers$2.get(KClassImpl$Data$declaredNonStaticMembers$2)) != null) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = new NestedAdapterWrapper(adapter, this, this.getAuthRequestContext, this.moveToNextValue.getAuthRequestContext());
        this.KClassImpl$Data$declaredNonStaticMembers$2.add(i, nestedAdapterWrapper);
        Iterator<WeakReference<RecyclerView>> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (nestedAdapterWrapper.KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            this.getErrorConfigVersion.notifyItemRangeInserted(KClassImpl$Data$declaredNonStaticMembers$2(nestedAdapterWrapper), nestedAdapterWrapper.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        BuiltInFictitiousFunctionClassFactory();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(adapter);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = this.KClassImpl$Data$declaredNonStaticMembers$2.get(KClassImpl$Data$declaredNonStaticMembers$2);
        int KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(nestedAdapterWrapper);
        this.KClassImpl$Data$declaredNonStaticMembers$2.remove(KClassImpl$Data$declaredNonStaticMembers$2);
        this.getErrorConfigVersion.notifyItemRangeRemoved(KClassImpl$Data$declaredNonStaticMembers$22, nestedAdapterWrapper.KClassImpl$Data$declaredNonStaticMembers$2);
        Iterator<WeakReference<RecyclerView>> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        nestedAdapterWrapper.getAuthRequestContext.unregisterAdapterDataObserver(nestedAdapterWrapper.PlaceComponentResult);
        nestedAdapterWrapper.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2();
        BuiltInFictitiousFunctionClassFactory();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(NestedAdapterWrapper nestedAdapterWrapper) {
        NestedAdapterWrapper next;
        Iterator<NestedAdapterWrapper> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        int i = 0;
        while (it.hasNext() && (next = it.next()) != nestedAdapterWrapper) {
            i += next.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getErrorConfigVersion.notifyDataSetChanged();
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public final void MyBillsEntityDataFactory(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2, Object obj) {
        this.getErrorConfigVersion.notifyItemRangeChanged(i + KClassImpl$Data$declaredNonStaticMembers$2(nestedAdapterWrapper), i2, obj);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public final void MyBillsEntityDataFactory(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.getErrorConfigVersion.notifyItemRangeInserted(i + KClassImpl$Data$declaredNonStaticMembers$2(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.getErrorConfigVersion.notifyItemRangeRemoved(i + KClassImpl$Data$declaredNonStaticMembers$2(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public final void getAuthRequestContext(NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(nestedAdapterWrapper);
        this.getErrorConfigVersion.notifyItemMoved(i + KClassImpl$Data$declaredNonStaticMembers$2, i2 + KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public final void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WrapperAndLocalPosition BuiltInFictitiousFunctionClassFactory(int i) {
        WrapperAndLocalPosition wrapperAndLocalPosition;
        if (this.PlaceComponentResult.PlaceComponentResult) {
            wrapperAndLocalPosition = new WrapperAndLocalPosition();
        } else {
            this.PlaceComponentResult.PlaceComponentResult = true;
            wrapperAndLocalPosition = this.PlaceComponentResult;
        }
        Iterator<NestedAdapterWrapper> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        int i2 = i;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NestedAdapterWrapper next = it.next();
            if (next.KClassImpl$Data$declaredNonStaticMembers$2 > i2) {
                wrapperAndLocalPosition.KClassImpl$Data$declaredNonStaticMembers$2 = next;
                wrapperAndLocalPosition.MyBillsEntityDataFactory = i2;
                break;
            }
            i2 -= next.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (wrapperAndLocalPosition.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return wrapperAndLocalPosition;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find wrapper for ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public final boolean PlaceComponentResult(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper remove = this.BuiltInFictitiousFunctionClassFactory.remove(viewHolder);
        if (remove == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find wrapper for ");
            sb.append(viewHolder);
            sb.append(", seems like it is not bound by this adapter: ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        return remove.getAuthRequestContext.onFailedToRecycleView(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final NestedAdapterWrapper BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.BuiltInFictitiousFunctionClassFactory.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find wrapper for ");
        sb.append(viewHolder);
        sb.append(", seems like it is not bound by this adapter: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView) {
        Iterator<WeakReference<RecyclerView>> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            if (it.next().get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class WrapperAndLocalPosition {
        NestedAdapterWrapper KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        boolean PlaceComponentResult;

        WrapperAndLocalPosition() {
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy;
        Iterator<NestedAdapterWrapper> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (it.hasNext()) {
                NestedAdapterWrapper next = it.next();
                RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = next.getAuthRequestContext.getStateRestorationPolicy();
                if (stateRestorationPolicy2 == RecyclerView.Adapter.StateRestorationPolicy.PREVENT) {
                    stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
                    break;
                } else if (stateRestorationPolicy2 == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && next.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                    stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
                    break;
                }
            } else {
                stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
                break;
            }
        }
        if (stateRestorationPolicy != this.getErrorConfigVersion.getStateRestorationPolicy()) {
            this.getErrorConfigVersion.MyBillsEntityDataFactory(stateRestorationPolicy);
        }
    }
}
