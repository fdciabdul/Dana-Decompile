package id.dana.nearbyme.adapter;

import android.location.Location;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.nearbyme.adapter.NearbyLocationResultAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$NearbyLocationResultViewHolder;", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "p0", "", "p1", "", "getAuthRequestContext", "(Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$NearbyLocationResultViewHolder;I)V", "Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$OnClickListener;", "Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$OnClickListener;", "<init>", "(Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$OnClickListener;)V", "NearbyLocationResultViewHolder", "OnClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class NearbyLocationResultAdapter extends BaseRecyclerViewAdapter<NearbyLocationResultViewHolder, NearbyLocation> {
    private final OnClickListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$OnClickListener;", "", "", "placeId", "name", "address", "Landroid/location/Location;", "location", "", "onLocationClicked", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/location/Location;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnClickListener {
        void onLocationClicked(String placeId, String name, String address, Location location);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new NearbyLocationResultViewHolder(viewGroup);
    }

    public NearbyLocationResultAdapter(OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        this.getAuthRequestContext = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(NearbyLocationResultViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onBindViewHolder((NearbyLocationResultAdapter) p0, p1);
        p0.bindData(getItems().get(p1));
        OnClickListener onClickListener = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(onClickListener, "");
        p0.BuiltInFictitiousFunctionClassFactory = onClickListener;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$NearbyLocationResultViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/nearbyplaces/model/NearbyLocation;)V", "Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$OnClickListener;", "Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter$OnClickListener;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class NearbyLocationResultViewHolder extends BaseRecyclerViewHolder<NearbyLocation> {
        OnClickListener BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NearbyLocationResultViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_location_result, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }

        @Override // id.dana.base.BaseRecyclerViewHolder
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final void bindData(final NearbyLocation p0) {
            if (p0 != null) {
                ((TextView) this.itemView.findViewById(R.id.tv_location_name)).setText(p0.getName());
                ((TextView) this.itemView.findViewById(R.id.res_0x7f0a17a3_graphs_transposedgraph_1_externalsyntheticlambda0)).setText(p0.getDescription());
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.NearbyLocationResultAdapter$NearbyLocationResultViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NearbyLocationResultAdapter.NearbyLocationResultViewHolder.getAuthRequestContext(NearbyLocationResultAdapter.NearbyLocationResultViewHolder.this, p0);
                    }
                });
            }
        }

        public static /* synthetic */ void getAuthRequestContext(NearbyLocationResultViewHolder nearbyLocationResultViewHolder, NearbyLocation nearbyLocation) {
            Intrinsics.checkNotNullParameter(nearbyLocationResultViewHolder, "");
            OnClickListener onClickListener = nearbyLocationResultViewHolder.BuiltInFictitiousFunctionClassFactory;
            if (onClickListener != null) {
                onClickListener.onLocationClicked(nearbyLocation.getPlaceId(), nearbyLocation.getName(), nearbyLocation.getDescription(), nearbyLocation.getLocation());
            }
        }
    }
}
