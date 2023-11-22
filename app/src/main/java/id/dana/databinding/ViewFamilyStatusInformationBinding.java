package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewFamilyStatusInformationBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final TextView moveToNextValue;

    private ViewFamilyStatusInformationBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonPrimaryView danaButtonPrimaryView2, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView2;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.moveToNextValue = textView2;
    }

    public static ViewFamilyStatusInformationBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_family_status_information, (ViewGroup) null, false);
        int i = R.id.btnNegativeStatusInformation;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnNegativeStatusInformation);
        if (danaButtonSecondaryView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnPositiveStatusInformation);
            if (danaButtonPrimaryView != null) {
                DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnStatusInformationGotIt);
                if (danaButtonPrimaryView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clPositiveNegativeButton);
                    if (constraintLayout != null) {
                        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivStatusInformation);
                        if (imageView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvStatusInformationDescription);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvStatusInformationTitle);
                                if (textView2 != null) {
                                    return new ViewFamilyStatusInformationBinding((ConstraintLayout) inflate, danaButtonSecondaryView, danaButtonPrimaryView, danaButtonPrimaryView2, constraintLayout, imageView, textView, textView2);
                                }
                                i = R.id.tvStatusInformationTitle;
                            } else {
                                i = R.id.tvStatusInformationDescription;
                            }
                        } else {
                            i = R.id.ivStatusInformation;
                        }
                    } else {
                        i = R.id.clPositiveNegativeButton;
                    }
                } else {
                    i = R.id.btnStatusInformationGotIt;
                }
            } else {
                i = R.id.btnPositiveStatusInformation;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
