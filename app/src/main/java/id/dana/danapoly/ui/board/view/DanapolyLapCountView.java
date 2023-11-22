package id.dana.danapoly.ui.board.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ViewDanapolyLapCountBinding;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyLapCountView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewDanapolyLapCountBinding;", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewDanapolyLapCountBinding;", "", "lapCount", "Lkotlin/Function0;", "", "onAnimationEnd", ContainerUIProvider.KEY_SHOW, "(ILkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyLapCountView extends BaseViewBindingRichView<ViewDanapolyLapCountBinding> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyLapCountView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyLapCountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyLapCountView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ DanapolyLapCountView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyLapCountView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanapolyLapCountBinding inflateViewBinding() {
        ViewDanapolyLapCountBinding BuiltInFictitiousFunctionClassFactory = ViewDanapolyLapCountBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void show(int lapCount, final Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(onAnimationEnd, "");
        AppCompatTextView appCompatTextView = getBinding().getErrorConfigVersion;
        String format = new DecimalFormat().format(Integer.valueOf(lapCount));
        Intrinsics.checkNotNullExpressionValue(format, "");
        appCompatTextView.setText(StringsKt.replace$default(format, ",", ".", false, 4, (Object) null));
        getBinding().moveToNextValue.setTransition(R.id.res_0x7f0a126a_arraytable_2);
        getBinding().moveToNextValue.transitionToEnd(new Runnable() { // from class: id.dana.danapoly.ui.board.view.DanapolyLapCountView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DanapolyLapCountView.$r8$lambda$Oz4cfUJppkgCFlhG35r092iQhJo(DanapolyLapCountView.this, onAnimationEnd);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$Oz4cfUJppkgCFlhG35r092iQhJo(final DanapolyLapCountView danapolyLapCountView, final Function0 function0) {
        Intrinsics.checkNotNullParameter(danapolyLapCountView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        danapolyLapCountView.getBinding().moveToNextValue.setTransition(R.id.ListenerMethod);
        danapolyLapCountView.getBinding().moveToNextValue.transitionToEnd(new Runnable() { // from class: id.dana.danapoly.ui.board.view.DanapolyLapCountView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DanapolyLapCountView.m731$r8$lambda$Xl1kaaqCERskBPk0la94AJT0zc(DanapolyLapCountView.this, function0);
            }
        });
    }

    /* renamed from: $r8$lambda$Xl1kaaqCERskBP-k0la94AJT0zc  reason: not valid java name */
    public static /* synthetic */ void m731$r8$lambda$Xl1kaaqCERskBPk0la94AJT0zc(DanapolyLapCountView danapolyLapCountView, final Function0 function0) {
        Intrinsics.checkNotNullParameter(danapolyLapCountView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        danapolyLapCountView.getBinding().moveToNextValue.setTransition(R.id.endAnimation);
        danapolyLapCountView.getBinding().moveToNextValue.transitionToEnd(new Runnable() { // from class: id.dana.danapoly.ui.board.view.DanapolyLapCountView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DanapolyLapCountView.$r8$lambda$gxo1qJxFtz0677hvrrnE0pixsHo(Function0.this);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$gxo1qJxFtz0677hvrrnE0pixsHo(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
