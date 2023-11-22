package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewProfileCtaBinding implements ViewBinding {
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout getAuthRequestContext;

    private ViewProfileCtaBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
    }

    public static ViewProfileCtaBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_profile_cta, (ViewGroup) null, false);
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvProfileCta);
        if (recyclerView != null) {
            return new ViewProfileCtaBinding((ConstraintLayout) inflate, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.rvProfileCta)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
