package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemViewListBeneficiaryGlobalSendBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CircleImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView scheduleImpl;

    private ItemViewListBeneficiaryGlobalSendBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, CircleImageView circleImageView2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = circleImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleImageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.MyBillsEntityDataFactory = textView;
        this.scheduleImpl = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView3;
        this.getErrorConfigVersion = textView4;
    }

    public static ItemViewListBeneficiaryGlobalSendBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_view_list_beneficiary_global_send, viewGroup, false);
        int i = R.id.ivCountryFlag;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.res_0x7f0a09ed_basesocialfeedcontract_presenter;
            CircleImageView circleImageView2 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (circleImageView2 != null) {
                i = R.id.res_0x7f0a0a01_securitysettingsactivity_createpinlauncher_2_2;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.res_0x7f0a13c0_fontscontractcompat_fontrequestcallback;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView != null) {
                        i = R.id.tvBankNumberMask;
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView2 != null) {
                            i = R.id.SearchConditionEntityKt;
                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView3 != null) {
                                i = R.id.ItemSnapshotList;
                                TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView4 != null) {
                                    return new ItemViewListBeneficiaryGlobalSendBinding((ConstraintLayout) inflate, circleImageView, circleImageView2, appCompatImageView, textView, textView2, textView3, textView4);
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
        return this.getAuthRequestContext;
    }
}
