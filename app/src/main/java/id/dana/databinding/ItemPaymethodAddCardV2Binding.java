package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemPaymethodAddCardV2Binding implements ViewBinding {
    public final RadioButton BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ImageView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final TextView lookAheadTest;

    private ItemPaymethodAddCardV2Binding(ConstraintLayout constraintLayout, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, RadioButton radioButton, TextView textView, TextView textView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = imageView;
        this.getAuthRequestContext = imageView2;
        this.MyBillsEntityDataFactory = imageView3;
        this.BuiltInFictitiousFunctionClassFactory = radioButton;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
    }

    public static ItemPaymethodAddCardV2Binding MyBillsEntityDataFactory(View view) {
        int i = R.id.divider;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_cards_logo);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_dd_card_logo);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.SendMoneyHomePresenter);
                    if (imageView3 != null) {
                        RadioButton radioButton = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4091rb_selected_card);
                        if (radioButton != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddCard);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                                if (textView2 != null) {
                                    return new ItemPaymethodAddCardV2Binding((ConstraintLayout) view, BuiltInFictitiousFunctionClassFactory, imageView, imageView2, imageView3, radioButton, textView, textView2);
                                }
                                i = R.id.tv_title;
                            } else {
                                i = R.id.tvAddCard;
                            }
                        } else {
                            i = R.id.f4091rb_selected_card;
                        }
                    } else {
                        i = R.id.SendMoneyHomePresenter;
                    }
                } else {
                    i = R.id.iv_dd_card_logo;
                }
            } else {
                i = R.id.iv_cards_logo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
