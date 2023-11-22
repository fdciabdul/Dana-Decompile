package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes8.dex */
public final class ActivityMapPageBinding implements ViewBinding {
    public final Guideline BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final CoordinatorLayout MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final BottomSheetMapPageBinding PlaceComponentResult;
    public final CardView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ConstraintLayout moveToNextValue;
    public final View scheduleImpl;

    private ActivityMapPageBinding(ConstraintLayout constraintLayout, BottomSheetMapPageBinding bottomSheetMapPageBinding, CoordinatorLayout coordinatorLayout, CardView cardView, View view, Guideline guideline, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, View view2) {
        this.getErrorConfigVersion = constraintLayout;
        this.PlaceComponentResult = bottomSheetMapPageBinding;
        this.MyBillsEntityDataFactory = coordinatorLayout;
        this.getAuthRequestContext = cardView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = guideline;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView;
        this.moveToNextValue = constraintLayout2;
        this.scheduleImpl = view2;
    }

    public static ActivityMapPageBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_map_page, (ViewGroup) null, false);
        int i = R.id.bsAction;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.bsAction);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BottomSheetMapPageBinding authRequestContext = BottomSheetMapPageBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3582MultiLanguageHttpClient_res_0x7f0a032b);
            if (coordinatorLayout != null) {
                CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cvMyLocation);
                if (cardView != null) {
                    View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.actualDraw);
                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.glCenter);
                        if (guideline != null) {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivPin);
                            if (appCompatImageView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewGradient);
                                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                    return new ActivityMapPageBinding(constraintLayout, authRequestContext, coordinatorLayout, cardView, BuiltInFictitiousFunctionClassFactory2, guideline, appCompatImageView, constraintLayout, BuiltInFictitiousFunctionClassFactory3);
                                }
                                i = R.id.viewGradient;
                            } else {
                                i = R.id.ivPin;
                            }
                        } else {
                            i = R.id.glCenter;
                        }
                    } else {
                        i = R.id.actualDraw;
                    }
                } else {
                    i = R.id.cvMyLocation;
                }
            } else {
                i = R.id.f3582MultiLanguageHttpClient_res_0x7f0a032b;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
