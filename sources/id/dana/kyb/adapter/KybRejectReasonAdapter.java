package id.dana.kyb.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/adapter/KybRejectReasonAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "", "getItemCount", "()I", "<init>", "()V", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybRejectReasonAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<String>, String> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ViewHolder(viewGroup);
    }

    @Inject
    public KybRejectReasonAdapter() {
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getItems().size();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/adapter/KybRejectReasonAdapter$ViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class ViewHolder extends BaseRecyclerViewHolder<String> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(String str) {
            String str2 = str;
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_kyb_reject_reason);
            if (str2 != null) {
                textView.setText(StringsKt.removeSurrounding(str2, (CharSequence) "\""));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_kyb_reject_reason, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}
