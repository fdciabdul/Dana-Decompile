package id.dana.globalsearch.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.globalsearch.adapter.RecentSearchAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/globalsearch/adapter/RecentSearchAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/globalsearch/adapter/RecentSearchAdapter$RecentSearchViewHolder;", "", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "<init>", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "RecentSearchViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecentSearchAdapter extends BaseRecyclerViewAdapter<RecentSearchViewHolder, String> {
    private final BaseRecyclerViewHolder.OnItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new RecentSearchViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public RecentSearchAdapter(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onItemClickListener;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/globalsearch/adapter/RecentSearchAdapter$RecentSearchViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RecentSearchViewHolder extends BaseRecyclerViewHolder<String> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(String str) {
            TextView textView;
            String str2 = str;
            if (str2 == null || (textView = (TextView) this.itemView.findViewById(R.id.PolystarContent)) == null) {
                return;
            }
            textView.setText(str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentSearchViewHolder(ViewGroup viewGroup, final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
            super(viewGroup.getContext(), R.layout.item_recent_search, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(onItemClickListener, "");
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.isValidRowNumber);
            if (appCompatImageView != null) {
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.adapter.RecentSearchAdapter$RecentSearchViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RecentSearchAdapter.RecentSearchViewHolder.PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                    }
                });
            }
        }

        public static /* synthetic */ void PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, RecentSearchViewHolder recentSearchViewHolder) {
            Intrinsics.checkNotNullParameter(onItemClickListener, "");
            Intrinsics.checkNotNullParameter(recentSearchViewHolder, "");
            onItemClickListener.onItemClick(recentSearchViewHolder.getAdapterPosition());
        }
    }
}
