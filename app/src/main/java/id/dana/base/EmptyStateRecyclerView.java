package id.dana.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/base/EmptyStateRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "MyBillsEntityDataFactory", "()V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Landroid/view/View;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "setEmptyView", "(Landroid/view/View;)V", "emptyView", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmptyStateRecyclerView extends RecyclerView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private View emptyView;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final RecyclerView.AdapterDataObserver MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = new RecyclerView.AdapterDataObserver() { // from class: id.dana.base.EmptyStateRecyclerView$observer$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onChanged() {
                EmptyStateRecyclerView.this.MyBillsEntityDataFactory();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeRemoved(int p0, int p1) {
                EmptyStateRecyclerView.this.MyBillsEntityDataFactory();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeMoved(int p0, int p1, int p2) {
                EmptyStateRecyclerView.this.MyBillsEntityDataFactory();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeInserted(int p0, int p1) {
                EmptyStateRecyclerView.this.MyBillsEntityDataFactory();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeChanged(int p0, int p1) {
                EmptyStateRecyclerView.this.MyBillsEntityDataFactory();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onItemRangeChanged(int p0, int p1, Object p2) {
                EmptyStateRecyclerView.this.MyBillsEntityDataFactory();
            }
        };
    }

    public /* synthetic */ EmptyStateRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getEmptyView")
    public final View getEmptyView() {
        return this.emptyView;
    }

    @JvmName(name = "setEmptyView")
    public final void setEmptyView(View view) {
        this.emptyView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void setAdapter(RecyclerView.Adapter<?> adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.MyBillsEntityDataFactory);
        }
        super.setAdapter(adapter);
        RecyclerView.Adapter adapter3 = getAdapter();
        if (adapter3 != null) {
            adapter3.registerAdapterDataObserver(this.MyBillsEntityDataFactory);
        }
        MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        RecyclerView.Adapter adapter;
        View view = this.emptyView;
        if (view == null || (adapter = getAdapter()) == null) {
            return;
        }
        view.setVisibility(adapter.getItemCount() == 0 ? 0 : 8);
    }
}
