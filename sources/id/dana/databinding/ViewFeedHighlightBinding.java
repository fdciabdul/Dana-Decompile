package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewFeedHighlightBinding implements ViewBinding {
    public final View BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final View PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;
    private final ConstraintLayout scheduleImpl;

    private ViewFeedHighlightBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, View view, RecyclerView recyclerView, View view2, AppCompatTextView appCompatTextView) {
        this.scheduleImpl = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.PlaceComponentResult = view2;
        this.lookAheadTest = appCompatTextView;
    }

    public static ViewFeedHighlightBinding PlaceComponentResult(View view) {
        int i = R.id.cl_highlight;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_highlight);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_loading);
            if (constraintLayout2 != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.first_skeleton);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_highlight);
                    if (recyclerView != null) {
                        View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.second_skeleton);
                        if (BuiltInFictitiousFunctionClassFactory2 != null) {
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                            if (appCompatTextView != null) {
                                return new ViewFeedHighlightBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, BuiltInFictitiousFunctionClassFactory, recyclerView, BuiltInFictitiousFunctionClassFactory2, appCompatTextView);
                            }
                            i = R.id.tv_title;
                        } else {
                            i = R.id.second_skeleton;
                        }
                    } else {
                        i = R.id.rv_highlight;
                    }
                } else {
                    i = R.id.first_skeleton;
                }
            } else {
                i = R.id.cl_loading;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
