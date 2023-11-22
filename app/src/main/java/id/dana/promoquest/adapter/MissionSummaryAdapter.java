package id.dana.promoquest.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.promoquest.model.MissionModel;
import id.dana.promoquest.views.MissionCardView;
import id.dana.promoquest.views.MissionSummaryViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/promoquest/adapter/MissionSummaryAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/promoquest/views/MissionSummaryViewHolder;", "Lid/dana/promoquest/model/MissionModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MissionSummaryAdapter extends BaseRecyclerViewAdapter<MissionSummaryViewHolder, MissionModel> {
    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MissionSummaryViewHolder missionSummaryViewHolder = (MissionSummaryViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(missionSummaryViewHolder, "");
        MissionModel missionModel = getItems().get(i);
        MissionCardView missionCardView = (MissionCardView) missionSummaryViewHolder.itemView;
        missionCardView.setSize(missionSummaryViewHolder.MyBillsEntityDataFactory);
        missionCardView.setMission(missionModel);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final /* synthetic */ void onBindViewHolder(MissionSummaryViewHolder missionSummaryViewHolder, int i) {
        MissionSummaryViewHolder missionSummaryViewHolder2 = missionSummaryViewHolder;
        Intrinsics.checkNotNullParameter(missionSummaryViewHolder2, "");
        MissionModel missionModel = getItems().get(i);
        MissionCardView missionCardView = (MissionCardView) missionSummaryViewHolder2.itemView;
        missionCardView.setSize(missionSummaryViewHolder2.MyBillsEntityDataFactory);
        missionCardView.setMission(missionModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MissionSummaryViewHolder(viewGroup, getPlaceComponentResult() > 1 ? 0 : 2);
    }
}
