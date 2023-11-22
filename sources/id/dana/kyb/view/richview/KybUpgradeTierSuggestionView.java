package id.dana.kyb.view.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewKybUpgradeTierSuggestionBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.kyb.constant.KybUpgradeTierUrgencyLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B/\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/kyb/view/richview/KybUpgradeTierSuggestionView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewKybUpgradeTierSuggestionBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewKybUpgradeTierSuggestionBinding;", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "", "urgencyLevel", ContainerUIProvider.KEY_SHOW, "(Ljava/lang/String;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybUpgradeTierSuggestionView extends BaseViewBindingRichView<ViewKybUpgradeTierSuggestionBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybUpgradeTierSuggestionView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybUpgradeTierSuggestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybUpgradeTierSuggestionView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybUpgradeTierSuggestionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ KybUpgradeTierSuggestionView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewKybUpgradeTierSuggestionBinding inflateViewBinding() {
        ViewKybUpgradeTierSuggestionBinding MyBillsEntityDataFactory = ViewKybUpgradeTierSuggestionBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener l) {
        ViewKybUpgradeTierSuggestionBinding binding = getBinding();
        Group group = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(group, "");
        ViewExtKt.getAuthRequestContext(group, l);
        binding.getAuthRequestContext.setOnClickListener(l);
    }

    public final void show(String urgencyLevel) {
        Intrinsics.checkNotNullParameter(urgencyLevel, "");
        int hashCode = urgencyLevel.hashCode();
        if (hashCode == 75572) {
            if (urgencyLevel.equals(KybUpgradeTierUrgencyLevel.LOW)) {
                ViewKybUpgradeTierSuggestionBinding binding = getBinding();
                ConstraintLayout constraintLayout = binding.scheduleImpl;
                constraintLayout.setContentDescription("");
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(0);
                Group group = binding.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(group, "");
                group.setVisibility(0);
                Group group2 = binding.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(group2, "");
                group2.setVisibility(8);
            }
        } else if (hashCode != 2217378) {
            if (hashCode == 2402104 && urgencyLevel.equals("NONE")) {
                ConstraintLayout constraintLayout2 = getBinding().scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                constraintLayout2.setVisibility(8);
            }
        } else if (urgencyLevel.equals(KybUpgradeTierUrgencyLevel.HIGH)) {
            ViewKybUpgradeTierSuggestionBinding binding2 = getBinding();
            ConstraintLayout constraintLayout3 = binding2.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(constraintLayout3, "");
            constraintLayout3.setVisibility(0);
            constraintLayout3.setContentDescription(constraintLayout3.getContext().getString(R.string.box_high_urgency));
            constraintLayout3.setBackground(ContextCompat.PlaceComponentResult(constraintLayout3.getContext(), (int) R.drawable.bg_rounded_border_red_50));
            Group group3 = binding2.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(group3, "");
            group3.setVisibility(8);
            Group group4 = binding2.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(group4, "");
            group4.setVisibility(0);
        }
    }
}
