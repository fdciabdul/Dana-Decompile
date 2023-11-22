package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemGroupRecipientBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaCheckboxButtonView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final View lookAheadTest;
    public final AppCompatTextView scheduleImpl;

    private ItemGroupRecipientBinding(ConstraintLayout constraintLayout, DanaCheckboxButtonView danaCheckboxButtonView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, CircleImageView circleImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaCheckboxButtonView;
        this.PlaceComponentResult = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout3;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = circleImageView;
        this.scheduleImpl = appCompatTextView;
        this.getErrorConfigVersion = appCompatTextView2;
        this.lookAheadTest = view;
    }

    public static ItemGroupRecipientBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d02cf_verifypinstatemanager_executeriskchallenge_2_1, viewGroup, false);
        int i = R.id.checkbox_group_recipient;
        DanaCheckboxButtonView danaCheckboxButtonView = (DanaCheckboxButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaCheckboxButtonView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            i = R.id.clMembers;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (constraintLayout2 != null) {
                i = R.id.res_0x7f0a0ae3_flowkt__reducekt_firstornull_inlined_collectwhile_2_1;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.iv_photo_group_recipient;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (circleImageView != null) {
                        i = R.id.tv_name_group_recipient;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatTextView != null) {
                            i = R.id.tv_phone_number_group_recipient;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (appCompatTextView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.MatrixEvaluator))) != null) {
                                return new ItemGroupRecipientBinding(constraintLayout, danaCheckboxButtonView, constraintLayout, constraintLayout2, appCompatImageView, circleImageView, appCompatTextView, appCompatTextView2, BuiltInFictitiousFunctionClassFactory);
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
