package androidx.paging;

import androidx.paging.LoadState;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004@GX\u0086\n¢\u0006\f\n\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/LoadStateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/paging/LoadState;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/LoadState;)Z", "PlaceComponentResult", "Landroidx/paging/LoadState;", "MyBillsEntityDataFactory", "(Landroidx/paging/LoadState;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class LoadStateAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private LoadState KClassImpl$Data$declaredNonStaticMembers$2 = new LoadState.NotLoading(false);

    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "");
        if (Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, loadState)) {
            return;
        }
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
        boolean KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(loadState);
        if (KClassImpl$Data$declaredNonStaticMembers$2 && !KClassImpl$Data$declaredNonStaticMembers$22) {
            notifyItemRemoved(0);
        } else if (KClassImpl$Data$declaredNonStaticMembers$22 && !KClassImpl$Data$declaredNonStaticMembers$2) {
            notifyItemInserted(0);
        } else if (KClassImpl$Data$declaredNonStaticMembers$2 && KClassImpl$Data$declaredNonStaticMembers$22) {
            notifyItemChanged(0);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = loadState;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(LoadState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return (p0 instanceof LoadState.Loading) || (p0 instanceof LoadState.Error);
    }
}
