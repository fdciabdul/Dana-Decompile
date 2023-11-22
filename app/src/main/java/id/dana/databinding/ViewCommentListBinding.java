package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCommentListBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ViewBackToTopBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView getAuthRequestContext;

    private ViewCommentListBinding(ConstraintLayout constraintLayout, ViewBackToTopBinding viewBackToTopBinding, RecyclerView recyclerView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewBackToTopBinding;
        this.getAuthRequestContext = recyclerView;
    }

    public static ViewCommentListBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.cvBackToTop;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cvBackToTop);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ViewBackToTopBinding PlaceComponentResult = ViewBackToTopBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_comment_list);
            if (recyclerView != null) {
                return new ViewCommentListBinding((ConstraintLayout) view, PlaceComponentResult, recyclerView);
            }
            i = R.id.rv_comment_list;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
