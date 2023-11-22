package id.dana.danapoly.ui.leaderboard.adapter;

import id.dana.core.ui.adapter.BaseRecyclerViewHolder;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ItemLeaderboardDividerBinding;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/adapter/LeaderboardDividerViewHolder;", "Lid/dana/core/ui/adapter/BaseRecyclerViewHolder;", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "Lid/dana/danapoly/databinding/ItemLeaderboardDividerBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/databinding/ItemLeaderboardDividerBinding;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/danapoly/databinding/ItemLeaderboardDividerBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardDividerViewHolder extends BaseRecyclerViewHolder<LeaderboardModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ItemLeaderboardDividerBinding PlaceComponentResult;

    @Override // id.dana.core.ui.adapter.BaseRecyclerViewHolder
    public final /* synthetic */ void MyBillsEntityDataFactory(LeaderboardModel leaderboardModel) {
        LeaderboardModel leaderboardModel2 = leaderboardModel;
        Intrinsics.checkNotNullParameter(leaderboardModel2, "");
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setText(this.PlaceComponentResult.getAuthRequestContext.getResources().getString(R.string.leaderboard_above_you, String.valueOf(leaderboardModel2.getUsersAboveMe() - 1)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LeaderboardDividerViewHolder(id.dana.danapoly.databinding.ItemLeaderboardDividerBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r3.getAuthRequestContext
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            android.view.View r1 = (android.view.View) r1
            r2.<init>(r1)
            r2.PlaceComponentResult = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.leaderboard.adapter.LeaderboardDividerViewHolder.<init>(id.dana.danapoly.databinding.ItemLeaderboardDividerBinding):void");
    }
}
