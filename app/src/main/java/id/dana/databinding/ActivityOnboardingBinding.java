package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityOnboardingBinding implements ViewBinding {
    private final LinearLayout MyBillsEntityDataFactory;
    public final FrameLayout PlaceComponentResult;

    private ActivityOnboardingBinding(LinearLayout linearLayout, FrameLayout frameLayout) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.PlaceComponentResult = frameLayout;
    }

    public static ActivityOnboardingBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_onboarding, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.container);
        if (frameLayout != null) {
            return new ActivityOnboardingBinding((LinearLayout) inflate, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.container)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
