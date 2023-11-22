package id.dana.promoquest.views;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promoquest.model.MissionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/promoquest/views/MissionSummaryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promoquest/model/MissionModel;", "", "PlaceComponentResult", "I", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MissionSummaryViewHolder extends BaseRecyclerViewHolder<MissionModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MissionModel missionModel) {
        MissionCardView missionCardView = (MissionCardView) this.itemView;
        missionCardView.setSize(this.MyBillsEntityDataFactory);
        missionCardView.setMission(missionModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionSummaryViewHolder(ViewGroup viewGroup, int i) {
        super(viewGroup.getContext(), R.layout.view_item_mission_card, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.MyBillsEntityDataFactory = i;
    }
}
