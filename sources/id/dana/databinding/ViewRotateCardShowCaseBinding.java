package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes8.dex */
public final class ViewRotateCardShowCaseBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Button MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;

    private ViewRotateCardShowCaseBinding(ConstraintLayout constraintLayout, Button button, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.MyBillsEntityDataFactory = button;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.PlaceComponentResult = textView;
        this.getErrorConfigVersion = textView2;
    }

    public static ViewRotateCardShowCaseBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.btnOkCardRotateTips;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnOkCardRotateTips);
        if (button != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivCardRotateCircle);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivCardRotateTips);
                if (appCompatImageView2 != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvContentTips);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvHeaderTips);
                        if (textView2 != null) {
                            return new ViewRotateCardShowCaseBinding((ConstraintLayout) view, button, appCompatImageView, appCompatImageView2, textView, textView2);
                        }
                        i = R.id.tvHeaderTips;
                    } else {
                        i = R.id.tvContentTips;
                    }
                } else {
                    i = R.id.ivCardRotateTips;
                }
            } else {
                i = R.id.ivCardRotateCircle;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
