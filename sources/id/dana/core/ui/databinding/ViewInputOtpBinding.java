package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewInputOtpBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout getAuthRequestContext;

    private ViewInputOtpBinding(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.getAuthRequestContext = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout2;
    }

    public static ViewInputOtpBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d057c_networkuserentitydata_externalsyntheticlambda2, (ViewGroup) null, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        LinearLayout linearLayout = (LinearLayout) inflate;
        return new ViewInputOtpBinding(linearLayout, linearLayout);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
