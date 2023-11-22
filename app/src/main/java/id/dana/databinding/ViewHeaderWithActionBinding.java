package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewHeaderWithActionBinding implements ViewBinding {
    public final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    private final RelativeLayout PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;

    private ViewHeaderWithActionBinding(RelativeLayout relativeLayout, DanaButtonSecondaryView danaButtonSecondaryView, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.PlaceComponentResult = relativeLayout;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout2;
        this.MyBillsEntityDataFactory = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView2;
    }

    public static ViewHeaderWithActionBinding PlaceComponentResult(View view) {
        int i = R.id.f3539ReferralMapper_Factory_res_0x7f0a024f;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3539ReferralMapper_Factory_res_0x7f0a024f);
        if (danaButtonSecondaryView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4543tv_widget_description);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4546tv_widget_title);
                if (textView2 != null) {
                    return new ViewHeaderWithActionBinding(relativeLayout, danaButtonSecondaryView, relativeLayout, textView, textView2);
                }
                i = R.id.f4546tv_widget_title;
            } else {
                i = R.id.f4543tv_widget_description;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
