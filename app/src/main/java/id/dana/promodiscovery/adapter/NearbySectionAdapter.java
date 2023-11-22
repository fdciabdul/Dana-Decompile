package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.viewholder.NearbySectionViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/promodiscovery/adapter/NearbySectionAdapter;", "Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "Lkotlin/Function0;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "<init>", "(Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySectionAdapter extends BaseDiscoverySectionAdapters<Unit> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function0<Unit> PlaceComponentResult;

    public NearbySectionAdapter(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.PlaceComponentResult = function0;
    }

    @Override // id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters
    public final BaseRecyclerViewHolder<DiscoverySectionModel<Unit>> getAuthRequestContext(ViewGroup p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new NearbySectionViewHolder(this.PlaceComponentResult, p0);
    }
}
