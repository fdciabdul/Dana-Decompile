package id.dana.richview.servicescard.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import io.supercharge.shimmerlayout.ShimmerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/richview/servicescard/adapter/viewholder/ServiceShimmerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/supercharge/shimmerlayout/ShimmerLayout;", "BuiltInFictitiousFunctionClassFactory", "Lio/supercharge/shimmerlayout/ShimmerLayout;", "MyBillsEntityDataFactory", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "", "p2", "<init>", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceShimmerViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ShimmerLayout MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceShimmerViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(layoutInflater.inflate(R.layout.viewholder_shimmer, viewGroup, false));
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ShimmerLayout shimmerLayout = (ShimmerLayout) this.itemView;
        this.MyBillsEntityDataFactory = shimmerLayout;
        layoutInflater.inflate(i, (ViewGroup) shimmerLayout, true);
    }
}
