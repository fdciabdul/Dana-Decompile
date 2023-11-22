package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemDropdownFormBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CardView MyBillsEntityDataFactory;
    public final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final LinearLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ItemDropdownFormBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, CardView cardView, CircleImageView circleImageView, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.MyBillsEntityDataFactory = cardView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleImageView;
        this.getAuthRequestContext = appCompatImageView;
        this.PlaceComponentResult = linearLayout2;
        this.getErrorConfigVersion = linearLayout3;
        this.moveToNextValue = textView;
        this.lookAheadTest = textView2;
        this.scheduleImpl = textView3;
    }

    public static ItemDropdownFormBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_dropdown_form, viewGroup, false);
        int i = R.id.getSupportButtonTintMode_res_0x7f0a0331;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.cvInfo;
            CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (cardView != null) {
                i = R.id.FlowableConcatMapEagerPublisher;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (circleImageView != null) {
                    i = R.id.encodingStream;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.checkParameterIsNotNull_res_0x7f0a0d49;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (linearLayout != null) {
                            LinearLayout linearLayout2 = (LinearLayout) inflate;
                            i = R.id.resetSizeCounter;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView != null) {
                                i = R.id.tvSelectedValue;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView2 != null) {
                                    i = R.id.setValue;
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView3 != null) {
                                        return new ItemDropdownFormBinding(linearLayout2, constraintLayout, cardView, circleImageView, appCompatImageView, linearLayout, linearLayout2, textView, textView2, textView3);
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
