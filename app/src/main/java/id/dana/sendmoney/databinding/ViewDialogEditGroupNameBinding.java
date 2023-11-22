package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewDialogEditGroupNameBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonGhostView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CardView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaTextBoxView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final TextView lookAheadTest;
    public final FrameLayout scheduleImpl;

    private ViewDialogEditGroupNameBinding(FrameLayout frameLayout, CardView cardView, ConstraintLayout constraintLayout, DanaTextBoxView danaTextBoxView, DanaButtonGhostView danaButtonGhostView, DanaButtonPrimaryView danaButtonPrimaryView, TextView textView, TextView textView2) {
        this.scheduleImpl = frameLayout;
        this.MyBillsEntityDataFactory = cardView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = danaTextBoxView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonGhostView;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.lookAheadTest = textView2;
    }

    public static ViewDialogEditGroupNameBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.card_view;
        CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (cardView != null) {
            i = R.id.constrainLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (constraintLayout != null) {
                i = R.id.dtbEditNameGroup;
                DanaTextBoxView danaTextBoxView = (DanaTextBoxView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (danaTextBoxView != null) {
                    i = R.id.res_0x7f0a0f15_r8_lambda_z7cckimop_rjsrtg6ix8npycd_m;
                    DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (danaButtonGhostView != null) {
                        i = R.id.getStackFromEnd_res_0x7f0a0fcb;
                        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (danaButtonPrimaryView != null) {
                            i = R.id.SeekBarStopChangeEvent;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (textView != null) {
                                i = R.id.setValue;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                if (textView2 != null) {
                                    return new ViewDialogEditGroupNameBinding((FrameLayout) view, cardView, constraintLayout, danaTextBoxView, danaButtonGhostView, danaButtonPrimaryView, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewDialogEditGroupNameBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        return MyBillsEntityDataFactory(layoutInflater.inflate(R.layout.view_dialog_edit_group_name, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
