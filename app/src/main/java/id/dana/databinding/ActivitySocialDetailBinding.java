package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/* loaded from: classes4.dex */
public final class ActivitySocialDetailBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final ViewSocialFeedsEmptyStateBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final PtrClassicFrameLayout PlaceComponentResult;
    public final ViewBackToTopBinding getAuthRequestContext;
    public final LayoutToolbarBinding getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;

    private ActivitySocialDetailBinding(ConstraintLayout constraintLayout, ViewBackToTopBinding viewBackToTopBinding, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout2, PtrClassicFrameLayout ptrClassicFrameLayout, RecyclerView recyclerView, LayoutToolbarBinding layoutToolbarBinding, ViewSocialFeedsEmptyStateBinding viewSocialFeedsEmptyStateBinding) {
        this.lookAheadTest = constraintLayout;
        this.getAuthRequestContext = viewBackToTopBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = ptrClassicFrameLayout;
        this.MyBillsEntityDataFactory = recyclerView;
        this.getErrorConfigVersion = layoutToolbarBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewSocialFeedsEmptyStateBinding;
    }

    public static ActivitySocialDetailBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_social_detail, (ViewGroup) null, false);
        int i = R.id.btn_back_to_top;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_back_to_top);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ViewBackToTopBinding PlaceComponentResult = ViewBackToTopBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_unblock);
            if (danaButtonSecondaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clSocialDetail);
                if (constraintLayout != null) {
                    PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ptr_feeds);
                    if (ptrClassicFrameLayout != null) {
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvSocialProfile);
                        if (recyclerView != null) {
                            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tb_social_detail);
                            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vh_empty_state);
                                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                    return new ActivitySocialDetailBinding((ConstraintLayout) inflate, PlaceComponentResult, danaButtonSecondaryView, constraintLayout, ptrClassicFrameLayout, recyclerView, MyBillsEntityDataFactory, ViewSocialFeedsEmptyStateBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3));
                                }
                                i = R.id.vh_empty_state;
                            } else {
                                i = R.id.tb_social_detail;
                            }
                        } else {
                            i = R.id.rvSocialProfile;
                        }
                    } else {
                        i = R.id.ptr_feeds;
                    }
                } else {
                    i = R.id.clSocialDetail;
                }
            } else {
                i = R.id.btn_unblock;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
