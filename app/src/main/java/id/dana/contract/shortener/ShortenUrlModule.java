package id.dana.contract.shortener;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.shortener.ShortenUrlContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes8.dex */
public class ShortenUrlModule {
    private final ShortenUrlContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ShortenUrlContract.Presenter PlaceComponentResult(ShortenUrlPresenter shortenUrlPresenter) {
        return shortenUrlPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ShortenUrlContract.View getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
