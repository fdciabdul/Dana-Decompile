package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewVerificationListStateBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewVerificationListStateBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, View view, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.getAuthRequestContext = textView2;
    }

    public static ViewVerificationListStateBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_verification_list_state, (ViewGroup) null, false);
        int i = R.id.f3450PrepareContext_res_0x7f0a011e;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3450PrepareContext_res_0x7f0a011e);
        if (danaButtonPrimaryView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.dividerLine);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivVerificationState);
                if (appCompatImageView != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvVerificationStateMessage);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvVerificationStateTitle);
                        if (textView2 != null) {
                            return new ViewVerificationListStateBinding((ConstraintLayout) inflate, danaButtonPrimaryView, BuiltInFictitiousFunctionClassFactory, appCompatImageView, textView, textView2);
                        }
                        i = R.id.tvVerificationStateTitle;
                    } else {
                        i = R.id.tvVerificationStateMessage;
                    }
                } else {
                    i = R.id.ivVerificationState;
                }
            } else {
                i = R.id.dividerLine;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
