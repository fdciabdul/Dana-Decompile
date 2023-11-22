package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class ViewHomePersonalizationBinding implements ViewBinding {
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private final AppCompatImageView PlaceComponentResult;

    private ViewHomePersonalizationBinding(AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
    }

    public static ViewHomePersonalizationBinding PlaceComponentResult(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view;
        return new ViewHomePersonalizationBinding(appCompatImageView, appCompatImageView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
