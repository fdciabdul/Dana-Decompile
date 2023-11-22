package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00000\u0003B/\u0012&\u0010\f\u001a\"\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0006\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\r\u0010\u000eR1\u0010\u000b\u001a\"\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0006\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerAdapter;", "", "T", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerViewHolder;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroid/view/View;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function2;", "PlaceComponentResult", "p0", "<init>", "(Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaViewerAdapter<T> extends BaseRecyclerViewAdapter<MediaViewerViewHolder<T>, T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Function2<T, View, Unit> PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MediaViewerViewHolder(viewGroup, this.PlaceComponentResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaViewerAdapter(Function2<? super T, ? super View, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.PlaceComponentResult = function2;
    }
}
