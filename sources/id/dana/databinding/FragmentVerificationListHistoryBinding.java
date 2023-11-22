package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.pushverify.view.richview.VerificationStateView;

/* loaded from: classes4.dex */
public final class FragmentVerificationListHistoryBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final VerificationStateView PlaceComponentResult;

    private FragmentVerificationListHistoryBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, VerificationStateView verificationStateView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.PlaceComponentResult = verificationStateView;
    }

    public static FragmentVerificationListHistoryBinding getAuthRequestContext(View view) {
        int i = R.id.rv_verification_list_history;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_verification_list_history);
        if (recyclerView != null) {
            VerificationStateView verificationStateView = (VerificationStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vs_state);
            if (verificationStateView != null) {
                return new FragmentVerificationListHistoryBinding((ConstraintLayout) view, recyclerView, verificationStateView);
            }
            i = R.id.vs_state;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
