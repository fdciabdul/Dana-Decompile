package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class ActivityPushVerifyBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final ViewStub KClassImpl$Data$declaredNonStaticMembers$2;
    public final LogoProgressView MyBillsEntityDataFactory;
    public final FrameLayout PlaceComponentResult;
    public final ViewStub getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ActivityPushVerifyBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, LogoProgressView logoProgressView, ViewStub viewStub, ViewStub viewStub2, LayoutToolbarBinding layoutToolbarBinding) {
        this.scheduleImpl = constraintLayout;
        this.PlaceComponentResult = frameLayout;
        this.MyBillsEntityDataFactory = logoProgressView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewStub;
        this.getAuthRequestContext = viewStub2;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
    }

    public static ActivityPushVerifyBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_push_verify, (ViewGroup) null, false);
        int i = R.id.flLoading;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flLoading);
        if (frameLayout != null) {
            LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lpv_push_verify);
            if (logoProgressView != null) {
                ViewStub viewStub = (ViewStub) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.push_verify_challenge);
                if (viewStub != null) {
                    ViewStub viewStub2 = (ViewStub) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.push_verify_error);
                    if (viewStub2 != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4218toolbar_layout);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            return new ActivityPushVerifyBinding((ConstraintLayout) inflate, frameLayout, logoProgressView, viewStub, viewStub2, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                        }
                        i = R.id.f4218toolbar_layout;
                    } else {
                        i = R.id.push_verify_error;
                    }
                } else {
                    i = R.id.push_verify_challenge;
                }
            } else {
                i = R.id.lpv_push_verify;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
