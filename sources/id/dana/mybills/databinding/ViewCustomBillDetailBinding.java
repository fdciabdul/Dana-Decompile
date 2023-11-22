package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ViewCustomBillDetailBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private final LinearLayoutCompat MyBillsEntityDataFactory;
    public final LinearLayoutCompat PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewCustomBillDetailBinding(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, LinearLayoutCompat linearLayoutCompat2) {
        this.MyBillsEntityDataFactory = linearLayoutCompat;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.getAuthRequestContext = textView2;
        this.PlaceComponentResult = linearLayoutCompat2;
    }

    public static ViewCustomBillDetailBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d04d0_networkuserentitydata_externalsyntheticlambda4, (ViewGroup) null, false);
        int i = R.id.ivDescIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.PlaybackStateCompat$MediaKeyAction;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.createJavaMethod_res_0x7f0a14a6;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) inflate;
                    return new ViewCustomBillDetailBinding(linearLayoutCompat, appCompatImageView, textView, textView2, linearLayoutCompat);
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
