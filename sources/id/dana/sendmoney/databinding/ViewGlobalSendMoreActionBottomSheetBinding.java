package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.cellcomponent.DanaCellLeftView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewGlobalSendMoreActionBottomSheetBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaCellLeftView PlaceComponentResult;
    public final DanaCellLeftView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView moveToNextValue;
    private final CoordinatorLayout scheduleImpl;

    private ViewGlobalSendMoreActionBottomSheetBinding(CoordinatorLayout coordinatorLayout, DanaCellLeftView danaCellLeftView, DanaCellLeftView danaCellLeftView2, FrameLayout frameLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.scheduleImpl = coordinatorLayout;
        this.PlaceComponentResult = danaCellLeftView;
        this.getAuthRequestContext = danaCellLeftView2;
        this.MyBillsEntityDataFactory = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.moveToNextValue = textView3;
        this.getErrorConfigVersion = textView4;
    }

    public static ViewGlobalSendMoreActionBottomSheetBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_global_send_more_action_bottom_sheet, viewGroup, false);
        int i = R.id.res_0x7f0a02c2_networkuserentitydata_externalsyntheticlambda6;
        DanaCellLeftView danaCellLeftView = (DanaCellLeftView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaCellLeftView != null) {
            i = R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a02c3;
            DanaCellLeftView danaCellLeftView2 = (DanaCellLeftView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaCellLeftView2 != null) {
                i = R.id.flMoreActionRecipientGlobalSend;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (frameLayout != null) {
                    i = R.id.InitSecurePreferenceAccount_res_0x7f0a097f;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.CacheBuilderSpec$AccessDurationParser;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView != null) {
                            i = R.id.res_0x7f0a13c0_fontscontractcompat_fontrequestcallback;
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView2 != null) {
                                i = R.id.VerifyPushDerollRequest_res_0x7f0a14e3;
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView3 != null) {
                                    i = R.id.setDistrictAdcode;
                                    TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView4 != null) {
                                        return new ViewGlobalSendMoreActionBottomSheetBinding((CoordinatorLayout) inflate, danaCellLeftView, danaCellLeftView2, frameLayout, appCompatImageView, textView, textView2, textView3, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
