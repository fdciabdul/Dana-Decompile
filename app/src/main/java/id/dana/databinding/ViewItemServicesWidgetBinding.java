package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.richview.servicescard.ServiceCardV2View;

/* loaded from: classes2.dex */
public final class ViewItemServicesWidgetBinding implements ViewBinding {
    public final ServiceCardV2View MyBillsEntityDataFactory;
    public final ServiceCardV2View getAuthRequestContext;

    private ViewItemServicesWidgetBinding(ServiceCardV2View serviceCardV2View, ServiceCardV2View serviceCardV2View2) {
        this.getAuthRequestContext = serviceCardV2View;
        this.MyBillsEntityDataFactory = serviceCardV2View2;
    }

    public static ViewItemServicesWidgetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_services_widget, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        ServiceCardV2View serviceCardV2View = (ServiceCardV2View) inflate;
        return new ViewItemServicesWidgetBinding(serviceCardV2View, serviceCardV2View);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
