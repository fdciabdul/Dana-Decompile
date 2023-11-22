package id.dana.richview.donation;

import dagger.MembersInjector;
import id.dana.donation.DonationContract;

/* loaded from: classes9.dex */
public final class DonationView_MembersInjector implements MembersInjector<DonationView> {
    public static void getAuthRequestContext(DonationView donationView, DonationContract.Presenter presenter) {
        donationView.donatinPresenter = presenter;
    }
}
