package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemGlobalSendCountryBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final CircleImageView getAuthRequestContext;
    public final View scheduleImpl;

    private ItemGlobalSendCountryBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CircleImageView circleImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.getAuthRequestContext = circleImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView3;
        this.scheduleImpl = view;
    }

    public static ItemGlobalSendCountryBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.item_global_send_country, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.SendMoneyScenario_res_0x7f0a098c;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.tvCountryName;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatTextView != null) {
                i = R.id.tvSendEstimation;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatTextView2 != null) {
                    i = R.id.tvSendEstimationValue;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatTextView3 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.MatrixEvaluator))) != null) {
                        return new ItemGlobalSendCountryBinding(constraintLayout, constraintLayout, circleImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, BuiltInFictitiousFunctionClassFactory);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
