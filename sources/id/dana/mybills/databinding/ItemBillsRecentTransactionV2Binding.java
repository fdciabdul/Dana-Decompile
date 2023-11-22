package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ItemBillsRecentTransactionV2Binding implements ViewBinding {
    public final CircleImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;

    private ItemBillsRecentTransactionV2Binding(ConstraintLayout constraintLayout, CircleImageView circleImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = circleImageView;
        this.getAuthRequestContext = textView;
        this.PlaceComponentResult = textView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView3;
        this.moveToNextValue = textView4;
        this.lookAheadTest = textView5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView6;
    }

    public static ItemBillsRecentTransactionV2Binding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_bills_recent_transaction_v2, viewGroup, false);
        int i = R.id.TypefaceCompatApi26Impl_res_0x7f0a0a23;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.res_0x7f0a13d5_arraytable_2;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.res_0x7f0a13d7_arraytable_1;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    i = R.id.res_0x7f0a13d8_flowkt__reducekt_firstornull_inlined_collectwhile_2_1;
                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView3 != null) {
                        i = R.id.SchedulerPoolFactory_res_0x7f0a13db;
                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView4 != null) {
                            i = R.id.onPolygonsChanged_res_0x7f0a13e9;
                            TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView5 != null) {
                                i = R.id.SplitSavingConfigEntityData_res_0x7f0a15ca;
                                TextView textView6 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView6 != null) {
                                    return new ItemBillsRecentTransactionV2Binding((ConstraintLayout) inflate, circleImageView, textView, textView2, textView3, textView4, textView5, textView6);
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
        return this.MyBillsEntityDataFactory;
    }
}
