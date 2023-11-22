package id.dana.danapoly.ui.leaderboard.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ViewDanapolyLeaderboardTopThreeBinding;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/view/LeaderboardTopThreeView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewDanapolyLeaderboardTopThreeBinding;", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewDanapolyLeaderboardTopThreeBinding;", "", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "leaderboards", "", "setLeaderboard", "(Ljava/util/List;)V", "Landroid/widget/TextView;", "p0", "p1", "Landroid/widget/ImageView;", "p2", "p3", "PlaceComponentResult", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardTopThreeView extends BaseViewBindingRichView<ViewDanapolyLeaderboardTopThreeBinding> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LeaderboardTopThreeView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LeaderboardTopThreeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LeaderboardTopThreeView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ LeaderboardTopThreeView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaderboardTopThreeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanapolyLeaderboardTopThreeBinding inflateViewBinding() {
        ViewDanapolyLeaderboardTopThreeBinding MyBillsEntityDataFactory = ViewDanapolyLeaderboardTopThreeBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public final void setLeaderboard(List<LeaderboardModel> leaderboards) {
        Intrinsics.checkNotNullParameter(leaderboards, "");
        for (LeaderboardModel leaderboardModel : leaderboards) {
            int rank = leaderboardModel.getRank();
            if (rank == 1) {
                ViewDanapolyLeaderboardTopThreeBinding binding = getBinding();
                AppCompatTextView appCompatTextView = binding.initRecordTimeStamp;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                AppCompatTextView appCompatTextView2 = binding.DatabaseTableConfigUtil;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
                ShapeableImageView shapeableImageView = binding.moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
                PlaceComponentResult(appCompatTextView, appCompatTextView2, shapeableImageView, leaderboardModel);
            } else if (rank != 2) {
                ViewDanapolyLeaderboardTopThreeBinding binding2 = getBinding();
                AppCompatTextView appCompatTextView3 = binding2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
                AppCompatTextView appCompatTextView4 = binding2.GetContactSyncConfig;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "");
                ShapeableImageView shapeableImageView2 = binding2.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(shapeableImageView2, "");
                PlaceComponentResult(appCompatTextView3, appCompatTextView4, shapeableImageView2, leaderboardModel);
            } else {
                ViewDanapolyLeaderboardTopThreeBinding binding3 = getBinding();
                AppCompatTextView appCompatTextView5 = binding3.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "");
                AppCompatTextView appCompatTextView6 = binding3.NetworkUserEntityData$$ExternalSyntheticLambda2;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView6, "");
                ShapeableImageView shapeableImageView3 = binding3.lookAheadTest;
                Intrinsics.checkNotNullExpressionValue(shapeableImageView3, "");
                PlaceComponentResult(appCompatTextView5, appCompatTextView6, shapeableImageView3, leaderboardModel);
            }
        }
    }

    private final void PlaceComponentResult(TextView p0, TextView p1, ImageView p2, LeaderboardModel p3) {
        String name;
        if (p3.getMyself()) {
            name = getContext().getString(R.string.leaderboard_myself_winner);
        } else {
            name = p3.getName();
        }
        p0.setText(name);
        p1.setText(getResources().getString(R.string.leaderboard_laps, Integer.valueOf(p3.getLaps())));
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(p3.getAvatarUrl()).getErrorConfigVersion(R.drawable.ic_default_avatar_square).PlaceComponentResult(R.drawable.ic_default_avatar_square).MyBillsEntityDataFactory(p2);
        if (p3.getMyself()) {
            p0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.AppCompatEmojiTextHelper, null), (Drawable) null);
            p0.setCompoundDrawablePadding(4);
        }
    }
}
