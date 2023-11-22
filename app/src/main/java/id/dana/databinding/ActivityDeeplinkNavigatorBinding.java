package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import id.dana.R;

/* loaded from: classes8.dex */
public final class ActivityDeeplinkNavigatorBinding implements ViewBinding {
    private final ConstraintLayout getAuthRequestContext;

    private ActivityDeeplinkNavigatorBinding(ConstraintLayout constraintLayout) {
        this.getAuthRequestContext = constraintLayout;
    }

    public static ActivityDeeplinkNavigatorBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_deeplink_navigator, (ViewGroup) null, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        return new ActivityDeeplinkNavigatorBinding((ConstraintLayout) inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
