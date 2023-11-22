package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.mybills.R;

/* loaded from: classes5.dex */
public final class ItemBillPaymentConfirmationBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CircleImageView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final CardView moveToNextValue;
    public final Guideline scheduleImpl;

    private ItemBillPaymentConfirmationBinding(CardView cardView, TextView textView, CircleImageView circleImageView, CircleImageView circleImageView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Guideline guideline, TextView textView2, TextView textView3, TextView textView4) {
        this.moveToNextValue = cardView;
        this.getAuthRequestContext = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleImageView;
        this.PlaceComponentResult = circleImageView2;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.scheduleImpl = guideline;
        this.getErrorConfigVersion = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView3;
        this.lookAheadTest = textView4;
    }

    public static ItemBillPaymentConfirmationBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d028f_networkuserentitydata_externalsyntheticlambda2, viewGroup, false);
        int i = R.id.res_0x7f0a027b_verifypinstatemanager_executeriskchallenge_2_2;
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (textView != null) {
            i = R.id.getOnBoardingScenario;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (circleImageView != null) {
                i = R.id.E;
                CircleImageView circleImageView2 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (circleImageView2 != null) {
                    i = R.id.clBillNameTryAgain;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (constraintLayout != null) {
                        i = R.id.clItemBillPaymentConfirm;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (constraintLayout2 != null) {
                            i = R.id.guideline2;
                            Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (guideline != null) {
                                i = R.id.ConcurrentKt;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView2 != null) {
                                    i = R.id.res_0x7f0a13da_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2;
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView3 != null) {
                                        i = R.id.getExceptionOrNull;
                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (textView4 != null) {
                                            return new ItemBillPaymentConfirmationBinding((CardView) inflate, textView, circleImageView, circleImageView2, constraintLayout, constraintLayout2, guideline, textView2, textView3, textView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
