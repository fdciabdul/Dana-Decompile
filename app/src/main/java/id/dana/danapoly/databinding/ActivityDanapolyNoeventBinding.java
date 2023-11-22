package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ActivityDanapolyNoeventBinding implements ViewBinding {
    public final FragmentContainerView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatButton PlaceComponentResult;
    public final ViewBaseToolbarBinding getAuthRequestContext;
    public final TextView lookAheadTest;
    private final ConstraintLayout scheduleImpl;

    private ActivityDanapolyNoeventBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, FragmentContainerView fragmentContainerView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ViewBaseToolbarBinding viewBaseToolbarBinding, TextView textView) {
        this.scheduleImpl = constraintLayout;
        this.PlaceComponentResult = appCompatButton;
        this.BuiltInFictitiousFunctionClassFactory = fragmentContainerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.getAuthRequestContext = viewBaseToolbarBinding;
        this.lookAheadTest = textView;
    }

    public static ActivityDanapolyNoeventBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.activity_danapoly_noevent, (ViewGroup) null, false);
        int i = R.id.btnCheckWinner;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatButton != null) {
            i = R.id.fragment_container_no_event;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (fragmentContainerView != null) {
                i = R.id.iv_background;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.iv_no_event;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.toolbar_danapoly))) != null) {
                        ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                        i = R.id.res_0x7f0a17fa_getwalletv3recommendationconfig_lambda_193;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView != null) {
                            return new ActivityDanapolyNoeventBinding((ConstraintLayout) inflate, appCompatButton, fragmentContainerView, appCompatImageView, appCompatImageView2, MyBillsEntityDataFactory, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
