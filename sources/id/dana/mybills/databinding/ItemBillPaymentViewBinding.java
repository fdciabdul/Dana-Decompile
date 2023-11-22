package id.dana.mybills.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.mybills.R;

/* loaded from: classes2.dex */
public final class ItemBillPaymentViewBinding implements ViewBinding {
    public final MaterialCardView BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ItemBillPaymentViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, MaterialCardView materialCardView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, View view) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.getAuthRequestContext = imageView;
        this.BuiltInFictitiousFunctionClassFactory = materialCardView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.scheduleImpl = textView;
        this.getErrorConfigVersion = textView2;
        this.moveToNextValue = textView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
    }

    public static ItemBillPaymentViewBinding PlaceComponentResult(View view) {
        View BuiltInFictitiousFunctionClassFactory;
        int i = R.id.clHeaderSection;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (constraintLayout != null) {
            i = R.id.ivMiniIcon;
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (imageView != null) {
                i = R.id.mcvDropDownListBills;
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (materialCardView != null) {
                    i = R.id.rvItemBillPayment;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (recyclerView != null) {
                        i = R.id.isTmpDetached_res_0x7f0a14db;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (textView != null) {
                            i = R.id.res_0x7f0a1594_daggeremergencynotifcomponent_emergencynotifcomponentimpl;
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (textView2 != null) {
                                i = R.id.res_0x7f0a15b4_standardrowsortedtable_1;
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                if (textView3 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.vSumBillPaymentSkeleton))) != null) {
                                    return new ItemBillPaymentViewBinding((ConstraintLayout) view, constraintLayout, imageView, materialCardView, recyclerView, textView, textView2, textView3, BuiltInFictitiousFunctionClassFactory);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
