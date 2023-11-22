package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ViewCustomerIdProviderBinding implements ViewBinding {
    public final EditText BuiltInFictitiousFunctionClassFactory;
    public final ProgressBar KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final ImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewCustomerIdProviderBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EditText editText, ImageView imageView, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = editText;
        this.PlaceComponentResult = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = progressBar;
        this.getErrorConfigVersion = textView;
        this.scheduleImpl = textView2;
        this.moveToNextValue = textView3;
    }

    public static ViewCustomerIdProviderBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d04e1_networkuserentitydata_externalsyntheticlambda3, (ViewGroup) null, false);
        int i = R.id.clCustomText;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.etCustomText;
            EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (editText != null) {
                i = R.id.ivClearText;
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (imageView != null) {
                    i = R.id.res_0x7f0a0f9b_promocategorypresenter_1;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (progressBar != null) {
                        i = R.id.checkMarmotConfig_res_0x7f0a14a7;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView != null) {
                            i = R.id.res_0x7f0a14a9_typetoken_typeset;
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView2 != null) {
                                i = R.id.murmurHash64WithSeed_res_0x7f0a14ac;
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView3 != null) {
                                    return new ViewCustomerIdProviderBinding((ConstraintLayout) inflate, constraintLayout, editText, imageView, progressBar, textView, textView2, textView3);
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
        return this.MyBillsEntityDataFactory;
    }
}
