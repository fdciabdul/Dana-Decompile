package id.dana.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewToolbarGlobalSearchBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final EditText MyBillsEntityDataFactory;
    public final Toolbar NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final ConstraintLayout lookAheadTest;
    public final LinearLayout scheduleImpl;

    private ViewToolbarGlobalSearchBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EditText editText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, Toolbar toolbar, TextView textView) {
        this.lookAheadTest = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.MyBillsEntityDataFactory = editText;
        this.getAuthRequestContext = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView3;
        this.scheduleImpl = linearLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = toolbar;
        this.getErrorConfigVersion = textView;
    }

    public static ViewToolbarGlobalSearchBinding BuiltInFictitiousFunctionClassFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.f3754et_global_search_toolbar;
        EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3754et_global_search_toolbar);
        if (editText != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_clear_toolbar_global_search);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_left_button);
                if (appCompatImageView2 != null) {
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_search_toolbar_global_search);
                    if (appCompatImageView3 != null) {
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_search_bar);
                        if (linearLayout != null) {
                            Toolbar toolbar = (Toolbar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tb_global_search_view);
                            if (toolbar != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_right_button);
                                if (textView != null) {
                                    return new ViewToolbarGlobalSearchBinding(constraintLayout, constraintLayout, editText, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayout, toolbar, textView);
                                }
                                i = R.id.tv_right_button;
                            } else {
                                i = R.id.tb_global_search_view;
                            }
                        } else {
                            i = R.id.ll_search_bar;
                        }
                    } else {
                        i = R.id.iv_search_toolbar_global_search;
                    }
                } else {
                    i = R.id.iv_left_button;
                }
            } else {
                i = R.id.iv_clear_toolbar_global_search;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
