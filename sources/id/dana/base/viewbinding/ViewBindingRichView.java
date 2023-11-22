package id.dana.base.viewbinding;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B'\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010!J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00028\u00008\u0005@\u0005X\u0084.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/base/viewbinding/ViewBindingRichView;", "Landroidx/viewbinding/ViewBinding;", "V", "Lid/dana/base/BaseRichView;", "Landroid/view/View;", "view", "", "bindView", "(Landroid/view/View;)V", "", "Lid/dana/utils/DisplayedErrorMessage;", "getShownErrorMessage", "()Ljava/lang/String;", "initViewBinding", "(Landroid/view/View;)Landroidx/viewbinding/ViewBinding;", "", "isBindingInitialized", "()Z", "binding", "Landroidx/viewbinding/ViewBinding;", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ViewBindingRichView<V extends ViewBinding> extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;
    protected V binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewBindingRichView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewBindingRichView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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

    protected abstract V initViewBinding(View view);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewBindingRichView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ViewBindingRichView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewBindingRichView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public void bindView(View view) {
        View childAt;
        Intrinsics.checkNotNullParameter(view, "");
        Unit unit = null;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null && (childAt = viewGroup.getChildAt(0)) != null) {
            setBinding(initViewBinding(childAt));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            throw new IllegalStateException("view should be ViewGroup");
        }
    }

    public final boolean isBindingInitialized() {
        return this.binding != null;
    }

    @JvmName(name = "getBinding")
    public final V getBinding() {
        V v = this.binding;
        if (v != null) {
            return v;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBinding")
    protected final void setBinding(V v) {
        Intrinsics.checkNotNullParameter(v, "");
        this.binding = v;
    }

    public final String getShownErrorMessage() {
        try {
            View view = getView();
            TextView textView = view != null ? (TextView) view.findViewWithTag(getResources().getString(R.string.error_message_tag)) : null;
            boolean z = false;
            if (textView != null && textView.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                return textView.getText().toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }
}
