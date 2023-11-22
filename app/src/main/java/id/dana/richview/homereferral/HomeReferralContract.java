package id.dana.richview.homereferral;

import id.dana.base.AbstractContract;
import id.dana.model.ReferralStatus;

/* loaded from: classes9.dex */
public interface HomeReferralContract {

    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult();
    }

    /* loaded from: classes9.dex */
    public interface View extends AbstractContract.AbstractView {
        void enableBanner(boolean z);

        void enableEntryPoint(boolean z);

        void onGetReferralStatusConsultSuccess(ReferralStatus referralStatus);

        void onLoadBanner(String str);

        void saveEntryPointUrl(String str);
    }
}
