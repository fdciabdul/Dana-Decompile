package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class FragmentCashierPromoSelectionBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final LogoProgressView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final ViewCashierHeaderBinding PlaceComponentResult;
    public final MaterialCardView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ViewCashierToolbarBinding moveToNextValue;
    public final RecyclerView scheduleImpl;

    private FragmentCashierPromoSelectionBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, FrameLayout frameLayout, ViewCashierHeaderBinding viewCashierHeaderBinding, LogoProgressView logoProgressView, MaterialCardView materialCardView, RecyclerView recyclerView, ViewCashierToolbarBinding viewCashierToolbarBinding) {
        this.getErrorConfigVersion = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.PlaceComponentResult = viewCashierHeaderBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = logoProgressView;
        this.getAuthRequestContext = materialCardView;
        this.scheduleImpl = recyclerView;
        this.moveToNextValue = viewCashierToolbarBinding;
    }

    public static FragmentCashierPromoSelectionBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_promo_selection, (ViewGroup) null, false);
        int i = R.id.btnUnselectPromo;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnUnselectPromo);
        if (danaButtonSecondaryView != null) {
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flDanaLoading);
            if (frameLayout != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cancelEventDelivery);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    ViewCashierHeaderBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCashierHeaderBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                    LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4033lpvLoading);
                    if (logoProgressView != null) {
                        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.materialCardView);
                        if (materialCardView != null) {
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvCashierPromo);
                            if (recyclerView != null) {
                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbar);
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    return new FragmentCashierPromoSelectionBinding((ConstraintLayout) inflate, danaButtonSecondaryView, frameLayout, KClassImpl$Data$declaredNonStaticMembers$2, logoProgressView, materialCardView, recyclerView, ViewCashierToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2));
                                }
                                i = R.id.toolbar;
                            } else {
                                i = R.id.rvCashierPromo;
                            }
                        } else {
                            i = R.id.materialCardView;
                        }
                    } else {
                        i = R.id.f4033lpvLoading;
                    }
                } else {
                    i = R.id.cancelEventDelivery;
                }
            } else {
                i = R.id.flDanaLoading;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
