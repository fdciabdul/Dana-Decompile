package id.dana.mybills.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.mybills.R;
import id.dana.mybills.databinding.MyBillsToolbarLayoutBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fB+\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010!J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/MyBillsToolbarLayoutBinding;", "Landroidx/appcompat/widget/AppCompatImageView;", "getLeftButton", "()Landroidx/appcompat/widget/AppCompatImageView;", "", "getToolbarTitle", "()Ljava/lang/CharSequence;", "inflateViewBinding", "()Lid/dana/mybills/databinding/MyBillsToolbarLayoutBinding;", "", "icon", "Lkotlin/Function0;", "", "onClick", "setToolbarAction", "(ILkotlin/jvm/functions/Function0;)V", "color", "setToolbarBackgroundColor", "(I)V", "", "title", "setToolbarTitle", "(Ljava/lang/String;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsToolbarView extends BaseViewBindingRichView<MyBillsToolbarLayoutBinding> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyBillsToolbarView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyBillsToolbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    public /* synthetic */ MyBillsToolbarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsToolbarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsToolbarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final MyBillsToolbarLayoutBinding inflateViewBinding() {
        MyBillsToolbarLayoutBinding PlaceComponentResult = MyBillsToolbarLayoutBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void setToolbarTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "");
        TextView textView = getBinding().initRecordTimeStamp;
        textView.setText(title);
        textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), R.color.getErrorConfigVersion));
    }

    public final CharSequence getToolbarTitle() {
        CharSequence text = getBinding().initRecordTimeStamp.getText();
        Intrinsics.checkNotNullExpressionValue(text, "");
        return text;
    }

    public final void setToolbarAction(int icon, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, icon);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.MyBillsToolbarView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBillsToolbarView.$r8$lambda$oNNfwP7Q4kBSeG1nvjtr9zhSEgo(Function0.this, view);
            }
        });
    }

    public final void setToolbarBackgroundColor(int color) {
        getBinding().scheduleImpl.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), color));
    }

    public final AppCompatImageView getLeftButton() {
        AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        return appCompatImageView;
    }

    public static /* synthetic */ void $r8$lambda$oNNfwP7Q4kBSeG1nvjtr9zhSEgo(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
