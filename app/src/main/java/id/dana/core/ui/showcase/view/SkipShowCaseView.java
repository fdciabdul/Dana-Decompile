package id.dana.core.ui.showcase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.databinding.ViewShowcaseSkipBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B+\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/core/ui/showcase/view/SkipShowCaseView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/core/ui/databinding/ViewShowcaseSkipBinding;", "inflateViewBinding", "()Lid/dana/core/ui/databinding/ViewShowcaseSkipBinding;", "Landroid/view/View$OnClickListener;", "onClickListener", "", "setOnSkipButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "setup", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SkipShowCaseView extends BaseViewBindingRichView<ViewShowcaseSkipBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SkipShowCaseView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SkipShowCaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipShowCaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SkipShowCaseView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipShowCaseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewShowcaseSkipBinding inflateViewBinding() {
        ViewShowcaseSkipBinding PlaceComponentResult = ViewShowcaseSkipBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void setOnSkipButtonClickListener(final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.showcase.view.SkipShowCaseView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkipShowCaseView.$r8$lambda$SWTWN0oCv5Mklv5tPOODQWUia9s(onClickListener, this, view);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$SWTWN0oCv5Mklv5tPOODQWUia9s(View.OnClickListener onClickListener, SkipShowCaseView skipShowCaseView, View view) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        Intrinsics.checkNotNullParameter(skipShowCaseView, "");
        onClickListener.onClick(skipShowCaseView);
    }
}
