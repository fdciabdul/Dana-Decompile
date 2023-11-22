package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class ViewMaintenanceBroadcastBinding implements ViewBinding {
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewMaintenanceBroadcastBinding(TextView textView, TextView textView2) {
        this.getAuthRequestContext = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ViewMaintenanceBroadcastBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new ViewMaintenanceBroadcastBinding(textView, textView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
