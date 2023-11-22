package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewDialogDeleteMemberBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Button MyBillsEntityDataFactory;
    public final Button PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    private final LinearLayout lookAheadTest;
    public final TextView scheduleImpl;

    private ViewDialogDeleteMemberBinding(LinearLayout linearLayout, Button button, Button button2, ConstraintLayout constraintLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.lookAheadTest = linearLayout;
        this.MyBillsEntityDataFactory = button;
        this.PlaceComponentResult = button2;
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.scheduleImpl = textView2;
    }

    public static ViewDialogDeleteMemberBinding PlaceComponentResult(View view) {
        int i = R.id.btn_negative;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_negative);
        if (button != null) {
            Button button2 = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_positive);
            if (button2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_action_dialog);
                if (constraintLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.isHelperTextDisplayed);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                        if (textView2 != null) {
                            return new ViewDialogDeleteMemberBinding(linearLayout, button, button2, constraintLayout, linearLayout, textView, textView2);
                        }
                        i = R.id.tvTitle;
                    } else {
                        i = R.id.isHelperTextDisplayed;
                    }
                } else {
                    i = R.id.cl_action_dialog;
                }
            } else {
                i = R.id.btn_positive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
