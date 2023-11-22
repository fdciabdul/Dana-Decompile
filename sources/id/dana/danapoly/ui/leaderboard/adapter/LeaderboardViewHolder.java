package id.dana.danapoly.ui.leaderboard.adapter;

import android.widget.ImageView;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.core.ui.adapter.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ItemLeaderboardBinding;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/adapter/LeaderboardViewHolder;", "Lid/dana/core/ui/adapter/BaseRecyclerViewHolder;", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "Lid/dana/danapoly/databinding/ItemLeaderboardBinding;", "PlaceComponentResult", "Lid/dana/danapoly/databinding/ItemLeaderboardBinding;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "p0", "<init>", "(Lid/dana/danapoly/databinding/ItemLeaderboardBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardViewHolder extends BaseRecyclerViewHolder<LeaderboardModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final ItemLeaderboardBinding BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private LeaderboardModel PlaceComponentResult;

    @Override // id.dana.core.ui.adapter.BaseRecyclerViewHolder
    public final /* synthetic */ void MyBillsEntityDataFactory(LeaderboardModel leaderboardModel) {
        LeaderboardModel leaderboardModel2 = leaderboardModel;
        Intrinsics.checkNotNullParameter(leaderboardModel2, "");
        this.PlaceComponentResult = leaderboardModel2;
        ItemLeaderboardBinding itemLeaderboardBinding = this.BuiltInFictitiousFunctionClassFactory;
        itemLeaderboardBinding.lookAheadTest.setText(String.valueOf(leaderboardModel2.getRank()));
        itemLeaderboardBinding.getErrorConfigVersion.setText(leaderboardModel2.getName());
        itemLeaderboardBinding.getAuthRequestContext.setText(itemLeaderboardBinding.PlaceComponentResult.getResources().getString(R.string.leaderboard_laps, Integer.valueOf(leaderboardModel2.getLaps())));
        ShapeableImageView shapeableImageView = itemLeaderboardBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        GlideApp.getAuthRequestContext(shapeableImageView.getContext()).PlaceComponentResult(leaderboardModel2.getAvatarUrl()).getErrorConfigVersion(R.drawable.ic_default_avatar_square).PlaceComponentResult(R.drawable.ic_default_avatar_square).MyBillsEntityDataFactory((ImageView) shapeableImageView);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LeaderboardViewHolder(id.dana.danapoly.databinding.ItemLeaderboardBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r3.PlaceComponentResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            android.view.View r1 = (android.view.View) r1
            r2.<init>(r1)
            r2.BuiltInFictitiousFunctionClassFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.leaderboard.adapter.LeaderboardViewHolder.<init>(id.dana.danapoly.databinding.ItemLeaderboardBinding):void");
    }
}
