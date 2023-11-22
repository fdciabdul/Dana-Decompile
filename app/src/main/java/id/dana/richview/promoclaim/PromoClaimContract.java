package id.dana.richview.promoclaim;

import id.dana.base.AbstractContract;

/* loaded from: classes9.dex */
public interface PromoClaimContract {

    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory();

        void PlaceComponentResult();
    }

    /* loaded from: classes9.dex */
    public interface View extends AbstractContract.AbstractView {
        void enableBanner(boolean z);

        void onLoadBanner(String str);
    }
}
