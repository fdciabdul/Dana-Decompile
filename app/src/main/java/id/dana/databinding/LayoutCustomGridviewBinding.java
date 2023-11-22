package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.service.ServiceBadgeImageView;

/* loaded from: classes4.dex */
public final class LayoutCustomGridviewBinding implements ViewBinding {
    public final ServiceBadgeImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatImageView getErrorConfigVersion;
    public final ConstraintLayout moveToNextValue;
    private final ConstraintLayout scheduleImpl;

    private LayoutCustomGridviewBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, AppCompatImageView appCompatImageView2, TextView textView2, ServiceBadgeImageView serviceBadgeImageView, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout2) {
        this.scheduleImpl = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = textView;
        this.getAuthRequestContext = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView2;
        this.BuiltInFictitiousFunctionClassFactory = serviceBadgeImageView;
        this.getErrorConfigVersion = appCompatImageView3;
        this.moveToNextValue = constraintLayout2;
    }

    public static LayoutCustomGridviewBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.f3704custom_gridview_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3704custom_gridview_image);
        if (appCompatImageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3705custom_gridview_image_badges_text);
            if (textView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3706custom_gridview_red_dot);
                if (appCompatImageView2 != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3707custom_gridview_text);
                    if (textView2 != null) {
                        ServiceBadgeImageView serviceBadgeImageView = (ServiceBadgeImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3887x7244421d);
                        if (serviceBadgeImageView != null) {
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3910iv_maintenance_badge);
                            if (appCompatImageView3 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                return new LayoutCustomGridviewBinding(constraintLayout, appCompatImageView, textView, appCompatImageView2, textView2, serviceBadgeImageView, appCompatImageView3, constraintLayout);
                            }
                            i = R.id.f3910iv_maintenance_badge;
                        } else {
                            i = R.id.f3887x7244421d;
                        }
                    } else {
                        i = R.id.f3707custom_gridview_text;
                    }
                } else {
                    i = R.id.f3706custom_gridview_red_dot;
                }
            } else {
                i = R.id.f3705custom_gridview_image_badges_text;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
