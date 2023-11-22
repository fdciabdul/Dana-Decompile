package id.dana.danapoly.ui.leaderboard.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.core.ui.adapter.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ItemLeaderboardMyselfBinding;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/adapter/LeaderboardMyselfViewHolder;", "Lid/dana/core/ui/adapter/BaseRecyclerViewHolder;", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "Lid/dana/danapoly/databinding/ItemLeaderboardMyselfBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/databinding/ItemLeaderboardMyselfBinding;", "PlaceComponentResult", "getAuthRequestContext", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/danapoly/databinding/ItemLeaderboardMyselfBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardMyselfViewHolder extends BaseRecyclerViewHolder<LeaderboardModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ItemLeaderboardMyselfBinding PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private LeaderboardModel MyBillsEntityDataFactory;

    @Override // id.dana.core.ui.adapter.BaseRecyclerViewHolder
    public final /* synthetic */ void MyBillsEntityDataFactory(LeaderboardModel leaderboardModel) {
        int i;
        LeaderboardModel leaderboardModel2 = leaderboardModel;
        Intrinsics.checkNotNullParameter(leaderboardModel2, "");
        this.MyBillsEntityDataFactory = leaderboardModel2;
        ItemLeaderboardMyselfBinding itemLeaderboardMyselfBinding = this.PlaceComponentResult;
        itemLeaderboardMyselfBinding.lookAheadTest.setText(String.valueOf(leaderboardModel2.getRank()));
        itemLeaderboardMyselfBinding.MyBillsEntityDataFactory.setText(itemLeaderboardMyselfBinding.getAuthRequestContext.getResources().getString(R.string.leaderboard_laps, Integer.valueOf(leaderboardModel2.getLaps())));
        ShapeableImageView shapeableImageView = itemLeaderboardMyselfBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        GlideApp.getAuthRequestContext(shapeableImageView.getContext()).PlaceComponentResult(leaderboardModel2.getAvatarUrl()).getErrorConfigVersion(R.drawable.ic_default_avatar_square).PlaceComponentResult(R.drawable.ic_default_avatar_square).MyBillsEntityDataFactory((ImageView) shapeableImageView);
        ConstraintLayout constraintLayout = itemLeaderboardMyselfBinding.BuiltInFictitiousFunctionClassFactory;
        Context context = itemLeaderboardMyselfBinding.getAuthRequestContext.getContext();
        if (leaderboardModel2.getRank() >= 10) {
            i = R.drawable.bg_rounded_bottom_white_8dp;
        } else {
            i = leaderboardModel2.getRank() == 4 ? R.drawable.bg_rounded_top_white_8dp : R.color.newProxyInstance;
        }
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(context, i);
        if (PlaceComponentResult != null) {
            GradientDrawable gradientDrawable = PlaceComponentResult instanceof GradientDrawable ? (GradientDrawable) PlaceComponentResult : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemLeaderboardMyselfBinding.getAuthRequestContext.getContext(), R.color.newProxyInstance));
            }
        } else {
            PlaceComponentResult = null;
        }
        constraintLayout.setBackground(PlaceComponentResult);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LeaderboardMyselfViewHolder(id.dana.danapoly.databinding.ItemLeaderboardMyselfBinding r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.leaderboard.adapter.LeaderboardMyselfViewHolder.<init>(id.dana.danapoly.databinding.ItemLeaderboardMyselfBinding):void");
    }
}
