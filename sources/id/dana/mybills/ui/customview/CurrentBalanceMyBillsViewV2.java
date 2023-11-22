package id.dana.mybills.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.mybills.databinding.ViewCurrentBalanceV2Binding;
import id.dana.mybills.ui.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B+\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/mybills/ui/customview/CurrentBalanceMyBillsViewV2;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewCurrentBalanceV2Binding;", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewCurrentBalanceV2Binding;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "balance", "", "setBalance", "(Lid/dana/mybills/ui/model/MoneyViewModel;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrentBalanceMyBillsViewV2 extends BaseViewBindingRichView<ViewCurrentBalanceV2Binding> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsViewV2(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsViewV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ CurrentBalanceMyBillsViewV2(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsViewV2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void setBalance(MoneyViewModel balance) {
        Intrinsics.checkNotNullParameter(balance, "");
        getBinding().getAuthRequestContext.setText(NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), balance.getAmountLong(), balance.getCurrency()));
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCurrentBalanceV2Binding inflateViewBinding() {
        ViewCurrentBalanceV2Binding PlaceComponentResult = ViewCurrentBalanceV2Binding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }
}
