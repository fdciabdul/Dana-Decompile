package id.dana.bottomsheet;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.ThirdPartyService;
import id.dana.richview.servicescard.adapter.viewholder.ServiceViewHolder;
import id.dana.service.viewholder.EmptyItemViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/bottomsheet/ServicesBottomSheetListAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "", "p0", "getItemViewType", "(I)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServicesBottomSheetListAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ThirdPartyService>, ThirdPartyService> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        BaseRecyclerViewHolder baseRecyclerViewHolder = (BaseRecyclerViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(baseRecyclerViewHolder, "");
        Intrinsics.checkNotNullParameter(list, "");
        baseRecyclerViewHolder.setIsRecyclable(false);
        super.onBindViewHolder(baseRecyclerViewHolder, i, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        BottomSheetSpaceItemViewHolder bottomSheetSpaceItemViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 3) {
            bottomSheetSpaceItemViewHolder = new BottomSheetSpaceItemViewHolder(viewGroup);
        } else if (i == 5) {
            bottomSheetSpaceItemViewHolder = new EmptyItemViewHolder(viewGroup);
        } else {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            bottomSheetSpaceItemViewHolder = new ServiceViewHolder(context, viewGroup);
        }
        return bottomSheetSpaceItemViewHolder;
    }

    public ServicesBottomSheetListAdapter() {
        setItems(CollectionsKt.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (p0 < 0 || p0 >= getItems().size() || getItem(p0) == null) {
            return 0;
        }
        int i = getItem(p0).D;
        if (i != 0) {
            if (i != 4) {
                return i != 6 ? 2 : 5;
            }
            return 3;
        }
        return 2;
    }
}
