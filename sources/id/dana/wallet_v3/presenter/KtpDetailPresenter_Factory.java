package id.dana.wallet_v3.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp;
import id.dana.wallet_v3.presenter.KtpDetailContract;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class KtpDetailPresenter_Factory implements Factory<KtpDetailPresenter> {
    private final Provider<GetKtpInfo> getKtpInfoProvider;
    private final Provider<SaveKtpConsultPopUp> saveKtpConsultPopUpProvider;
    private final Provider<KtpDetailContract.View> viewProvider;

    public KtpDetailPresenter_Factory(Provider<KtpDetailContract.View> provider, Provider<SaveKtpConsultPopUp> provider2, Provider<GetKtpInfo> provider3) {
        this.viewProvider = provider;
        this.saveKtpConsultPopUpProvider = provider2;
        this.getKtpInfoProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final KtpDetailPresenter get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.viewProvider), DoubleCheck.MyBillsEntityDataFactory(this.saveKtpConsultPopUpProvider), DoubleCheck.MyBillsEntityDataFactory(this.getKtpInfoProvider));
    }

    public static KtpDetailPresenter_Factory create(Provider<KtpDetailContract.View> provider, Provider<SaveKtpConsultPopUp> provider2, Provider<GetKtpInfo> provider3) {
        return new KtpDetailPresenter_Factory(provider, provider2, provider3);
    }

    public static KtpDetailPresenter newInstance(Lazy<KtpDetailContract.View> lazy, Lazy<SaveKtpConsultPopUp> lazy2, Lazy<GetKtpInfo> lazy3) {
        return new KtpDetailPresenter(lazy, lazy2, lazy3);
    }
}
