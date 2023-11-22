package id.dana.richview.profile.paymentauth;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class PaymentAuthenticationView_ViewBinding implements Unbinder {
    private View MyBillsEntityDataFactory;
    private PaymentAuthenticationView getAuthRequestContext;

    public PaymentAuthenticationView_ViewBinding(final PaymentAuthenticationView paymentAuthenticationView, View view) {
        this.getAuthRequestContext = paymentAuthenticationView;
        paymentAuthenticationView.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        paymentAuthenticationView.switchButton = (SwitchCompat) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.switch_button, "field 'switchButton'", SwitchCompat.class);
        paymentAuthenticationView.tvSubtitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        paymentAuthenticationView.ivDanaProtection = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_dana_protection, "field 'ivDanaProtection'", ImageView.class);
        paymentAuthenticationView.clContainerPaymentAuth = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3679cl_payment_auth, "field 'clContainerPaymentAuth'", ConstraintLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3652cl_dana_protection, "method 'onClDanaProtectionClick'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.profile.paymentauth.PaymentAuthenticationView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                paymentAuthenticationView.onClDanaProtectionClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PaymentAuthenticationView paymentAuthenticationView = this.getAuthRequestContext;
        if (paymentAuthenticationView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        paymentAuthenticationView.tvTitle = null;
        paymentAuthenticationView.switchButton = null;
        paymentAuthenticationView.tvSubtitle = null;
        paymentAuthenticationView.ivDanaProtection = null;
        paymentAuthenticationView.clContainerPaymentAuth = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
