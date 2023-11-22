package id.dana.showcase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.acs.plugin.downgrade.ui.ErrorPageActivity;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewTooltipTwoButtonWithImageBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b!\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0016\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001b\u0010\u000e"}, d2 = {"Lid/dana/showcase/view/TwoButtonWithImageContentView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewTooltipTwoButtonWithImageBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewTooltipTwoButtonWithImageBinding;", "", "desc", "", "setDescription", "(Ljava/lang/String;)V", "imageRes", "setImage", "(Ljava/lang/Integer;)V", ErrorPageActivity.KEY_BUTTON_TEXT, "Landroid/view/View$OnClickListener;", "onClickButtonListener", "buttonContentDescription", "setNegativeButton", "(Ljava/lang/String;Landroid/view/View$OnClickListener;Ljava/lang/String;)V", "positiveBtnText", "setPositiveButton", "title", GriverEvents.EVENT_SET_TITLE, "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwoButtonWithImageContentView extends ViewBindingRichView<ViewTooltipTwoButtonWithImageBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TwoButtonWithImageContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TwoButtonWithImageContentView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_tooltip_two_button_with_image;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoButtonWithImageContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ TwoButtonWithImageContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoButtonWithImageContentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewTooltipTwoButtonWithImageBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewTooltipTwoButtonWithImageBinding authRequestContext = ViewTooltipTwoButtonWithImageBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void setImage(Integer imageRes) {
        if (imageRes != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().getAuthRequestContext, imageRes.intValue());
            return;
        }
        AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
    }

    public final void setTitle(String title) {
        getBinding().MyBillsEntityDataFactory.setText(title);
    }

    public final void setDescription(String desc) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(desc);
    }

    public final void setPositiveButton(String positiveBtnText, final View.OnClickListener onClickButtonListener, String buttonContentDescription) {
        Button button = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(button, "");
        String str = positiveBtnText;
        button.setVisibility(true ^ (str == null || str.length() == 0) ? 0 : 8);
        button.setText(str);
        button.setContentDescription(buttonContentDescription);
        button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.showcase.view.TwoButtonWithImageContentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TwoButtonWithImageContentView.m2950$r8$lambda$Mu2Ez3rN31y3CX2GYcNzsvw(onClickButtonListener, view);
            }
        });
    }

    public final void setNegativeButton(String buttonText, final View.OnClickListener onClickButtonListener, String buttonContentDescription) {
        Button button = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(button, "");
        String str = buttonText;
        button.setVisibility(true ^ (str == null || str.length() == 0) ? 0 : 8);
        button.setText(str);
        button.setContentDescription(buttonContentDescription);
        button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.showcase.view.TwoButtonWithImageContentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TwoButtonWithImageContentView.$r8$lambda$svDgm8Oo5FzXj3UqcteoYltPgdU(onClickButtonListener, view);
            }
        });
    }

    /* renamed from: $r8$lambda$Mu2E-z3rN31y3C-X2G-YcNzsv-w  reason: not valid java name */
    public static /* synthetic */ void m2950$r8$lambda$Mu2Ez3rN31y3CX2GYcNzsvw(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void $r8$lambda$svDgm8Oo5FzXj3UqcteoYltPgdU(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
