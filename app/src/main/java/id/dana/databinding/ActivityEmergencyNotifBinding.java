package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ActivityEmergencyNotifBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonSecondaryView PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final AppCompatTextView scheduleImpl;

    private ActivityEmergencyNotifBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.PlaceComponentResult = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
        this.scheduleImpl = appCompatTextView3;
    }

    public static ActivityEmergencyNotifBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_emergency_notif, (ViewGroup) null, false);
        int i = R.id.PlaceComponentResult_res_0x7f0a021e;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.PlaceComponentResult_res_0x7f0a021e);
        if (danaButtonSecondaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_maintenance);
            if (appCompatImageView != null) {
                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ll_content);
                if (linearLayout != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_desc);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a190e_summaryvoucherview_externalsyntheticlambda0);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                            if (appCompatTextView3 != null) {
                                return new ActivityEmergencyNotifBinding((ConstraintLayout) inflate, danaButtonSecondaryView, appCompatImageView, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                            }
                            i = R.id.tv_title;
                        } else {
                            i = R.id.res_0x7f0a190e_summaryvoucherview_externalsyntheticlambda0;
                        }
                    } else {
                        i = R.id.tv_desc;
                    }
                } else {
                    i = R.id.ll_content;
                }
            } else {
                i = R.id.iv_maintenance;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
