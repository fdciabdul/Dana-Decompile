package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\u0006\u0010\u0004\u001a\u00020\r\u0012&\u0010\u0010\u001a\"\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\t\u0012\u000b\u0012\t\u0018\u00010\n¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R1\u0010\u000b\u001a\"\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\t\u0012\u000b\u0012\t\u0018\u00010\n¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00050\bX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerViewHolder;", "", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroid/view/View;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function2;", "Landroid/view/ViewGroup;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaViewerViewHolder<T> extends BaseRecyclerViewHolder<T> {
    public final Function2<T, View, Unit> BuiltInFictitiousFunctionClassFactory;
    public final ViewGroup PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MediaViewerViewHolder(ViewGroup viewGroup, Function2<? super T, ? super View, Unit> function2) {
        super(viewGroup.getContext(), R.layout.view_media_viewer, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.PlaceComponentResult = viewGroup;
        this.BuiltInFictitiousFunctionClassFactory = function2;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Function2<T, View, Unit> function2 = this.BuiltInFictitiousFunctionClassFactory;
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "");
        function2.invoke(p0, view);
    }
}
