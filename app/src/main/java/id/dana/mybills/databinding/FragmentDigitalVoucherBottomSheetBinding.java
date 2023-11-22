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
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.CustomEditTextView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;

/* loaded from: classes9.dex */
public final class FragmentDigitalVoucherBottomSheetBinding implements ViewBinding {
    public final CustomDropdownView BuiltInFictitiousFunctionClassFactory;
    public final ViewHeaderDetailBillsBinding DatabaseTableConfigUtil;
    private final CoordinatorLayout GetContactSyncConfig;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final NestedScrollView MyBillsEntityDataFactory;
    public final MyBillsToolbarView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CustomEditTextView PlaceComponentResult;
    public final RelativeLayout getAuthRequestContext;
    public final View getErrorConfigVersion;
    public final BodySaveToBillsView lookAheadTest;
    public final ViewFooterAddNewBillsBinding moveToNextValue;
    public final View scheduleImpl;

    private FragmentDigitalVoucherBottomSheetBinding(CoordinatorLayout coordinatorLayout, ImageView imageView, CustomDropdownView customDropdownView, CustomEditTextView customEditTextView, RelativeLayout relativeLayout, NestedScrollView nestedScrollView, MyBillsToolbarView myBillsToolbarView, BodySaveToBillsView bodySaveToBillsView, View view, View view2, ViewFooterAddNewBillsBinding viewFooterAddNewBillsBinding, ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding) {
        this.GetContactSyncConfig = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.BuiltInFictitiousFunctionClassFactory = customDropdownView;
        this.PlaceComponentResult = customEditTextView;
        this.getAuthRequestContext = relativeLayout;
        this.MyBillsEntityDataFactory = nestedScrollView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = myBillsToolbarView;
        this.lookAheadTest = bodySaveToBillsView;
        this.scheduleImpl = view;
        this.getErrorConfigVersion = view2;
        this.moveToNextValue = viewFooterAddNewBillsBinding;
        this.DatabaseTableConfigUtil = viewHeaderDetailBillsBinding;
    }

    public static FragmentDigitalVoucherBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View BuiltInFictitiousFunctionClassFactory3;
        View inflate = layoutInflater.inflate(R.layout.fragment_digital_voucher_bottom_sheet, viewGroup, false);
        int i = R.id.M;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (imageView != null) {
            i = R.id.dropdownAmount;
            CustomDropdownView customDropdownView = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (customDropdownView != null) {
                i = R.id.TypeProjectionImpl_res_0x7f0a0689;
                CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (customEditTextView != null) {
                    i = R.id.rl_digital_voucher_bottom_sheet;
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
                                if (bodySaveToBillsView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.res_0x7f0a19b1_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8))) != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.vDividerToolbar))) != null && (BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.GetTopUpUserConsult_res_0x7f0a19ba))) != null) {
                                    ViewFooterAddNewBillsBinding PlaceComponentResult = ViewFooterAddNewBillsBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3);
                                    i = R.id.vHeaderDetailBills;
                                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                        return new FragmentDigitalVoucherBottomSheetBinding((CoordinatorLayout) inflate, imageView, customDropdownView, customEditTextView, relativeLayout, nestedScrollView, myBillsToolbarView, bodySaveToBillsView, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, PlaceComponentResult, ViewHeaderDetailBillsBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory4));
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
        return this.GetContactSyncConfig;
    }
}
