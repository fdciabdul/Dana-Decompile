package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemAddNewPhoneNumberBinding implements ViewBinding {
    public final CircleImageView BuiltInFictitiousFunctionClassFactory;
    public final DanaCheckboxButtonView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ItemAddNewPhoneNumberBinding(ConstraintLayout constraintLayout, DanaCheckboxButtonView danaCheckboxButtonView, CircleImageView circleImageView, TextView textView, TextView textView2) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaCheckboxButtonView;
        this.BuiltInFictitiousFunctionClassFactory = circleImageView;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = textView2;
    }

    public static ItemAddNewPhoneNumberBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d027a_networkuserentitydata_externalsyntheticlambda3, viewGroup, false);
        int i = R.id.checkbox_group_recipient;
        DanaCheckboxButtonView danaCheckboxButtonView = (DanaCheckboxButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaCheckboxButtonView != null) {
            i = R.id.iv_photo_group_recipient;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (circleImageView != null) {
                i = R.id.tv_add_phone_number_group_recipient;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null) {
                    i = R.id.tv_add_phone_number_message_group_recipient;
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView2 != null) {
                        return new ItemAddNewPhoneNumberBinding((ConstraintLayout) inflate, danaCheckboxButtonView, circleImageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
