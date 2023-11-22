package id.dana.myprofile.viewholder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationView;

/* loaded from: classes9.dex */
public class ProfileMenuPaymentAuthViewHolder_ViewBinding implements Unbinder {
    private ProfileMenuPaymentAuthViewHolder BuiltInFictitiousFunctionClassFactory;

    public ProfileMenuPaymentAuthViewHolder_ViewBinding(ProfileMenuPaymentAuthViewHolder profileMenuPaymentAuthViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = profileMenuPaymentAuthViewHolder;
        profileMenuPaymentAuthViewHolder.paymentAuthenticationView = (PaymentAuthenticationView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.TopUpAndPayModule_ProvideTopUpAndPayViewFactory, "field 'paymentAuthenticationView'", PaymentAuthenticationView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ProfileMenuPaymentAuthViewHolder profileMenuPaymentAuthViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (profileMenuPaymentAuthViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        profileMenuPaymentAuthViewHolder.paymentAuthenticationView = null;
    }
}
