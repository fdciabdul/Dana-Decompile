package id.dana.drawable.search.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/LocationSearchResultAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "", "p0", "getItemViewType", "(I)I", "", "getAuthRequestContext", "(I)Z", "<init>", "()V", "ChainQueryViewHolder", "LocationSearchResultViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationSearchResultAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<NearbyLocation>, NearbyLocation> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LocationSearchResultViewHolder locationSearchResultViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            locationSearchResultViewHolder = new ChainQueryViewHolder(viewGroup);
        } else {
            locationSearchResultViewHolder = new LocationSearchResultViewHolder(viewGroup);
        }
        return locationSearchResultViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).getViewHolderType();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/LocationSearchResultAdapter$LocationSearchResultViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LocationSearchResultViewHolder extends BaseRecyclerViewHolder<NearbyLocation> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(NearbyLocation nearbyLocation) {
            String string;
            NearbyLocation nearbyLocation2 = nearbyLocation;
            if (nearbyLocation2 != null) {
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.tvLocationName);
                if (textView != null) {
                    textView.setText(nearbyLocation2.getName());
                }
                TextView textView2 = (TextView) view.findViewById(R.id.res_0x7f0a14bc_access_launchmessage);
                if (textView2 != null) {
                    textView2.setText(nearbyLocation2.getDescription());
                }
                double distanceInMeters = nearbyLocation2.getDistanceInMeters();
                Double.isNaN(distanceInMeters);
                double d = distanceInMeters / 1000.0d;
                TextView textView3 = (TextView) view.findViewById(R.id.createProfileProvider);
                if (textView3 != null) {
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    if (d >= 1.0d) {
                        string = context.getString(R.string.km_away_no_space, Double.valueOf(d));
                        Intrinsics.checkNotNullExpressionValue(string, "");
                    } else {
                        string = context.getString(R.string.m_away_no_space, Double.valueOf(d * 1000.0d));
                        Intrinsics.checkNotNullExpressionValue(string, "");
                    }
                    textView3.setText(string);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocationSearchResultViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_location_search_result, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/LocationSearchResultAdapter$ChainQueryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ChainQueryViewHolder extends BaseRecyclerViewHolder<NearbyLocation> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(NearbyLocation nearbyLocation) {
            TextView textView;
            NearbyLocation nearbyLocation2 = nearbyLocation;
            if (nearbyLocation2 == null || (textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a1400_resetpinstatemanager_resetpinstate_failed)) == null) {
                return;
            }
            textView.setText(nearbyLocation2.getName());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChainQueryViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_chain_query, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    public final boolean getAuthRequestContext(int p0) {
        return getItems().get(p0).getViewHolderType() == 1;
    }
}
