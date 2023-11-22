package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class ViewActivityReactionsListBinding implements ViewBinding {
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LogoProgressView MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;

    private ViewActivityReactionsListBinding(ConstraintLayout constraintLayout, LogoProgressView logoProgressView, RecyclerView recyclerView, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = logoProgressView;
        this.getAuthRequestContext = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ViewActivityReactionsListBinding getAuthRequestContext(View view) {
        int i = R.id.lpv_activity_reactions;
        LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.lpv_activity_reactions);
        if (logoProgressView != null) {
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_activity_reactions);
            if (recyclerView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_reactions_name);
                if (textView != null) {
                    return new ViewActivityReactionsListBinding((ConstraintLayout) view, logoProgressView, recyclerView, textView);
                }
                i = R.id.tv_reactions_name;
            } else {
                i = R.id.rv_activity_reactions;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
