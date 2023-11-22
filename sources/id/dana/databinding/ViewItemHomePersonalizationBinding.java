package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.animation.view.HomePersonalizationView;

/* loaded from: classes2.dex */
public final class ViewItemHomePersonalizationBinding implements ViewBinding {
    public final HomePersonalizationView MyBillsEntityDataFactory;
    public final HomePersonalizationView getAuthRequestContext;

    private ViewItemHomePersonalizationBinding(HomePersonalizationView homePersonalizationView, HomePersonalizationView homePersonalizationView2) {
        this.MyBillsEntityDataFactory = homePersonalizationView;
        this.getAuthRequestContext = homePersonalizationView2;
    }

    public static ViewItemHomePersonalizationBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_home_personalization, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        HomePersonalizationView homePersonalizationView = (HomePersonalizationView) inflate;
        return new ViewItemHomePersonalizationBinding(homePersonalizationView, homePersonalizationView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
