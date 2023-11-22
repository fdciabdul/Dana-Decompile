package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ItemMerchantBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CardView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final View getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView scheduleImpl;

    private ItemMerchantBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, CardView cardView, View view, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = cardView;
        this.getAuthRequestContext = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.PlaceComponentResult = constraintLayout2;
        this.scheduleImpl = textView;
        this.lookAheadTest = textView2;
        this.getErrorConfigVersion = textView3;
    }

    public static ItemMerchantBinding getAuthRequestContext(View view) {
        int i = R.id.btnRemove;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnRemove);
        if (danaButtonSecondaryView != null) {
            CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cvRounded);
            if (cardView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.itemDivider);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3854res_0x7f0a09f8_r8_lambda_npxyyf3zgc_tldyljuapq7cvou4);
                    if (appCompatImageView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvLinkedDate);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvLinkedRegId);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4286res_0x7f0a14d0_amountformuistate_onsuccesstransfersubmit);
                                if (textView3 != null) {
                                    return new ItemMerchantBinding(constraintLayout, danaButtonSecondaryView, cardView, BuiltInFictitiousFunctionClassFactory, appCompatImageView, constraintLayout, textView, textView2, textView3);
                                }
                                i = R.id.f4286res_0x7f0a14d0_amountformuistate_onsuccesstransfersubmit;
                            } else {
                                i = R.id.tvLinkedRegId;
                            }
                        } else {
                            i = R.id.tvLinkedDate;
                        }
                    } else {
                        i = R.id.f3854res_0x7f0a09f8_r8_lambda_npxyyf3zgc_tldyljuapq7cvou4;
                    }
                } else {
                    i = R.id.itemDivider;
                }
            } else {
                i = R.id.cvRounded;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
