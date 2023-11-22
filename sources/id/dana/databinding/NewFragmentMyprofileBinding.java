package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.richview.NewSimpleProfileWithQrView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/* loaded from: classes2.dex */
public final class NewFragmentMyprofileBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout DatabaseTableConfigUtil;
    public final AppCompatButton KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final NestedScrollView PlaceComponentResult;
    public final CoordinatorLayout getAuthRequestContext;
    public final PtrClassicFrameLayout getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final LinearLayout moveToNextValue;
    public final NewSimpleProfileWithQrView scheduleImpl;

    private NewFragmentMyprofileBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, AppCompatButton appCompatButton, CoordinatorLayout coordinatorLayout, LayoutToolbarBinding layoutToolbarBinding, NestedScrollView nestedScrollView, NewSimpleProfileWithQrView newSimpleProfileWithQrView, PtrClassicFrameLayout ptrClassicFrameLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView, LinearLayout linearLayout) {
        this.DatabaseTableConfigUtil = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatButton;
        this.getAuthRequestContext = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.PlaceComponentResult = nestedScrollView;
        this.scheduleImpl = newSimpleProfileWithQrView;
        this.getErrorConfigVersion = ptrClassicFrameLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.lookAheadTest = appCompatTextView;
        this.moveToNextValue = linearLayout;
    }

    public static NewFragmentMyprofileBinding PlaceComponentResult(View view) {
        int i = R.id.btnLogout;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnLogout);
        if (danaButtonSecondaryView != null) {
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_verify);
            if (appCompatButton != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_fragment_new_profile);
                if (coordinatorLayout != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.include_toolbar);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.nsv_profile);
                        if (nestedScrollView != null) {
                            NewSimpleProfileWithQrView newSimpleProfileWithQrView = (NewSimpleProfileWithQrView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.profile);
                            if (newSimpleProfileWithQrView != null) {
                                PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ptr_fragment_new_profile);
                                if (ptrClassicFrameLayout != null) {
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_profile_setting);
                                    if (recyclerView != null) {
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAppVersion);
                                        if (appCompatTextView != null) {
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4562vg_profile_with_qr_show);
                                            if (linearLayout != null) {
                                                return new NewFragmentMyprofileBinding((ConstraintLayout) view, danaButtonSecondaryView, appCompatButton, coordinatorLayout, MyBillsEntityDataFactory, nestedScrollView, newSimpleProfileWithQrView, ptrClassicFrameLayout, recyclerView, appCompatTextView, linearLayout);
                                            }
                                            i = R.id.f4562vg_profile_with_qr_show;
                                        } else {
                                            i = R.id.tvAppVersion;
                                        }
                                    } else {
                                        i = R.id.rv_profile_setting;
                                    }
                                } else {
                                    i = R.id.ptr_fragment_new_profile;
                                }
                            } else {
                                i = R.id.profile;
                            }
                        } else {
                            i = R.id.nsv_profile;
                        }
                    } else {
                        i = R.id.include_toolbar;
                    }
                } else {
                    i = R.id.cl_fragment_new_profile;
                }
            } else {
                i = R.id.btn_verify;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
