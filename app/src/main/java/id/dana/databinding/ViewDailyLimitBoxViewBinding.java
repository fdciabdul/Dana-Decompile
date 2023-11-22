package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.component.edittextcomponent.DanaTextBoxView;

/* loaded from: classes4.dex */
public final class ViewDailyLimitBoxViewBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final TextInputLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaTextBoxView MyBillsEntityDataFactory;
    public final TextView getAuthRequestContext;

    private ViewDailyLimitBoxViewBinding(LinearLayout linearLayout, DanaTextBoxView danaTextBoxView, TextInputLayout textInputLayout, TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.MyBillsEntityDataFactory = danaTextBoxView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputLayout;
        this.getAuthRequestContext = textView;
    }

    public static ViewDailyLimitBoxViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_daily_limit_box_view, (ViewGroup) null, false);
        int i = R.id.etAmountDaily;
        DanaTextBoxView danaTextBoxView = (DanaTextBoxView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etAmountDaily);
        if (danaTextBoxView != null) {
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilAmountDaily);
            if (textInputLayout != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorHelper);
                if (textView != null) {
                    return new ViewDailyLimitBoxViewBinding((LinearLayout) inflate, danaTextBoxView, textInputLayout, textView);
                }
                i = R.id.tvErrorHelper;
            } else {
                i = R.id.tilAmountDaily;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
