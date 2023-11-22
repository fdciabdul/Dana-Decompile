package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewEditTextFormBinding implements ViewBinding {
    public final DanaCheckboxButtonView BuiltInFictitiousFunctionClassFactory;
    public final DanaTextBoxView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final ImageView PlaceComponentResult;
    public final Group getAuthRequestContext;
    public final ConstraintLayout getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final CardView scheduleImpl;

    private ViewEditTextFormBinding(ConstraintLayout constraintLayout, DanaCheckboxButtonView danaCheckboxButtonView, DanaTextBoxView danaTextBoxView, Group group, ImageView imageView, ImageView imageView2, CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.getErrorConfigVersion = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaCheckboxButtonView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaTextBoxView;
        this.getAuthRequestContext = group;
        this.MyBillsEntityDataFactory = imageView;
        this.PlaceComponentResult = imageView2;
        this.scheduleImpl = cardView;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.moveToNextValue = textView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView4;
        this.initRecordTimeStamp = textView5;
    }

    public static ViewEditTextFormBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_edit_text_form, viewGroup, false);
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda4;
        DanaCheckboxButtonView danaCheckboxButtonView = (DanaCheckboxButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaCheckboxButtonView != null) {
            i = R.id.etForm;
            DanaTextBoxView danaTextBoxView = (DanaTextBoxView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaTextBoxView != null) {
                i = R.id.res_0x7f0a07d4_requestmoneyqrcontract_view;
                Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (group != null) {
                    i = R.id.insertActivities_res_0x7f0a09a2;
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (imageView != null) {
                        i = R.id.getRawPath_res_0x7f0a09d1;
                        ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (imageView2 != null) {
                            i = R.id.secondaryAdditionalInfo;
                            CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (cardView != null) {
                                i = R.id.KeyEvent$DispatcherState;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView != null) {
                                    i = R.id.res_0x7f0a13fc_imagecaptureviewmodel_gettipuploadphoto_2;
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView2 != null) {
                                        i = R.id.resetSizeCounter;
                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (textView3 != null) {
                                            i = R.id.tvHeaderForm;
                                            TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (textView4 != null) {
                                                i = R.id.tvSecondaryAdditionalInfo;
                                                TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                if (textView5 != null) {
                                                    return new ViewEditTextFormBinding((ConstraintLayout) inflate, danaCheckboxButtonView, danaTextBoxView, group, imageView, imageView2, cardView, textView, textView2, textView3, textView4, textView5);
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
        return this.getErrorConfigVersion;
    }
}
