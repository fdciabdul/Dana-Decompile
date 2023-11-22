package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class FragmentRequestMoneyAddBankCardBinding implements ViewBinding {
    public final Button BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final CardView scheduleImpl;

    private FragmentRequestMoneyAddBankCardBinding(CardView cardView, Button button, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2) {
        this.scheduleImpl = cardView;
        this.BuiltInFictitiousFunctionClassFactory = button;
        this.PlaceComponentResult = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.MyBillsEntityDataFactory = textView2;
    }

    public static FragmentRequestMoneyAddBankCardBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_request_money_add_bank_card, viewGroup, false);
        int i = R.id.btn_add_bank_account;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_add_bank_account);
        if (button != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_add_bank_account);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivBg);
                if (appCompatImageView2 != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_desc);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                        if (textView2 != null) {
                            return new FragmentRequestMoneyAddBankCardBinding((CardView) inflate, button, appCompatImageView, appCompatImageView2, textView, textView2);
                        }
                        i = R.id.tv_title;
                    } else {
                        i = R.id.tv_desc;
                    }
                } else {
                    i = R.id.ivBg;
                }
            } else {
                i = R.id.iv_add_bank_account;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
