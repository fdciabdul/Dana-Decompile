package id.dana.contract.payqr;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class OfflinePayModule {
    private final OfflinePayContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public OfflinePayContract.Presenter getAuthRequestContext(OfflinePayPresenter offlinePayPresenter) {
        return offlinePayPresenter;
    }

    public OfflinePayModule(OfflinePayContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public OfflinePayContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
