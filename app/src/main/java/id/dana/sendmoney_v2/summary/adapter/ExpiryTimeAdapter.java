package id.dana.sendmoney_v2.summary.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney_v2/summary/adapter/ExpiryTimeAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/sendmoney_v2/summary/adapter/ExpiryTimeViewHolder;", "Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpiryTimeAdapter extends BaseRecyclerViewAdapter<ExpiryTimeViewHolder, ExpiryTimeConfig> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = getOnItemClickListener();
        Intrinsics.checkNotNullExpressionValue(onItemClickListener, "");
        return new ExpiryTimeViewHolder(viewGroup, onItemClickListener);
    }
}
