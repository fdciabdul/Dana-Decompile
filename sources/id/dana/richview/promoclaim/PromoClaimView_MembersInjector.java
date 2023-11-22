package id.dana.richview.promoclaim;

import dagger.MembersInjector;
import id.dana.richview.promoclaim.PromoClaimContract;

/* loaded from: classes9.dex */
public final class PromoClaimView_MembersInjector implements MembersInjector<PromoClaimView> {
    public static void MyBillsEntityDataFactory(PromoClaimView promoClaimView, PromoClaimContract.Presenter presenter) {
        promoClaimView.presenter = presenter;
    }
}
