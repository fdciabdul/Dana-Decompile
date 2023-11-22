package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;

/* loaded from: classes9.dex */
public final class FragmentGeneralBillsBottomSheetBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final BodySaveToBillsView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RelativeLayout MyBillsEntityDataFactory;
    public final ViewBodyGeneralBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final CoordinatorLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final NestedScrollView PlaceComponentResult;
    public final MyBillsToolbarView getAuthRequestContext;
    public final ViewHeaderDetailBillsBinding getErrorConfigVersion;
    public final View lookAheadTest;
    public final View moveToNextValue;
    public final ViewFooterAddNewBillsBinding scheduleImpl;

    private FragmentGeneralBillsBottomSheetBinding(CoordinatorLayout coordinatorLayout, ImageView imageView, RelativeLayout relativeLayout, NestedScrollView nestedScrollView, MyBillsToolbarView myBillsToolbarView, BodySaveToBillsView bodySaveToBillsView, ViewBodyGeneralBillsBinding viewBodyGeneralBillsBinding, View view, View view2, ViewFooterAddNewBillsBinding viewFooterAddNewBillsBinding, ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.MyBillsEntityDataFactory = relativeLayout;
        this.PlaceComponentResult = nestedScrollView;
        this.getAuthRequestContext = myBillsToolbarView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bodySaveToBillsView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewBodyGeneralBillsBinding;
        this.moveToNextValue = view;
        this.lookAheadTest = view2;
        this.scheduleImpl = viewFooterAddNewBillsBinding;
        this.getErrorConfigVersion = viewHeaderDetailBillsBinding;
    }

    public static FragmentGeneralBillsBottomSheetBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View BuiltInFictitiousFunctionClassFactory3;
        View inflate = layoutInflater.inflate(R.layout.fragment_general_bills_bottom_sheet, viewGroup, false);
        int i = R.id.M;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (imageView != null) {
            i = R.id.rl_general_bills_bottom_sheet;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (relativeLayout != null) {
                i = R.id.encodingStream_res_0x7f0a11c7;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (nestedScrollView != null) {
                    i = R.id.res_0x7f0a135c_basesocialfeedcontract_presenter;
                    MyBillsToolbarView myBillsToolbarView = (MyBillsToolbarView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (myBillsToolbarView != null) {
                        i = R.id.vAddToMyBills;
                        BodySaveToBillsView bodySaveToBillsView = (BodySaveToBillsView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (bodySaveToBillsView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.vBodyGeneralBills))) != null) {
                            ViewBodyGeneralBillsBinding authRequestContext = ViewBodyGeneralBillsBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                            i = R.id.res_0x7f0a19b1_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8;
                            View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (BuiltInFictitiousFunctionClassFactory4 != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.vDividerToolbar))) != null && (BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.GetTopUpUserConsult_res_0x7f0a19ba))) != null) {
                                ViewFooterAddNewBillsBinding PlaceComponentResult = ViewFooterAddNewBillsBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3);
                                i = R.id.vHeaderDetailBills;
                                View BuiltInFictitiousFunctionClassFactory5 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (BuiltInFictitiousFunctionClassFactory5 != null) {
                                    return new FragmentGeneralBillsBottomSheetBinding((CoordinatorLayout) inflate, imageView, relativeLayout, nestedScrollView, myBillsToolbarView, bodySaveToBillsView, authRequestContext, BuiltInFictitiousFunctionClassFactory4, BuiltInFictitiousFunctionClassFactory2, PlaceComponentResult, ViewHeaderDetailBillsBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory5));
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}
