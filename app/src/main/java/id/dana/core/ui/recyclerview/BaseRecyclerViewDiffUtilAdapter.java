package id.dana.core.ui.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\u0013J'\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015"}, d2 = {"Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "T", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "", "p2", "PlaceComponentResult", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "getAuthRequestContext", "(I)Ljava/lang/Object;", "getItemCount", "()I", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "Ljava/util/List;", "<init>", "DiffUtilCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseRecyclerViewDiffUtilAdapter<T, V extends BaseViewBindingViewHolder<T>> extends RecyclerView.Adapter<V> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public List<T> getAuthRequestContext = new ArrayList();

    protected abstract V PlaceComponentResult(LayoutInflater p0, ViewGroup p1, int p2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        BaseViewBindingViewHolder baseViewBindingViewHolder = (BaseViewBindingViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(baseViewBindingViewHolder, "");
        baseViewBindingViewHolder.KClassImpl$Data$declaredNonStaticMembers$2((BaseViewBindingViewHolder) this.getAuthRequestContext.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "");
        return PlaceComponentResult(from, viewGroup, i);
    }

    public static /* synthetic */ void getAuthRequestContext(BaseRecyclerViewDiffUtilAdapter baseRecyclerViewDiffUtilAdapter, List list) {
        Intrinsics.checkNotNullParameter(list, "");
        DiffUtil.DiffResult authRequestContext = DiffUtil.getAuthRequestContext(new DiffUtilCallback(baseRecyclerViewDiffUtilAdapter.getAuthRequestContext, list));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.MyBillsEntityDataFactory(new AdapterListUpdateCallback(baseRecyclerViewDiffUtilAdapter));
        baseRecyclerViewDiffUtilAdapter.getAuthRequestContext = CollectionsKt.toMutableList((Collection) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.getAuthRequestContext.size();
    }

    public final T getAuthRequestContext(int p0) {
        if (p0 < 0 || p0 >= this.getAuthRequestContext.size()) {
            return null;
        }
        return this.getAuthRequestContext.get(p0);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        int size = this.getAuthRequestContext.size();
        if (this.getAuthRequestContext.isEmpty()) {
            return;
        }
        this.getAuthRequestContext.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\r\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e"}, d2 = {"Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter$DiffUtilCallback;", "T", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(II)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "()I", "getAuthRequestContext", "", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DiffUtilCallback<T> extends DiffUtil.Callback {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final List<T> getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final List<T> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Multi-variable type inference failed */
        public DiffUtilCallback(List<? extends T> list, List<? extends T> list2) {
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(list2, "");
            this.getAuthRequestContext = list;
            this.BuiltInFictitiousFunctionClassFactory = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getAuthRequestContext() {
            return this.getAuthRequestContext.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int PlaceComponentResult() {
            return this.BuiltInFictitiousFunctionClassFactory.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
            return Intrinsics.areEqual(this.getAuthRequestContext.get(p0), this.BuiltInFictitiousFunctionClassFactory.get(p1));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean MyBillsEntityDataFactory(int p0, int p1) {
            return Intrinsics.areEqual(this.getAuthRequestContext.get(p0), this.BuiltInFictitiousFunctionClassFactory.get(p1));
        }
    }
}
