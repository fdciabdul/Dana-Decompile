package id.dana.promoquest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.extension.view.ViewExtKt;
import id.dana.promoquest.model.MissionModel;
import id.dana.promoquest.views.MissionCardView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0017\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/promoquest/adapter/MissionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/promoquest/adapter/MissionsAdapter$ViewHolder;", "", "getItemCount", "()I", "", "Lid/dana/promoquest/model/MissionModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/util/List;)V", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissionsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<MissionModel> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MissionsAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promoquest.adapter.MissionsAdapter.<init>():void");
    }

    public /* synthetic */ MissionsAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        Intrinsics.checkNotNullParameter(viewHolder2, "");
        MissionCardView missionCardView = (MissionCardView) viewHolder2.itemView;
        missionCardView.setMission(this.BuiltInFictitiousFunctionClassFactory.get(i));
        if (i == 0) {
            ViewExtKt.PlaceComponentResult(missionCardView, null, Float.valueOf(16.0f), null, null, 13);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_mission_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        return new ViewHolder(inflate);
    }

    private MissionsAdapter(List<MissionModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/promoquest/adapter/MissionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "p0", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "");
            MissionCardView missionCardView = (MissionCardView) this.itemView;
            missionCardView.setQuestsVisible(true);
            missionCardView.setSize(1);
        }
    }
}
