package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.nearbyme.NewNearbyMeView;

/* loaded from: classes2.dex */
public final class ViewItemNearbyWidgetBinding implements ViewBinding {
    public final NewNearbyMeView BuiltInFictitiousFunctionClassFactory;
    public final NewNearbyMeView PlaceComponentResult;

    private ViewItemNearbyWidgetBinding(NewNearbyMeView newNearbyMeView, NewNearbyMeView newNearbyMeView2) {
        this.BuiltInFictitiousFunctionClassFactory = newNearbyMeView;
        this.PlaceComponentResult = newNearbyMeView2;
    }

    public static ViewItemNearbyWidgetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_nearby_widget, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        NewNearbyMeView newNearbyMeView = (NewNearbyMeView) inflate;
        return new ViewItemNearbyWidgetBinding(newNearbyMeView, newNearbyMeView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
