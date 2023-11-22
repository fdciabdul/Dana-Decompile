package id.dana.base.viewbinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import id.dana.R;
import id.dana.base.BaseFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\u0004\u0018\u00018\u00008EX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/base/viewbinding/ViewBindingFragment;", "Landroidx/viewbinding/ViewBinding;", "V", "Lid/dana/base/BaseFragment;", "Landroid/view/View;", "view", "", "bindView", "(Landroid/view/View;)V", "", "getShownErrorMessage", "()Ljava/lang/String;", "initViewBinding", "(Landroid/view/View;)Landroidx/viewbinding/ViewBinding;", "", "isViewBinded", "()Z", "binding$delegate", "Lid/dana/base/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "binding", PerfId.viewCreated, "Landroid/view/View;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ViewBindingFragment<V extends ViewBinding> extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ViewBindingFragment.class, "binding", "getBinding()Landroidx/viewbinding/ViewBinding;", 0))};
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: binding$delegate  reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding = new FragmentViewBindingDelegate(this, new ViewBindingFragment$binding$2(this));
    private View viewCreated;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract V initViewBinding(View view);

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.BaseFragment
    public void bindView(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.viewCreated = view;
    }

    @Override // id.dana.base.BaseFragment
    public boolean isViewBinded() {
        return this.viewCreated != null;
    }

    @JvmName(name = "getBinding")
    public final V getBinding() {
        return (V) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // id.dana.base.BaseFragment
    public String getShownErrorMessage() {
        try {
            V binding = getBinding();
            if (binding != null) {
                TextView textView = (TextView) binding.KClassImpl$Data$declaredNonStaticMembers$2().findViewWithTag(getResources().getString(R.string.error_message_tag));
                String obj = textView.getVisibility() == 0 ? textView.getText().toString() : "";
                return obj == null ? "" : obj;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
