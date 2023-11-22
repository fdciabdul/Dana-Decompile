package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.BodySinglePayView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;

/* loaded from: classes2.dex */
public final class FragmentSinglePayBillBottomSheetBinding implements ViewBinding {
    public final MaterialButton BuiltInFictitiousFunctionClassFactory;
    public final View DatabaseTableConfigUtil;
    private final CoordinatorLayout GetContactSyncConfig;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final LinearLayoutCompat NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final BodySinglePayView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final MaterialButton PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final ImageView getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final NestedScrollView lookAheadTest;
    public final MyBillsToolbarView moveToNextValue;
    public final RelativeLayout scheduleImpl;

    private FragmentSinglePayBillBottomSheetBinding(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, DanaButtonPrimaryView danaButtonPrimaryView, MaterialButton materialButton2, ImageView imageView, ConstraintLayout constraintLayout, ImageView imageView2, LinearLayoutCompat linearLayoutCompat, RelativeLayout relativeLayout, NestedScrollView nestedScrollView, MyBillsToolbarView myBillsToolbarView, TextView textView, BodySinglePayView bodySinglePayView, View view) {
        this.GetContactSyncConfig = coordinatorLayout;
        this.PlaceComponentResult = materialButton;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = materialButton2;
        this.getAuthRequestContext = imageView;
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getErrorConfigVersion = imageView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearLayoutCompat;
        this.scheduleImpl = relativeLayout;
        this.lookAheadTest = nestedScrollView;
        this.moveToNextValue = myBillsToolbarView;
        this.initRecordTimeStamp = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = bodySinglePayView;
        this.DatabaseTableConfigUtil = view;
    }

    public static FragmentSinglePayBillBottomSheetBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0207_networkuserentitydata_externalsyntheticlambda1, viewGroup, false);
        int i = R.id.btnDeleteBill;
        MaterialButton materialButton = (MaterialButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (materialButton != null) {
            i = R.id.A;
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaButtonPrimaryView != null) {
                i = R.id.btnSaveChangesBill;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (materialButton2 != null) {
                    i = R.id.M;
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (imageView != null) {
                        i = R.id.footerPaySingle;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (constraintLayout != null) {
                            i = R.id.ivDangerDescription;
                            ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (imageView2 != null) {
                                i = R.id.llcBtnEditState;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (linearLayoutCompat != null) {
                                    i = R.id.rlBottomSheetPaySingle;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (relativeLayout != null) {
                                        i = R.id.encodingStream_res_0x7f0a11c7;
                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (nestedScrollView != null) {
                                            i = R.id.res_0x7f0a135c_basesocialfeedcontract_presenter;
                                            MyBillsToolbarView myBillsToolbarView = (MyBillsToolbarView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (myBillsToolbarView != null) {
                                                i = R.id.PrefetchDownloadStatus_res_0x7f0a145a;
                                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                if (textView != null) {
                                                    i = R.id.vBodySinglePay;
                                                    BodySinglePayView bodySinglePayView = (BodySinglePayView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                    if (bodySinglePayView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.SplitReferralConfigEntityData_Factory_res_0x7f0a1a88))) != null) {
                                                        return new FragmentSinglePayBillBottomSheetBinding((CoordinatorLayout) inflate, materialButton, danaButtonPrimaryView, materialButton2, imageView, constraintLayout, imageView2, linearLayoutCompat, relativeLayout, nestedScrollView, myBillsToolbarView, textView, bodySinglePayView, BuiltInFictitiousFunctionClassFactory);
                                                    }
                                                }
                                            }
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
        return this.GetContactSyncConfig;
    }
}
