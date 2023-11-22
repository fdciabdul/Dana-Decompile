package id.dana.drawable.search.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.search.model.NearbySearchSectionModel;
import id.dana.drawable.search.viewholder.NearbyTrendingSectionViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/search/model/NearbySearchSectionModel;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V", "NearbySectionListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySearchSectionAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<NearbySearchSectionModel>, NearbySearchSectionModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public NearbySectionListener BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "", "", "p0", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface NearbySectionListener {
        void getAuthRequestContext(String p0, String p1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new NearbyTrendingSectionViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
    }

    public NearbySearchSectionAdapter() {
        setItems(new ArrayList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).getAuthRequestContext.getValue();
    }
}
