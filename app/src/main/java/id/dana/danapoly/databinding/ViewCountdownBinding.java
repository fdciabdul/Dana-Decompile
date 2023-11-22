package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewCountdownBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ViewCountdownBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
    }

    public static ViewCountdownBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d04cc_networkuserentitydata_externalsyntheticlambda7, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.ivCountdown;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.PrefetchDownloadStatus_res_0x7f0a140a;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatTextView != null) {
                i = R.id.checkMarmotConfig_res_0x7f0a140b;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatTextView2 != null) {
                    return new ViewCountdownBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatTextView, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
