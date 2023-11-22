package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class BottomSheetEnableNotificationBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonGhostView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final ShapeableImageView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    private final CoordinatorLayout getErrorConfigVersion;
    public final AppCompatTextView scheduleImpl;

    private BottomSheetEnableNotificationBinding(CoordinatorLayout coordinatorLayout, DanaButtonGhostView danaButtonGhostView, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonGhostView;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = frameLayout;
        this.PlaceComponentResult = shapeableImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.scheduleImpl = appCompatTextView2;
    }

    public static BottomSheetEnableNotificationBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_enable_notification, viewGroup, false);
        int i = R.id.btn_negative;
        DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_negative);
        if (danaButtonGhostView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_positive);
            if (danaButtonPrimaryView != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.fl_container);
                if (frameLayout != null) {
                    ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_image);
                    if (shapeableImageView != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_message);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                            if (appCompatTextView2 != null) {
                                return new BottomSheetEnableNotificationBinding((CoordinatorLayout) inflate, danaButtonGhostView, danaButtonPrimaryView, frameLayout, shapeableImageView, appCompatTextView, appCompatTextView2);
                            }
                            i = R.id.tv_title;
                        } else {
                            i = R.id.tv_message;
                        }
                    } else {
                        i = R.id.iv_image;
                    }
                } else {
                    i = R.id.fl_container;
                }
            } else {
                i = R.id.btn_positive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
