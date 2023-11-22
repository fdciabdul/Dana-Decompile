package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewHistoryAddFavoriteBinding implements ViewBinding {
    public final Group BuiltInFictitiousFunctionClassFactory;
    public final View DatabaseTableConfigUtil;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final SwitchMaterial NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final Group getAuthRequestContext;
    public final ConstraintLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private ViewHistoryAddFavoriteBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, Group group2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, SwitchMaterial switchMaterial, TextView textView, TextView textView2, View view) {
        this.getErrorConfigVersion = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = group;
        this.getAuthRequestContext = group2;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.scheduleImpl = appCompatImageView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = switchMaterial;
        this.moveToNextValue = textView;
        this.lookAheadTest = textView2;
        this.DatabaseTableConfigUtil = view;
    }

    public static ViewHistoryAddFavoriteBinding PlaceComponentResult(View view) {
        View BuiltInFictitiousFunctionClassFactory;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.groupFavorite;
        Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (group != null) {
            i = R.id.groupTransactionHistory;
            Group group2 = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (group2 != null) {
                i = R.id.getCardNumberOCR_res_0x7f0a08a5;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (appCompatImageView != null) {
                    i = R.id.res_0x7f0a08a8_otpregistrationpresenter_input_1;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.getDefaultSenderId_res_0x7f0a08a9;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (appCompatImageView3 != null) {
                            i = R.id.onLayoutDirectionChanged_res_0x7f0a12bc;
                            SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (switchMaterial != null) {
                                i = R.id.onCubeAppPerfEvent;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                if (textView != null) {
                                    i = R.id.res_0x7f0a1497_barcodeutil_externalsyntheticlambda0;
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                    if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.clearName))) != null) {
                                        return new ViewHistoryAddFavoriteBinding(constraintLayout, constraintLayout, group, group2, appCompatImageView, appCompatImageView2, appCompatImageView3, switchMaterial, textView, textView2, BuiltInFictitiousFunctionClassFactory);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
