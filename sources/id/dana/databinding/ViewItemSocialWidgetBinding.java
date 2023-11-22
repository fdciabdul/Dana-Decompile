package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.social.view.NewSocialWidgetView;

/* loaded from: classes2.dex */
public final class ViewItemSocialWidgetBinding implements ViewBinding {
    public final NewSocialWidgetView KClassImpl$Data$declaredNonStaticMembers$2;
    public final NewSocialWidgetView PlaceComponentResult;

    private ViewItemSocialWidgetBinding(NewSocialWidgetView newSocialWidgetView, NewSocialWidgetView newSocialWidgetView2) {
        this.PlaceComponentResult = newSocialWidgetView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newSocialWidgetView2;
    }

    public static ViewItemSocialWidgetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_social_widget, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        NewSocialWidgetView newSocialWidgetView = (NewSocialWidgetView) inflate;
        return new ViewItemSocialWidgetBinding(newSocialWidgetView, newSocialWidgetView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
