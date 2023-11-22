package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.service.ServiceBadgeImageView;

/* loaded from: classes4.dex */
public final class NewLayoutCustomGridviewBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;
    public final ServiceBadgeImageView moveToNextValue;

    private NewLayoutCustomGridviewBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView2, ServiceBadgeImageView serviceBadgeImageView, ConstraintLayout constraintLayout2) {
        this.lookAheadTest = constraintLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.PlaceComponentResult = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView2;
        this.moveToNextValue = serviceBadgeImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout2;
    }

    public static NewLayoutCustomGridviewBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.f3704custom_gridview_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3704custom_gridview_image);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3705custom_gridview_image_badges_text);
            if (appCompatTextView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.custom_gridview_maintenance_badge);
                if (appCompatImageView2 != null) {
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3706custom_gridview_red_dot);
                    if (appCompatImageView3 != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3707custom_gridview_text);
                        if (appCompatTextView2 != null) {
                            ServiceBadgeImageView serviceBadgeImageView = (ServiceBadgeImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3887x7244421d);
                            if (serviceBadgeImageView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                return new NewLayoutCustomGridviewBinding(constraintLayout, appCompatImageView, appCompatTextView, appCompatImageView2, appCompatImageView3, appCompatTextView2, serviceBadgeImageView, constraintLayout);
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
        return this.lookAheadTest;
    }
}
