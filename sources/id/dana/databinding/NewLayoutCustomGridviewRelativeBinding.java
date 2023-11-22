package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.service.ServiceBadgeImageView;

/* loaded from: classes4.dex */
public final class NewLayoutCustomGridviewRelativeBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    private final RelativeLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final ServiceBadgeImageView lookAheadTest;
    public final RelativeLayout scheduleImpl;

    private NewLayoutCustomGridviewRelativeBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView2, ServiceBadgeImageView serviceBadgeImageView, RelativeLayout relativeLayout2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = relativeLayout;
        this.MyBillsEntityDataFactory = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.PlaceComponentResult = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
        this.lookAheadTest = serviceBadgeImageView;
        this.scheduleImpl = relativeLayout2;
    }

    public static NewLayoutCustomGridviewRelativeBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.f3704custom_gridview_image;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3704custom_gridview_image);
        if (imageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3705custom_gridview_image_badges_text);
            if (textView != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.custom_gridview_maintenance_badge);
                if (appCompatImageView != null) {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3706custom_gridview_red_dot);
                    if (appCompatImageView2 != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3707custom_gridview_text);
                        if (textView2 != null) {
                            ServiceBadgeImageView serviceBadgeImageView = (ServiceBadgeImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3887x7244421d);
                            if (serviceBadgeImageView != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) view;
                                return new NewLayoutCustomGridviewRelativeBinding(relativeLayout, imageView, textView, appCompatImageView, appCompatImageView2, textView2, serviceBadgeImageView, relativeLayout);
                            }
                            i = R.id.f3887x7244421d;
                        } else {
                            i = R.id.f3707custom_gridview_text;
                        }
                    } else {
                        i = R.id.f3706custom_gridview_red_dot;
                    }
                } else {
                    i = R.id.custom_gridview_maintenance_badge;
                }
            } else {
                i = R.id.f3705custom_gridview_image_badges_text;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
