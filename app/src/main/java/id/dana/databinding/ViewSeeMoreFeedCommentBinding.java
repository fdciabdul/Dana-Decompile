package id.dana.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSeeMoreFeedCommentBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ProgressBar MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ViewSeeMoreFeedCommentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.scheduleImpl = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = progressBar;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView2;
    }

    public static ViewSeeMoreFeedCommentBinding BuiltInFictitiousFunctionClassFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.res_0x7f0a0f9b_promocategorypresenter_1;
        ProgressBar progressBar = (ProgressBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0f9b_promocategorypresenter_1);
        if (progressBar != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ProductInfoEntityData);
            if (appCompatImageView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4275tvHideReplies);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4319res_0x7f0a155b_longcounterbuilder_cc);
                    if (appCompatTextView2 != null) {
                        return new ViewSeeMoreFeedCommentBinding(constraintLayout, constraintLayout, progressBar, appCompatImageView, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.f4319res_0x7f0a155b_longcounterbuilder_cc;
                } else {
                    i = R.id.f4275tvHideReplies;
                }
            } else {
                i = R.id.ProductInfoEntityData;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
