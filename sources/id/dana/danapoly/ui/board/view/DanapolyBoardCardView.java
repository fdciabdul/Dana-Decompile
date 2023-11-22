package id.dana.danapoly.ui.board.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danapoly.databinding.ViewDanapolyBoardCardBinding;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.enums.RewardTypeKt;
import id.dana.danapoly.ui.model.BoardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyBoardCardView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewDanapolyBoardCardBinding;", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewDanapolyBoardCardBinding;", "Lid/dana/danapoly/ui/model/BoardModel;", "boardModel", "", "loadBoardCard", "(Lid/dana/danapoly/ui/model/BoardModel;)V", "", "color", "setBoardColor", "(I)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyBoardCardView extends BaseViewBindingRichView<ViewDanapolyBoardCardBinding> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardCardView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardCardView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ DanapolyBoardCardView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanapolyBoardCardBinding inflateViewBinding() {
        ViewDanapolyBoardCardBinding BuiltInFictitiousFunctionClassFactory = ViewDanapolyBoardCardBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void loadBoardCard(BoardModel boardModel) {
        RewardType rewardType;
        Intrinsics.checkNotNullParameter(boardModel, "");
        try {
            rewardType = RewardType.valueOf(boardModel.getType());
        } catch (Exception unused) {
            rewardType = RewardType.DEFAULT;
        }
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(boardModel.getIconUrl()).getErrorConfigVersion(RewardTypeKt.BuiltInFictitiousFunctionClassFactory(rewardType)).PlaceComponentResult(RewardTypeKt.BuiltInFictitiousFunctionClassFactory(rewardType)).MyBillsEntityDataFactory((ImageView) getBinding().PlaceComponentResult);
    }

    public final void setBoardColor(int color) {
        getBinding().PlaceComponentResult.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), color));
    }
}
