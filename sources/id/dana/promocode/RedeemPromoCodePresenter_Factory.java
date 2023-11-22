package id.dana.promocode;

import dagger.internal.Factory;
import id.dana.domain.promocode.interactor.ApplyPromoCode;
import id.dana.promocode.RedeemPromoCodeContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RedeemPromoCodePresenter_Factory implements Factory<RedeemPromoCodePresenter> {
    private final Provider<ApplyPromoCode> MyBillsEntityDataFactory;
    private final Provider<RedeemPromoCodeContract.View> PlaceComponentResult;

    private RedeemPromoCodePresenter_Factory(Provider<RedeemPromoCodeContract.View> provider, Provider<ApplyPromoCode> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static RedeemPromoCodePresenter_Factory PlaceComponentResult(Provider<RedeemPromoCodeContract.View> provider, Provider<ApplyPromoCode> provider2) {
        return new RedeemPromoCodePresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RedeemPromoCodePresenter(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
