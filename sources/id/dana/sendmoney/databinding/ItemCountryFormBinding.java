package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemCountryFormBinding implements ViewBinding {
    public final CircleImageView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CardView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;

    private ItemCountryFormBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CardView cardView, ImageView imageView, CircleImageView circleImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.MyBillsEntityDataFactory = cardView;
        this.getAuthRequestContext = imageView;
        this.BuiltInFictitiousFunctionClassFactory = circleImageView;
        this.lookAheadTest = textView;
        this.moveToNextValue = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView3;
        this.getErrorConfigVersion = textView4;
    }

    public static ItemCountryFormBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d02a9_networkuserentitydata_externalsyntheticlambda4, viewGroup, false);
        int i = R.id.clEditTextForm;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.cvExchangeRate;
            CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (cardView != null) {
                i = R.id.f5916reduceIndexedz1zDJgo;
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (imageView != null) {
                    i = R.id.SendMoneyScenario_res_0x7f0a098c;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (circleImageView != null) {
                        i = R.id.tvCountryName;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView != null) {
                            i = R.id.SubmitReceiptRequest;
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView2 != null) {
                                i = R.id.clearMerchantList;
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView3 != null) {
                                    i = R.id.EventLoopImplBase$DelayedRunnableTask;
                                    TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView4 != null) {
                                        return new ItemCountryFormBinding((ConstraintLayout) inflate, constraintLayout, cardView, imageView, circleImageView, textView, textView2, textView3, textView4);
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
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
