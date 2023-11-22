package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ActivityDanapolySplashBinding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;

    private ActivityDanapolySplashBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
    }

    public static ActivityDanapolySplashBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_danapoly_splash, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a08e8_flowviewutil_textchanges_1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            return new ActivityDanapolySplashBinding((ConstraintLayout) inflate, appCompatImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
