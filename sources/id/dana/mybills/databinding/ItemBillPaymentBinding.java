package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.mybills.R;

/* loaded from: classes5.dex */
public final class ItemBillPaymentBinding implements ViewBinding {
    public final DanaCheckboxButtonView BuiltInFictitiousFunctionClassFactory;
    public final TextView GetContactSyncConfig;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final CircleImageView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final CardView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final LinearLayoutCompat moveToNextValue;
    public final TextView scheduleImpl;

    private ItemBillPaymentBinding(CardView cardView, CircleImageView circleImageView, CircleImageView circleImageView2, ConstraintLayout constraintLayout, DanaCheckboxButtonView danaCheckboxButtonView, ImageView imageView, LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.getErrorConfigVersion = cardView;
        this.MyBillsEntityDataFactory = circleImageView;
        this.PlaceComponentResult = circleImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaCheckboxButtonView;
        this.getAuthRequestContext = imageView;
        this.moveToNextValue = linearLayoutCompat;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.scheduleImpl = textView3;
        this.GetContactSyncConfig = textView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view;
    }

    public static ItemBillPaymentBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.item_bill_payment, viewGroup, false);
        int i = R.id.getOnBoardingScenario;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.E;
            CircleImageView circleImageView2 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (circleImageView2 != null) {
                i = R.id.K;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (constraintLayout != null) {
                    i = R.id.isAuth;
                    DanaCheckboxButtonView danaCheckboxButtonView = (DanaCheckboxButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (danaCheckboxButtonView != null) {
                        i = R.id.p;
                        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (imageView != null) {
                            i = R.id.getContainerAuth_res_0x7f0a0d22;
                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (linearLayoutCompat != null) {
                                i = R.id.ConcurrentKt;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView != null) {
                                    i = R.id.WithdrawSavedCardChannelView;
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView2 != null) {
                                        i = R.id.TrackerKey$GlobalSearchOpenProperties;
                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (textView3 != null) {
                                            i = R.id.getExceptionOrNull;
                                            TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (textView4 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.access$getFeaturedBankListAdapter$p))) != null) {
                                                return new ItemBillPaymentBinding((CardView) inflate, circleImageView, circleImageView2, constraintLayout, danaCheckboxButtonView, imageView, linearLayoutCompat, textView, textView2, textView3, textView4, BuiltInFictitiousFunctionClassFactory);
                                            }
                                        }
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
        return this.getErrorConfigVersion;
    }
}
