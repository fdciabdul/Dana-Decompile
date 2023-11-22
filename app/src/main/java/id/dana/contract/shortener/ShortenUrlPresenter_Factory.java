package id.dana.contract.shortener;

import dagger.internal.Factory;
import id.dana.contract.shortener.ShortenUrlContract;
import id.dana.domain.shortener.interactor.ShortenUrl;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ShortenUrlPresenter_Factory implements Factory<ShortenUrlPresenter> {
    private final Provider<ShortenUrl> MyBillsEntityDataFactory;
    private final Provider<ShortenUrlContract.View> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ShortenUrlPresenter(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
