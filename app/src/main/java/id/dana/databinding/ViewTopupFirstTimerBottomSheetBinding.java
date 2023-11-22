package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewTopupFirstTimerBottomSheetBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView lookAheadTest;

    private ViewTopupFirstTimerBottomSheetBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.lookAheadTest = textView2;
    }

    public static ViewTopupFirstTimerBottomSheetBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.getErrorConfigVersion_res_0x7f0a0141;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.getErrorConfigVersion_res_0x7f0a0141);
        if (danaButtonPrimaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivGrid);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivTopUp);
                if (appCompatImageView2 != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDesc);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                        if (textView2 != null) {
                            return new ViewTopupFirstTimerBottomSheetBinding((ConstraintLayout) view, danaButtonPrimaryView, appCompatImageView, appCompatImageView2, textView, textView2);
                        }
                        i = R.id.tvTitle;
                    } else {
                        i = R.id.tvDesc;
                    }
                } else {
                    i = R.id.ivTopUp;
                }
            } else {
                i = R.id.ivGrid;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
