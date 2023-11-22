package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.pushverify.view.richview.VerificationStateView;

/* loaded from: classes4.dex */
public final class FragmentVerificationListActiveBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView PlaceComponentResult;
    public final VerificationStateView getAuthRequestContext;

    private FragmentVerificationListActiveBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, VerificationStateView verificationStateView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = recyclerView;
        this.getAuthRequestContext = verificationStateView;
    }

    public static FragmentVerificationListActiveBinding PlaceComponentResult(View view) {
        int i = R.id.rv_verification_list_active;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_verification_list_active);
        if (recyclerView != null) {
            VerificationStateView verificationStateView = (VerificationStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vs_state);
            if (verificationStateView != null) {
                return new FragmentVerificationListActiveBinding((ConstraintLayout) view, recyclerView, verificationStateView);
            }
            i = R.id.vs_state;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
